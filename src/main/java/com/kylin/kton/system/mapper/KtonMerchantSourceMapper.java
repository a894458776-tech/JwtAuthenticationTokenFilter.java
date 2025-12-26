/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonMerchantSource;
import java.util.List;

public interface KtonMerchantSourceMapper {
    public KtonMerchantSource selectKtonMerchantSourceById(Long var1);

    public List<KtonMerchantSource> selectKtonMerchantSourceList(KtonMerchantSource var1);

    public int insertKtonMerchantSource(KtonMerchantSource var1);

    public int updateKtonMerchantSource(KtonMerchantSource var1);

    public int deleteKtonMerchantSourceById(Long var1);

    public int deleteKtonMerchantSourceByIds(Long[] var1);
}

