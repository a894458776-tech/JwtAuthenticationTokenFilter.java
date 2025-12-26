/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonVpsHostContainerParam;
import java.util.List;

public interface KtonVpsHostContainerParamMapper {
    public KtonVpsHostContainerParam selectKtonVpsHostContainerParamById(Long var1);

    public List<KtonVpsHostContainerParam> selectKtonVpsHostContainerParamList(KtonVpsHostContainerParam var1);

    public int insertKtonVpsHostContainerParam(KtonVpsHostContainerParam var1);

    public int updateKtonVpsHostContainerParam(KtonVpsHostContainerParam var1);

    public int deleteKtonVpsHostContainerParamById(Long var1);

    public int deleteKtonVpsHostContainerParamByIds(Long[] var1);
}

