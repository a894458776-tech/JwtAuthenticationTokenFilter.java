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

public class CustomerUsageRequest {
    @JsonProperty(value="date_range")
    private Long dateRange;
    @JsonProperty(value="plan_status")
    private Long planStatus;
    @JsonProperty(value="package_type")
    private Long packageType;
    @JsonProperty(value="by_sub_user")
    private Long bySubUser;
    @JsonProperty(value="sub_users")
    private Long subUsers;

    @Generated
    public static CustomerUsageRequestBuilder builder() {
        return new CustomerUsageRequestBuilder();
    }

    @Generated
    public Long getDateRange() {
        return this.dateRange;
    }

    @Generated
    public Long getPlanStatus() {
        return this.planStatus;
    }

    @Generated
    public Long getPackageType() {
        return this.packageType;
    }

    @Generated
    public Long getBySubUser() {
        return this.bySubUser;
    }

    @Generated
    public Long getSubUsers() {
        return this.subUsers;
    }

    @JsonProperty(value="date_range")
    @Generated
    public void setDateRange(Long dateRange) {
        this.dateRange = dateRange;
    }

    @JsonProperty(value="plan_status")
    @Generated
    public void setPlanStatus(Long planStatus) {
        this.planStatus = planStatus;
    }

    @JsonProperty(value="package_type")
    @Generated
    public void setPackageType(Long packageType) {
        this.packageType = packageType;
    }

    @JsonProperty(value="by_sub_user")
    @Generated
    public void setBySubUser(Long bySubUser) {
        this.bySubUser = bySubUser;
    }

    @JsonProperty(value="sub_users")
    @Generated
    public void setSubUsers(Long subUsers) {
        this.subUsers = subUsers;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CustomerUsageRequest)) {
            return false;
        }
        CustomerUsageRequest other = (CustomerUsageRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$dateRange = this.getDateRange();
        Long other$dateRange = other.getDateRange();
        if (this$dateRange == null ? other$dateRange != null : !((Object)this$dateRange).equals(other$dateRange)) {
            return false;
        }
        Long this$planStatus = this.getPlanStatus();
        Long other$planStatus = other.getPlanStatus();
        if (this$planStatus == null ? other$planStatus != null : !((Object)this$planStatus).equals(other$planStatus)) {
            return false;
        }
        Long this$packageType = this.getPackageType();
        Long other$packageType = other.getPackageType();
        if (this$packageType == null ? other$packageType != null : !((Object)this$packageType).equals(other$packageType)) {
            return false;
        }
        Long this$bySubUser = this.getBySubUser();
        Long other$bySubUser = other.getBySubUser();
        if (this$bySubUser == null ? other$bySubUser != null : !((Object)this$bySubUser).equals(other$bySubUser)) {
            return false;
        }
        Long this$subUsers = this.getSubUsers();
        Long other$subUsers = other.getSubUsers();
        return !(this$subUsers == null ? other$subUsers != null : !((Object)this$subUsers).equals(other$subUsers));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof CustomerUsageRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $dateRange = this.getDateRange();
        result = result * 59 + ($dateRange == null ? 43 : ((Object)$dateRange).hashCode());
        Long $planStatus = this.getPlanStatus();
        result = result * 59 + ($planStatus == null ? 43 : ((Object)$planStatus).hashCode());
        Long $packageType = this.getPackageType();
        result = result * 59 + ($packageType == null ? 43 : ((Object)$packageType).hashCode());
        Long $bySubUser = this.getBySubUser();
        result = result * 59 + ($bySubUser == null ? 43 : ((Object)$bySubUser).hashCode());
        Long $subUsers = this.getSubUsers();
        result = result * 59 + ($subUsers == null ? 43 : ((Object)$subUsers).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "CustomerUsageRequest(dateRange=" + this.getDateRange() + ", planStatus=" + this.getPlanStatus() + ", packageType=" + this.getPackageType() + ", bySubUser=" + this.getBySubUser() + ", subUsers=" + this.getSubUsers() + ")";
    }

    @Generated
    public CustomerUsageRequest(Long dateRange, Long planStatus, Long packageType, Long bySubUser, Long subUsers) {
        this.dateRange = dateRange;
        this.planStatus = planStatus;
        this.packageType = packageType;
        this.bySubUser = bySubUser;
        this.subUsers = subUsers;
    }

    @Generated
    public CustomerUsageRequest() {
    }

    @Generated
    public static class CustomerUsageRequestBuilder {
        @Generated
        private Long dateRange;
        @Generated
        private Long planStatus;
        @Generated
        private Long packageType;
        @Generated
        private Long bySubUser;
        @Generated
        private Long subUsers;

        @Generated
        CustomerUsageRequestBuilder() {
        }

        @JsonProperty(value="date_range")
        @Generated
        public CustomerUsageRequestBuilder dateRange(Long dateRange) {
            this.dateRange = dateRange;
            return this;
        }

        @JsonProperty(value="plan_status")
        @Generated
        public CustomerUsageRequestBuilder planStatus(Long planStatus) {
            this.planStatus = planStatus;
            return this;
        }

        @JsonProperty(value="package_type")
        @Generated
        public CustomerUsageRequestBuilder packageType(Long packageType) {
            this.packageType = packageType;
            return this;
        }

        @JsonProperty(value="by_sub_user")
        @Generated
        public CustomerUsageRequestBuilder bySubUser(Long bySubUser) {
            this.bySubUser = bySubUser;
            return this;
        }

        @JsonProperty(value="sub_users")
        @Generated
        public CustomerUsageRequestBuilder subUsers(Long subUsers) {
            this.subUsers = subUsers;
            return this;
        }

        @Generated
        public CustomerUsageRequest build() {
            return new CustomerUsageRequest(this.dateRange, this.planStatus, this.packageType, this.bySubUser, this.subUsers);
        }

        @Generated
        public String toString() {
            return "CustomerUsageRequest.CustomerUsageRequestBuilder(dateRange=" + this.dateRange + ", planStatus=" + this.planStatus + ", packageType=" + this.packageType + ", bySubUser=" + this.bySubUser + ", subUsers=" + this.subUsers + ")";
        }
    }
}

