/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonIpDynamicsConfigPeriod;
import java.util.List;

public interface KtonIpDynamicsConfigPeriodMapper {
    public KtonIpDynamicsConfigPeriod selectKtonIpDynamicsConfigPeriodById(Long var1);

    public List<KtonIpDynamicsConfigPeriod> selectKtonIpDynamicsConfigPeriodList(KtonIpDynamicsConfigPeriod var1);

    public int insertKtonIpDynamicsConfigPeriod(KtonIpDynamicsConfigPeriod var1);

    public int updateKtonIpDynamicsConfigPeriod(KtonIpDynamicsConfigPeriod var1);

    public int deleteKtonIpDynamicsConfigPeriodById(Long var1);

    public int deleteKtonIpDynamicsConfigPeriodByIds(Long[] var1);
}

