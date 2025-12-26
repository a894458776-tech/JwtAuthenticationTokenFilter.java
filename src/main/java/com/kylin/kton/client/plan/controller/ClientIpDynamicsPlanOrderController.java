/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.core.page.TableDataInfo
 *  com.kylin.kton.system.domain.KtonIpDynamicsPlanOrder
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.client.plan.controller;

import com.kylin.kton.client.plan.service.ClientIpDynamicsPlanOrderService;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.system.domain.KtonIpDynamicsPlanOrder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/client/plan/order"})
public class ClientIpDynamicsPlanOrderController
extends BaseController {
    @Autowired
    private ClientIpDynamicsPlanOrderService ktonIpDynamicsPlanOrderService;

    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonIpDynamicsPlanOrder ktonIpDynamicsPlanOrder) {
        this.startPage();
        List list = this.ktonIpDynamicsPlanOrderService.selectKtonIpDynamicsPlanOrderList(ktonIpDynamicsPlanOrder);
        return this.getDataTable(list);
    }

    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonIpDynamicsPlanOrderService.selectKtonIpDynamicsPlanOrderById(id));
    }
}

