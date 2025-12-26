/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.vps.entity.vo;

import lombok.Generated;

public class ContaineDetailVO {
    public Long containerId;

    @Generated
    public ContaineDetailVO() {
    }

    @Generated
    public Long getContainerId() {
        return this.containerId;
    }

    @Generated
    public void setContainerId(Long containerId) {
        this.containerId = containerId;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ContaineDetailVO)) {
            return false;
        }
        ContaineDetailVO other = (ContaineDetailVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$containerId = this.getContainerId();
        Long other$containerId = other.getContainerId();
        return !(this$containerId == null ? other$containerId != null : !((Object)this$containerId).equals(other$containerId));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ContaineDetailVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $containerId = this.getContainerId();
        result = result * 59 + ($containerId == null ? 43 : ((Object)$containerId).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ContaineDetailVO(containerId=" + this.getContainerId() + ")";
    }
}

