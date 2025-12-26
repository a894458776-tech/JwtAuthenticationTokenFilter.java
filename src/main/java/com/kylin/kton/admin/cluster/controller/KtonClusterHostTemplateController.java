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
 *  com.kylin.kton.system.domain.KtonClusterHostTemplate
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

import com.kylin.kton.admin.cluster.service.ClusterHostTemplateService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonClusterHostTemplate;
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
@RequestMapping(value={"/admin/template"})
public class KtonClusterHostTemplateController
extends BaseController {
    @Autowired
    private ClusterHostTemplateService ktonClusterHostTemplateService;

    @PreAuthorize(value="@ss.hasPermi('system:template:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonClusterHostTemplate ktonClusterHostTemplate) {
        this.startPage();
        List list = this.ktonClusterHostTemplateService.selectKtonClusterHostTemplateList(ktonClusterHostTemplate);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:template:export')")
    @Log(title="\u96c6\u7fa4 - \u4e3b\u673a\u53c2\u6570", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonClusterHostTemplate ktonClusterHostTemplate) {
        List list = this.ktonClusterHostTemplateService.selectKtonClusterHostTemplateList(ktonClusterHostTemplate);
        ExcelUtil util = new ExcelUtil(KtonClusterHostTemplate.class);
        util.exportExcel(response, list, "\u96c6\u7fa4 - \u4e3b\u673a\u53c2\u6570\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:template:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonClusterHostTemplateService.selectKtonClusterHostTemplateById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:template:add')")
    @Log(title="\u96c6\u7fa4 - \u4e3b\u673a\u53c2\u6570", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonClusterHostTemplate ktonClusterHostTemplate) {
        return this.toAjax(this.ktonClusterHostTemplateService.add(ktonClusterHostTemplate));
    }

    @PreAuthorize(value="@ss.hasPermi('system:template:edit')")
    @Log(title="\u96c6\u7fa4 - \u4e3b\u673a\u53c2\u6570", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonClusterHostTemplate ktonClusterHostTemplate) {
        return this.toAjax(this.ktonClusterHostTemplateService.updateKtonClusterHostTemplate(ktonClusterHostTemplate));
    }

    @PreAuthorize(value="@ss.hasPermi('system:template:remove')")
    @Log(title="\u96c6\u7fa4 - \u4e3b\u673a\u53c2\u6570", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonClusterHostTemplateService.deleteKtonClusterHostTemplateByIds(ids));
    }
}

