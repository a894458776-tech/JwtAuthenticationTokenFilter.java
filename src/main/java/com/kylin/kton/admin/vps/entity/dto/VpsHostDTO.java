/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonVpsHost
 *  lombok.Generated
 */
package com.kylin.kton.admin.vps.entity.dto;

import com.kylin.kton.system.domain.KtonVpsHost;
import lombok.Generated;

public class VpsHostDTO
extends KtonVpsHost {
    private String clusterName;

    @Generated
    public VpsHostDTO() {
    }

    @Generated
    public String getClusterName() {
        return this.clusterName;
    }

    @Generated
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof VpsHostDTO)) {
            return false;
        }
        VpsHostDTO other = (VpsHostDTO)((Object)o);
        if (!other.canEqual((Object)this)) {
            return false;
        }
        String this$clusterName = this.getClusterName();
        String other$clusterName = other.getClusterName();
        return !(this$clusterName == null ? other$clusterName != null : !this$clusterName.equals(other$clusterName));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof VpsHostDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $clusterName = this.getClusterName();
        result = result * 59 + ($clusterName == null ? 43 : $clusterName.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "VpsHostDTO(clusterName=" + this.getClusterName() + ")";
    }
}

