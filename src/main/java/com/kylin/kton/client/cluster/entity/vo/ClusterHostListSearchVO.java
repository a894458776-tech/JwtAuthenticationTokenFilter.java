/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.cluster.entity.vo;

import lombok.Generated;

public class ClusterHostListSearchVO {
    private Long clusterId;

    @Generated
    public ClusterHostListSearchVO() {
    }

    @Generated
    public Long getClusterId() {
        return this.clusterId;
    }

    @Generated
    public void setClusterId(Long clusterId) {
        this.clusterId = clusterId;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ClusterHostListSearchVO)) {
            return false;
        }
        ClusterHostListSearchVO other = (ClusterHostListSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$clusterId = this.getClusterId();
        Long other$clusterId = other.getClusterId();
        return !(this$clusterId == null ? other$clusterId != null : !((Object)this$clusterId).equals(other$clusterId));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ClusterHostListSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $clusterId = this.getClusterId();
        result = result * 59 + ($clusterId == null ? 43 : ((Object)$clusterId).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ClusterHostListSearchVO(clusterId=" + this.getClusterId() + ")";
    }
}

