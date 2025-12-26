/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import lombok.Generated;

public class DataUsageResponse {
    private boolean success;
    private String token;

    @Generated
    public DataUsageResponse() {
    }

    @Generated
    public boolean isSuccess() {
        return this.success;
    }

    @Generated
    public String getToken() {
        return this.token;
    }

    @Generated
    public void setSuccess(boolean success) {
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
        if (!(o instanceof DataUsageResponse)) {
            return false;
        }
        DataUsageResponse other = (DataUsageResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.isSuccess() != other.isSuccess()) {
            return false;
        }
        String this$token = this.getToken();
        String other$token = other.getToken();
        return !(this$token == null ? other$token != null : !this$token.equals(other$token));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof DataUsageResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isSuccess() ? 79 : 97);
        String $token = this.getToken();
        result = result * 59 + ($token == null ? 43 : $token.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "DataUsageResponse(success=" + this.isSuccess() + ", token=" + this.getToken() + ")";
    }
}

