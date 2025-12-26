/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonIpStaticPoolItem;
import java.util.List;

public interface IKtonIpStaticPoolItemService {
    public KtonIpStaticPoolItem selectKtonIpStaticPoolItemById(Long var1);

    public List<KtonIpStaticPoolItem> selectKtonIpStaticPoolItemList(KtonIpStaticPoolItem var1);

    public int insertKtonIpStaticPoolItem(KtonIpStaticPoolItem var1);

    public int updateKtonIpStaticPoolItem(KtonIpStaticPoolItem var1);

    public int deleteKtonIpStaticPoolItemByIds(Long[] var1);

    public int deleteKtonIpStaticPoolItemById(Long var1);
}

