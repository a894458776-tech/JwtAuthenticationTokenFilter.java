/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonIpDynamicsAccountEndpoint;
import java.util.List;

public interface KtonIpDynamicsAccountEndpointMapper {
    public KtonIpDynamicsAccountEndpoint selectKtonIpDynamicsAccountEndpointById(Long var1);

    public List<KtonIpDynamicsAccountEndpoint> selectKtonIpDynamicsAccountEndpointList(KtonIpDynamicsAccountEndpoint var1);

    public int insertKtonIpDynamicsAccountEndpoint(KtonIpDynamicsAccountEndpoint var1);

    public int updateKtonIpDynamicsAccountEndpoint(KtonIpDynamicsAccountEndpoint var1);

    public int deleteKtonIpDynamicsAccountEndpointById(Long var1);

    public int deleteKtonIpDynamicsAccountEndpointByIds(Long[] var1);
}

