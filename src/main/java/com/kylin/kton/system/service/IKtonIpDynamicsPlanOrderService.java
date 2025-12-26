/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonIpDynamicsPlanOrder;
import java.util.List;

public interface IKtonIpDynamicsPlanOrderService {
    public KtonIpDynamicsPlanOrder selectKtonIpDynamicsPlanOrderById(Long var1);

    public List<KtonIpDynamicsPlanOrder> selectKtonIpDynamicsPlanOrderList(KtonIpDynamicsPlanOrder var1);

    public int insertKtonIpDynamicsPlanOrder(KtonIpDynamicsPlanOrder var1);

    public int updateKtonIpDynamicsPlanOrder(KtonIpDynamicsPlanOrder var1);

    public int deleteKtonIpDynamicsPlanOrderByIds(Long[] var1);

    public int deleteKtonIpDynamicsPlanOrderById(Long var1);
}

