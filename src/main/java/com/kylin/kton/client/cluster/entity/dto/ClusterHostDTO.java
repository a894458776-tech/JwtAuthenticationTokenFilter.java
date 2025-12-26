/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonVpsHost
 *  io.swagger.annotations.ApiModelProperty
 *  lombok.Generated
 */
package com.kylin.kton.client.cluster.entity.dto;

import com.kylin.kton.system.domain.KtonVpsHost;
import io.swagger.annotations.ApiModelProperty;
import lombok.Generated;

public class ClusterHostDTO
extends KtonVpsHost {
    @ApiModelProperty(value="\u53ef\u7528IP\u6570\u91cf")
    private Integer countIp;

    @Generated
    public ClusterHostDTO() {
    }

    @Generated
    public Integer getCountIp() {
        return this.countIp;
    }

    @Generated
    public void setCountIp(Integer countIp) {
        this.countIp = countIp;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ClusterHostDTO)) {
            return false;
        }
        ClusterHostDTO other = (ClusterHostDTO)((Object)o);
        if (!other.canEqual((Object)this)) {
            return false;
        }
        Integer this$countIp = this.getCountIp();
        Integer other$countIp = other.getCountIp();
        return !(this$countIp == null ? other$countIp != null : !((Object)this$countIp).equals(other$countIp));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ClusterHostDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $countIp = this.getCountIp();
        result = result * 59 + ($countIp == null ? 43 : ((Object)$countIp).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ClusterHostDTO(countIp=" + this.getCountIp() + ")";
    }
}

