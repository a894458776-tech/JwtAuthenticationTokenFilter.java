/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  javax.validation.constraints.Size
 *  lombok.Generated
 */
package com.kylin.kton.api.oxylabs.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Size;
import lombok.Generated;

public class UpdateSubUserRequest {
    @Size(min=12, max=64, message="Password must be between 12 and 64 characters")
    private @Size(min=12, max=64, message="Password must be between 12 and 64 characters") String password;
    @JsonProperty(value="traffic_limit")
    private Double trafficLimit;
    @JsonProperty(value="lifetime")
    private Boolean lifetime;
    private String status;
    @JsonProperty(value="auto_disable")
    private Boolean autoDisable;

    @Generated
    public UpdateSubUserRequest() {
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
    public String getStatus() {
        return this.status;
    }

    @Generated
    public Boolean getAutoDisable() {
        return this.autoDisable;
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

    @JsonProperty(value="lifetime")
    @Generated
    public void setLifetime(Boolean lifetime) {
        this.lifetime = lifetime;
    }

    @Generated
    public void setStatus(String status) {
        this.status = status;
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
        if (!(o instanceof UpdateSubUserRequest)) {
            return false;
        }
        UpdateSubUserRequest other = (UpdateSubUserRequest)o;
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
        String this$password = this.getPassword();
        String other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) {
            return false;
        }
        String this$status = this.getStatus();
        String other$status = other.getStatus();
        return !(this$status == null ? other$status != null : !this$status.equals(other$status));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof UpdateSubUserRequest;
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
        String $password = this.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        String $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "UpdateSubUserRequest(password=" + this.getPassword() + ", trafficLimit=" + this.getTrafficLimit() + ", lifetime=" + this.getLifetime() + ", status=" + this.getStatus() + ", autoDisable=" + this.getAutoDisable() + ")";
    }
}

