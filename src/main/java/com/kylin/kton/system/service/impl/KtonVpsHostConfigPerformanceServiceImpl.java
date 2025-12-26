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
import com.kylin.kton.system.domain.KtonVpsHostConfigPerformance;
import com.kylin.kton.system.mapper.KtonVpsHostConfigPerformanceMapper;
import com.kylin.kton.system.service.IKtonVpsHostConfigPerformanceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonVpsHostConfigPerformanceServiceImpl
implements IKtonVpsHostConfigPerformanceService {
    @Autowired
    private KtonVpsHostConfigPerformanceMapper ktonVpsHostConfigPerformanceMapper;

    @Override
    public KtonVpsHostConfigPerformance selectKtonVpsHostConfigPerformanceById(Long id) {
        return this.ktonVpsHostConfigPerformanceMapper.selectKtonVpsHostConfigPerformanceById(id);
    }

    @Override
    public List<KtonVpsHostConfigPerformance> selectKtonVpsHostConfigPerformanceList(KtonVpsHostConfigPerformance ktonVpsHostConfigPerformance) {
        return this.ktonVpsHostConfigPerformanceMapper.selectKtonVpsHostConfigPerformanceList(ktonVpsHostConfigPerformance);
    }

    @Override
    public int insertKtonVpsHostConfigPerformance(KtonVpsHostConfigPerformance ktonVpsHostConfigPerformance) {
        ktonVpsHostConfigPerformance.setCreateTime(DateUtils.getNowDate());
        return this.ktonVpsHostConfigPerformanceMapper.insertKtonVpsHostConfigPerformance(ktonVpsHostConfigPerformance);
    }

    @Override
    public int updateKtonVpsHostConfigPerformance(KtonVpsHostConfigPerformance ktonVpsHostConfigPerformance) {
        ktonVpsHostConfigPerformance.setUpdateTime(DateUtils.getNowDate());
        return this.ktonVpsHostConfigPerformanceMapper.updateKtonVpsHostConfigPerformance(ktonVpsHostConfigPerformance);
    }

    @Override
    public int deleteKtonVpsHostConfigPerformanceByIds(Long[] ids) {
        return this.ktonVpsHostConfigPerformanceMapper.deleteKtonVpsHostConfigPerformanceByIds(ids);
    }

    @Override
    public int deleteKtonVpsHostConfigPerformanceById(Long id) {
        return this.ktonVpsHostConfigPerformanceMapper.deleteKtonVpsHostConfigPerformanceById(id);
    }
}

