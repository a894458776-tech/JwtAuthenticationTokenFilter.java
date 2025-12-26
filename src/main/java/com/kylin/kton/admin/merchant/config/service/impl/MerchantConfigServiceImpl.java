/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonMerchantConfig
 *  com.kylin.kton.system.service.impl.KtonMerchantConfigServiceImpl
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.admin.merchant.config.service.impl;

import com.kylin.kton.admin.merchant.config.mapper.AdminMerchantConfigDao;
import com.kylin.kton.admin.merchant.config.service.MerchantConfigService;
import com.kylin.kton.system.domain.KtonMerchantConfig;
import com.kylin.kton.system.service.impl.KtonMerchantConfigServiceImpl;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantConfigServiceImpl
extends KtonMerchantConfigServiceImpl
implements MerchantConfigService {
    @Autowired
    private AdminMerchantConfigDao adminMerchantConfigDao;

    @Override
    public KtonMerchantConfig detail(Long merchantId) {
        KtonMerchantConfig ktonMerchantConfig = this.adminMerchantConfigDao.detail(merchantId);
        if (ktonMerchantConfig == null) {
            ktonMerchantConfig = new KtonMerchantConfig();
            ktonMerchantConfig.setMerchantId(merchantId);
            ktonMerchantConfig.setCreateTime(new Date());
            this.adminMerchantConfigDao.insertKtonMerchantConfig(ktonMerchantConfig);
        }
        return ktonMerchantConfig;
    }
}

