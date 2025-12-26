/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.dataimpulse.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Generated;

public class ResetPwdRequest
implements Serializable {
    @JsonProperty(value="subuser_id")
    private Long subUserId;

    @Generated
    public static ResetPwdRequestBuilder builder() {
        return new ResetPwdRequestBuilder();
    }

    @Generated
    public Long getSubUserId() {
        return this.subUserId;
    }

    @JsonProperty(value="subuser_id")
    @Generated
    public void setSubUserId(Long subUserId) {
        this.subUserId = subUserId;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ResetPwdRequest)) {
            return false;
        }
        ResetPwdRequest other = (ResetPwdRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$subUserId = this.getSubUserId();
        Long other$subUserId = other.getSubUserId();
        return !(this$subUserId == null ? other$subUserId != null : !((Object)this$subUserId).equals(other$subUserId));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ResetPwdRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $subUserId = this.getSubUserId();
        result = result * 59 + ($subUserId == null ? 43 : ((Object)$subUserId).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ResetPwdRequest(subUserId=" + this.getSubUserId() + ")";
    }

    @Generated
    public ResetPwdRequest() {
    }

    @Generated
    public ResetPwdRequest(Long subUserId) {
        this.subUserId = subUserId;
    }

    @Generated
    public static class ResetPwdRequestBuilder {
        @Generated
        private Long subUserId;

        @Generated
        ResetPwdRequestBuilder() {
        }

        @JsonProperty(value="subuser_id")
        @Generated
        public ResetPwdRequestBuilder subUserId(Long subUserId) {
            this.subUserId = subUserId;
            return this;
        }

        @Generated
        public ResetPwdRequest build() {
            return new ResetPwdRequest(this.subUserId);
        }

        @Generated
        public String toString() {
            return "ResetPwdRequest.ResetPwdRequestBuilder(subUserId=" + this.subUserId + ")";
        }
    }
}

