/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.oxylabs.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kylin.kton.api.oxylabs.entity.subuser.BaseResponse;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Generated;

public class CustomerAllUsageResponse
extends BaseResponse
implements Serializable {
    private Integer id;
    @JsonProperty(value="start_date")
    private String startDate;
    @JsonProperty(value="end_date")
    private String endDate;
    @JsonProperty(value="is_active")
    private Boolean isActive;
    @JsonProperty(value="total_requests_used")
    private BigDecimal totalRequestsUsed;
    @JsonProperty(value="total_gb_used")
    private BigDecimal totalGbUsed;
    @JsonProperty(value="usage_percentage")
    private BigDecimal usagePercentage;
    @JsonProperty(value="plan_gb")
    private BigDecimal planGb;
    @JsonProperty(value="product_type")
    private String productType;
    @JsonProperty(value="plan_name")
    private String planName;

    @Override
    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CustomerAllUsageResponse)) {
            return false;
        }
        CustomerAllUsageResponse other = (CustomerAllUsageResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Integer this$id = this.getId();
        Integer other$id = other.getId();
        if (this$id == null ? other$id != null : !((Object)this$id).equals(other$id)) {
            return false;
        }
        Boolean this$isActive = this.getIsActive();
        Boolean other$isActive = other.getIsActive();
        if (this$isActive == null ? other$isActive != null : !((Object)this$isActive).equals(other$isActive)) {
            return false;
        }
        String this$startDate = this.getStartDate();
        String other$startDate = other.getStartDate();
        if (this$startDate == null ? other$startDate != null : !this$startDate.equals(other$startDate)) {
            return false;
        }
        String this$endDate = this.getEndDate();
        String other$endDate = other.getEndDate();
        if (this$endDate == null ? other$endDate != null : !this$endDate.equals(other$endDate)) {
            return false;
        }
        BigDecimal this$totalRequestsUsed = this.getTotalRequestsUsed();
        BigDecimal other$totalRequestsUsed = other.getTotalRequestsUsed();
        if (this$totalRequestsUsed == null ? other$totalRequestsUsed != null : !((Object)this$totalRequestsUsed).equals(other$totalRequestsUsed)) {
            return false;
        }
        BigDecimal this$totalGbUsed = this.getTotalGbUsed();
        BigDecimal other$totalGbUsed = other.getTotalGbUsed();
        if (this$totalGbUsed == null ? other$totalGbUsed != null : !((Object)this$totalGbUsed).equals(other$totalGbUsed)) {
            return false;
        }
        BigDecimal this$usagePercentage = this.getUsagePercentage();
        BigDecimal other$usagePercentage = other.getUsagePercentage();
        if (this$usagePercentage == null ? other$usagePercentage != null : !((Object)this$usagePercentage).equals(other$usagePercentage)) {
            return false;
        }
        BigDecimal this$planGb = this.getPlanGb();
        BigDecimal other$planGb = other.getPlanGb();
        if (this$planGb == null ? other$planGb != null : !((Object)this$planGb).equals(other$planGb)) {
            return false;
        }
        String this$productType = this.getProductType();
        String other$productType = other.getProductType();
        if (this$productType == null ? other$productType != null : !this$productType.equals(other$productType)) {
            return false;
        }
        String this$planName = this.getPlanName();
        String other$planName = other.getPlanName();
        return !(this$planName == null ? other$planName != null : !this$planName.equals(other$planName));
    }

    @Override
    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof CustomerAllUsageResponse;
    }

    @Override
    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = super.hashCode();
        Integer $id = this.getId();
        result = result * 59 + ($id == null ? 43 : ((Object)$id).hashCode());
        Boolean $isActive = this.getIsActive();
        result = result * 59 + ($isActive == null ? 43 : ((Object)$isActive).hashCode());
        String $startDate = this.getStartDate();
        result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
        String $endDate = this.getEndDate();
        result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
        BigDecimal $totalRequestsUsed = this.getTotalRequestsUsed();
        result = result * 59 + ($totalRequestsUsed == null ? 43 : ((Object)$totalRequestsUsed).hashCode());
        BigDecimal $totalGbUsed = this.getTotalGbUsed();
        result = result * 59 + ($totalGbUsed == null ? 43 : ((Object)$totalGbUsed).hashCode());
        BigDecimal $usagePercentage = this.getUsagePercentage();
        result = result * 59 + ($usagePercentage == null ? 43 : ((Object)$usagePercentage).hashCode());
        BigDecimal $planGb = this.getPlanGb();
        result = result * 59 + ($planGb == null ? 43 : ((Object)$planGb).hashCode());
        String $productType = this.getProductType();
        result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
        String $planName = this.getPlanName();
        result = result * 59 + ($planName == null ? 43 : $planName.hashCode());
        return result;
    }

    @Generated
    public CustomerAllUsageResponse() {
    }

    @Generated
    public Integer getId() {
        return this.id;
    }

    @Generated
    public String getStartDate() {
        return this.startDate;
    }

    @Generated
    public String getEndDate() {
        return this.endDate;
    }

    @Generated
    public Boolean getIsActive() {
        return this.isActive;
    }

    @Generated
    public BigDecimal getTotalRequestsUsed() {
        return this.totalRequestsUsed;
    }

    @Generated
    public BigDecimal getTotalGbUsed() {
        return this.totalGbUsed;
    }

    @Generated
    public BigDecimal getUsagePercentage() {
        return this.usagePercentage;
    }

    @Generated
    public BigDecimal getPlanGb() {
        return this.planGb;
    }

    @Generated
    public String getProductType() {
        return this.productType;
    }

    @Generated
    public String getPlanName() {
        return this.planName;
    }

    @Generated
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty(value="start_date")
    @Generated
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty(value="end_date")
    @Generated
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @JsonProperty(value="is_active")
    @Generated
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty(value="total_requests_used")
    @Generated
    public void setTotalRequestsUsed(BigDecimal totalRequestsUsed) {
        this.totalRequestsUsed = totalRequestsUsed;
    }

    @JsonProperty(value="total_gb_used")
    @Generated
    public void setTotalGbUsed(BigDecimal totalGbUsed) {
        this.totalGbUsed = totalGbUsed;
    }

    @JsonProperty(value="usage_percentage")
    @Generated
    public void setUsagePercentage(BigDecimal usagePercentage) {
        this.usagePercentage = usagePercentage;
    }

    @JsonProperty(value="plan_gb")
    @Generated
    public void setPlanGb(BigDecimal planGb) {
        this.planGb = planGb;
    }

    @JsonProperty(value="product_type")
    @Generated
    public void setProductType(String productType) {
        this.productType = productType;
    }

    @JsonProperty(value="plan_name")
    @Generated
    public void setPlanName(String planName) {
        this.planName = planName;
    }

    @Override
    @Generated
    public String toString() {
        return "CustomerAllUsageResponse(id=" + this.getId() + ", startDate=" + this.getStartDate() + ", endDate=" + this.getEndDate() + ", isActive=" + this.getIsActive() + ", totalRequestsUsed=" + this.getTotalRequestsUsed() + ", totalGbUsed=" + this.getTotalGbUsed() + ", usagePercentage=" + this.getUsagePercentage() + ", planGb=" + this.getPlanGb() + ", productType=" + this.getProductType() + ", planName=" + this.getPlanName() + ")";
    }
}

