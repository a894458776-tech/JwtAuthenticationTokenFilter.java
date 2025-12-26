/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonIpStatic;
import java.util.List;

public interface KtonIpStaticMapper {
    public KtonIpStatic selectKtonIpStaticById(Long var1);

    public List<KtonIpStatic> selectKtonIpStaticList(KtonIpStatic var1);

    public int insertKtonIpStatic(KtonIpStatic var1);

    public int updateKtonIpStatic(KtonIpStatic var1);

    public int deleteKtonIpStaticById(Long var1);

    public int deleteKtonIpStaticByIds(Long[] var1);
}

