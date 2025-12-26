/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonIpDynamicsAccountEndpoint;
import java.util.List;

public interface IKtonIpDynamicsAccountEndpointService {
    public KtonIpDynamicsAccountEndpoint selectKtonIpDynamicsAccountEndpointById(Long var1);

    public List<KtonIpDynamicsAccountEndpoint> selectKtonIpDynamicsAccountEndpointList(KtonIpDynamicsAccountEndpoint var1);

    public int insertKtonIpDynamicsAccountEndpoint(KtonIpDynamicsAccountEndpoint var1);

    public int updateKtonIpDynamicsAccountEndpoint(KtonIpDynamicsAccountEndpoint var1);

    public int deleteKtonIpDynamicsAccountEndpointByIds(Long[] var1);

    public int deleteKtonIpDynamicsAccountEndpointById(Long var1);
}

