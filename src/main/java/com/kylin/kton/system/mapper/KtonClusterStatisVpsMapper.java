/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonClusterStatisVps;
import java.util.List;

public interface KtonClusterStatisVpsMapper {
    public KtonClusterStatisVps selectKtonClusterStatisVpsById(Long var1);

    public List<KtonClusterStatisVps> selectKtonClusterStatisVpsList(KtonClusterStatisVps var1);

    public int insertKtonClusterStatisVps(KtonClusterStatisVps var1);

    public int updateKtonClusterStatisVps(KtonClusterStatisVps var1);

    public int deleteKtonClusterStatisVpsById(Long var1);

    public int deleteKtonClusterStatisVpsByIds(Long[] var1);
}

