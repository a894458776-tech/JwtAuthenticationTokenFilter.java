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
import com.kylin.kton.system.domain.KtonVpsIpPool;
import com.kylin.kton.system.mapper.KtonVpsIpPoolMapper;
import com.kylin.kton.system.service.IKtonVpsIpPoolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonVpsIpPoolServiceImpl
implements IKtonVpsIpPoolService {
    @Autowired
    private KtonVpsIpPoolMapper ktonVpsIpPoolMapper;

    @Override
    public KtonVpsIpPool selectKtonVpsIpPoolById(Long id) {
        return this.ktonVpsIpPoolMapper.selectKtonVpsIpPoolById(id);
    }

    @Override
    public List<KtonVpsIpPool> selectKtonVpsIpPoolList(KtonVpsIpPool ktonVpsIpPool) {
        return this.ktonVpsIpPoolMapper.selectKtonVpsIpPoolList(ktonVpsIpPool);
    }

    @Override
    public int insertKtonVpsIpPool(KtonVpsIpPool ktonVpsIpPool) {
        ktonVpsIpPool.setCreateTime(DateUtils.getNowDate());
        return this.ktonVpsIpPoolMapper.insertKtonVpsIpPool(ktonVpsIpPool);
    }

    @Override
    public int updateKtonVpsIpPool(KtonVpsIpPool ktonVpsIpPool) {
        ktonVpsIpPool.setUpdateTime(DateUtils.getNowDate());
        return this.ktonVpsIpPoolMapper.updateKtonVpsIpPool(ktonVpsIpPool);
    }

    @Override
    public int deleteKtonVpsIpPoolByIds(Long[] ids) {
        return this.ktonVpsIpPoolMapper.deleteKtonVpsIpPoolByIds(ids);
    }

    @Override
    public int deleteKtonVpsIpPoolById(Long id) {
        return this.ktonVpsIpPoolMapper.deleteKtonVpsIpPoolById(id);
    }
}

