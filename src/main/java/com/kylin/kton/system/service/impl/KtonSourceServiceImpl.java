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
import com.kylin.kton.system.domain.KtonSource;
import com.kylin.kton.system.mapper.KtonSourceMapper;
import com.kylin.kton.system.service.IKtonSourceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonSourceServiceImpl
implements IKtonSourceService {
    @Autowired
    private KtonSourceMapper ktonSourceMapper;

    @Override
    public KtonSource selectKtonSourceById(Long id) {
        return this.ktonSourceMapper.selectKtonSourceById(id);
    }

    @Override
    public List<KtonSource> selectKtonSourceList(KtonSource ktonSource) {
        return this.ktonSourceMapper.selectKtonSourceList(ktonSource);
    }

    @Override
    public int insertKtonSource(KtonSource ktonSource) {
        ktonSource.setCreateTime(DateUtils.getNowDate());
        return this.ktonSourceMapper.insertKtonSource(ktonSource);
    }

    @Override
    public int updateKtonSource(KtonSource ktonSource) {
        ktonSource.setUpdateTime(DateUtils.getNowDate());
        return this.ktonSourceMapper.updateKtonSource(ktonSource);
    }

    @Override
    public int deleteKtonSourceByIds(Long[] ids) {
        return this.ktonSourceMapper.deleteKtonSourceByIds(ids);
    }

    @Override
    public int deleteKtonSourceById(Long id) {
        return this.ktonSourceMapper.deleteKtonSourceById(id);
    }
}

