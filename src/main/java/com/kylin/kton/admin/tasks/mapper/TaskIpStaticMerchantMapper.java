/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticMerchant
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.apache.ibatis.annotations.Update
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.tasks.mapper;

import com.kylin.kton.system.domain.KtonIpStaticMerchant;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskIpStaticMerchantMapper {
    @Select(value={"<script>select * from kton_ip_static_merchant where orderId = #{orderId} </script>"})
    public List<KtonIpStaticMerchant> getByOrderId(@Param(value="orderId") Long var1);

    @Select(value={"<script>", " SELECT * FROM kton_ip_static_merchant", " WHERE expire_datetime &lt; NOW() AND expire_datetime !='9999-12-31 00:00:00' ", " AND status != 2", " AND status != 3", "</script>"})
    public List<KtonIpStaticMerchant> selectExpiredIps();

    @Update(value={"<script>", " UPDATE kton_ip_static_merchant", " SET status = 2", " WHERE id IN", " <foreach collection='ipList' item='item' open='(' separator=',' close=')'>", "   #{item.id}", " </foreach>", "</script>"})
    public void updateExpiredStatus(@Param(value="ipList") List<KtonIpStaticMerchant> var1);

    @Select(value={"<script>", "SELECT DISTINCT merchant_id", "FROM kton_ip_static_merchant", "WHERE expire_datetime &lt;= #{cutoffDate}", "</script>"})
    public List<Long> findMerchantIdsWithExpiringIps(@Param(value="cutoffDate") LocalDateTime var1);

    @Select(value={"<script>", "SELECT *", "FROM kton_ip_static_merchant", "WHERE merchant_id IN", "<foreach collection='merchantIds' item='id' open='(' separator=',' close=')'>#{id}</foreach>", "AND expire_datetime &lt;= #{cutoffDate}", "</script>"})
    public List<KtonIpStaticMerchant> findExpiringIpsByMerchantIds(@Param(value="merchantIds") List<Long> var1, @Param(value="cutoffDate") LocalDateTime var2);
}

