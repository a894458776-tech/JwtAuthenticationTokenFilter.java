/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.kylin.kton.common.annotation.Excel
 *  lombok.Generated
 */
package com.kylin.kton.client.order.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kylin.kton.common.annotation.Excel;
import java.util.Date;
import lombok.Generated;

public class ClientOrderItemVpsDTO {
    private String orderNo;
    private String hostIp;
    private String containerId;
    @Excel(name="\u96c6\u7fa4ID")
    private Long clusterId;
    @Excel(name="\u6a21\u7248ID")
    private String hostTemplateId;
    @Excel(name="\u6fc0\u6d3b\u65f6\u957f\u7c7b\u578b")
    private String activationDurationType;
    @Excel(name="\u6d32(Asia-\u4e9a\u6d32\uff0cNorthAmerica-\u5317\u7f8e\u6d32, Europe-\u6b27\u6d32)")
    private String continent;
    @Excel(name="\u56fd\u5bb6\u7f16\u7801")
    private String countryCode;
    @Excel(name="\u57ce\u5e02")
    private String city;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Excel(name="\u751f\u6548\u65f6\u95f4", width=30.0, dateFormat="yyyy-MM-dd")
    private Date effectiveDatetime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
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

    @Generated
    public ClientOrderItemVpsDTO() {
    }

    @Generated
    public String getOrderNo() {
        return this.orderNo;
    }

    @Generated
    public String getHostIp() {
        return this.hostIp;
    }

    @Generated
    public String getContainerId() {
        return this.containerId;
    }

    @Generated
    public Long getClusterId() {
        return this.clusterId;
    }

    @Generated
    public String getHostTemplateId() {
        return this.hostTemplateId;
    }

    @Generated
    public String getActivationDurationType() {
        return this.activationDurationType;
    }

    @Generated
    public String getContinent() {
        return this.continent;
    }

    @Generated
    public String getCountryCode() {
        return this.countryCode;
    }

    @Generated
    public String getCity() {
        return this.city;
    }

    @Generated
    public Date getEffectiveDatetime() {
        return this.effectiveDatetime;
    }

    @Generated
    public Date getExpireDatetime() {
        return this.expireDatetime;
    }

    @Generated
    public String getModel() {
        return this.model;
    }

    @Generated
    public Long getCpuCores() {
        return this.cpuCores;
    }

    @Generated
    public String getCpuModel() {
        return this.cpuModel;
    }

    @Generated
    public Long getMemory() {
        return this.memory;
    }

    @Generated
    public Long getDiskCapacity() {
        return this.diskCapacity;
    }

    @Generated
    public String getDiskModel() {
        return this.diskModel;
    }

    @Generated
    public Long getIoWrite() {
        return this.ioWrite;
    }

    @Generated
    public Long getIoRead() {
        return this.ioRead;
    }

    @Generated
    public Long getBandwidth() {
        return this.bandwidth;
    }

    @Generated
    public Long getInternetTraffic() {
        return this.internetTraffic;
    }

    @Generated
    public String getIpV4() {
        return this.ipV4;
    }

    @Generated
    public String getIpV6() {
        return this.ipV6;
    }

    @Generated
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Generated
    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    @Generated
    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    @Generated
    public void setClusterId(Long clusterId) {
        this.clusterId = clusterId;
    }

    @Generated
    public void setHostTemplateId(String hostTemplateId) {
        this.hostTemplateId = hostTemplateId;
    }

    @Generated
    public void setActivationDurationType(String activationDurationType) {
        this.activationDurationType = activationDurationType;
    }

