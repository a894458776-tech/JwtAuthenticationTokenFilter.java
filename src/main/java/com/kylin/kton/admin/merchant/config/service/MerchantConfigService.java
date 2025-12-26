/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonMerchantConfig
 *  com.kylin.kton.system.service.IKtonMerchantConfigService
 */
package com.kylin.kton.admin.merchant.config.service;

import com.kylin.kton.system.domain.KtonMerchantConfig;
import com.kylin.kton.system.service.IKtonMerchantConfigService;

public interface MerchantConfigService
extends IKtonMerchantConfigService {
    public KtonMerchantConfig detail(Long var1);
}

