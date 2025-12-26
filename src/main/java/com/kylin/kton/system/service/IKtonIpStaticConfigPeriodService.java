/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonIpStaticConfigPeriod;
import java.util.List;

public interface IKtonIpStaticConfigPeriodService {
    public KtonIpStaticConfigPeriod selectKtonIpStaticConfigPeriodById(Long var1);

    public List<KtonIpStaticConfigPeriod> selectKtonIpStaticConfigPeriodList(KtonIpStaticConfigPeriod var1);

    public int insertKtonIpStaticConfigPeriod(KtonIpStaticConfigPeriod var1);

    public int updateKtonIpStaticConfigPeriod(KtonIpStaticConfigPeriod var1);

    public int deleteKtonIpStaticConfigPeriodByIds(Long[] var1);

    public int deleteKtonIpStaticConfigPeriodById(Long var1);
}

