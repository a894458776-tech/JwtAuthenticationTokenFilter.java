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

public class SetBlockedRequest
implements Serializable {
    @JsonProperty(value="subuser_id")
    private Long subUserId;
    private Boolean blocked;

    @Generated
    public static SetBlockedRequestBuilder builder() {
        return new SetBlockedRequestBuilder();
    }

    @Generated
    public Long getSubUserId() {
        return this.subUserId;
    }

    @Generated
    public Boolean getBlocked() {
        return this.blocked;
    }

    @JsonProperty(value="subuser_id")
    @Generated
    public void setSubUserId(Long subUserId) {
        this.subUserId = subUserId;
    }

    @Generated
    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SetBlockedRequest)) {
            return false;
        }
        SetBlockedRequest other = (SetBlockedRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$subUserId = this.getSubUserId();
        Long other$subUserId = other.getSubUserId();
        if (this$subUserId == null ? other$subUserId != null : !((Object)this$subUserId).equals(other$subUserId)) {
            return false;
        }
        Boolean this$blocked = this.getBlocked();
        Boolean other$blocked = other.getBlocked();
        return !(this$blocked == null ? other$blocked != null : !((Object)this$blocked).equals(other$blocked));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof SetBlockedRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $subUserId = this.getSubUserId();
        result = result * 59 + ($subUserId == null ? 43 : ((Object)$subUserId).hashCode());
        Boolean $blocked = this.getBlocked();
        result = result * 59 + ($blocked == null ? 43 : ((Object)$blocked).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "SetBlockedRequest(subUserId=" + this.getSubUserId() + ", blocked=" + this.getBlocked() + ")";
    }

    @Generated
    public SetBlockedRequest() {
    }

    @Generated
    public SetBlockedRequest(Long subUserId, Boolean blocked) {
        this.subUserId = subUserId;
        this.blocked = blocked;
    }

    @Generated
    public static class SetBlockedRequestBuilder {
        @Generated
        private Long subUserId;
        @Generated
        private Boolean blocked;

        @Generated
        SetBlockedRequestBuilder() {
        }

        @JsonProperty(value="subuser_id")
        @Generated
        public SetBlockedRequestBuilder subUserId(Long subUserId) {
            this.subUserId = subUserId;
            return this;
        }

        @Generated
        public SetBlockedRequestBuilder blocked(Boolean blocked) {
            this.blocked = blocked;
            return this;
        }

        @Generated
        public SetBlockedRequest build() {
            return new SetBlockedRequest(this.subUserId, this.blocked);
        }

        @Generated
        public String toString() {
            return "SetBlockedRequest.SetBlockedRequestBuilder(subUserId=" + this.subUserId + ", blocked=" + this.blocked + ")";
        }
    }
}

