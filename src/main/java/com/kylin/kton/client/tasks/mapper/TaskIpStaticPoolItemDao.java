/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Update
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.client.tasks.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskIpStaticPoolItemDao {
    @Update(value={"<script> UPDATE kton_ip_static_pool_item SET status=#{status}, update_time=NOW() WHERE ip IN  <foreach collection='ips' item='ip' index='index' open='(' close=')' separator=','>  #{ip} </foreach> AND status =1 </script> "})
    public void batchEdit(@Param(value="status") Integer var1, @Param(value="ips") List<String> var2);
}

