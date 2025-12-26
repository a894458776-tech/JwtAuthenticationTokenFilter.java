/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.api.dataimpulse.service.DataImpulseSubUserApiService
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageDetails
 *  com.kylin.kton.system.mapper.KtonIpDynamicsAccountUsageDetailsMapper
 *  com.kylin.kton.system.service.impl.KtonIpDynamicsAccountUsageDetailsServiceImpl
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.BeanUtils
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.client.account.service.impl;

import com.kylin.kton.api.dataimpulse.service.DataImpulseSubUserApiService;
import com.kylin.kton.client.account.entity.vo.AccountUsageDetailsSearchVO;
import com.kylin.kton.client.account.service.ClientIpDynamicsAccountUsageDetailsService;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageDetails;
import com.kylin.kton.system.mapper.KtonIpDynamicsAccountUsageDetailsMapper;
import com.kylin.kton.system.service.impl.KtonIpDynamicsAccountUsageDetailsServiceImpl;
import java.util.List;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientIpDynamicsAccountUsageDetailsServiceImpl
extends KtonIpDynamicsAccountUsageDetailsServiceImpl
implements ClientIpDynamicsAccountUsageDetailsService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(ClientIpDynamicsAccountUsageDetailsServiceImpl.class);
    @Autowired
    KtonIpDynamicsAccountUsageDetailsMapper detailsMapper;
    @Autowired
    DataImpulseSubUserApiService dataimpulseSubUserApiService;

    @Override
    public List<KtonIpDynamicsAccountUsageDetails> list(AccountUsageDetailsSearchVO searchVO) {
        KtonIpDynamicsAccountUsageDetails entity = new KtonIpDynamicsAccountUsageDetails();
        BeanUtils.copyProperties((Object)searchVO, (Object)entity);
        List list = this.detailsMapper.selectKtonIpDynamicsAccountUsageDetailsList(entity);
        return list;
    }
}

