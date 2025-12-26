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
import com.kylin.kton.system.domain.KtonMerchantSummary;
import com.kylin.kton.system.mapper.KtonMerchantSummaryMapper;
import com.kylin.kton.system.service.IKtonMerchantSummaryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonMerchantSummaryServiceImpl
implements IKtonMerchantSummaryService {
    @Autowired
    private KtonMerchantSummaryMapper ktonMerchantSummaryMapper;

    @Override
    public KtonMerchantSummary selectKtonMerchantSummaryById(Long id) {
        return this.ktonMerchantSummaryMapper.selectKtonMerchantSummaryById(id);
    }

    @Override
    public List<KtonMerchantSummary> selectKtonMerchantSummaryList(KtonMerchantSummary ktonMerchantSummary) {
        return this.ktonMerchantSummaryMapper.selectKtonMerchantSummaryList(ktonMerchantSummary);
    }

    @Override
    public int insertKtonMerchantSummary(KtonMerchantSummary ktonMerchantSummary) {
        ktonMerchantSummary.setCreateTime(DateUtils.getNowDate());
        return this.ktonMerchantSummaryMapper.insertKtonMerchantSummary(ktonMerchantSummary);
    }

    @Override
    public int updateKtonMerchantSummary(KtonMerchantSummary ktonMerchantSummary) {
        ktonMerchantSummary.setUpdateTime(DateUtils.getNowDate());
        return this.ktonMerchantSummaryMapper.updateKtonMerchantSummary(ktonMerchantSummary);
    }

    @Override
    public int deleteKtonMerchantSummaryByIds(Long[] ids) {
        return this.ktonMerchantSummaryMapper.deleteKtonMerchantSummaryByIds(ids);
    }

    @Override
    public int deleteKtonMerchantSummaryById(Long id) {
        return this.ktonMerchantSummaryMapper.deleteKtonMerchantSummaryById(id);
    }
}

