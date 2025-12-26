/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonIpDynamicsChannelItem;
import java.util.List;

public interface KtonIpDynamicsChannelItemMapper {
    public KtonIpDynamicsChannelItem selectKtonIpDynamicsChannelItemById(Long var1);

    public List<KtonIpDynamicsChannelItem> selectKtonIpDynamicsChannelItemList(KtonIpDynamicsChannelItem var1);

    public int insertKtonIpDynamicsChannelItem(KtonIpDynamicsChannelItem var1);

    public int updateKtonIpDynamicsChannelItem(KtonIpDynamicsChannelItem var1);

    public int deleteKtonIpDynamicsChannelItemById(Long var1);

    public int deleteKtonIpDynamicsChannelItemByIds(Long[] var1);
}

