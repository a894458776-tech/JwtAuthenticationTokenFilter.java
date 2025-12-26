/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonClusterHostTemplate
 *  org.apache.ibatis.annotations.Mapper
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 */
package com.kylin.kton.admin.cluster.mapper;

import com.kylin.kton.system.domain.KtonClusterHostTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminClusterMapper {
    @Select(value={"<script>select cpt.* from kton_cluster_host_template cpt where 1 = 1 and  cpt.price_monthly  &gt; 0  <if test='templateId != null'> and cpt.ref_id = #{templateId}</if> LIMIT 1 ", "</script>"})
    public KtonClusterHostTemplate getByRefId(@Param(value="templateId") String var1);
}

