/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonOrderItemDynamics;
import java.util.List;

public interface KtonOrderItemDynamicsMapper {
    public KtonOrderItemDynamics selectKtonOrderItemDynamicsById(Long var1);

    public List<KtonOrderItemDynamics> selectKtonOrderItemDynamicsList(KtonOrderItemDynamics var1);

    public int insertKtonOrderItemDynamics(KtonOrderItemDynamics var1);

    public int updateKtonOrderItemDynamics(KtonOrderItemDynamics var1);

    public int deleteKtonOrderItemDynamicsById(Long var1);

    public int deleteKtonOrderItemDynamicsByIds(Long[] var1);
}

