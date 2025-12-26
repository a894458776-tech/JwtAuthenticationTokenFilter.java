/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageDetails
 *  com.kylin.kton.system.service.IKtonIpDynamicsAccountUsageDetailsService
 */
package com.kylin.kton.admin.account.service;

import com.kylin.kton.admin.account.entity.vo.AccountUsageDetailsSearchVO;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageDetails;
import com.kylin.kton.system.service.IKtonIpDynamicsAccountUsageDetailsService;
import java.util.List;

public interface IpDynamicsAccountUsageDetailsService
extends IKtonIpDynamicsAccountUsageDetailsService {
    public List<KtonIpDynamicsAccountUsageDetails> list(AccountUsageDetailsSearchVO var1);
}

