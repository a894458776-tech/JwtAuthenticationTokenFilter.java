/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonMessageRecords;
import java.util.List;

public interface KtonMessageRecordsMapper {
    public KtonMessageRecords selectKtonMessageRecordsById(Long var1);

    public List<KtonMessageRecords> selectKtonMessageRecordsList(KtonMessageRecords var1);

    public int insertKtonMessageRecords(KtonMessageRecords var1);

    public int updateKtonMessageRecords(KtonMessageRecords var1);

    public int deleteKtonMessageRecordsById(Long var1);

    public int deleteKtonMessageRecordsByIds(Long[] var1);
}

