/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.service.IKtonIpDynamicsAccountUsageStatService
 */
package com.kylin.kton.client.account.service;

import com.kylin.kton.client.account.entity.dto.ClientAccountStatDTO;
import com.kylin.kton.client.account.entity.vo.AccountStatSearchVO;
import com.kylin.kton.system.service.IKtonIpDynamicsAccountUsageStatService;
import java.util.List;

public interface ClientIpDynamicsAccountUsageStatService
extends IKtonIpDynamicsAccountUsageStatService {
    public List<ClientAccountStatDTO> list(AccountStatSearchVO var1);
}

