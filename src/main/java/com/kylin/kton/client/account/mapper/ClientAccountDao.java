/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccount
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.client.account.mapper;

import com.kylin.kton.system.domain.KtonIpDynamicsAccount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientAccountDao {
    @Select(value={"<script> SELECT * FROM kton_ip_dynamics_account WHERE merchant_id = #{merchantId} AND account_id = #{accountId} </script>"})
    public KtonIpDynamicsAccount detail(@Param(value="merchantId") Long var1, @Param(value="accountId") Long var2);
}

