/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonCluster
 *  com.kylin.kton.system.domain.KtonClusterStatisVps
 *  com.kylin.kton.system.mapper.KtonClusterMapper
 *  com.kylin.kton.system.mapper.KtonClusterStatisVpsMapper
 *  javax.annotation.Resource
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.stereotype.Component
 *  org.springframework.util.CollectionUtils
 */
package com.kylin.kton.admin.tasks;

import com.kylin.kton.admin.tasks.mapper.ClusterStatisMapper;
import com.kylin.kton.system.domain.KtonCluster;
import com.kylin.kton.system.domain.KtonClusterStatisVps;
import com.kylin.kton.system.mapper.KtonClusterMapper;
import com.kylin.kton.system.mapper.KtonClusterStatisVpsMapper;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class SyncClusterStatisTask {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(SyncClusterStatisTask.class);
    @Resource
    KtonClusterMapper ktonClusterMapper;
    @Resource
    KtonClusterStatisVpsMapper ktonClusterStatisVpsMapper;
    @Resource
    ClusterStatisMapper clusterStatisMapper;

    public void syncClusterStatis() {
        log.info("start sync cluster statis  ...");
        List<KtonCluster> clusterList = this.listCluster();
        if (CollectionUtils.isEmpty(clusterList)) {
            log.info("cluster is empty....");
            return;
        }
        for (KtonCluster cluster : clusterList) {
            this.addClusterStatis(cluster.getId());
        }
        log.info("finished sync cluster statis ...");
    }

    private List<KtonCluster> listCluster() {
        KtonCluster cluster = new KtonCluster();
        return this.ktonClusterMapper.selectKtonClusterList(cluster);
    }

    private void addClusterStatis(Long clusterId) {
        KtonClusterStatisVps statisVps = this.ktonClusterStatisVpsMapper.selectKtonClusterStatisVpsById(clusterId);
        Integer countUserIp = this.clusterStatisMapper.countUserIp(clusterId);
        Integer countHost = this.clusterStatisMapper.countHost(clusterId);
        Integer countContainer = this.clusterStatisMapper.countContainer(clusterId);
        Integer countIpTotal = this.clusterStatisMapper.countIp(clusterId);
        if (statisVps == null) {
            statisVps.setCountIpUsed(Long.valueOf(countUserIp.intValue()));
            statisVps.setCountHost(Long.valueOf(countHost.intValue()));
            statisVps.setCountContainer(Long.valueOf(countContainer.intValue()));
            statisVps.setCountIpTotal(Long.valueOf(countIpTotal.intValue()));
            statisVps.setCreateTime(new Date());
        } else {
            statisVps.setCountIpUsed(Long.valueOf(countUserIp.intValue()));
            statisVps.setCountHost(Long.valueOf(countUserIp.intValue()));
            statisVps.setCountContainer(Long.valueOf(countContainer.intValue()));
            statisVps.setCountIpTotal(Long.valueOf(countIpTotal.intValue()));
            statisVps.setUpdateTime(new Date());
            this.ktonClusterStatisVpsMapper.updateKtonClusterStatisVps(statisVps);
        }
    }

    @Generated
    public SyncClusterStatisTask() {
    }
}

