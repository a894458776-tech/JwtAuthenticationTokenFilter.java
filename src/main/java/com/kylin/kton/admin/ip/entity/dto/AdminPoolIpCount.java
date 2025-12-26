/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.dto;

import lombok.Generated;

public class AdminPoolIpCount {
    private Long poolId;
    private Integer ipCount;

    @Generated
    public AdminPoolIpCount() {
    }

    @Generated
    public Long getPoolId() {
        return this.poolId;
    }

    @Generated
    public Integer getIpCount() {
        return this.ipCount;
    }

    @Generated
    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    @Generated
    public void setIpCount(Integer ipCount) {
        this.ipCount = ipCount;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminPoolIpCount)) {
            return false;
        }
        AdminPoolIpCount other = (AdminPoolIpCount)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$poolId = this.getPoolId();
        Long other$poolId = other.getPoolId();
        if (this$poolId == null ? other$poolId != null : !((Object)this$poolId).equals(other$poolId)) {
            return false;
        }
        Integer this$ipCount = this.getIpCount();
        Integer other$ipCount = other.getIpCount();
        return !(this$ipCount == null ? other$ipCount != null : !((Object)this$ipCount).equals(other$ipCount));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminPoolIpCount;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $poolId = this.getPoolId();
        result = result * 59 + ($poolId == null ? 43 : ((Object)$poolId).hashCode());
        Integer $ipCount = this.getIpCount();
        result = result * 59 + ($ipCount == null ? 43 : ((Object)$ipCount).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminPoolIpCount(poolId=" + this.getPoolId() + ", ipCount=" + this.getIpCount() + ")";
    }
}

