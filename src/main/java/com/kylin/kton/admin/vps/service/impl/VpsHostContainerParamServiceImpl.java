/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.mapper.KtonVpsHostContainerParamMapper
 *  com.kylin.kton.system.service.impl.KtonVpsHostContainerParamServiceImpl
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.admin.vps.service.impl;

import com.kylin.kton.admin.vps.service.VpsHostContainerParamService;
import com.kylin.kton.system.mapper.KtonVpsHostContainerParamMapper;
import com.kylin.kton.system.service.impl.KtonVpsHostContainerParamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VpsHostContainerParamServiceImpl
extends KtonVpsHostContainerParamServiceImpl
implements VpsHostContainerParamService {
    @Autowired
    private KtonVpsHostContainerParamMapper ktonVpsHostContainerParamMapper;
}

