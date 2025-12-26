/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonIpStaticConfigPlan;
import java.util.List;

public interface KtonIpStaticConfigPlanMapper {
    public KtonIpStaticConfigPlan selectKtonIpStaticConfigPlanById(Long var1);

    public List<KtonIpStaticConfigPlan> selectKtonIpStaticConfigPlanList(KtonIpStaticConfigPlan var1);

    public int insertKtonIpStaticConfigPlan(KtonIpStaticConfigPlan var1);

    public int updateKtonIpStaticConfigPlan(KtonIpStaticConfigPlan var1);

    public int deleteKtonIpStaticConfigPlanById(Long var1);

    public int deleteKtonIpStaticConfigPlanByIds(Long[] var1);
}

