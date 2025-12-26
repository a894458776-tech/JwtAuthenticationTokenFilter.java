/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.core.page.TableDataInfo
 *  com.kylin.kton.common.utils.SecurityUtils
 *  com.kylin.kton.system.domain.KtonIpDynamicsPlan
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.client.plan.controller;

import com.kylin.kton.client.plan.service.ClientIpDynamicsPlanService;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.utils.SecurityUtils;
import com.kylin.kton.system.domain.KtonIpDynamicsPlan;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/client/plan"})
public class ClientIpDynamicsPlanController
extends BaseController {
    @Autowired
    private ClientIpDynamicsPlanService ktonIpDynamicsPlanService;

    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonIpDynamicsPlan ktonIpDynamicsPlan) {
        this.startPage();
        List list = this.ktonIpDynamicsPlanService.selectKtonIpDynamicsPlanList(ktonIpDynamicsPlan);
        return this.getDataTable(list);
    }

    @GetMapping(value={"/detail"})
    public AjaxResult detail() {
        KtonIpDynamicsPlan entity = new KtonIpDynamicsPlan();
        Long merchantId = SecurityUtils.getUserId();
        entity.setMerchantId(merchantId);
        List plans = this.ktonIpDynamicsPlanService.selectKtonIpDynamicsPlanList(entity);
        KtonIpDynamicsPlan plan = new KtonIpDynamicsPlan();
        if (plans.size() > 0) {
            plan = (KtonIpDynamicsPlan)plans.get(0);
        }
        return this.success(plan);
    }

    @GetMapping(value={"/queryMainBalance"})
    public AjaxResult queryMainBalance() {
        this.ktonIpDynamicsPlanService.queryMainBalance();
        return AjaxResult.success();
    }
}

