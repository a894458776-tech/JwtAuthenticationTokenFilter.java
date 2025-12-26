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
 *  com.kylin.kton.system.domain.KtonOrderItemStatic
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
package com.kylin.kton.admin.order.controller;

import com.kylin.kton.admin.order.service.OrderItemStaticService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonOrderItemStatic;
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
@RequestMapping(value={"/admin/order/item"})
public class KtonOrderItemStaticController
extends BaseController {
    private final OrderItemStaticService orderItemStaticService;

    @PreAuthorize(value="@ss.hasPermi('system:item:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonOrderItemStatic ktonOrderItem) {
        this.startPage();
        List list = this.orderItemStaticService.selectKtonOrderItemStaticList(ktonOrderItem);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:item:export')")
    @Log(title="\u8ba2\u5355-\u660e\u7ec6", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonOrderItemStatic ktonOrderItem) {
        List list = this.orderItemStaticService.selectKtonOrderItemStaticList(ktonOrderItem);
        ExcelUtil util = new ExcelUtil(KtonOrderItemStatic.class);
        util.exportExcel(response, list, "\u8ba2\u5355-\u660e\u7ec6\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:item:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.orderItemStaticService.selectKtonOrderItemStaticById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:item:add')")
    @Log(title="\u8ba2\u5355-\u660e\u7ec6", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonOrderItemStatic ktonOrderItem) {
        return this.toAjax(this.orderItemStaticService.insertKtonOrderItemStatic(ktonOrderItem));
    }

    @PreAuthorize(value="@ss.hasPermi('system:item:edit')")
    @Log(title="\u8ba2\u5355-\u660e\u7ec6", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonOrderItemStatic ktonOrderItem) {
        return this.toAjax(this.orderItemStaticService.updateKtonOrderItemStatic(ktonOrderItem));
    }

    @PreAuthorize(value="@ss.hasPermi('system:item:remove')")
    @Log(title="\u8ba2\u5355-\u660e\u7ec6", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.orderItemStaticService.deleteKtonOrderItemStaticByIds(ids));
    }

    @Generated
    public KtonOrderItemStaticController(OrderItemStaticService orderItemStaticService) {
        this.orderItemStaticService = orderItemStaticService;
    }
}

