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
 *  com.kylin.kton.system.domain.KtonVpsHostContainerParam
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
package com.kylin.kton.admin.vps.controller;

import com.kylin.kton.admin.vps.service.VpsHostContainerParamService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonVpsHostContainerParam;
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
@RequestMapping(value={"/admin/vps/container/param"})
public class KtonVpsHostContainerParamController
extends BaseController {
    @Autowired
    private VpsHostContainerParamService ktonVpsHostContainerParamService;

    @PreAuthorize(value="@ss.hasPermi('system:param:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonVpsHostContainerParam ktonVpsHostContainerParam) {
        this.startPage();
        List list = this.ktonVpsHostContainerParamService.selectKtonVpsHostContainerParamList(ktonVpsHostContainerParam);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:param:export')")
    @Log(title="vps - \u5bb9\u5668\u5b9e\u4f8b\u53c2\u6570\u914d\u7f6e", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonVpsHostContainerParam ktonVpsHostContainerParam) {
        List list = this.ktonVpsHostContainerParamService.selectKtonVpsHostContainerParamList(ktonVpsHostContainerParam);
        ExcelUtil util = new ExcelUtil(KtonVpsHostContainerParam.class);
        util.exportExcel(response, list, "vps - \u5bb9\u5668\u5b9e\u4f8b\u53c2\u6570\u914d\u7f6e\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:param:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonVpsHostContainerParamService.selectKtonVpsHostContainerParamById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:param:add')")
    @Log(title="vps - \u5bb9\u5668\u5b9e\u4f8b\u53c2\u6570\u914d\u7f6e", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonVpsHostContainerParam ktonVpsHostContainerParam) {
        return this.toAjax(this.ktonVpsHostContainerParamService.insertKtonVpsHostContainerParam(ktonVpsHostContainerParam));
    }

    @PreAuthorize(value="@ss.hasPermi('system:param:edit')")
    @Log(title="vps - \u5bb9\u5668\u5b9e\u4f8b\u53c2\u6570\u914d\u7f6e", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonVpsHostContainerParam ktonVpsHostContainerParam) {
        return this.toAjax(this.ktonVpsHostContainerParamService.updateKtonVpsHostContainerParam(ktonVpsHostContainerParam));
    }

    @PreAuthorize(value="@ss.hasPermi('system:param:remove')")
    @Log(title="vps - \u5bb9\u5668\u5b9e\u4f8b\u53c2\u6570\u914d\u7f6e", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonVpsHostContainerParamService.deleteKtonVpsHostContainerParamByIds(ids));
    }
}

