/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonIpStaticPool;
import java.util.List;

public interface IKtonIpStaticPoolService {
    public KtonIpStaticPool selectKtonIpStaticPoolById(Long var1);

    public List<KtonIpStaticPool> selectKtonIpStaticPoolList(KtonIpStaticPool var1);

    public int insertKtonIpStaticPool(KtonIpStaticPool var1);

    public int updateKtonIpStaticPool(KtonIpStaticPool var1);

    public int deleteKtonIpStaticPoolByIds(Long[] var1);

    public int deleteKtonIpStaticPoolById(Long var1);
}

