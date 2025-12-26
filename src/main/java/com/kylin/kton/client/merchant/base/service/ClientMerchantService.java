/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.service.IKtonMerchantService
 */
package com.kylin.kton.client.merchant.base.service;

import com.kylin.kton.client.merchant.base.entity.MerchantEditVO;
import com.kylin.kton.client.merchant.base.entity.dto.ClientMerchantSourceDTO;
import com.kylin.kton.client.merchant.base.entity.vo.MerchantSourceVO;
import com.kylin.kton.system.service.IKtonMerchantService;

public interface ClientMerchantService
extends IKtonMerchantService {
    public int editMerchant(MerchantEditVO var1);

    public ClientMerchantSourceDTO merchantSource(MerchantSourceVO var1);
}

