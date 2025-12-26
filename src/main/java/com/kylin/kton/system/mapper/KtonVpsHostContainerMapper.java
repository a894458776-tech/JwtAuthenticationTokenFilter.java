/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonVpsHostContainer;
import java.util.List;

public interface KtonVpsHostContainerMapper {
    public KtonVpsHostContainer selectKtonVpsHostContainerById(Long var1);

    public List<KtonVpsHostContainer> selectKtonVpsHostContainerList(KtonVpsHostContainer var1);

    public int insertKtonVpsHostContainer(KtonVpsHostContainer var1);

    public int updateKtonVpsHostContainer(KtonVpsHostContainer var1);

    public int deleteKtonVpsHostContainerById(Long var1);

    public int deleteKtonVpsHostContainerByIds(Long[] var1);
}

