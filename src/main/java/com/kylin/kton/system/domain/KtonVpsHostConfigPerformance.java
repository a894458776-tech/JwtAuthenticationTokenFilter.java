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
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class KtonVpsHostConfigPerformance
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="")
    private Long hostId;
    @Excel(name="\u578b\u53f7")
    private String model;
    @Excel(name="cpu\u6838\u5fc3\u6570")
    private Long cpuCores;
    @Excel(name="cpu\u578b\u53f7")
    private String cpuModel;
    @Excel(name="\u5185\u5b58")
    private Long memory;
    @Excel(name="\u786c\u76d8\u5bb9\u91cf")
    private Long diskCapacity;
    @Excel(name="\u786c\u76d8\u578b\u53f7")
    private String diskModel;
    @Excel(name="io\u8bfb")
    private Long ioWrite;
    @Excel(name="io\u5199")
    private Long ioRead;
    @Excel(name="\u5e26\u5bbd")
    private Long bandwidth;
    @Excel(name="\u6d41\u91cf")
    private Long internetTraffic;
    @Excel(name="ipv4")
    private String ipV4;
    @Excel(name="ipv6", readConverterExp="Y=-\u652f\u6301\uff0cN-\u4e0d\u652f\u6301")
    private String ipV6;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public Long getHostId() {
        return this.hostId;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    public void setCpuCores(Long cpuCores) {
        this.cpuCores = cpuCores;
    }

    public Long getCpuCores() {
        return this.cpuCores;
    }

    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }

    public String getCpuModel() {
        return this.cpuModel;
    }

    public void setMemory(Long memory) {
        this.memory = memory;
    }

    public Long getMemory() {
        return this.memory;
    }

    public void setDiskCapacity(Long diskCapacity) {
        this.diskCapacity = diskCapacity;
    }

    public Long getDiskCapacity() {
        return this.diskCapacity;
    }

    public void setDiskModel(String diskModel) {
        this.diskModel = diskModel;
    }

    public String getDiskModel() {
        return this.diskModel;
    }

    public void setIoWrite(Long ioWrite) {
        this.ioWrite = ioWrite;
    }

    public Long getIoWrite() {
        return this.ioWrite;
    }

    public void setIoRead(Long ioRead) {
        this.ioRead = ioRead;
    }

    public Long getIoRead() {
        return this.ioRead;
    }

    public void setBandwidth(Long bandwidth) {
        this.bandwidth = bandwidth;
    }

    public Long getBandwidth() {
        return this.bandwidth;
    }

    public void setInternetTraffic(Long internetTraffic) {
        this.internetTraffic = internetTraffic;
    }

    public Long getInternetTraffic() {
        return this.internetTraffic;
    }

    public void setIpV4(String ipV4) {
        this.ipV4 = ipV4;
    }

    public String getIpV4() {
        return this.ipV4;
    }

    public void setIpV6(String ipV6) {
        this.ipV6 = ipV6;
    }

    public String getIpV6() {
        return this.ipV6;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("hostId", (Object)this.getHostId()).append("model", (Object)this.getModel()).append("cpuCores", (Object)this.getCpuCores()).append("cpuModel", (Object)this.getCpuModel()).append("memory", (Object)this.getMemory()).append("diskCapacity", (Object)this.getDiskCapacity()).append("diskModel", (Object)this.getDiskModel()).append("ioWrite", (Object)this.getIoWrite()).append("ioRead", (Object)this.getIoRead()).append("bandwidth", (Object)this.getBandwidth()).append("internetTraffic", (Object)this.getInternetTraffic()).append("ipV4", (Object)this.getIpV4()).append("ipV6", (Object)this.getIpV6()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

