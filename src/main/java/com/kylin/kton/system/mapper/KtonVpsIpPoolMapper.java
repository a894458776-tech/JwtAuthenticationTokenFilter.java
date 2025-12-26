/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonVpsIpPool;
import java.util.List;

public interface KtonVpsIpPoolMapper {
    public KtonVpsIpPool selectKtonVpsIpPoolById(Long var1);

    public List<KtonVpsIpPool> selectKtonVpsIpPoolList(KtonVpsIpPool var1);

    public int insertKtonVpsIpPool(KtonVpsIpPool var1);

    public int updateKtonVpsIpPool(KtonVpsIpPool var1);

    public int deleteKtonVpsIpPoolById(Long var1);

    public int deleteKtonVpsIpPoolByIds(Long[] var1);
}

