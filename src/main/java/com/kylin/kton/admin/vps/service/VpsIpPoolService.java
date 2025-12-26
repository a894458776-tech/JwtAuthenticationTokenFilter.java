/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.service.IKtonVpsIpPoolService
 */
package com.kylin.kton.admin.vps.service;

import com.kylin.kton.admin.vps.entity.vo.VpsIpPoolAddVO;
import com.kylin.kton.system.service.IKtonVpsIpPoolService;

public interface VpsIpPoolService
extends IKtonVpsIpPoolService {
    public Integer add(VpsIpPoolAddVO var1);
}

