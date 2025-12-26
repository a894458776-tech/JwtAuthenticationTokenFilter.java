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
import com.kylin.kton.system.domain.KtonIpStaticMerchant;
import com.kylin.kton.system.mapper.KtonIpStaticMerchantMapper;
import com.kylin.kton.system.service.IKtonIpStaticMerchantService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpStaticMerchantServiceImpl
implements IKtonIpStaticMerchantService {
    @Autowired
    private KtonIpStaticMerchantMapper ktonIpStaticMerchantMapper;

    @Override
    public KtonIpStaticMerchant selectKtonIpStaticMerchantById(Long id) {
        return this.ktonIpStaticMerchantMapper.selectKtonIpStaticMerchantById(id);
    }

    @Override
    public List<KtonIpStaticMerchant> selectKtonIpStaticMerchantList(KtonIpStaticMerchant ktonIpStaticMerchant) {
        return this.ktonIpStaticMerchantMapper.selectKtonIpStaticMerchantList(ktonIpStaticMerchant);
    }

    @Override
    public int insertKtonIpStaticMerchant(KtonIpStaticMerchant ktonIpStaticMerchant) {
        ktonIpStaticMerchant.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpStaticMerchantMapper.insertKtonIpStaticMerchant(ktonIpStaticMerchant);
    }

    @Override
    public int updateKtonIpStaticMerchant(KtonIpStaticMerchant ktonIpStaticMerchant) {
        ktonIpStaticMerchant.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpStaticMerchantMapper.updateKtonIpStaticMerchant(ktonIpStaticMerchant);
    }

    @Override
    public int deleteKtonIpStaticMerchantByIds(Long[] ids) {
        return this.ktonIpStaticMerchantMapper.deleteKtonIpStaticMerchantByIds(ids);
    }

    @Override
    public int deleteKtonIpStaticMerchantById(Long id) {
        return this.ktonIpStaticMerchantMapper.deleteKtonIpStaticMerchantById(id);
    }
}

