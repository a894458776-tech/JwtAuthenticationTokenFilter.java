/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonMerchantConfig
 *  com.kylin.kton.system.service.impl.KtonMerchantConfigServiceImpl
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.client.merchant.config.service.impl;

import com.kylin.kton.client.merchant.config.mapper.ClientMerchantConfigDao;
import com.kylin.kton.client.merchant.config.service.ClientMerchantConfigService;
import com.kylin.kton.system.domain.KtonMerchantConfig;
import com.kylin.kton.system.service.impl.KtonMerchantConfigServiceImpl;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientMerchantConfigServiceImpl
extends KtonMerchantConfigServiceImpl
implements ClientMerchantConfigService {
    @Autowired
    private ClientMerchantConfigDao clientMerchantConfigDao;

    @Override
    public KtonMerchantConfig detail(Long merchantId) {
        KtonMerchantConfig ktonMerchantConfig = this.clientMerchantConfigDao.detail(merchantId);
        if (ktonMerchantConfig == null) {
            ktonMerchantConfig = new KtonMerchantConfig();
            ktonMerchantConfig.setMerchantId(merchantId);
            ktonMerchantConfig.setCreateTime(new Date());
            this.clientMerchantConfigDao.insertKtonMerchantConfig(ktonMerchantConfig);
        }
        return ktonMerchantConfig;
    }
}

