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
import com.kylin.kton.system.domain.KtonOrderItemDynamics;
import com.kylin.kton.system.mapper.KtonOrderItemDynamicsMapper;
import com.kylin.kton.system.service.IKtonOrderItemDynamicsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonOrderItemDynamicsServiceImpl
implements IKtonOrderItemDynamicsService {
    @Autowired
    private KtonOrderItemDynamicsMapper ktonOrderItemDynamicsMapper;

    @Override
    public KtonOrderItemDynamics selectKtonOrderItemDynamicsById(Long id) {
        return this.ktonOrderItemDynamicsMapper.selectKtonOrderItemDynamicsById(id);
    }

    @Override
    public List<KtonOrderItemDynamics> selectKtonOrderItemDynamicsList(KtonOrderItemDynamics ktonOrderItemDynamics) {
        return this.ktonOrderItemDynamicsMapper.selectKtonOrderItemDynamicsList(ktonOrderItemDynamics);
    }

    @Override
    public int insertKtonOrderItemDynamics(KtonOrderItemDynamics ktonOrderItemDynamics) {
        ktonOrderItemDynamics.setCreateTime(DateUtils.getNowDate());
        return this.ktonOrderItemDynamicsMapper.insertKtonOrderItemDynamics(ktonOrderItemDynamics);
    }

    @Override
    public int updateKtonOrderItemDynamics(KtonOrderItemDynamics ktonOrderItemDynamics) {
        ktonOrderItemDynamics.setUpdateTime(DateUtils.getNowDate());
        return this.ktonOrderItemDynamicsMapper.updateKtonOrderItemDynamics(ktonOrderItemDynamics);
    }

    @Override
    public int deleteKtonOrderItemDynamicsByIds(Long[] ids) {
        return this.ktonOrderItemDynamicsMapper.deleteKtonOrderItemDynamicsByIds(ids);
    }

    @Override
    public int deleteKtonOrderItemDynamicsById(Long id) {
        return this.ktonOrderItemDynamicsMapper.deleteKtonOrderItemDynamicsById(id);
    }
}

