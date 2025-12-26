/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.dataimpulse.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kylin.kton.api.dataimpulse.entity.subuser.SubUserInfo;
import java.io.Serializable;
import lombok.Generated;

public class UpdateSubUserRequest
extends SubUserInfo
implements Serializable {
    @JsonProperty(value="subuser_id")
    private Long subuserId;

    @Override
    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof UpdateSubUserRequest)) {
            return false;
        }
        UpdateSubUserRequest other = (UpdateSubUserRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Long this$subuserId = this.getSubuserId();
        Long other$subuserId = other.getSubuserId();
        return !(this$subuserId == null ? other$subuserId != null : !((Object)this$subuserId).equals(other$subuserId));
    }

    @Override
    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof UpdateSubUserRequest;
    }

    @Override
    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = super.hashCode();
        Long $subuserId = this.getSubuserId();
        result = result * 59 + ($subuserId == null ? 43 : ((Object)$subuserId).hashCode());
        return result;
    }

    @Generated
    public UpdateSubUserRequest() {
    }

    @Generated
    public Long getSubuserId() {
        return this.subuserId;
    }

    @JsonProperty(value="subuser_id")
    @Generated
    public void setSubuserId(Long subuserId) {
        this.subuserId = subuserId;
    }

    @Override
    @Generated
    public String toString() {
        return "UpdateSubUserRequest(subuserId=" + this.getSubuserId() + ")";
    }
}

