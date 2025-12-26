/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.utils.SecurityUtils
 *  com.kylin.kton.system.domain.KtonMerchantConfig
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.PostMapping
 *  org.springframework.web.bind.annotation.PutMapping
 *  org.springframework.web.bind.annotation.RequestBody
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.client.merchant.config.controller;

import com.kylin.kton.client.merchant.config.service.ClientMerchantConfigService;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.utils.SecurityUtils;
import com.kylin.kton.system.domain.KtonMerchantConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/client/merchant/config"})
public class ClientMerchantConfigController
extends BaseController {
    @Autowired
    private ClientMerchantConfigService ktonMerchantConfigService;

    @GetMapping(value={"/detail"})
    public AjaxResult detail() {
        Long merchantId = SecurityUtils.getUserId();
        return this.success(this.ktonMerchantConfigService.detail(merchantId));
    }

    @PostMapping
    public AjaxResult add(@RequestBody KtonMerchantConfig ktonMerchantConfig) {
        return this.toAjax(this.ktonMerchantConfigService.insertKtonMerchantConfig(ktonMerchantConfig));
    }

    @PutMapping
    public AjaxResult edit(@RequestBody KtonMerchantConfig ktonMerchantConfig) {
        return this.toAjax(this.ktonMerchantConfigService.updateKtonMerchantConfig(ktonMerchantConfig));
    }
}

