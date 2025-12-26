/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.springframework.context.annotation.Configuration
 */
package com.kylin.kton.api.ipidea.properties;

import java.io.Serializable;
import lombok.Generated;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IpIdeaApiProperties
implements Serializable {
    private String baseUrl = "https://api.ipidea.net";
    private String appkey1 = "5fdba6ccd86fc10320f6b78dcbbc7fea";
    private String appkey2 = "f974c0e09ae7796bcec4b6493ba94a2c";
    private String account1 = "justinka";
    private String password1 = "34372766";
    private String account2 = "staticisp";
    private String password2 = "static123456";

    @Generated
    public IpIdeaApiProperties() {
    }

    @Generated
    public String getBaseUrl() {
        return this.baseUrl;
    }

    @Generated
    public String getAppkey1() {
        return this.appkey1;
    }

    @Generated
    public String getAppkey2() {
        return this.appkey2;
    }

    @Generated
    public String getAccount1() {
        return this.account1;
    }

    @Generated
    public String getPassword1() {
        return this.password1;
    }

    @Generated
    public String getAccount2() {
        return this.account2;
    }

    @Generated
    public String getPassword2() {
        return this.password2;
    }

    @Generated
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Generated
    public void setAppkey1(String appkey1) {
        this.appkey1 = appkey1;
    }

    @Generated
    public void setAppkey2(String appkey2) {
        this.appkey2 = appkey2;
    }

    @Generated
    public void setAccount1(String account1) {
        this.account1 = account1;
    }

    @Generated
    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    @Generated
    public void setAccount2(String account2) {
        this.account2 = account2;
    }

    @Generated
    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof IpIdeaApiProperties)) {
            return false;
        }
        IpIdeaApiProperties other = (IpIdeaApiProperties)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$baseUrl = this.getBaseUrl();
        String other$baseUrl = other.getBaseUrl();
        if (this$baseUrl == null ? other$baseUrl != null : !this$baseUrl.equals(other$baseUrl)) {
            return false;
        }
        String this$appkey1 = this.getAppkey1();
        String other$appkey1 = other.getAppkey1();
        if (this$appkey1 == null ? other$appkey1 != null : !this$appkey1.equals(other$appkey1)) {
            return false;
        }
        String this$appkey2 = this.getAppkey2();
        String other$appkey2 = other.getAppkey2();
        if (this$appkey2 == null ? other$appkey2 != null : !this$appkey2.equals(other$appkey2)) {
            return false;
        }
        String this$account1 = this.getAccount1();
        String other$account1 = other.getAccount1();
        if (this$account1 == null ? other$account1 != null : !this$account1.equals(other$account1)) {
            return false;
        }
        String this$password1 = this.getPassword1();
        String other$password1 = other.getPassword1();
        if (this$password1 == null ? other$password1 != null : !this$password1.equals(other$password1)) {
            return false;
        }
        String this$account2 = this.getAccount2();
        String other$account2 = other.getAccount2();
        if (this$account2 == null ? other$account2 != null : !this$account2.equals(other$account2)) {
            return false;
        }
        String this$password2 = this.getPassword2();
        String other$password2 = other.getPassword2();
        return !(this$password2 == null ? other$password2 != null : !this$password2.equals(other$password2));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof IpIdeaApiProperties;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $baseUrl = this.getBaseUrl();
        result = result * 59 + ($baseUrl == null ? 43 : $baseUrl.hashCode());
        String $appkey1 = this.getAppkey1();
        result = result * 59 + ($appkey1 == null ? 43 : $appkey1.hashCode());
        String $appkey2 = this.getAppkey2();
        result = result * 59 + ($appkey2 == null ? 43 : $appkey2.hashCode());
        String $account1 = this.getAccount1();
        result = result * 59 + ($account1 == null ? 43 : $account1.hashCode());
        String $password1 = this.getPassword1();
        result = result * 59 + ($password1 == null ? 43 : $password1.hashCode());
        String $account2 = this.getAccount2();
        result = result * 59 + ($account2 == null ? 43 : $account2.hashCode());
        String $password2 = this.getPassword2();
        result = result * 59 + ($password2 == null ? 43 : $password2.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "IpIdeaApiProperties(baseUrl=" + this.getBaseUrl() + ", appkey1=" + this.getAppkey1() + ", appkey2=" + this.getAppkey2() + ", account1=" + this.getAccount1() + ", password1=" + this.getPassword1() + ", account2=" + this.getAccount2() + ", password2=" + this.getPassword2() + ")";
    }
}

