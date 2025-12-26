/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonIpDetect;
import java.util.List;

public interface KtonIpDetectMapper {
    public KtonIpDetect selectKtonIpDetectById(String var1);

    public List<KtonIpDetect> selectKtonIpDetectList(KtonIpDetect var1);

    public int insertKtonIpDetect(KtonIpDetect var1);

    public int updateKtonIpDetect(KtonIpDetect var1);

    public int deleteKtonIpDetectById(String var1);

    public int deleteKtonIpDetectByIds(String[] var1);
}

