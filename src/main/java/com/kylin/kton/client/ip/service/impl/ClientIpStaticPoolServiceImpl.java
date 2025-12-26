/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticConfigPlan
 *  com.kylin.kton.system.service.impl.KtonIpStaticPoolServiceImpl
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.beans.factory.annotation.Value
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.client.ip.service.impl;

import com.kylin.kton.client.ip.entity.dto.ClientIpStaticPoolDTO;
import com.kylin.kton.client.ip.entity.dto.RegionalAvailableIpsDTO;
import com.kylin.kton.client.ip.entity.vo.ClientRegionalAvailableIpsVO;
import com.kylin.kton.client.ip.entity.vo.StaticPoolSearchVO;
import com.kylin.kton.client.ip.mapper.ClientStaticPoolDao;
import com.kylin.kton.client.ip.service.ClientIpStaticPoolService;
import com.kylin.kton.system.domain.KtonIpStaticConfigPlan;
import com.kylin.kton.system.service.impl.KtonIpStaticPoolServiceImpl;
import java.util.Iterator;
import java.util.List;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ClientIpStaticPoolServiceImpl
extends KtonIpStaticPoolServiceImpl
implements ClientIpStaticPoolService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(ClientIpStaticPoolServiceImpl.class);
    @Autowired
    ClientStaticPoolDao clientStaticPoolDao;
    @Value(value="${source.conf.assignTimes}")
    Integer assignTimes;

    @Override
    public List<ClientIpStaticPoolDTO> list(StaticPoolSearchVO vo) {
        Integer assignTimesParam = this.assignTimes;
        Long isExclusive = vo.getIsExclusive();
        if (isExclusive != null && isExclusive == 1L) {
            assignTimesParam = 0;
        }
        List<ClientIpStaticPoolDTO> list = this.clientStaticPoolDao.list(vo, assignTimesParam);
        Iterator<ClientIpStaticPoolDTO> iterator = list.iterator();
        while (iterator.hasNext()) {
            ClientIpStaticPoolDTO staticPoolDTO = iterator.next();
            List<KtonIpStaticConfigPlan> configPlans = this.clientStaticPoolDao.selectConfigPlans(staticPoolDTO.getCountryCode(), vo.getType(), vo.getMerchantId(), vo.getIsExclusive());
            staticPoolDTO.setConfigPlans(configPlans);
            if (configPlans != null && !configPlans.isEmpty()) continue;
            iterator.remove();
        }
        return list;
    }

    @Override
    public List<RegionalAvailableIpsDTO> regionalAvailableIps(ClientRegionalAvailableIpsVO vo) {
        Integer assignTimesParam = this.assignTimes;
        Long isExclusive = vo.getIsExclusive();
        if (isExclusive != null && isExclusive == 1L) {
            assignTimesParam = 0;
        }
        List<RegionalAvailableIpsDTO> list = this.clientStaticPoolDao.regionalAvailableIps(vo, assignTimesParam);
        Iterator<RegionalAvailableIpsDTO> iterator = list.iterator();
        while (iterator.hasNext()) {
            RegionalAvailableIpsDTO dto = iterator.next();
            KtonIpStaticConfigPlan configPlan = this.clientStaticPoolDao.selectConfigPlanPrice(dto.getCountryCode(), dto.getType(), vo.getMerchantId(), vo.getIsExclusive());
            if (configPlan != null) {
                dto.setPrice(configPlan.getPrice());
                continue;
            }
            iterator.remove();
        }
        return list;
    }
}

