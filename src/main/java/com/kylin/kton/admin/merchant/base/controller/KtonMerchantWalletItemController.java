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
 *  com.kylin.kton.system.domain.KtonMerchantWalletItem
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

import com.kylin.kton.admin.merchant.base.service.MerchantWalletItemService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonMerchantWalletItem;
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
@RequestMapping(value={"/admin/merchant/wallet/item"})
public class KtonMerchantWalletItemController
extends BaseController {
    private final MerchantWalletItemService merchantWalletItemService;

    @PreAuthorize(value="@ss.hasPermi('system:item:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonMerchantWalletItem ktonMerchantWalletItem) {
        this.startPage();
        List list = this.merchantWalletItemService.selectKtonMerchantWalletItemList(ktonMerchantWalletItem);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:item:export')")
    @Log(title="\u5546\u6237-\u94b1\u5305-\u4ea4\u6613\u660e\u7ec6", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonMerchantWalletItem ktonMerchantWalletItem) {
        List list = this.merchantWalletItemService.selectKtonMerchantWalletItemList(ktonMerchantWalletItem);
        ExcelUtil util = new ExcelUtil(KtonMerchantWalletItem.class);
        util.exportExcel(response, list, "\u5546\u6237-\u94b1\u5305-\u4ea4\u6613\u660e\u7ec6\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:item:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.merchantWalletItemService.selectKtonMerchantWalletItemById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:item:add')")
    @Log(title="\u5546\u6237-\u94b1\u5305-\u4ea4\u6613\u660e\u7ec6", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonMerchantWalletItem ktonMerchantWalletItem) {
        return this.toAjax(this.merchantWalletItemService.insertKtonMerchantWalletItem(ktonMerchantWalletItem));
    }

    @PreAuthorize(value="@ss.hasPermi('system:item:edit')")
    @Log(title="\u5546\u6237-\u94b1\u5305-\u4ea4\u6613\u660e\u7ec6", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonMerchantWalletItem ktonMerchantWalletItem) {
        return this.toAjax(this.merchantWalletItemService.updateKtonMerchantWalletItem(ktonMerchantWalletItem));
    }

    @PreAuthorize(value="@ss.hasPermi('system:item:remove')")
    @Log(title="\u5546\u6237-\u94b1\u5305-\u4ea4\u6613\u660e\u7ec6", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.merchantWalletItemService.deleteKtonMerchantWalletItemByIds(ids));
    }

    @Generated
    public KtonMerchantWalletItemController(MerchantWalletItemService merchantWalletItemService) {
        this.merchantWalletItemService = merchantWalletItemService;
    }
}

