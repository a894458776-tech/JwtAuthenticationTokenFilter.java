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
import com.kylin.kton.system.domain.KtonIpDynamics;
import com.kylin.kton.system.mapper.KtonIpDynamicsMapper;
import com.kylin.kton.system.service.IKtonIpDynamicsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpDynamicsServiceImpl
implements IKtonIpDynamicsService {
    @Autowired
    private KtonIpDynamicsMapper ktonIpDynamicsMapper;

    @Override
    public KtonIpDynamics selectKtonIpDynamicsById(Long id) {
        return this.ktonIpDynamicsMapper.selectKtonIpDynamicsById(id);
    }

    @Override
    public List<KtonIpDynamics> selectKtonIpDynamicsList(KtonIpDynamics ktonIpDynamics) {
        return this.ktonIpDynamicsMapper.selectKtonIpDynamicsList(ktonIpDynamics);
    }

    @Override
    public int insertKtonIpDynamics(KtonIpDynamics ktonIpDynamics) {
        ktonIpDynamics.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsMapper.insertKtonIpDynamics(ktonIpDynamics);
    }

    @Override
    public int updateKtonIpDynamics(KtonIpDynamics ktonIpDynamics) {
        ktonIpDynamics.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsMapper.updateKtonIpDynamics(ktonIpDynamics);
    }

    @Override
    public int deleteKtonIpDynamicsByIds(Long[] ids) {
        return this.ktonIpDynamicsMapper.deleteKtonIpDynamicsByIds(ids);
    }

    @Override
    public int deleteKtonIpDynamicsById(Long id) {
        return this.ktonIpDynamicsMapper.deleteKtonIpDynamicsById(id);
    }
}

