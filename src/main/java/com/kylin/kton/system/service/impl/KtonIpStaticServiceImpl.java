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
import com.kylin.kton.system.domain.KtonIpStatic;
import com.kylin.kton.system.mapper.KtonIpStaticMapper;
import com.kylin.kton.system.service.IKtonIpStaticService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpStaticServiceImpl
implements IKtonIpStaticService {
    @Autowired
    private KtonIpStaticMapper ktonIpStaticMapper;

    @Override
    public KtonIpStatic selectKtonIpStaticById(Long id) {
        return this.ktonIpStaticMapper.selectKtonIpStaticById(id);
    }

    @Override
    public List<KtonIpStatic> selectKtonIpStaticList(KtonIpStatic ktonIpStatic) {
        return this.ktonIpStaticMapper.selectKtonIpStaticList(ktonIpStatic);
    }

    @Override
    public int insertKtonIpStatic(KtonIpStatic ktonIpStatic) {
        ktonIpStatic.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpStaticMapper.insertKtonIpStatic(ktonIpStatic);
    }

    @Override
    public int updateKtonIpStatic(KtonIpStatic ktonIpStatic) {
        ktonIpStatic.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpStaticMapper.updateKtonIpStatic(ktonIpStatic);
    }

    @Override
    public int deleteKtonIpStaticByIds(Long[] ids) {
        return this.ktonIpStaticMapper.deleteKtonIpStaticByIds(ids);
    }

    @Override
    public int deleteKtonIpStaticById(Long id) {
        return this.ktonIpStaticMapper.deleteKtonIpStaticById(id);
    }
}

