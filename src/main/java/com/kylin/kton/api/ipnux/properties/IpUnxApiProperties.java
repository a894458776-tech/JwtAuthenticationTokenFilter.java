/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.springframework.boot.context.properties.ConfigurationProperties
 *  org.springframework.context.annotation.Configuration
 */
package com.kylin.kton.api.ipnux.properties;

import java.io.Serializable;
import lombok.Generated;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="api.ipnux")
public class IpUnxApiProperties
implements Serializable {
    private String baseUrl = "https://api.ipnux.com";
    private String userId = "1866825255666978816";
    private String token = "836383d7d798439db895fe3ce54d7fab";

    @Generated
    public IpUnxApiProperties() {
    }

    @Generated
    public String getBaseUrl() {
        return this.baseUrl;
    }

    @Generated
    public String getUserId() {
        return this.userId;
    }

    @Generated
    public String getToken() {
        return this.token;
    }

    @Generated
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Generated
    public void setUserId(String userId) {
        this.userId = userId;
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
        if (!(o instanceof IpUnxApiProperties)) {
            return false;
        }
        IpUnxApiProperties other = (IpUnxApiProperties)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$baseUrl = this.getBaseUrl();
        String other$baseUrl = other.getBaseUrl();
        if (this$baseUrl == null ? other$baseUrl != null : !this$baseUrl.equals(other$baseUrl)) {
            return false;
        }
        String this$userId = this.getUserId();
        String other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) {
            return false;
        }
        String this$token = this.getToken();
        String other$token = other.getToken();
        return !(this$token == null ? other$token != null : !this$token.equals(other$token));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof IpUnxApiProperties;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $baseUrl = this.getBaseUrl();
        result = result * 59 + ($baseUrl == null ? 43 : $baseUrl.hashCode());
        String $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        String $token = this.getToken();
        result = result * 59 + ($token == null ? 43 : $token.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "IpUnxApiProperties(baseUrl=" + this.getBaseUrl() + ", userId=" + this.getUserId() + ", token=" + this.getToken() + ")";
    }
}

