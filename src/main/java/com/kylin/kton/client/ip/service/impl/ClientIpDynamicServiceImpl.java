/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpDynamicsConfigPeriod
 *  com.kylin.kton.system.domain.KtonIpDynamicsConfigPlan
 *  com.kylin.kton.system.service.impl.KtonIpDynamicsServiceImpl
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.client.ip.service.impl;

import com.kylin.kton.client.ip.entity.dto.DynamicPlanConfigDTO;
import com.kylin.kton.client.ip.entity.vo.DynamicsConfListVO;
import com.kylin.kton.client.ip.entity.vo.DynamicsDaysConfigVO;
import com.kylin.kton.client.ip.mapper.ClientDynamicsConfigPeriodDao;
import com.kylin.kton.client.ip.mapper.ClientDynamicsDao;
import com.kylin.kton.client.ip.service.ClientIpDynamicService;
import com.kylin.kton.system.domain.KtonIpDynamicsConfigPeriod;
import com.kylin.kton.system.domain.KtonIpDynamicsConfigPlan;
import com.kylin.kton.system.service.impl.KtonIpDynamicsServiceImpl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientIpDynamicServiceImpl
extends KtonIpDynamicsServiceImpl
implements ClientIpDynamicService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(ClientIpDynamicServiceImpl.class);
    @Autowired
    ClientDynamicsDao clientDynamicsDao;
    @Autowired
    ClientDynamicsConfigPeriodDao clientDynamicsConfigPeriodDao;

    @Override
    public List<DynamicPlanConfigDTO> planConfig(DynamicsConfListVO confListVO) {
        List<DynamicPlanConfigDTO> list = this.clientDynamicsDao.planConfig(confListVO);
        log.info("list  ={}", list);
        HashMap<BigDecimal, DynamicPlanConfigDTO> map = new HashMap<BigDecimal, DynamicPlanConfigDTO>();
        for (DynamicPlanConfigDTO period : list) {
            BigDecimal capacity = period.getCapacity();
            DynamicPlanConfigDTO existingPeriod = (DynamicPlanConfigDTO)((Object)map.get(capacity));
            if (existingPeriod != null && (period.getMerchantId() <= 0L || existingPeriod.getMerchantId() > 0L && period.getMerchantId() <= existingPeriod.getMerchantId())) continue;
            map.put(capacity, period);
        }
        ArrayList<DynamicPlanConfigDTO> uniqueList = new ArrayList<DynamicPlanConfigDTO>(map.values());
        log.info("uniqueList  ={}", list);
        uniqueList.sort(Comparator.comparing(KtonIpDynamicsConfigPlan::getCapacity));
        return uniqueList;
    }

    @Override
    public List<DynamicPlanConfigDTO> planConfigWithOutAuth(DynamicsConfListVO confListVO) {
        List<DynamicPlanConfigDTO> list = this.clientDynamicsDao.planConfigWithOutAuth(confListVO);
        log.info("list  ={}", list);
        HashMap<BigDecimal, DynamicPlanConfigDTO> map = new HashMap<BigDecimal, DynamicPlanConfigDTO>();
        for (DynamicPlanConfigDTO period : list) {
            BigDecimal capacity = period.getCapacity();
            DynamicPlanConfigDTO existingPeriod = (DynamicPlanConfigDTO)((Object)map.get(capacity));
            if (existingPeriod != null && (period.getMerchantId() <= 0L || existingPeriod.getMerchantId() > 0L && period.getMerchantId() <= existingPeriod.getMerchantId())) continue;
            map.put(capacity, period);
        }
        ArrayList<DynamicPlanConfigDTO> uniqueList = new ArrayList<DynamicPlanConfigDTO>(map.values());
        log.info("uniqueList  ={}", list);
        uniqueList.sort(Comparator.comparing(KtonIpDynamicsConfigPlan::getCapacity));
        return uniqueList;
    }

    @Override
    public List<KtonIpDynamicsConfigPeriod> dayConfig(DynamicsDaysConfigVO daysConfigVO) {
        return this.clientDynamicsConfigPeriodDao.list(daysConfigVO);
    }

    @Override
    public List<KtonIpDynamicsConfigPeriod> dayConfigWithOutAuth(DynamicsDaysConfigVO daysConfigVO) {
        return this.clientDynamicsConfigPeriodDao.dayConfigWithOutAuth(daysConfigVO);
    }
}

