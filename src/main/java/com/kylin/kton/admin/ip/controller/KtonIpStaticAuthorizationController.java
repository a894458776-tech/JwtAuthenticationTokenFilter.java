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
 *  com.kylin.kton.system.domain.KtonIpStaticAuthorization
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

import com.kylin.kton.admin.ip.service.IpStaticAuthorizationService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonIpStaticAuthorization;
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
@RequestMapping(value={"/admin/ip/static/authorization"})
public class KtonIpStaticAuthorizationController
extends BaseController {
    @Autowired
    private IpStaticAuthorizationService ktonIpStaticAuthorizationService;

    @PreAuthorize(value="@ss.hasPermi('system:authorization:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonIpStaticAuthorization ktonIpStaticAuthorization) {
        this.startPage();
        List list = this.ktonIpStaticAuthorizationService.selectKtonIpStaticAuthorizationList(ktonIpStaticAuthorization);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:authorization:export')")
    @Log(title="\u5b89\u5168\u7b56\u7565", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonIpStaticAuthorization ktonIpStaticAuthorization) {
        List list = this.ktonIpStaticAuthorizationService.selectKtonIpStaticAuthorizationList(ktonIpStaticAuthorization);
        ExcelUtil util = new ExcelUtil(KtonIpStaticAuthorization.class);
        util.exportExcel(response, list, "\u5b89\u5168\u7b56\u7565\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:authorization:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonIpStaticAuthorizationService.selectKtonIpStaticAuthorizationById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:authorization:add')")
    @Log(title="\u5b89\u5168\u7b56\u7565", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonIpStaticAuthorization ktonIpStaticAuthorization) {
        return this.toAjax(this.ktonIpStaticAuthorizationService.insertKtonIpStaticAuthorization(ktonIpStaticAuthorization));
    }

    @PreAuthorize(value="@ss.hasPermi('system:authorization:edit')")
    @Log(title="\u5b89\u5168\u7b56\u7565", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonIpStaticAuthorization ktonIpStaticAuthorization) {
        return this.toAjax(this.ktonIpStaticAuthorizationService.updateKtonIpStaticAuthorization(ktonIpStaticAuthorization));
    }

    @PreAuthorize(value="@ss.hasPermi('system:authorization:remove')")
    @Log(title="\u5b89\u5168\u7b56\u7565", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonIpStaticAuthorizationService.deleteKtonIpStaticAuthorizationByIds(ids));
    }
}

