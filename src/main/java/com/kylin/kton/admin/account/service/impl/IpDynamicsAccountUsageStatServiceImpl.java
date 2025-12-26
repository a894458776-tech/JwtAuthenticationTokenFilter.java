/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.service.impl.KtonIpDynamicsAccountUsageStatServiceImpl
 *  javax.annotation.Resource
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.admin.account.service.impl;

import com.kylin.kton.admin.account.entity.dto.AdminAccountStatDTO;
import com.kylin.kton.admin.account.entity.vo.AdminAccountStatSearchVO;
import com.kylin.kton.admin.account.mapper.AdminAccountUsageStatDao;
import com.kylin.kton.admin.account.service.IpDynamicsAccountUsageStatService;
import com.kylin.kton.system.service.impl.KtonIpDynamicsAccountUsageStatServiceImpl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class IpDynamicsAccountUsageStatServiceImpl
extends KtonIpDynamicsAccountUsageStatServiceImpl
implements IpDynamicsAccountUsageStatService {
    @Resource
    AdminAccountUsageStatDao adminAccountUsageStatDao;

    @Override
    public List<AdminAccountStatDTO> list(AdminAccountStatSearchVO searchVO) {
        return this.adminAccountUsageStatDao.list(searchVO);
    }
}

