/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.page.TableDataInfo
 *  com.kylin.kton.common.utils.SecurityUtils
 *  com.kylin.kton.system.domain.KtonMerchantWalletStatis
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.client.statis.controller;

import com.kylin.kton.client.statis.entity.vo.WalletStatisSearchVO;
import com.kylin.kton.client.statis.service.ClientMerchantWalletStatisService;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.utils.SecurityUtils;
import com.kylin.kton.system.domain.KtonMerchantWalletStatis;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/wallet/statis"})
public class ClientMerchantWalletStatisController
extends BaseController {
    @Autowired
    private ClientMerchantWalletStatisService ktonMerchantWalletStatisService;

    @GetMapping(value={"/list"})
    public TableDataInfo list(WalletStatisSearchVO searchVO) {
        this.startPage();
        Long merchantId = SecurityUtils.getUserId();
        searchVO.setMerchantId(merchantId);
        List<KtonMerchantWalletStatis> list = this.ktonMerchantWalletStatisService.list(searchVO);
        return this.getDataTable(list);
    }
}

