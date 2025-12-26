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
import com.kylin.kton.system.domain.KtonMerchantWalletItem;
import com.kylin.kton.system.mapper.KtonMerchantWalletItemMapper;
import com.kylin.kton.system.service.IKtonMerchantWalletItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonMerchantWalletItemServiceImpl
implements IKtonMerchantWalletItemService {
    @Autowired
    private KtonMerchantWalletItemMapper ktonMerchantWalletItemMapper;

    @Override
    public KtonMerchantWalletItem selectKtonMerchantWalletItemById(Long id) {
        return this.ktonMerchantWalletItemMapper.selectKtonMerchantWalletItemById(id);
    }

    @Override
    public List<KtonMerchantWalletItem> selectKtonMerchantWalletItemList(KtonMerchantWalletItem ktonMerchantWalletItem) {
        return this.ktonMerchantWalletItemMapper.selectKtonMerchantWalletItemList(ktonMerchantWalletItem);
    }

    @Override
    public int insertKtonMerchantWalletItem(KtonMerchantWalletItem ktonMerchantWalletItem) {
        ktonMerchantWalletItem.setCreateTime(DateUtils.getNowDate());
        return this.ktonMerchantWalletItemMapper.insertKtonMerchantWalletItem(ktonMerchantWalletItem);
    }

    @Override
    public int updateKtonMerchantWalletItem(KtonMerchantWalletItem ktonMerchantWalletItem) {
        ktonMerchantWalletItem.setUpdateTime(DateUtils.getNowDate());
        return this.ktonMerchantWalletItemMapper.updateKtonMerchantWalletItem(ktonMerchantWalletItem);
    }

    @Override
    public int deleteKtonMerchantWalletItemByIds(Long[] ids) {
        return this.ktonMerchantWalletItemMapper.deleteKtonMerchantWalletItemByIds(ids);
    }

    @Override
    public int deleteKtonMerchantWalletItemById(Long id) {
        return this.ktonMerchantWalletItemMapper.deleteKtonMerchantWalletItemById(id);
    }
}

