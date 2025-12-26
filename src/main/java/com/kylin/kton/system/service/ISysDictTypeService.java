/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.domain.entity.SysDictData
 *  com.kylin.kton.common.core.domain.entity.SysDictType
 */
package com.kylin.kton.system.service;

import com.kylin.kton.common.core.domain.entity.SysDictData;
import com.kylin.kton.common.core.domain.entity.SysDictType;
import java.util.List;

public interface ISysDictTypeService {
    public List<SysDictType> selectDictTypeList(SysDictType var1);

    public List<SysDictType> selectDictTypeAll();

    public List<SysDictData> selectDictDataByType(String var1);

    public SysDictType selectDictTypeById(Long var1);

    public SysDictType selectDictTypeByType(String var1);

    public void deleteDictTypeByIds(Long[] var1);

    public void loadingDictCache();

    public void clearDictCache();

    public void resetDictCache();

    public int insertDictType(SysDictType var1);

    public int updateDictType(SysDictType var1);

    public boolean checkDictTypeUnique(SysDictType var1);
}

