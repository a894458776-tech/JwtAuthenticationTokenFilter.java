/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonIpDynamicsPlan;
import java.util.List;

public interface IKtonIpDynamicsPlanService {
    public KtonIpDynamicsPlan selectKtonIpDynamicsPlanById(Long var1);

    public List<KtonIpDynamicsPlan> selectKtonIpDynamicsPlanList(KtonIpDynamicsPlan var1);

    public int insertKtonIpDynamicsPlan(KtonIpDynamicsPlan var1);

    public int updateKtonIpDynamicsPlan(KtonIpDynamicsPlan var1);

    public int deleteKtonIpDynamicsPlanByIds(Long[] var1);

    public int deleteKtonIpDynamicsPlanById(Long var1);
}

