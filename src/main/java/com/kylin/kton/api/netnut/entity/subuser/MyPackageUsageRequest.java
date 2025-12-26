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

public class MyPackageUsageRequest {
    @JsonProperty(value="date_range")
    private String dateRange;
    @JsonProperty(value="plan_status")
    private int planStatus;

    @Generated
    public MyPackageUsageRequest() {
    }

    @Generated
    public String getDateRange() {
        return this.dateRange;
    }

    @Generated
    public int getPlanStatus() {
        return this.planStatus;
    }

    @JsonProperty(value="date_range")
    @Generated
    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
    }

    @JsonProperty(value="plan_status")
    @Generated
    public void setPlanStatus(int planStatus) {
        this.planStatus = planStatus;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MyPackageUsageRequest)) {
            return false;
        }
        MyPackageUsageRequest other = (MyPackageUsageRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getPlanStatus() != other.getPlanStatus()) {
            return false;
        }
        String this$dateRange = this.getDateRange();
        String other$dateRange = other.getDateRange();
        return !(this$dateRange == null ? other$dateRange != null : !this$dateRange.equals(other$dateRange));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof MyPackageUsageRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getPlanStatus();
        String $dateRange = this.getDateRange();
        result = result * 59 + ($dateRange == null ? 43 : $dateRange.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "MyPackageUsageRequest(dateRange=" + this.getDateRange() + ", planStatus=" + this.getPlanStatus() + ")";
    }
}

