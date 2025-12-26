/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageDetails;
import java.util.List;

public interface IKtonIpDynamicsAccountUsageDetailsService {
    public KtonIpDynamicsAccountUsageDetails selectKtonIpDynamicsAccountUsageDetailsById(Long var1);

    public List<KtonIpDynamicsAccountUsageDetails> selectKtonIpDynamicsAccountUsageDetailsList(KtonIpDynamicsAccountUsageDetails var1);

    public int insertKtonIpDynamicsAccountUsageDetails(KtonIpDynamicsAccountUsageDetails var1);

    public int updateKtonIpDynamicsAccountUsageDetails(KtonIpDynamicsAccountUsageDetails var1);

    public int deleteKtonIpDynamicsAccountUsageDetailsByIds(Long[] var1);

    public int deleteKtonIpDynamicsAccountUsageDetailsById(Long var1);
}

