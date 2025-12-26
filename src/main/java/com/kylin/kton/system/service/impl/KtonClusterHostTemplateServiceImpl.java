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
import com.kylin.kton.system.domain.KtonClusterHostTemplate;
import com.kylin.kton.system.mapper.KtonClusterHostTemplateMapper;
import com.kylin.kton.system.service.IKtonClusterHostTemplateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonClusterHostTemplateServiceImpl
implements IKtonClusterHostTemplateService {
    @Autowired
    private KtonClusterHostTemplateMapper ktonClusterHostTemplateMapper;

    @Override
    public KtonClusterHostTemplate selectKtonClusterHostTemplateById(Long id) {
        return this.ktonClusterHostTemplateMapper.selectKtonClusterHostTemplateById(id);
    }

    @Override
    public List<KtonClusterHostTemplate> selectKtonClusterHostTemplateList(KtonClusterHostTemplate ktonClusterHostTemplate) {
        return this.ktonClusterHostTemplateMapper.selectKtonClusterHostTemplateList(ktonClusterHostTemplate);
    }

    @Override
    public int insertKtonClusterHostTemplate(KtonClusterHostTemplate ktonClusterHostTemplate) {
        ktonClusterHostTemplate.setCreateTime(DateUtils.getNowDate());
        return this.ktonClusterHostTemplateMapper.insertKtonClusterHostTemplate(ktonClusterHostTemplate);
    }

    @Override
    public int updateKtonClusterHostTemplate(KtonClusterHostTemplate ktonClusterHostTemplate) {
        ktonClusterHostTemplate.setUpdateTime(DateUtils.getNowDate());
        return this.ktonClusterHostTemplateMapper.updateKtonClusterHostTemplate(ktonClusterHostTemplate);
    }

    @Override
    public int deleteKtonClusterHostTemplateByIds(Long[] ids) {
        return this.ktonClusterHostTemplateMapper.deleteKtonClusterHostTemplateByIds(ids);
    }

    @Override
    public int deleteKtonClusterHostTemplateById(Long id) {
        return this.ktonClusterHostTemplateMapper.deleteKtonClusterHostTemplateById(id);
    }
}

