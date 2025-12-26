/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.vo;

import java.math.BigDecimal;
import lombok.Generated;

public class AdminIpStaticItemDetailsVO {
    private Long ipType;
    private Long totalIps;
    private BigDecimal price;
    private String status;

    @Generated
    public AdminIpStaticItemDetailsVO() {
    }

    @Generated
    public Long getIpType() {
        return this.ipType;
    }

    @Generated
    public Long getTotalIps() {
        return this.totalIps;
    }

    @Generated
    public BigDecimal getPrice() {
        return this.price;
    }

    @Generated
    public String getStatus() {
        return this.status;
    }

    @Generated
    public void setIpType(Long ipType) {
        this.ipType = ipType;
    }

    @Generated
    public void setTotalIps(Long totalIps) {
        this.totalIps = totalIps;
    }

    @Generated
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Generated
    public void setStatus(String status) {
        this.status = status;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminIpStaticItemDetailsVO)) {
            return false;
        }
        AdminIpStaticItemDetailsVO other = (AdminIpStaticItemDetailsVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$ipType = this.getIpType();
        Long other$ipType = other.getIpType();
        if (this$ipType == null ? other$ipType != null : !((Object)this$ipType).equals(other$ipType)) {
            return false;
        }
        Long this$totalIps = this.getTotalIps();
        Long other$totalIps = other.getTotalIps();
        if (this$totalIps == null ? other$totalIps != null : !((Object)this$totalIps).equals(other$totalIps)) {
            return false;
        }
        BigDecimal this$price = this.getPrice();
        BigDecimal other$price = other.getPrice();
        if (this$price == null ? other$price != null : !((Object)this$price).equals(other$price)) {
            return false;
        }
        String this$status = this.getStatus();
        String other$status = other.getStatus();
        return !(this$status == null ? other$status != null : !this$status.equals(other$status));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminIpStaticItemDetailsVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $ipType = this.getIpType();
        result = result * 59 + ($ipType == null ? 43 : ((Object)$ipType).hashCode());
        Long $totalIps = this.getTotalIps();
        result = result * 59 + ($totalIps == null ? 43 : ((Object)$totalIps).hashCode());
        BigDecimal $price = this.getPrice();
        result = result * 59 + ($price == null ? 43 : ((Object)$price).hashCode());
        String $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminIpStaticItemDetailsVO(ipType=" + this.getIpType() + ", totalIps=" + this.getTotalIps() + ", price=" + this.getPrice() + ", status=" + this.getStatus() + ")";
    }
}

