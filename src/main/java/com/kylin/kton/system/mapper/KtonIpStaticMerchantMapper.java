/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonIpStaticMerchant;
import java.util.List;

public interface KtonIpStaticMerchantMapper {
    public KtonIpStaticMerchant selectKtonIpStaticMerchantById(Long var1);

    public List<KtonIpStaticMerchant> selectKtonIpStaticMerchantList(KtonIpStaticMerchant var1);

    public int insertKtonIpStaticMerchant(KtonIpStaticMerchant var1);

    public int updateKtonIpStaticMerchant(KtonIpStaticMerchant var1);

    public int deleteKtonIpStaticMerchantById(Long var1);

    public int deleteKtonIpStaticMerchantByIds(Long[] var1);
}

