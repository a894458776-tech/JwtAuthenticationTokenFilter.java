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
import com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageDetails;
import com.kylin.kton.system.mapper.KtonIpDynamicsAccountUsageDetailsMapper;
import com.kylin.kton.system.service.IKtonIpDynamicsAccountUsageDetailsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpDynamicsAccountUsageDetailsServiceImpl
implements IKtonIpDynamicsAccountUsageDetailsService {
    @Autowired
    private KtonIpDynamicsAccountUsageDetailsMapper ktonIpDynamicsAccountUsageDetailsMapper;

    @Override
    public KtonIpDynamicsAccountUsageDetails selectKtonIpDynamicsAccountUsageDetailsById(Long id) {
        return this.ktonIpDynamicsAccountUsageDetailsMapper.selectKtonIpDynamicsAccountUsageDetailsById(id);
    }

    @Override
    public List<KtonIpDynamicsAccountUsageDetails> selectKtonIpDynamicsAccountUsageDetailsList(KtonIpDynamicsAccountUsageDetails ktonIpDynamicsAccountUsageDetails) {
        return this.ktonIpDynamicsAccountUsageDetailsMapper.selectKtonIpDynamicsAccountUsageDetailsList(ktonIpDynamicsAccountUsageDetails);
    }

    @Override
    public int insertKtonIpDynamicsAccountUsageDetails(KtonIpDynamicsAccountUsageDetails ktonIpDynamicsAccountUsageDetails) {
        ktonIpDynamicsAccountUsageDetails.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsAccountUsageDetailsMapper.insertKtonIpDynamicsAccountUsageDetails(ktonIpDynamicsAccountUsageDetails);
    }

    @Override
    public int updateKtonIpDynamicsAccountUsageDetails(KtonIpDynamicsAccountUsageDetails ktonIpDynamicsAccountUsageDetails) {
        ktonIpDynamicsAccountUsageDetails.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsAccountUsageDetailsMapper.updateKtonIpDynamicsAccountUsageDetails(ktonIpDynamicsAccountUsageDetails);
    }

    @Override
    public int deleteKtonIpDynamicsAccountUsageDetailsByIds(Long[] ids) {
        return this.ktonIpDynamicsAccountUsageDetailsMapper.deleteKtonIpDynamicsAccountUsageDetailsByIds(ids);
    }

    @Override
    public int deleteKtonIpDynamicsAccountUsageDetailsById(Long id) {
        return this.ktonIpDynamicsAccountUsageDetailsMapper.deleteKtonIpDynamicsAccountUsageDetailsById(id);
    }
}

