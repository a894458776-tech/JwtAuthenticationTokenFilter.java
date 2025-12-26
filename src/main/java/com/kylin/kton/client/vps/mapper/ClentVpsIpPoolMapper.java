/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonVpsIpPool
 *  com.kylin.kton.system.mapper.KtonVpsIpPoolMapper
 *  org.apache.ibatis.annotations.Mapper
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.apache.ibatis.annotations.Update
 */
package com.kylin.kton.client.vps.mapper;

import com.kylin.kton.client.vps.entity.dto.ClientIpPreFixCountDTO;
import com.kylin.kton.system.domain.KtonVpsIpPool;
import com.kylin.kton.system.mapper.KtonVpsIpPoolMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ClentVpsIpPoolMapper
extends KtonVpsIpPoolMapper {
    @Select(value={"<script>", "SELECT * ", "FROM kton_vps_ip_pool ", "WHERE ip = #{ip} and container_ip = #{containerIp} ", "LIMIT 1 ", "</script>"})
    public KtonVpsIpPool getByIp(@Param(value="ip") String var1, @Param(value="containerIp") String var2);

    @Update(value={"<script> UPDATE kton_vps_ip_pool SET status = #{dto.status},     merchant_id = #{dto.merchantId},     update_time = NOW()  WHERE id = #{dto.id} </script>"})
    public void updateById(@Param(value="dto") KtonVpsIpPool var1);

    @Select(value={"<script>", "SELECT     SUBSTRING_INDEX(ip, '.', 3) AS ip_prefix,     COUNT(*) AS count_ip FROM kton_vps_ip_pool GROUP BY SUBSTRING_INDEX(ip, '.', 3) ORDER BY ip_prefix; ", "</script>"})
    public ClientIpPreFixCountDTO ipPreFixCount(@Param(value="ip") String var1, @Param(value="containerIp") String var2);
}

