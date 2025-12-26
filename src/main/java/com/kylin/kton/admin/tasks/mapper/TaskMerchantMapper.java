/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.ibatis.annotations.Mapper
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 */
package com.kylin.kton.admin.tasks.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TaskMerchantMapper {
    @Select(value={"<script>", "SELECT id, email", "FROM kton_merchant", "WHERE id IN", "<foreach collection='merchantIds' item='id' open='(' separator=',' close=')'>#{id}</foreach>", "</script>"})
    public List<Map<String, Object>> findEmailsByIds(@Param(value="merchantIds") List<Long> var1);
}

