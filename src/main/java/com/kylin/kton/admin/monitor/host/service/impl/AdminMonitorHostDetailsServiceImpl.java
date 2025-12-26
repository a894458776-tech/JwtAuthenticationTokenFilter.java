/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonMonitorHostDetails
 *  com.kylin.kton.system.service.impl.KtonMonitorHostDetailsServiceImpl
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.admin.monitor.host.service.impl;

import com.kylin.kton.admin.monitor.host.entity.vo.MonitorHostDetailsSearchVO;
import com.kylin.kton.admin.monitor.host.mapper.MonitorHostDetailsDao;
import com.kylin.kton.admin.monitor.host.service.AdminMonitorHostDetailsService;
import com.kylin.kton.system.domain.KtonMonitorHostDetails;
import com.kylin.kton.system.service.impl.KtonMonitorHostDetailsServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminMonitorHostDetailsServiceImpl
extends KtonMonitorHostDetailsServiceImpl
implements AdminMonitorHostDetailsService {
    @Autowired
    private MonitorHostDetailsDao monitorHostDetailsDao;

    @Override
    public List<KtonMonitorHostDetails> list(MonitorHostDetailsSearchVO searchVO) {
        return this.monitorHostDetailsDao.list(searchVO);
    }
}

