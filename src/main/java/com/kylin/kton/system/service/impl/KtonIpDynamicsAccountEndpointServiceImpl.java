/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.utils.DateUtils
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.system.service.impl;

import com.kylin.kton.common.utils.DateUtils;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountEndpoint;
import com.kylin.kton.system.mapper.KtonIpDynamicsAccountEndpointMapper;
import com.kylin.kton.system.service.IKtonIpDynamicsAccountEndpointService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpDynamicsAccountEndpointServiceImpl
implements IKtonIpDynamicsAccountEndpointService {
    @Autowired
    private KtonIpDynamicsAccountEndpointMapper ktonIpDynamicsAccountEndpointMapper;

    @Override
    public KtonIpDynamicsAccountEndpoint selectKtonIpDynamicsAccountEndpointById(Long id) {
        return this.ktonIpDynamicsAccountEndpointMapper.selectKtonIpDynamicsAccountEndpointById(id);
    }

    @Override
    public List<KtonIpDynamicsAccountEndpoint> selectKtonIpDynamicsAccountEndpointList(KtonIpDynamicsAccountEndpoint ktonIpDynamicsAccountEndpoint) {
        return this.ktonIpDynamicsAccountEndpointMapper.selectKtonIpDynamicsAccountEndpointList(ktonIpDynamicsAccountEndpoint);
    }

    @Override
    public int insertKtonIpDynamicsAccountEndpoint(KtonIpDynamicsAccountEndpoint ktonIpDynamicsAccountEndpoint) {
        ktonIpDynamicsAccountEndpoint.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsAccountEndpointMapper.insertKtonIpDynamicsAccountEndpoint(ktonIpDynamicsAccountEndpoint);
    }

    @Override
    public int updateKtonIpDynamicsAccountEndpoint(KtonIpDynamicsAccountEndpoint ktonIpDynamicsAccountEndpoint) {
        ktonIpDynamicsAccountEndpoint.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsAccountEndpointMapper.updateKtonIpDynamicsAccountEndpoint(ktonIpDynamicsAccountEndpoint);
    }

    @Override
    public int deleteKtonIpDynamicsAccountEndpointByIds(Long[] ids) {
        return this.ktonIpDynamicsAccountEndpointMapper.deleteKtonIpDynamicsAccountEndpointByIds(ids);
    }

    @Override
    public int deleteKtonIpDynamicsAccountEndpointById(Long id) {
        return this.ktonIpDynamicsAccountEndpointMapper.deleteKtonIpDynamicsAccountEndpointById(id);
    }
}

