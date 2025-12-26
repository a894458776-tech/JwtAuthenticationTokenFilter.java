/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonIpStaticDiscount;
import java.util.List;

public interface IKtonIpStaticDiscountService {
    public KtonIpStaticDiscount selectKtonIpStaticDiscountById(Long var1);

    public List<KtonIpStaticDiscount> selectKtonIpStaticDiscountList(KtonIpStaticDiscount var1);

    public int insertKtonIpStaticDiscount(KtonIpStaticDiscount var1);

    public int updateKtonIpStaticDiscount(KtonIpStaticDiscount var1);

    public int deleteKtonIpStaticDiscountByIds(Long[] var1);

    public int deleteKtonIpStaticDiscountById(Long var1);
}

