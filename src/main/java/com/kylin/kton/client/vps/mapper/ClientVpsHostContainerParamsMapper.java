/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonVpsHostContainerParam
 *  org.apache.ibatis.annotations.Mapper
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 */
package com.kylin.kton.client.vps.mapper;

import com.kylin.kton.system.domain.KtonVpsHostContainerParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ClientVpsHostContainerParamsMapper {
    @Select(value={"<script>", "SELECT * ", "FROM kton_vps_host_container_param ", "WHERE  container_id = #{containerId} ", "LIMIT 1 ", "</script>"})
    public KtonVpsHostContainerParam getByContainerId(@Param(value="containerId") String var1);
}

