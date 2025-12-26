package com.kylin.kton.admin.ip.service.impl;

import com.kylin.kton.admin.ip.entity.dto.AdminIpStaticSourceDTO;
import com.kylin.kton.admin.ip.entity.dto.AdminPoolIpCount;
import com.kylin.kton.admin.ip.entity.vo.*;
import com.kylin.kton.admin.ip.mapper.AdminIpDetectDao;
import com.kylin.kton.admin.ip.mapper.AdminIpStaticPoolDao;
import com.kylin.kton.admin.ip.mapper.AdminIpStaticPoolItemDao;
import com.kylin.kton.admin.ip.mapper.AdminIpStaticSourceDao;
import com.kylin.kton.admin.ip.mapper.IpStaticPoolMapper;
import com.kylin.kton.admin.ip.mapper.IpStaticPoolSourceDao;
import com.kylin.kton.admin.ip.service.IpStaticSourceService;
import com.kylin.kton.admin.tasks.mapper.IpDetectMapper;
import com.kylin.kton.admin.tasks.mapper.SysDictDataDao;
import com.kylin.kton.common.constant.IpDetectConstants;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.domain.entity.SysDictData;
import com.kylin.kton.common.utils.ipInfo.Ping0Utils;
import com.kylin.kton.system.domain.KtonIpDetect;
import com.kylin.kton.system.domain.KtonIpStaticSource;
import com.kylin.kton.system.domain.KtonSource;
import com.kylin.kton.system.mapper.KtonIpStaticPoolItemMapper;
import com.kylin.kton.system.service.impl.KtonIpStaticSourceServiceImpl;
import lombok.Generated;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
public class IpStaticSourceServiceImpl extends KtonIpStaticSourceServiceImpl implements IpStaticSourceService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(IpStaticSourceServiceImpl.class);

    @Autowired
    private AdminIpStaticSourceDao adminIpStaticSourceDao;
    @Autowired
    private IpStaticPoolMapper ipStaticPoolMapper;
    @Autowired
    AdminIpStaticPoolDao adminIpStaticPoolDao;
    @Autowired
    KtonIpStaticPoolItemMapper ipStaticPoolItemMapper;
    @Autowired
    AdminIpStaticPoolItemDao adminIpStaticPoolItemDao;
    @Autowired
    AdminIpDetectDao adminIpDetectDao;
    @Resource
    IpDetectMapper ipDetectMapper;
    @Resource
    SysDictDataDao sysDictDataDao;
    @Autowired
    IpStaticPoolSourceDao ipStaticPoolSourceDao;

    @Value("${source.conf.assignTimes}")
    Integer assignTimes;

    @Resource
    private Ping0Utils ping0Utils;

    @Override
    public List<AdminIpStaticSourceDTO> list(AdminIpStaticSourceSearchVO searchVO) {
        return this.adminIpStaticSourceDao.list(searchVO);
    }

    @Override
    public List<AdminIpStaticSourceDTO> withOutPoolList(AdminWithOutPoolSearchVO searchVO) {
        return this.adminIpStaticSourceDao.withOutPoolList(searchVO);
    }

    @Override
    public AjaxResult importIpExcel(MultipartFile file) {
        try {
            List<AdminImportIpItemVO> ipList = this.parseExcel(file);
            int totalItems = this.addPoolItems(ipList);
            log.info("成功导入 {} 条IP数据", totalItems);
            return AjaxResult.success("导入成功", totalItems);
        } catch (IllegalArgumentException e) {
            log.error("导入失败：{}", e.getMessage());
            return AjaxResult.error("导入失败：" + e.getMessage());
        } catch (Exception e) {
            log.error("导入异常", e);
            return AjaxResult.error("系统异常，请联系管理员");
        }
    }

    public List<AdminImportIpItemVO> parseExcel(MultipartFile file) throws IOException {
        List<AdminImportIpItemVO> ipDataList = new ArrayList<>();
        try (InputStream inputStream = file.getInputStream();
             XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheetAt(0);
            int totalRows = sheet.getLastRowNum();
            if (totalRows <= 0) {
                throw new IllegalArgumentException("Excel文件中没有数据");
            }

            for (int i = 1; i <= totalRows; ++i) {
                Row row = sheet.getRow(i);
                if (row == null) continue;
                AdminImportIpItemVO ipDTO = this.parseRow(row);
                if (this.isValidIpItem(ipDTO)) {
                    ipDataList.add(ipDTO);
                } else {
                    log.warn("第 {} 行数据验证失败: {}", (i + 1), ipDTO);
                }
            }

            if (ipDataList.isEmpty()) {
                throw new IllegalArgumentException("Excel文件中没有有效数据");
            }
            return ipDataList;
        }
    }

    private AdminImportIpItemVO parseRow(Row row) {
        AdminImportIpItemVO ipDTO = new AdminImportIpItemVO();
        this.setStringValue(row, 0, ipDTO::setIp);
        this.setStringValue(row, 1, ipDTO::setPort);
        this.setStringValue(row, 2, ipDTO::setAccount);
        this.setStringValue(row, 3, ipDTO::setPassword);
        this.setDateTimeValue(row, 4, ipDTO::setExpireDatetime);
        this.setDateTimeValue(row, 5, ipDTO::setEffectiveDatetime);
        this.setStringValue(row, 6, ipDTO::setSourceCode);
        return ipDTO;
    }

    private void setStringValue(Row row, int cellIndex, Consumer<String> setter) {
        Cell cell = row.getCell(cellIndex);
        if (cell != null) {
            cell.setCellType(CellType.STRING);
            setter.accept(cell.getStringCellValue());
        }
    }

    private void setDateTimeValue(Row row, int cellIndex, Consumer<Date> setter) {
        Cell cell = row.getCell(cellIndex);
        if (cell != null && cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
            LocalDateTime localDateTime = cell.getLocalDateTimeCellValue();
            if (localDateTime != null) {
                Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
                setter.accept(date);
            }
        }
    }

    private boolean isValidIpItem(AdminImportIpItemVO item) {
        return StringUtils.hasText(item.getIp()) && StringUtils.hasText(item.getPort());
    }

    @Override
    public Integer importIpSource(AdminImportIpSourceVO importIpSourceVO) {
        return this.addPoolItems(importIpSourceVO.getIps());
    }

    @Override
    @Transactional
    public int putOnIpSource(PutOnIpSourceVO putOnIpSourceVO) {
        List<String> ipList = new ArrayList<>();
        Integer specifyIpSwitch = putOnIpSourceVO.getSpecifyIpSwitch();
        if ((specifyIpSwitch != null && (1 == specifyIpSwitch || 2 == specifyIpSwitch)) && putOnIpSourceVO.getIpListStr() != null) {
            ipList = Arrays.asList(putOnIpSourceVO.getIpListStr().split(","));
        }

        if (!this.isIpQuantitySufficient(putOnIpSourceVO.getPoolId(), putOnIpSourceVO.getQuantity(), specifyIpSwitch, ipList, putOnIpSourceVO.getMerchantIds())) {
            throw new RuntimeException("指定IP可用数量不足");
        }

        this.adminIpStaticPoolItemDao.createTempTable();
        this.adminIpStaticPoolItemDao.insertIntoTempTable(putOnIpSourceVO.getPoolId(), putOnIpSourceVO.getQuantity(), specifyIpSwitch, ipList, putOnIpSourceVO.getMerchantIds(), this.assignTimes);

        int updateCount = 0;
        for (Long merchantId : putOnIpSourceVO.getMerchantIds()) {
            updateCount += this.adminIpStaticPoolItemDao.insertSingleMerchant(merchantId);
        }

        this.adminIpStaticPoolItemDao.dropTempTable();
        log.info("插入记录，更新{}条状态", updateCount);
        return updateCount;
    }

    @Override
    public void putOffIpSource(AdminPutOffIpSourceVO putOffIpSourceVO) {
        List<Long> merchantIds = putOffIpSourceVO.getMerchantIds();
        for (Long merchantId : merchantIds) {
            Long poolId = putOffIpSourceVO.getPoolId();
            Integer specifyIpSwitch = putOffIpSourceVO.getSpecifyIpSwitch();
            List<String> ipList = new ArrayList<>();
            if (specifyIpSwitch != null && (1 == specifyIpSwitch || 2 == specifyIpSwitch) && putOffIpSourceVO.getIpListStr() != null) {
                ipList = Arrays.asList(putOffIpSourceVO.getIpListStr().split(","));
            }
            this.adminIpStaticPoolItemDao.deleteIpByCondition(merchantId, poolId, specifyIpSwitch, ipList);
        }
    }

    @Override
    public Integer addByIpPattern(AdminAddByIpPatternVO addByIpPatternVO) {
        KtonIpStaticSource template = new KtonIpStaticSource();
        BeanUtils.copyProperties(addByIpPatternVO, template);
        Date now = new Date();
        template.setCreateTime(now);
        String ipPattern = addByIpPatternVO.getIpPattern();
        String[] parts = ipPattern.split("\\.");
        if (parts.length < 3) {
            throw new IllegalArgumentException("IP模式格式错误，至少需要三个段");
        }
        for (int i = 0; i < 3; ++i) {
            try {
                int value = Integer.parseInt(parts[i]);
                if (value < 0 || value > 255) {
                    throw new IllegalArgumentException("IP段必须在0到255之间");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("IP段必须为有效的数字");
            }
        }
        String ipBase = String.join(".", Arrays.copyOfRange(parts, 0, 3));
        List<KtonIpStaticSource> ipList = new ArrayList<>(253);
        for (int i = 2; i <= 254; ++i) {
            KtonIpStaticSource source = new KtonIpStaticSource();
            BeanUtils.copyProperties(template, source);
            source.setIp(ipBase + "." + i);
            if (source.getExpireDatetime() == null) {
                LocalDateTime defaultExpire = LocalDateTime.of(9999, 12, 31, 0, 0, 0);
                Date date = Date.from(defaultExpire.atZone(ZoneId.systemDefault()).toInstant());
                source.setExpireDatetime(date);
            }
            ipList.add(source);
        }
        return this.adminIpStaticSourceDao.batchInsertKtonIpStaticSources(ipList);
    }

    public boolean isIpQuantitySufficient(Long poolId, Integer quantity, Integer specifyIpSwitch, List<String> ipList, List<Long> merchantIds) {
        if (quantity == null || quantity <= 0) {
            return false;
        }
        List<AdminPoolIpCount> poolIpCounts = this.adminIpStaticPoolItemDao.checkAvailableIpCount(poolId, specifyIpSwitch, ipList, merchantIds, this.assignTimes);
        if (poolId != null) {
            return poolIpCounts.stream().anyMatch(pic -> pic.getPoolId().equals(poolId) && pic.getIpCount() >= quantity);
        }
        return !poolIpCounts.isEmpty() && poolIpCounts.stream().allMatch(pic -> pic.getIpCount() >= quantity);
    }

    private int addPoolItems(List<AdminImportIpItemVO> ipDTOs) {
        if (CollectionUtils.isEmpty(ipDTOs)) {
            log.warn("Input IP list is empty");
            return 0;
        }
        int totalProcessed = 0;
        List<KtonIpStaticSource> sourcesToAdd = new ArrayList<>(ipDTOs.size());
        List<KtonIpDetect> ipDetectsToAdd = new ArrayList<>(ipDTOs.size());
        Map<String, KtonSource> sourceCache = new HashMap<>();

        for (AdminImportIpItemVO ipDTO : ipDTOs) {
            if (sourceCache.containsKey(ipDTO.getSourceCode())) continue;
            KtonSource source = this.adminIpStaticSourceDao.getBySourceCode(ipDTO.getSourceCode());
            if (source == null) {
                log.error("Source not found for code: {}", ipDTO.getSourceCode());
                continue;
            }
            sourceCache.put(ipDTO.getSourceCode(), source);
        }

        for (AdminImportIpItemVO ipDTO : ipDTOs) {
            KtonSource source = sourceCache.get(ipDTO.getSourceCode());
            if (source == null) continue;

            KtonIpStaticSource poolItemSource = new KtonIpStaticSource();
            BeanUtils.copyProperties(ipDTO, poolItemSource);
            poolItemSource.setPort(ipDTO.getPort());
            poolItemSource.setSourceId(source.getId());
            sourcesToAdd.add(poolItemSource);

            KtonIpDetect ipDetect = new KtonIpDetect();
            ipDetect.setIp(ipDTO.getIp());
            ipDetect.setDatasource(IpDetectConstants.DATASOURCE.ping0.name());
            ipDetectsToAdd.add(ipDetect);
        }

        if (!sourcesToAdd.isEmpty()) {
            int batchResult = this.ipStaticPoolSourceDao.batchSaveOrUpdate(sourcesToAdd);
            totalProcessed += batchResult;
            log.info("Batch processed {} IP static sources", batchResult);
        }
        if (!ipDetectsToAdd.isEmpty()) {
            int detectResult = this.adminIpDetectDao.batchInsertOrUpdateIp(ipDetectsToAdd);
            totalProcessed += detectResult;
            log.info("Batch processed {} IP detect records", detectResult);
        }
        return totalProcessed;
    }

    private void updateIpDataByPing0() {
        log.info("开始同步IP基础数据 ping0...");
        int totalCount = this.ipDetectMapper.selectTotalCount(IpDetectConstants.DATASOURCE.ping0.name());
        log.info("待处理IP总数: {}", totalCount);
        // 修复：添加泛型
        List<String> ipList = this.ipDetectMapper.selectIpGroupList(IpDetectConstants.DATASOURCE.ping0.name());
        log.info("待处理IP段数: {}", ipList.size());

        ipList.forEach(ip -> {
            Ping0Utils.IPGeoInfo geoInfo = Ping0Utils.getIPGeoInfo(ip);
            KtonIpDetect ipDetect = new KtonIpDetect();
            ipDetect.setIp(ip);
            if (!"未知国家".equals(geoInfo.getCountryCode())) {
                this.updateIpDetectWithGeoInfo(ipDetect, geoInfo, IpDetectConstants.DATASOURCE.ping0.name());
                this.ipDetectMapper.updateByIpGroup(ipDetect);
                log.debug("IP段 {} 数据更新成功", ipDetect.getIp());
            }
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        log.info("同步IP基础数据 ping0...完成");
    }

    private void updateIpDetectWithGeoInfo(KtonIpDetect ipDetect, Ping0Utils.IPGeoInfo geoInfo, String dateSource) {
        // 修复：添加泛型
        List<SysDictData> sysDictDataList = this.sysDictDataDao.selectLocationDict();
        // 修复：collect 泛型推断
        Map<String, String> locationMap = sysDictDataList.stream()
                .collect(Collectors.toMap(SysDictData::getDictLabel, SysDictData::getDictValue, (i1, i2) -> i2));

        ipDetect.setDatasource(dateSource);
        ipDetect.setCountryCode(Optional.ofNullable(locationMap.get(geoInfo.getCountryCode())).orElse(geoInfo.getCountryCode()));
        ipDetect.setProvince(Optional.ofNullable(locationMap.get(geoInfo.getProvince())).orElse(geoInfo.getProvince()));
        ipDetect.setCity(Optional.ofNullable(locationMap.get(geoInfo.getCity())).orElse(geoInfo.getCity()));

        ipDetect.setAsn(geoInfo.getAsn());
        ipDetect.setAsnBelong(geoInfo.getAsnBelong());
        ipDetect.setAsnBelongUrl(geoInfo.getAsnBelongUrl());
        ipDetect.setAsnIsIsp(geoInfo.getAsnIsIsp());
        ipDetect.setCompany(geoInfo.getCompany());
        ipDetect.setCompanyUrl(geoInfo.getCompanyUrl());
        ipDetect.setCompanyIsIsp(geoInfo.getCompanyIsIsp());
        ipDetect.setLatitude(geoInfo.getLatitude());
        ipDetect.setLongitude(geoInfo.getLongitude());
        ipDetect.setIpType(geoInfo.getIpType());
        ipDetect.setRiskValue(geoInfo.getRiskValue());
        ipDetect.setIsNative(geoInfo.getIsNative());
        ipDetect.setUpdateTime(new Date());
    }
}