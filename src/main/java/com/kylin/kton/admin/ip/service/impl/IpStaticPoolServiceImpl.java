package com.kylin.kton.admin.ip.service.impl;

import com.kylin.kton.admin.account.mapper.AdminSourceDao;
import com.kylin.kton.admin.ip.entity.dto.AdminIpStaticPoolDTO;
import com.kylin.kton.admin.ip.entity.dto.AdminMerchantAvailableIpListDTO;
import com.kylin.kton.admin.ip.entity.dto.AdminMerchantInventoryIpsDTO;
import com.kylin.kton.admin.ip.entity.dto.AdminRegionalAvailableIpsDTO;
import com.kylin.kton.admin.ip.entity.vo.*;
import com.kylin.kton.admin.ip.mapper.AdminIpDetectDao;
import com.kylin.kton.admin.ip.mapper.AdminIpStaticPoolDao;
import com.kylin.kton.admin.ip.mapper.AdminStaticConfigPlanDao;
import com.kylin.kton.admin.ip.mapper.IpStaticPoolMapper;
import com.kylin.kton.admin.ip.mapper.IpStaticPoolSourceDao;
import com.kylin.kton.admin.ip.service.IpStaticPoolService;
import com.kylin.kton.admin.source.mapper.AdminIpSourceDao;
import com.kylin.kton.api.ipidea.entity.IpListResponse;
import com.kylin.kton.api.ipidea.properties.IpIdeaApiProperties;
import com.kylin.kton.api.ipidea.service.IpIdeaApiService;
import com.kylin.kton.api.ipnux.constant.ProxiesType;
import com.kylin.kton.api.ipnux.entity.NodeListResponse;
import com.kylin.kton.api.ipnux.service.IpNuxApiService;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.framework.config.ServerConfig;
import com.kylin.kton.system.domain.*;
import com.kylin.kton.system.mapper.KtonIpStaticPoolItemMapper;
import com.kylin.kton.system.service.impl.KtonIpStaticPoolServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class IpStaticPoolServiceImpl extends KtonIpStaticPoolServiceImpl implements IpStaticPoolService {

    @Autowired
    private IpNuxApiService ipNuxApiService;
    @Autowired
    private IpStaticPoolMapper ipStaticPoolMapper;
    @Autowired
    private IpIdeaApiService ipIdeaApiService;
    @Autowired
    private AdminIpDetectDao adminIpDetectDao;
    @Autowired
    private IpIdeaApiProperties ipIdeaApiProperties;
    @Autowired
    private AdminSourceDao adminSourceDao;
    @Autowired
    private AdminIpStaticPoolDao adminIpStaticPoolDao;
    @Autowired
    private KtonIpStaticPoolItemMapper ipStaticPoolItemMapper;
    @Autowired
    private IpStaticPoolSourceDao ipStaticPoolSourceDao;
    @Autowired
    private ServerConfig serverConfig;
    @Autowired
    private AdminIpSourceDao adminIpSourceDao;
    @Autowired
    private AdminStaticConfigPlanDao adminStaticConfigPlanDao;

    @Value("${source.conf.assignTimes}")
    private Integer assignTimes;

    @Override
    public List<AdminIpStaticPoolDTO> list(KtonIpStaticPool ktonIpStaticPool) {
        return this.adminIpStaticPoolDao.list(ktonIpStaticPool, this.assignTimes);
    }

    @Override
    @Transactional
    public AjaxResult ipNuxSync() {
        Long sourceId = this.adminIpSourceDao.getBySourceCode("ipnux").getId();
        List<String> ipList = Arrays.stream(ProxiesType.values())
                .map(item -> this.doIpNuxSync(item, sourceId))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(ipList)) {
            this.ipStaticPoolSourceDao.updateExpireIpList(ipList, sourceId);
            this.adminIpDetectDao.insertIpList(ipList);
        }
        return AjaxResult.success("同步完成");
    }

    private int addPoolItems(List<AdminImportIpItemVO> ipDTOs) {
        if (CollectionUtils.isEmpty(ipDTOs)) {
            return 0;
        }
        List<KtonIpStaticSource> poolItems = ipDTOs.stream()
                .map(this::convertToPoolItemWithSourceId)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        if (poolItems.isEmpty()) {
            return 0;
        }
        return this.ipStaticPoolSourceDao.batchSaveOrUpdate(poolItems);
    }

    private KtonIpStaticSource convertToPoolItemWithSourceId(AdminImportIpItemVO ipDTO) {
        if (ipDTO == null) {
            return null;
        }
        KtonIpStaticSource poolItem = new KtonIpStaticSource();
        BeanUtils.copyProperties(ipDTO, poolItem);
        String sourceCode = ipDTO.getSourceCode();
        if (!StringUtils.hasText(sourceCode)) {
            log.warn("转换IP池项时sourceCode为空，ipDTO: {}", ipDTO);
            return null;
        }
        Long sourceId = this.getSourceIdBySourceCode(sourceCode);
        poolItem.setSourceId(sourceId);
        return poolItem;
    }

    private Long getSourceIdBySourceCode(String sourceCode) {
        KtonSource source = this.adminSourceDao.detailBySourceCode(sourceCode);
        return source.getId();
    }

    private KtonIpStaticSource convertToPoolItem(AdminImportIpItemVO ipDTO) {
        if (ipDTO == null) {
            return null;
        }
        KtonIpStaticSource poolItem = new KtonIpStaticSource();
        BeanUtils.copyProperties(ipDTO, poolItem);
        return poolItem;
    }

    @Override
    public AjaxResult ipIdeaSync() {
        Long sourceId = this.adminIpSourceDao.getBySourceCode("ipidea").getId();
        List<String> ipList1 = this.getIpIdeaIpList(1, sourceId, 1);
        List<String> ipList2 = this.getIpIdeaIpList(2, sourceId, 1);
        List<String> ipList = Stream.of(ipList1, ipList2)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(ipList)) {
            this.ipStaticPoolSourceDao.updateExpireIpList(ipList, sourceId);
            this.adminIpDetectDao.insertIpList(ipList);
        }
        return AjaxResult.success("账号1 同步完成 同步数量：" + ipList.size());
    }

    @Override
    public AjaxResult ipIdeaSync2() {
        Long sourceId = this.adminIpSourceDao.getBySourceCode("ipidea2").getId();
        List<String> ipList1 = this.getIpIdeaIpList(1, sourceId, 2);
        List<String> ipList2 = this.getIpIdeaIpList(2, sourceId, 2);
        List<String> ipList = Stream.of(ipList1, ipList2)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(ipList)) {
            this.ipStaticPoolSourceDao.updateExpireIpList(ipList, sourceId);
            this.adminIpDetectDao.insertIpList(ipList);
        }
        return AjaxResult.success("账号2 同步完成 同步数量：" + ipList.size());
    }

    private List<String> getIpIdeaIpList(Integer type, Long sourceId, Integer accountType) {
        int currentPage = 1;
        int lastPage = 999;
        List<KtonIpStaticSource> ktonIpStaticSourceList = new ArrayList<>();

        while (currentPage <= lastPage) {
            IpListResponse ipListResponse = null;
            if (type == 1) {
                ipListResponse = this.ipIdeaApiService.getDataCenterIpList(currentPage, 1000, accountType);
            } else if (type == 2) {
                ipListResponse = this.ipIdeaApiService.getIspIpList(currentPage, 1000, accountType);
            }

            if (ipListResponse == null || ipListResponse.getRetData() == null) {
                break;
            }

            String account = this.getAccountByAccountType(accountType);
            String password = this.getPasswordByAccountType(accountType);

            List<KtonIpStaticSource> resultList = ipListResponse.getRetData().getData().stream().map(item -> {
                KtonIpStaticSource source = new KtonIpStaticSource();
                source.setAccount(account);
                source.setPassword(password);
                source.setPort("2340");
                source.setIp(item.getIp());
                source.setEffectiveDatetime(Date.from(Instant.ofEpochSecond(item.getAddTime())));
                source.setExpireDatetime(Date.from(Instant.ofEpochSecond(item.getExpireTime())));
                return source;
            }).collect(Collectors.toList());

            ktonIpStaticSourceList.addAll(resultList);
            lastPage = ipListResponse.getRetData().getLastPage();
            currentPage++;

            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

            if (resultList.isEmpty()) {
                break;
            }
            this.ipStaticPoolMapper.batchSaveOrUpdateSource(resultList, sourceId);
        }
        return ktonIpStaticSourceList.stream().map(KtonIpStaticSource::getIp).collect(Collectors.toList());
    }

    private String getAccountByAccountType(Integer accountType) {
        switch (accountType) {
            case 1:
                return this.ipIdeaApiProperties.getAccount1();
            case 2:
                return this.ipIdeaApiProperties.getAccount2();
            default:
                throw new IllegalArgumentException("不支持的账号: " + accountType);
        }
    }

    private String getPasswordByAccountType(Integer accountType) {
        switch (accountType) {
            case 1:
                return this.ipIdeaApiProperties.getPassword1();
            case 2:
                return this.ipIdeaApiProperties.getPassword2();
            default:
                throw new IllegalArgumentException("不支持的账号: " + accountType);
        }
    }

    private List<String> doIpNuxSync(ProxiesType proxiesType, Long sourceId) {
        NodeListResponse nodeListResponse = this.ipNuxApiService.listNode(proxiesType);
        if (Objects.isNull(nodeListResponse) || !nodeListResponse.isSuccess()) {
            return new ArrayList<>();
        }

        // 泛型修复
        List<NodeListResponse.Result> results = Optional.ofNullable(nodeListResponse.getData())
                .map(NodeListResponse.NodeData::getResults)
                .orElse(Collections.emptyList());

        // 处理时间
        results.forEach(item -> {
            item.setExpiredAt(item.getExpiredAt().plusHours(8L));
            item.setCreatedAt(item.getCreatedAt().plusHours(8L));
        });

        // 映射转换
        List<KtonIpStaticSource> list = results.stream().map(item -> {
            KtonIpStaticSource source = new KtonIpStaticSource();
            source.setAccount(item.getUserName());
            source.setPassword(item.getPassword());
            source.setPort(String.valueOf(item.getPort()));
            source.setIp(item.getProxyAddress());
            source.setEffectiveDatetime(Date.from(item.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant()));
            source.setExpireDatetime(Date.from(item.getExpiredAt().atZone(ZoneId.systemDefault()).toInstant()));
            return source;
        }).collect(Collectors.toList());

        int totalItem = this.ipStaticPoolMapper.batchSaveOrUpdateSource(list, sourceId);
        log.info("insert or update total item = {}", totalItem);

        return results.stream()
                .map(NodeListResponse.Result::getProxyAddress)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdminRegionalAvailableIpsDTO> regionalAvailableIps(AdminRegionalAvailableIpsVO vo) {
        Integer assignTimesParam = this.assignTimes;
        Long isExclusive = vo.getIsExclusive();
        if (isExclusive != null && isExclusive == 1L) {
            assignTimesParam = 0;
        }
        List<AdminRegionalAvailableIpsDTO> list = this.ipStaticPoolSourceDao.regionalAvailableIps(vo, assignTimesParam);

        Iterator<AdminRegionalAvailableIpsDTO> iterator = list.iterator();
        while (iterator.hasNext()) {
            AdminRegionalAvailableIpsDTO dto = iterator.next();
            KtonIpStaticConfigPlan configPlan = this.adminStaticConfigPlanDao.selectConfigPlanPrice(dto.getCountryCode(), dto.getType(), vo.getMerchantId(), isExclusive);
            if (configPlan != null) {
                dto.setPrice(configPlan.getPrice());
            } else {
                iterator.remove();
            }
        }
        return list;
    }

    @Override
    public List<AdminMerchantAvailableIpListDTO> merchantAvailableIpList(MerchantAvailableIpListVO vo) {
        Integer assignTimesParam = this.assignTimes;
        Long isExclusive = vo.getIsExclusive();
        if (isExclusive != null && isExclusive == 1L) {
            assignTimesParam = 0;
        }
        return this.ipStaticPoolMapper.getMerchantAvailableIpList(vo, assignTimesParam);
    }

    @Override
    public List<AdminMerchantInventoryIpsDTO> merchantInventoryIps(AdminMerchantInventoryIpsVO vo) {
        Integer assignTimesParam = this.assignTimes;
        Long isExclusive = vo.getIsExclusive();
        if (isExclusive != null && isExclusive == 1L) {
            assignTimesParam = 0;
        }
        List<AdminMerchantInventoryIpsDTO> list = this.ipStaticPoolMapper.merchantInventoryIps(vo, assignTimesParam);

        Iterator<AdminMerchantInventoryIpsDTO> iterator = list.iterator();
        while (iterator.hasNext()) {
            AdminMerchantInventoryIpsDTO dto = iterator.next();
            List<KtonIpStaticConfigPlan> configPlans = this.adminStaticConfigPlanDao.selectConfigPlans(dto.getCountryCode(), dto.getType(), vo.getMerchantId(), isExclusive);
            dto.setConfigPlans(configPlans);
            if (configPlans == null || configPlans.isEmpty()) {
                iterator.remove();
            }
        }
        return list;
    }
}