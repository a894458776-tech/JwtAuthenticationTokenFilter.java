/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonVpsHostConfigPerformance;
import java.util.List;

public interface IKtonVpsHostConfigPerformanceService {
    public KtonVpsHostConfigPerformance selectKtonVpsHostConfigPerformanceById(Long var1);

    public List<KtonVpsHostConfigPerformance> selectKtonVpsHostConfigPerformanceList(KtonVpsHostConfigPerformance var1);

    public int insertKtonVpsHostConfigPerformance(KtonVpsHostConfigPerformance var1);

    public int updateKtonVpsHostConfigPerformance(KtonVpsHostConfigPerformance var1);

    public int deleteKtonVpsHostConfigPerformanceByIds(Long[] var1);

    public int deleteKtonVpsHostConfigPerformanceById(Long var1);
}

