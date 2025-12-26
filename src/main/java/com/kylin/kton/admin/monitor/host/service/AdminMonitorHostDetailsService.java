/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonMonitorHostDetails
 *  com.kylin.kton.system.service.IKtonMonitorHostDetailsService
 */
package com.kylin.kton.admin.monitor.host.service;

import com.kylin.kton.admin.monitor.host.entity.vo.MonitorHostDetailsSearchVO;
import com.kylin.kton.system.domain.KtonMonitorHostDetails;
import com.kylin.kton.system.service.IKtonMonitorHostDetailsService;
import java.util.List;

public interface AdminMonitorHostDetailsService
extends IKtonMonitorHostDetailsService {
    public List<KtonMonitorHostDetails> list(MonitorHostDetailsSearchVO var1);
}

