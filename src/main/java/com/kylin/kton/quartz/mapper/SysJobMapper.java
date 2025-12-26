/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.quartz.mapper;

import com.kylin.kton.quartz.domain.SysJob;
import java.util.List;

public interface SysJobMapper {
    public List<SysJob> selectJobList(SysJob var1);

    public List<SysJob> selectJobAll();

    public SysJob selectJobById(Long var1);

    public int deleteJobById(Long var1);

    public int deleteJobByIds(Long[] var1);

    public int updateJob(SysJob var1);

    public int insertJob(SysJob var1);
}

