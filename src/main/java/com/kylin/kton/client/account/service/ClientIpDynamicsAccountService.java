/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.service.IKtonIpDynamicsAccountService
 */
package com.kylin.kton.client.account.service;

import com.kylin.kton.client.account.entity.vo.AccountAddVO;
import com.kylin.kton.client.account.entity.vo.AccountEditVO;
import com.kylin.kton.system.service.IKtonIpDynamicsAccountService;

public interface ClientIpDynamicsAccountService
extends IKtonIpDynamicsAccountService {
    public int add(AccountAddVO var1);

    public int edit(AccountEditVO var1);

    public int remove(Long var1, Long[] var2);
}

