/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Generated;

public class DataUsageRequest {
    @JsonProperty(value="date_range")
    private String dateRange;
    @JsonProperty(value="plan_status")
    private int planStatus;
    @JsonProperty(value="package_type")
    private String packageType;
    @JsonProperty(value="subscribers")
    private List<String> subscribers;

    @Generated
    public DataUsageRequest() {
    }

    @Generated
    public String getDateRange() {
        return this.dateRange;
    }

    @Generated
    public int getPlanStatus() {
        return this.planStatus;
    }

    @Generated
    public String getPackageType() {
        return this.packageType;
    }

    @Generated
    public List<String> getSubscribers() {
        return this.subscribers;
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

    @JsonProperty(value="package_type")
    @Generated
    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    @JsonProperty(value="subscribers")
    @Generated
    public void setSubscribers(List<String> subscribers) {
        this.subscribers = subscribers;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DataUsageRequest)) {
            return false;
        }
        DataUsageRequest other = (DataUsageRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getPlanStatus() != other.getPlanStatus()) {
            return false;
        }
        String this$dateRange = this.getDateRange();
        String other$dateRange = other.getDateRange();
        if (this$dateRange == null ? other$dateRange != null : !this$dateRange.equals(other$dateRange)) {
            return false;
        }
        String this$packageType = this.getPackageType();
        String other$packageType = other.getPackageType();
        if (this$packageType == null ? other$packageType != null : !this$packageType.equals(other$packageType)) {
            return false;
        }
        List<String> this$subscribers = this.getSubscribers();
        List<String> other$subscribers = other.getSubscribers();
        return !(this$subscribers == null ? other$subscribers != null : !((Object)this$subscribers).equals(other$subscribers));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof DataUsageRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getPlanStatus();
        String $dateRange = this.getDateRange();
        result = result * 59 + ($dateRange == null ? 43 : $dateRange.hashCode());
        String $packageType = this.getPackageType();
        result = result * 59 + ($packageType == null ? 43 : $packageType.hashCode());
        List<String> $subscribers = this.getSubscribers();
        result = result * 59 + ($subscribers == null ? 43 : ((Object)$subscribers).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "DataUsageRequest(dateRange=" + this.getDateRange() + ", planStatus=" + this.getPlanStatus() + ", packageType=" + this.getPackageType() + ", subscribers=" + this.getSubscribers() + ")";
    }
}

