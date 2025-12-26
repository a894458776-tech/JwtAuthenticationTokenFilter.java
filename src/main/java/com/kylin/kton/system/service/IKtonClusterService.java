/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonCluster;
import java.util.List;

public interface IKtonClusterService {
    public KtonCluster selectKtonClusterById(Long var1);

    public List<KtonCluster> selectKtonClusterList(KtonCluster var1);

    public int insertKtonCluster(KtonCluster var1);

    public int updateKtonCluster(KtonCluster var1);

    public int deleteKtonClusterByIds(Long[] var1);

    public int deleteKtonClusterById(Long var1);
}

