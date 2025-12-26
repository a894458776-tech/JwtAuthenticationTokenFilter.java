/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonIpStaticConfigPlan;
import java.util.List;

public interface IKtonIpStaticConfigPlanService {
    public KtonIpStaticConfigPlan selectKtonIpStaticConfigPlanById(Long var1);

    public List<KtonIpStaticConfigPlan> selectKtonIpStaticConfigPlanList(KtonIpStaticConfigPlan var1);

    public int insertKtonIpStaticConfigPlan(KtonIpStaticConfigPlan var1);

    public int updateKtonIpStaticConfigPlan(KtonIpStaticConfigPlan var1);

    public int deleteKtonIpStaticConfigPlanByIds(Long[] var1);

    public int deleteKtonIpStaticConfigPlanById(Long var1);
}

