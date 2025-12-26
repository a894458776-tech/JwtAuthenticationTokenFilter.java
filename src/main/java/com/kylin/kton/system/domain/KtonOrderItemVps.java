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

public class KtonOrderItemVps
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="VPSID")
    private Long vpsId;
    @Excel(name="\u8ba2\u5355ID")
    private Long orderId;
    @Excel(name="\u4e3b\u673aIP")
    private String hostIp;
    @Excel(name="\u4e3b\u673aID")
    private Long hostId;
    @Excel(name="\u96c6\u7fa4ID")
    private Long clusterId;
    @Excel(name="\u5bb9\u5668IP")
    private String vpsIp;
    @Excel(name="\u6a21\u7248ID")
    private String hostTemplateId;
    @Excel(name="\u955c\u50cf\u540d\u79f0:\u7248\u672c\u53f7")
    private String imagesUrl;
    @Excel(name="\u6fc0\u6d3b\u65f6\u957f\u7c7b\u578b")
    private String activationDurationType;
    @Excel(name="(0-\u72ec\u7acb\uff0c1-\u5171\u4eab)")
    private Long vpsType;
    @Excel(name="\u6d32(Asia-\u4e9a\u6d32\uff0cNorthAmerica-\u5317\u7f8e\u6d32, Europe-\u6b27\u6d32)")
    private String continent;
    @Excel(name="\u56fd\u5bb6\u7f16\u7801")
    private String countryCode;
    @Excel(name="\u57ce\u5e02")
    private String city;
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
    @JsonFormat(pattern="yyyy-MM-dd")
    @Excel(name="\u9000\u8ba2\u65f6\u95f4", width=30.0, dateFormat="yyyy-MM-dd")
    private Date unsubscribeTime;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setVpsId(Long vpsId) {
        this.vpsId = vpsId;
    }

    public Long getVpsId() {
        return this.vpsId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public String getHostIp() {
        return this.hostIp;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public Long getHostId() {
        return this.hostId;
    }

    public void setClusterId(Long clusterId) {
        this.clusterId = clusterId;
    }

    public Long getClusterId() {
        return this.clusterId;
    }

    public void setVpsIp(String vpsIp) {
        this.vpsIp = vpsIp;
    }

    public String getVpsIp() {
        return this.vpsIp;
    }

    public void setHostTemplateId(String hostTemplateId) {
        this.hostTemplateId = hostTemplateId;
    }

    public String getHostTemplateId() {
        return this.hostTemplateId;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public String getImagesUrl() {
        return this.imagesUrl;
    }

    public void setActivationDurationType(String activationDurationType) {
        this.activationDurationType = activationDurationType;
    }

    public String getActivationDurationType() {
        return this.activationDurationType;
    }

    public void setVpsType(Long vpsType) {
        this.vpsType = vpsType;
    }

    public Long getVpsType() {
        return this.vpsType;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getContinent() {
        return this.continent;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
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

    public void setUnsubscribeTime(Date unsubscribeTime) {
        this.unsubscribeTime = unsubscribeTime;
    }

    public Date getUnsubscribeTime() {
        return this.unsubscribeTime;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("vpsId", (Object)this.getVpsId()).append("orderId", (Object)this.getOrderId()).append("hostIp", (Object)this.getHostIp()).append("hostId", (Object)this.getHostId()).append("clusterId", (Object)this.getClusterId()).append("vpsIp", (Object)this.getVpsIp()).append("hostTemplateId", (Object)this.getHostTemplateId()).append("imagesUrl", (Object)this.getImagesUrl()).append("activationDurationType", (Object)this.getActivationDurationType()).append("vpsType", (Object)this.getVpsType()).append("continent", (Object)this.getContinent()).append("countryCode", (Object)this.getCountryCode()).append("city", (Object)this.getCity()).append("effectiveDatetime", (Object)this.getEffectiveDatetime()).append("expireDatetime", (Object)this.getExpireDatetime()).append("model", (Object)this.getModel()).append("cpuCores", (Object)this.getCpuCores()).append("cpuModel", (Object)this.getCpuModel()).append("memory", (Object)this.getMemory()).append("diskCapacity", (Object)this.getDiskCapacity()).append("diskModel", (Object)this.getDiskModel()).append("ioWrite", (Object)this.getIoWrite()).append("ioRead", (Object)this.getIoRead()).append("bandwidth", (Object)this.getBandwidth()).append("internetTraffic", (Object)this.getInternetTraffic()).append("ipV4", (Object)this.getIpV4()).append("ipV6", (Object)this.getIpV6()).append("unsubscribeTime", (Object)this.getUnsubscribeTime()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

