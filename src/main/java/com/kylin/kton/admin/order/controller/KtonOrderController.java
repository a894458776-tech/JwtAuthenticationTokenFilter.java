package com.kylin.kton.admin.order.controller;

import com.kylin.kton.admin.order.entity.dto.AdminOrderDTO;
import com.kylin.kton.admin.order.entity.vo.AdminOrderSearchVO;
import com.kylin.kton.admin.order.entity.vo.AdminOrderStaticAddVO;
import com.kylin.kton.admin.order.entity.vo.AdminProcessIpReplacementVO;
import com.kylin.kton.admin.order.entity.vo.AdminReNewIpListVO;
import com.kylin.kton.admin.order.entity.vo.AdminUnsubscribeStaticStrIpsVO;
import com.kylin.kton.admin.order.service.OrderService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.annotation.OpenPlatform;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonOrder;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
@RequestMapping(value={"/admin/order"})
public class KtonOrderController
extends BaseController {
    private final OrderService orderService;

    @PreAuthorize(value="@ss.hasPermi('system:order:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(AdminOrderSearchVO searchVO) {
        this.startPage();
        List<AdminOrderDTO> list = this.orderService.list(searchVO);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:order:export')")
    @Log(title="\u8ba2\u5355", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, AdminOrderSearchVO searchVO) {
        List<AdminOrderDTO> list = this.orderService.list(searchVO);
        ExcelUtil util = new ExcelUtil(AdminOrderDTO.class);
        util.exportExcel(response, list, "\u8ba2\u5355\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:order:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success((Object)this.orderService.detail(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:order:add')")
    @Log(title="\u8ba2\u5355", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonOrder ktonOrder) {
        return this.toAjax(this.orderService.insertKtonOrder(ktonOrder));
    }

    @PreAuthorize(value="@ss.hasPermi('system:order:edit')")
    @Log(title="\u8ba2\u5355", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonOrder ktonOrder) {
        return this.toAjax(this.orderService.updateKtonOrder(ktonOrder));
    }

    @PreAuthorize(value="@ss.hasPermi('system:order:remove')")
    @Log(title="\u8ba2\u5355", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.orderService.deleteKtonOrderByIds(ids));
    }

    @ApiOperation(value="\u7ba1\u7406\u7aef\u4e0b\u5355\u9759\u6001IP")
    @OpenPlatform
    @PostMapping(value={"/addStatic"})
    public AjaxResult addStatic(@RequestBody @Valid AdminOrderStaticAddVO addVO) {
        String orderNo = this.orderService.addStatic(addVO);
        return AjaxResult.success((String)orderNo);
    }

    @ApiOperation(value="\u5ba2\u6237\u9000\u8ba2\u9759\u6001ip\u8ba2\u5355\u90e8\u5206ip(\u5b57\u7b26\u4e32\u5f62\u5f0f)")
    @OpenPlatform
    @PostMapping(value={"/unsubscribeStaticStrIps"})
    public AjaxResult unsubscribeStaticStrIps(@RequestBody @Valid AdminUnsubscribeStaticStrIpsVO ipsVO) {
        Boolean ret = this.orderService.unsubscribeStaticStrIps(ipsVO);
        return AjaxResult.success((Object)ret);
    }

    @PostMapping(value={"/renewIpList"})
    @OpenPlatform
    public AjaxResult renewIpList(@RequestBody @Valid AdminReNewIpListVO reNewIpListVO) {
        return this.orderService.renewIpList(reNewIpListVO);
    }

    @PostMapping(value={"/processIpReplacement"})
    @OpenPlatform
    public AjaxResult processIpReplacement(@RequestBody @Valid AdminProcessIpReplacementVO processIpReplacementVO) {
        return this.orderService.processIpReplacement(processIpReplacementVO);
    }

    @Generated
    public KtonOrderController(OrderService orderService) {
        this.orderService = orderService;
    }
}

