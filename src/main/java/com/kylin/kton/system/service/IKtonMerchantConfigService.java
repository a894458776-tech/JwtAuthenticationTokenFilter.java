/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonMerchantConfig;
import java.util.List;

public interface IKtonMerchantConfigService {
    public KtonMerchantConfig selectKtonMerchantConfigByMerchantConfigId(Long var1);

    public List<KtonMerchantConfig> selectKtonMerchantConfigList(KtonMerchantConfig var1);

    public int insertKtonMerchantConfig(KtonMerchantConfig var1);

    public int updateKtonMerchantConfig(KtonMerchantConfig var1);

    public int deleteKtonMerchantConfigByMerchantConfigIds(Long[] var1);

    public int deleteKtonMerchantConfigByMerchantConfigId(Long var1);
}

