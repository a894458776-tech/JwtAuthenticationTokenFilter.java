/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonIpStaticAuthorization;
import java.util.List;

public interface KtonIpStaticAuthorizationMapper {
    public KtonIpStaticAuthorization selectKtonIpStaticAuthorizationById(Long var1);

    public List<KtonIpStaticAuthorization> selectKtonIpStaticAuthorizationList(KtonIpStaticAuthorization var1);

    public int insertKtonIpStaticAuthorization(KtonIpStaticAuthorization var1);

    public int updateKtonIpStaticAuthorization(KtonIpStaticAuthorization var1);

    public int deleteKtonIpStaticAuthorizationById(Long var1);

    public int deleteKtonIpStaticAuthorizationByIds(Long[] var1);
}

