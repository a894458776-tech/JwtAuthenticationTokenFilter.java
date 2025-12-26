/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.utils.DateUtils
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.system.service.impl;

import com.kylin.kton.common.utils.DateUtils;
import com.kylin.kton.system.domain.KtonIpDynamicsPlanOrder;
import com.kylin.kton.system.mapper.KtonIpDynamicsPlanOrderMapper;
import com.kylin.kton.system.service.IKtonIpDynamicsPlanOrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpDynamicsPlanOrderServiceImpl
implements IKtonIpDynamicsPlanOrderService {
    @Autowired
    private KtonIpDynamicsPlanOrderMapper ktonIpDynamicsPlanOrderMapper;

    @Override
    public KtonIpDynamicsPlanOrder selectKtonIpDynamicsPlanOrderById(Long id) {
        return this.ktonIpDynamicsPlanOrderMapper.selectKtonIpDynamicsPlanOrderById(id);
    }

    @Override
    public List<KtonIpDynamicsPlanOrder> selectKtonIpDynamicsPlanOrderList(KtonIpDynamicsPlanOrder ktonIpDynamicsPlanOrder) {
        return this.ktonIpDynamicsPlanOrderMapper.selectKtonIpDynamicsPlanOrderList(ktonIpDynamicsPlanOrder);
    }

    @Override
    public int insertKtonIpDynamicsPlanOrder(KtonIpDynamicsPlanOrder ktonIpDynamicsPlanOrder) {
        ktonIpDynamicsPlanOrder.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsPlanOrderMapper.insertKtonIpDynamicsPlanOrder(ktonIpDynamicsPlanOrder);
    }

    @Override
    public int updateKtonIpDynamicsPlanOrder(KtonIpDynamicsPlanOrder ktonIpDynamicsPlanOrder) {
        ktonIpDynamicsPlanOrder.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpDynamicsPlanOrderMapper.updateKtonIpDynamicsPlanOrder(ktonIpDynamicsPlanOrder);
    }

    @Override
    public int deleteKtonIpDynamicsPlanOrderByIds(Long[] ids) {
        return this.ktonIpDynamicsPlanOrderMapper.deleteKtonIpDynamicsPlanOrderByIds(ids);
    }

    @Override
    public int deleteKtonIpDynamicsPlanOrderById(Long id) {
        return this.ktonIpDynamicsPlanOrderMapper.deleteKtonIpDynamicsPlanOrderById(id);
    }
}

