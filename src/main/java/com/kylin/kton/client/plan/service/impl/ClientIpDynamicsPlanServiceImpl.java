/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.api.dataimpulse.entity.subuser.MasterBalanceResponse
 *  com.kylin.kton.api.dataimpulse.service.DataImpulseSubUserApiService
 *  com.kylin.kton.system.service.impl.KtonIpDynamicsPlanServiceImpl
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.client.plan.service.impl;

import com.kylin.kton.api.dataimpulse.entity.subuser.MasterBalanceResponse;
import com.kylin.kton.api.dataimpulse.service.DataImpulseSubUserApiService;
import com.kylin.kton.client.plan.service.ClientIpDynamicsPlanService;
import com.kylin.kton.system.service.impl.KtonIpDynamicsPlanServiceImpl;
import java.math.BigDecimal;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientIpDynamicsPlanServiceImpl
extends KtonIpDynamicsPlanServiceImpl
implements ClientIpDynamicsPlanService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(ClientIpDynamicsPlanServiceImpl.class);
    @Autowired
    DataImpulseSubUserApiService dataimpulseSubUserApiService;

    @Override
    public BigDecimal queryMainBalance() {
        BigDecimal balance = new BigDecimal(0);
        MasterBalanceResponse response = this.dataimpulseSubUserApiService.queryMainBalance();
        log.info("queryMainBalance response balance = " + response.getBalance());
        return balance;
    }
}

