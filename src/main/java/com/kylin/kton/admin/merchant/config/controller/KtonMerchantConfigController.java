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
 *  com.kylin.kton.system.domain.KtonMerchantConfig
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
package com.kylin.kton.admin.merchant.config.controller;

import com.kylin.kton.admin.merchant.config.service.MerchantConfigService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonMerchantConfig;
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
@RequestMapping(value={"/admin/merchant/config"})
public class KtonMerchantConfigController
extends BaseController {
    @Autowired
    private MerchantConfigService ktonMerchantConfigService;

    @PreAuthorize(value="@ss.hasPermi('system:config:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonMerchantConfig ktonMerchantConfig) {
        this.startPage();
        List list = this.ktonMerchantConfigService.selectKtonMerchantConfigList(ktonMerchantConfig);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:config:export')")
    @Log(title="\u5546\u6237\u914d\u7f6e", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonMerchantConfig ktonMerchantConfig) {
        List list = this.ktonMerchantConfigService.selectKtonMerchantConfigList(ktonMerchantConfig);
        ExcelUtil util = new ExcelUtil(KtonMerchantConfig.class);
        util.exportExcel(response, list, "\u5546\u6237\u914d\u7f6e\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:config:query')")
    @GetMapping(value={"/detail/{merchantId}"})
    public AjaxResult detail(@PathVariable(value="merchantId") Long merchantId) {
        return this.success(this.ktonMerchantConfigService.detail(merchantId));
    }

    @PreAuthorize(value="@ss.hasPermi('system:config:add')")
    @Log(title="\u5546\u6237\u914d\u7f6e", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonMerchantConfig ktonMerchantConfig) {
        return this.toAjax(this.ktonMerchantConfigService.insertKtonMerchantConfig(ktonMerchantConfig));
    }

    @PreAuthorize(value="@ss.hasPermi('system:config:edit')")
    @Log(title="\u5546\u6237\u914d\u7f6e", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonMerchantConfig ktonMerchantConfig) {
        return this.toAjax(this.ktonMerchantConfigService.updateKtonMerchantConfig(ktonMerchantConfig));
    }

    @PreAuthorize(value="@ss.hasPermi('system:config:remove')")
    @Log(title="\u5546\u6237\u914d\u7f6e", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{merchantConfigIds}"})
    public AjaxResult remove(@PathVariable Long[] merchantConfigIds) {
        return this.toAjax(this.ktonMerchantConfigService.deleteKtonMerchantConfigByMerchantConfigIds(merchantConfigIds));
    }
}

