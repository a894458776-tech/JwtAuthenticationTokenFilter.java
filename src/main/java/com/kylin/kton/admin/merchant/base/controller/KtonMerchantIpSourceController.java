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
 *  com.kylin.kton.system.domain.KtonMerchantIpSource
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
package com.kylin.kton.admin.merchant.base.controller;

import com.kylin.kton.admin.merchant.base.entity.dto.AdminMerchantSourceDTO;
import com.kylin.kton.admin.merchant.base.entity.vo.AdminMerchantSourceSearchVO;
import com.kylin.kton.admin.merchant.base.service.MerchantIpSourceService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonMerchantIpSource;
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
@RequestMapping(value={"/admin/merchant/source"})
public class KtonMerchantIpSourceController
extends BaseController {
    @Autowired
    private MerchantIpSourceService ktonMerchantIpSourceService;

    @PreAuthorize(value="@ss.hasPermi('system:source:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(AdminMerchantSourceSearchVO searchVO) {
        this.startPage();
        List<AdminMerchantSourceDTO> list = this.ktonMerchantIpSourceService.list(searchVO);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:source:export')")
    @Log(title="\u5546\u6237-IP-\u4f9b\u5e94\u5546-\u5173\u7cfb", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, AdminMerchantSourceSearchVO searchVO) {
        List<AdminMerchantSourceDTO> list = this.ktonMerchantIpSourceService.list(searchVO);
        ExcelUtil util = new ExcelUtil(AdminMerchantSourceDTO.class);
        util.exportExcel(response, list, "\u5546\u6237-IP-\u4f9b\u5e94\u5546-\u5173\u7cfb\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:source:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonMerchantIpSourceService.selectKtonMerchantIpSourceById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:source:add')")
    @Log(title="\u5546\u6237-IP-\u4f9b\u5e94\u5546-\u5173\u7cfb", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonMerchantIpSource ktonMerchantIpSource) {
        return this.toAjax(this.ktonMerchantIpSourceService.insertKtonMerchantIpSource(ktonMerchantIpSource));
    }

    @PreAuthorize(value="@ss.hasPermi('system:source:edit')")
    @Log(title="\u5546\u6237-IP-\u4f9b\u5e94\u5546-\u5173\u7cfb", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonMerchantIpSource ktonMerchantIpSource) {
        return this.toAjax(this.ktonMerchantIpSourceService.updateKtonMerchantIpSource(ktonMerchantIpSource));
    }

    @PreAuthorize(value="@ss.hasPermi('system:source:remove')")
    @Log(title="\u5546\u6237-IP-\u4f9b\u5e94\u5546-\u5173\u7cfb", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonMerchantIpSourceService.deleteKtonMerchantIpSourceByIds(ids));
    }
}

