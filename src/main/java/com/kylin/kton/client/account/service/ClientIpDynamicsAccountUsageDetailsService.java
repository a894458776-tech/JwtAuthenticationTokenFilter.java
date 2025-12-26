/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageDetails
 *  com.kylin.kton.system.service.IKtonIpDynamicsAccountUsageDetailsService
 */
package com.kylin.kton.client.account.service;

import com.kylin.kton.client.account.entity.vo.AccountUsageDetailsSearchVO;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageDetails;
import com.kylin.kton.system.service.IKtonIpDynamicsAccountUsageDetailsService;
import java.util.List;

public interface ClientIpDynamicsAccountUsageDetailsService
extends IKtonIpDynamicsAccountUsageDetailsService {
    public List<KtonIpDynamicsAccountUsageDetails> list(AccountUsageDetailsSearchVO var1);
}

