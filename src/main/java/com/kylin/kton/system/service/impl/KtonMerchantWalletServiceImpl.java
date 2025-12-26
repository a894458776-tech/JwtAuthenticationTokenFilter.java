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
import com.kylin.kton.system.domain.KtonMerchantWallet;
import com.kylin.kton.system.mapper.KtonMerchantWalletMapper;
import com.kylin.kton.system.service.IKtonMerchantWalletService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonMerchantWalletServiceImpl
implements IKtonMerchantWalletService {
    @Autowired
    private KtonMerchantWalletMapper ktonMerchantWalletMapper;

    @Override
    public KtonMerchantWallet selectKtonMerchantWalletByMerchantId(Long merchantId) {
        return this.ktonMerchantWalletMapper.selectKtonMerchantWalletByMerchantId(merchantId);
    }

    @Override
    public List<KtonMerchantWallet> selectKtonMerchantWalletList(KtonMerchantWallet ktonMerchantWallet) {
        return this.ktonMerchantWalletMapper.selectKtonMerchantWalletList(ktonMerchantWallet);
    }

    @Override
    public int insertKtonMerchantWallet(KtonMerchantWallet ktonMerchantWallet) {
        ktonMerchantWallet.setCreateTime(DateUtils.getNowDate());
        return this.ktonMerchantWalletMapper.insertKtonMerchantWallet(ktonMerchantWallet);
    }

    @Override
    public int updateKtonMerchantWallet(KtonMerchantWallet ktonMerchantWallet) {
        ktonMerchantWallet.setUpdateTime(DateUtils.getNowDate());
        return this.ktonMerchantWalletMapper.updateKtonMerchantWallet(ktonMerchantWallet);
    }

    @Override
    public int deleteKtonMerchantWalletByMerchantIds(Long[] merchantIds) {
        return this.ktonMerchantWalletMapper.deleteKtonMerchantWalletByMerchantIds(merchantIds);
    }

    @Override
    public int deleteKtonMerchantWalletByMerchantId(Long merchantId) {
        return this.ktonMerchantWalletMapper.deleteKtonMerchantWalletByMerchantId(merchantId);
    }
}

