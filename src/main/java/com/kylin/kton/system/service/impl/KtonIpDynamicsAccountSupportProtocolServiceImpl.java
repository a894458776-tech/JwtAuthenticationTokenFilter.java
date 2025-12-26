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
import com.kylin.kton.system.domain.KtonIpDynamicsAccountSupportProtocol;
import com.kylin.kton.system.mapper.KtonIpDynamicsAccountSupportProtocolMapper;
import com.kylin.kton.system.service.IKtonIpDynamicsAccountSupportProtocolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpDynamicsAccountSupportProtocolServiceImpl
implements IKtonIpDynamicsAccountSupportProtocolService {
    @Autowired
    private KtonIpDynamicsAccountSupportProtocolMapper ktonIpDynamicsAccountSupportProtocolMapper;

    @Override
    public KtonIpDynamicsAccountSupportProtocol selectKtonIpDynamicsAccountSupportProtocolById(Long id) {
        return this.ktonIpDynamicsAccountSupportProtocolMapper.selectKtonIpDynamicsAccountSupportProtocolById(id);
    }

    @Override
    public List<KtonIpDynamicsAccountSupportProtocol> selectKtonIpDynamicsAccountSupportProtocolList(KtonIpDynamicsAccountSupportProtocol ktonIpDynamicsAccountSupportProtocol) {
        return this.ktonIpDynamicsAccountSupportProtocolMapper.selectKtonIpDynamicsAccountSupportProtocolList(ktonIpDynamicsAccountSupportProtocol);
    }

    @Override
    public int insertKtonIpDynamicsAccountSupportProtocol(KtonIpDynamicsAccountSupportProtocol ktonIpDynamicsAccountSupportProtocol) {
        ktonIpDynamicsAccountSupportProtocol.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsAccountSupportProtocolMapper.insertKtonIpDynamicsAccountSupportProtocol(ktonIpDynamicsAccountSupportProtocol);
    }

    @Override
    public int updateKtonIpDynamicsAccountSupportProtocol(KtonIpDynamicsAccountSupportProtocol ktonIpDynamicsAccountSupportProtocol) {
        ktonIpDynamicsAccountSupportProtocol.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsAccountSupportProtocolMapper.updateKtonIpDynamicsAccountSupportProtocol(ktonIpDynamicsAccountSupportProtocol);
    }

    @Override
    public int deleteKtonIpDynamicsAccountSupportProtocolByIds(Long[] ids) {
        return this.ktonIpDynamicsAccountSupportProtocolMapper.deleteKtonIpDynamicsAccountSupportProtocolByIds(ids);
    }

    @Override
    public int deleteKtonIpDynamicsAccountSupportProtocolById(Long id) {
        return this.ktonIpDynamicsAccountSupportProtocolMapper.deleteKtonIpDynamicsAccountSupportProtocolById(id);
    }
}

