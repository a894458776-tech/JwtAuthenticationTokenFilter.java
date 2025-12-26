/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.service.impl.KtonIpDynamicsAccountUsageStatServiceImpl
 *  javax.annotation.Resource
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.client.account.service.impl;

import com.kylin.kton.client.account.entity.dto.ClientAccountStatDTO;
import com.kylin.kton.client.account.entity.vo.AccountStatSearchVO;
import com.kylin.kton.client.account.mapper.ClientAccountUsageStatDao;
import com.kylin.kton.client.account.service.ClientIpDynamicsAccountUsageStatService;
import com.kylin.kton.system.service.impl.KtonIpDynamicsAccountUsageStatServiceImpl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ClientIpDynamicsAccountUsageStatServiceImpl
extends KtonIpDynamicsAccountUsageStatServiceImpl
implements ClientIpDynamicsAccountUsageStatService {
    @Resource
    ClientAccountUsageStatDao clientAccountUsageStatDao;

    @Override
    public List<ClientAccountStatDTO> list(AccountStatSearchVO searchVO) {
        return this.clientAccountUsageStatDao.list(searchVO);
    }
}

