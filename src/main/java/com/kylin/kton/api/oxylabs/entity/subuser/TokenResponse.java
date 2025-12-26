/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.oxylabs.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Generated;

public class TokenResponse
implements Serializable {
    private String token;
    @JsonProperty(value="user_id")
    private String userId;

    @Generated
    public TokenResponse() {
    }

    @Generated
    public String getToken() {
        return this.token;
    }

    @Generated
    public String getUserId() {
        return this.userId;
    }

    @Generated
    public void setToken(String token) {
        this.token = token;
    }

    @JsonProperty(value="user_id")
    @Generated
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TokenResponse)) {
            return false;
        }
        TokenResponse other = (TokenResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$token = this.getToken();
        String other$token = other.getToken();
        if (this$token == null ? other$token != null : !this$token.equals(other$token)) {
            return false;
        }
        String this$userId = this.getUserId();
        String other$userId = other.getUserId();
        return !(this$userId == null ? other$userId != null : !this$userId.equals(other$userId));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof TokenResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $token = this.getToken();
        result = result * 59 + ($token == null ? 43 : $token.hashCode());
        String $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "TokenResponse(token=" + this.getToken() + ", userId=" + this.getUserId() + ")";
    }
}

