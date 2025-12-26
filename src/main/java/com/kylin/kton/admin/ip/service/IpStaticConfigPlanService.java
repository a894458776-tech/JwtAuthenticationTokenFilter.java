/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticConfigPlan
 *  com.kylin.kton.system.service.IKtonIpStaticConfigPlanService
 */
package com.kylin.kton.admin.ip.service;

import com.kylin.kton.admin.ip.entity.dto.AdminIpStaticConfigPlanDTO;
import com.kylin.kton.admin.ip.entity.vo.AdminIpStaticConfigPlanSearchVO;
import com.kylin.kton.system.domain.KtonIpStaticConfigPlan;
import com.kylin.kton.system.service.IKtonIpStaticConfigPlanService;
import java.util.List;

public interface IpStaticConfigPlanService
extends IKtonIpStaticConfigPlanService {
    public List<AdminIpStaticConfigPlanDTO> list(AdminIpStaticConfigPlanSearchVO var1);

    public Integer add(KtonIpStaticConfigPlan var1);
}

