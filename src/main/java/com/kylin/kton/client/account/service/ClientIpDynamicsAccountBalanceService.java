/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountBalance
 *  com.kylin.kton.system.service.IKtonIpDynamicsAccountBalanceService
 */
package com.kylin.kton.client.account.service;

import com.kylin.kton.client.account.entity.vo.AccountBalanceSearchVO;
import com.kylin.kton.client.account.entity.vo.BalanceAddVO;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountBalance;
import com.kylin.kton.system.service.IKtonIpDynamicsAccountBalanceService;
import java.util.List;

public interface ClientIpDynamicsAccountBalanceService
extends IKtonIpDynamicsAccountBalanceService {
    public List<KtonIpDynamicsAccountBalance> list(AccountBalanceSearchVO var1);

    public AjaxResult addBalance(BalanceAddVO var1);
}

