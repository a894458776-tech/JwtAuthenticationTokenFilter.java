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
import com.kylin.kton.system.domain.KtonIpBase;
import com.kylin.kton.system.mapper.KtonIpBaseMapper;
import com.kylin.kton.system.service.IKtonIpBaseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpBaseServiceImpl
implements IKtonIpBaseService {
    @Autowired
    private KtonIpBaseMapper ktonIpBaseMapper;

    @Override
    public KtonIpBase selectKtonIpBaseById(String id) {
        return this.ktonIpBaseMapper.selectKtonIpBaseById(id);
    }

    @Override
    public List<KtonIpBase> selectKtonIpBaseList(KtonIpBase ktonIpBase) {
        return this.ktonIpBaseMapper.selectKtonIpBaseList(ktonIpBase);
    }

    @Override
    public int insertKtonIpBase(KtonIpBase ktonIpBase) {
        ktonIpBase.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpBaseMapper.insertKtonIpBase(ktonIpBase);
    }

    @Override
    public int updateKtonIpBase(KtonIpBase ktonIpBase) {
        ktonIpBase.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpBaseMapper.updateKtonIpBase(ktonIpBase);
    }

    @Override
    public int deleteKtonIpBaseByIds(String[] ids) {
        return this.ktonIpBaseMapper.deleteKtonIpBaseByIds(ids);
    }

    @Override
    public int deleteKtonIpBaseById(String id) {
        return this.ktonIpBaseMapper.deleteKtonIpBaseById(id);
    }
}

