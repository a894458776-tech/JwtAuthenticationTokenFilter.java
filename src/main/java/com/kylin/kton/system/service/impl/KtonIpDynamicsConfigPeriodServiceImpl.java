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
import com.kylin.kton.system.domain.KtonIpDynamicsConfigPeriod;
import com.kylin.kton.system.mapper.KtonIpDynamicsConfigPeriodMapper;
import com.kylin.kton.system.service.IKtonIpDynamicsConfigPeriodService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpDynamicsConfigPeriodServiceImpl
implements IKtonIpDynamicsConfigPeriodService {
    @Autowired
    private KtonIpDynamicsConfigPeriodMapper ktonIpDynamicsConfigPeriodMapper;

    @Override
    public KtonIpDynamicsConfigPeriod selectKtonIpDynamicsConfigPeriodById(Long id) {
        return this.ktonIpDynamicsConfigPeriodMapper.selectKtonIpDynamicsConfigPeriodById(id);
    }

    @Override
    public List<KtonIpDynamicsConfigPeriod> selectKtonIpDynamicsConfigPeriodList(KtonIpDynamicsConfigPeriod ktonIpDynamicsConfigPeriod) {
        return this.ktonIpDynamicsConfigPeriodMapper.selectKtonIpDynamicsConfigPeriodList(ktonIpDynamicsConfigPeriod);
    }

    @Override
    public int insertKtonIpDynamicsConfigPeriod(KtonIpDynamicsConfigPeriod ktonIpDynamicsConfigPeriod) {
        ktonIpDynamicsConfigPeriod.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsConfigPeriodMapper.insertKtonIpDynamicsConfigPeriod(ktonIpDynamicsConfigPeriod);
    }

    @Override
    public int updateKtonIpDynamicsConfigPeriod(KtonIpDynamicsConfigPeriod ktonIpDynamicsConfigPeriod) {
        ktonIpDynamicsConfigPeriod.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsConfigPeriodMapper.updateKtonIpDynamicsConfigPeriod(ktonIpDynamicsConfigPeriod);
    }

    @Override
    public int deleteKtonIpDynamicsConfigPeriodByIds(Long[] ids) {
        return this.ktonIpDynamicsConfigPeriodMapper.deleteKtonIpDynamicsConfigPeriodByIds(ids);
    }

    @Override
    public int deleteKtonIpDynamicsConfigPeriodById(Long id) {
        return this.ktonIpDynamicsConfigPeriodMapper.deleteKtonIpDynamicsConfigPeriodById(id);
    }
}

