/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonClusterHostTemplate;
import java.util.List;

public interface IKtonClusterHostTemplateService {
    public KtonClusterHostTemplate selectKtonClusterHostTemplateById(Long var1);

    public List<KtonClusterHostTemplate> selectKtonClusterHostTemplateList(KtonClusterHostTemplate var1);

    public int insertKtonClusterHostTemplate(KtonClusterHostTemplate var1);

    public int updateKtonClusterHostTemplate(KtonClusterHostTemplate var1);

    public int deleteKtonClusterHostTemplateByIds(Long[] var1);

    public int deleteKtonClusterHostTemplateById(Long var1);
}

