/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  javax.validation.constraints.NotBlank
 *  javax.validation.constraints.Size
 *  lombok.Generated
 */
package com.kylin.kton.api.oxylabs.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Generated;

public class SubUserRequest {
    @NotBlank(message="Username is required")
    @Size(min=1, max=64, message="Username must be between 1 and 64 characters")
    private @NotBlank(message="Username is required") @Size(min=1, max=64, message="Username must be between 1 and 64 characters") String username;
    @NotBlank(message="Password is required")
    @Size(min=12, max=64, message="Password must be between 12 and 64 characters")
    private @NotBlank(message="Password is required") @Size(min=12, max=64, message="Password must be between 12 and 64 characters") String password;
    @JsonProperty(value="traffic_limit")
    private Double trafficLimit;
    private Boolean lifetime;
    @JsonProperty(value="auto_disable")
    private Boolean autoDisable;

    @Generated
    public SubUserRequest() {
    }

    @Generated
    public String getUsername() {
        return this.username;
    }

    @Generated
    public String getPassword() {
        return this.password;
    }

    @Generated
    public Double getTrafficLimit() {
        return this.trafficLimit;
    }

    @Generated
    public Boolean getLifetime() {
        return this.lifetime;
    }

    @Generated
    public Boolean getAutoDisable() {
        return this.autoDisable;
    }

    @Generated
    public void setUsername(String username) {
        this.username = username;
    }

    @Generated
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty(value="traffic_limit")
    @Generated
    public void setTrafficLimit(Double trafficLimit) {
        this.trafficLimit = trafficLimit;
    }

    @Generated
    public void setLifetime(Boolean lifetime) {
        this.lifetime = lifetime;
    }

    @JsonProperty(value="auto_disable")
    @Generated
    public void setAutoDisable(Boolean autoDisable) {
        this.autoDisable = autoDisable;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SubUserRequest)) {
            return false;
        }
        SubUserRequest other = (SubUserRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Double this$trafficLimit = this.getTrafficLimit();
        Double other$trafficLimit = other.getTrafficLimit();
        if (this$trafficLimit == null ? other$trafficLimit != null : !((Object)this$trafficLimit).equals(other$trafficLimit)) {
            return false;
        }
        Boolean this$lifetime = this.getLifetime();
        Boolean other$lifetime = other.getLifetime();
        if (this$lifetime == null ? other$lifetime != null : !((Object)this$lifetime).equals(other$lifetime)) {
            return false;
        }
        Boolean this$autoDisable = this.getAutoDisable();
        Boolean other$autoDisable = other.getAutoDisable();
        if (this$autoDisable == null ? other$autoDisable != null : !((Object)this$autoDisable).equals(other$autoDisable)) {
            return false;
        }
        String this$username = this.getUsername();
        String other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) {
            return false;
        }
        String this$password = this.getPassword();
        String other$password = other.getPassword();
        return !(this$password == null ? other$password != null : !this$password.equals(other$password));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof SubUserRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Double $trafficLimit = this.getTrafficLimit();
        result = result * 59 + ($trafficLimit == null ? 43 : ((Object)$trafficLimit).hashCode());
        Boolean $lifetime = this.getLifetime();
        result = result * 59 + ($lifetime == null ? 43 : ((Object)$lifetime).hashCode());
        Boolean $autoDisable = this.getAutoDisable();
        result = result * 59 + ($autoDisable == null ? 43 : ((Object)$autoDisable).hashCode());
        String $username = this.getUsername();
        result = result * 59 + ($username == null ? 43 : $username.hashCode());
        String $password = this.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "SubUserRequest(username=" + this.getUsername() + ", password=" + this.getPassword() + ", trafficLimit=" + this.getTrafficLimit() + ", lifetime=" + this.getLifetime() + ", autoDisable=" + this.getAutoDisable() + ")";
    }
}

