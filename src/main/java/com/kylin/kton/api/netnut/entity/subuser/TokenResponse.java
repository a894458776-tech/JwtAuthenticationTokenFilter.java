/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import java.io.Serializable;
import lombok.Generated;

public class TokenResponse
implements Serializable {
    private String token;

    @Generated
    public TokenResponse() {
    }

    @Generated
    public String getToken() {
        return this.token;
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
        if (!(o instanceof TokenResponse)) {
            return false;
        }
        TokenResponse other = (TokenResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$token = this.getToken();
        String other$token = other.getToken();
        return !(this$token == null ? other$token != null : !this$token.equals(other$token));
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
        return result;
    }

    @Generated
    public String toString() {
        return "TokenResponse(token=" + this.getToken() + ")";
    }
}

