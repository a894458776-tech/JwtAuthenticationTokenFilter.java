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
import com.kylin.kton.system.domain.KtonIpDetect;
import com.kylin.kton.system.mapper.KtonIpDetectMapper;
import com.kylin.kton.system.service.IKtonIpDetectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpDetectServiceImpl
implements IKtonIpDetectService {
    @Autowired
    private KtonIpDetectMapper ktonIpDetectMapper;

    @Override
    public KtonIpDetect selectKtonIpDetectById(String id) {
        return this.ktonIpDetectMapper.selectKtonIpDetectById(id);
    }

    @Override
    public List<KtonIpDetect> selectKtonIpDetectList(KtonIpDetect ktonIpDetect) {
        return this.ktonIpDetectMapper.selectKtonIpDetectList(ktonIpDetect);
    }

    @Override
    public int insertKtonIpDetect(KtonIpDetect ktonIpDetect) {
        ktonIpDetect.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpDetectMapper.insertKtonIpDetect(ktonIpDetect);
    }

    @Override
    public int updateKtonIpDetect(KtonIpDetect ktonIpDetect) {
        ktonIpDetect.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpDetectMapper.updateKtonIpDetect(ktonIpDetect);
    }

    @Override
    public int deleteKtonIpDetectByIds(String[] ids) {
        return this.ktonIpDetectMapper.deleteKtonIpDetectByIds(ids);
    }

    @Override
    public int deleteKtonIpDetectById(String id) {
        return this.ktonIpDetectMapper.deleteKtonIpDetectById(id);
    }
}

