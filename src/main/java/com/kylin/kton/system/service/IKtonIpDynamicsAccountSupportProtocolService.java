/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonIpDynamicsAccountSupportProtocol;
import java.util.List;

public interface IKtonIpDynamicsAccountSupportProtocolService {
    public KtonIpDynamicsAccountSupportProtocol selectKtonIpDynamicsAccountSupportProtocolById(Long var1);

    public List<KtonIpDynamicsAccountSupportProtocol> selectKtonIpDynamicsAccountSupportProtocolList(KtonIpDynamicsAccountSupportProtocol var1);

    public int insertKtonIpDynamicsAccountSupportProtocol(KtonIpDynamicsAccountSupportProtocol var1);

    public int updateKtonIpDynamicsAccountSupportProtocol(KtonIpDynamicsAccountSupportProtocol var1);

    public int deleteKtonIpDynamicsAccountSupportProtocolByIds(Long[] var1);

    public int deleteKtonIpDynamicsAccountSupportProtocolById(Long var1);
}

