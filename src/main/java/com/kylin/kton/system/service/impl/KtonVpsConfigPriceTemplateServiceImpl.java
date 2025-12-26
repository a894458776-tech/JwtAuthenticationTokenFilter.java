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
import com.kylin.kton.system.domain.KtonVpsConfigPriceTemplate;
import com.kylin.kton.system.mapper.KtonVpsConfigPriceTemplateMapper;
import com.kylin.kton.system.service.IKtonVpsConfigPriceTemplateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonVpsConfigPriceTemplateServiceImpl
implements IKtonVpsConfigPriceTemplateService {
    @Autowired
    private KtonVpsConfigPriceTemplateMapper ktonVpsConfigPriceTemplateMapper;

    @Override
    public KtonVpsConfigPriceTemplate selectKtonVpsConfigPriceTemplateById(Long id) {
        return this.ktonVpsConfigPriceTemplateMapper.selectKtonVpsConfigPriceTemplateById(id);
    }

    @Override
    public List<KtonVpsConfigPriceTemplate> selectKtonVpsConfigPriceTemplateList(KtonVpsConfigPriceTemplate ktonVpsConfigPriceTemplate) {
        return this.ktonVpsConfigPriceTemplateMapper.selectKtonVpsConfigPriceTemplateList(ktonVpsConfigPriceTemplate);
    }

    @Override
    public int insertKtonVpsConfigPriceTemplate(KtonVpsConfigPriceTemplate ktonVpsConfigPriceTemplate) {
        ktonVpsConfigPriceTemplate.setCreateTime(DateUtils.getNowDate());
        return this.ktonVpsConfigPriceTemplateMapper.insertKtonVpsConfigPriceTemplate(ktonVpsConfigPriceTemplate);
    }

    @Override
    public int updateKtonVpsConfigPriceTemplate(KtonVpsConfigPriceTemplate ktonVpsConfigPriceTemplate) {
        ktonVpsConfigPriceTemplate.setUpdateTime(DateUtils.getNowDate());
        return this.ktonVpsConfigPriceTemplateMapper.updateKtonVpsConfigPriceTemplate(ktonVpsConfigPriceTemplate);
    }

    @Override
    public int deleteKtonVpsConfigPriceTemplateByIds(Long[] ids) {
        return this.ktonVpsConfigPriceTemplateMapper.deleteKtonVpsConfigPriceTemplateByIds(ids);
    }

    @Override
    public int deleteKtonVpsConfigPriceTemplateById(Long id) {
        return this.ktonVpsConfigPriceTemplateMapper.deleteKtonVpsConfigPriceTemplateById(id);
    }
}

