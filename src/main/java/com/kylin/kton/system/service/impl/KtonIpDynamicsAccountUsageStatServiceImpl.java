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
import com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageStat;
import com.kylin.kton.system.mapper.KtonIpDynamicsAccountUsageStatMapper;
import com.kylin.kton.system.service.IKtonIpDynamicsAccountUsageStatService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpDynamicsAccountUsageStatServiceImpl
implements IKtonIpDynamicsAccountUsageStatService {
    @Autowired
    private KtonIpDynamicsAccountUsageStatMapper ktonIpDynamicsAccountUsageStatMapper;

    @Override
    public KtonIpDynamicsAccountUsageStat selectKtonIpDynamicsAccountUsageStatById(Long id) {
        return this.ktonIpDynamicsAccountUsageStatMapper.selectKtonIpDynamicsAccountUsageStatById(id);
    }

    @Override
    public List<KtonIpDynamicsAccountUsageStat> selectKtonIpDynamicsAccountUsageStatList(KtonIpDynamicsAccountUsageStat ktonIpDynamicsAccountUsageStat) {
        return this.ktonIpDynamicsAccountUsageStatMapper.selectKtonIpDynamicsAccountUsageStatList(ktonIpDynamicsAccountUsageStat);
    }

    @Override
    public int insertKtonIpDynamicsAccountUsageStat(KtonIpDynamicsAccountUsageStat ktonIpDynamicsAccountUsageStat) {
        ktonIpDynamicsAccountUsageStat.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsAccountUsageStatMapper.insertKtonIpDynamicsAccountUsageStat(ktonIpDynamicsAccountUsageStat);
    }

    @Override
    public int updateKtonIpDynamicsAccountUsageStat(KtonIpDynamicsAccountUsageStat ktonIpDynamicsAccountUsageStat) {
        ktonIpDynamicsAccountUsageStat.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsAccountUsageStatMapper.updateKtonIpDynamicsAccountUsageStat(ktonIpDynamicsAccountUsageStat);
    }

    @Override
    public int deleteKtonIpDynamicsAccountUsageStatByIds(Long[] ids) {
        return this.ktonIpDynamicsAccountUsageStatMapper.deleteKtonIpDynamicsAccountUsageStatByIds(ids);
    }

    @Override
    public int deleteKtonIpDynamicsAccountUsageStatById(Long id) {
        return this.ktonIpDynamicsAccountUsageStatMapper.deleteKtonIpDynamicsAccountUsageStatById(id);
    }
}

