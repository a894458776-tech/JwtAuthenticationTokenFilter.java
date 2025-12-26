/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonIpDynamicsItem;
import java.util.List;

public interface KtonIpDynamicsItemMapper {
    public KtonIpDynamicsItem selectKtonIpDynamicsItemById(Long var1);

    public List<KtonIpDynamicsItem> selectKtonIpDynamicsItemList(KtonIpDynamicsItem var1);

    public int insertKtonIpDynamicsItem(KtonIpDynamicsItem var1);

    public int updateKtonIpDynamicsItem(KtonIpDynamicsItem var1);

    public int deleteKtonIpDynamicsItemById(Long var1);

    public int deleteKtonIpDynamicsItemByIds(Long[] var1);
}

