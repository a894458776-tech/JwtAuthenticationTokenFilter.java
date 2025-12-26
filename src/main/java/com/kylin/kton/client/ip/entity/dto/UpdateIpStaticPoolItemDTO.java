/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.ip.entity.dto;

import java.util.List;
import lombok.Generated;

public class UpdateIpStaticPoolItemDTO {
    private Integer status;
    private List<String> ips;

    @Generated
    public UpdateIpStaticPoolItemDTO() {
    }

    @Generated
    public Integer getStatus() {
        return this.status;
    }

    @Generated
    public List<String> getIps() {
        return this.ips;
    }

    @Generated
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Generated
    public void setIps(List<String> ips) {
        this.ips = ips;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof UpdateIpStaticPoolItemDTO)) {
            return false;
        }
        UpdateIpStaticPoolItemDTO other = (UpdateIpStaticPoolItemDTO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Integer this$status = this.getStatus();
        Integer other$status = other.getStatus();
        if (this$status == null ? other$status != null : !((Object)this$status).equals(other$status)) {
            return false;
        }
        List<String> this$ips = this.getIps();
        List<String> other$ips = other.getIps();
        return !(this$ips == null ? other$ips != null : !((Object)this$ips).equals(other$ips));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof UpdateIpStaticPoolItemDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : ((Object)$status).hashCode());
        List<String> $ips = this.getIps();
        result = result * 59 + ($ips == null ? 43 : ((Object)$ips).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "UpdateIpStaticPoolItemDTO(status=" + this.getStatus() + ", ips=" + this.getIps() + ")";
    }
}

