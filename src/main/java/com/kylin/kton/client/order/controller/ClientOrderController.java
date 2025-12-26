package com.kylin.kton.client.order.controller;

import com.kylin.kton.client.ip.entity.vo.ReNewIpListVO;
import com.kylin.kton.client.ip.service.ClientIpStaticPoolItemService;
import com.kylin.kton.client.order.entity.dto.ClientOrderDetailDTO;
import com.kylin.kton.client.order.entity.dto.ClientOrderItemStaticDTO;
import com.kylin.kton.client.order.entity.dto.ClientOrderVpsDetailDTO;
import com.kylin.kton.client.order.entity.vo.*;
import com.kylin.kton.client.order.service.ClientOrderService;
import com.kylin.kton.common.annotation.OpenPlatform;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.utils.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags={"订单模块"})
@RestController
@RequestMapping("/client/order")
@OpenPlatform
public class ClientOrderController extends BaseController {

    @Autowired
    private ClientOrderService clientOrderService;
    @Autowired
    private ClientIpStaticPoolItemService ipStaticPoolItemService;

    @ApiOperation("客户端下单静态IP")
    @PostMapping("/addStatic")
    @OpenPlatform
    public AjaxResult addStatic(@Valid @RequestBody OrderStaticAddVO addVO) {
        Long merchantId = SecurityUtils.getUserId();
        addVO.setMerchantId(merchantId);
        return clientOrderService.addStatic(addVO);
    }

    @ApiOperation("数据统计")
    @GetMapping("/dataStatistics")
    public AjaxResult dataStatistics(@Valid ClientDataStatisticsVO dataStatisticsVO) {
        Long merchantId = SecurityUtils.getUserId();
        dataStatisticsVO.setMerchantId(merchantId);
        return clientOrderService.dataStatistics(dataStatisticsVO);
    }

    @ApiOperation("客户端下单动态IP")
    @PostMapping("/addDynamics")
    @OpenPlatform
    public AjaxResult addDynamics(@RequestBody OrderDynamicsAddVO addVO) {
        Long merchantId = SecurityUtils.getUserId();
        addVO.setMerchantId(merchantId);
        return clientOrderService.addDynamics(addVO);
    }

    @ApiOperation("订单列表")
    @GetMapping("/orderList")
    public TableDataInfo orderList(@Valid ClientOrderSearchVO searchVO) {
        startPage();
        Long merchantId = SecurityUtils.getUserId();
        searchVO.setMerchantId(merchantId);
        List<ClientOrderDetailDTO> list = clientOrderService.orderList(searchVO);
        return getDataTable(list);
    }

    @ApiOperation("订单详情")
    @GetMapping("/orderDetail/{orderId}")
    public AjaxResult orderDetail(@PathVariable("orderId") Long orderId) {
        return AjaxResult.success(clientOrderService.orderDetail(orderId));
    }

    @ApiOperation("已购买IP详情列表")
    @GetMapping("/purchasedList")
    @OpenPlatform
    public TableDataInfo purchasedList(@Valid PurchasedListSearchVO searchVO) {
        startPage();
        Long merchantId = SecurityUtils.getUserId();
        searchVO.setMerchantId(merchantId);
        List<ClientOrderItemStaticDTO> list = clientOrderService.purchasedList(searchVO);
        return getDataTable(list);
    }

    @ApiOperation("是否已购买")
    @GetMapping("/beenPurchased")
    public AjaxResult beenPurchased(@Valid BeenPurchasedVO beenPurchasedVO) {
        Long merchantId = SecurityUtils.getUserId();
        beenPurchasedVO.setMerchantId(merchantId);
        Boolean ret = clientOrderService.beenPurchased(beenPurchasedVO);
        return AjaxResult.success(ret);
    }

    @ApiOperation("客户端下单vps")
    @PostMapping("/addVps")
    public AjaxResult addVps(@RequestBody @Valid VpsOrderAddVO addVO) {
        Long merchantId = SecurityUtils.getUserId();
        addVO.setMerchantId(merchantId);
        return clientOrderService.addVpsOrder(addVO);
    }

    @ApiOperation("客户端退订静态ip订单部分ip")
    @PostMapping("/unsubscribeStaticIps")
    @OpenPlatform
    public AjaxResult unsubscribeStaticIps(@RequestBody UnsubscribeStaticIpVO staticIpVO) {
        Long merchantId = SecurityUtils.getUserId();
        staticIpVO.setMerchantId(merchantId);
        Boolean ret = clientOrderService.unsubscribeStaticIps(staticIpVO);
        return AjaxResult.success(ret);
    }

    @ApiOperation("客户端退订静态ip订单部分ip(字符串形式)")
    @PostMapping("/unsubscribeStaticStrIps")
    @OpenPlatform
    public AjaxResult unsubscribeStaticStrIps(@RequestBody UnsubscribeStaticStrIpsVO ipsVO) {
        Long merchantId = SecurityUtils.getUserId();
        ipsVO.setMerchantId(merchantId);
        Boolean ret = clientOrderService.unsubscribeStaticStrIps(ipsVO);
        return AjaxResult.success(ret);
    }

    @ApiOperation("订单列表")
    @PostMapping("/vpsOrderList")
    public AjaxResult vpsOrderList(@Valid @RequestBody ClientVpsOrderSearchVO searchVO) {
        ClientOrderVpsDetailDTO result = clientOrderService.vpsOrder(searchVO);
        return AjaxResult.success(result);
    }

    @ApiOperation("客户端退订vps")
    @PostMapping("/unsubscribeVps")
    public AjaxResult unsubscribeVps(@RequestBody UnsubscribeVpsVO unsubscribeVpsVO) {
        Long merchantId = SecurityUtils.getUserId();
        unsubscribeVpsVO.setMerchantId(merchantId);
        Boolean ret = clientOrderService.unsubscribeVps(unsubscribeVpsVO);
        return AjaxResult.success(ret);
    }

    @PostMapping("/renewIpList")
    @OpenPlatform
    public AjaxResult renewIpList(@RequestBody ReNewIpListVO reNewIpListVO) {
        Long merchantId = SecurityUtils.getUserId();
        return ipStaticPoolItemService.renewIpList(reNewIpListVO, merchantId);
    }

    @GetMapping("/getMerchantIpsByOrderNo")
    @OpenPlatform
    public AjaxResult getMerchantIpsByOrderNo(@Valid ClientMerchantIpsByOrderNoGetVO merchantIpsByOrderNoGetVO) {
        Long merchantId = SecurityUtils.getUserId();
        merchantIpsByOrderNoGetVO.setMerchantId(merchantId);
        return ipStaticPoolItemService.getMerchantIpsByOrderNo(merchantIpsByOrderNoGetVO);
    }
}