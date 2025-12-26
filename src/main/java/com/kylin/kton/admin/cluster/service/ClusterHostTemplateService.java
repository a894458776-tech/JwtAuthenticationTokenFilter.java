/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonClusterHostTemplate
 *  com.kylin.kton.system.service.IKtonClusterHostTemplateService
 */
package com.kylin.kton.admin.cluster.service;

import com.kylin.kton.system.domain.KtonClusterHostTemplate;
import com.kylin.kton.system.service.IKtonClusterHostTemplateService;

public interface ClusterHostTemplateService
extends IKtonClusterHostTemplateService {
    public Integer add(KtonClusterHostTemplate var1);
}

