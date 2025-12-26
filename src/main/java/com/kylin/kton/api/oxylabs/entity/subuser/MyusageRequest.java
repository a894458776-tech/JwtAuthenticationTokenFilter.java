/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.oxylabs.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

public class MyusageRequest {
    @JsonProperty(value="date_range")
    private String dateRange;
    @JsonProperty(value="plan_status")
    private String planStatus;

    @Generated
    public static MyusageRequestBuilder builder() {
        return new MyusageRequestBuilder();
    }

    @Generated
    public String getDateRange() {
        return this.dateRange;
    }

    @Generated
    public String getPlanStatus() {
        return this.planStatus;
    }

    @JsonProperty(value="date_range")
    @Generated
    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
    }

    @JsonProperty(value="plan_status")
    @Generated
    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MyusageRequest)) {
            return false;
        }
        MyusageRequest other = (MyusageRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$dateRange = this.getDateRange();
        String other$dateRange = other.getDateRange();
        if (this$dateRange == null ? other$dateRange != null : !this$dateRange.equals(other$dateRange)) {
            return false;
        }
        String this$planStatus = this.getPlanStatus();
        String other$planStatus = other.getPlanStatus();
        return !(this$planStatus == null ? other$planStatus != null : !this$planStatus.equals(other$planStatus));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof MyusageRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $dateRange = this.getDateRange();
        result = result * 59 + ($dateRange == null ? 43 : $dateRange.hashCode());
        String $planStatus = this.getPlanStatus();
        result = result * 59 + ($planStatus == null ? 43 : $planStatus.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "MyusageRequest(dateRange=" + this.getDateRange() + ", planStatus=" + this.getPlanStatus() + ")";
    }

    @Generated
    public MyusageRequest(String dateRange, String planStatus) {
        this.dateRange = dateRange;
        this.planStatus = planStatus;
    }

    @Generated
    public MyusageRequest() {
    }

    @Generated
    public static class MyusageRequestBuilder {
        @Generated
        private String dateRange;
        @Generated
        private String planStatus;

        @Generated
        MyusageRequestBuilder() {
        }

        @JsonProperty(value="date_range")
        @Generated
        public MyusageRequestBuilder dateRange(String dateRange) {
            this.dateRange = dateRange;
            return this;
        }

        @JsonProperty(value="plan_status")
        @Generated
        public MyusageRequestBuilder planStatus(String planStatus) {
            this.planStatus = planStatus;
            return this;
        }

        @Generated
        public MyusageRequest build() {
            return new MyusageRequest(this.dateRange, this.planStatus);
        }

        @Generated
        public String toString() {
            return "MyusageRequest.MyusageRequestBuilder(dateRange=" + this.dateRange + ", planStatus=" + this.planStatus + ")";
        }
    }
}

