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
import java.util.Objects;
import lombok.Generated;

public class SetAllowedIpResponse
implements Serializable {
    private String message;
    @JsonProperty(value="status_code")
    private Integer statusCode;

    public Boolean isSuccess() {
        return Objects.equals(this.statusCode, 400);
    }

    @Generated
    public SetAllowedIpResponse() {
    }

    @Generated
    public String getMessage() {
        return this.message;
    }

    @Generated
    public Integer getStatusCode() {
        return this.statusCode;
    }

    @Generated
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty(value="status_code")
    @Generated
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SetAllowedIpResponse)) {
            return false;
        }
        SetAllowedIpResponse other = (SetAllowedIpResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Integer this$statusCode = this.getStatusCode();
        Integer other$statusCode = other.getStatusCode();
        if (this$statusCode == null ? other$statusCode != null : !((Object)this$statusCode).equals(other$statusCode)) {
            return false;
        }
        String this$message = this.getMessage();
        String other$message = other.getMessage();
        return !(this$message == null ? other$message != null : !this$message.equals(other$message));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof SetAllowedIpResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $statusCode = this.getStatusCode();
        result = result * 59 + ($statusCode == null ? 43 : ((Object)$statusCode).hashCode());
        String $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "SetAllowedIpResponse(message=" + this.getMessage() + ", statusCode=" + this.getStatusCode() + ")";
    }
}

