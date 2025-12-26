/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonMonitorHostDetails;
import java.util.List;

public interface IKtonMonitorHostDetailsService {
    public KtonMonitorHostDetails selectKtonMonitorHostDetailsByHostIp(String var1);

    public List<KtonMonitorHostDetails> selectKtonMonitorHostDetailsList(KtonMonitorHostDetails var1);

    public int insertKtonMonitorHostDetails(KtonMonitorHostDetails var1);

    public int updateKtonMonitorHostDetails(KtonMonitorHostDetails var1);

    public int deleteKtonMonitorHostDetailsByHostIps(String[] var1);

    public int deleteKtonMonitorHostDetailsByHostIp(String var1);
}

