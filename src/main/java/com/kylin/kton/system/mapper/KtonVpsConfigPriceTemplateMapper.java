/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonVpsConfigPriceTemplate;
import java.util.List;

public interface KtonVpsConfigPriceTemplateMapper {
    public KtonVpsConfigPriceTemplate selectKtonVpsConfigPriceTemplateById(Long var1);

    public List<KtonVpsConfigPriceTemplate> selectKtonVpsConfigPriceTemplateList(KtonVpsConfigPriceTemplate var1);

    public int insertKtonVpsConfigPriceTemplate(KtonVpsConfigPriceTemplate var1);

    public int updateKtonVpsConfigPriceTemplate(KtonVpsConfigPriceTemplate var1);

    public int deleteKtonVpsConfigPriceTemplateById(Long var1);

    public int deleteKtonVpsConfigPriceTemplateByIds(Long[] var1);
}

