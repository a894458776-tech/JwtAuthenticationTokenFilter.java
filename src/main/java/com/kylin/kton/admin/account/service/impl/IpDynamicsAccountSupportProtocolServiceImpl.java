package com.kylin.kton.admin.account.service.impl;

import com.kylin.kton.admin.account.service.IpDynamicsAccountEndpointService;
import com.kylin.kton.admin.account.service.IpDynamicsAccountSupportProtocolService;
import com.kylin.kton.admin.merchant.base.entity.dto.AdminMrtchantIpSourceDTO;
import com.kylin.kton.admin.merchant.base.mapper.AdminMerchantSourceDao;
import com.kylin.kton.api.dataimpulse.constant.Protocols;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetSupportedProtocolsResponse;
import com.kylin.kton.api.dataimpulse.service.DataImpulseSubUserApiService;
import com.kylin.kton.common.constant.IpSourceConstants;
import com.kylin.kton.common.constant.MerchantIpSourceConstants;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountEndpoint;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountSupportProtocol;
import com.kylin.kton.system.mapper.KtonIpDynamicsAccountEndpointMapper;
import com.kylin.kton.system.mapper.KtonIpDynamicsAccountSupportProtocolMapper;
import com.kylin.kton.system.service.impl.KtonIpDynamicsAccountSupportProtocolServiceImpl;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class IpDynamicsAccountSupportProtocolServiceImpl
        extends KtonIpDynamicsAccountSupportProtocolServiceImpl
        implements IpDynamicsAccountSupportProtocolService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(IpDynamicsAccountSupportProtocolServiceImpl.class);
    @Autowired
    KtonIpDynamicsAccountSupportProtocolMapper supportProtocolMapper;
    @Autowired
    DataImpulseSubUserApiService dataimpulseSubUserApiService;
    @Autowired
    KtonIpDynamicsAccountEndpointMapper ktonIpDynamicsAccountEndpointMapper;
    @Autowired
    IpDynamicsAccountEndpointService ipDynamicsAccountEndpointService;
    @Autowired
    AdminMerchantSourceDao merchantSourceDao;

    @Override
    public int add(Long merchantId, KtonIpDynamicsAccountSupportProtocol supportProtocol) {
        KtonIpDynamicsAccountSupportProtocol checkEntity = new KtonIpDynamicsAccountSupportProtocol();
        checkEntity.setAccountId(supportProtocol.getAccountId());
        checkEntity.setSupportedProtocol(supportProtocol.getSupportedProtocol());
        // 【修复】添加泛型
        List<KtonIpDynamicsAccountSupportProtocol> protocols = this.supportProtocolMapper.selectKtonIpDynamicsAccountSupportProtocolList(checkEntity);
        int res = 0;
        if (protocols.size() <= 0) {
            res = this.supportProtocolMapper.insertKtonIpDynamicsAccountSupportProtocol(supportProtocol);
            this.resetProtocol(merchantId, supportProtocol.getAccountId());
            this.ipDynamicsAccountEndpointService.addEndpoint(merchantId, supportProtocol.getAccountId(), supportProtocol.getSupportedProtocol());
        }
        return res;
    }

    @Override
    public int edit(List<String> protocols, Long accountId, Long merchantId) {
        KtonIpDynamicsAccountSupportProtocol checkEntity = new KtonIpDynamicsAccountSupportProtocol();
        checkEntity.setMerchantId(merchantId);
        checkEntity.setAccountId(merchantId);
        // 【修复】添加泛型，解决报错
        List<KtonIpDynamicsAccountSupportProtocol> delProtocols = this.supportProtocolMapper.selectKtonIpDynamicsAccountSupportProtocolList(checkEntity);
        if (protocols.size() > 0) {
            for (KtonIpDynamicsAccountSupportProtocol protocol : delProtocols) {
                this.supportProtocolMapper.deleteKtonIpDynamicsAccountSupportProtocolById(protocol.getId());
            }
        }
        int res = 0;
        for (String supportedProtocol : protocols) {
            KtonIpDynamicsAccountSupportProtocol protocol = new KtonIpDynamicsAccountSupportProtocol();
            protocol.setMerchantId(merchantId);
            protocol.setAccountId(accountId);
            protocol.setSupportedProtocol(supportedProtocol);
            protocol.setCreateTime(new Date());
            res = this.add(merchantId, protocol);
            this.resetProtocol(merchantId, accountId);
        }
        return res;
    }

    @Override
    public int remove(Long[] ids) {
        for (Long id : ids) {
            KtonIpDynamicsAccountSupportProtocol dynamicsAccountSupportProtocol = this.supportProtocolMapper.selectKtonIpDynamicsAccountSupportProtocolById(id);
            if (dynamicsAccountSupportProtocol == null) continue;

            Long merchantId = dynamicsAccountSupportProtocol.getMerchantId();
            Long accountId = dynamicsAccountSupportProtocol.getAccountId();

            KtonIpDynamicsAccountEndpoint endpointEntity = new KtonIpDynamicsAccountEndpoint();
            endpointEntity.setAccountId(accountId);
            endpointEntity.setMerchantId(merchantId);
            endpointEntity.setSupportedProtocol(dynamicsAccountSupportProtocol.getSupportedProtocol());

            // 【修复】添加泛型
            List<KtonIpDynamicsAccountEndpoint> endpoints = this.ktonIpDynamicsAccountEndpointMapper.selectKtonIpDynamicsAccountEndpointList(endpointEntity);
            if (endpoints.size() > 0) {
                KtonIpDynamicsAccountEndpoint endpoint = endpoints.get(0);
                this.ktonIpDynamicsAccountEndpointMapper.deleteKtonIpDynamicsAccountEndpointById(endpoint.getId());
            }
            this.resetProtocol(merchantId, accountId);
        }
        return this.supportProtocolMapper.deleteKtonIpDynamicsAccountSupportProtocolByIds(ids);
    }

    private void resetProtocol(Long merchantId, Long accountId) {
        AdminMrtchantIpSourceDTO sourceDTO = this.merchantSourceDao.merchantSource(merchantId, MerchantIpSourceConstants.IP_TYPE.dynamics.name());
        String sourceCode = IpSourceConstants.SOURCE_CODE.dataimpulse.name();
        if (sourceDTO != null) {
            sourceCode = sourceDTO.getSourceCode();
        }
        if (sourceCode.equals(IpSourceConstants.SOURCE_CODE.dataimpulse.name())) {
            KtonIpDynamicsAccountSupportProtocol entity = new KtonIpDynamicsAccountSupportProtocol();
            entity.setAccountId(accountId);
            // 【修复】添加泛型，解决报错
            List<KtonIpDynamicsAccountSupportProtocol> accountSupportProtocols = this.supportProtocolMapper.selectKtonIpDynamicsAccountSupportProtocolList(entity);
            if (accountSupportProtocols.size() > 0) {
                ArrayList<Protocols> initialList = new ArrayList<>();
                for (KtonIpDynamicsAccountSupportProtocol protocol : accountSupportProtocols) {
                    if (protocol.getSupportedProtocol().equals(Protocols.HTTP.getCode())) {
                        initialList.add(Protocols.HTTP);
                    }
                    if (protocol.getSupportedProtocol().equals(Protocols.SOCKS5.getCode())) {
                        initialList.add(Protocols.SOCKS5);
                    }
                }
                SetSupportedProtocolsResponse setAllowedIpResponse = this.dataimpulseSubUserApiService.setSupportedProtocols(accountId, initialList);
                log.info("setAllowedIpResponse = {}", setAllowedIpResponse);
            }
        }
    }
}