/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticConfigPlan
 *  com.kylin.kton.system.service.IKtonIpStaticConfigPlanService
 */
package com.kylin.kton.client.ip.service;

import com.kylin.kton.client.ip.entity.vo.ConfNumListVO;
import com.kylin.kton.system.domain.KtonIpStaticConfigPlan;
import com.kylin.kton.system.service.IKtonIpStaticConfigPlanService;
import java.util.List;

public interface ClientIpStaticConfigPlanService
extends IKtonIpStaticConfigPlanService {
    public List<KtonIpStaticConfigPlan> list(ConfNumListVO var1);

    public List<KtonIpStaticConfigPlan> listWithOutAuth(ConfNumListVO var1);
}

