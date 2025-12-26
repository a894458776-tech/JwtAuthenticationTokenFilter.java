/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonIpStaticSource;
import java.util.List;

public interface KtonIpStaticSourceMapper {
    public KtonIpStaticSource selectKtonIpStaticSourceById(Long var1);

    public List<KtonIpStaticSource> selectKtonIpStaticSourceList(KtonIpStaticSource var1);

    public int insertKtonIpStaticSource(KtonIpStaticSource var1);

    public int updateKtonIpStaticSource(KtonIpStaticSource var1);

    public int deleteKtonIpStaticSourceById(Long var1);

    public int deleteKtonIpStaticSourceByIds(Long[] var1);
}

