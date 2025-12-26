/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonIpDynamicsConfigPlan;
import java.util.List;

public interface KtonIpDynamicsConfigPlanMapper {
    public KtonIpDynamicsConfigPlan selectKtonIpDynamicsConfigPlanById(Long var1);

    public List<KtonIpDynamicsConfigPlan> selectKtonIpDynamicsConfigPlanList(KtonIpDynamicsConfigPlan var1);

    public int insertKtonIpDynamicsConfigPlan(KtonIpDynamicsConfigPlan var1);

    public int updateKtonIpDynamicsConfigPlan(KtonIpDynamicsConfigPlan var1);

    public int deleteKtonIpDynamicsConfigPlanById(Long var1);

    public int deleteKtonIpDynamicsConfigPlanByIds(Long[] var1);
}

