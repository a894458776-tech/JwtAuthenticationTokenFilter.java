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
 *  com.kylin.kton.system.domain.KtonMerchantWallet
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

import com.kylin.kton.admin.merchant.base.entity.vo.MerchantRecahrgeVO;
import com.kylin.kton.admin.merchant.base.service.MerchantWalletService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonMerchantWallet;
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
@RequestMapping(value={"/admin/merchant/wallet"})
public class KtonMerchantWalletController
extends BaseController {
    private final MerchantWalletService merchantWalletService;

    @PreAuthorize(value="@ss.hasPermi('system:wallet:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonMerchantWallet ktonMerchantWallet) {
        this.startPage();
        List list = this.merchantWalletService.selectKtonMerchantWalletList(ktonMerchantWallet);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:wallet:export')")
    @Log(title="\u5546\u6237-\u94b1\u5305", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonMerchantWallet ktonMerchantWallet) {
        List list = this.merchantWalletService.selectKtonMerchantWalletList(ktonMerchantWallet);
        ExcelUtil util = new ExcelUtil(KtonMerchantWallet.class);
        util.exportExcel(response, list, "\u5546\u6237-\u94b1\u5305\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:wallet:query')")
    @GetMapping(value={"/{merchantId}"})
    public AjaxResult getInfo(@PathVariable(value="merchantId") Long merchantId) {
        return this.success(this.merchantWalletService.selectKtonMerchantWalletByMerchantId(merchantId));
    }

    @PreAuthorize(value="@ss.hasPermi('system:wallet:add')")
    @Log(title="\u5546\u6237-\u94b1\u5305", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonMerchantWallet ktonMerchantWallet) {
        return this.toAjax(this.merchantWalletService.insertKtonMerchantWallet(ktonMerchantWallet));
    }

    @PostMapping(value={"/recharge"})
    public AjaxResult recharge(@RequestBody MerchantRecahrgeVO merchantRecahrgeVO) {
        return this.toAjax(this.merchantWalletService.recharge(merchantRecahrgeVO));
    }

    @PreAuthorize(value="@ss.hasPermi('system:wallet:edit')")
    @Log(title="\u5546\u6237-\u94b1\u5305", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonMerchantWallet ktonMerchantWallet) {
        return this.toAjax(this.merchantWalletService.updateKtonMerchantWallet(ktonMerchantWallet));
    }

    @PreAuthorize(value="@ss.hasPermi('system:wallet:remove')")
    @Log(title="\u5546\u6237-\u94b1\u5305", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{merchantIds}"})
    public AjaxResult remove(@PathVariable Long[] merchantIds) {
        return this.toAjax(this.merchantWalletService.deleteKtonMerchantWalletByMerchantIds(merchantIds));
    }

    @Generated
    public KtonMerchantWalletController(MerchantWalletService merchantWalletService) {
        this.merchantWalletService = merchantWalletService;
    }
}

