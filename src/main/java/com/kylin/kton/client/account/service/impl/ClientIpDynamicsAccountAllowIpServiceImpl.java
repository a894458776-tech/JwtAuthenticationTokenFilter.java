/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.api.dataimpulse.entity.subuser.RemoveAllowedIpResponse
 *  com.kylin.kton.api.dataimpulse.entity.subuser.SetAllowedIpResponse
 *  com.kylin.kton.api.dataimpulse.service.DataImpulseSubUserApiService
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountAllowIp
 *  com.kylin.kton.system.mapper.KtonIpDynamicsAccountAllowIpMapper
 *  com.kylin.kton.system.service.impl.KtonIpDynamicsAccountAllowIpServiceImpl
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.client.account.service.impl;

import com.kylin.kton.api.dataimpulse.entity.subuser.RemoveAllowedIpResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetAllowedIpResponse;
import com.kylin.kton.api.dataimpulse.service.DataImpulseSubUserApiService;
import com.kylin.kton.client.account.service.ClientIpDynamicsAccountAllowIpService;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountAllowIp;
import com.kylin.kton.system.mapper.KtonIpDynamicsAccountAllowIpMapper;
import com.kylin.kton.system.service.impl.KtonIpDynamicsAccountAllowIpServiceImpl;
import java.util.List;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientIpDynamicsAccountAllowIpServiceImpl
extends KtonIpDynamicsAccountAllowIpServiceImpl
implements ClientIpDynamicsAccountAllowIpService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(ClientIpDynamicsAccountAllowIpServiceImpl.class);
    @Autowired
    KtonIpDynamicsAccountAllowIpMapper accountAllowIpMapper;
    @Autowired
    DataImpulseSubUserApiService dataimpulseSubUserApiService;

    @Override
    public int add(KtonIpDynamicsAccountAllowIp accountAllowIp) {
        KtonIpDynamicsAccountAllowIp entity = new KtonIpDynamicsAccountAllowIp();
        entity.setAccountId(accountAllowIp.getAccountId());
        entity.setIpAddress(accountAllowIp.getIpAddress());
        List ips = this.accountAllowIpMapper.selectKtonIpDynamicsAccountAllowIpList(entity);
        int res = 0;
        if (ips.size() <= 0) {
            res = this.accountAllowIpMapper.insertKtonIpDynamicsAccountAllowIp(accountAllowIp);
            Long accountId = accountAllowIp.getAccountId();
            SetAllowedIpResponse setAllowedIpResponse = this.dataimpulseSubUserApiService.setAllowedIp(accountId, accountAllowIp.getIpAddress());
            log.info("setAllowedIpResponse = {}", (Object)setAllowedIpResponse);
        }
        return res;
    }

    @Override
    public int del(Long id) {
        KtonIpDynamicsAccountAllowIp accountAllowIp = this.accountAllowIpMapper.selectKtonIpDynamicsAccountAllowIpById(id);
        Long accountId = accountAllowIp.getAccountId();
        RemoveAllowedIpResponse removeAllowedIpResponsee = this.dataimpulseSubUserApiService.removeAllowedIp(accountId, accountAllowIp.getIpAddress());
        log.info("removeAllowedIpResponsee = {}", (Object)removeAllowedIpResponsee);
        return this.accountAllowIpMapper.deleteKtonIpDynamicsAccountAllowIpById(id);
    }
}

