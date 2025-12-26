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
import com.kylin.kton.system.domain.KtonIpDynamicsAccount;
import com.kylin.kton.system.mapper.KtonIpDynamicsAccountMapper;
import com.kylin.kton.system.service.IKtonIpDynamicsAccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpDynamicsAccountServiceImpl
implements IKtonIpDynamicsAccountService {
    @Autowired
    private KtonIpDynamicsAccountMapper ktonIpDynamicsAccountMapper;

    @Override
    public KtonIpDynamicsAccount selectKtonIpDynamicsAccountById(Long id) {
        return this.ktonIpDynamicsAccountMapper.selectKtonIpDynamicsAccountById(id);
    }

    @Override
    public List<KtonIpDynamicsAccount> selectKtonIpDynamicsAccountList(KtonIpDynamicsAccount ktonIpDynamicsAccount) {
        return this.ktonIpDynamicsAccountMapper.selectKtonIpDynamicsAccountList(ktonIpDynamicsAccount);
    }

    @Override
    public int insertKtonIpDynamicsAccount(KtonIpDynamicsAccount ktonIpDynamicsAccount) {
        ktonIpDynamicsAccount.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsAccountMapper.insertKtonIpDynamicsAccount(ktonIpDynamicsAccount);
    }

    @Override
    public int updateKtonIpDynamicsAccount(KtonIpDynamicsAccount ktonIpDynamicsAccount) {
        ktonIpDynamicsAccount.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsAccountMapper.updateKtonIpDynamicsAccount(ktonIpDynamicsAccount);
    }

    @Override
    public int deleteKtonIpDynamicsAccountByIds(Long[] ids) {
        return this.ktonIpDynamicsAccountMapper.deleteKtonIpDynamicsAccountByIds(ids);
    }

    @Override
    public int deleteKtonIpDynamicsAccountById(Long id) {
        return this.ktonIpDynamicsAccountMapper.deleteKtonIpDynamicsAccountById(id);
    }
}

