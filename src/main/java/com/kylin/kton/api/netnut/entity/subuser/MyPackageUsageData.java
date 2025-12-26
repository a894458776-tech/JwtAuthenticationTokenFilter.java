/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

public class MyPackageUsageData {
    private int id;
    @JsonProperty(value="start_date")
    private String startDate;
    @JsonProperty(value="end_date")
    private String endDate;
    @JsonProperty(value="is_active")
    private boolean isActive;
    @JsonProperty(value="total_requests_used")
    private int totalRequestsUsed;
    @JsonProperty(value="total_gb_used")
    private String totalGBUsed;
    @JsonProperty(value="usage_percentage")
    private String usagePercentage;
    @JsonProperty(value="plan_id")
    private int planId;

    @Generated
    public MyPackageUsageData() {
    }

    @Generated
    public int getId() {
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
    public boolean isActive() {
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
    public String getUsagePercentage() {
        return this.usagePercentage;
    }

    @Generated
    public int getPlanId() {
        return this.planId;
    }

    @Generated
    public void setId(int id) {
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
    public void setActive(boolean isActive) {
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

    @JsonProperty(value="usage_percentage")
    @Generated
    public void setUsagePercentage(String usagePercentage) {
        this.usagePercentage = usagePercentage;
    }

    @JsonProperty(value="plan_id")
    @Generated
    public void setPlanId(int planId) {
        this.planId = planId;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MyPackageUsageData)) {
            return false;
        }
        MyPackageUsageData other = (MyPackageUsageData)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getId() != other.getId()) {
            return false;
        }
        if (this.isActive() != other.isActive()) {
            return false;
        }
        if (this.getTotalRequestsUsed() != other.getTotalRequestsUsed()) {
            return false;
        }
        if (this.getPlanId() != other.getPlanId()) {
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
        String this$totalGBUsed = this.getTotalGBUsed();
        String other$totalGBUsed = other.getTotalGBUsed();
        if (this$totalGBUsed == null ? other$totalGBUsed != null : !this$totalGBUsed.equals(other$totalGBUsed)) {
            return false;
        }
        String this$usagePercentage = this.getUsagePercentage();
        String other$usagePercentage = other.getUsagePercentage();
        return !(this$usagePercentage == null ? other$usagePercentage != null : !this$usagePercentage.equals(other$usagePercentage));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof MyPackageUsageData;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getId();
        result = result * 59 + (this.isActive() ? 79 : 97);
        result = result * 59 + this.getTotalRequestsUsed();
        result = result * 59 + this.getPlanId();
        String $startDate = this.getStartDate();
        result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
        String $endDate = this.getEndDate();
        result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
        String $totalGBUsed = this.getTotalGBUsed();
        result = result * 59 + ($totalGBUsed == null ? 43 : $totalGBUsed.hashCode());
        String $usagePercentage = this.getUsagePercentage();
        result = result * 59 + ($usagePercentage == null ? 43 : $usagePercentage.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "MyPackageUsageData(id=" + this.getId() + ", startDate=" + this.getStartDate() + ", endDate=" + this.getEndDate() + ", isActive=" + this.isActive() + ", totalRequestsUsed=" + this.getTotalRequestsUsed() + ", totalGBUsed=" + this.getTotalGBUsed() + ", usagePercentage=" + this.getUsagePercentage() + ", planId=" + this.getPlanId() + ")";
    }
}

