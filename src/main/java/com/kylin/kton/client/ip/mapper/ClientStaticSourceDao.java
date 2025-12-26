/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticSource
 *  com.kylin.kton.system.mapper.KtonIpStaticSourceMapper
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.apache.ibatis.annotations.Update
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.client.ip.mapper;

import com.kylin.kton.system.domain.KtonIpStaticSource;
import com.kylin.kton.system.mapper.KtonIpStaticSourceMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientStaticSourceDao
extends KtonIpStaticSourceMapper {
    @Select(value={"<script> SELECT *  FROM kton_ip_static_source   WHERE ip = #{ip}    LIMIT 1  </script>"})
    public KtonIpStaticSource selectByIp(@Param(value="ip") String var1);

    @Update(value={"<script> UPDATE kton_ip_static_pool_item  SET status = #{status},     update_time = NOW() WHERE ip = #{ip} </script>"})
    public void updateStatus(@Param(value="ip") String var1, @Param(value="status") Integer var2);

    @Update(value={"UPDATE kton_ip_static_source ", "SET assign_times = assign_times + 1 ", "WHERE ip = #{ip} "})
    public int incrementAssignTimes(String var1);

    @Update(value={"UPDATE kton_ip_static_source ", "SET assign_times = GREATEST(0, assign_times - 1) ", "WHERE ip = #{ip} AND assign_times > 0"})
    public int subtAssignTimes(String var1);
}

