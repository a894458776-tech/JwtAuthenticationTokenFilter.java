/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.utils.WeChatWebhookUtil
 *  com.kylin.kton.system.domain.KtonMerchant
 *  com.kylin.kton.system.domain.KtonMerchantWallet
 *  com.kylin.kton.system.domain.KtonMerchantWalletItem
 *  com.kylin.kton.system.mapper.KtonMerchantMapper
 *  com.kylin.kton.system.mapper.KtonMerchantWalletItemMapper
 *  com.kylin.kton.system.mapper.KtonMerchantWalletMapper
 *  com.kylin.kton.system.service.impl.KtonMerchantWalletServiceImpl
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.admin.merchant.base.service.impl;

import com.kylin.kton.admin.merchant.base.entity.vo.MerchantRecahrgeVO;
import com.kylin.kton.admin.merchant.base.service.MerchantWalletService;
import com.kylin.kton.common.utils.WeChatWebhookUtil;
import com.kylin.kton.system.domain.KtonMerchant;
import com.kylin.kton.system.domain.KtonMerchantWallet;
import com.kylin.kton.system.domain.KtonMerchantWalletItem;
import com.kylin.kton.system.mapper.KtonMerchantMapper;
import com.kylin.kton.system.mapper.KtonMerchantWalletItemMapper;
import com.kylin.kton.system.mapper.KtonMerchantWalletMapper;
import com.kylin.kton.system.service.impl.KtonMerchantWalletServiceImpl;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantWalletServiceImpl
extends KtonMerchantWalletServiceImpl
implements MerchantWalletService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(MerchantWalletServiceImpl.class);
    @Autowired
    KtonMerchantWalletMapper ktonMerchantWalletMapper;
    @Autowired
    KtonMerchantWalletItemMapper ktonMerchantWalletItemMapper;
    @Autowired
    KtonMerchantMapper merchantMapper;

    @Override
    public Integer recharge(MerchantRecahrgeVO merchantRecahrgeVO) {
        KtonMerchantWallet ktonMerchantWallet = this.ktonMerchantWalletMapper.selectKtonMerchantWalletByMerchantId(merchantRecahrgeVO.getMerchantId());
        Integer res = 0;
        if (ktonMerchantWallet == null) {
            KtonMerchantWallet addWallet = new KtonMerchantWallet();
            addWallet.setMerchantId(merchantRecahrgeVO.getMerchantId());
            addWallet.setTotalAmount(new BigDecimal(0));
            addWallet.setBalance(merchantRecahrgeVO.getAmount());
            addWallet.setCreateTime(new Date());
            res = this.ktonMerchantWalletMapper.insertKtonMerchantWallet(addWallet);
        } else {
            KtonMerchantWallet updateWallet = ktonMerchantWallet;
            BigDecimal lastBalance = ktonMerchantWallet.getBalance().add(merchantRecahrgeVO.getAmount());
            updateWallet.setBalance(lastBalance);
            updateWallet.setUpdateTime(new Date());
            res = this.ktonMerchantWalletMapper.updateKtonMerchantWallet(updateWallet);
        }
        this.addWalletItem(merchantRecahrgeVO);
        this.sendWeComMessage(merchantRecahrgeVO.getMerchantId(), merchantRecahrgeVO.getAmount());
        return res;
    }

    private void sendWeComMessage(Long merchantId, BigDecimal amount) {
        KtonMerchant ktonMerchant = this.merchantMapper.selectKtonMerchantById(merchantId);
        Date subtime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(subtime);
        String msg = "\u4e1a\u52a1\u4e8b\u4ef6\u901a\u77e5\uff1a\n\u4e3a\u5546\u6237\u5145\u503c\u4f59\u989d\uff1a\n\u5546\u6237\u540d\uff1a" + ktonMerchant.getName() + "\n\u5546\u6237ID:" + ktonMerchant.getId() + "\n\u5145\u503c\u91d1\u989d:" + amount + "\n\u652f\u4ed8\u65b9\u5f0f: \u7ba1\u7406\u540e\u53f0\u5145\u503c \n\u5145\u503c\u65f6\u95f4\uff1a" + formattedDate;
        WeChatWebhookUtil.sendMessage((String)msg);
    }

    private void addWalletItem(MerchantRecahrgeVO merchantRecahrgeVO) {
        KtonMerchantWalletItem ktonMerchantWalletItem = new KtonMerchantWalletItem();
        ktonMerchantWalletItem.setType(Long.valueOf(1L));
        ktonMerchantWalletItem.setAmount(merchantRecahrgeVO.getAmount());
        ktonMerchantWalletItem.setMerchantId(merchantRecahrgeVO.getMerchantId());
        ktonMerchantWalletItem.setCreateTime(new Date());
        this.ktonMerchantWalletItemMapper.insertKtonMerchantWalletItem(ktonMerchantWalletItem);
    }
}

