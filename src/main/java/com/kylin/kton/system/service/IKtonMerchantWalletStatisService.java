/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonMerchantWalletStatis;
import java.util.List;

public interface IKtonMerchantWalletStatisService {
    public KtonMerchantWalletStatis selectKtonMerchantWalletStatisById(Long var1);

    public List<KtonMerchantWalletStatis> selectKtonMerchantWalletStatisList(KtonMerchantWalletStatis var1);

    public int insertKtonMerchantWalletStatis(KtonMerchantWalletStatis var1);

    public int updateKtonMerchantWalletStatis(KtonMerchantWalletStatis var1);

    public int deleteKtonMerchantWalletStatisByIds(Long[] var1);

    public int deleteKtonMerchantWalletStatisById(Long var1);
}

