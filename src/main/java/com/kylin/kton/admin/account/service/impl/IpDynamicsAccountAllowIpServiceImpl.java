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
package com.kylin.kton.admin.account.service.impl;

import com.kylin.kton.admin.account.service.IpDynamicsAccountAllowIpService;
import com.kylin.kton.api.dataimpulse.entity.subuser.RemoveAllowedIpResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetAllowedIpResponse;
import com.kylin.kton.api.dataimpulse.service.DataImpulseSubUserApiService;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountAllowIp;
import com.kylin.kton.system.mapper.KtonIpDynamicsAccountAllowIpMapper;
import com.kylin.kton.system.service.impl.KtonIpDynamicsAccountAllowIpServiceImpl;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IpDynamicsAccountAllowIpServiceImpl
extends KtonIpDynamicsAccountAllowIpServiceImpl
implements IpDynamicsAccountAllowIpService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(IpDynamicsAccountAllowIpServiceImpl.class);
    @Autowired
    KtonIpDynamicsAccountAllowIpMapper accountAllowIpMapper;
    @Autowired
    DataImpulseSubUserApiService dataimpulseSubUserApiService;

    @Override
    public int add(KtonIpDynamicsAccountAllowIp accountAllowIp) {
        int res = this.accountAllowIpMapper.insertKtonIpDynamicsAccountAllowIp(accountAllowIp);
        Long accountId = accountAllowIp.getAccountId();
        SetAllowedIpResponse setAllowedIpResponse = this.dataimpulseSubUserApiService.setAllowedIp(accountId, accountAllowIp.getIpAddress());
        log.info("setAllowedIpResponse = {}", (Object)setAllowedIpResponse);
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

