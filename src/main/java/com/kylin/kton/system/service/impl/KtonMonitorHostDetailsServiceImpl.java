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
import com.kylin.kton.system.domain.KtonMonitorHostDetails;
import com.kylin.kton.system.mapper.KtonMonitorHostDetailsMapper;
import com.kylin.kton.system.service.IKtonMonitorHostDetailsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonMonitorHostDetailsServiceImpl
implements IKtonMonitorHostDetailsService {
    @Autowired
    private KtonMonitorHostDetailsMapper ktonMonitorHostDetailsMapper;

    @Override
    public KtonMonitorHostDetails selectKtonMonitorHostDetailsByHostIp(String hostIp) {
        return this.ktonMonitorHostDetailsMapper.selectKtonMonitorHostDetailsByHostIp(hostIp);
    }

    @Override
    public List<KtonMonitorHostDetails> selectKtonMonitorHostDetailsList(KtonMonitorHostDetails ktonMonitorHostDetails) {
        return this.ktonMonitorHostDetailsMapper.selectKtonMonitorHostDetailsList(ktonMonitorHostDetails);
    }

    @Override
    public int insertKtonMonitorHostDetails(KtonMonitorHostDetails ktonMonitorHostDetails) {
        ktonMonitorHostDetails.setCreateTime(DateUtils.getNowDate());
        return this.ktonMonitorHostDetailsMapper.insertKtonMonitorHostDetails(ktonMonitorHostDetails);
    }

    @Override
    public int updateKtonMonitorHostDetails(KtonMonitorHostDetails ktonMonitorHostDetails) {
        return this.ktonMonitorHostDetailsMapper.updateKtonMonitorHostDetails(ktonMonitorHostDetails);
    }

    @Override
    public int deleteKtonMonitorHostDetailsByHostIps(String[] hostIps) {
        return this.ktonMonitorHostDetailsMapper.deleteKtonMonitorHostDetailsByHostIps(hostIps);
    }

    @Override
    public int deleteKtonMonitorHostDetailsByHostIp(String hostIp) {
        return this.ktonMonitorHostDetailsMapper.deleteKtonMonitorHostDetailsByHostIp(hostIp);
    }
}

