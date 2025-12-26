/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonMerchantIpSource;
import java.util.List;

public interface KtonMerchantIpSourceMapper {
    public KtonMerchantIpSource selectKtonMerchantIpSourceById(Long var1);

    public List<KtonMerchantIpSource> selectKtonMerchantIpSourceList(KtonMerchantIpSource var1);

    public int insertKtonMerchantIpSource(KtonMerchantIpSource var1);

    public int updateKtonMerchantIpSource(KtonMerchantIpSource var1);

    public int deleteKtonMerchantIpSourceById(Long var1);

    public int deleteKtonMerchantIpSourceByIds(Long[] var1);
}

