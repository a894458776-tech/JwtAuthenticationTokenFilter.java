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
import com.kylin.kton.system.domain.KtonIpDynamicsConfigPlan;
import com.kylin.kton.system.mapper.KtonIpDynamicsConfigPlanMapper;
import com.kylin.kton.system.service.IKtonIpDynamicsConfigPlanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpDynamicsConfigPlanServiceImpl
implements IKtonIpDynamicsConfigPlanService {
    @Autowired
    private KtonIpDynamicsConfigPlanMapper ktonIpDynamicsConfigPlanMapper;

    @Override
    public KtonIpDynamicsConfigPlan selectKtonIpDynamicsConfigPlanById(Long id) {
        return this.ktonIpDynamicsConfigPlanMapper.selectKtonIpDynamicsConfigPlanById(id);
    }

    @Override
    public List<KtonIpDynamicsConfigPlan> selectKtonIpDynamicsConfigPlanList(KtonIpDynamicsConfigPlan ktonIpDynamicsConfigPlan) {
        return this.ktonIpDynamicsConfigPlanMapper.selectKtonIpDynamicsConfigPlanList(ktonIpDynamicsConfigPlan);
    }

    @Override
    public int insertKtonIpDynamicsConfigPlan(KtonIpDynamicsConfigPlan ktonIpDynamicsConfigPlan) {
        ktonIpDynamicsConfigPlan.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsConfigPlanMapper.insertKtonIpDynamicsConfigPlan(ktonIpDynamicsConfigPlan);
    }

    @Override
    public int updateKtonIpDynamicsConfigPlan(KtonIpDynamicsConfigPlan ktonIpDynamicsConfigPlan) {
        ktonIpDynamicsConfigPlan.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsConfigPlanMapper.updateKtonIpDynamicsConfigPlan(ktonIpDynamicsConfigPlan);
    }

    @Override
    public int deleteKtonIpDynamicsConfigPlanByIds(Long[] ids) {
        return this.ktonIpDynamicsConfigPlanMapper.deleteKtonIpDynamicsConfigPlanByIds(ids);
    }

    @Override
    public int deleteKtonIpDynamicsConfigPlanById(Long id) {
        return this.ktonIpDynamicsConfigPlanMapper.deleteKtonIpDynamicsConfigPlanById(id);
    }
}

