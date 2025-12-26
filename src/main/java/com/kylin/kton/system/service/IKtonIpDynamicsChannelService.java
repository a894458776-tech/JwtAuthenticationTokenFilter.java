/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonIpDynamicsChannel;
import java.util.List;

public interface IKtonIpDynamicsChannelService {
    public KtonIpDynamicsChannel selectKtonIpDynamicsChannelById(Long var1);

    public List<KtonIpDynamicsChannel> selectKtonIpDynamicsChannelList(KtonIpDynamicsChannel var1);

    public int insertKtonIpDynamicsChannel(KtonIpDynamicsChannel var1);

    public int updateKtonIpDynamicsChannel(KtonIpDynamicsChannel var1);

    public int deleteKtonIpDynamicsChannelByIds(Long[] var1);

    public int deleteKtonIpDynamicsChannelById(Long var1);
}

