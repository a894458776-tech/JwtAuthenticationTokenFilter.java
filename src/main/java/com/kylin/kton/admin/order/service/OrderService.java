/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.system.service.IKtonOrderService
 */
package com.kylin.kton.admin.order.service;

import com.kylin.kton.admin.order.entity.dto.AdminOrderDTO;
import com.kylin.kton.admin.order.entity.dto.AdminOrderDetailDTO;
import com.kylin.kton.admin.order.entity.dto.AdminOrderItemStaticDTO;
import com.kylin.kton.admin.order.entity.vo.AdminOrderSearchVO;
import com.kylin.kton.admin.order.entity.vo.AdminOrderStaticAddVO;
import com.kylin.kton.admin.order.entity.vo.AdminProcessIpReplacementVO;
import com.kylin.kton.admin.order.entity.vo.AdminReNewIpListVO;
import com.kylin.kton.admin.order.entity.vo.AdminUnsubscribeStaticStrIpsVO;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.system.service.IKtonOrderService;
import java.util.List;

public interface OrderService
extends IKtonOrderService {
    public List<AdminOrderDTO> list(AdminOrderSearchVO var1);

    public AdminOrderDetailDTO detail(Long var1);

    public List<AdminOrderItemStaticDTO> expireList();

    public String addStatic(AdminOrderStaticAddVO var1);

    public Boolean unsubscribeStaticStrIps(AdminUnsubscribeStaticStrIpsVO var1);

    public AjaxResult renewIpList(AdminReNewIpListVO var1);

    public AjaxResult processIpReplacement(AdminProcessIpReplacementVO var1);
}

