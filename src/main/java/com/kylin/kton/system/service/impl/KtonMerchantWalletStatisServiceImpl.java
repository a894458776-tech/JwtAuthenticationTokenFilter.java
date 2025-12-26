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
import com.kylin.kton.system.domain.KtonMerchantWalletStatis;
import com.kylin.kton.system.mapper.KtonMerchantWalletStatisMapper;
import com.kylin.kton.system.service.IKtonMerchantWalletStatisService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonMerchantWalletStatisServiceImpl
implements IKtonMerchantWalletStatisService {
    @Autowired
    private KtonMerchantWalletStatisMapper ktonMerchantWalletStatisMapper;

    @Override
    public KtonMerchantWalletStatis selectKtonMerchantWalletStatisById(Long id) {
        return this.ktonMerchantWalletStatisMapper.selectKtonMerchantWalletStatisById(id);
    }

    @Override
    public List<KtonMerchantWalletStatis> selectKtonMerchantWalletStatisList(KtonMerchantWalletStatis ktonMerchantWalletStatis) {
        return this.ktonMerchantWalletStatisMapper.selectKtonMerchantWalletStatisList(ktonMerchantWalletStatis);
    }

    @Override
    public int insertKtonMerchantWalletStatis(KtonMerchantWalletStatis ktonMerchantWalletStatis) {
        ktonMerchantWalletStatis.setCreateTime(DateUtils.getNowDate());
        return this.ktonMerchantWalletStatisMapper.insertKtonMerchantWalletStatis(ktonMerchantWalletStatis);
    }

    @Override
    public int updateKtonMerchantWalletStatis(KtonMerchantWalletStatis ktonMerchantWalletStatis) {
        ktonMerchantWalletStatis.setUpdateTime(DateUtils.getNowDate());
        return this.ktonMerchantWalletStatisMapper.updateKtonMerchantWalletStatis(ktonMerchantWalletStatis);
    }

    @Override
    public int deleteKtonMerchantWalletStatisByIds(Long[] ids) {
        return this.ktonMerchantWalletStatisMapper.deleteKtonMerchantWalletStatisByIds(ids);
    }

    @Override
    public int deleteKtonMerchantWalletStatisById(Long id) {
        return this.ktonMerchantWalletStatisMapper.deleteKtonMerchantWalletStatisById(id);
    }
}

