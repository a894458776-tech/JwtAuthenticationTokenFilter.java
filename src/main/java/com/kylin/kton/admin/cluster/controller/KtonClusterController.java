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
 *  com.kylin.kton.system.domain.KtonCluster
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

import com.kylin.kton.admin.cluster.service.ClusterService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonCluster;
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
@RequestMapping(value={"/admin/cluster"})
public class KtonClusterController
extends BaseController {
    @Autowired
    private ClusterService ktonClusterService;

    @PreAuthorize(value="@ss.hasPermi('system:cluster:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonCluster ktonCluster) {
        this.startPage();
        List list = this.ktonClusterService.selectKtonClusterList(ktonCluster);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:cluster:export')")
    @Log(title="\u96c6\u7fa4", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonCluster ktonCluster) {
        List list = this.ktonClusterService.selectKtonClusterList(ktonCluster);
        ExcelUtil util = new ExcelUtil(KtonCluster.class);
        util.exportExcel(response, list, "\u96c6\u7fa4\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:cluster:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonClusterService.selectKtonClusterById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:cluster:add')")
    @Log(title="\u96c6\u7fa4", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonCluster ktonCluster) {
        return this.toAjax(this.ktonClusterService.insertKtonCluster(ktonCluster));
    }

    @PreAuthorize(value="@ss.hasPermi('system:cluster:edit')")
    @Log(title="\u96c6\u7fa4", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonCluster ktonCluster) {
        return this.toAjax(this.ktonClusterService.updateKtonCluster(ktonCluster));
    }

    @PreAuthorize(value="@ss.hasPermi('system:cluster:remove')")
    @Log(title="\u96c6\u7fa4", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonClusterService.deleteKtonClusterByIds(ids));
    }
}

