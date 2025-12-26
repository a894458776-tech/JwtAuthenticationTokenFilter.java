/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.annotation.Excel
 *  com.kylin.kton.common.core.domain.BaseEntity
 *  org.apache.commons.lang3.builder.ToStringBuilder
 *  org.apache.commons.lang3.builder.ToStringStyle
 */
package com.kylin.kton.system.domain;

import com.kylin.kton.common.annotation.Excel;
import com.kylin.kton.common.core.domain.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class KtonMonitorHostDetails
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private String hostIp;
    private Date dateTime;
    @Excel(name="cpu\u4f7f\u7528\u7387")
    private BigDecimal cpuUsage;
    @Excel(name="\u78c1\u76d8\u4f7f\u7528\u7387")
    private BigDecimal diskUsage;
    @Excel(name="\u5185\u5b58\u4f7f\u7528\u7387")
    private BigDecimal memoryUsage;
    @Excel(name="\u8fdb\u7a0b\u6570")
    private Long countProcess;
    @Excel(name="\u5bb9\u5668\u6570\u91cf")
    private Long countContainer;

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public String getHostIp() {
        return this.hostIp;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Date getDateTime() {
        return this.dateTime;
    }

    public void setCpuUsage(BigDecimal cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public BigDecimal getCpuUsage() {
        return this.cpuUsage;
    }

    public void setDiskUsage(BigDecimal diskUsage) {
        this.diskUsage = diskUsage;
    }

    public BigDecimal getDiskUsage() {
        return this.diskUsage;
    }

    public void setMemoryUsage(BigDecimal memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public BigDecimal getMemoryUsage() {
        return this.memoryUsage;
    }

    public void setCountProcess(Long countProcess) {
        this.countProcess = countProcess;
    }

    public Long getCountProcess() {
        return this.countProcess;
    }

    public void setCountContainer(Long countContainer) {
        this.countContainer = countContainer;
    }

    public Long getCountContainer() {
        return this.countContainer;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("hostIp", (Object)this.getHostIp()).append("dateTime", (Object)this.getDateTime()).append("cpuUsage", (Object)this.getCpuUsage()).append("diskUsage", (Object)this.getDiskUsage()).append("memoryUsage", (Object)this.getMemoryUsage()).append("countProcess", (Object)this.getCountProcess()).append("countContainer", (Object)this.getCountContainer()).append("createTime", (Object)this.getCreateTime()).toString();
    }
}

