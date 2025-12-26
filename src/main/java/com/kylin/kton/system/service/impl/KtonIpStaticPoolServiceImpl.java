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
import com.kylin.kton.system.domain.KtonIpStaticPool;
import com.kylin.kton.system.mapper.KtonIpStaticPoolMapper;
import com.kylin.kton.system.service.IKtonIpStaticPoolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpStaticPoolServiceImpl
implements IKtonIpStaticPoolService {
    @Autowired
    private KtonIpStaticPoolMapper ktonIpStaticPoolMapper;

    @Override
    public KtonIpStaticPool selectKtonIpStaticPoolById(Long id) {
        return this.ktonIpStaticPoolMapper.selectKtonIpStaticPoolById(id);
    }

    @Override
    public List<KtonIpStaticPool> selectKtonIpStaticPoolList(KtonIpStaticPool ktonIpStaticPool) {
        return this.ktonIpStaticPoolMapper.selectKtonIpStaticPoolList(ktonIpStaticPool);
    }

    @Override
    public int insertKtonIpStaticPool(KtonIpStaticPool ktonIpStaticPool) {
        ktonIpStaticPool.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpStaticPoolMapper.insertKtonIpStaticPool(ktonIpStaticPool);
    }

    @Override
    public int updateKtonIpStaticPool(KtonIpStaticPool ktonIpStaticPool) {
        ktonIpStaticPool.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpStaticPoolMapper.updateKtonIpStaticPool(ktonIpStaticPool);
    }

    @Override
    public int deleteKtonIpStaticPoolByIds(Long[] ids) {
        return this.ktonIpStaticPoolMapper.deleteKtonIpStaticPoolByIds(ids);
    }

    @Override
    public int deleteKtonIpStaticPoolById(Long id) {
        return this.ktonIpStaticPoolMapper.deleteKtonIpStaticPoolById(id);
    }
}

