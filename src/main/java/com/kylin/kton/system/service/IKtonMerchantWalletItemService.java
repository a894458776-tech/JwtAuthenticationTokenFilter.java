/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonMerchantWalletItem;
import java.util.List;

public interface IKtonMerchantWalletItemService {
    public KtonMerchantWalletItem selectKtonMerchantWalletItemById(Long var1);

    public List<KtonMerchantWalletItem> selectKtonMerchantWalletItemList(KtonMerchantWalletItem var1);

    public int insertKtonMerchantWalletItem(KtonMerchantWalletItem var1);

    public int updateKtonMerchantWalletItem(KtonMerchantWalletItem var1);

    public int deleteKtonMerchantWalletItemByIds(Long[] var1);

    public int deleteKtonMerchantWalletItemById(Long var1);
}

