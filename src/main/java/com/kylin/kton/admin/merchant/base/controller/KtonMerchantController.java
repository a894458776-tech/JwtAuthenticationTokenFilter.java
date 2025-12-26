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
 *  com.kylin.kton.system.domain.KtonMerchant
 *  javax.servlet.http.HttpServletResponse
 *  lombok.Generated
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
package com.kylin.kton.admin.merchant.base.controller;

import com.kylin.kton.admin.merchant.base.service.MerchantService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonMerchant;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import lombok.Generated;
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
@RequestMapping(value={"/admin/merchant"})
public class KtonMerchantController
extends BaseController {
    private final MerchantService merchantService;

    @PreAuthorize(value="@ss.hasPermi('system:merchant:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonMerchant ktonMerchant) {
        this.startPage();
        List list = this.merchantService.selectKtonMerchantList(ktonMerchant);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:merchant:export')")
    @Log(title="\u5546\u6237", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonMerchant ktonMerchant) {
        List list = this.merchantService.selectKtonMerchantList(ktonMerchant);
        ExcelUtil util = new ExcelUtil(KtonMerchant.class);
        util.exportExcel(response, list, "\u5546\u6237\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:merchant:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.merchantService.selectKtonMerchantById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:merchant:add')")
    @Log(title="\u5546\u6237", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonMerchant ktonMerchant) {
        return this.toAjax(this.merchantService.add(ktonMerchant));
    }

    @PreAuthorize(value="@ss.hasPermi('system:merchant:edit')")
    @Log(title="\u5546\u6237", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonMerchant ktonMerchant) {
        return this.toAjax(this.merchantService.updateKtonMerchant(ktonMerchant));
    }

    @PreAuthorize(value="@ss.hasPermi('system:merchant:remove')")
    @Log(title="\u5546\u6237", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.merchantService.deleteKtonMerchantByIds(ids));
    }

    @Generated
    public KtonMerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }
}

