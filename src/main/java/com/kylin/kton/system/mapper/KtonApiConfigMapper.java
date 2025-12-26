/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonApiConfig;
import java.util.List;

public interface KtonApiConfigMapper {
    public KtonApiConfig selectKtonApiConfigByUserId(Long var1);

    public List<KtonApiConfig> selectKtonApiConfigList(KtonApiConfig var1);

    public int insertKtonApiConfig(KtonApiConfig var1);

    public int updateKtonApiConfig(KtonApiConfig var1);

    public int deleteKtonApiConfigByUserId(Long var1);

    public int deleteKtonApiConfigByUserIds(Long[] var1);
}

