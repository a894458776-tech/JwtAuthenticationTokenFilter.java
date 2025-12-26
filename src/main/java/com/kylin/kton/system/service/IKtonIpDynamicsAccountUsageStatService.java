/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageStat;
import java.util.List;

public interface IKtonIpDynamicsAccountUsageStatService {
    public KtonIpDynamicsAccountUsageStat selectKtonIpDynamicsAccountUsageStatById(Long var1);

    public List<KtonIpDynamicsAccountUsageStat> selectKtonIpDynamicsAccountUsageStatList(KtonIpDynamicsAccountUsageStat var1);

    public int insertKtonIpDynamicsAccountUsageStat(KtonIpDynamicsAccountUsageStat var1);

    public int updateKtonIpDynamicsAccountUsageStat(KtonIpDynamicsAccountUsageStat var1);

    public int deleteKtonIpDynamicsAccountUsageStatByIds(Long[] var1);

    public int deleteKtonIpDynamicsAccountUsageStatById(Long var1);
}

