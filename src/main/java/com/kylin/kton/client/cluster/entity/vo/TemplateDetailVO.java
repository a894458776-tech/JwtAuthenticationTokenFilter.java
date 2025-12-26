/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.validation.constraints.NotNull
 *  lombok.Generated
 */
package com.kylin.kton.client.cluster.entity.vo;

import javax.validation.constraints.NotNull;
import lombok.Generated;

public class TemplateDetailVO {
    @NotNull(message="\u6a21\u677fID\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="\u6a21\u677fID\u4e0d\u80fd\u4e3a\u7a7a") String hostTemplateId;

    @Generated
    public TemplateDetailVO() {
    }

    @Generated
    public String getHostTemplateId() {
        return this.hostTemplateId;
    }

    @Generated
    public void setHostTemplateId(String hostTemplateId) {
        this.hostTemplateId = hostTemplateId;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TemplateDetailVO)) {
            return false;
        }
        TemplateDetailVO other = (TemplateDetailVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$hostTemplateId = this.getHostTemplateId();
        String other$hostTemplateId = other.getHostTemplateId();
        return !(this$hostTemplateId == null ? other$hostTemplateId != null : !this$hostTemplateId.equals(other$hostTemplateId));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof TemplateDetailVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $hostTemplateId = this.getHostTemplateId();
        result = result * 59 + ($hostTemplateId == null ? 43 : $hostTemplateId.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "TemplateDetailVO(hostTemplateId=" + this.getHostTemplateId() + ")";
    }
}

