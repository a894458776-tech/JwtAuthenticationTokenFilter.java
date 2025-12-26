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
import com.kylin.kton.system.domain.KtonCluster;
import com.kylin.kton.system.mapper.KtonClusterMapper;
import com.kylin.kton.system.service.IKtonClusterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonClusterServiceImpl
implements IKtonClusterService {
    @Autowired
    private KtonClusterMapper ktonClusterMapper;

    @Override
    public KtonCluster selectKtonClusterById(Long id) {
        return this.ktonClusterMapper.selectKtonClusterById(id);
    }

    @Override
    public List<KtonCluster> selectKtonClusterList(KtonCluster ktonCluster) {
        return this.ktonClusterMapper.selectKtonClusterList(ktonCluster);
    }

    @Override
    public int insertKtonCluster(KtonCluster ktonCluster) {
        ktonCluster.setCreateTime(DateUtils.getNowDate());
        return this.ktonClusterMapper.insertKtonCluster(ktonCluster);
    }

    @Override
    public int updateKtonCluster(KtonCluster ktonCluster) {
        ktonCluster.setUpdateTime(DateUtils.getNowDate());
        return this.ktonClusterMapper.updateKtonCluster(ktonCluster);
    }

    @Override
    public int deleteKtonClusterByIds(Long[] ids) {
        return this.ktonClusterMapper.deleteKtonClusterByIds(ids);
    }

    @Override
    public int deleteKtonClusterById(Long id) {
        return this.ktonClusterMapper.deleteKtonClusterById(id);
    }
}

