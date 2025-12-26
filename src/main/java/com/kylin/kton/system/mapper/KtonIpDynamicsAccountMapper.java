/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonIpDynamicsAccount;
import java.util.List;

public interface KtonIpDynamicsAccountMapper {
    public KtonIpDynamicsAccount selectKtonIpDynamicsAccountById(Long var1);

    public List<KtonIpDynamicsAccount> selectKtonIpDynamicsAccountList(KtonIpDynamicsAccount var1);

    public int insertKtonIpDynamicsAccount(KtonIpDynamicsAccount var1);

    public int updateKtonIpDynamicsAccount(KtonIpDynamicsAccount var1);

    public int deleteKtonIpDynamicsAccountById(Long var1);

    public int deleteKtonIpDynamicsAccountByIds(Long[] var1);
}

