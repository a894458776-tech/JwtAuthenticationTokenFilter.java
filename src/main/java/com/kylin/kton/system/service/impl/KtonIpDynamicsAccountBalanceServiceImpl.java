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
import com.kylin.kton.system.domain.KtonIpDynamicsAccountBalance;
import com.kylin.kton.system.mapper.KtonIpDynamicsAccountBalanceMapper;
import com.kylin.kton.system.service.IKtonIpDynamicsAccountBalanceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpDynamicsAccountBalanceServiceImpl
implements IKtonIpDynamicsAccountBalanceService {
    @Autowired
    private KtonIpDynamicsAccountBalanceMapper ktonIpDynamicsAccountBalanceMapper;

    @Override
    public KtonIpDynamicsAccountBalance selectKtonIpDynamicsAccountBalanceById(Long id) {
        return this.ktonIpDynamicsAccountBalanceMapper.selectKtonIpDynamicsAccountBalanceById(id);
    }

    @Override
    public List<KtonIpDynamicsAccountBalance> selectKtonIpDynamicsAccountBalanceList(KtonIpDynamicsAccountBalance ktonIpDynamicsAccountBalance) {
        return this.ktonIpDynamicsAccountBalanceMapper.selectKtonIpDynamicsAccountBalanceList(ktonIpDynamicsAccountBalance);
    }

    @Override
    public int insertKtonIpDynamicsAccountBalance(KtonIpDynamicsAccountBalance ktonIpDynamicsAccountBalance) {
        ktonIpDynamicsAccountBalance.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsAccountBalanceMapper.insertKtonIpDynamicsAccountBalance(ktonIpDynamicsAccountBalance);
    }

    @Override
    public int updateKtonIpDynamicsAccountBalance(KtonIpDynamicsAccountBalance ktonIpDynamicsAccountBalance) {
        ktonIpDynamicsAccountBalance.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsAccountBalanceMapper.updateKtonIpDynamicsAccountBalance(ktonIpDynamicsAccountBalance);
    }

    @Override
    public int deleteKtonIpDynamicsAccountBalanceByIds(Long[] ids) {
        return this.ktonIpDynamicsAccountBalanceMapper.deleteKtonIpDynamicsAccountBalanceByIds(ids);
    }

    @Override
    public int deleteKtonIpDynamicsAccountBalanceById(Long id) {
        return this.ktonIpDynamicsAccountBalanceMapper.deleteKtonIpDynamicsAccountBalanceById(id);
    }
}

