/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.api.dataimpulse.entity.subuser.AddSubUserBalanceResponse
 *  com.kylin.kton.api.dataimpulse.entity.subuser.QuerySubUserBalanceResponse
 *  com.kylin.kton.api.dataimpulse.service.DataImpulseSubUserApiService
 *  com.kylin.kton.api.netnut.entity.subuser.AllocateGBRequest
 *  com.kylin.kton.api.netnut.entity.subuser.AllocateGBResponse
 *  com.kylin.kton.api.netnut.entity.subuser.CustomerPlansData
 *  com.kylin.kton.api.netnut.entity.subuser.CustomerPlansRequest
 *  com.kylin.kton.api.netnut.entity.subuser.CustomerPlansResponse
 *  com.kylin.kton.api.netnut.service.NetnutSubUserApiService
 *  com.kylin.kton.api.oxylabs.entity.subuser.SubUserResponse
 *  com.kylin.kton.api.oxylabs.entity.subuser.UpdateSubUserRequest
 *  com.kylin.kton.api.oxylabs.service.OxylabsSubUserApiService
 *  com.kylin.kton.common.constant.IpSourceConstants$SOURCE_CODE
 *  com.kylin.kton.common.constant.MerchantIpSourceConstants$IP_TYPE
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.utils.WeChatWebhookUtil
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccount
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountBalance
 *  com.kylin.kton.system.domain.KtonIpDynamicsPlan
 *  com.kylin.kton.system.domain.KtonMerchant
 *  com.kylin.kton.system.mapper.KtonIpDynamicsAccountBalanceMapper
 *  com.kylin.kton.system.mapper.KtonIpDynamicsAccountMapper
 *  com.kylin.kton.system.mapper.KtonIpDynamicsPlanMapper
 *  com.kylin.kton.system.mapper.KtonMerchantMapper
 *  com.kylin.kton.system.service.impl.KtonIpDynamicsAccountBalanceServiceImpl
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.BeanUtils
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.client.account.service.impl;

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
import com.kylin.kton.api.oxylabs.entity.subuser.UpdateSubUserRequest;
import com.kylin.kton.api.oxylabs.service.OxylabsSubUserApiService;
import com.kylin.kton.client.account.entity.dto.BanlanceResponseInfoDTO;
import com.kylin.kton.client.account.entity.vo.AccountBalanceSearchVO;
import com.kylin.kton.client.account.entity.vo.BalanceAddVO;
import com.kylin.kton.client.account.mapper.ClientAccountDao;
import com.kylin.kton.client.account.service.ClientIpDynamicsAccountBalanceService;
import com.kylin.kton.client.merchant.base.entity.dto.ClientMerchantSourceDTO;
import com.kylin.kton.client.merchant.base.mapper.MerchantSourceDao;
import com.kylin.kton.common.constant.IpSourceConstants;
import com.kylin.kton.common.constant.MerchantIpSourceConstants;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.utils.WeChatWebhookUtil;
import com.kylin.kton.system.domain.KtonIpDynamicsAccount;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountBalance;
import com.kylin.kton.system.domain.KtonIpDynamicsPlan;
import com.kylin.kton.system.domain.KtonMerchant;
import com.kylin.kton.system.mapper.KtonIpDynamicsAccountBalanceMapper;
import com.kylin.kton.system.mapper.KtonIpDynamicsAccountMapper;
import com.kylin.kton.system.mapper.KtonIpDynamicsPlanMapper;
import com.kylin.kton.system.mapper.KtonMerchantMapper;
import com.kylin.kton.system.service.impl.KtonIpDynamicsAccountBalanceServiceImpl;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientIpDynamicsAccountBalanceServiceImpl
extends KtonIpDynamicsAccountBalanceServiceImpl
implements ClientIpDynamicsAccountBalanceService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(ClientIpDynamicsAccountBalanceServiceImpl.class);
    @Autowired
    KtonIpDynamicsAccountBalanceMapper balanceMapper;
    @Autowired
    KtonMerchantMapper merchantMapper;
    @Autowired
    KtonIpDynamicsAccountMapper accountMapper;
    @Autowired
    DataImpulseSubUserApiService dataimpulseSubUserApiService;
    @Autowired
    NetnutSubUserApiService netnutSubUserApiService;
    @Autowired
    OxylabsSubUserApiService oxylabsSubUserApiService;
    @Autowired
    ClientAccountDao clientAccountDao;
    @Autowired
    KtonIpDynamicsPlanMapper planMapper;
    @Autowired
    MerchantSourceDao merchantSourceDao;

    @Override
    public List<KtonIpDynamicsAccountBalance> list(AccountBalanceSearchVO searchVO) {
        Long merchantId = searchVO.getMerchantId();
        Long accountId = searchVO.getAccountId();
        try {
            this.distributeBanlanceUpdateRequset(merchantId, accountId);
        }
        catch (ArithmeticException e) {
            log.info("queryBalance  failed: " + e.getMessage());
        }
        KtonIpDynamicsAccountBalance entity = new KtonIpDynamicsAccountBalance();
        entity.setMerchantId(merchantId);
        entity.setAccountId(accountId);
        List balances = this.balanceMapper.selectKtonIpDynamicsAccountBalanceList(entity);
        return balances;
    }

    private void distributeBanlanceUpdateRequset(Long merchantId, Long accountId) {
        ClientMerchantSourceDTO sourceDTO = this.merchantSourceDao.merchantSource(merchantId, MerchantIpSourceConstants.IP_TYPE.dynamics.name());
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
            this.updateOxylabsBanlanceInfo(merchantId, accountId);
        }
    }

    private void updateDataimpulseBanlanceInfo(Long merchantId, Long accountId) {
        QuerySubUserBalanceResponse balanceResponse = this.dataimpulseSubUserApiService.queryBalance(accountId);
        log.info("balanceResponse = {}", (Object)balanceResponse);
        BanlanceResponseInfoDTO infoDTO = new BanlanceResponseInfoDTO();
        BeanUtils.copyProperties((Object)balanceResponse, (Object)infoDTO);
        this.addBanlanceInfo(merchantId, accountId, infoDTO);
    }

    private void updateNetnutBanlanceInfo(Long merchantId, Long accountId) {
        CustomerPlansRequest customerPlansRequest = new CustomerPlansRequest();
        CustomerPlansResponse customerPlansResponse = this.netnutSubUserApiService.getCustomerPlans(accountId.toString(), customerPlansRequest);
        log.info("updateNetnutBanlanceInfo subUserResponse = {}", (Object)customerPlansResponse);
        BanlanceResponseInfoDTO infoDTO = new BanlanceResponseInfoDTO();
        Object plan = null;
        List plansData = customerPlansResponse.getData();
        if (plansData.size() > 0) {
            infoDTO = this.calcBalanceData(plansData);
        }
        this.addBanlanceInfo(merchantId, accountId, infoDTO);
    }

    private BanlanceResponseInfoDTO calcBalanceData(List<CustomerPlansData> plansData) {
        BanlanceResponseInfoDTO infoDTO = new BanlanceResponseInfoDTO();
        BigDecimal balanceTotal = new BigDecimal(0);
        BigDecimal balanceUsed = new BigDecimal(0);
        BigDecimal banlance = new BigDecimal(0);
        String threadsUsed = "0";
        if (plansData.size() > 0) {
            for (CustomerPlansData plan : plansData) {
                if (!plan.getIsActive().booleanValue()) continue;
                balanceTotal = balanceTotal.add(new BigDecimal(plan.getPlanGb()));
                balanceUsed = balanceUsed.add(new BigDecimal(plan.getTotalGBUsed()));
            }
        }
        banlance = balanceTotal.subtract(balanceUsed);
        String balanceTotalFormat = balanceTotal + "GB";
        String balanceUsedFormat = balanceUsed + "GB";
        String banlanceFormat = banlance + "GB";
        infoDTO.setBalanceTotal(balanceTotal);
        infoDTO.setBalanceTotalFormat(balanceTotalFormat);
        infoDTO.setBalanceUsed(balanceUsed);
        infoDTO.setBalanceUsedFormat(balanceUsedFormat);
        infoDTO.setBalanceFormat(banlanceFormat);
        infoDTO.setBalance(banlance);
        infoDTO.setBalanceFormat(banlanceFormat);
        infoDTO.setThreadsUsed(threadsUsed);
        return infoDTO;
    }

    private void updateOxylabsBanlanceInfo(Long merchantId, Long accountId) {
        BanlanceResponseInfoDTO infoDTO = new BanlanceResponseInfoDTO();
        this.addBanlanceInfo(merchantId, accountId, infoDTO);
    }

    @Override
    public AjaxResult addBalance(BalanceAddVO addVO) {
        log.info("addBalance request params = \uff1a{}", (Object)addVO);
        Long accountId = addVO.getAccountId();
        Long merchantId = addVO.getMerchantId();
        BigDecimal trafficLimit = addVO.getTrafficLimit();
        long traffic = 0L;
        try {
            traffic = trafficLimit.longValueExact();
        }
        catch (ArithmeticException e) {
            log.info("Conversion to long failed: " + e.getMessage());
        }
        KtonIpDynamicsPlan entity = new KtonIpDynamicsPlan();
        entity.setMerchantId(merchantId);
        List plans = this.planMapper.selectKtonIpDynamicsPlanList(entity);
        if (plans.size() > 0) {
            KtonIpDynamicsPlan plan = (KtonIpDynamicsPlan)plans.get(0);
            BigDecimal balance = plan.getPlanResidueTrafficGb();
            if (balance.compareTo(trafficLimit) < 0) {
                return AjaxResult.error((String)"\u4f59\u989d\u4e0d\u8db3");
            }
            this.distributionRequest(addVO);
            this.cutMerchantBalance(merchantId, trafficLimit);
            this.addSubAccountBalance(merchantId, accountId, trafficLimit);
            this.sendWeComMessage(merchantId, accountId, trafficLimit);
        }
        return AjaxResult.success();
    }

    private Boolean distributionRequest(BalanceAddVO addVO) {
        Long accountId = addVO.getAccountId();
        BigDecimal trafficLimit = addVO.getTrafficLimit();
        Long merchantId = addVO.getMerchantId();
        ClientMerchantSourceDTO sourceDTO = this.merchantSourceDao.merchantSource(merchantId, MerchantIpSourceConstants.IP_TYPE.dynamics.name());
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
            this.addOxylabsBalance(accountId, trafficLimit.longValue());
        }
        return true;
    }

    private Boolean addDataimpulseBalance(Long accountId, Long traffic) {
        AddSubUserBalanceResponse addSubUserBalanceResponse = this.dataimpulseSubUserApiService.addBalance(accountId, traffic);
        log.info("addSubUserBalanceResponse = {]", (Object)addSubUserBalanceResponse);
        if (addSubUserBalanceResponse.getSuccess().booleanValue()) {
            log.info(accountId + " addDataimpulseBalance success");
            return true;
        }
        log.info(accountId + " addDataimpulseBalance fail");
        return false;
    }

    private Boolean addNetnutBalance(Long accountId, Long traffic) {
        AllocateGBRequest allocateGBRequest = new AllocateGBRequest();
        allocateGBRequest.setAllocate(Integer.valueOf(traffic.intValue()));
        allocateGBRequest.setProductType("*");
        AllocateGBResponse allocateGBResponse = this.netnutSubUserApiService.allocateGBToSubUser(accountId.toString(), allocateGBRequest);
        log.info("addNetnutBalance = {]", (Object)allocateGBResponse);
        if (allocateGBResponse.getSuccess().booleanValue()) {
            log.info(accountId + " addNetnutBalance success");
            return true;
        }
        log.info(accountId + " addNetnutBalance fail");
        return false;
    }

    private Boolean addOxylabsBalance(Long accountId, Long traffic) {
        UpdateSubUserRequest updateSubUserRequest = new UpdateSubUserRequest();
        updateSubUserRequest.setTrafficLimit(Double.valueOf(traffic.doubleValue()));
        SubUserResponse subUserResponse = this.oxylabsSubUserApiService.updateSubUser(Integer.valueOf(accountId.intValue()), updateSubUserRequest);
        log.info("addOxylabsBalance = {}", (Object)subUserResponse);
        return true;
    }

    private void cutMerchantBalance(Long merchantId, BigDecimal traffic) {
        KtonIpDynamicsPlan entity = new KtonIpDynamicsPlan();
        entity.setMerchantId(merchantId);
        List plans = this.planMapper.selectKtonIpDynamicsPlanList(entity);
        if (plans.size() > 0) {
            KtonIpDynamicsPlan plan = (KtonIpDynamicsPlan)plans.get(0);
            BigDecimal planResidueTrafficGb = plan.getPlanResidueTrafficGb();
            BigDecimal lastPlanResidueTrafficGb = planResidueTrafficGb.subtract(traffic);
            plan.setPlanResidueTrafficGb(lastPlanResidueTrafficGb);
            plan.setUpdateTime(new Date());
            log.info("cutMerchantBalance merchantId = " + merchantId);
            log.info("cutMerchantBalance traffic = " + traffic);
            this.planMapper.updateKtonIpDynamicsPlan(plan);
        }
    }

    private void addSubAccountBalance(Long merchantId, Long accountId, BigDecimal traffic) {
        KtonIpDynamicsAccount entity = new KtonIpDynamicsAccount();
        entity.setMerchantId(merchantId);
        entity.setAccountId(accountId);
        List accounts = this.accountMapper.selectKtonIpDynamicsAccountList(entity);
        if (accounts.size() > 0) {
            KtonIpDynamicsAccount account = (KtonIpDynamicsAccount)accounts.get(0);
            BigDecimal accountTrafficLimit = account.getTrafficLimit();
            BigDecimal lastPlanResidueTrafficGb = accountTrafficLimit.add(traffic);
            account.setTrafficLimit(lastPlanResidueTrafficGb);
            account.setUpdateTime(new Date());
            log.info("cutMerchantBalance merchantId = " + merchantId);
            log.info("cutMerchantBalance traffic = " + traffic);
            this.accountMapper.updateKtonIpDynamicsAccount(account);
        }
    }

    private void sendWeComMessage(Long merchantId, Long accountId, BigDecimal trafficLimit) {
        KtonMerchant ktonMerchant = this.merchantMapper.selectKtonMerchantById(merchantId);
        KtonIpDynamicsAccount account = this.clientAccountDao.detail(merchantId, accountId);
        String label = account.getLabel();
        Date subtime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(subtime);
        String msg = "\u4e1a\u52a1\u4e8b\u4ef6\u901a\u77e5\uff1a\n\u6709\u5546\u6237\u4e3a\u5b50\u8d26\u53f7\u5145\u503c\uff1a\n\u5546\u6237\u540d\uff1a" + ktonMerchant.getName() + "\n\u5546\u6237ID:" + ktonMerchant.getId() + "\n\u5b50\u8d26\u53f7\u6807\u7b7e\uff1a" + label + "\n\u5145\u503c\u7684\u6d41\u91cf\u4e3a\uff1a" + trafficLimit + "GB\n\u5145\u503c\u65f6\u95f4\uff1a" + formattedDate;
        WeChatWebhookUtil.sendMessage((String)msg);
    }

    private int addBanlanceInfo(Long merchantId, Long accountId, BanlanceResponseInfoDTO responseInfoDTO) {
        KtonIpDynamicsAccountBalance entity = new KtonIpDynamicsAccountBalance();
        entity.setMerchantId(merchantId);
        entity.setAccountId(accountId);
        List balances = this.balanceMapper.selectKtonIpDynamicsAccountBalanceList(entity);
        if (balances.size() > 0) {
            this.balanceMapper.deleteKtonIpDynamicsAccountBalanceById(((KtonIpDynamicsAccountBalance)balances.get(0)).getId());
            return this.addBalanceRecord(merchantId, accountId, responseInfoDTO);
        }
        return this.addBalanceRecord(merchantId, accountId, responseInfoDTO);
    }

    private int addBalanceRecord(Long merchantId, Long accountId, BanlanceResponseInfoDTO responseInfoDTO) {
        BigDecimal balance = responseInfoDTO.getBalance();
        String balanceFormat = responseInfoDTO.getBalanceFormat();
        BigDecimal balanceTotal = responseInfoDTO.getBalanceTotal();
        String balanceTotalFormat = responseInfoDTO.getBalanceTotalFormat();
        BigDecimal balanceUsed = responseInfoDTO.getBalanceUsed();
        String balanceUsedFormat = responseInfoDTO.getBalanceUsedFormat();
        String threadsUsed = responseInfoDTO.getThreadsUsed();
        KtonIpDynamicsAccountBalance addEntity = new KtonIpDynamicsAccountBalance();
        addEntity.setMerchantId(merchantId);
        addEntity.setAccountId(accountId);
        addEntity.setBalance(balance);
        addEntity.setBalanceFormat(balanceFormat);
        addEntity.setBalanceTotal(balanceTotal);
        addEntity.setBalanceTotalFormat(balanceTotalFormat);
        addEntity.setBalanceUsed(balanceUsed);
        addEntity.setBalanceUsedFormat(balanceUsedFormat);
        addEntity.setThreadsUsed(threadsUsed);
        addEntity.setCreateTime(new Date());
        return this.balanceMapper.insertKtonIpDynamicsAccountBalance(addEntity);
    }
}

