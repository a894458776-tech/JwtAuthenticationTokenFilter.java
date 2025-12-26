/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.admin.merchant.base.controller;

import com.kylin.kton.admin.merchant.base.service.MerchantSummaryService;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/client/merchant/summary"})
public class KtonMerchantSummaryController
extends BaseController {
    @Autowired
    private MerchantSummaryService ktonMerchantSummaryService;

    @GetMapping(value={"/detail/{id}"})
    public AjaxResult detail(@PathVariable(value="id") Long id) {
        return this.success(this.ktonMerchantSummaryService.selectKtonMerchantSummaryById(id));
    }
}

