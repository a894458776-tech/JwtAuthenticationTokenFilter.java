/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonClusterHostTemplate
 *  com.kylin.kton.system.mapper.KtonClusterHostTemplateMapper
 *  com.kylin.kton.system.service.impl.KtonClusterHostTemplateServiceImpl
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.admin.cluster.service.impl;

import com.kylin.kton.admin.cluster.service.ClusterHostTemplateService;
import com.kylin.kton.system.domain.KtonClusterHostTemplate;
import com.kylin.kton.system.mapper.KtonClusterHostTemplateMapper;
import com.kylin.kton.system.service.impl.KtonClusterHostTemplateServiceImpl;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClusterHostTemplateServiceImpl
extends KtonClusterHostTemplateServiceImpl
implements ClusterHostTemplateService {
    @Autowired
    private KtonClusterHostTemplateMapper ktonClusterHostTemplateMapper;

    @Override
    public Integer add(KtonClusterHostTemplate ktonClusterHostTemplate) {
        ktonClusterHostTemplate.setRefId(this.getRefId());
        ktonClusterHostTemplate.setCreateTime(new Date());
        return this.ktonClusterHostTemplateMapper.insertKtonClusterHostTemplate(ktonClusterHostTemplate);
    }

    private String getRefId() {
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString().replace("-", "");
        return uuidStr.substring(0, 32);
    }
}

