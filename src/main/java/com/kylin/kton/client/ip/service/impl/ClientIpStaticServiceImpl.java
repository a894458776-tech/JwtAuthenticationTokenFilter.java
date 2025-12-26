/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStatic
 *  com.kylin.kton.system.mapper.KtonIpStaticMapper
 *  com.kylin.kton.system.service.impl.KtonIpStaticServiceImpl
 *  javax.annotation.Resource
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.BeanUtils
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.client.ip.service.impl;

import com.kylin.kton.client.ip.entity.vo.ConfTypeListVO;
import com.kylin.kton.client.ip.service.ClientIpStaticService;
import com.kylin.kton.system.domain.KtonIpStatic;
import com.kylin.kton.system.mapper.KtonIpStaticMapper;
import com.kylin.kton.system.service.impl.KtonIpStaticServiceImpl;
import java.util.List;
import javax.annotation.Resource;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ClientIpStaticServiceImpl
extends KtonIpStaticServiceImpl
implements ClientIpStaticService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(ClientIpStaticServiceImpl.class);
    @Resource
    KtonIpStaticMapper ktonIpStaticMapper;

    @Override
    public List<KtonIpStatic> list(ConfTypeListVO listVO) {
        KtonIpStatic entity = new KtonIpStatic();
        BeanUtils.copyProperties((Object)listVO, (Object)entity);
        return this.ktonIpStaticMapper.selectKtonIpStaticList(entity);
    }
}

