/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonIpDynamicsAccountSupportProtocol;
import java.util.List;

public interface KtonIpDynamicsAccountSupportProtocolMapper {
    public KtonIpDynamicsAccountSupportProtocol selectKtonIpDynamicsAccountSupportProtocolById(Long var1);

    public List<KtonIpDynamicsAccountSupportProtocol> selectKtonIpDynamicsAccountSupportProtocolList(KtonIpDynamicsAccountSupportProtocol var1);

    public int insertKtonIpDynamicsAccountSupportProtocol(KtonIpDynamicsAccountSupportProtocol var1);

    public int updateKtonIpDynamicsAccountSupportProtocol(KtonIpDynamicsAccountSupportProtocol var1);

    public int deleteKtonIpDynamicsAccountSupportProtocolById(Long var1);

    public int deleteKtonIpDynamicsAccountSupportProtocolByIds(Long[] var1);
}

