/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.constant.IpSourceConstants$SOURCE_CODE
 *  com.kylin.kton.common.constant.MerchantIpSourceConstants$IP_TYPE
 *  com.kylin.kton.system.domain.KtonMerchant
 *  com.kylin.kton.system.mapper.KtonMerchantMapper
 *  com.kylin.kton.system.service.impl.KtonMerchantServiceImpl
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.BeanUtils
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.client.merchant.base.service.impl;

import com.kylin.kton.client.merchant.base.entity.MerchantEditVO;
import com.kylin.kton.client.merchant.base.entity.dto.ClientMerchantSourceDTO;
import com.kylin.kton.client.merchant.base.entity.vo.MerchantSourceVO;
import com.kylin.kton.client.merchant.base.mapper.MerchantSourceDao;
import com.kylin.kton.client.merchant.base.service.ClientMerchantService;
import com.kylin.kton.common.constant.IpSourceConstants;
import com.kylin.kton.common.constant.MerchantIpSourceConstants;
import com.kylin.kton.system.domain.KtonMerchant;
import com.kylin.kton.system.mapper.KtonMerchantMapper;
import com.kylin.kton.system.service.impl.KtonMerchantServiceImpl;
import java.util.Date;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientMerchantServiceImpl
extends KtonMerchantServiceImpl
implements ClientMerchantService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(ClientMerchantServiceImpl.class);
    @Autowired
    KtonMerchantMapper merchantMapper;
    @Autowired
    MerchantSourceDao merchantSourceDao;

    @Override
    public int editMerchant(MerchantEditVO merchantEditVO) {
        KtonMerchant ktonMerchant = this.merchantMapper.selectKtonMerchantById(merchantEditVO.getId());
        BeanUtils.copyProperties((Object)merchantEditVO, (Object)ktonMerchant);
        ktonMerchant.setUpdateTime(new Date());
        this.merchantMapper.updateKtonMerchant(ktonMerchant);
        return 0;
    }

    @Override
    public ClientMerchantSourceDTO merchantSource(MerchantSourceVO sourceVO) {
        Long merchantId = sourceVO.getMerchantId();
        ClientMerchantSourceDTO clientMerchantSourceDTO = this.merchantSourceDao.merchantSource(merchantId, MerchantIpSourceConstants.IP_TYPE.dynamics.name());
        if (clientMerchantSourceDTO == null) {
            clientMerchantSourceDTO = new ClientMerchantSourceDTO();
            clientMerchantSourceDTO.setSourceCode(IpSourceConstants.SOURCE_CODE.dataimpulse.name());
        }
        return clientMerchantSourceDTO;
    }
}

