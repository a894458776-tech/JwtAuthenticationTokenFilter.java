/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticConfigPlan
 *  com.kylin.kton.system.service.impl.KtonIpStaticConfigPlanServiceImpl
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.admin.ip.service.impl;

import com.kylin.kton.admin.ip.entity.dto.AdminIpStaticConfigPlanDTO;
import com.kylin.kton.admin.ip.entity.vo.AdminIpStaticConfigPlanSearchVO;
import com.kylin.kton.admin.ip.mapper.AdminStaticConfigPlanDao;
import com.kylin.kton.admin.ip.service.IpStaticConfigPlanService;
import com.kylin.kton.system.domain.KtonIpStaticConfigPlan;
import com.kylin.kton.system.service.impl.KtonIpStaticConfigPlanServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IpStaticConfigPlanServiceImpl
extends KtonIpStaticConfigPlanServiceImpl
implements IpStaticConfigPlanService {
    @Autowired
    AdminStaticConfigPlanDao adminStaticConfigPlanDao;

    @Override
    public List<AdminIpStaticConfigPlanDTO> list(AdminIpStaticConfigPlanSearchVO searchVO) {
        return this.adminStaticConfigPlanDao.list(searchVO);
    }

    @Override
    public Integer add(KtonIpStaticConfigPlan plan) {
        String countryCode = plan.getCountryCode();
        Long ipType = plan.getIpType();
        Long isExclusive = plan.getIsExclusive();
        Long merchantId = plan.getMerchantId();
        KtonIpStaticConfigPlan res = this.adminStaticConfigPlanDao.checkConfig(countryCode, ipType, merchantId, isExclusive);
        if (res != null) {
            throw new RuntimeException("\u914d\u7f6e\u5df2\u5b58\u5728");
        }
        return this.adminStaticConfigPlanDao.insertKtonIpStaticConfigPlan(plan);
    }
}

