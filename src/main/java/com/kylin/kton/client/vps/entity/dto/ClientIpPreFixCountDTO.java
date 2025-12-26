/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.vps.entity.dto;

import lombok.Generated;

public class ClientIpPreFixCountDTO {
    private String ipPrefix;
    private String countIp;

    @Generated
    public ClientIpPreFixCountDTO() {
    }

    @Generated
    public String getIpPrefix() {
        return this.ipPrefix;
    }

    @Generated
    public String getCountIp() {
        return this.countIp;
    }

    @Generated
    public void setIpPrefix(String ipPrefix) {
        this.ipPrefix = ipPrefix;
    }

    @Generated
    public void setCountIp(String countIp) {
        this.countIp = countIp;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ClientIpPreFixCountDTO)) {
            return false;
        }
        ClientIpPreFixCountDTO other = (ClientIpPreFixCountDTO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$ipPrefix = this.getIpPrefix();
        String other$ipPrefix = other.getIpPrefix();
        if (this$ipPrefix == null ? other$ipPrefix != null : !this$ipPrefix.equals(other$ipPrefix)) {
            return false;
        }
        String this$countIp = this.getCountIp();
        String other$countIp = other.getCountIp();
        return !(this$countIp == null ? other$countIp != null : !this$countIp.equals(other$countIp));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ClientIpPreFixCountDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $ipPrefix = this.getIpPrefix();
        result = result * 59 + ($ipPrefix == null ? 43 : $ipPrefix.hashCode());
        String $countIp = this.getCountIp();
        result = result * 59 + ($countIp == null ? 43 : $countIp.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ClientIpPreFixCountDTO(ipPrefix=" + this.getIpPrefix() + ", countIp=" + this.getCountIp() + ")";
    }
}

