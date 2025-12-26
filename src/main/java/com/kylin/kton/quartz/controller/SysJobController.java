/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.annotation.Log
 *  com.kylin.kton.common.constant.Constants
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.core.page.TableDataInfo
 *  com.kylin.kton.common.enums.BusinessType
 *  com.kylin.kton.common.exception.job.TaskException
 *  com.kylin.kton.common.utils.StringUtils
 *  com.kylin.kton.common.utils.poi.ExcelUtil
 *  javax.servlet.http.HttpServletResponse
 *  org.quartz.SchedulerException
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.security.access.prepost.PreAuthorize
 *  org.springframework.web.bind.annotation.DeleteMapping
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.PostMapping
 *  org.springframework.web.bind.annotation.PutMapping
 *  org.springframework.web.bind.annotation.RequestBody
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.quartz.controller;

import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.constant.Constants;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.exception.job.TaskException;
import com.kylin.kton.common.utils.StringUtils;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.quartz.domain.SysJob;
import com.kylin.kton.quartz.service.ISysJobService;
import com.kylin.kton.quartz.util.CronUtils;
import com.kylin.kton.quartz.util.ScheduleUtils;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/monitor/job"})
public class SysJobController
extends BaseController {
    @Autowired
    private ISysJobService jobService;

    @PreAuthorize(value="@ss.hasPermi('monitor:job:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(SysJob sysJob) {
        this.startPage();
        List<SysJob> list = this.jobService.selectJobList(sysJob);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('monitor:job:export')")
    @Log(title="\u5b9a\u65f6\u4efb\u52a1", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, SysJob sysJob) {
        List<SysJob> list = this.jobService.selectJobList(sysJob);
        ExcelUtil util = new ExcelUtil(SysJob.class);
        util.exportExcel(response, list, "\u5b9a\u65f6\u4efb\u52a1");
    }

    @PreAuthorize(value="@ss.hasPermi('monitor:job:query')")
    @GetMapping(value={"/{jobId}"})
    public AjaxResult getInfo(@PathVariable(value="jobId") Long jobId) {
        return this.success((Object)this.jobService.selectJobById(jobId));
    }

    @PreAuthorize(value="@ss.hasPermi('monitor:job:add')")
    @Log(title="\u5b9a\u65f6\u4efb\u52a1", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysJob job) throws SchedulerException, TaskException {
        if (!CronUtils.isValid(job.getCronExpression())) {
            return this.error("\u65b0\u589e\u4efb\u52a1'" + job.getJobName() + "'\u5931\u8d25\uff0cCron\u8868\u8fbe\u5f0f\u4e0d\u6b63\u786e");
        }
        if (StringUtils.containsIgnoreCase((CharSequence)job.getInvokeTarget(), (CharSequence)"rmi:")) {
            return this.error("\u65b0\u589e\u4efb\u52a1'" + job.getJobName() + "'\u5931\u8d25\uff0c\u76ee\u6807\u5b57\u7b26\u4e32\u4e0d\u5141\u8bb8'rmi'\u8c03\u7528");
        }
        if (StringUtils.containsAnyIgnoreCase((CharSequence)job.getInvokeTarget(), (CharSequence[])new String[]{"ldap:", "ldaps:"})) {
            return this.error("\u65b0\u589e\u4efb\u52a1'" + job.getJobName() + "'\u5931\u8d25\uff0c\u76ee\u6807\u5b57\u7b26\u4e32\u4e0d\u5141\u8bb8'ldap(s)'\u8c03\u7528");
        }
        if (StringUtils.containsAnyIgnoreCase((CharSequence)job.getInvokeTarget(), (CharSequence[])new String[]{"http://", "https://"})) {
            return this.error("\u65b0\u589e\u4efb\u52a1'" + job.getJobName() + "'\u5931\u8d25\uff0c\u76ee\u6807\u5b57\u7b26\u4e32\u4e0d\u5141\u8bb8'http(s)'\u8c03\u7528");
        }
        if (StringUtils.containsAnyIgnoreCase((CharSequence)job.getInvokeTarget(), (CharSequence[])Constants.JOB_ERROR_STR)) {
            return this.error("\u65b0\u589e\u4efb\u52a1'" + job.getJobName() + "'\u5931\u8d25\uff0c\u76ee\u6807\u5b57\u7b26\u4e32\u5b58\u5728\u8fdd\u89c4");
        }
        if (!ScheduleUtils.whiteList(job.getInvokeTarget())) {
            return this.error("\u65b0\u589e\u4efb\u52a1'" + job.getJobName() + "'\u5931\u8d25\uff0c\u76ee\u6807\u5b57\u7b26\u4e32\u4e0d\u5728\u767d\u540d\u5355\u5185");
        }
        job.setCreateBy(this.getUsername());
        return this.toAjax(this.jobService.insertJob(job));
    }

    @PreAuthorize(value="@ss.hasPermi('monitor:job:edit')")
    @Log(title="\u5b9a\u65f6\u4efb\u52a1", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysJob job) throws SchedulerException, TaskException {
        if (!CronUtils.isValid(job.getCronExpression())) {
            return this.error("\u4fee\u6539\u4efb\u52a1'" + job.getJobName() + "'\u5931\u8d25\uff0cCron\u8868\u8fbe\u5f0f\u4e0d\u6b63\u786e");
        }
        if (StringUtils.containsIgnoreCase((CharSequence)job.getInvokeTarget(), (CharSequence)"rmi:")) {
            return this.error("\u4fee\u6539\u4efb\u52a1'" + job.getJobName() + "'\u5931\u8d25\uff0c\u76ee\u6807\u5b57\u7b26\u4e32\u4e0d\u5141\u8bb8'rmi'\u8c03\u7528");
        }
        if (StringUtils.containsAnyIgnoreCase((CharSequence)job.getInvokeTarget(), (CharSequence[])new String[]{"ldap:", "ldaps:"})) {
            return this.error("\u4fee\u6539\u4efb\u52a1'" + job.getJobName() + "'\u5931\u8d25\uff0c\u76ee\u6807\u5b57\u7b26\u4e32\u4e0d\u5141\u8bb8'ldap(s)'\u8c03\u7528");
        }
        if (StringUtils.containsAnyIgnoreCase((CharSequence)job.getInvokeTarget(), (CharSequence[])new String[]{"http://", "https://"})) {
            return this.error("\u4fee\u6539\u4efb\u52a1'" + job.getJobName() + "'\u5931\u8d25\uff0c\u76ee\u6807\u5b57\u7b26\u4e32\u4e0d\u5141\u8bb8'http(s)'\u8c03\u7528");
        }
        if (StringUtils.containsAnyIgnoreCase((CharSequence)job.getInvokeTarget(), (CharSequence[])Constants.JOB_ERROR_STR)) {
            return this.error("\u4fee\u6539\u4efb\u52a1'" + job.getJobName() + "'\u5931\u8d25\uff0c\u76ee\u6807\u5b57\u7b26\u4e32\u5b58\u5728\u8fdd\u89c4");
        }
        if (!ScheduleUtils.whiteList(job.getInvokeTarget())) {
            return this.error("\u4fee\u6539\u4efb\u52a1'" + job.getJobName() + "'\u5931\u8d25\uff0c\u76ee\u6807\u5b57\u7b26\u4e32\u4e0d\u5728\u767d\u540d\u5355\u5185");
        }
        job.setUpdateBy(this.getUsername());
        return this.toAjax(this.jobService.updateJob(job));
    }

    @PreAuthorize(value="@ss.hasPermi('monitor:job:changeStatus')")
    @Log(title="\u5b9a\u65f6\u4efb\u52a1", businessType=BusinessType.UPDATE)
    @PutMapping(value={"/changeStatus"})
    public AjaxResult changeStatus(@RequestBody SysJob job) throws SchedulerException {
        SysJob newJob = this.jobService.selectJobById(job.getJobId());
        newJob.setStatus(job.getStatus());
        return this.toAjax(this.jobService.changeStatus(newJob));
    }

    @PreAuthorize(value="@ss.hasPermi('monitor:job:changeStatus')")
    @Log(title="\u5b9a\u65f6\u4efb\u52a1", businessType=BusinessType.UPDATE)
    @PutMapping(value={"/run"})
    public AjaxResult run(@RequestBody SysJob job) throws SchedulerException {
        boolean result = this.jobService.run(job);
        return result ? this.success() : this.error("\u4efb\u52a1\u4e0d\u5b58\u5728\u6216\u5df2\u8fc7\u671f\uff01");
    }

    @PreAuthorize(value="@ss.hasPermi('monitor:job:remove')")
    @Log(title="\u5b9a\u65f6\u4efb\u52a1", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{jobIds}"})
    public AjaxResult remove(@PathVariable Long[] jobIds) throws SchedulerException, TaskException {
        this.jobService.deleteJobByIds(jobIds);
        return this.success();
    }
}

