/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.oxylabs.entity.subuser;

import java.io.Serializable;
import lombok.Generated;

public class TokenRequest
implements Serializable {
    private String login;
    private String password;

    @Generated
    public static TokenRequestBuilder builder() {
        return new TokenRequestBuilder();
    }

    @Generated
    public String getLogin() {
        return this.login;
    }

    @Generated
    public String getPassword() {
        return this.password;
    }

    @Generated
    public void setLogin(String login) {
        this.login = login;
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
        String this$login = this.getLogin();
        String other$login = other.getLogin();
        if (this$login == null ? other$login != null : !this$login.equals(other$login)) {
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
        String $login = this.getLogin();
        result = result * 59 + ($login == null ? 43 : $login.hashCode());
        String $password = this.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "TokenRequest(login=" + this.getLogin() + ", password=" + this.getPassword() + ")";
    }

    @Generated
    public TokenRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Generated
    public TokenRequest() {
    }

    @Generated
    public static class TokenRequestBuilder {
        @Generated
        private String login;
        @Generated
        private String password;

        @Generated
        TokenRequestBuilder() {
        }

        @Generated
        public TokenRequestBuilder login(String login) {
            this.login = login;
            return this;
        }

        @Generated
        public TokenRequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        @Generated
        public TokenRequest build() {
            return new TokenRequest(this.login, this.password);
        }

        @Generated
        public String toString() {
            return "TokenRequest.TokenRequestBuilder(login=" + this.login + ", password=" + this.password + ")";
        }
    }
}

