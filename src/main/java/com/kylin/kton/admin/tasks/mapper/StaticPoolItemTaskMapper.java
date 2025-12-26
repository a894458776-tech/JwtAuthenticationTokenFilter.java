/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Update
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.tasks.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface StaticPoolItemTaskMapper {
    @Update(value={"<script> UPDATE kton_ip_static_pool_item  SET status = 0,     update_time = NOW() WHERE id = #{id} </script>"})
    public void updateById(@Param(value="id") Long var1);
}

