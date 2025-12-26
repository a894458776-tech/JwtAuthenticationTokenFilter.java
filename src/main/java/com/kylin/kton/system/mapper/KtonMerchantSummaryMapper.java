/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonMerchantSummary;
import java.util.List;

public interface KtonMerchantSummaryMapper {
    public KtonMerchantSummary selectKtonMerchantSummaryById(Long var1);

    public List<KtonMerchantSummary> selectKtonMerchantSummaryList(KtonMerchantSummary var1);

    public int insertKtonMerchantSummary(KtonMerchantSummary var1);

    public int updateKtonMerchantSummary(KtonMerchantSummary var1);

    public int deleteKtonMerchantSummaryById(Long var1);

    public int deleteKtonMerchantSummaryByIds(Long[] var1);
}

