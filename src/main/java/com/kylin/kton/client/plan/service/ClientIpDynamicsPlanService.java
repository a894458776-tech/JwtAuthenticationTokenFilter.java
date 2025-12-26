/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.service.IKtonIpDynamicsPlanService
 */
package com.kylin.kton.client.plan.service;

import com.kylin.kton.system.service.IKtonIpDynamicsPlanService;
import java.math.BigDecimal;

public interface ClientIpDynamicsPlanService
extends IKtonIpDynamicsPlanService {
    public BigDecimal queryMainBalance();
}

