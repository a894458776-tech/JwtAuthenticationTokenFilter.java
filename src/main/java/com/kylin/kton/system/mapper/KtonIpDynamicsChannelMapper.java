/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonIpDynamicsChannel;
import java.util.List;

public interface KtonIpDynamicsChannelMapper {
    public KtonIpDynamicsChannel selectKtonIpDynamicsChannelById(Long var1);

    public List<KtonIpDynamicsChannel> selectKtonIpDynamicsChannelList(KtonIpDynamicsChannel var1);

    public int insertKtonIpDynamicsChannel(KtonIpDynamicsChannel var1);

    public int updateKtonIpDynamicsChannel(KtonIpDynamicsChannel var1);

    public int deleteKtonIpDynamicsChannelById(Long var1);

    public int deleteKtonIpDynamicsChannelByIds(Long[] var1);
}