    @Generated
    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Generated
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Generated
    public void setCity(String city) {
        this.city = city;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Generated
    public void setEffectiveDatetime(Date effectiveDatetime) {
        this.effectiveDatetime = effectiveDatetime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Generated
    public void setExpireDatetime(Date expireDatetime) {
        this.expireDatetime = expireDatetime;
    }

    @Generated
    public void setModel(String model) {
        this.model = model;
    }

    @Generated
    public void setCpuCores(Long cpuCores) {
        this.cpuCores = cpuCores;
    }

    @Generated
    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }

    @Generated
    public void setMemory(Long memory) {
        this.memory = memory;
    }

    @Generated
    public void setDiskCapacity(Long diskCapacity) {
        this.diskCapacity = diskCapacity;
    }

    @Generated
    public void setDiskModel(String diskModel) {
        this.diskModel = diskModel;
    }

    @Generated
    public void setIoWrite(Long ioWrite) {
        this.ioWrite = ioWrite;
    }

    @Generated
    public void setIoRead(Long ioRead) {
        this.ioRead = ioRead;
    }

    @Generated
    public void setBandwidth(Long bandwidth) {
        this.bandwidth = bandwidth;
    }

    @Generated
    public void setInternetTraffic(Long internetTraffic) {
        this.internetTraffic = internetTraffic;
    }

    @Generated
    public void setIpV4(String ipV4) {
        this.ipV4 = ipV4;
    }

    @Generated
    public void setIpV6(String ipV6) {
        this.ipV6 = ipV6;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ClientOrderItemVpsDTO)) {
            return false;
        }
        ClientOrderItemVpsDTO other = (ClientOrderItemVpsDTO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$clusterId = this.getClusterId();
        Long other$clusterId = other.getClusterId();
        if (this$clusterId == null ? other$clusterId != null : !((Object)this$clusterId).equals(other$clusterId)) {
            return false;
        }
        Long this$cpuCores = this.getCpuCores();
        Long other$cpuCores = other.getCpuCores();
        if (this$cpuCores == null ? other$cpuCores != null : !((Object)this$cpuCores).equals(other$cpuCores)) {
            return false;
        }
        Long this$memory = this.getMemory();
        Long other$memory = other.getMemory();
        if (this$memory == null ? other$memory != null : !((Object)this$memory).equals(other$memory)) {
            return false;
        }
        Long this$diskCapacity = this.getDiskCapacity();
        Long other$diskCapacity = other.getDiskCapacity();
        if (this$diskCapacity == null ? other$diskCapacity != null : !((Object)this$diskCapacity).equals(other$diskCapacity)) {
            return false;
        }
        Long this$ioWrite = this.getIoWrite();
        Long other$ioWrite = other.getIoWrite();
        if (this$ioWrite == null ? other$ioWrite != null : !((Object)this$ioWrite).equals(other$ioWrite)) {
            return false;
        }
        Long this$ioRead = this.getIoRead();
        Long other$ioRead = other.getIoRead();
        if (this$ioRead == null ? other$ioRead != null : !((Object)this$ioRead).equals(other$ioRead)) {
            return false;
        }
        Long this$bandwidth = this.getBandwidth();
        Long other$bandwidth = other.getBandwidth();
        if (this$bandwidth == null ? other$bandwidth != null : !((Object)this$bandwidth).equals(other$bandwidth)) {
            return false;
        }
        Long this$internetTraffic = this.getInternetTraffic();
        Long other$internetTraffic = other.getInternetTraffic();
        if (this$internetTraffic == null ? other$internetTraffic != null : !((Object)this$internetTraffic).equals(other$internetTraffic)) {
            return false;
        }
        String this$orderNo = this.getOrderNo();
        String other$orderNo = other.getOrderNo();
        if (this$orderNo == null ? other$orderNo != null : !this$orderNo.equals(other$orderNo)) {
            return false;
        }
        String this$hostIp = this.getHostIp();
        String other$hostIp = other.getHostIp();
        if (this$hostIp == null ? other$hostIp != null : !this$hostIp.equals(other$hostIp)) {
            return false;
        }
        String this$containerId = this.getContainerId();
        String other$containerId = other.getContainerId();
        if (this$containerId == null ? other$containerId != null : !this$containerId.equals(other$containerId)) {
            return false;
        }
        String this$hostTemplateId = this.getHostTemplateId();
        String other$hostTemplateId = other.getHostTemplateId();
        if (this$hostTemplateId == null ? other$hostTemplateId != null : !this$hostTemplateId.equals(other$hostTemplateId)) {
            return false;
        }
        String this$activationDurationType = this.getActivationDurationType();
        String other$activationDurationType = other.getActivationDurationType();
        if (this$activationDurationType == null ? other$activationDurationType != null : !this$activationDurationType.equals(other$activationDurationType)) {
            return false;
        }
        String this$continent = this.getContinent();
        String other$continent = other.getContinent();
        if (this$continent == null ? other$continent != null : !this$continent.equals(other$continent)) {
            return false;
        }
        String this$countryCode = this.getCountryCode();
        String other$countryCode = other.getCountryCode();
        if (this$countryCode == null ? other$countryCode != null : !this$countryCode.equals(other$countryCode)) {
            return false;
        }
        String this$city = this.getCity();
        String other$city = other.getCity();
        if (this$city == null ? other$city != null : !this$city.equals(other$city)) {
            return false;
        }
        Date this$effectiveDatetime = this.getEffectiveDatetime();
        Date other$effectiveDatetime = other.getEffectiveDatetime();
        if (this$effectiveDatetime == null ? other$effectiveDatetime != null : !((Object)this$effectiveDatetime).equals(other$effectiveDatetime)) {
            return false;
        }
        Date this$expireDatetime = this.getExpireDatetime();
        Date other$expireDatetime = other.getExpireDatetime();
        if (this$expireDatetime == null ? other$expireDatetime != null : !((Object)this$expireDatetime).equals(other$expireDatetime)) {
            return false;
        }
        String this$model = this.getModel();
        String other$model = other.getModel();
        if (this$model == null ? other$model != null : !this$model.equals(other$model)) {
            return false;
        }
        String this$cpuModel = this.getCpuModel();
        String other$cpuModel = other.getCpuModel();
        if (this$cpuModel == null ? other$cpuModel != null : !this$cpuModel.equals(other$cpuModel)) {
            return false;
        }
        String this$diskModel = this.getDiskModel();
        String other$diskModel = other.getDiskModel();
        if (this$diskModel == null ? other$diskModel != null : !this$diskModel.equals(other$diskModel)) {
            return false;
        }
        String this$ipV4 = this.getIpV4();
        String other$ipV4 = other.getIpV4();
        if (this$ipV4 == null ? other$ipV4 != null : !this$ipV4.equals(other$ipV4)) {
            return false;
        }
        String this$ipV6 = this.getIpV6();
        String other$ipV6 = other.getIpV6();
        return !(this$ipV6 == null ? other$ipV6 != null : !this$ipV6.equals(other$ipV6));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ClientOrderItemVpsDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $clusterId = this.getClusterId();
        result = result * 59 + ($clusterId == null ? 43 : ((Object)$clusterId).hashCode());
        Long $cpuCores = this.getCpuCores();
        result = result * 59 + ($cpuCores == null ? 43 : ((Object)$cpuCores).hashCode());
        Long $memory = this.getMemory();
        result = result * 59 + ($memory == null ? 43 : ((Object)$memory).hashCode());
        Long $diskCapacity = this.getDiskCapacity();
        result = result * 59 + ($diskCapacity == null ? 43 : ((Object)$diskCapacity).hashCode());
        Long $ioWrite = this.getIoWrite();
        result = result * 59 + ($ioWrite == null ? 43 : ((Object)$ioWrite).hashCode());
        Long $ioRead = this.getIoRead();
        result = result * 59 + ($ioRead == null ? 43 : ((Object)$ioRead).hashCode());
        Long $bandwidth = this.getBandwidth();
        result = result * 59 + ($bandwidth == null ? 43 : ((Object)$bandwidth).hashCode());
        Long $internetTraffic = this.getInternetTraffic();
        result = result * 59 + ($internetTraffic == null ? 43 : ((Object)$internetTraffic).hashCode());
        String $orderNo = this.getOrderNo();
        result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
        String $hostIp = this.getHostIp();
        result = result * 59 + ($hostIp == null ? 43 : $hostIp.hashCode());
        String $containerId = this.getContainerId();
        result = result * 59 + ($containerId == null ? 43 : $containerId.hashCode());
        String $hostTemplateId = this.getHostTemplateId();
        result = result * 59 + ($hostTemplateId == null ? 43 : $hostTemplateId.hashCode());
        String $activationDurationType = this.getActivationDurationType();
        result = result * 59 + ($activationDurationType == null ? 43 : $activationDurationType.hashCode());
        String $continent = this.getContinent();
        result = result * 59 + ($continent == null ? 43 : $continent.hashCode());
        String $countryCode = this.getCountryCode();
        result = result * 59 + ($countryCode == null ? 43 : $countryCode.hashCode());
        String $city = this.getCity();
        result = result * 59 + ($city == null ? 43 : $city.hashCode());
        Date $effectiveDatetime = this.getEffectiveDatetime();
        result = result * 59 + ($effectiveDatetime == null ? 43 : ((Object)$effectiveDatetime).hashCode());
        Date $expireDatetime = this.getExpireDatetime();
        result = result * 59 + ($expireDatetime == null ? 43 : ((Object)$expireDatetime).hashCode());
        String $model = this.getModel();
        result = result * 59 + ($model == null ? 43 : $model.hashCode());
        String $cpuModel = this.getCpuModel();
        result = result * 59 + ($cpuModel == null ? 43 : $cpuModel.hashCode());
        String $diskModel = this.getDiskModel();
        result = result * 59 + ($diskModel == null ? 43 : $diskModel.hashCode());
        String $ipV4 = this.getIpV4();
        result = result * 59 + ($ipV4 == null ? 43 : $ipV4.hashCode());
        String $ipV6 = this.getIpV6();
        result = result * 59 + ($ipV6 == null ? 43 : $ipV6.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ClientOrderItemVpsDTO(orderNo=" + this.getOrderNo() + ", hostIp=" + this.getHostIp() + ", containerId=" + this.getContainerId() + ", clusterId=" + this.getClusterId() + ", hostTemplateId=" + this.getHostTemplateId() + ", activationDurationType=" + this.getActivationDurationType() + ", continent=" + this.getContinent() + ", countryCode=" + this.getCountryCode() + ", city=" + this.getCity() + ", effectiveDatetime=" + this.getEffectiveDatetime() + ", expireDatetime=" + this.getExpireDatetime() + ", model=" + this.getModel() + ", cpuCores=" + this.getCpuCores() + ", cpuModel=" + this.getCpuModel() + ", memory=" + this.getMemory() + ", diskCapacity=" + this.getDiskCapacity() + ", diskModel=" + this.getDiskModel() + ", ioWrite=" + this.getIoWrite() + ", ioRead=" + this.getIoRead() + ", bandwidth=" + this.getBandwidth() + ", internetTraffic=" + this.getInternetTraffic() + ", ipV4=" + this.getIpV4() + ", ipV6=" + this.getIpV6() + ")";
    }
}

