/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.kylin.kton.common.annotation.Excel
 *  com.kylin.kton.common.core.domain.BaseEntity
 *  org.apache.commons.lang3.builder.ToStringBuilder
 *  org.apache.commons.lang3.builder.ToStringStyle
 */
package com.kylin.kton.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kylin.kton.common.annotation.Excel;
import com.kylin.kton.common.core.domain.BaseEntity;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class KtonVpsHostContainerParam
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="kton_vps_host_container.id")
    private Long containerId;
    @Excel(name="\u4e3b\u673aID")
    private Long hostId;
    @Excel(name="\u53c2\u6570\u914d\u7f6e\u6765\u6e90\u6a21\u677fID")
    private String hostTemplateId;
    @Excel(name="\u6fc0\u6d3b\u65f6\u957f\u7c7b\u578b")
    private Long activationDurationType;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Excel(name="\u751f\u6548\u65f6\u95f4", width=30.0, dateFormat="yyyy-MM-dd")
    private Date effectiveDatetime;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Excel(name="\u8fc7\u671f\u65f6\u95f4", width=30.0, dateFormat="yyyy-MM-dd")
    private Date expireDatetime;
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
    @Excel(name="\u955c\u50cf\u5730\u5740:\u7248\u672c\u53f7")
    private String imageUrl;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setContainerId(Long containerId) {
        this.containerId = containerId;
    }

    public Long getContainerId() {
        return this.containerId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public Long getHostId() {
        return this.hostId;
    }

    public void setHostTemplateId(String hostTemplateId) {
        this.hostTemplateId = hostTemplateId;
    }

    public String getHostTemplateId() {
        return this.hostTemplateId;
    }

    public void setActivationDurationType(Long activationDurationType) {
        this.activationDurationType = activationDurationType;
    }

    public Long getActivationDurationType() {
        return this.activationDurationType;
    }

    public void setEffectiveDatetime(Date effectiveDatetime) {
        this.effectiveDatetime = effectiveDatetime;
    }

    public Date getEffectiveDatetime() {
        return this.effectiveDatetime;
    }

    public void setExpireDatetime(Date expireDatetime) {
        this.expireDatetime = expireDatetime;
    }

    public Date getExpireDatetime() {
        return this.expireDatetime;
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

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("containerId", (Object)this.getContainerId()).append("hostId", (Object)this.getHostId()).append("hostTemplateId", (Object)this.getHostTemplateId()).append("activationDurationType", (Object)this.getActivationDurationType()).append("effectiveDatetime", (Object)this.getEffectiveDatetime()).append("expireDatetime", (Object)this.getExpireDatetime()).append("model", (Object)this.getModel()).append("cpuCores", (Object)this.getCpuCores()).append("cpuModel", (Object)this.getCpuModel()).append("memory", (Object)this.getMemory()).append("diskCapacity", (Object)this.getDiskCapacity()).append("diskModel", (Object)this.getDiskModel()).append("ioWrite", (Object)this.getIoWrite()).append("ioRead", (Object)this.getIoRead()).append("bandwidth", (Object)this.getBandwidth()).append("internetTraffic", (Object)this.getInternetTraffic()).append("ipV4", (Object)this.getIpV4()).append("ipV6", (Object)this.getIpV6()).append("imageUrl", (Object)this.getImageUrl()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

