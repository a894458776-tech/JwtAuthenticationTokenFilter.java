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
import com.kylin.kton.system.domain.KtonVpsHostContainerParam;
import com.kylin.kton.system.mapper.KtonVpsHostContainerParamMapper;
import com.kylin.kton.system.service.IKtonVpsHostContainerParamService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonVpsHostContainerParamServiceImpl
implements IKtonVpsHostContainerParamService {
    @Autowired
    private KtonVpsHostContainerParamMapper ktonVpsHostContainerParamMapper;

    @Override
    public KtonVpsHostContainerParam selectKtonVpsHostContainerParamById(Long id) {
        return this.ktonVpsHostContainerParamMapper.selectKtonVpsHostContainerParamById(id);
    }

    @Override
    public List<KtonVpsHostContainerParam> selectKtonVpsHostContainerParamList(KtonVpsHostContainerParam ktonVpsHostContainerParam) {
        return this.ktonVpsHostContainerParamMapper.selectKtonVpsHostContainerParamList(ktonVpsHostContainerParam);
    }

    @Override
    public int insertKtonVpsHostContainerParam(KtonVpsHostContainerParam ktonVpsHostContainerParam) {
        ktonVpsHostContainerParam.setCreateTime(DateUtils.getNowDate());
        return this.ktonVpsHostContainerParamMapper.insertKtonVpsHostContainerParam(ktonVpsHostContainerParam);
    }

    @Override
    public int updateKtonVpsHostContainerParam(KtonVpsHostContainerParam ktonVpsHostContainerParam) {
        ktonVpsHostContainerParam.setUpdateTime(DateUtils.getNowDate());
        return this.ktonVpsHostContainerParamMapper.updateKtonVpsHostContainerParam(ktonVpsHostContainerParam);
    }

    @Override
    public int deleteKtonVpsHostContainerParamByIds(Long[] ids) {
        return this.ktonVpsHostContainerParamMapper.deleteKtonVpsHostContainerParamByIds(ids);
    }

    @Override
    public int deleteKtonVpsHostContainerParamById(Long id) {
        return this.ktonVpsHostContainerParamMapper.deleteKtonVpsHostContainerParamById(id);
    }
}

