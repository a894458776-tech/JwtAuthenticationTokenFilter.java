/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpDynamicsConfigPeriod
 *  com.kylin.kton.system.service.IKtonIpDynamicsService
 */
package com.kylin.kton.client.ip.service;

import com.kylin.kton.client.ip.entity.dto.DynamicPlanConfigDTO;
import com.kylin.kton.client.ip.entity.vo.DynamicsConfListVO;
import com.kylin.kton.client.ip.entity.vo.DynamicsDaysConfigVO;
import com.kylin.kton.system.domain.KtonIpDynamicsConfigPeriod;
import com.kylin.kton.system.service.IKtonIpDynamicsService;
import java.util.List;

public interface ClientIpDynamicService
extends IKtonIpDynamicsService {
    public List<DynamicPlanConfigDTO> planConfig(DynamicsConfListVO var1);

    public List<DynamicPlanConfigDTO> planConfigWithOutAuth(DynamicsConfListVO var1);

    public List<KtonIpDynamicsConfigPeriod> dayConfig(DynamicsDaysConfigVO var1);

    public List<KtonIpDynamicsConfigPeriod> dayConfigWithOutAuth(DynamicsDaysConfigVO var1);
}

