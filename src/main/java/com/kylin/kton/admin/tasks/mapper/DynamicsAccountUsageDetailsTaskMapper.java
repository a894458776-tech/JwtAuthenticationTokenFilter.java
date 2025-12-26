/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.api.dataimpulse.entity.subuser.QuerySubUserUsageStatDetailsResponse$Usage
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccount
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageDetails
 *  org.apache.ibatis.annotations.Insert
 *  org.apache.ibatis.annotations.Mapper
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 */
package com.kylin.kton.admin.tasks.mapper;

import com.kylin.kton.api.dataimpulse.entity.subuser.QuerySubUserUsageStatDetailsResponse;
import com.kylin.kton.system.domain.KtonIpDynamicsAccount;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageDetails;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DynamicsAccountUsageDetailsTaskMapper {
    @Select(value={"<script>select * from kton_ip_dynamics_account_usage_details where merchant_id = #{merchantId} and account_id = #{accountId} order by data_datetime desc limit 1</script>"})
    public KtonIpDynamicsAccountUsageDetails getLatestUsageDetails(@Param(value="merchantId") Long var1, @Param(value="accountId") Long var2);

    @Insert(value={"<script>insert into kton_ip_dynamics_account_usage_details(merchant_id,account_id,data_datetime, host,requests,traffic,extra_traffic,status,message) values <foreach collection='list' item='p' separator=','>(#{acc.merchantId}, #{acc.accountId}, #{p.datetime}, #{p.host}, #{p.requests}, #{p.traffic}, #{p.extraTraffic}, #{p.status}, #{p.message})</foreach></script>"})
    public Integer batchInsertUsageDetails(@Param(value="list") List<QuerySubUserUsageStatDetailsResponse.Usage> var1, @Param(value="acc") KtonIpDynamicsAccount var2);
}

