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

public class SubUserPlans {
    @JsonProperty(value="plan_id")
    private int planId;
    @JsonProperty(value="subscription_name")
    private String subscriptionName;
    @JsonProperty(value="is_active")
    private boolean isActive;
    @JsonProperty(value="usage")
    private int usage;
    @JsonProperty(value="start_date")
    private String startDate;
    @JsonProperty(value="end_date")
    private String endDate;
    @JsonProperty(value="subscription_bandwidth_gb")
    private int subscriptionBandwidthGB;

    @Generated
    public SubUserPlans() {
    }

    @Generated
    public int getPlanId() {
        return this.planId;
    }

    @Generated
    public String getSubscriptionName() {
        return this.subscriptionName;
    }

    @Generated
    public boolean isActive() {
        return this.isActive;
    }

    @Generated
    public int getUsage() {
        return this.usage;
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
    public int getSubscriptionBandwidthGB() {
        return this.subscriptionBandwidthGB;
    }

    @JsonProperty(value="plan_id")
    @Generated
    public void setPlanId(int planId) {
        this.planId = planId;
    }

    @JsonProperty(value="subscription_name")
    @Generated
    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }

    @JsonProperty(value="is_active")
    @Generated
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty(value="usage")
    @Generated
    public void setUsage(int usage) {
        this.usage = usage;
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

    @JsonProperty(value="subscription_bandwidth_gb")
    @Generated
    public void setSubscriptionBandwidthGB(int subscriptionBandwidthGB) {
        this.subscriptionBandwidthGB = subscriptionBandwidthGB;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SubUserPlans)) {
            return false;
        }
        SubUserPlans other = (SubUserPlans)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getPlanId() != other.getPlanId()) {
            return false;
        }
        if (this.isActive() != other.isActive()) {
            return false;
        }
        if (this.getUsage() != other.getUsage()) {
            return false;
        }
        if (this.getSubscriptionBandwidthGB() != other.getSubscriptionBandwidthGB()) {
            return false;
        }
        String this$subscriptionName = this.getSubscriptionName();
        String other$subscriptionName = other.getSubscriptionName();
        if (this$subscriptionName == null ? other$subscriptionName != null : !this$subscriptionName.equals(other$subscriptionName)) {
            return false;
        }
        String this$startDate = this.getStartDate();
        String other$startDate = other.getStartDate();
        if (this$startDate == null ? other$startDate != null : !this$startDate.equals(other$startDate)) {
            return false;
        }
        String this$endDate = this.getEndDate();
        String other$endDate = other.getEndDate();
        return !(this$endDate == null ? other$endDate != null : !this$endDate.equals(other$endDate));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof SubUserPlans;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getPlanId();
        result = result * 59 + (this.isActive() ? 79 : 97);
        result = result * 59 + this.getUsage();
        result = result * 59 + this.getSubscriptionBandwidthGB();
        String $subscriptionName = this.getSubscriptionName();
        result = result * 59 + ($subscriptionName == null ? 43 : $subscriptionName.hashCode());
        String $startDate = this.getStartDate();
        result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
        String $endDate = this.getEndDate();
        result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "SubUserPlans(planId=" + this.getPlanId() + ", subscriptionName=" + this.getSubscriptionName() + ", isActive=" + this.isActive() + ", usage=" + this.getUsage() + ", startDate=" + this.getStartDate() + ", endDate=" + this.getEndDate() + ", subscriptionBandwidthGB=" + this.getSubscriptionBandwidthGB() + ")";
    }
}

