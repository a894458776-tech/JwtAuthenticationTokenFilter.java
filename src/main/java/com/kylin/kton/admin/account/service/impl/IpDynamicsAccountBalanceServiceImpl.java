package com.kylin.kton.admin.account.service.impl;

import com.kylin.kton.admin.account.entity.dto.BanlanceResponseInfoDTO;
import com.kylin.kton.admin.account.entity.vo.AccountBalanceSearchVO;
import com.kylin.kton.admin.account.entity.vo.BalanceAddVO;
import com.kylin.kton.admin.account.mapper.AdminAccountBalanceDao;
import com.kylin.kton.admin.account.mapper.AdminAccountDao;
import com.kylin.kton.admin.account.service.IpDynamicsAccountBalanceService;
import com.kylin.kton.admin.merchant.base.entity.dto.AdminMrtchantIpSourceDTO;
import com.kylin.kton.admin.merchant.base.mapper.AdminMerchantSourceDao;
import com.kylin.kton.api.dataimpulse.entity.subuser.AddSubUserBalanceResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.QuerySubUserBalanceResponse;
import com.kylin.kton.api.dataimpulse.service.DataImpulseSubUserApiService;
import com.kylin.kton.api.netnut.entity.subuser.AllocateGBRequest;
import com.kylin.kton.api.netnut.entity.subuser.AllocateGBResponse;
import com.kylin.kton.api.netnut.entity.subuser.CustomerPlansData;
import com.kylin.kton.api.netnut.entity.subuser.CustomerPlansRequest;
import com.kylin.kton.api.netnut.entity.subuser.CustomerPlansResponse;
import com.kylin.kton.api.netnut.service.NetnutSubUserApiService;
import com.kylin.kton.api.oxylabs.entity.subuser.SubUserResponse;
import com.kylin.kton.api.oxylabs.entity.subuser.SubUserResponseItem;
import com.kylin.kton.api.oxylabs.entity.subuser.UpdateSubUserRequest;
import com.kylin.kton.api.oxylabs.service.OxylabsSubUserApiService;
import com.kylin.kton.common.constant.IpSourceConstants;
import com.kylin.kton.common.constant.MerchantIpSourceConstants;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.utils.WeChatWebhookUtil;
import com.kylin.kton.common.utils.bean.BeanUtils;
import com.kylin.kton.system.domain.KtonIpDynamicsAccount;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountBalance;
import com.kylin.kton.system.domain.KtonIpDynamicsPlan;
import com.kylin.kton.system.domain.KtonMerchant;
import com.kylin.kton.system.mapper.KtonIpDynamicsAccountBalanceMapper;
import com.kylin.kton.system.mapper.KtonIpDynamicsAccountMapper;
import com.kylin.kton.system.mapper.KtonIpDynamicsPlanMapper;
import com.kylin.kton.system.mapper.KtonMerchantMapper;
import com.kylin.kton.system.service.impl.KtonIpDynamicsAccountBalanceServiceImpl;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class IpDynamicsAccountBalanceServiceImpl extends KtonIpDynamicsAccountBalanceServiceImpl implements IpDynamicsAccountBalanceService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(IpDynamicsAccountBalanceServiceImpl.class);
    @Autowired
    KtonIpDynamicsAccountBalanceMapper balanceMapper;
    @Autowired
    KtonMerchantMapper merchantMapper;
    @Autowired
    KtonIpDynamicsAccountMapper accountMapper;
    @Autowired
    DataImpulseSubUserApiService dataimpulseSubUserApiService;
    @Autowired
    private NetnutSubUserApiService netnutSubUserApiService;
    @Autowired
    OxylabsSubUserApiService oxylabsSubUserApiService;
    @Autowired
    AdminAccountDao adminAccountDao;
    @Autowired
    AdminMerchantSourceDao merchantSourceDao;
    @Autowired
    KtonIpDynamicsPlanMapper planMapper;
    @Autowired
    AdminAccountBalanceDao adminAccountBalanceDao;

    @Override
    public void listUnupdatedAccounts() {
        Integer minute = 30;
        List<KtonIpDynamicsAccountBalance> balances = this.adminAccountBalanceDao.pendingList(minute);
        for (KtonIpDynamicsAccountBalance balance : balances) {
            try {
                this.distributeBanlanceUpdateRequset(balance.getMerchantId(), balance.getAccountId());
            } catch (ArithmeticException e) {
                log.info("queryBalance  failed: " + e.getMessage());
            }
        }
    }

    @Override
    public List<KtonIpDynamicsAccountBalance> list(AccountBalanceSearchVO searchVO) {
        Long merchantId = searchVO.getMerchantId();
        Long accountId = searchVO.getAccountId();
        try {
            this.distributeBanlanceUpdateRequset(merchantId, accountId);
        } catch (ArithmeticException e) {
            log.info("queryBalance  failed: " + e.getMessage());
        }
        KtonIpDynamicsAccountBalance entity = new KtonIpDynamicsAccountBalance();
        entity.setMerchantId(merchantId);
        entity.setAccountId(accountId);
        // 【修复】泛型
        return this.balanceMapper.selectKtonIpDynamicsAccountBalanceList(entity);
    }

    private void distributeBanlanceUpdateRequset(Long merchantId, Long accountId) {
        AdminMrtchantIpSourceDTO sourceDTO = this.merchantSourceDao.merchantSource(merchantId, MerchantIpSourceConstants.IP_TYPE.dynamics.name());
        String sourceCode = IpSourceConstants.SOURCE_CODE.dataimpulse.name();
        if (sourceDTO != null) {
            sourceCode = sourceDTO.getSourceCode();
        }
        if (sourceCode.equals(IpSourceConstants.SOURCE_CODE.dataimpulse.name())) {
            this.updateDataimpulseBanlanceInfo(merchantId, accountId);
        }
        if (sourceCode.equals(IpSourceConstants.SOURCE_CODE.netnut.name())) {
            this.updateNetnutBanlanceInfo(merchantId, accountId);
        }
        if (sourceCode.equals(IpSourceConstants.SOURCE_CODE.oxylabs.name())) {
            this.updateOxylabsBanlanceInfo(accountId);
        }
    }

    private void updateDataimpulseBanlanceInfo(Long merchantId, Long accountId) {
        if (accountId == null) {
            log.info("accountId is null");
        }
        QuerySubUserBalanceResponse balanceResponse = this.dataimpulseSubUserApiService.queryBalance(accountId);
        log.info("balanceResponse = {}", balanceResponse);
        if (balanceResponse == null) {
            return;
        }
        BanlanceResponseInfoDTO infoDTO = new BanlanceResponseInfoDTO();
        BeanUtils.copyProperties(balanceResponse, infoDTO);
        this.addBanlanceInfo(merchantId, accountId, infoDTO);
    }

    private void updateNetnutBanlanceInfo(Long merchantId, Long accountId) {
        try {
            CustomerPlansRequest customerPlansRequest = new CustomerPlansRequest();
            CustomerPlansResponse customerPlansResponse = this.netnutSubUserApiService.getCustomerPlans(accountId.toString(), customerPlansRequest);
            BanlanceResponseInfoDTO infoDTO = new BanlanceResponseInfoDTO();
            if (customerPlansResponse.getData() != null) {
                // 【修复】泛型
                List<CustomerPlansData> plansData = customerPlansResponse.getData();
                if (plansData.size() > 0) {
                    infoDTO = this.calcBalanceData(plansData);
                }
                this.addBanlanceInfo(merchantId, accountId, infoDTO);
            }
        } catch (ArithmeticException e) {
            log.info("queryBalance  failed: " + e.getMessage());
        }
    }

    private BanlanceResponseInfoDTO calcBalanceData(List<CustomerPlansData> plansData) {
        BanlanceResponseInfoDTO infoDTO = new BanlanceResponseInfoDTO();
        BigDecimal balanceTotal = BigDecimal.ZERO;
        BigDecimal balanceUsed = BigDecimal.ZERO;
        for (CustomerPlansData plan : plansData) {
            if (plan.getIsActive()) {
                balanceTotal = balanceTotal.add(new BigDecimal(plan.getPlanGb()));
                balanceUsed = balanceUsed.add(new BigDecimal(plan.getTotalGBUsed()));
            }
        }
        BigDecimal banlance = balanceTotal.subtract(balanceUsed);
        infoDTO.setBalanceTotal(balanceTotal);
        infoDTO.setBalanceTotalFormat(balanceTotal + "GB");
        infoDTO.setBalanceUsed(balanceUsed);
        infoDTO.setBalanceUsedFormat(balanceUsed + "GB");
        infoDTO.setBalance(banlance);
        infoDTO.setBalanceFormat(banlance + "GB");
        infoDTO.setThreadsUsed("0");
        return infoDTO;
    }

    private void updateOxylabsBanlanceInfo(Long accountId) {
        // 【修复】泛型和强制转换
        List<SubUserResponseItem> items = this.oxylabsSubUserApiService.getSubUsers();
        BanlanceResponseInfoDTO infoDTO = new BanlanceResponseInfoDTO();
        for (SubUserResponseItem item : items) {
            if (item.getId().intValue() != accountId.intValue()) continue;
            BigDecimal balanceTotal = BigDecimal.ZERO;
            BigDecimal balanceUsed = BigDecimal.ZERO;

            if (item.getTrafficLimit() != null) {
                balanceTotal = new BigDecimal(item.getTrafficLimit());
            }
            if (item.getTraffic() != null) {
                balanceUsed = new BigDecimal(item.getTraffic());
            }
            BigDecimal banlance = balanceTotal.subtract(balanceUsed);
            infoDTO.setBalanceTotal(balanceTotal);
            infoDTO.setBalanceTotalFormat(balanceTotal + "GB");
            infoDTO.setBalanceUsed(balanceUsed);
            infoDTO.setBalanceUsedFormat(balanceUsed + "GB");
            infoDTO.setBalanceFormat(banlance + "GB");
            infoDTO.setBalance(banlance);
            infoDTO.setBalanceFormat(banlance + "GB");
            infoDTO.setThreadsUsed("0");
        }
    }

    @Override
    public AjaxResult addBalance(BalanceAddVO addVO) {
        log.info("addBalance request params = ：{}", addVO);
        Long accountId = addVO.getAccountId();
        Long merchantId = addVO.getMerchantId();
        BigDecimal trafficLimit = addVO.getTrafficLimit();
        long traffic = 0L;
        try {
            traffic = trafficLimit.longValueExact();
        } catch (ArithmeticException e) {
            log.info("Conversion to long failed: " + e.getMessage());
        }

        this.distributionRequest(addVO);
        this.addSubAccountBalance(merchantId, accountId, trafficLimit);
        this.cutMerchantBalance(merchantId, trafficLimit);

        return AjaxResult.success();
    }

    private Boolean distributionRequest(BalanceAddVO addVO) {
        Long accountId = addVO.getAccountId();
        BigDecimal trafficLimit = addVO.getTrafficLimit();
        Long merchantId = addVO.getMerchantId();
        AdminMrtchantIpSourceDTO sourceDTO = this.merchantSourceDao.merchantSource(merchantId, MerchantIpSourceConstants.IP_TYPE.dynamics.name());
        String sourceCode = IpSourceConstants.SOURCE_CODE.dataimpulse.name();
        if (sourceDTO != null) {
            sourceCode = sourceDTO.getSourceCode();
        }
        if (sourceCode.equals(IpSourceConstants.SOURCE_CODE.dataimpulse.name())) {
            this.addDataimpulseBalance(accountId, trafficLimit.longValue());
        }
        if (sourceCode.equals(IpSourceConstants.SOURCE_CODE.netnut.name())) {
            this.addNetnutBalance(accountId, trafficLimit.longValue());
        }
        if (sourceCode.equals(IpSourceConstants.SOURCE_CODE.oxylabs.name())) {
            this.addOxylabsBalance(merchantId, accountId, trafficLimit.longValue());
        }
        return true;
    }

    private Boolean addDataimpulseBalance(Long accountId, Long traffic) {
        AddSubUserBalanceResponse addSubUserBalanceResponse = this.dataimpulseSubUserApiService.addBalance(accountId, traffic);
        if (addSubUserBalanceResponse.getSuccess()) {
            return true;
        }
        return false;
    }

    private Boolean addNetnutBalance(Long accountId, Long traffic) {
        AllocateGBRequest allocateGBRequest = new AllocateGBRequest();
        allocateGBRequest.setAllocate(traffic.intValue());
        allocateGBRequest.setProductType("*");
        AllocateGBResponse allocateGBResponse = this.netnutSubUserApiService.allocateGBToSubUser(accountId.toString(), allocateGBRequest);
        if (allocateGBResponse.getSuccess()) {
            return true;
        }
        return false;
    }

    private Boolean addOxylabsBalance(Long merchantId, Long accountId, Long traffic) {
        KtonIpDynamicsAccount entity = new KtonIpDynamicsAccount();
        entity.setMerchantId(merchantId);
        entity.setAccountId(accountId);
        // 【修复】泛型
        List<KtonIpDynamicsAccount> accounts = this.accountMapper.selectKtonIpDynamicsAccountList(entity);
        BigDecimal lastPlanResidueTrafficGb = new BigDecimal(traffic);
        if (accounts.size() > 0) {
            KtonIpDynamicsAccount account = accounts.get(0);
            BigDecimal accountTrafficLimit = account.getTrafficLimit();
            lastPlanResidueTrafficGb = accountTrafficLimit.add(new BigDecimal(traffic));
        }
        UpdateSubUserRequest updateSubUserRequest = new UpdateSubUserRequest();
        updateSubUserRequest.setTrafficLimit(lastPlanResidueTrafficGb.doubleValue());
        SubUserResponse subUserResponse = this.oxylabsSubUserApiService.updateSubUser(Integer.valueOf(accountId.intValue()), updateSubUserRequest);
        if (subUserResponse.getTraffic().compareTo(0.0) > 0) {
            return true;
        }
        return false;
    }

    private void cutMerchantBalance(Long merchantId, BigDecimal traffic) {
        KtonIpDynamicsPlan entity = new KtonIpDynamicsPlan();
        entity.setMerchantId(merchantId);
        // 【修复】泛型
        List<KtonIpDynamicsPlan> plans = this.planMapper.selectKtonIpDynamicsPlanList(entity);
        if (plans.size() > 0) {
            KtonIpDynamicsPlan plan = plans.get(0);
            BigDecimal planResidueTrafficGb = plan.getPlanResidueTrafficGb();
            BigDecimal lastPlanResidueTrafficGb = planResidueTrafficGb.subtract(traffic);
            plan.setPlanResidueTrafficGb(lastPlanResidueTrafficGb);
            plan.setUpdateTime(new Date());
            this.planMapper.updateKtonIpDynamicsPlan(plan);
        }
    }

    private void addSubAccountBalance(Long merchantId, Long accountId, BigDecimal traffic) {
        KtonIpDynamicsAccount entity = new KtonIpDynamicsAccount();
        entity.setMerchantId(merchantId);
        entity.setAccountId(accountId);
        // 【修复】泛型
        List<KtonIpDynamicsAccount> accounts = this.accountMapper.selectKtonIpDynamicsAccountList(entity);
        if (accounts.size() > 0) {
            KtonIpDynamicsAccount account = accounts.get(0);
            BigDecimal accountTrafficLimit = account.getTrafficLimit();
            BigDecimal lastPlanResidueTrafficGb = accountTrafficLimit.add(traffic);
            account.setTrafficLimit(lastPlanResidueTrafficGb);
            account.setUpdateTime(new Date());
            this.accountMapper.updateKtonIpDynamicsAccount(account);
        }
    }

    private void sendWeComMessage(Long merchantId, Long accountId, BigDecimal trafficLimit) {
        KtonMerchant ktonMerchant = this.merchantMapper.selectKtonMerchantById(merchantId);
        KtonIpDynamicsAccount account = this.adminAccountDao.detail(merchantId, accountId);
        String label = account.getLabel();
        Date subtime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(subtime);
        String msg = "业务事件通知：\n有商户为子账号充值：\n商户名：" + ktonMerchant.getName() + "\n商户ID:" + ktonMerchant.getId() + "\n子账号标签：" + label + "\n充值的流量为：" + trafficLimit + "GB\n充值时间：" + formattedDate;
        WeChatWebhookUtil.sendMessage(msg);
    }

    private int addBanlanceInfo(Long merchantId, Long accountId, BanlanceResponseInfoDTO responseInfoDTO) {
        KtonIpDynamicsAccountBalance entity = new KtonIpDynamicsAccountBalance();
        entity.setMerchantId(merchantId);
        entity.setAccountId(accountId);
        // 【修复】泛型
        List<KtonIpDynamicsAccountBalance> balances = this.balanceMapper.selectKtonIpDynamicsAccountBalanceList(entity);
        if (balances.size() > 0) {
            this.balanceMapper.deleteKtonIpDynamicsAccountBalanceById(balances.get(0).getId());
        }
        return this.addBalanceRecord(merchantId, accountId, responseInfoDTO);
    }

    private int addBalanceRecord(Long merchantId, Long accountId, BanlanceResponseInfoDTO responseInfoDTO) {
        KtonIpDynamicsAccountBalance addEntity = new KtonIpDynamicsAccountBalance();
        addEntity.setMerchantId(merchantId);
        addEntity.setAccountId(accountId);
        addEntity.setBalance(responseInfoDTO.getBalance());
        addEntity.setBalanceFormat(responseInfoDTO.getBalanceFormat());
        addEntity.setBalanceTotal(responseInfoDTO.getBalanceTotal());
        addEntity.setBalanceTotalFormat(responseInfoDTO.getBalanceTotalFormat());
        addEntity.setBalanceUsed(responseInfoDTO.getBalanceUsed());
        addEntity.setBalanceUsedFormat(responseInfoDTO.getBalanceUsedFormat());
        addEntity.setThreadsUsed(responseInfoDTO.getThreadsUsed());
        addEntity.setCreateTime(new Date());
        return this.balanceMapper.insertKtonIpDynamicsAccountBalance(addEntity);
    }
}