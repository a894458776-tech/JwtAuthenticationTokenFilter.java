/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.service.IKtonIpDynamicsAccountService
 */
package com.kylin.kton.admin.account.service;

import com.kylin.kton.admin.account.entity.dto.AdminIpDynamicsAccountDTO;
import com.kylin.kton.admin.account.entity.vo.AccountAddVO;
import com.kylin.kton.admin.account.entity.vo.AccountEditVO;
import com.kylin.kton.admin.account.entity.vo.AdminAccountSearchVO;
import com.kylin.kton.system.service.IKtonIpDynamicsAccountService;
import java.util.List;

public interface IpDynamicsAccountService
extends IKtonIpDynamicsAccountService {
    public List<AdminIpDynamicsAccountDTO> list(AdminAccountSearchVO var1);

    public int add(AccountAddVO var1);

    public int edit(AccountEditVO var1);

    public int remove(Long var1, Long[] var2);
}

