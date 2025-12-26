/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  lombok.Generated
 */
package com.kylin.kton.admin.account.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Generated;

public class AdminAccountStatDTO {
    private Integer requestsTotal;
    private BigDecimal trafficTotal;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dUsage;

    @Generated
    public AdminAccountStatDTO() {
    }

    @Generated
    public Integer getRequestsTotal() {
        return this.requestsTotal;
    }

    @Generated
    public BigDecimal getTrafficTotal() {
        return this.trafficTotal;
    }

    @Generated
    public Date getDUsage() {
        return this.dUsage;
    }

    @Generated
    public void setRequestsTotal(Integer requestsTotal) {
        this.requestsTotal = requestsTotal;
    }

    @Generated
    public void setTrafficTotal(BigDecimal trafficTotal) {
        this.trafficTotal = trafficTotal;
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    @Generated
    public void setDUsage(Date dUsage) {
        this.dUsage = dUsage;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminAccountStatDTO)) {
            return false;
        }
        AdminAccountStatDTO other = (AdminAccountStatDTO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Integer this$requestsTotal = this.getRequestsTotal();
        Integer other$requestsTotal = other.getRequestsTotal();
        if (this$requestsTotal == null ? other$requestsTotal != null : !((Object)this$requestsTotal).equals(other$requestsTotal)) {
            return false;
        }
        BigDecimal this$trafficTotal = this.getTrafficTotal();
        BigDecimal other$trafficTotal = other.getTrafficTotal();
        if (this$trafficTotal == null ? other$trafficTotal != null : !((Object)this$trafficTotal).equals(other$trafficTotal)) {
            return false;
        }
        Date this$dUsage = this.getDUsage();
        Date other$dUsage = other.getDUsage();
        return !(this$dUsage == null ? other$dUsage != null : !((Object)this$dUsage).equals(other$dUsage));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminAccountStatDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $requestsTotal = this.getRequestsTotal();
        result = result * 59 + ($requestsTotal == null ? 43 : ((Object)$requestsTotal).hashCode());
        BigDecimal $trafficTotal = this.getTrafficTotal();
        result = result * 59 + ($trafficTotal == null ? 43 : ((Object)$trafficTotal).hashCode());
        Date $dUsage = this.getDUsage();
        result = result * 59 + ($dUsage == null ? 43 : ((Object)$dUsage).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminAccountStatDTO(requestsTotal=" + this.getRequestsTotal() + ", trafficTotal=" + this.getTrafficTotal() + ", dUsage=" + this.getDUsage() + ")";
    }
}

