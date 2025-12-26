/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonSource
 *  com.kylin.kton.system.service.impl.KtonSourceServiceImpl
 *  javax.annotation.Resource
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.admin.source.service.impl;

import com.kylin.kton.admin.ip.entity.vo.AdminWithOutMerchantlistSearchVO;
import com.kylin.kton.admin.source.mapper.AdminIpSourceDao;
import com.kylin.kton.admin.source.service.IpSourceService;
import com.kylin.kton.system.domain.KtonSource;
import com.kylin.kton.system.service.impl.KtonSourceServiceImpl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class IpSourceServiceImpl
extends KtonSourceServiceImpl
implements IpSourceService {
    @Resource
    AdminIpSourceDao adminIpSourceDao;

    @Override
    public List<KtonSource> withOutMerchantlist(AdminWithOutMerchantlistSearchVO searchVO) {
        return this.adminIpSourceDao.withOutMerchantlist(searchVO);
    }
}

