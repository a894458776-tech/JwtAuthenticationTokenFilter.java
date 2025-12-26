/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticSource
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.apache.ibatis.annotations.Update
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.tasks.mapper;

import com.kylin.kton.system.domain.KtonIpStaticSource;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskIpStaticSourceMapper {
    @Update(value={"<script> UPDATE kton_ip_static_pool_item  SET status = #{status},     update_time = NOW() WHERE ip = #{ip} </script>"})
    public void updateByIp(@Param(value="ip") String var1, Integer var2);

    @Select(value={"<script>", " SELECT * FROM kton_ip_static_source", " WHERE expire_datetime &lt; NOW() AND expire_datetime!='9999-12-31 00:00:00' ", " AND status != 2", "</script>"})
    public List<KtonIpStaticSource> selectExpiredIps();

    @Update(value={"<script>", " UPDATE kton_ip_static_source", " SET status = 2, ", "     assign_times = 0", " WHERE ip IN", " <foreach collection='ipList' item='item' open='(' separator=',' close=')'>", "   #{item.ip}", " </foreach>", "</script>"})
    public void updateExpiredStatus(@Param(value="ipList") List<KtonIpStaticSource> var1);
}

