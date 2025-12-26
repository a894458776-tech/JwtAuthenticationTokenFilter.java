/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonMerchantConfig
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.client.risk.service;

import com.kylin.kton.system.domain.KtonMerchantConfig;
import org.springframework.stereotype.Service;

@Service
public interface RiskService {
    public Boolean checkRisk(KtonMerchantConfig var1, String var2);

    public Boolean checkIpRisk(String var1);
}

