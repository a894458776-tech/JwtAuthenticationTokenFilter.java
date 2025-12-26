/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.service;

import com.kylin.kton.system.domain.KtonIpDynamicsAccountBalance;
import java.util.List;

public interface IKtonIpDynamicsAccountBalanceService {
    public KtonIpDynamicsAccountBalance selectKtonIpDynamicsAccountBalanceById(Long var1);

    public List<KtonIpDynamicsAccountBalance> selectKtonIpDynamicsAccountBalanceList(KtonIpDynamicsAccountBalance var1);

    public int insertKtonIpDynamicsAccountBalance(KtonIpDynamicsAccountBalance var1);

    public int updateKtonIpDynamicsAccountBalance(KtonIpDynamicsAccountBalance var1);

    public int deleteKtonIpDynamicsAccountBalanceByIds(Long[] var1);

    public int deleteKtonIpDynamicsAccountBalanceById(Long var1);
}

