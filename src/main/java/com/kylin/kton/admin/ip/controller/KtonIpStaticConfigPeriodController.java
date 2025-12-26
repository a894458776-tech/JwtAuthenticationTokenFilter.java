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
 *  com.kylin.kton.system.domain.KtonIpStaticConfigPeriod
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

import com.kylin.kton.admin.ip.service.IpStaticConfigPeriodService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.annotation.OpenPlatform;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonIpStaticConfigPeriod;
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
@RequestMapping(value={"/admin/ip/staitc/config/period"})
@OpenPlatform
public class KtonIpStaticConfigPeriodController
extends BaseController {
    @Autowired
    private IpStaticConfigPeriodService ktonIpStaticConfigPeriodService;

    @PreAuthorize(value="@ss.hasPermi('system:period:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonIpStaticConfigPeriod ktonIpStaticConfigPeriod) {
        this.startPage();
        List list = this.ktonIpStaticConfigPeriodService.selectKtonIpStaticConfigPeriodList(ktonIpStaticConfigPeriod);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:period:export')")
    @Log(title="\u9759\u6001IP-\u4ed8\u6b3e\u5468\u671f", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonIpStaticConfigPeriod ktonIpStaticConfigPeriod) {
        List list = this.ktonIpStaticConfigPeriodService.selectKtonIpStaticConfigPeriodList(ktonIpStaticConfigPeriod);
        ExcelUtil util = new ExcelUtil(KtonIpStaticConfigPeriod.class);
        util.exportExcel(response, list, "\u9759\u6001IP-\u4ed8\u6b3e\u5468\u671f\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:period:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonIpStaticConfigPeriodService.selectKtonIpStaticConfigPeriodById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:period:add')")
    @Log(title="\u9759\u6001IP-\u4ed8\u6b3e\u5468\u671f", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonIpStaticConfigPeriod ktonIpStaticConfigPeriod) {
        return this.toAjax(this.ktonIpStaticConfigPeriodService.insertKtonIpStaticConfigPeriod(ktonIpStaticConfigPeriod));
    }

    @PreAuthorize(value="@ss.hasPermi('system:period:edit')")
    @Log(title="\u9759\u6001IP-\u4ed8\u6b3e\u5468\u671f", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonIpStaticConfigPeriod ktonIpStaticConfigPeriod) {
        return this.toAjax(this.ktonIpStaticConfigPeriodService.updateKtonIpStaticConfigPeriod(ktonIpStaticConfigPeriod));
    }

    @PreAuthorize(value="@ss.hasPermi('system:period:remove')")
    @Log(title="\u9759\u6001IP-\u4ed8\u6b3e\u5468\u671f", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonIpStaticConfigPeriodService.deleteKtonIpStaticConfigPeriodByIds(ids));
    }
}

