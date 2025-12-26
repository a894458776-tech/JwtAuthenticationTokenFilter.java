/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonMerchantWalletStatis
 *  com.kylin.kton.system.service.impl.KtonMerchantWalletStatisServiceImpl
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.client.statis.service.impl;

import com.kylin.kton.client.statis.entity.vo.WalletStatisSearchVO;
import com.kylin.kton.client.statis.service.ClientMerchantWalletStatisService;
import com.kylin.kton.system.domain.KtonMerchantWalletStatis;
import com.kylin.kton.system.service.impl.KtonMerchantWalletStatisServiceImpl;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ClientMerchantWalletStatisServiceImpl
extends KtonMerchantWalletStatisServiceImpl
implements ClientMerchantWalletStatisService {
    @Override
    public List<KtonMerchantWalletStatis> list(WalletStatisSearchVO searchVO) {
        return null;
    }
}

