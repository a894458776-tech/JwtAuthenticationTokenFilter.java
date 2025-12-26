/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.ibatis.annotations.Mapper
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 */
package com.kylin.kton.admin.tasks.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ClusterStatisMapper {
    @Select(value={"<script>select count(*) from kton_vps_host where cluster_id = #{clusterId} </script>"})
    public Integer countHost(@Param(value="clusterId") Long var1);

    @Select(value={"<script>select count(*) from kton_vps_ip_pool where cluster_id = #{clusterId} </script>"})
    public Integer countIp(@Param(value="clusterId") Long var1);

    @Select(value={"<script>select count(*) from kton_vps_host_container where cluster_id = #{clusterId} </script>"})
    public Integer countContainer(@Param(value="clusterId") Long var1);

    @Select(value={"<script>select count(*) from kton_vps_ip_pool where status = 1 and  cluster_id = #{clusterId} </script>"})
    public Integer countUserIp(@Param(value="clusterId") Long var1);
}

