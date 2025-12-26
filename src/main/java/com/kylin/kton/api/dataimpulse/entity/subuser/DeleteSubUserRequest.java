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

public class DeleteSubUserRequest
implements Serializable {
    @JsonProperty(value="subuser_id")
    private Long subuserId;

    @Generated
    public static DeleteSubUserRequestBuilder builder() {
        return new DeleteSubUserRequestBuilder();
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

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DeleteSubUserRequest)) {
            return false;
        }
        DeleteSubUserRequest other = (DeleteSubUserRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$subuserId = this.getSubuserId();
        Long other$subuserId = other.getSubuserId();
        return !(this$subuserId == null ? other$subuserId != null : !((Object)this$subuserId).equals(other$subuserId));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof DeleteSubUserRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $subuserId = this.getSubuserId();
        result = result * 59 + ($subuserId == null ? 43 : ((Object)$subuserId).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "DeleteSubUserRequest(subuserId=" + this.getSubuserId() + ")";
    }

    @Generated
    public DeleteSubUserRequest(Long subuserId) {
        this.subuserId = subuserId;
    }

    @Generated
    public DeleteSubUserRequest() {
    }

    @Generated
    public static class DeleteSubUserRequestBuilder {
        @Generated
        private Long subuserId;

        @Generated
        DeleteSubUserRequestBuilder() {
        }

        @JsonProperty(value="subuser_id")
        @Generated
        public DeleteSubUserRequestBuilder subuserId(Long subuserId) {
            this.subuserId = subuserId;
            return this;
        }

        @Generated
        public DeleteSubUserRequest build() {
            return new DeleteSubUserRequest(this.subuserId);
        }

        @Generated
        public String toString() {
            return "DeleteSubUserRequest.DeleteSubUserRequestBuilder(subuserId=" + this.subuserId + ")";
        }
    }
}

