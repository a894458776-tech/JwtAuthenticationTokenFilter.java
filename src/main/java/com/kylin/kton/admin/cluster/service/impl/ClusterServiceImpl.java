/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.mapper.KtonClusterMapper
 *  com.kylin.kton.system.service.impl.KtonClusterServiceImpl
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.admin.cluster.service.impl;

import com.kylin.kton.admin.cluster.service.ClusterService;
import com.kylin.kton.system.mapper.KtonClusterMapper;
import com.kylin.kton.system.service.impl.KtonClusterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClusterServiceImpl
extends KtonClusterServiceImpl
implements ClusterService {
    @Autowired
    private KtonClusterMapper ktonClusterMapper;
}

