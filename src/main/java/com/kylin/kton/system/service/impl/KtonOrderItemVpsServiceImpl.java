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
import com.kylin.kton.system.domain.KtonOrderItemVps;
import com.kylin.kton.system.mapper.KtonOrderItemVpsMapper;
import com.kylin.kton.system.service.IKtonOrderItemVpsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonOrderItemVpsServiceImpl
implements IKtonOrderItemVpsService {
    @Autowired
    private KtonOrderItemVpsMapper ktonOrderItemVpsMapper;

    @Override
    public KtonOrderItemVps selectKtonOrderItemVpsById(Long id) {
        return this.ktonOrderItemVpsMapper.selectKtonOrderItemVpsById(id);
    }

    @Override
    public List<KtonOrderItemVps> selectKtonOrderItemVpsList(KtonOrderItemVps ktonOrderItemVps) {
        return this.ktonOrderItemVpsMapper.selectKtonOrderItemVpsList(ktonOrderItemVps);
    }

    @Override
    public int insertKtonOrderItemVps(KtonOrderItemVps ktonOrderItemVps) {
        ktonOrderItemVps.setCreateTime(DateUtils.getNowDate());
        return this.ktonOrderItemVpsMapper.insertKtonOrderItemVps(ktonOrderItemVps);
    }

    @Override
    public int updateKtonOrderItemVps(KtonOrderItemVps ktonOrderItemVps) {
        ktonOrderItemVps.setUpdateTime(DateUtils.getNowDate());
        return this.ktonOrderItemVpsMapper.updateKtonOrderItemVps(ktonOrderItemVps);
    }

    @Override
    public int deleteKtonOrderItemVpsByIds(Long[] ids) {
        return this.ktonOrderItemVpsMapper.deleteKtonOrderItemVpsByIds(ids);
    }

    @Override
    public int deleteKtonOrderItemVpsById(Long id) {
        return this.ktonOrderItemVpsMapper.deleteKtonOrderItemVpsById(id);
    }
}

