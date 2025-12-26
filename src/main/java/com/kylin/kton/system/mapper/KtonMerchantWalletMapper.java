/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonMerchantWallet;
import java.util.List;

public interface KtonMerchantWalletMapper {
    public KtonMerchantWallet selectKtonMerchantWalletByMerchantId(Long var1);

    public List<KtonMerchantWallet> selectKtonMerchantWalletList(KtonMerchantWallet var1);

    public int insertKtonMerchantWallet(KtonMerchantWallet var1);

    public int updateKtonMerchantWallet(KtonMerchantWallet var1);

    public int deleteKtonMerchantWalletByMerchantId(Long var1);

    public int deleteKtonMerchantWalletByMerchantIds(Long[] var1);
}

