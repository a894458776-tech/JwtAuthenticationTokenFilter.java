/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountAllowIp
 *  com.kylin.kton.system.service.IKtonIpDynamicsAccountAllowIpService
 */
package com.kylin.kton.admin.account.service;

import com.kylin.kton.system.domain.KtonIpDynamicsAccountAllowIp;
import com.kylin.kton.system.service.IKtonIpDynamicsAccountAllowIpService;

public interface IpDynamicsAccountAllowIpService
extends IKtonIpDynamicsAccountAllowIpService {
    public int add(KtonIpDynamicsAccountAllowIp var1);

    public int del(Long var1);
}

