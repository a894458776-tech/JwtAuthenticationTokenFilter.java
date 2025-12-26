/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.annotation.OpenPlatform
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.core.page.TableDataInfo
 *  com.kylin.kton.common.utils.SecurityUtils
 *  com.kylin.kton.common.utils.poi.ExcelUtil
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountEndpoint
 *  javax.servlet.http.HttpServletResponse
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.web.bind.annotation.DeleteMapping
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.PostMapping
 *  org.springframework.web.bind.annotation.PutMapping
 *  org.springframework.web.bind.annotation.RequestBody
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.client.account.controller;

import com.kylin.kton.client.account.service.ClientIpDynamicsAccountEndpointService;
import com.kylin.kton.common.annotation.OpenPlatform;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.utils.SecurityUtils;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountEndpoint;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/client/dynamics/account/endpoint"})
@OpenPlatform
public class ClientIpDynamicsAccountEndpointController
extends BaseController {
    @Autowired
    private ClientIpDynamicsAccountEndpointService ktonIpDynamicsAccountEndpointService;

    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonIpDynamicsAccountEndpoint ktonIpDynamicsAccountEndpoint) {
        this.startPage();
        Long merchantId = SecurityUtils.getUserId();
        ktonIpDynamicsAccountEndpoint.setMerchantId(merchantId);
        List list = this.ktonIpDynamicsAccountEndpointService.selectKtonIpDynamicsAccountEndpointList(ktonIpDynamicsAccountEndpoint);
        return this.getDataTable(list);
    }

    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonIpDynamicsAccountEndpoint ktonIpDynamicsAccountEndpoint) {
        List list = this.ktonIpDynamicsAccountEndpointService.selectKtonIpDynamicsAccountEndpointList(ktonIpDynamicsAccountEndpoint);
        ExcelUtil util = new ExcelUtil(KtonIpDynamicsAccountEndpoint.class);
        util.exportExcel(response, list, "\u52a8\u6001IP-\u8d26\u53f7\u63a5\u5165\u70b9\u6570\u636e");
    }

    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonIpDynamicsAccountEndpointService.selectKtonIpDynamicsAccountEndpointById(id));
    }

    @PostMapping
    public AjaxResult add(@RequestBody KtonIpDynamicsAccountEndpoint ktonIpDynamicsAccountEndpoint) {
        return this.toAjax(this.ktonIpDynamicsAccountEndpointService.insertKtonIpDynamicsAccountEndpoint(ktonIpDynamicsAccountEndpoint));
    }

    @PutMapping
    public AjaxResult edit(@RequestBody KtonIpDynamicsAccountEndpoint ktonIpDynamicsAccountEndpoint) {
        return this.toAjax(this.ktonIpDynamicsAccountEndpointService.updateKtonIpDynamicsAccountEndpoint(ktonIpDynamicsAccountEndpoint));
    }

    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonIpDynamicsAccountEndpointService.deleteKtonIpDynamicsAccountEndpointByIds(ids));
    }
}

