/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonVpsIpPool
 *  org.apache.ibatis.annotations.Insert
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.apache.ibatis.annotations.Update
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.user.mapper;

import com.kylin.kton.system.domain.KtonVpsIpPool;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface VpsIpPoolDao {
    @Insert(value={"<script>", "INSERT INTO kton_vps_ip_pool (cluster_id, host_id, ip, container_ip,status, create_time, update_time) ", "VALUES ", "<foreach collection='ipPoolList' item='item' separator=','>", "(#{item.clusterId}, #{item.hostId}, #{item.ip}, #{item.containerIp}, #{item.status}, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)", "</foreach>", "</script>"})
    public int batchInsertKtonVpsIpPool(@Param(value="ipPoolList") List<KtonVpsIpPool> var1);

    @Select(value={"<script>", "SELECT * ", "FROM kton_vps_ip_pool ", "WHERE cluster_id = #{clusterId} and (merchant_id = #{merchantId} or merchant_id = 0 ) ", "AND status = 0 and id &gt; #{latestIpId} ORDER BY id asc LIMIT 1 ", "</script>"})
    public KtonVpsIpPool getIp(@Param(value="clusterId") Long var1, @Param(value="latestIpId") Long var2, @Param(value="merchantId") Long var3);

    @Update(value={"<script>", "UPDATE kton_vps_ip_pool ", "SET status = #{status}, ", "count_assign = count_assign + 1 ", "WHERE id = #{id}", "</script>"})
    public int updateStatus(@Param(value="id") Long var1, @Param(value="status") int var2);
}

