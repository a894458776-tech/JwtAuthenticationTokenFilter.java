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
import com.kylin.kton.system.domain.KtonOrder;
import com.kylin.kton.system.mapper.KtonOrderMapper;
import com.kylin.kton.system.service.IKtonOrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonOrderServiceImpl
implements IKtonOrderService {
    @Autowired
    private KtonOrderMapper ktonOrderMapper;

    @Override
    public KtonOrder selectKtonOrderById(Long id) {
        return this.ktonOrderMapper.selectKtonOrderById(id);
    }

    @Override
    public List<KtonOrder> selectKtonOrderList(KtonOrder ktonOrder) {
        return this.ktonOrderMapper.selectKtonOrderList(ktonOrder);
    }

    @Override
    public int insertKtonOrder(KtonOrder ktonOrder) {
        ktonOrder.setCreateTime(DateUtils.getNowDate());
        return this.ktonOrderMapper.insertKtonOrder(ktonOrder);
    }

    @Override
    public int updateKtonOrder(KtonOrder ktonOrder) {
        ktonOrder.setUpdateTime(DateUtils.getNowDate());
        return this.ktonOrderMapper.updateKtonOrder(ktonOrder);
    }

    @Override
    public int deleteKtonOrderByIds(Long[] ids) {
        return this.ktonOrderMapper.deleteKtonOrderByIds(ids);
    }

    @Override
    public int deleteKtonOrderById(Long id) {
        return this.ktonOrderMapper.deleteKtonOrderById(id);
    }
}

