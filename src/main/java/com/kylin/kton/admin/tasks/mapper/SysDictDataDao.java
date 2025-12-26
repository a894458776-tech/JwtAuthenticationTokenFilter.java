/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.domain.entity.SysDictData
 *  com.kylin.kton.system.mapper.KtonIpDetectMapper
 *  org.apache.ibatis.annotations.Mapper
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 */
package com.kylin.kton.admin.tasks.mapper;

import com.kylin.kton.common.core.domain.entity.SysDictData;
import com.kylin.kton.system.mapper.KtonIpDetectMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysDictDataDao
extends KtonIpDetectMapper {
    @Select(value={"SELECT * FROM sys_dict_data WHERE dict_type = 'location_dict' "})
    public List<SysDictData> selectLocationDict();

    @Select(value={"SELECT * FROM sys_dict_data  WHERE dict_type = #{dictType} "})
    public List<SysDictData> selectListByType(@Param(value="dictType") String var1);
}

