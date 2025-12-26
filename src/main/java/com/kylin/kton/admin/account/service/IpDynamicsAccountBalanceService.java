/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountBalance
 *  com.kylin.kton.system.service.IKtonIpDynamicsAccountBalanceService
 */
package com.kylin.kton.admin.account.service;

import com.kylin.kton.admin.account.entity.vo.AccountBalanceSearchVO;
import com.kylin.kton.admin.account.entity.vo.BalanceAddVO;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountBalance;
import com.kylin.kton.system.service.IKtonIpDynamicsAccountBalanceService;
import java.util.List;

public interface IpDynamicsAccountBalanceService
extends IKtonIpDynamicsAccountBalanceService {
    public void listUnupdatedAccounts();

    public List<KtonIpDynamicsAccountBalance> list(AccountBalanceSearchVO var1);

    public AjaxResult addBalance(BalanceAddVO var1);
}

