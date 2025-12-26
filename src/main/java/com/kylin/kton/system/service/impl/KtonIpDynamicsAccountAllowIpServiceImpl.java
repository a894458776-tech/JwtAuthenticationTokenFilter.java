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
import com.kylin.kton.system.domain.KtonIpDynamicsAccountAllowIp;
import com.kylin.kton.system.mapper.KtonIpDynamicsAccountAllowIpMapper;
import com.kylin.kton.system.service.IKtonIpDynamicsAccountAllowIpService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpDynamicsAccountAllowIpServiceImpl
implements IKtonIpDynamicsAccountAllowIpService {
    @Autowired
    private KtonIpDynamicsAccountAllowIpMapper ktonIpDynamicsAccountAllowIpMapper;

    @Override
    public KtonIpDynamicsAccountAllowIp selectKtonIpDynamicsAccountAllowIpById(Long id) {
        return this.ktonIpDynamicsAccountAllowIpMapper.selectKtonIpDynamicsAccountAllowIpById(id);
    }

    @Override
    public List<KtonIpDynamicsAccountAllowIp> selectKtonIpDynamicsAccountAllowIpList(KtonIpDynamicsAccountAllowIp ktonIpDynamicsAccountAllowIp) {
        return this.ktonIpDynamicsAccountAllowIpMapper.selectKtonIpDynamicsAccountAllowIpList(ktonIpDynamicsAccountAllowIp);
    }

    @Override
    public int insertKtonIpDynamicsAccountAllowIp(KtonIpDynamicsAccountAllowIp ktonIpDynamicsAccountAllowIp) {
        ktonIpDynamicsAccountAllowIp.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsAccountAllowIpMapper.insertKtonIpDynamicsAccountAllowIp(ktonIpDynamicsAccountAllowIp);
    }

    @Override
    public int updateKtonIpDynamicsAccountAllowIp(KtonIpDynamicsAccountAllowIp ktonIpDynamicsAccountAllowIp) {
        ktonIpDynamicsAccountAllowIp.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsAccountAllowIpMapper.updateKtonIpDynamicsAccountAllowIp(ktonIpDynamicsAccountAllowIp);
    }

    @Override
    public int deleteKtonIpDynamicsAccountAllowIpByIds(Long[] ids) {
        return this.ktonIpDynamicsAccountAllowIpMapper.deleteKtonIpDynamicsAccountAllowIpByIds(ids);
    }

    @Override
    public int deleteKtonIpDynamicsAccountAllowIpById(Long id) {
        return this.ktonIpDynamicsAccountAllowIpMapper.deleteKtonIpDynamicsAccountAllowIpById(id);
    }
}

