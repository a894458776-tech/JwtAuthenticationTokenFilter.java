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
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountSupportProtocol
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

import com.kylin.kton.admin.account.service.IpDynamicsAccountSupportProtocolService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountSupportProtocol;
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
@RequestMapping(value={"/admin/dynamics/account/protocol"})
public class IpDynamicsAccountSupportProtocolController
extends BaseController {
    @Autowired
    private IpDynamicsAccountSupportProtocolService ktonIpDynamicsAccountSupportProtocolService;

    @PreAuthorize(value="@ss.hasPermi('system:protocol:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonIpDynamicsAccountSupportProtocol ktonIpDynamicsAccountSupportProtocol) {
        this.startPage();
        List list = this.ktonIpDynamicsAccountSupportProtocolService.selectKtonIpDynamicsAccountSupportProtocolList(ktonIpDynamicsAccountSupportProtocol);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:protocol:export')")
    @Log(title="\u52a8\u6001IP-\u652f\u6301\u534f\u8bae", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonIpDynamicsAccountSupportProtocol ktonIpDynamicsAccountSupportProtocol) {
        List list = this.ktonIpDynamicsAccountSupportProtocolService.selectKtonIpDynamicsAccountSupportProtocolList(ktonIpDynamicsAccountSupportProtocol);
        ExcelUtil util = new ExcelUtil(KtonIpDynamicsAccountSupportProtocol.class);
        util.exportExcel(response, list, "\u52a8\u6001IP-\u652f\u6301\u534f\u8bae\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:protocol:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonIpDynamicsAccountSupportProtocolService.selectKtonIpDynamicsAccountSupportProtocolById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:protocol:add')")
    @Log(title="\u52a8\u6001IP-\u652f\u6301\u534f\u8bae", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonIpDynamicsAccountSupportProtocol ktonIpDynamicsAccountSupportProtocol) {
        return this.toAjax(this.ktonIpDynamicsAccountSupportProtocolService.add(ktonIpDynamicsAccountSupportProtocol.getMerchantId(), ktonIpDynamicsAccountSupportProtocol));
    }

    @PreAuthorize(value="@ss.hasPermi('system:protocol:edit')")
    @Log(title="\u52a8\u6001IP-\u652f\u6301\u534f\u8bae", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonIpDynamicsAccountSupportProtocol ktonIpDynamicsAccountSupportProtocol) {
        return this.toAjax(this.ktonIpDynamicsAccountSupportProtocolService.updateKtonIpDynamicsAccountSupportProtocol(ktonIpDynamicsAccountSupportProtocol));
    }

    @PreAuthorize(value="@ss.hasPermi('system:protocol:remove')")
    @Log(title="\u52a8\u6001IP-\u652f\u6301\u534f\u8bae", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonIpDynamicsAccountSupportProtocolService.remove(ids));
    }
}

