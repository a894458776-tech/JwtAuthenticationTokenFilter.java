/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.generator.mapper;

import com.kylin.kton.generator.domain.GenTableColumn;
import java.util.List;

public interface GenTableColumnMapper {
    public List<GenTableColumn> selectDbTableColumnsByName(String var1);

    public List<GenTableColumn> selectGenTableColumnListByTableId(Long var1);

    public int insertGenTableColumn(GenTableColumn var1);

    public int updateGenTableColumn(GenTableColumn var1);

    public int deleteGenTableColumns(List<GenTableColumn> var1);

    public int deleteGenTableColumnByIds(Long[] var1);
}

