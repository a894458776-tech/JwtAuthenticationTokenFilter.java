/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountSupportProtocol
 *  com.kylin.kton.system.service.IKtonIpDynamicsAccountSupportProtocolService
 */
package com.kylin.kton.client.account.service;

import com.kylin.kton.system.domain.KtonIpDynamicsAccountSupportProtocol;
import com.kylin.kton.system.service.IKtonIpDynamicsAccountSupportProtocolService;
import java.util.List;

public interface ClientIpDynamicsAccountSupportProtocolService
extends IKtonIpDynamicsAccountSupportProtocolService {
    public int add(Long var1, KtonIpDynamicsAccountSupportProtocol var2);

    public int edit(List<String> var1, Long var2, Long var3);

    public int remove(Long[] var1);
}

