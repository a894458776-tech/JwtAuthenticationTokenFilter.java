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
 *  com.kylin.kton.system.domain.KtonIpStaticAuthWhitelist
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

import com.kylin.kton.admin.ip.service.IpStaticAuthWhitelistService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonIpStaticAuthWhitelist;
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
@RequestMapping(value={"/admin/ip/static/whitelist"})
public class KtonIpStaticAuthWhitelistController
extends BaseController {
    @Autowired
    private IpStaticAuthWhitelistService ktonIpStaticAuthWhitelistService;

    @PreAuthorize(value="@ss.hasPermi('system:whitelist:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonIpStaticAuthWhitelist ktonIpStaticAuthWhitelist) {
        this.startPage();
        List list = this.ktonIpStaticAuthWhitelistService.selectKtonIpStaticAuthWhitelistList(ktonIpStaticAuthWhitelist);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:whitelist:export')")
    @Log(title="\u5b89\u5168\u7b56\u7565: \u767d\u540d\u5355IP", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonIpStaticAuthWhitelist ktonIpStaticAuthWhitelist) {
        List list = this.ktonIpStaticAuthWhitelistService.selectKtonIpStaticAuthWhitelistList(ktonIpStaticAuthWhitelist);
        ExcelUtil util = new ExcelUtil(KtonIpStaticAuthWhitelist.class);
        util.exportExcel(response, list, "\u5b89\u5168\u7b56\u7565: \u767d\u540d\u5355IP\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:whitelist:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonIpStaticAuthWhitelistService.selectKtonIpStaticAuthWhitelistById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:whitelist:add')")
    @Log(title="\u5b89\u5168\u7b56\u7565: \u767d\u540d\u5355IP", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonIpStaticAuthWhitelist ktonIpStaticAuthWhitelist) {
        return this.toAjax(this.ktonIpStaticAuthWhitelistService.insertKtonIpStaticAuthWhitelist(ktonIpStaticAuthWhitelist));
    }

    @PreAuthorize(value="@ss.hasPermi('system:whitelist:edit')")
    @Log(title="\u5b89\u5168\u7b56\u7565: \u767d\u540d\u5355IP", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonIpStaticAuthWhitelist ktonIpStaticAuthWhitelist) {
        return this.toAjax(this.ktonIpStaticAuthWhitelistService.updateKtonIpStaticAuthWhitelist(ktonIpStaticAuthWhitelist));
    }

    @PreAuthorize(value="@ss.hasPermi('system:whitelist:remove')")
    @Log(title="\u5b89\u5168\u7b56\u7565: \u767d\u540d\u5355IP", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonIpStaticAuthWhitelistService.deleteKtonIpStaticAuthWhitelistByIds(ids));
    }
}

