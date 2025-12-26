/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.quartz.JobExecutionContext
 */
package com.kylin.kton.quartz.util;

import com.kylin.kton.quartz.domain.SysJob;
import com.kylin.kton.quartz.util.AbstractQuartzJob;
import com.kylin.kton.quartz.util.JobInvokeUtil;
import org.quartz.JobExecutionContext;

public class QuartzJobExecution
extends AbstractQuartzJob {
    @Override
    protected void doExecute(JobExecutionContext context, SysJob sysJob) throws Exception {
        JobInvokeUtil.invokeMethod(sysJob);
    }
}

