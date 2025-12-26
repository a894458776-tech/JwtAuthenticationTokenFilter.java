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

public class DropSubUserBalanceRequest
implements Serializable {
    @JsonProperty(value="subuser_id")
    private Long subUserId;

    @Generated
    public static DropSubUserBalanceRequestBuilder builder() {
        return new DropSubUserBalanceRequestBuilder();
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
        if (!(o instanceof DropSubUserBalanceRequest)) {
            return false;
        }
        DropSubUserBalanceRequest other = (DropSubUserBalanceRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$subUserId = this.getSubUserId();
        Long other$subUserId = other.getSubUserId();
        return !(this$subUserId == null ? other$subUserId != null : !((Object)this$subUserId).equals(other$subUserId));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof DropSubUserBalanceRequest;
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
        return "DropSubUserBalanceRequest(subUserId=" + this.getSubUserId() + ")";
    }

    @Generated
    public DropSubUserBalanceRequest() {
    }

    @Generated
    public DropSubUserBalanceRequest(Long subUserId) {
        this.subUserId = subUserId;
    }

    @Generated
    public static class DropSubUserBalanceRequestBuilder {
        @Generated
        private Long subUserId;

        @Generated
        DropSubUserBalanceRequestBuilder() {
        }

        @JsonProperty(value="subuser_id")
        @Generated
        public DropSubUserBalanceRequestBuilder subUserId(Long subUserId) {
            this.subUserId = subUserId;
            return this;
        }

        @Generated
        public DropSubUserBalanceRequest build() {
            return new DropSubUserBalanceRequest(this.subUserId);
        }

        @Generated
        public String toString() {
            return "DropSubUserBalanceRequest.DropSubUserBalanceRequestBuilder(subUserId=" + this.subUserId + ")";
        }
    }
}

