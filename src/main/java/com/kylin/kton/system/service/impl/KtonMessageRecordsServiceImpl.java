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
import com.kylin.kton.system.domain.KtonMessageRecords;
import com.kylin.kton.system.mapper.KtonMessageRecordsMapper;
import com.kylin.kton.system.service.IKtonMessageRecordsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonMessageRecordsServiceImpl
implements IKtonMessageRecordsService {
    @Autowired
    private KtonMessageRecordsMapper ktonMessageRecordsMapper;

    @Override
    public KtonMessageRecords selectKtonMessageRecordsById(Long id) {
        return this.ktonMessageRecordsMapper.selectKtonMessageRecordsById(id);
    }

    @Override
    public List<KtonMessageRecords> selectKtonMessageRecordsList(KtonMessageRecords ktonMessageRecords) {
        return this.ktonMessageRecordsMapper.selectKtonMessageRecordsList(ktonMessageRecords);
    }

    @Override
    public int insertKtonMessageRecords(KtonMessageRecords ktonMessageRecords) {
        ktonMessageRecords.setCreateTime(DateUtils.getNowDate());
        return this.ktonMessageRecordsMapper.insertKtonMessageRecords(ktonMessageRecords);
    }

    @Override
    public int updateKtonMessageRecords(KtonMessageRecords ktonMessageRecords) {
        ktonMessageRecords.setUpdateTime(DateUtils.getNowDate());
        return this.ktonMessageRecordsMapper.updateKtonMessageRecords(ktonMessageRecords);
    }

    @Override
    public int deleteKtonMessageRecordsByIds(Long[] ids) {
        return this.ktonMessageRecordsMapper.deleteKtonMessageRecordsByIds(ids);
    }

    @Override
    public int deleteKtonMessageRecordsById(Long id) {
        return this.ktonMessageRecordsMapper.deleteKtonMessageRecordsById(id);
    }
}

