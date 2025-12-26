/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticConfigPeriod
 *  com.kylin.kton.system.service.IKtonIpStaticConfigPeriodService
 */
package com.kylin.kton.client.ip.service;

import com.kylin.kton.client.ip.entity.vo.ConfDaysListVO;
import com.kylin.kton.system.domain.KtonIpStaticConfigPeriod;
import com.kylin.kton.system.service.IKtonIpStaticConfigPeriodService;
import java.util.List;

public interface ClientIpStaticConfigPeriodService
extends IKtonIpStaticConfigPeriodService {
    public List<KtonIpStaticConfigPeriod> list(ConfDaysListVO var1);

    public List<KtonIpStaticConfigPeriod> listWithOutAuth(ConfDaysListVO var1);
}

