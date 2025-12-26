/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonOrderItemVps;
import java.util.List;

public interface KtonOrderItemVpsMapper {
    public KtonOrderItemVps selectKtonOrderItemVpsById(Long var1);

    public List<KtonOrderItemVps> selectKtonOrderItemVpsList(KtonOrderItemVps var1);

    public int insertKtonOrderItemVps(KtonOrderItemVps var1);

    public int updateKtonOrderItemVps(KtonOrderItemVps var1);

    public int deleteKtonOrderItemVpsById(Long var1);

    public int deleteKtonOrderItemVpsByIds(Long[] var1);
}

