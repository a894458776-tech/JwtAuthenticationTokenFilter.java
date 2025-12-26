/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.system.service.IKtonOrderService
 */
package com.kylin.kton.client.order.service;

import com.kylin.kton.client.order.entity.dto.ClientOrderDetailDTO;
import com.kylin.kton.client.order.entity.dto.ClientOrderItemStaticDTO;
import com.kylin.kton.client.order.entity.dto.ClientOrderVpsDetailDTO;
import com.kylin.kton.client.order.entity.vo.BeenPurchasedVO;
import com.kylin.kton.client.order.entity.vo.ClientDataStatisticsVO;
import com.kylin.kton.client.order.entity.vo.ClientOrderSearchVO;
import com.kylin.kton.client.order.entity.vo.ClientVpsOrderSearchVO;
import com.kylin.kton.client.order.entity.vo.OrderDynamicsAddVO;
import com.kylin.kton.client.order.entity.vo.OrderStaticAddVO;
import com.kylin.kton.client.order.entity.vo.PurchasedListSearchVO;
import com.kylin.kton.client.order.entity.vo.UnsubscribeStaticIpVO;
import com.kylin.kton.client.order.entity.vo.UnsubscribeStaticStrIpsVO;
import com.kylin.kton.client.order.entity.vo.UnsubscribeVpsVO;
import com.kylin.kton.client.order.entity.vo.VpsOrderAddVO;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.system.service.IKtonOrderService;
import java.util.List;

public interface ClientOrderService
extends IKtonOrderService {
    public AjaxResult addStatic(OrderStaticAddVO var1);

    public AjaxResult dataStatistics(ClientDataStatisticsVO var1);

    public AjaxResult addDynamics(OrderDynamicsAddVO var1);

    public AjaxResult addVpsOrder(VpsOrderAddVO var1);

    public ClientOrderDetailDTO orderDetail(Long var1);

    public List<ClientOrderItemStaticDTO> purchasedList(PurchasedListSearchVO var1);

    public Boolean beenPurchased(BeenPurchasedVO var1);

    public Boolean unsubscribeStaticIps(UnsubscribeStaticIpVO var1);

    public Boolean unsubscribeStaticStrIps(UnsubscribeStaticStrIpsVO var1);

    public List<ClientOrderDetailDTO> orderList(ClientOrderSearchVO var1);

    public ClientOrderVpsDetailDTO vpsOrder(ClientVpsOrderSearchVO var1);

    public Boolean unsubscribeVps(UnsubscribeVpsVO var1);
}

