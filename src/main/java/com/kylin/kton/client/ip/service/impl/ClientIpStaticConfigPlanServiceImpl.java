/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticConfigPlan
 *  com.kylin.kton.system.mapper.KtonIpStaticConfigPlanMapper
 *  com.kylin.kton.system.service.impl.KtonIpStaticConfigPlanServiceImpl
 *  javax.annotation.Resource
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.BeanUtils
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.client.ip.service.impl;

import com.kylin.kton.client.ip.entity.vo.ConfNumListVO;
import com.kylin.kton.client.ip.service.ClientIpStaticConfigPlanService;
import com.kylin.kton.system.domain.KtonIpStaticConfigPlan;
import com.kylin.kton.system.mapper.KtonIpStaticConfigPlanMapper;
import com.kylin.kton.system.service.impl.KtonIpStaticConfigPlanServiceImpl;
import java.util.List;
import javax.annotation.Resource;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ClientIpStaticConfigPlanServiceImpl
extends KtonIpStaticConfigPlanServiceImpl
implements ClientIpStaticConfigPlanService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(ClientIpStaticConfigPlanServiceImpl.class);
    @Resource
    KtonIpStaticConfigPlanMapper ktonIpStaticConfigPlanMapper;

    @Override
    public List<KtonIpStaticConfigPlan> list(ConfNumListVO confNumListVO) {
        KtonIpStaticConfigPlan entity = new KtonIpStaticConfigPlan();
        BeanUtils.copyProperties((Object)confNumListVO, (Object)entity);
        return this.ktonIpStaticConfigPlanMapper.selectKtonIpStaticConfigPlanList(entity);
    }

    @Override
    public List<KtonIpStaticConfigPlan> listWithOutAuth(ConfNumListVO confNumListVO) {
        KtonIpStaticConfigPlan entity = new KtonIpStaticConfigPlan();
        BeanUtils.copyProperties((Object)confNumListVO, (Object)entity);
        return this.ktonIpStaticConfigPlanMapper.selectKtonIpStaticConfigPlanList(entity);
    }
}

