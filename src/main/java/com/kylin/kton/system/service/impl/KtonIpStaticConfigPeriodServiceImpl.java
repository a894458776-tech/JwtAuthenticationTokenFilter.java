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
import com.kylin.kton.system.domain.KtonIpStaticConfigPeriod;
import com.kylin.kton.system.mapper.KtonIpStaticConfigPeriodMapper;
import com.kylin.kton.system.service.IKtonIpStaticConfigPeriodService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpStaticConfigPeriodServiceImpl
implements IKtonIpStaticConfigPeriodService {
    @Autowired
    private KtonIpStaticConfigPeriodMapper ktonIpStaticConfigPeriodMapper;

    @Override
    public KtonIpStaticConfigPeriod selectKtonIpStaticConfigPeriodById(Long id) {
        return this.ktonIpStaticConfigPeriodMapper.selectKtonIpStaticConfigPeriodById(id);
    }

    @Override
    public List<KtonIpStaticConfigPeriod> selectKtonIpStaticConfigPeriodList(KtonIpStaticConfigPeriod ktonIpStaticConfigPeriod) {
        return this.ktonIpStaticConfigPeriodMapper.selectKtonIpStaticConfigPeriodList(ktonIpStaticConfigPeriod);
    }

    @Override
    public int insertKtonIpStaticConfigPeriod(KtonIpStaticConfigPeriod ktonIpStaticConfigPeriod) {
        ktonIpStaticConfigPeriod.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpStaticConfigPeriodMapper.insertKtonIpStaticConfigPeriod(ktonIpStaticConfigPeriod);
    }

    @Override
    public int updateKtonIpStaticConfigPeriod(KtonIpStaticConfigPeriod ktonIpStaticConfigPeriod) {
        ktonIpStaticConfigPeriod.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpStaticConfigPeriodMapper.updateKtonIpStaticConfigPeriod(ktonIpStaticConfigPeriod);
    }

    @Override
    public int deleteKtonIpStaticConfigPeriodByIds(Long[] ids) {
        return this.ktonIpStaticConfigPeriodMapper.deleteKtonIpStaticConfigPeriodByIds(ids);
    }

    @Override
    public int deleteKtonIpStaticConfigPeriodById(Long id) {
        return this.ktonIpStaticConfigPeriodMapper.deleteKtonIpStaticConfigPeriodById(id);
    }
}

