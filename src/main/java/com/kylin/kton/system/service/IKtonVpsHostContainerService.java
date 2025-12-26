/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonVpsHostContainer;
import java.util.List;

public interface IKtonVpsHostContainerService {
    public KtonVpsHostContainer selectKtonVpsHostContainerById(Long var1);

    public List<KtonVpsHostContainer> selectKtonVpsHostContainerList(KtonVpsHostContainer var1);

    public int insertKtonVpsHostContainer(KtonVpsHostContainer var1);

    public int updateKtonVpsHostContainer(KtonVpsHostContainer var1);

    public int deleteKtonVpsHostContainerByIds(Long[] var1);

    public int deleteKtonVpsHostContainerById(Long var1);
}

