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
import com.kylin.kton.system.domain.KtonMerchant;
import com.kylin.kton.system.mapper.KtonMerchantMapper;
import com.kylin.kton.system.service.IKtonMerchantService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonMerchantServiceImpl
implements IKtonMerchantService {
    @Autowired
    private KtonMerchantMapper ktonMerchantMapper;

    @Override
    public KtonMerchant selectKtonMerchantById(Long id) {
        return this.ktonMerchantMapper.selectKtonMerchantById(id);
    }

    @Override
    public List<KtonMerchant> selectKtonMerchantList(KtonMerchant ktonMerchant) {
        return this.ktonMerchantMapper.selectKtonMerchantList(ktonMerchant);
    }

    @Override
    public int insertKtonMerchant(KtonMerchant ktonMerchant) {
        ktonMerchant.setCreateTime(DateUtils.getNowDate());
        return this.ktonMerchantMapper.insertKtonMerchant(ktonMerchant);
    }

    @Override
    public int updateKtonMerchant(KtonMerchant ktonMerchant) {
        ktonMerchant.setUpdateTime(DateUtils.getNowDate());
        return this.ktonMerchantMapper.updateKtonMerchant(ktonMerchant);
    }

    @Override
    public int deleteKtonMerchantByIds(Long[] ids) {
        return this.ktonMerchantMapper.deleteKtonMerchantByIds(ids);
    }

    @Override
    public int deleteKtonMerchantById(Long id) {
        return this.ktonMerchantMapper.deleteKtonMerchantById(id);
    }
}

