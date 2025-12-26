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
import com.kylin.kton.system.domain.KtonIpDynamicsItem;
import com.kylin.kton.system.mapper.KtonIpDynamicsItemMapper;
import com.kylin.kton.system.service.IKtonIpDynamicsItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpDynamicsItemServiceImpl
implements IKtonIpDynamicsItemService {
    @Autowired
    private KtonIpDynamicsItemMapper ktonIpDynamicsItemMapper;

    @Override
    public KtonIpDynamicsItem selectKtonIpDynamicsItemById(Long id) {
        return this.ktonIpDynamicsItemMapper.selectKtonIpDynamicsItemById(id);
    }

    @Override
    public List<KtonIpDynamicsItem> selectKtonIpDynamicsItemList(KtonIpDynamicsItem ktonIpDynamicsItem) {
        return this.ktonIpDynamicsItemMapper.selectKtonIpDynamicsItemList(ktonIpDynamicsItem);
    }

    @Override
    public int insertKtonIpDynamicsItem(KtonIpDynamicsItem ktonIpDynamicsItem) {
        ktonIpDynamicsItem.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsItemMapper.insertKtonIpDynamicsItem(ktonIpDynamicsItem);
    }

    @Override
    public int updateKtonIpDynamicsItem(KtonIpDynamicsItem ktonIpDynamicsItem) {
        ktonIpDynamicsItem.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsItemMapper.updateKtonIpDynamicsItem(ktonIpDynamicsItem);
    }

    @Override
    public int deleteKtonIpDynamicsItemByIds(Long[] ids) {
        return this.ktonIpDynamicsItemMapper.deleteKtonIpDynamicsItemByIds(ids);
    }

    @Override
    public int deleteKtonIpDynamicsItemById(Long id) {
        return this.ktonIpDynamicsItemMapper.deleteKtonIpDynamicsItemById(id);
    }
}

