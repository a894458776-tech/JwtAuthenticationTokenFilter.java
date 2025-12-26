/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonOrder;
import java.util.List;

public interface KtonOrderMapper {
    public KtonOrder selectKtonOrderById(Long var1);

    public List<KtonOrder> selectKtonOrderList(KtonOrder var1);

    public int insertKtonOrder(KtonOrder var1);

    public int updateKtonOrder(KtonOrder var1);

    public int deleteKtonOrderById(Long var1);

    public int deleteKtonOrderByIds(Long[] var1);
}

