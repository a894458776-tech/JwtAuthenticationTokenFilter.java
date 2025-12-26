/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonVpsHost;
import java.util.List;

public interface KtonVpsHostMapper {
    public KtonVpsHost selectKtonVpsHostById(Long var1);

    public List<KtonVpsHost> selectKtonVpsHostList(KtonVpsHost var1);

    public int insertKtonVpsHost(KtonVpsHost var1);

    public int updateKtonVpsHost(KtonVpsHost var1);

    public int deleteKtonVpsHostById(Long var1);

    public int deleteKtonVpsHostByIds(Long[] var1);
}

