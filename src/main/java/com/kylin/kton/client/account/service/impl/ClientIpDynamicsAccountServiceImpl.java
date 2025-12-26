package com.kylin.kton.client.account.service.impl;

import com.kylin.kton.api.dataimpulse.constant.Protocols;
import com.kylin.kton.api.dataimpulse.entity.subuser.CreateSubUserRequest;
import com.kylin.kton.api.dataimpulse.entity.subuser.CreateSubUserResponse;
import com.kylin.kton.api.dataimpulse.service.DataImpulseSubUserApiService;
import com.kylin.kton.api.netnut.entity.subuser.AddSubUserData;
import com.kylin.kton.api.netnut.entity.subuser.AddSubUserRequest;
import com.kylin.kton.api.netnut.entity.subuser.AddSubUserResponse;
import com.kylin.kton.api.netnut.entity.subuser.DisableSubUserRequest;
import com.kylin.kton.api.netnut.service.NetnutSubUserApiService;
import com.kylin.kton.api.oxylabs.entity.subuser.SubUserRequest;
import com.kylin.kton.api.oxylabs.entity.subuser.createSubUserResponse;
import com.kylin.kton.api.oxylabs.service.OxylabsSubUserApiService;
import com.kylin.kton.client.account.entity.dto.SubUserAccountResDTO;
import com.kylin.kton.client.account.entity.vo.AccountAddVO;
import com.kylin.kton.client.account.entity.vo.AccountEditVO;
import com.kylin.kton.client.account.mapper.ClientSourceDao;
import com.kylin.kton.client.account.service.ClientIpDynamicsAccountService;
import com.kylin.kton.client.account.service.ClientIpDynamicsAccountSupportProtocolService;
import com.kylin.kton.client.merchant.base.entity.dto.ClientMerchantSourceDTO;
import com.kylin.kton.client.merchant.base.mapper.MerchantSourceDao;
import com.kylin.kton.common.constant.IpDynamicsAccountConstants;
import com.kylin.kton.common.constant.IpSourceConstants;
import com.kylin.kton.common.constant.MerchantIpSourceConstants;
import com.kylin.kton.common.exception.CustomServiceException;
import com.kylin.kton.common.utils.WeChatWebhookUtil;
import com.kylin.kton.common.utils.bean.BeanUtils;
import com.kylin.kton.system.domain.KtonIpDynamicsAccount;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountAllowIp;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountEndpoint;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountSupportProtocol;
import com.kylin.kton.system.domain.KtonIpDynamicsPlan;
import com.kylin.kton.system.domain.KtonMerchant;
import com.kylin.kton.system.domain.KtonSource;
import com.kylin.kton.system.mapper.KtonIpDynamicsAccountAllowIpMapper;
import com.kylin.kton.system.mapper.KtonIpDynamicsAccountBalanceMapper;
import com.kylin.kton.system.mapper.KtonIpDynamicsAccountEndpointMapper;
import com.kylin.kton.system.mapper.KtonIpDynamicsAccountMapper;
import com.kylin.kton.system.mapper.KtonIpDynamicsPlanMapper;
import com.kylin.kton.system.mapper.KtonMerchantMapper;
import com.kylin.kton.system.service.impl.KtonIpDynamicsAccountServiceImpl;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ClientIpDynamicsAccountServiceImpl
        extends KtonIpDynamicsAccountServiceImpl
        implements ClientIpDynamicsAccountService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(ClientIpDynamicsAccountServiceImpl.class);
    @Autowired
    KtonIpDynamicsAccountMapper accountMapper;
    @Autowired
    KtonIpDynamicsAccountBalanceMapper balanceMapper;
    @Autowired
    KtonIpDynamicsAccountAllowIpMapper accountAllowIpMapper;
    @Autowired
    KtonMerchantMapper merchantMapper;
    @Autowired
    ClientSourceDao clientSourceDao;
    @Autowired
    DataImpulseSubUserApiService dataimpulseSubUserApiService;
    @Autowired
    NetnutSubUserApiService netnutSubUserApiService;
    @Autowired
    OxylabsSubUserApiService oxylabsSubUserApiService;
    @Autowired
    ClientIpDynamicsAccountSupportProtocolService protocolService;
    @Autowired
    KtonIpDynamicsAccountEndpointMapper endpointMapper;
    @Autowired
    MerchantSourceDao merchantSourceDao;
    @Autowired
    KtonIpDynamicsPlanMapper planMapper;
    @Value(value="${api.dataimpulse.endpointHost}")
    String dataimpulseEndpointHost;
    @Value(value="${api.dataimpulse.endpointHttpsPort}")
    Long dataimpulseHttpsEndpointPort;
    @Value(value="${api.dataimpulse.endpointSocks5Port}")
    Long dataimpulseSocks5EndpointPort;
    @Value(value="${api.netnut.endpointHost}")
    String netnutEndpointHost;
    @Value(value="${api.netnut.endpointHttpsPort}")
    Long netnutHttpsEndpointPort;
    @Value(value="${api.netnut.endpointSocks5Port}")
    Long netnutSocks5EndpointPort;
    @Value(value="${api.oxylabs.endpointHost}")
    String oxylabsEndpointHost;
    @Value(value="${api.oxylabs.endpointHttpsPort}")
    Long oxylabsHttpsEndpointPort;
    @Value(value="${api.oxylabs.endpointSocks5Port}")
    Long oxylabsSocks5EndpointPort;
    @Value(value="${api.ipnux.endpointHost}")
    String ipnuxEndpointHost;
    @Value(value="${api.ipnux.endpointPort}")
    Long ipnuxEndpointPort;

    @Override
    public int add(AccountAddVO addVO) {
        log.info("Creating account with AccountAddVO: {}", addVO);
        KtonIpDynamicsAccount account = new KtonIpDynamicsAccount();
        account.setLabel(addVO.getLabel());
        account.setTrafficLimit(addVO.getTrafficLimit());
        account.setRemarks(addVO.getRemarks());
        account.setMerchantId(addVO.getMerchantId());
        account.setCreateTime(new Date());
        account.setPassword(this.createPassword());
        try {
            SubUserAccountResDTO resDTO = this.distributeRequset(addVO);
            this.populateAccountFromResponse(account, resDTO);
            account.setStatus(IpDynamicsAccountConstants.STATUS.active.name());
            int res = this.handleAccountInsertion(account, addVO);
            this.sendWeComMessage(addVO.getMerchantId(), addVO.getLabel());
            this.handleProtocols(addVO.getProtocols(), account.getAccountId(), addVO.getMerchantId());
            return res;
        }
        catch (Exception e) {
            log.error("Error during account creation. AccountAddVO: {}", addVO, e);
            throw new CustomServiceException("Account creation failed.");
        }
    }

    @Override
    public int edit(AccountEditVO editVO) {
        KtonIpDynamicsAccount account = new KtonIpDynamicsAccount();
        BeanUtils.copyProperties(editVO, account);
        account.setAccount(editVO.getAccount());
        account.setTrafficLimit(editVO.getTrafficLimit());
        account.setRemarks(editVO.getRemarks());
        account.setPassword(editVO.getPassword());
        account.setMerchantId(editVO.getMerchantId());
        account.setAccountId(editVO.getAccountId());
        account.setUpdateTime(new Date());
        log.info("account = {}", account);
        this.handleEditProtocols(editVO.getProtocols(), account.getAccountId(), editVO.getMerchantId());
        int res = this.accountMapper.updateKtonIpDynamicsAccount(account);
        return res;
    }

    private SubUserAccountResDTO distributeRequset(AccountAddVO addVO) {
        SubUserAccountResDTO resDto = new SubUserAccountResDTO();
        Long merchantId = addVO.getMerchantId();
        ClientMerchantSourceDTO sourceDTO = this.merchantSourceDao.merchantSource(merchantId, MerchantIpSourceConstants.IP_TYPE.dynamics.name());
        String sourceCode = IpSourceConstants.SOURCE_CODE.dataimpulse.name();
        if (sourceDTO != null) {
            sourceCode = sourceDTO.getSourceCode();
        }
        if (sourceCode.equals(IpSourceConstants.SOURCE_CODE.dataimpulse.name())) {
            log.info("do createDataimpulseSubUser");
            resDto = this.createDataimpulseSubUser(addVO);
        }
        if (sourceCode.equals(IpSourceConstants.SOURCE_CODE.netnut.name())) {
            log.info("do createNetnutSubUser");
            resDto = this.createNetnutSubUser(addVO);
        }
        if (sourceCode.equals(IpSourceConstants.SOURCE_CODE.oxylabs.name())) {
            log.info("do createOxylabsSubUser");
            resDto = this.createOxylabsSubUser(addVO);
        }
        return resDto;
    }

    private int handleAccountInsertion(KtonIpDynamicsAccount account, Object accountInfo) {
        int res = this.accountMapper.insertKtonIpDynamicsAccount(account);
        if (res <= 0) {
            log.error("Failed to insert account into database. Account: {}", accountInfo);
            throw new CustomServiceException("Account creation failed due to database insertion error.");
        }
        return res;
    }

    private SubUserAccountResDTO createDataimpulseSubUser(AccountAddVO addVO) {
        SubUserAccountResDTO resDTO = new SubUserAccountResDTO();
        CreateSubUserRequest createSubUserRequest = new CreateSubUserRequest();
        createSubUserRequest.setLabel(addVO.getLabel());
        CreateSubUserResponse subUserResponse = this.dataimpulseSubUserApiService.create(createSubUserRequest);
        resDTO.setChannelLabel(subUserResponse.getLabel());
        resDTO.setPoolType(subUserResponse.getPoolType());
        resDTO.setPassword(subUserResponse.getPassword());
        resDTO.setAccount(subUserResponse.getLogin());
        resDTO.setAccountId(subUserResponse.getId());
        resDTO.setSourceCode(IpSourceConstants.SOURCE_CODE.dataimpulse.name());
        return resDTO;
    }

    private SubUserAccountResDTO createNetnutSubUser(AccountAddVO addVO) {
        SubUserAccountResDTO resDTO = new SubUserAccountResDTO();
        String account = this.createNetnutAccount();
        String pwd = this.createPassword();
        AddSubUserRequest addSubUserRequest = new AddSubUserRequest();
        addSubUserRequest.setCustomerName(addVO.getLabel());
        addSubUserRequest.setCustomerLoginName(account);
        addSubUserRequest.setCustomerLoginPwd(pwd);
        addSubUserRequest.setCustomerDashboardPwd(pwd);
        addSubUserRequest.setCustomerDashboardEmail(addVO.getEmail());
        AddSubUserResponse addSubUserResponse = this.netnutSubUserApiService.addSubUser(addSubUserRequest);
        log.info("createNetnutSubUser = {}", addSubUserResponse);
        AddSubUserData addSubUserData = addSubUserResponse.getData();
        resDTO.setChannelLabel(addSubUserData.getCustomerName());
        resDTO.setSourceCode(IpSourceConstants.SOURCE_CODE.netnut.name());
        resDTO.setAccountId((long)addSubUserData.getCustomerId());
        resDTO.setAccount(addSubUserData.getCustomerLoginName());
        resDTO.setPassword(pwd);
        resDTO.setEmail(addVO.getEmail());
        return resDTO;
    }

    private SubUserAccountResDTO createOxylabsSubUser(AccountAddVO addVO) {
        SubUserAccountResDTO resDTO = new SubUserAccountResDTO();
        String account = this.createOxylabsAccount();
        String pwd = this.createPassword();
        SubUserRequest subUserRequest = new SubUserRequest();
        subUserRequest.setUsername(account);
        subUserRequest.setPassword(pwd);
        createSubUserResponse subUserResponse = this.oxylabsSubUserApiService.createSubUser(subUserRequest);
        log.info("createOxylabsSubUser subUserResponse = {}", subUserResponse);
        resDTO.setChannelLabel(account);
        resDTO.setAccount(account);
        resDTO.setPassword(pwd);
        resDTO.setAccountId((long)subUserResponse.getId());
        resDTO.setSourceCode(IpSourceConstants.SOURCE_CODE.oxylabs.name());
        return resDTO;
    }

    private void populateAccountFromResponse(KtonIpDynamicsAccount account, SubUserAccountResDTO response) {
        account.setChannelLabel(response.getChannelLabel());
        account.setAccountId(response.getAccountId());
        account.setAccount(response.getAccount());
        account.setPassword(response.getPassword());
        account.setPoolType(response.getPoolType());
        account.setSourceId(this.getSourceIdBySourceCode(response.getSourceCode()));
    }

    private Long getSourceIdBySourceCode(String sourceCode) {
        KtonSource source = this.clientSourceDao.detailBySourceCode(sourceCode);
        Long sourceId = source.getId();
        return sourceId;
    }

    private void handleAllowedIps(CreateSubUserResponse response, Long merchantId) {
        if (response.getAllowedIps() != null && !response.getAllowedIps().isEmpty()) {
            this.addAllowIp(response.getAllowedIps(), response.getId(), merchantId);
        }
    }

    private void handleProtocols(List<String> protocols, Long subUserId, Long merchantId) {
        if (protocols != null) {
            log.info("Adding protocols: {}", protocols);
            this.addProtocols(protocols, subUserId, merchantId);
        }
    }

    private void handleEditProtocols(List<String> protocols, Long subUserId, Long merchantId) {
        if (protocols != null) {
            log.info("Editing protocols: {}", protocols);
            this.editProtocols(protocols, subUserId, merchantId);
        }
    }

    private void addktonEndpoint(Long merchantId, Long accountId, String protocol) {
        ClientMerchantSourceDTO sourceDTO = this.merchantSourceDao.merchantSource(merchantId, MerchantIpSourceConstants.IP_TYPE.dynamics.name());
        String sourceCode = IpSourceConstants.SOURCE_CODE.dataimpulse.name();
        if (sourceDTO != null) {
            sourceCode = sourceDTO.getSourceCode();
        }
        String endpointHost = null;
        Long socks5EndpointPort = null;
        Long httpsEndpointPort = null;
        if (sourceCode.equals(IpSourceConstants.SOURCE_CODE.dataimpulse.name())) {
            endpointHost = this.dataimpulseEndpointHost;
            httpsEndpointPort = this.dataimpulseHttpsEndpointPort;
            socks5EndpointPort = this.dataimpulseSocks5EndpointPort;
        }
        if (sourceCode.equals(IpSourceConstants.SOURCE_CODE.netnut.name())) {
            endpointHost = this.netnutEndpointHost;
            httpsEndpointPort = this.netnutHttpsEndpointPort;
            socks5EndpointPort = this.netnutSocks5EndpointPort;
        }
        if (sourceCode.equals(IpSourceConstants.SOURCE_CODE.oxylabs.name())) {
            endpointHost = this.oxylabsEndpointHost;
            httpsEndpointPort = this.oxylabsHttpsEndpointPort;
            socks5EndpointPort = this.oxylabsSocks5EndpointPort;
        }
        if (protocol.equals(Protocols.SOCKS5.getCode())) {
            KtonIpDynamicsAccountEndpoint accountEndpoint = new KtonIpDynamicsAccountEndpoint();
            accountEndpoint.setMerchantId(merchantId);
            accountEndpoint.setAccountId(accountId);
            accountEndpoint.setEndpointHost(endpointHost);
            accountEndpoint.setEndpointPort(socks5EndpointPort);
            accountEndpoint.setSupportedProtocol(Protocols.SOCKS5.getCode());
            accountEndpoint.setCreateTime(new Date());
            this.endpointMapper.insertKtonIpDynamicsAccountEndpoint(accountEndpoint);
        } else if (protocol.equals(Protocols.HTTP.getCode())) {
            KtonIpDynamicsAccountEndpoint accountEndpoint = new KtonIpDynamicsAccountEndpoint();
            accountEndpoint.setMerchantId(merchantId);
            accountEndpoint.setAccountId(accountId);
            accountEndpoint.setEndpointHost(endpointHost);
            accountEndpoint.setEndpointPort(httpsEndpointPort);
            accountEndpoint.setSupportedProtocol(Protocols.HTTP.getCode());
            accountEndpoint.setCreateTime(new Date());
            this.endpointMapper.insertKtonIpDynamicsAccountEndpoint(accountEndpoint);
        }
    }

    private void editKtonEndpoint(List<String> protocols, Long merchantId, Long accountId) {
        KtonIpDynamicsAccountEndpoint checkEndpoint = new KtonIpDynamicsAccountEndpoint();
        checkEndpoint.setAccountId(accountId);
        checkEndpoint.setMerchantId(merchantId);
        // 【修复】泛型
        List<KtonIpDynamicsAccountEndpoint> endpoints = this.endpointMapper.selectKtonIpDynamicsAccountEndpointList(checkEndpoint);
        Long[] ids = endpoints.stream().map(KtonIpDynamicsAccountEndpoint::getId).toArray(Long[]::new);
        if (ids.length > 0) {
            this.endpointMapper.deleteKtonIpDynamicsAccountEndpointByIds(ids);
        }
        for (String supportedProtocol : protocols) {
            KtonIpDynamicsAccountEndpoint accountEndpoint;
            KtonIpDynamicsAccountSupportProtocol protocol = new KtonIpDynamicsAccountSupportProtocol();
            protocol.setMerchantId(merchantId);
            protocol.setAccountId(accountId);
            protocol.setSupportedProtocol(supportedProtocol);
            protocol.setCreateTime(new Date());
            ClientMerchantSourceDTO sourceDTO = this.merchantSourceDao.merchantSource(merchantId, MerchantIpSourceConstants.IP_TYPE.dynamics.name());
            String sourceCode = IpSourceConstants.SOURCE_CODE.dataimpulse.name();
            if (sourceDTO != null) {
                sourceCode = sourceDTO.getSourceCode();
            }
            String endpointHost = null;
            Long socks5EndpointPort = null;
            Long httpsEndpointPort = null;
            if (sourceCode.equals(IpSourceConstants.SOURCE_CODE.dataimpulse.name())) {
                endpointHost = this.dataimpulseEndpointHost;
                httpsEndpointPort = this.dataimpulseHttpsEndpointPort;
                socks5EndpointPort = this.dataimpulseSocks5EndpointPort;
            }
            if (sourceCode.equals(IpSourceConstants.SOURCE_CODE.netnut.name())) {
                endpointHost = this.netnutEndpointHost;
                httpsEndpointPort = this.netnutHttpsEndpointPort;
                socks5EndpointPort = this.netnutSocks5EndpointPort;
            }
            if (sourceCode.equals(IpSourceConstants.SOURCE_CODE.oxylabs.name())) {
                endpointHost = this.oxylabsEndpointHost;
                httpsEndpointPort = this.oxylabsHttpsEndpointPort;
                socks5EndpointPort = this.oxylabsSocks5EndpointPort;
            }
            if (supportedProtocol.equals(Protocols.SOCKS5.getCode())) {
                accountEndpoint = new KtonIpDynamicsAccountEndpoint();
                accountEndpoint.setMerchantId(merchantId);
                accountEndpoint.setAccountId(accountId);
                accountEndpoint.setEndpointHost(endpointHost);
                accountEndpoint.setEndpointPort(socks5EndpointPort);
                accountEndpoint.setSupportedProtocol(Protocols.SOCKS5.getCode());
                accountEndpoint.setCreateTime(new Date());
                this.endpointMapper.insertKtonIpDynamicsAccountEndpoint(accountEndpoint);
                continue;
            }
            if (!supportedProtocol.equals(Protocols.HTTP.getCode())) continue;
            accountEndpoint = new KtonIpDynamicsAccountEndpoint();
            accountEndpoint.setMerchantId(merchantId);
            accountEndpoint.setAccountId(accountId);
            accountEndpoint.setEndpointHost(endpointHost);
            accountEndpoint.setEndpointPort(httpsEndpointPort);
            accountEndpoint.setSupportedProtocol(Protocols.HTTP.getCode());
            accountEndpoint.setCreateTime(new Date());
            this.endpointMapper.insertKtonIpDynamicsAccountEndpoint(accountEndpoint);
        }
    }

    private void sendWeComMessage(Long merchantId, String label) {
        KtonMerchant ktonMerchant = this.merchantMapper.selectKtonMerchantById(merchantId);
        Date subtime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(subtime);
        String msg = "\u4e1a\u52a1\u4e8b\u4ef6\u901a\u77e5\uff1a\n\u5546\u6237\u65b0\u521b\u5efa\u5b50\u8d26\u53f7\uff1a\n\u5546\u6237\u540d\uff1a" + ktonMerchant.getName() + "\n\u5546\u6237ID:" + ktonMerchant.getId() + "\n\u5b50\u8d26\u53f7\u6807\u7b7e\uff1a" + label + "\n\u521b\u5efa\u65f6\u95f4\uff1a" + formattedDate;
        WeChatWebhookUtil.sendMessage((String)msg);
    }

    private void addAllowIp(List<String> allowedIps, Long accountId, Long merchantId) {
        for (String ipAddress : allowedIps) {
            KtonIpDynamicsAccountAllowIp accountAllowIp = new KtonIpDynamicsAccountAllowIp();
            accountAllowIp.setMerchantId(accountId);
            accountAllowIp.setAccountId(merchantId);
            accountAllowIp.setIpAddress(ipAddress);
            accountAllowIp.setCreateTime(new Date());
            this.accountAllowIpMapper.insertKtonIpDynamicsAccountAllowIp(accountAllowIp);
        }
    }

    private void addProtocols(List<String> protocols, Long accountId, Long merchantId) {
        for (String supportedProtocol : protocols) {
            KtonIpDynamicsAccountSupportProtocol protocol = new KtonIpDynamicsAccountSupportProtocol();
            protocol.setMerchantId(merchantId);
            protocol.setAccountId(accountId);
            protocol.setSupportedProtocol(supportedProtocol);
            protocol.setCreateTime(new Date());
            this.protocolService.add(merchantId, protocol);
            this.addktonEndpoint(merchantId, accountId, supportedProtocol);
        }
    }

    private void editProtocols(List<String> protocols, Long accountId, Long merchantId) {
        this.protocolService.edit(protocols, accountId, merchantId);
        this.editKtonEndpoint(protocols, merchantId, accountId);
    }

    @Override
    public int remove(Long merchantId, Long[] ids) {
        for (Long id : ids) {
            KtonIpDynamicsAccount account = this.accountMapper.selectKtonIpDynamicsAccountById(id);
            this.distributeDelRequest(merchantId, account.getAccountId());
            BigDecimal trafficLimit = account.getTrafficLimit();
            log.info("accountId = " + account.getAccountId());
            log.info("account balance =  = " + account.getTrafficLimit());
            log.info("trafficLimit = " + trafficLimit);
            this.addMerchantBalance(merchantId, trafficLimit);
        }
        return this.accountMapper.deleteKtonIpDynamicsAccountByIds(ids);
    }

    private Boolean distributeDelRequest(Long merchantId, Long accountId) {
        ClientMerchantSourceDTO sourceDTO = this.merchantSourceDao.merchantSource(merchantId, MerchantIpSourceConstants.IP_TYPE.dynamics.name());
        String sourceCode = IpSourceConstants.SOURCE_CODE.dataimpulse.name();
        if (sourceDTO != null) {
            sourceCode = sourceDTO.getSourceCode();
        }
        if (sourceCode.equals(IpSourceConstants.SOURCE_CODE.dataimpulse.name())) {
            log.info("do delDataimpulseSubUser ");
            this.delDataimpulseSubUser(accountId);
        }
        if (sourceCode.equals(IpSourceConstants.SOURCE_CODE.netnut.name())) {
            log.info("do delNetnutSubUser ");
            this.delNetnutSubUser(accountId);
        }
        if (sourceCode.equals(IpSourceConstants.SOURCE_CODE.oxylabs.name())) {
            log.info("do delOxylabsSubUser ");
            this.delOxylabsSubUser(accountId);
        }
        return true;
    }

    private Boolean delDataimpulseSubUser(Long accountId) {
        this.dataimpulseSubUserApiService.dropBalance(accountId);
        this.dataimpulseSubUserApiService.delete(accountId);
        return true;
    }

    private Boolean delNetnutSubUser(Long accountId) {
        DisableSubUserRequest disableSubUserRequest = new DisableSubUserRequest();
        this.netnutSubUserApiService.disableSubUser(accountId.toString(), disableSubUserRequest);
        return true;
    }

    private Boolean delOxylabsSubUser(Long accountId) {
        this.oxylabsSubUserApiService.deleteSubUser(Integer.valueOf(accountId.intValue()));
        return true;
    }

    private void addMerchantBalance(Long merchantId, BigDecimal traffic) {
        KtonIpDynamicsPlan entity = new KtonIpDynamicsPlan();
        entity.setMerchantId(merchantId);
        // 【修复】泛型
        List<KtonIpDynamicsPlan> plans = this.planMapper.selectKtonIpDynamicsPlanList(entity);
        if (plans.size() > 0) {
            KtonIpDynamicsPlan plan = plans.get(0);
            BigDecimal planResidueTrafficGb = plan.getPlanResidueTrafficGb();
            BigDecimal lastPlanResidueTrafficGb = planResidueTrafficGb.add(traffic);
            plan.setPlanResidueTrafficGb(lastPlanResidueTrafficGb);
            plan.setUpdateTime(new Date());
            this.planMapper.updateKtonIpDynamicsPlan(plan);
        }
    }

    private String createPassword() {
        int passwordLength = 15;
        return ClientIpDynamicsAccountServiceImpl.generatePassword(passwordLength);
    }

    private String createNetnutAccount() {
        int length = 15;
        return ClientIpDynamicsAccountServiceImpl.generateNetnutAccount(length);
    }

    private String createOxylabsAccount() {
        int passwordLength = 15;
        return ClientIpDynamicsAccountServiceImpl.generateAccount(passwordLength);
    }

    private static String generateRandomString(int length, String chars) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; ++i) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }

    public static String generatePassword(int length) {
        if (length < 15) {
            throw new CustomServiceException("Password length must be at least 15 characters");
        }
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialChars = "_";
        String allChars = uppercaseLetters + lowercaseLetters + digits + specialChars;
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        password.append(uppercaseLetters.charAt(random.nextInt(uppercaseLetters.length())));
        password.append(lowercaseLetters.charAt(random.nextInt(lowercaseLetters.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(specialChars.charAt(random.nextInt(specialChars.length())));
        for (int i = 4; i < length; ++i) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }
        return ClientIpDynamicsAccountServiceImpl.shuffleString(password.toString());
    }

    public static String generateAccount(int length) {
        if (length < 15) {
            throw new CustomServiceException("Password length must be at least 15 characters");
        }
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialChars = "_";
        String allChars = uppercaseLetters + lowercaseLetters + specialChars;
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        password.append(uppercaseLetters.charAt(random.nextInt(uppercaseLetters.length())));
        password.append(lowercaseLetters.charAt(random.nextInt(lowercaseLetters.length())));
        password.append(specialChars.charAt(random.nextInt(specialChars.length())));
        for (int i = 4; i < length; ++i) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }
        return ClientIpDynamicsAccountServiceImpl.shuffleString(password.toString());
    }

    private static String shuffleString(String input) {
        char[] chars = input.toCharArray();
        Random random = new Random();
        for (int i = chars.length - 1; i > 0; --i) {
            int j = random.nextInt(i + 1);
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }

    public static String generateNetnutAccount(Integer length) {
        String charStr = "0123456789abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; ++i) {
            int index = random.nextInt(charStr.length());
            sb.append(charStr.charAt(index));
        }
        return sb.toString();
    }
}