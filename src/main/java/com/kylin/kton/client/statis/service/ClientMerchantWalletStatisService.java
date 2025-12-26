/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonMerchantWalletStatis
 *  com.kylin.kton.system.service.IKtonMerchantWalletStatisService
 */
package com.kylin.kton.client.statis.service;

import com.kylin.kton.client.statis.entity.vo.WalletStatisSearchVO;
import com.kylin.kton.system.domain.KtonMerchantWalletStatis;
import com.kylin.kton.system.service.IKtonMerchantWalletStatisService;
import java.util.List;

public interface ClientMerchantWalletStatisService
extends IKtonMerchantWalletStatisService {
    public List<KtonMerchantWalletStatis> list(WalletStatisSearchVO var1);
}

