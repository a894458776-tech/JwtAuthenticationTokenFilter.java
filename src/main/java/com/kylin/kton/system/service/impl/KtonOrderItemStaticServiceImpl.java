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
import com.kylin.kton.system.domain.KtonOrderItemStatic;
import com.kylin.kton.system.mapper.KtonOrderItemStaticMapper;
import com.kylin.kton.system.service.IKtonOrderItemStaticService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonOrderItemStaticServiceImpl
implements IKtonOrderItemStaticService {
    @Autowired
    private KtonOrderItemStaticMapper ktonOrderItemStaticMapper;

    @Override
    public KtonOrderItemStatic selectKtonOrderItemStaticById(Long id) {
        return this.ktonOrderItemStaticMapper.selectKtonOrderItemStaticById(id);
    }

    @Override
    public List<KtonOrderItemStatic> selectKtonOrderItemStaticList(KtonOrderItemStatic ktonOrderItemStatic) {
        return this.ktonOrderItemStaticMapper.selectKtonOrderItemStaticList(ktonOrderItemStatic);
    }

    @Override
    public int insertKtonOrderItemStatic(KtonOrderItemStatic ktonOrderItemStatic) {
        ktonOrderItemStatic.setCreateTime(DateUtils.getNowDate());
        return this.ktonOrderItemStaticMapper.insertKtonOrderItemStatic(ktonOrderItemStatic);
    }

    @Override
    public int updateKtonOrderItemStatic(KtonOrderItemStatic ktonOrderItemStatic) {
        ktonOrderItemStatic.setUpdateTime(DateUtils.getNowDate());
        return this.ktonOrderItemStaticMapper.updateKtonOrderItemStatic(ktonOrderItemStatic);
    }

    @Override
    public int deleteKtonOrderItemStaticByIds(Long[] ids) {
        return this.ktonOrderItemStaticMapper.deleteKtonOrderItemStaticByIds(ids);
    }

    @Override
    public int deleteKtonOrderItemStaticById(Long id) {
        return this.ktonOrderItemStaticMapper.deleteKtonOrderItemStaticById(id);
    }
}

