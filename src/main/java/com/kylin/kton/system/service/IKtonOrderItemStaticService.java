/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonOrderItemStatic;
import java.util.List;

public interface IKtonOrderItemStaticService {
    public KtonOrderItemStatic selectKtonOrderItemStaticById(Long var1);

    public List<KtonOrderItemStatic> selectKtonOrderItemStaticList(KtonOrderItemStatic var1);

    public int insertKtonOrderItemStatic(KtonOrderItemStatic var1);

    public int updateKtonOrderItemStatic(KtonOrderItemStatic var1);

    public int deleteKtonOrderItemStaticByIds(Long[] var1);

    public int deleteKtonOrderItemStaticById(Long var1);
}

