/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.exception.job.TaskException
 *  org.quartz.SchedulerException
 */
package com.kylin.kton.quartz.service;

import com.kylin.kton.common.exception.job.TaskException;
import com.kylin.kton.quartz.domain.SysJob;
import java.util.List;
import org.quartz.SchedulerException;

public interface ISysJobService {
    public List<SysJob> selectJobList(SysJob var1);

    public SysJob selectJobById(Long var1);

    public int pauseJob(SysJob var1) throws SchedulerException;

    public int resumeJob(SysJob var1) throws SchedulerException;

    public int deleteJob(SysJob var1) throws SchedulerException;

    public void deleteJobByIds(Long[] var1) throws SchedulerException;

    public int changeStatus(SysJob var1) throws SchedulerException;

    public boolean run(SysJob var1) throws SchedulerException;

    public int insertJob(SysJob var1) throws SchedulerException, TaskException;

    public int updateJob(SysJob var1) throws SchedulerException, TaskException;

    public boolean checkCronExpressionIsValid(String var1);
}

