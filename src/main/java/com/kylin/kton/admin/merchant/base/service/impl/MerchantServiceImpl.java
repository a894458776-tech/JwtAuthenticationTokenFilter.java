/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.utils.WeChatWebhookUtil
 *  com.kylin.kton.system.domain.KtonMerchant
 *  com.kylin.kton.system.domain.KtonMerchantWallet
 *  com.kylin.kton.system.mapper.KtonMerchantMapper
 *  com.kylin.kton.system.mapper.KtonMerchantWalletMapper
 *  com.kylin.kton.system.service.ISysUserService
 *  com.kylin.kton.system.service.impl.KtonMerchantServiceImpl
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.admin.merchant.base.service.impl;

import com.kylin.kton.admin.account.mapper.AdminAccountDao;
import com.kylin.kton.admin.merchant.base.service.MerchantService;
import com.kylin.kton.common.utils.WeChatWebhookUtil;
import com.kylin.kton.system.domain.KtonMerchant;
import com.kylin.kton.system.domain.KtonMerchantWallet;
import com.kylin.kton.system.mapper.KtonMerchantMapper;
import com.kylin.kton.system.mapper.KtonMerchantWalletMapper;
import com.kylin.kton.system.service.ISysUserService;
import com.kylin.kton.system.service.impl.KtonMerchantServiceImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl
extends KtonMerchantServiceImpl
implements MerchantService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(MerchantServiceImpl.class);
    @Autowired
    KtonMerchantMapper merchantMapper;
    @Autowired
    ISysUserService sysUserService;
    @Autowired
    AdminAccountDao adminAccountDao;
    @Autowired
    KtonMerchantWalletMapper walletMapper;

    @Override
    public int add(KtonMerchant ktonMerchant) {
        ktonMerchant.setCreateTime(new Date());
        int res = this.merchantMapper.insertKtonMerchant(ktonMerchant);
        KtonMerchantWallet wallet = new KtonMerchantWallet();
        wallet.setMerchantId(ktonMerchant.getId());
        wallet.setCreateTime(new Date());
        this.walletMapper.insertKtonMerchantWallet(wallet);
        Long[] roleIds = new Long[]{2L};
        this.sysUserService.insertUserAuth(ktonMerchant.getId(), roleIds);
        this.sendWeComMessage(ktonMerchant.getId());
        return res;
    }

    private void sendWeComMessage(Long merchantId) {
        KtonMerchant ktonMerchant = this.merchantMapper.selectKtonMerchantById(merchantId);
        Date subtime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(subtime);
        String msg = "\u4e1a\u52a1\u4e8b\u4ef6\u901a\u77e5\uff1a\n\u5f00\u901a\u5546\u6237\u6210\u529f\uff1a\n\u5546\u6237\u540d\uff1a" + ktonMerchant.getName() + "\n\u5546\u6237ID:" + ktonMerchant.getId() + "\n\u6743\u9650\u5206\u914d\u6210\u529f: \u89d2\u8272\u4e3a\u3010\u666e\u901a\u89d2\u8272\u3011 \n\u5f00\u901a\u65f6\u95f4\uff1a" + formattedDate;
        WeChatWebhookUtil.sendMessage((String)msg);
    }
}

