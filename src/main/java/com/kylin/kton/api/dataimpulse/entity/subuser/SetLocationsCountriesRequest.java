/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.dataimpulse.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kylin.kton.api.dataimpulse.entity.subuser.SubUserInfo;
import java.io.Serializable;
import lombok.Generated;

public class SetLocationsCountriesRequest
implements Serializable {
    @JsonProperty(value="subuser_id")
    private Long subUserId;
    @JsonProperty(value="default_pool_parameters")
    private SubUserInfo.DefaultPoolParameters defaultPoolParameters;

    @Generated
    public SetLocationsCountriesRequest() {
    }

    @Generated
    public Long getSubUserId() {
        return this.subUserId;
    }

    @Generated
    public SubUserInfo.DefaultPoolParameters getDefaultPoolParameters() {
        return this.defaultPoolParameters;
    }

    @JsonProperty(value="subuser_id")
    @Generated
    public void setSubUserId(Long subUserId) {
        this.subUserId = subUserId;
    }

    @JsonProperty(value="default_pool_parameters")
    @Generated
    public void setDefaultPoolParameters(SubUserInfo.DefaultPoolParameters defaultPoolParameters) {
        this.defaultPoolParameters = defaultPoolParameters;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SetLocationsCountriesRequest)) {
            return false;
        }
        SetLocationsCountriesRequest other = (SetLocationsCountriesRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$subUserId = this.getSubUserId();
        Long other$subUserId = other.getSubUserId();
        if (this$subUserId == null ? other$subUserId != null : !((Object)this$subUserId).equals(other$subUserId)) {
            return false;
        }
        SubUserInfo.DefaultPoolParameters this$defaultPoolParameters = this.getDefaultPoolParameters();
        SubUserInfo.DefaultPoolParameters other$defaultPoolParameters = other.getDefaultPoolParameters();
        return !(this$defaultPoolParameters == null ? other$defaultPoolParameters != null : !((Object)this$defaultPoolParameters).equals(other$defaultPoolParameters));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof SetLocationsCountriesRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $subUserId = this.getSubUserId();
        result = result * 59 + ($subUserId == null ? 43 : ((Object)$subUserId).hashCode());
        SubUserInfo.DefaultPoolParameters $defaultPoolParameters = this.getDefaultPoolParameters();
        result = result * 59 + ($defaultPoolParameters == null ? 43 : ((Object)$defaultPoolParameters).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "SetLocationsCountriesRequest(subUserId=" + this.getSubUserId() + ", defaultPoolParameters=" + this.getDefaultPoolParameters() + ")";
    }
}

