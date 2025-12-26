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
import com.kylin.kton.system.domain.KtonIpDynamicsPlan;
import com.kylin.kton.system.mapper.KtonIpDynamicsPlanMapper;
import com.kylin.kton.system.service.IKtonIpDynamicsPlanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpDynamicsPlanServiceImpl
implements IKtonIpDynamicsPlanService {
    @Autowired
    private KtonIpDynamicsPlanMapper ktonIpDynamicsPlanMapper;

    @Override
    public KtonIpDynamicsPlan selectKtonIpDynamicsPlanById(Long id) {
        return this.ktonIpDynamicsPlanMapper.selectKtonIpDynamicsPlanById(id);
    }

    @Override
    public List<KtonIpDynamicsPlan> selectKtonIpDynamicsPlanList(KtonIpDynamicsPlan ktonIpDynamicsPlan) {
        return this.ktonIpDynamicsPlanMapper.selectKtonIpDynamicsPlanList(ktonIpDynamicsPlan);
    }

    @Override
    public int insertKtonIpDynamicsPlan(KtonIpDynamicsPlan ktonIpDynamicsPlan) {
        ktonIpDynamicsPlan.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsPlanMapper.insertKtonIpDynamicsPlan(ktonIpDynamicsPlan);
    }

    @Override
    public int updateKtonIpDynamicsPlan(KtonIpDynamicsPlan ktonIpDynamicsPlan) {
        ktonIpDynamicsPlan.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsPlanMapper.updateKtonIpDynamicsPlan(ktonIpDynamicsPlan);
    }

    @Override
    public int deleteKtonIpDynamicsPlanByIds(Long[] ids) {
        return this.ktonIpDynamicsPlanMapper.deleteKtonIpDynamicsPlanByIds(ids);
    }

    @Override
    public int deleteKtonIpDynamicsPlanById(Long id) {
        return this.ktonIpDynamicsPlanMapper.deleteKtonIpDynamicsPlanById(id);
    }
}

