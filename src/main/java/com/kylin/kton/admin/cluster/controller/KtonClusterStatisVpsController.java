/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.annotation.Log
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.core.page.TableDataInfo
 *  com.kylin.kton.common.enums.BusinessType
 *  com.kylin.kton.common.utils.poi.ExcelUtil
 *  com.kylin.kton.system.domain.KtonClusterStatisVps
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
package com.kylin.kton.admin.cluster.controller;

import com.kylin.kton.admin.cluster.service.ClusterStatisVpsService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonClusterStatisVps;
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
@RequestMapping(value={"/admin/cluster/vps"})
public class KtonClusterStatisVpsController
extends BaseController {
    @Autowired
    private ClusterStatisVpsService ktonClusterStatisVpsService;

    @PreAuthorize(value="@ss.hasPermi('system:vps:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonClusterStatisVps ktonClusterStatisVps) {
        this.startPage();
        List list = this.ktonClusterStatisVpsService.selectKtonClusterStatisVpsList(ktonClusterStatisVps);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:vps:export')")
    @Log(title="VPS\u96c6\u7fa4\u7edf\u8ba1\u6c47\u603b\u4fe1\u606f", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonClusterStatisVps ktonClusterStatisVps) {
        List list = this.ktonClusterStatisVpsService.selectKtonClusterStatisVpsList(ktonClusterStatisVps);
        ExcelUtil util = new ExcelUtil(KtonClusterStatisVps.class);
        util.exportExcel(response, list, "VPS\u96c6\u7fa4\u7edf\u8ba1\u6c47\u603b\u4fe1\u606f\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:vps:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonClusterStatisVpsService.selectKtonClusterStatisVpsById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:vps:add')")
    @Log(title="VPS\u96c6\u7fa4\u7edf\u8ba1\u6c47\u603b\u4fe1\u606f", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonClusterStatisVps ktonClusterStatisVps) {
        return this.toAjax(this.ktonClusterStatisVpsService.insertKtonClusterStatisVps(ktonClusterStatisVps));
    }

    @PreAuthorize(value="@ss.hasPermi('system:vps:edit')")
    @Log(title="VPS\u96c6\u7fa4\u7edf\u8ba1\u6c47\u603b\u4fe1\u606f", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonClusterStatisVps ktonClusterStatisVps) {
        return this.toAjax(this.ktonClusterStatisVpsService.updateKtonClusterStatisVps(ktonClusterStatisVps));
    }

    @PreAuthorize(value="@ss.hasPermi('system:vps:remove')")
    @Log(title="VPS\u96c6\u7fa4\u7edf\u8ba1\u6c47\u603b\u4fe1\u606f", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonClusterStatisVpsService.deleteKtonClusterStatisVpsByIds(ids));
    }
}

