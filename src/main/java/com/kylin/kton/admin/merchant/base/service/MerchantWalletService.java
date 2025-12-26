/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.service.IKtonMerchantWalletService
 */
package com.kylin.kton.admin.merchant.base.service;

import com.kylin.kton.admin.merchant.base.entity.vo.MerchantRecahrgeVO;
import com.kylin.kton.system.service.IKtonMerchantWalletService;

public interface MerchantWalletService
extends IKtonMerchantWalletService {
    public Integer recharge(MerchantRecahrgeVO var1);
}

