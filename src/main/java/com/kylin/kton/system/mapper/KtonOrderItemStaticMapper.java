/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonOrderItemStatic;
import java.util.List;

public interface KtonOrderItemStaticMapper {
    public KtonOrderItemStatic selectKtonOrderItemStaticById(Long var1);

    public List<KtonOrderItemStatic> selectKtonOrderItemStaticList(KtonOrderItemStatic var1);

    public int insertKtonOrderItemStatic(KtonOrderItemStatic var1);

    public int updateKtonOrderItemStatic(KtonOrderItemStatic var1);

    public int deleteKtonOrderItemStaticById(Long var1);

    public int deleteKtonOrderItemStaticByIds(Long[] var1);
}

