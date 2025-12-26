/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonIpStaticSource;
import java.util.List;

public interface IKtonIpStaticSourceService {
    public KtonIpStaticSource selectKtonIpStaticSourceById(Long var1);

    public List<KtonIpStaticSource> selectKtonIpStaticSourceList(KtonIpStaticSource var1);

    public int insertKtonIpStaticSource(KtonIpStaticSource var1);

    public int updateKtonIpStaticSource(KtonIpStaticSource var1);

    public int deleteKtonIpStaticSourceByIds(Long[] var1);

    public int deleteKtonIpStaticSourceById(Long var1);
}

