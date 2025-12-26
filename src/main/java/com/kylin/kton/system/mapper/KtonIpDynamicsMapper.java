/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonIpDynamics;
import java.util.List;

public interface KtonIpDynamicsMapper {
    public KtonIpDynamics selectKtonIpDynamicsById(Long var1);

    public List<KtonIpDynamics> selectKtonIpDynamicsList(KtonIpDynamics var1);

    public int insertKtonIpDynamics(KtonIpDynamics var1);

    public int updateKtonIpDynamics(KtonIpDynamics var1);

    public int deleteKtonIpDynamicsById(Long var1);

    public int deleteKtonIpDynamicsByIds(Long[] var1);
}

