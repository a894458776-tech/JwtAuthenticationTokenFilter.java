/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.cluster.entity.dto;

import java.math.BigDecimal;
import lombok.Generated;

public class ClusterTemplateDTO {
    private String id;
    private String templateId;
    private Long clusterId;
    private String model;
    private Long cpuCores;
    private String cpuModel;
    private Long memory;
    private Long diskCapacity;
    private String diskModel;
    private Long ioWrite;
    private Long ioRead;
    private Long bandwidth;
    private Long internetTraffic;
    private String ipV4;
    private String ipV6;
    private String refId;
    private BigDecimal priceMonthly;
    private BigDecimal priceQuarterly;
    private BigDecimal priceSemiAnnually;
    private BigDecimal priceAnnually;

    @Generated
    public ClusterTemplateDTO() {
    }

    @Generated
    public String getId() {
        return this.id;
    }

    @Generated
    public String getTemplateId() {
        return this.templateId;
    }

    @Generated
    public Long getClusterId() {
        return this.clusterId;
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
    public String getRefId() {
        return this.refId;
    }

    @Generated
    public BigDecimal getPriceMonthly() {
        return this.priceMonthly;
    }

    @Generated
    public BigDecimal getPriceQuarterly() {
        return this.priceQuarterly;
    }

    @Generated
    public BigDecimal getPriceSemiAnnually() {
        return this.priceSemiAnnually;
    }

    @Generated
    public BigDecimal getPriceAnnually() {
        return this.priceAnnually;
    }

    @Generated
    public void setId(String id) {
        this.id = id;
    }

    @Generated
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    @Generated
    public void setClusterId(Long clusterId) {
        this.clusterId = clusterId;
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
    public void setRefId(String refId) {
        this.refId = refId;
    }

    @Generated
    public void setPriceMonthly(BigDecimal priceMonthly) {
        this.priceMonthly = priceMonthly;
    }

    @Generated
    public void setPriceQuarterly(BigDecimal priceQuarterly) {
        this.priceQuarterly = priceQuarterly;
    }

    @Generated
    public void setPriceSemiAnnually(BigDecimal priceSemiAnnually) {
        this.priceSemiAnnually = priceSemiAnnually;
    }

    @Generated
    public void setPriceAnnually(BigDecimal priceAnnually) {
        this.priceAnnually = priceAnnually;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ClusterTemplateDTO)) {
            return false;
        }
        ClusterTemplateDTO other = (ClusterTemplateDTO)o;
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
        String this$id = this.getId();
        String other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
            return false;
        }
        String this$templateId = this.getTemplateId();
        String other$templateId = other.getTemplateId();
        if (this$templateId == null ? other$templateId != null : !this$templateId.equals(other$templateId)) {
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
        if (this$ipV6 == null ? other$ipV6 != null : !this$ipV6.equals(other$ipV6)) {
            return false;
        }
        String this$refId = this.getRefId();
        String other$refId = other.getRefId();
        if (this$refId == null ? other$refId != null : !this$refId.equals(other$refId)) {
            return false;
        }
        BigDecimal this$priceMonthly = this.getPriceMonthly();
        BigDecimal other$priceMonthly = other.getPriceMonthly();
        if (this$priceMonthly == null ? other$priceMonthly != null : !((Object)this$priceMonthly).equals(other$priceMonthly)) {
            return false;
        }
        BigDecimal this$priceQuarterly = this.getPriceQuarterly();
        BigDecimal other$priceQuarterly = other.getPriceQuarterly();
        if (this$priceQuarterly == null ? other$priceQuarterly != null : !((Object)this$priceQuarterly).equals(other$priceQuarterly)) {
            return false;
        }
        BigDecimal this$priceSemiAnnually = this.getPriceSemiAnnually();
        BigDecimal other$priceSemiAnnually = other.getPriceSemiAnnually();
        if (this$priceSemiAnnually == null ? other$priceSemiAnnually != null : !((Object)this$priceSemiAnnually).equals(other$priceSemiAnnually)) {
            return false;
        }
        BigDecimal this$priceAnnually = this.getPriceAnnually();
        BigDecimal other$priceAnnually = other.getPriceAnnually();
        return !(this$priceAnnually == null ? other$priceAnnually != null : !((Object)this$priceAnnually).equals(other$priceAnnually));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ClusterTemplateDTO;
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
        String $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        String $templateId = this.getTemplateId();
        result = result * 59 + ($templateId == null ? 43 : $templateId.hashCode());
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
        String $refId = this.getRefId();
        result = result * 59 + ($refId == null ? 43 : $refId.hashCode());
        BigDecimal $priceMonthly = this.getPriceMonthly();
        result = result * 59 + ($priceMonthly == null ? 43 : ((Object)$priceMonthly).hashCode());
        BigDecimal $priceQuarterly = this.getPriceQuarterly();
        result = result * 59 + ($priceQuarterly == null ? 43 : ((Object)$priceQuarterly).hashCode());
        BigDecimal $priceSemiAnnually = this.getPriceSemiAnnually();
        result = result * 59 + ($priceSemiAnnually == null ? 43 : ((Object)$priceSemiAnnually).hashCode());
        BigDecimal $priceAnnually = this.getPriceAnnually();
        result = result * 59 + ($priceAnnually == null ? 43 : ((Object)$priceAnnually).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ClusterTemplateDTO(id=" + this.getId() + ", templateId=" + this.getTemplateId() + ", clusterId=" + this.getClusterId() + ", model=" + this.getModel() + ", cpuCores=" + this.getCpuCores() + ", cpuModel=" + this.getCpuModel() + ", memory=" + this.getMemory() + ", diskCapacity=" + this.getDiskCapacity() + ", diskModel=" + this.getDiskModel() + ", ioWrite=" + this.getIoWrite() + ", ioRead=" + this.getIoRead() + ", bandwidth=" + this.getBandwidth() + ", internetTraffic=" + this.getInternetTraffic() + ", ipV4=" + this.getIpV4() + ", ipV6=" + this.getIpV6() + ", refId=" + this.getRefId() + ", priceMonthly=" + this.getPriceMonthly() + ", priceQuarterly=" + this.getPriceQuarterly() + ", priceSemiAnnually=" + this.getPriceSemiAnnually() + ", priceAnnually=" + this.getPriceAnnually() + ")";
    }
}

