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
import com.kylin.kton.system.domain.KtonIpStaticConfigPlan;
import com.kylin.kton.system.mapper.KtonIpStaticConfigPlanMapper;
import com.kylin.kton.system.service.IKtonIpStaticConfigPlanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpStaticConfigPlanServiceImpl
implements IKtonIpStaticConfigPlanService {
    @Autowired
    private KtonIpStaticConfigPlanMapper ktonIpStaticConfigPlanMapper;

    @Override
    public KtonIpStaticConfigPlan selectKtonIpStaticConfigPlanById(Long id) {
        return this.ktonIpStaticConfigPlanMapper.selectKtonIpStaticConfigPlanById(id);
    }

    @Override
    public List<KtonIpStaticConfigPlan> selectKtonIpStaticConfigPlanList(KtonIpStaticConfigPlan ktonIpStaticConfigPlan) {
        return this.ktonIpStaticConfigPlanMapper.selectKtonIpStaticConfigPlanList(ktonIpStaticConfigPlan);
    }

    @Override
    public int insertKtonIpStaticConfigPlan(KtonIpStaticConfigPlan ktonIpStaticConfigPlan) {
        ktonIpStaticConfigPlan.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpStaticConfigPlanMapper.insertKtonIpStaticConfigPlan(ktonIpStaticConfigPlan);
    }

    @Override
    public int updateKtonIpStaticConfigPlan(KtonIpStaticConfigPlan ktonIpStaticConfigPlan) {
        ktonIpStaticConfigPlan.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpStaticConfigPlanMapper.updateKtonIpStaticConfigPlan(ktonIpStaticConfigPlan);
    }

    @Override
    public int deleteKtonIpStaticConfigPlanByIds(Long[] ids) {
        return this.ktonIpStaticConfigPlanMapper.deleteKtonIpStaticConfigPlanByIds(ids);
    }

    @Override
    public int deleteKtonIpStaticConfigPlanById(Long id) {
        return this.ktonIpStaticConfigPlanMapper.deleteKtonIpStaticConfigPlanById(id);
    }
}

