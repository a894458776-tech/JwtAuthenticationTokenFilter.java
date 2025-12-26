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

public class TrafficUsageRequest {
    @JsonProperty(value="by_sub_user")
    private boolean bySubUser;
    @JsonProperty(value="sub_users")
    private List<String> subUsers;
    @JsonProperty(value="package_type")
    private Integer packageType;
    @JsonProperty(value="plan_status")
    private Integer planStatus;

    @Generated
    public TrafficUsageRequest() {
    }

    @Generated
    public boolean isBySubUser() {
        return this.bySubUser;
    }

    @Generated
    public List<String> getSubUsers() {
        return this.subUsers;
    }

    @Generated
    public Integer getPackageType() {
        return this.packageType;
    }

    @Generated
    public Integer getPlanStatus() {
        return this.planStatus;
    }

    @JsonProperty(value="by_sub_user")
    @Generated
    public void setBySubUser(boolean bySubUser) {
        this.bySubUser = bySubUser;
    }

    @JsonProperty(value="sub_users")
    @Generated
    public void setSubUsers(List<String> subUsers) {
        this.subUsers = subUsers;
    }

    @JsonProperty(value="package_type")
    @Generated
    public void setPackageType(Integer packageType) {
        this.packageType = packageType;
    }

    @JsonProperty(value="plan_status")
    @Generated
    public void setPlanStatus(Integer planStatus) {
        this.planStatus = planStatus;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TrafficUsageRequest)) {
            return false;
        }
        TrafficUsageRequest other = (TrafficUsageRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.isBySubUser() != other.isBySubUser()) {
            return false;
        }
        Integer this$packageType = this.getPackageType();
        Integer other$packageType = other.getPackageType();
        if (this$packageType == null ? other$packageType != null : !((Object)this$packageType).equals(other$packageType)) {
            return false;
        }
        Integer this$planStatus = this.getPlanStatus();
        Integer other$planStatus = other.getPlanStatus();
        if (this$planStatus == null ? other$planStatus != null : !((Object)this$planStatus).equals(other$planStatus)) {
            return false;
        }
        List<String> this$subUsers = this.getSubUsers();
        List<String> other$subUsers = other.getSubUsers();
        return !(this$subUsers == null ? other$subUsers != null : !((Object)this$subUsers).equals(other$subUsers));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof TrafficUsageRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isBySubUser() ? 79 : 97);
        Integer $packageType = this.getPackageType();
        result = result * 59 + ($packageType == null ? 43 : ((Object)$packageType).hashCode());
        Integer $planStatus = this.getPlanStatus();
        result = result * 59 + ($planStatus == null ? 43 : ((Object)$planStatus).hashCode());
        List<String> $subUsers = this.getSubUsers();
        result = result * 59 + ($subUsers == null ? 43 : ((Object)$subUsers).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "TrafficUsageRequest(bySubUser=" + this.isBySubUser() + ", subUsers=" + this.getSubUsers() + ", packageType=" + this.getPackageType() + ", planStatus=" + this.getPlanStatus() + ")";
    }
}

