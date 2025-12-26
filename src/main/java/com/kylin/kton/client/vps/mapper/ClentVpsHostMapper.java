/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonVpsHost
 *  com.kylin.kton.system.mapper.KtonVpsHostMapper
 *  org.apache.ibatis.annotations.Mapper
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 */
package com.kylin.kton.client.vps.mapper;

import com.kylin.kton.system.domain.KtonVpsHost;
import com.kylin.kton.system.mapper.KtonVpsHostMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ClentVpsHostMapper
extends KtonVpsHostMapper {
    @Select(value={"<script>", "SELECT * ", "FROM kton_vps_host ", "WHERE id = #{hostId}  ", "LIMIT 1 ", "</script>"})
    public KtonVpsHost getById(@Param(value="hostId") Long var1);
}

