/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticConfigPeriod
 *  com.kylin.kton.system.service.impl.KtonIpStaticConfigPeriodServiceImpl
 *  javax.annotation.Resource
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.client.ip.service.impl;

import com.kylin.kton.client.ip.entity.vo.ConfDaysListVO;
import com.kylin.kton.client.ip.mapper.ClientStaticConfigPeriodDao;
import com.kylin.kton.client.ip.service.ClientIpStaticConfigPeriodService;
import com.kylin.kton.system.domain.KtonIpStaticConfigPeriod;
import com.kylin.kton.system.service.impl.KtonIpStaticConfigPeriodServiceImpl;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ClientIpStaticConfigPeriodServiceImpl
extends KtonIpStaticConfigPeriodServiceImpl
implements ClientIpStaticConfigPeriodService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(ClientIpStaticConfigPeriodServiceImpl.class);
    @Resource
    ClientStaticConfigPeriodDao clientStaticConfigPeriodDao;

    @Override
    public List<KtonIpStaticConfigPeriod> list(ConfDaysListVO confDaysListVO) {
        log.info("confDaysListVO \u5165\u53c2 ={}", (Object)confDaysListVO);
        List<KtonIpStaticConfigPeriod> list = this.clientStaticConfigPeriodDao.list(confDaysListVO);
        log.info("list  ={}", list);
        HashMap<Long, KtonIpStaticConfigPeriod> map = new HashMap<Long, KtonIpStaticConfigPeriod>();
        for (KtonIpStaticConfigPeriod period : list) {
            Long days = period.getDays();
            KtonIpStaticConfigPeriod existingPeriod = (KtonIpStaticConfigPeriod)map.get(days);
            if (existingPeriod != null && (period.getMerchantId() <= 0L || existingPeriod.getMerchantId() > 0L && period.getMerchantId() <= existingPeriod.getMerchantId())) continue;
            map.put(days, period);
        }
        ArrayList<KtonIpStaticConfigPeriod> uniqueList = new ArrayList<KtonIpStaticConfigPeriod>(map.values());
        uniqueList.sort(Comparator.comparing(KtonIpStaticConfigPeriod::getDays));
        log.info("uniqueList  ={}", list);
        return uniqueList;
    }

    @Override
    public List<KtonIpStaticConfigPeriod> listWithOutAuth(ConfDaysListVO confDaysListVO) {
        log.info("confDaysListVO \u5165\u53c2 ={}", (Object)confDaysListVO);
        List<KtonIpStaticConfigPeriod> list = this.clientStaticConfigPeriodDao.listWithOutAuth(confDaysListVO);
        log.info("list  ={}", list);
        HashMap<Long, KtonIpStaticConfigPeriod> map = new HashMap<Long, KtonIpStaticConfigPeriod>();
        for (KtonIpStaticConfigPeriod period : list) {
            Long days = period.getDays();
            KtonIpStaticConfigPeriod existingPeriod = (KtonIpStaticConfigPeriod)map.get(days);
            if (existingPeriod != null && (period.getMerchantId() <= 0L || existingPeriod.getMerchantId() > 0L && period.getMerchantId() <= existingPeriod.getMerchantId())) continue;
            map.put(days, period);
        }
        ArrayList<KtonIpStaticConfigPeriod> uniqueList = new ArrayList<KtonIpStaticConfigPeriod>(map.values());
        uniqueList.sort(Comparator.comparing(KtonIpStaticConfigPeriod::getDays));
        log.info("uniqueList  ={}", list);
        return uniqueList;
    }
}

