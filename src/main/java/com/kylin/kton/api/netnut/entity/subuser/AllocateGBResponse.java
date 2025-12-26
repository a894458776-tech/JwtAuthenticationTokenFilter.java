/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import lombok.Generated;

public class AllocateGBResponse {
    private Boolean success;
    private String token;

    @Generated
    public AllocateGBResponse() {
    }

    @Generated
    public Boolean getSuccess() {
        return this.success;
    }

    @Generated
    public String getToken() {
        return this.token;
    }

    @Generated
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Generated
    public void setToken(String token) {
        this.token = token;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AllocateGBResponse)) {
            return false;
        }
        AllocateGBResponse other = (AllocateGBResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Boolean this$success = this.getSuccess();
        Boolean other$success = other.getSuccess();
        if (this$success == null ? other$success != null : !((Object)this$success).equals(other$success)) {
            return false;
        }
        String this$token = this.getToken();
        String other$token = other.getToken();
        return !(this$token == null ? other$token != null : !this$token.equals(other$token));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AllocateGBResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Boolean $success = this.getSuccess();
        result = result * 59 + ($success == null ? 43 : ((Object)$success).hashCode());
        String $token = this.getToken();
        result = result * 59 + ($token == null ? 43 : $token.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AllocateGBResponse(success=" + this.getSuccess() + ", token=" + this.getToken() + ")";
    }
}

