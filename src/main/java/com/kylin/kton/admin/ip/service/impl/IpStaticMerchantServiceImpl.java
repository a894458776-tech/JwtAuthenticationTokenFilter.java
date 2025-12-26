/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.service.impl.KtonIpStaticMerchantServiceImpl
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.admin.ip.service.impl;

import com.kylin.kton.admin.ip.entity.dto.AdminIpStaticMerchantDTO;
import com.kylin.kton.admin.ip.entity.vo.AdminIpStaticMerchantSearchVO;
import com.kylin.kton.admin.ip.mapper.AdminIpStaticMerchantDao;
import com.kylin.kton.admin.ip.service.IpStaticMerchantService;
import com.kylin.kton.system.service.impl.KtonIpStaticMerchantServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IpStaticMerchantServiceImpl
extends KtonIpStaticMerchantServiceImpl
implements IpStaticMerchantService {
    @Autowired
    private AdminIpStaticMerchantDao adminIpStaticMerchantDao;

    @Override
    public List<AdminIpStaticMerchantDTO> list(AdminIpStaticMerchantSearchVO searchVO) {
        return this.adminIpStaticMerchantDao.list(searchVO);
    }
}

