package com.kylin.kton.client.account.service.impl;

import com.kylin.kton.api.dataimpulse.constant.Protocols;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetSupportedProtocolsResponse;
import com.kylin.kton.api.dataimpulse.service.DataImpulseSubUserApiService;
import com.kylin.kton.client.account.service.ClientIpDynamicsAccountEndpointService;
import com.kylin.kton.client.account.service.ClientIpDynamicsAccountSupportProtocolService;
import com.kylin.kton.client.merchant.base.entity.dto.ClientMerchantSourceDTO;
import com.kylin.kton.client.merchant.base.mapper.MerchantSourceDao;
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
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ClientIpDynamicsAccountSupportProtocolServiceImpl
        extends KtonIpDynamicsAccountSupportProtocolServiceImpl
        implements ClientIpDynamicsAccountSupportProtocolService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(ClientIpDynamicsAccountSupportProtocolServiceImpl.class);
    @Autowired
    KtonIpDynamicsAccountSupportProtocolMapper supportProtocolMapper;
    @Autowired
    DataImpulseSubUserApiService dataimpulseSubUserApiService;
    @Autowired
    KtonIpDynamicsAccountEndpointMapper ktonIpDynamicsAccountEndpointMapper;
    @Autowired
    ClientIpDynamicsAccountEndpointService clientIpDynamicsAccountEndpointService;
    @Autowired
    MerchantSourceDao merchantSourceDao;

    @Override
    public int add(Long merchantId, KtonIpDynamicsAccountSupportProtocol supportProtocol) {
        log.info("add protocols params =  {}", supportProtocol);
        KtonIpDynamicsAccountSupportProtocol checkEntity = new KtonIpDynamicsAccountSupportProtocol();
        checkEntity.setAccountId(supportProtocol.getAccountId());
        checkEntity.setSupportedProtocol(supportProtocol.getSupportedProtocol());
        List protocols = this.supportProtocolMapper.selectKtonIpDynamicsAccountSupportProtocolList(checkEntity);
        int res = 0;
        if (protocols.size() <= 0) {
            res = this.supportProtocolMapper.insertKtonIpDynamicsAccountSupportProtocol(supportProtocol);
            this.resetProtocol(merchantId, supportProtocol.getAccountId());
            this.clientIpDynamicsAccountEndpointService.addEndpoint(merchantId, supportProtocol.getAccountId(), supportProtocol.getSupportedProtocol());
        }
        return res;
    }

    @Override
    public int edit(List<String> protocols, Long accountId, Long merchantId) {
        KtonIpDynamicsAccountSupportProtocol checkEntity = new KtonIpDynamicsAccountSupportProtocol();
        checkEntity.setMerchantId(merchantId);
        checkEntity.setAccountId(merchantId);
        // 修复：添加泛型
        List<KtonIpDynamicsAccountSupportProtocol> existProtocols = supportProtocolMapper.selectKtonIpDynamicsAccountSupportProtocolList(checkEntity);
        List<String> existProtocolStrs = existProtocols.stream().map(KtonIpDynamicsAccountSupportProtocol::getSupportedProtocol).collect(Collectors.toList());

        List<String> addProtocols = protocols.stream().filter(item -> !existProtocolStrs.contains(item)).collect(Collectors.toList());
        List<String> delProtocols = existProtocolStrs.stream().filter(item -> !protocols.contains(item)).collect(Collectors.toList());

        if (!addProtocols.isEmpty()) {
            for (String p : addProtocols) {
                KtonIpDynamicsAccountSupportProtocol add = new KtonIpDynamicsAccountSupportProtocol();
                add.setAccountId(accountId);
                add.setMerchantId(merchantId);
                add.setSupportedProtocol(p);
                add.setCreateTime(new Date());
                this.add(merchantId, add);
            }
        }

        if (!delProtocols.isEmpty()) {
            // 修复：使用泛型 Map
            Map<String, List<KtonIpDynamicsAccountSupportProtocol>> map = existProtocols.stream()
                    .collect(Collectors.groupingBy(KtonIpDynamicsAccountSupportProtocol::getSupportedProtocol));

            List<Long> ids = new ArrayList<>();
            for (String p : delProtocols) {
                if (map.containsKey(p)) {
                    List<KtonIpDynamicsAccountSupportProtocol> list = map.get(p);
                    if (!list.isEmpty()) {
                        ids.add(list.get(0).getId());
                    }
                }
            }
            if (!ids.isEmpty()) {
                // 修复：使用 deleteKtonIpDynamicsAccountSupportProtocolByIds
                this.remove(ids.toArray(new Long[0]));
            }
        }

        // 重新 reset 协议
        this.resetProtocol(merchantId, accountId);
        return 1;
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

            // 修复：添加泛型
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
        ClientMerchantSourceDTO sourceDTO = this.merchantSourceDao.merchantSource(merchantId, MerchantIpSourceConstants.IP_TYPE.dynamics.name());
        String sourceCode = IpSourceConstants.SOURCE_CODE.dataimpulse.name();
        if (sourceDTO != null) {
            sourceCode = sourceDTO.getSourceCode();
        }
        if (sourceCode.equals(IpSourceConstants.SOURCE_CODE.dataimpulse.name())) {
            KtonIpDynamicsAccountSupportProtocol entity = new KtonIpDynamicsAccountSupportProtocol();
            entity.setAccountId(accountId);
            // 修复：添加泛型
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
                log.info("initialList = {}", initialList);
                SetSupportedProtocolsResponse setAllowedIpResponse = this.dataimpulseSubUserApiService.setSupportedProtocols(accountId, initialList);
                log.info("setAllowedIpResponse = {}", setAllowedIpResponse);
            }
        }
    }
}