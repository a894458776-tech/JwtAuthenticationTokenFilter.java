/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.api.dataimpulse.constant.Protocols
 *  com.kylin.kton.api.dataimpulse.service.DataImpulseSubUserApiService
 *  com.kylin.kton.api.netnut.service.NetnutSubUserApiService
 *  com.kylin.kton.api.oxylabs.service.OxylabsSubUserApiService
 *  com.kylin.kton.common.constant.IpSourceConstants$SOURCE_CODE
 *  com.kylin.kton.common.constant.MerchantIpSourceConstants$IP_TYPE
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountEndpoint
 *  com.kylin.kton.system.mapper.KtonIpDynamicsAccountEndpointMapper
 *  com.kylin.kton.system.mapper.KtonIpDynamicsPlanMapper
 *  com.kylin.kton.system.service.impl.KtonIpDynamicsAccountEndpointServiceImpl
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.beans.factory.annotation.Value
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.admin.account.service.impl;

import com.kylin.kton.admin.account.mapper.AdminAccountDao;
import com.kylin.kton.admin.account.service.IpDynamicsAccountEndpointService;
import com.kylin.kton.admin.merchant.base.entity.dto.AdminMrtchantIpSourceDTO;
import com.kylin.kton.admin.merchant.base.mapper.AdminMerchantSourceDao;
import com.kylin.kton.api.dataimpulse.constant.Protocols;
import com.kylin.kton.api.dataimpulse.service.DataImpulseSubUserApiService;
import com.kylin.kton.api.netnut.service.NetnutSubUserApiService;
import com.kylin.kton.api.oxylabs.service.OxylabsSubUserApiService;
import com.kylin.kton.common.constant.IpSourceConstants;
import com.kylin.kton.common.constant.MerchantIpSourceConstants;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountEndpoint;
import com.kylin.kton.system.mapper.KtonIpDynamicsAccountEndpointMapper;
import com.kylin.kton.system.mapper.KtonIpDynamicsPlanMapper;
import com.kylin.kton.system.service.impl.KtonIpDynamicsAccountEndpointServiceImpl;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class IpDynamicsAccountEndpointServiceImpl
extends KtonIpDynamicsAccountEndpointServiceImpl
implements IpDynamicsAccountEndpointService {
    @Autowired
    AdminAccountDao adminAccountDao;
    @Autowired
    DataImpulseSubUserApiService dataimpulseSubUserApiService;
    @Autowired
    NetnutSubUserApiService netnutSubUserApiService;
    @Autowired
    OxylabsSubUserApiService oxylabsSubUserApiService;
    @Autowired
    KtonIpDynamicsAccountEndpointMapper endpointMapper;
    @Autowired
    AdminMerchantSourceDao adminMerchantSourceDao;
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
    public void addEndpoint(Long merchantId, Long accountId, String protocol) {
        KtonIpDynamicsAccountEndpoint checkEndpoint = new KtonIpDynamicsAccountEndpoint();
        checkEndpoint.setAccountId(accountId);
        checkEndpoint.setSupportedProtocol(protocol);
        checkEndpoint.setMerchantId(merchantId);
        List endpoints = this.endpointMapper.selectKtonIpDynamicsAccountEndpointList(checkEndpoint);
        if (endpoints.size() <= 0) {
            AdminMrtchantIpSourceDTO sourceDTO = this.adminMerchantSourceDao.merchantSource(merchantId, MerchantIpSourceConstants.IP_TYPE.dynamics.name());
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
    }
}

