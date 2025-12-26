/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonSource
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.tasks.mapper;

import com.kylin.kton.system.domain.KtonSource;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksSourceDao {
    @Select(value={"<script> SELECT * FROM kton_source WHERE source_code = #{sourceCode}  </script>"})
    public KtonSource detailBySourceCode(@Param(value="sourceCode") String var1);
}

