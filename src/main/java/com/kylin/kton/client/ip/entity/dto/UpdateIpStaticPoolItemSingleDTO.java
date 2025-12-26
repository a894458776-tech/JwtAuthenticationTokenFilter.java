/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.ip.entity.dto;

import lombok.Generated;

public class UpdateIpStaticPoolItemSingleDTO {
    private Integer status;
    private String ip;

    @Generated
    public UpdateIpStaticPoolItemSingleDTO() {
    }

    @Generated
    public Integer getStatus() {
        return this.status;
    }

    @Generated
    public String getIp() {
        return this.ip;
    }

    @Generated
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Generated
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof UpdateIpStaticPoolItemSingleDTO)) {
            return false;
        }
        UpdateIpStaticPoolItemSingleDTO other = (UpdateIpStaticPoolItemSingleDTO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Integer this$status = this.getStatus();
        Integer other$status = other.getStatus();
        if (this$status == null ? other$status != null : !((Object)this$status).equals(other$status)) {
            return false;
        }
        String this$ip = this.getIp();
        String other$ip = other.getIp();
        return !(this$ip == null ? other$ip != null : !this$ip.equals(other$ip));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof UpdateIpStaticPoolItemSingleDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : ((Object)$status).hashCode());
        String $ip = this.getIp();
        result = result * 59 + ($ip == null ? 43 : $ip.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "UpdateIpStaticPoolItemSingleDTO(status=" + this.getStatus() + ", ip=" + this.getIp() + ")";
    }
}

