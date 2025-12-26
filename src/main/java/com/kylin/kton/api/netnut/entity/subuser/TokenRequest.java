/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import java.io.Serializable;
import lombok.Generated;

public class TokenRequest
implements Serializable {
    private String email;
    private String password;

    @Generated
    public static TokenRequestBuilder builder() {
        return new TokenRequestBuilder();
    }

    @Generated
    public String getEmail() {
        return this.email;
    }

    @Generated
    public String getPassword() {
        return this.password;
    }

    @Generated
    public void setEmail(String email) {
        this.email = email;
    }

    @Generated
    public void setPassword(String password) {
        this.password = password;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TokenRequest)) {
            return false;
        }
        TokenRequest other = (TokenRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$email = this.getEmail();
        String other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) {
            return false;
        }
        String this$password = this.getPassword();
        String other$password = other.getPassword();
        return !(this$password == null ? other$password != null : !this$password.equals(other$password));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof TokenRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $email = this.getEmail();
        result = result * 59 + ($email == null ? 43 : $email.hashCode());
        String $password = this.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "TokenRequest(email=" + this.getEmail() + ", password=" + this.getPassword() + ")";
    }

    @Generated
    public TokenRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Generated
    public TokenRequest() {
    }

    @Generated
    public static class TokenRequestBuilder {
        @Generated
        private String email;
        @Generated
        private String password;

        @Generated
        TokenRequestBuilder() {
        }

        @Generated
        public TokenRequestBuilder email(String email) {
            this.email = email;
            return this;
        }

        @Generated
        public TokenRequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        @Generated
        public TokenRequest build() {
            return new TokenRequest(this.email, this.password);
        }

        @Generated
        public String toString() {
            return "TokenRequest.TokenRequestBuilder(email=" + this.email + ", password=" + this.password + ")";
        }
    }
}

