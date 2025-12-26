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
import com.kylin.kton.system.domain.KtonIpStaticSource;
import com.kylin.kton.system.mapper.KtonIpStaticSourceMapper;
import com.kylin.kton.system.service.IKtonIpStaticSourceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpStaticSourceServiceImpl
implements IKtonIpStaticSourceService {
    @Autowired
    private KtonIpStaticSourceMapper ktonIpStaticSourceMapper;

    @Override
    public KtonIpStaticSource selectKtonIpStaticSourceById(Long id) {
        return this.ktonIpStaticSourceMapper.selectKtonIpStaticSourceById(id);
    }

    @Override
    public List<KtonIpStaticSource> selectKtonIpStaticSourceList(KtonIpStaticSource ktonIpStaticSource) {
        return this.ktonIpStaticSourceMapper.selectKtonIpStaticSourceList(ktonIpStaticSource);
    }

    @Override
    public int insertKtonIpStaticSource(KtonIpStaticSource ktonIpStaticSource) {
        ktonIpStaticSource.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpStaticSourceMapper.insertKtonIpStaticSource(ktonIpStaticSource);
    }

    @Override
    public int updateKtonIpStaticSource(KtonIpStaticSource ktonIpStaticSource) {
        ktonIpStaticSource.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpStaticSourceMapper.updateKtonIpStaticSource(ktonIpStaticSource);
    }

    @Override
    public int deleteKtonIpStaticSourceByIds(Long[] ids) {
        return this.ktonIpStaticSourceMapper.deleteKtonIpStaticSourceByIds(ids);
    }

    @Override
    public int deleteKtonIpStaticSourceById(Long id) {
        return this.ktonIpStaticSourceMapper.deleteKtonIpStaticSourceById(id);
    }
}

