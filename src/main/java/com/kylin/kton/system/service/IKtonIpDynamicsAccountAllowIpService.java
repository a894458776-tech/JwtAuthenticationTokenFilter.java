/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonIpDynamicsAccountAllowIp;
import java.util.List;

public interface IKtonIpDynamicsAccountAllowIpService {
    public KtonIpDynamicsAccountAllowIp selectKtonIpDynamicsAccountAllowIpById(Long var1);

    public List<KtonIpDynamicsAccountAllowIp> selectKtonIpDynamicsAccountAllowIpList(KtonIpDynamicsAccountAllowIp var1);

    public int insertKtonIpDynamicsAccountAllowIp(KtonIpDynamicsAccountAllowIp var1);

    public int updateKtonIpDynamicsAccountAllowIp(KtonIpDynamicsAccountAllowIp var1);

    public int deleteKtonIpDynamicsAccountAllowIpByIds(Long[] var1);

    public int deleteKtonIpDynamicsAccountAllowIpById(Long var1);
}

