/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonIpBase;
import java.util.List;

public interface IKtonIpBaseService {
    public KtonIpBase selectKtonIpBaseById(String var1);

    public List<KtonIpBase> selectKtonIpBaseList(KtonIpBase var1);

    public int insertKtonIpBase(KtonIpBase var1);

    public int updateKtonIpBase(KtonIpBase var1);

    public int deleteKtonIpBaseByIds(String[] var1);

    public int deleteKtonIpBaseById(String var1);
}

