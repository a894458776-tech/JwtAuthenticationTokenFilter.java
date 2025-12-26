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
import com.kylin.kton.system.domain.KtonClusterStatisVps;
import com.kylin.kton.system.mapper.KtonClusterStatisVpsMapper;
import com.kylin.kton.system.service.IKtonClusterStatisVpsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonClusterStatisVpsServiceImpl
implements IKtonClusterStatisVpsService {
    @Autowired
    private KtonClusterStatisVpsMapper ktonClusterStatisVpsMapper;

    @Override
    public KtonClusterStatisVps selectKtonClusterStatisVpsById(Long id) {
        return this.ktonClusterStatisVpsMapper.selectKtonClusterStatisVpsById(id);
    }

    @Override
    public List<KtonClusterStatisVps> selectKtonClusterStatisVpsList(KtonClusterStatisVps ktonClusterStatisVps) {
        return this.ktonClusterStatisVpsMapper.selectKtonClusterStatisVpsList(ktonClusterStatisVps);
    }

    @Override
    public int insertKtonClusterStatisVps(KtonClusterStatisVps ktonClusterStatisVps) {
        ktonClusterStatisVps.setCreateTime(DateUtils.getNowDate());
        return this.ktonClusterStatisVpsMapper.insertKtonClusterStatisVps(ktonClusterStatisVps);
    }

    @Override
    public int updateKtonClusterStatisVps(KtonClusterStatisVps ktonClusterStatisVps) {
        ktonClusterStatisVps.setUpdateTime(DateUtils.getNowDate());
        return this.ktonClusterStatisVpsMapper.updateKtonClusterStatisVps(ktonClusterStatisVps);
    }

    @Override
    public int deleteKtonClusterStatisVpsByIds(Long[] ids) {
        return this.ktonClusterStatisVpsMapper.deleteKtonClusterStatisVpsByIds(ids);
    }

    @Override
    public int deleteKtonClusterStatisVpsById(Long id) {
        return this.ktonClusterStatisVpsMapper.deleteKtonClusterStatisVpsById(id);
    }
}

