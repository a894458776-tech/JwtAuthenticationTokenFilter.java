/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.api.dataimpulse.entity.subuser.QuerySubUserUsageStatResponse$Usage
 *  com.kylin.kton.api.netnut.entity.subuser.TrafficUsageData
 *  com.kylin.kton.api.oxylabs.entity.subuser.DateResItem
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccount
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageStat
 *  org.apache.ibatis.annotations.Insert
 *  org.apache.ibatis.annotations.Mapper
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 */
package com.kylin.kton.admin.tasks.mapper;

import com.kylin.kton.api.dataimpulse.entity.subuser.QuerySubUserUsageStatResponse;
import com.kylin.kton.api.netnut.entity.subuser.TrafficUsageData;
import com.kylin.kton.api.oxylabs.entity.subuser.DateResItem;
import com.kylin.kton.system.domain.KtonIpDynamicsAccount;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageStat;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DynamicsAccountUsageStatTaskMapper {
    @Select(value={"<script>select * from kton_ip_dynamics_account_usage_stat where merchant_id = #{merchantId} and account_id = #{accountId} order by id desc limit 1</script>"})
    public KtonIpDynamicsAccountUsageStat getLatestUsageStat(@Param(value="merchantId") Long var1, @Param(value="accountId") Long var2);

    @Select(value={"<script>select * from kton_ip_dynamics_account_usage_stat where merchant_id = #{merchantId} and account_id = #{accountId} order by id desc limit 1</script>"})
    public KtonIpDynamicsAccountUsageStat getLatestUsageStatToday(@Param(value="merchantId") Long var1, @Param(value="accountId") Long var2, String var3);

    @Insert(value={"<script>insert into kton_ip_dynamics_account_usage_stat(merchant_id,account_id,d_usage,requests,traffic,extra_traffic) values <foreach collection='list' item='p' separator=','>(#{acc.merchantId}, #{acc.accountId}, #{p.usageD}, #{p.request}, #{p.traffic}, #{p.extraTraffic})</foreach></script>"})
    public Integer batchInsertUsage(@Param(value="list") List<QuerySubUserUsageStatResponse.Usage> var1, @Param(value="acc") KtonIpDynamicsAccount var2);

    @Insert(value={"<script>insert into kton_ip_dynamics_account_usage_stat(merchant_id,account_id,d_usage,requests,traffic,extra_traffic) values <foreach collection='list' item='p' separator=','>(#{acc.merchantId}, #{acc.accountId}, #{p.usageD}, #{p.request}, #{p.traffic}, #{p.extraTraffic})</foreach></script>"})
    public Integer batchInsertNetnutUsage(@Param(value="list") List<TrafficUsageData> var1, @Param(value="acc") KtonIpDynamicsAccount var2);

    @Insert(value={"<script>insert into kton_ip_dynamics_account_usage_stat(merchant_id,account_id,traffic,d_usage) values <foreach collection='list' item='p' separator=','>(#{acc.merchantId}, #{acc.accountId}, #{p.usageD}, #{p.value}, #{p.date})</foreach></script>"})
    public Integer batchInsertOxylabsUsage(List<DateResItem> var1, @Param(value="acc") KtonIpDynamicsAccount var2);
}

