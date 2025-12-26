/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonMerchantConfig
 *  com.kylin.kton.system.service.IKtonMerchantConfigService
 */
package com.kylin.kton.client.merchant.config.service;

import com.kylin.kton.system.domain.KtonMerchantConfig;
import com.kylin.kton.system.service.IKtonMerchantConfigService;

public interface ClientMerchantConfigService
extends IKtonMerchantConfigService {
    public KtonMerchantConfig detail(Long var1);
}

