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
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountAllowIp
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
package com.kylin.kton.admin.account.controller;

import com.kylin.kton.admin.account.service.IpDynamicsAccountAllowIpService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountAllowIp;
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
@RequestMapping(value={"/admin/dynamics/account/allow/ip"})
public class IpDynamicsAccountAllowIpController
extends BaseController {
    @Autowired
    private IpDynamicsAccountAllowIpService ktonIpDynamicsAccountAllowIpService;

    @PreAuthorize(value="@ss.hasPermi('system:ip:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonIpDynamicsAccountAllowIp ktonIpDynamicsAccountAllowIp) {
        this.startPage();
        List list = this.ktonIpDynamicsAccountAllowIpService.selectKtonIpDynamicsAccountAllowIpList(ktonIpDynamicsAccountAllowIp);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:ip:export')")
    @Log(title="\u52a8\u6001IP-\u5141\u8bb8\u63a5\u5165\u7684IP", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonIpDynamicsAccountAllowIp ktonIpDynamicsAccountAllowIp) {
        List list = this.ktonIpDynamicsAccountAllowIpService.selectKtonIpDynamicsAccountAllowIpList(ktonIpDynamicsAccountAllowIp);
        ExcelUtil util = new ExcelUtil(KtonIpDynamicsAccountAllowIp.class);
        util.exportExcel(response, list, "\u52a8\u6001IP-\u5141\u8bb8\u63a5\u5165\u7684IP\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:ip:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonIpDynamicsAccountAllowIpService.selectKtonIpDynamicsAccountAllowIpById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:ip:add')")
    @Log(title="\u52a8\u6001IP-\u5141\u8bb8\u63a5\u5165\u7684IP", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonIpDynamicsAccountAllowIp ktonIpDynamicsAccountAllowIp) {
        return this.toAjax(this.ktonIpDynamicsAccountAllowIpService.insertKtonIpDynamicsAccountAllowIp(ktonIpDynamicsAccountAllowIp));
    }

    @PreAuthorize(value="@ss.hasPermi('system:ip:edit')")
    @Log(title="\u52a8\u6001IP-\u5141\u8bb8\u63a5\u5165\u7684IP", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonIpDynamicsAccountAllowIp ktonIpDynamicsAccountAllowIp) {
        return this.toAjax(this.ktonIpDynamicsAccountAllowIpService.updateKtonIpDynamicsAccountAllowIp(ktonIpDynamicsAccountAllowIp));
    }

    @PreAuthorize(value="@ss.hasPermi('system:ip:remove')")
    @Log(title="\u52a8\u6001IP-\u5141\u8bb8\u63a5\u5165\u7684IP", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonIpDynamicsAccountAllowIpService.deleteKtonIpDynamicsAccountAllowIpByIds(ids));
    }
}

