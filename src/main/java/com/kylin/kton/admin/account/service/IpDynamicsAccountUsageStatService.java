/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.service.IKtonIpDynamicsAccountUsageStatService
 */
package com.kylin.kton.admin.account.service;

import com.kylin.kton.admin.account.entity.dto.AdminAccountStatDTO;
import com.kylin.kton.admin.account.entity.vo.AdminAccountStatSearchVO;
import com.kylin.kton.system.service.IKtonIpDynamicsAccountUsageStatService;
import java.util.List;

public interface IpDynamicsAccountUsageStatService
extends IKtonIpDynamicsAccountUsageStatService {
    public List<AdminAccountStatDTO> list(AdminAccountStatSearchVO var1);
}

