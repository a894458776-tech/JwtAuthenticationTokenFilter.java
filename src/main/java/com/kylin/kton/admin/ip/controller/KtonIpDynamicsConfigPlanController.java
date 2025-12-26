/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.annotation.Log
 *  com.kylin.kton.common.annotation.OpenPlatform
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.core.page.TableDataInfo
 *  com.kylin.kton.common.enums.BusinessType
 *  com.kylin.kton.common.utils.poi.ExcelUtil
 *  com.kylin.kton.system.domain.KtonIpDynamicsConfigPlan
 *  javax.servlet.http.HttpServletResponse
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.security.access.prepost.PreAuthorize
 *  org.springframework.web.bind.annotation.DeleteMapping
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.PostMapping
 *  org.springframework.web.bind.annotation.PutMapping
 *  org.springframework.web.bind.annotation.RequestBody
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.admin.ip.controller;

import com.kylin.kton.admin.ip.service.IpDynamicsConfigPlanService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.annotation.OpenPlatform;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonIpDynamicsConfigPlan;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/admin/ip/dynamics/config/plan"})
@OpenPlatform
public class KtonIpDynamicsConfigPlanController
extends BaseController {
    @Autowired
    private IpDynamicsConfigPlanService ktonIpDynamicsConfigPlanService;

    @PreAuthorize(value="@ss.hasPermi('system:plan:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonIpDynamicsConfigPlan ktonIpDynamicsConfigPlan) {
        this.startPage();
        List list = this.ktonIpDynamicsConfigPlanService.selectKtonIpDynamicsConfigPlanList(ktonIpDynamicsConfigPlan);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:plan:export')")
    @Log(title="\u52a8\u6001IP-\u6d41\u91cf\u8ba1\u5212", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonIpDynamicsConfigPlan ktonIpDynamicsConfigPlan) {
        List list = this.ktonIpDynamicsConfigPlanService.selectKtonIpDynamicsConfigPlanList(ktonIpDynamicsConfigPlan);
        ExcelUtil util = new ExcelUtil(KtonIpDynamicsConfigPlan.class);
        util.exportExcel(response, list, "\u52a8\u6001IP-\u6d41\u91cf\u8ba1\u5212\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:plan:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonIpDynamicsConfigPlanService.selectKtonIpDynamicsConfigPlanById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:plan:add')")
    @Log(title="\u52a8\u6001IP-\u6d41\u91cf\u8ba1\u5212", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonIpDynamicsConfigPlan ktonIpDynamicsConfigPlan) {
        return this.toAjax(this.ktonIpDynamicsConfigPlanService.insertKtonIpDynamicsConfigPlan(ktonIpDynamicsConfigPlan));
    }

    @PreAuthorize(value="@ss.hasPermi('system:plan:edit')")
    @Log(title="\u52a8\u6001IP-\u6d41\u91cf\u8ba1\u5212", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonIpDynamicsConfigPlan ktonIpDynamicsConfigPlan) {
        return this.toAjax(this.ktonIpDynamicsConfigPlanService.updateKtonIpDynamicsConfigPlan(ktonIpDynamicsConfigPlan));
    }

    @PreAuthorize(value="@ss.hasPermi('system:plan:remove')")
    @Log(title="\u52a8\u6001IP-\u6d41\u91cf\u8ba1\u5212", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonIpDynamicsConfigPlanService.deleteKtonIpDynamicsConfigPlanByIds(ids));
    }
}

