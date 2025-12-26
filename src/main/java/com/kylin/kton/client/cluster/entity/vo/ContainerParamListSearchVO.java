/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.cluster.entity.vo;

import lombok.Generated;

public class ContainerParamListSearchVO {
    private String containerId;

    @Generated
    public ContainerParamListSearchVO() {
    }

    @Generated
    public String getContainerId() {
        return this.containerId;
    }

    @Generated
    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ContainerParamListSearchVO)) {
            return false;
        }
        ContainerParamListSearchVO other = (ContainerParamListSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$containerId = this.getContainerId();
        String other$containerId = other.getContainerId();
        return !(this$containerId == null ? other$containerId != null : !this$containerId.equals(other$containerId));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ContainerParamListSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $containerId = this.getContainerId();
        result = result * 59 + ($containerId == null ? 43 : $containerId.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ContainerParamListSearchVO(containerId=" + this.getContainerId() + ")";
    }
}

