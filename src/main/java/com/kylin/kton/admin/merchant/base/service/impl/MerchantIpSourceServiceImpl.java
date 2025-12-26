/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.service.impl.KtonMerchantIpSourceServiceImpl
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.admin.merchant.base.service.impl;

import com.kylin.kton.admin.merchant.base.entity.dto.AdminMerchantSourceDTO;
import com.kylin.kton.admin.merchant.base.entity.vo.AdminMerchantSourceSearchVO;
import com.kylin.kton.admin.merchant.base.mapper.AdminMerchantSourceDao;
import com.kylin.kton.admin.merchant.base.service.MerchantIpSourceService;
import com.kylin.kton.system.service.impl.KtonMerchantIpSourceServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantIpSourceServiceImpl
extends KtonMerchantIpSourceServiceImpl
implements MerchantIpSourceService {
    @Autowired
    private AdminMerchantSourceDao adminMerchantSourceDao;

    @Override
    public List<AdminMerchantSourceDTO> list(AdminMerchantSourceSearchVO searchVO) {
        return this.adminMerchantSourceDao.list(searchVO);
    }
}

