/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.dto;

import lombok.Generated;

public class AdminMerchantAvailableIpListDTO {
    String ip;
    String poolId;

    @Generated
    public AdminMerchantAvailableIpListDTO() {
    }

    @Generated
    public String getIp() {
        return this.ip;
    }

    @Generated
    public String getPoolId() {
        return this.poolId;
    }

    @Generated
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Generated
    public void setPoolId(String poolId) {
        this.poolId = poolId;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminMerchantAvailableIpListDTO)) {
            return false;
        }
        AdminMerchantAvailableIpListDTO other = (AdminMerchantAvailableIpListDTO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$ip = this.getIp();
        String other$ip = other.getIp();
        if (this$ip == null ? other$ip != null : !this$ip.equals(other$ip)) {
            return false;
        }
        String this$poolId = this.getPoolId();
        String other$poolId = other.getPoolId();
        return !(this$poolId == null ? other$poolId != null : !this$poolId.equals(other$poolId));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminMerchantAvailableIpListDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $ip = this.getIp();
        result = result * 59 + ($ip == null ? 43 : $ip.hashCode());
        String $poolId = this.getPoolId();
        result = result * 59 + ($poolId == null ? 43 : $poolId.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminMerchantAvailableIpListDTO(ip=" + this.getIp() + ", poolId=" + this.getPoolId() + ")";
    }
}

