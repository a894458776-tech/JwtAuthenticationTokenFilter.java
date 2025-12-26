/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.utils.DateUtils
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.system.service.impl;

import com.kylin.kton.common.utils.DateUtils;
import com.kylin.kton.system.domain.KtonIpDynamicsChannel;
import com.kylin.kton.system.mapper.KtonIpDynamicsChannelMapper;
import com.kylin.kton.system.service.IKtonIpDynamicsChannelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpDynamicsChannelServiceImpl
implements IKtonIpDynamicsChannelService {
    @Autowired
    private KtonIpDynamicsChannelMapper ktonIpDynamicsChannelMapper;

    @Override
    public KtonIpDynamicsChannel selectKtonIpDynamicsChannelById(Long id) {
        return this.ktonIpDynamicsChannelMapper.selectKtonIpDynamicsChannelById(id);
    }

    @Override
    public List<KtonIpDynamicsChannel> selectKtonIpDynamicsChannelList(KtonIpDynamicsChannel ktonIpDynamicsChannel) {
        return this.ktonIpDynamicsChannelMapper.selectKtonIpDynamicsChannelList(ktonIpDynamicsChannel);
    }

    @Override
    public int insertKtonIpDynamicsChannel(KtonIpDynamicsChannel ktonIpDynamicsChannel) {
        ktonIpDynamicsChannel.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsChannelMapper.insertKtonIpDynamicsChannel(ktonIpDynamicsChannel);
    }

    @Override
    public int updateKtonIpDynamicsChannel(KtonIpDynamicsChannel ktonIpDynamicsChannel) {
        ktonIpDynamicsChannel.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsChannelMapper.updateKtonIpDynamicsChannel(ktonIpDynamicsChannel);
    }

    @Override
    public int deleteKtonIpDynamicsChannelByIds(Long[] ids) {
        return this.ktonIpDynamicsChannelMapper.deleteKtonIpDynamicsChannelByIds(ids);
    }

    @Override
    public int deleteKtonIpDynamicsChannelById(Long id) {
        return this.ktonIpDynamicsChannelMapper.deleteKtonIpDynamicsChannelById(id);
    }
}

