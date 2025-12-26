/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.Generated;

public class CustomerPlansData {
    private int id;
    @JsonProperty(value="start_date")
    private LocalDate startDate;
    @JsonProperty(value="end_date")
    private LocalDate endDate;
    @JsonProperty(value="is_active")
    private Boolean isActive;
    @JsonProperty(value="total_requests_used")
    private int totalRequestsUsed;
    @JsonProperty(value="total_gb_used")
    private String totalGBUsed;
    @JsonProperty(value="is_over")
    private boolean isOver;
    @JsonProperty(value="plan_id")
    private int planId;
    @JsonProperty(value="product_type")
    private String productType;
    @JsonProperty(value="plan_name")
    private String planName;
    @JsonProperty(value="plan_gb")
    private String planGb;

    @Generated
    public CustomerPlansData() {
    }

    @Generated
    public int getId() {
        return this.id;
    }

    @Generated
    public LocalDate getStartDate() {
        return this.startDate;
    }

    @Generated
    public LocalDate getEndDate() {
        return this.endDate;
    }

    @Generated
    public Boolean getIsActive() {
        return this.isActive;
    }

    @Generated
    public int getTotalRequestsUsed() {
        return this.totalRequestsUsed;
    }

    @Generated
    public String getTotalGBUsed() {
        return this.totalGBUsed;
    }

    @Generated
    public boolean isOver() {
        return this.isOver;
    }

    @Generated
    public int getPlanId() {
        return this.planId;
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
    public String getPlanGb() {
        return this.planGb;
    }

    @Generated
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty(value="start_date")
    @Generated
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @JsonProperty(value="end_date")
    @Generated
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @JsonProperty(value="is_active")
    @Generated
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty(value="total_requests_used")
    @Generated
    public void setTotalRequestsUsed(int totalRequestsUsed) {
        this.totalRequestsUsed = totalRequestsUsed;
    }

    @JsonProperty(value="total_gb_used")
    @Generated
    public void setTotalGBUsed(String totalGBUsed) {
        this.totalGBUsed = totalGBUsed;
    }

    @JsonProperty(value="is_over")
    @Generated
    public void setOver(boolean isOver) {
        this.isOver = isOver;
    }

    @JsonProperty(value="plan_id")
    @Generated
    public void setPlanId(int planId) {
        this.planId = planId;
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

    @JsonProperty(value="plan_gb")
    @Generated
    public void setPlanGb(String planGb) {
        this.planGb = planGb;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CustomerPlansData)) {
            return false;
        }
        CustomerPlansData other = (CustomerPlansData)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getId() != other.getId()) {
            return false;
        }
        if (this.getTotalRequestsUsed() != other.getTotalRequestsUsed()) {
            return false;
        }
        if (this.isOver() != other.isOver()) {
            return false;
        }
        if (this.getPlanId() != other.getPlanId()) {
            return false;
        }
        Boolean this$isActive = this.getIsActive();
        Boolean other$isActive = other.getIsActive();
        if (this$isActive == null ? other$isActive != null : !((Object)this$isActive).equals(other$isActive)) {
            return false;
        }
        LocalDate this$startDate = this.getStartDate();
        LocalDate other$startDate = other.getStartDate();
        if (this$startDate == null ? other$startDate != null : !((Object)this$startDate).equals(other$startDate)) {
            return false;
        }
        LocalDate this$endDate = this.getEndDate();
        LocalDate other$endDate = other.getEndDate();
        if (this$endDate == null ? other$endDate != null : !((Object)this$endDate).equals(other$endDate)) {
            return false;
        }
        String this$totalGBUsed = this.getTotalGBUsed();
        String other$totalGBUsed = other.getTotalGBUsed();
        if (this$totalGBUsed == null ? other$totalGBUsed != null : !this$totalGBUsed.equals(other$totalGBUsed)) {
            return false;
        }
        String this$productType = this.getProductType();
        String other$productType = other.getProductType();
        if (this$productType == null ? other$productType != null : !this$productType.equals(other$productType)) {
            return false;
        }
        String this$planName = this.getPlanName();
        String other$planName = other.getPlanName();
        if (this$planName == null ? other$planName != null : !this$planName.equals(other$planName)) {
            return false;
        }
        String this$planGb = this.getPlanGb();
        String other$planGb = other.getPlanGb();
        return !(this$planGb == null ? other$planGb != null : !this$planGb.equals(other$planGb));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof CustomerPlansData;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getId();
        result = result * 59 + this.getTotalRequestsUsed();
        result = result * 59 + (this.isOver() ? 79 : 97);
        result = result * 59 + this.getPlanId();
        Boolean $isActive = this.getIsActive();
        result = result * 59 + ($isActive == null ? 43 : ((Object)$isActive).hashCode());
        LocalDate $startDate = this.getStartDate();
        result = result * 59 + ($startDate == null ? 43 : ((Object)$startDate).hashCode());
        LocalDate $endDate = this.getEndDate();
        result = result * 59 + ($endDate == null ? 43 : ((Object)$endDate).hashCode());
        String $totalGBUsed = this.getTotalGBUsed();
        result = result * 59 + ($totalGBUsed == null ? 43 : $totalGBUsed.hashCode());
        String $productType = this.getProductType();
        result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
        String $planName = this.getPlanName();
        result = result * 59 + ($planName == null ? 43 : $planName.hashCode());
        String $planGb = this.getPlanGb();
        result = result * 59 + ($planGb == null ? 43 : $planGb.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "CustomerPlansData(id=" + this.getId() + ", startDate=" + this.getStartDate() + ", endDate=" + this.getEndDate() + ", isActive=" + this.getIsActive() + ", totalRequestsUsed=" + this.getTotalRequestsUsed() + ", totalGBUsed=" + this.getTotalGBUsed() + ", isOver=" + this.isOver() + ", planId=" + this.getPlanId() + ", productType=" + this.getProductType() + ", planName=" + this.getPlanName() + ", planGb=" + this.getPlanGb() + ")";
    }
}

