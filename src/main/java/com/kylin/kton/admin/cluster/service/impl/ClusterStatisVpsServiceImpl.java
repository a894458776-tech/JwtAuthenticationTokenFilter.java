/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.mapper.KtonClusterStatisVpsMapper
 *  com.kylin.kton.system.service.impl.KtonClusterStatisVpsServiceImpl
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.admin.cluster.service.impl;

import com.kylin.kton.admin.cluster.service.ClusterStatisVpsService;
import com.kylin.kton.system.mapper.KtonClusterStatisVpsMapper;
import com.kylin.kton.system.service.impl.KtonClusterStatisVpsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClusterStatisVpsServiceImpl
extends KtonClusterStatisVpsServiceImpl
implements ClusterStatisVpsService {
    @Autowired
    private KtonClusterStatisVpsMapper ktonClusterStatisVpsMapper;
}

