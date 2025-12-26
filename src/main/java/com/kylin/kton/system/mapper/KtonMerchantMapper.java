/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonMerchant;
import java.util.List;

public interface KtonMerchantMapper {
    public KtonMerchant selectKtonMerchantById(Long var1);

    public List<KtonMerchant> selectKtonMerchantList(KtonMerchant var1);

    public int insertKtonMerchant(KtonMerchant var1);

    public int updateKtonMerchant(KtonMerchant var1);

    public int deleteKtonMerchantById(Long var1);

    public int deleteKtonMerchantByIds(Long[] var1);
}

