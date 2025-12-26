/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountBalance
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.account.mapper;

import com.kylin.kton.system.domain.KtonIpDynamicsAccountBalance;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminAccountBalanceDao {
    @Select(value={"<script>", "SELECT * FROM kton_ip_dynamics_account_balance", "WHERE update_time &lt;= DATE_SUB(NOW(), INTERVAL #{minute} MINUTE)", "</script>"})
    public List<KtonIpDynamicsAccountBalance> pendingList(@Param(value="minute") Integer var1);
}

