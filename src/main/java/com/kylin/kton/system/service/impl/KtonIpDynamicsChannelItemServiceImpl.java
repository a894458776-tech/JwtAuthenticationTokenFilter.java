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
import com.kylin.kton.system.domain.KtonIpDynamicsChannelItem;
import com.kylin.kton.system.mapper.KtonIpDynamicsChannelItemMapper;
import com.kylin.kton.system.service.IKtonIpDynamicsChannelItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpDynamicsChannelItemServiceImpl
implements IKtonIpDynamicsChannelItemService {
    @Autowired
    private KtonIpDynamicsChannelItemMapper ktonIpDynamicsChannelItemMapper;

    @Override
    public KtonIpDynamicsChannelItem selectKtonIpDynamicsChannelItemById(Long id) {
        return this.ktonIpDynamicsChannelItemMapper.selectKtonIpDynamicsChannelItemById(id);
    }

    @Override
    public List<KtonIpDynamicsChannelItem> selectKtonIpDynamicsChannelItemList(KtonIpDynamicsChannelItem ktonIpDynamicsChannelItem) {
        return this.ktonIpDynamicsChannelItemMapper.selectKtonIpDynamicsChannelItemList(ktonIpDynamicsChannelItem);
    }

    @Override
    public int insertKtonIpDynamicsChannelItem(KtonIpDynamicsChannelItem ktonIpDynamicsChannelItem) {
        ktonIpDynamicsChannelItem.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsChannelItemMapper.insertKtonIpDynamicsChannelItem(ktonIpDynamicsChannelItem);
    }

    @Override
    public int updateKtonIpDynamicsChannelItem(KtonIpDynamicsChannelItem ktonIpDynamicsChannelItem) {
        ktonIpDynamicsChannelItem.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsChannelItemMapper.updateKtonIpDynamicsChannelItem(ktonIpDynamicsChannelItem);
    }

    @Override
    public int deleteKtonIpDynamicsChannelItemByIds(Long[] ids) {
        return this.ktonIpDynamicsChannelItemMapper.deleteKtonIpDynamicsChannelItemByIds(ids);
    }

    @Override
    public int deleteKtonIpDynamicsChannelItemById(Long id) {
        return this.ktonIpDynamicsChannelItemMapper.deleteKtonIpDynamicsChannelItemById(id);
    }
}

