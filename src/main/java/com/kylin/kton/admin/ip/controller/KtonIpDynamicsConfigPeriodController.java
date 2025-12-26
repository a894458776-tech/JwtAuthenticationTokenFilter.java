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
 *  com.kylin.kton.system.domain.KtonIpDynamicsConfigPeriod
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

import com.kylin.kton.admin.ip.service.IpDynamicsConfigPeriodService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.annotation.OpenPlatform;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonIpDynamicsConfigPeriod;
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
@RequestMapping(value={"/admin/ip/dynamics/config/period"})
@OpenPlatform
public class KtonIpDynamicsConfigPeriodController
extends BaseController {
    @Autowired
    private IpDynamicsConfigPeriodService ktonIpDynamicsConfigPeriodService;

    @PreAuthorize(value="@ss.hasPermi('system:period:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonIpDynamicsConfigPeriod ktonIpDynamicsConfigPeriod) {
        this.startPage();
        List list = this.ktonIpDynamicsConfigPeriodService.selectKtonIpDynamicsConfigPeriodList(ktonIpDynamicsConfigPeriod);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:period:export')")
    @Log(title="\u52a8\u6001IP-\u4ed8\u6b3e\u5468\u671f", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonIpDynamicsConfigPeriod ktonIpDynamicsConfigPeriod) {
        List list = this.ktonIpDynamicsConfigPeriodService.selectKtonIpDynamicsConfigPeriodList(ktonIpDynamicsConfigPeriod);
        ExcelUtil util = new ExcelUtil(KtonIpDynamicsConfigPeriod.class);
        util.exportExcel(response, list, "\u52a8\u6001IP-\u4ed8\u6b3e\u5468\u671f\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:period:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonIpDynamicsConfigPeriodService.selectKtonIpDynamicsConfigPeriodById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:period:add')")
    @Log(title="\u52a8\u6001IP-\u4ed8\u6b3e\u5468\u671f", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonIpDynamicsConfigPeriod ktonIpDynamicsConfigPeriod) {
        return this.toAjax(this.ktonIpDynamicsConfigPeriodService.insertKtonIpDynamicsConfigPeriod(ktonIpDynamicsConfigPeriod));
    }

    @PreAuthorize(value="@ss.hasPermi('system:period:edit')")
    @Log(title="\u52a8\u6001IP-\u4ed8\u6b3e\u5468\u671f", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonIpDynamicsConfigPeriod ktonIpDynamicsConfigPeriod) {
        return this.toAjax(this.ktonIpDynamicsConfigPeriodService.updateKtonIpDynamicsConfigPeriod(ktonIpDynamicsConfigPeriod));
    }

    @PreAuthorize(value="@ss.hasPermi('system:period:remove')")
    @Log(title="\u52a8\u6001IP-\u4ed8\u6b3e\u5468\u671f", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonIpDynamicsConfigPeriodService.deleteKtonIpDynamicsConfigPeriodByIds(ids));
    }
}

