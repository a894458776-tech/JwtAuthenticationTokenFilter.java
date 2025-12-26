/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonIpStaticPrices;
import java.util.List;

public interface KtonIpStaticPricesMapper {
    public KtonIpStaticPrices selectKtonIpStaticPricesById(Long var1);

    public List<KtonIpStaticPrices> selectKtonIpStaticPricesList(KtonIpStaticPrices var1);

    public int insertKtonIpStaticPrices(KtonIpStaticPrices var1);

    public int updateKtonIpStaticPrices(KtonIpStaticPrices var1);

    public int deleteKtonIpStaticPricesById(Long var1);

    public int deleteKtonIpStaticPricesByIds(Long[] var1);
}

