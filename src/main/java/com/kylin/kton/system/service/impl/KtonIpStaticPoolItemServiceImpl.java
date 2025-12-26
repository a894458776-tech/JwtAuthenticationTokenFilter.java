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
import com.kylin.kton.system.domain.KtonIpStaticPoolItem;
import com.kylin.kton.system.mapper.KtonIpStaticPoolItemMapper;
import com.kylin.kton.system.service.IKtonIpStaticPoolItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpStaticPoolItemServiceImpl
implements IKtonIpStaticPoolItemService {
    @Autowired
    private KtonIpStaticPoolItemMapper ktonIpStaticPoolItemMapper;

    @Override
    public KtonIpStaticPoolItem selectKtonIpStaticPoolItemById(Long id) {
        return this.ktonIpStaticPoolItemMapper.selectKtonIpStaticPoolItemById(id);
    }

    @Override
    public List<KtonIpStaticPoolItem> selectKtonIpStaticPoolItemList(KtonIpStaticPoolItem ktonIpStaticPoolItem) {
        return this.ktonIpStaticPoolItemMapper.selectKtonIpStaticPoolItemList(ktonIpStaticPoolItem);
    }

    @Override
    public int insertKtonIpStaticPoolItem(KtonIpStaticPoolItem ktonIpStaticPoolItem) {
        ktonIpStaticPoolItem.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpStaticPoolItemMapper.insertKtonIpStaticPoolItem(ktonIpStaticPoolItem);
    }

    @Override
    public int updateKtonIpStaticPoolItem(KtonIpStaticPoolItem ktonIpStaticPoolItem) {
        ktonIpStaticPoolItem.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpStaticPoolItemMapper.updateKtonIpStaticPoolItem(ktonIpStaticPoolItem);
    }

    @Override
    public int deleteKtonIpStaticPoolItemByIds(Long[] ids) {
        return this.ktonIpStaticPoolItemMapper.deleteKtonIpStaticPoolItemByIds(ids);
    }

    @Override
    public int deleteKtonIpStaticPoolItemById(Long id) {
        return this.ktonIpStaticPoolItemMapper.deleteKtonIpStaticPoolItemById(id);
    }
}

