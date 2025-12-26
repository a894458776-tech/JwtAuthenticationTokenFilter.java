/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonVpsHostContainer
 *  com.kylin.kton.system.mapper.KtonVpsHostContainerMapper
 *  org.apache.ibatis.annotations.Mapper
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 */
package com.kylin.kton.client.vps.mapper;

import com.kylin.kton.system.domain.KtonVpsHostContainer;
import com.kylin.kton.system.mapper.KtonVpsHostContainerMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ClientVpsHostContainerMapper
extends KtonVpsHostContainerMapper {
    @Select(value={"<script>", "SELECT * ", "FROM kton_vps_host_container ", "WHERE  container_id = #{containerId} ", "LIMIT 1 ", "</script>"})
    public KtonVpsHostContainer getByContainerId(@Param(value="containerId") String var1);
}

