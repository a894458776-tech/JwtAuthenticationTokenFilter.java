/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonSource;
import java.util.List;

public interface IKtonSourceService {
    public KtonSource selectKtonSourceById(Long var1);

    public List<KtonSource> selectKtonSourceList(KtonSource var1);

    public int insertKtonSource(KtonSource var1);

    public int updateKtonSource(KtonSource var1);

    public int deleteKtonSourceByIds(Long[] var1);

    public int deleteKtonSourceById(Long var1);
}

