/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.system.service.IKtonIpStaticPoolItemService
 */
package com.kylin.kton.client.ip.service;

import com.kylin.kton.client.ip.entity.dto.ClientIpStaticPoolMerchantDTO;
import com.kylin.kton.client.ip.entity.vo.IpStaticPoolItemSearchVO;
import com.kylin.kton.client.ip.entity.vo.ReNewIpListVO;
import com.kylin.kton.client.order.entity.vo.ClientMerchantIpsByOrderNoGetVO;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.system.service.IKtonIpStaticPoolItemService;
import java.util.List;

public interface ClientIpStaticPoolItemService
extends IKtonIpStaticPoolItemService {
    public List<ClientIpStaticPoolMerchantDTO> merchantIpList(IpStaticPoolItemSearchVO var1);

    public AjaxResult renewIpList(ReNewIpListVO var1, Long var2);

    public AjaxResult getMerchantIpsByOrderNo(ClientMerchantIpsByOrderNoGetVO var1);
}

