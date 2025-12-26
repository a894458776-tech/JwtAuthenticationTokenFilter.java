/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.annotation.OpenPlatform
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.utils.SecurityUtils
 *  com.kylin.kton.system.domain.KtonMerchantWallet
 *  com.kylin.kton.system.domain.KtonOrder
 *  com.kylin.kton.system.mapper.KtonMerchantWalletMapper
 *  com.kylin.kton.system.mapper.KtonOrderMapper
 *  io.swagger.annotations.Api
 *  io.swagger.annotations.ApiOperation
 *  javax.annotation.Resource
 *  javax.validation.Valid
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.PostMapping
 *  org.springframework.web.bind.annotation.RequestBody
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.client.payment.base.controller;

import com.kylin.kton.client.order.mapper.ClientOrderDao;
import com.kylin.kton.client.payment.base.entity.dto.PayResultDTO;
import com.kylin.kton.client.payment.base.entity.vo.PayOrderVO;
import com.kylin.kton.client.payment.base.service.PayService;
import com.kylin.kton.common.annotation.OpenPlatform;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.utils.SecurityUtils;
import com.kylin.kton.system.domain.KtonMerchantWallet;
import com.kylin.kton.system.domain.KtonOrder;
import com.kylin.kton.system.mapper.KtonMerchantWalletMapper;
import com.kylin.kton.system.mapper.KtonOrderMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags={"\u652f\u4ed8\u4e2d\u5fc3\u6a21\u5757"})
@RestController
@RequestMapping(value={"/client/payment/order"})
public class PayOrderController {
    @Resource
    List<PayService> payServices;
    @Resource
    KtonOrderMapper ktonOrderMapper;
    @Resource
    ClientOrderDao clientOrderDao;
    @Resource
    KtonMerchantWalletMapper ktonMerchantWalletMapper;

    @ApiOperation(value="\u8ba2\u5355\u652f\u4ed8")
    @PostMapping(value={"pay/{orderNo}"})
    @OpenPlatform
    public AjaxResult payOrder(@PathVariable(value="orderNo") String orderNo, @Valid @RequestBody PayOrderVO payOrderVO) {
        BigDecimal totalAmount;
        KtonOrder order = this.clientOrderDao.getByOrderNo(SecurityUtils.getUserId(), orderNo, null);
        if (order.getPaidStatus() != 10L) {
            return AjaxResult.error((String)"\u8ba2\u5355\u5df2\u5931\u6548");
        }
        KtonMerchantWallet assets = this.ktonMerchantWalletMapper.selectKtonMerchantWalletByMerchantId(order.getMerchantId());
        if (assets == null) {
            return AjaxResult.error((String)"\u5546\u6237\u94b1\u5305\u8d26\u6237\u4e0d\u5b58\u5728");
        }
        BigDecimal balance = assets.getBalance();
        if (balance.compareTo(totalAmount = order.getTotalAmount()) < 0) {
            return AjaxResult.error((String)"\u4f59\u989d\u4e0d\u8db3");
        }
        PayResultDTO resultDTO = new PayResultDTO();
        for (PayService payService : this.payServices) {
            if (!payOrderVO.getPayment().equalsIgnoreCase(payService.getPayment().name())) continue;
            resultDTO = payService.pay(order.getId());
            break;
        }
        return AjaxResult.success((Object)resultDTO);
    }
}

