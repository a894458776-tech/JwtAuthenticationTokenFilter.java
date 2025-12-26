/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.springframework.boot.context.properties.ConfigurationProperties
 *  org.springframework.context.annotation.Configuration
 */
package com.kylin.kton.api.dataimpulse.properties;

import java.io.Serializable;
import lombok.Generated;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="api.dataimpulse")
public class DataimpulseProperties
implements Serializable {
    private String account = "a894458776@gmail.com";
    private String password = "3Fq2Y08eAYggke09izQXeUt7tO6hSNGq";
    private String apiHost = "https://api.dataimpulse.com";

    @Generated
    public DataimpulseProperties() {
    }

    @Generated
    public String getAccount() {
        return this.account;
    }

    @Generated
    public String getPassword() {
        return this.password;
    }

    @Generated
    public String getApiHost() {
        return this.apiHost;
    }

    @Generated
    public void setAccount(String account) {
        this.account = account;
    }

    @Generated
    public void setPassword(String password) {
        this.password = password;
    }

    @Generated
    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DataimpulseProperties)) {
            return false;
        }
        DataimpulseProperties other = (DataimpulseProperties)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$account = this.getAccount();
        String other$account = other.getAccount();
        if (this$account == null ? other$account != null : !this$account.equals(other$account)) {
            return false;
        }
        String this$password = this.getPassword();
        String other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) {
            return false;
        }
        String this$apiHost = this.getApiHost();
        String other$apiHost = other.getApiHost();
        return !(this$apiHost == null ? other$apiHost != null : !this$apiHost.equals(other$apiHost));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof DataimpulseProperties;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $account = this.getAccount();
        result = result * 59 + ($account == null ? 43 : $account.hashCode());
        String $password = this.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        String $apiHost = this.getApiHost();
        result = result * 59 + ($apiHost == null ? 43 : $apiHost.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "DataimpulseProperties(account=" + this.getAccount() + ", password=" + this.getPassword() + ", apiHost=" + this.getApiHost() + ")";
    }
}

