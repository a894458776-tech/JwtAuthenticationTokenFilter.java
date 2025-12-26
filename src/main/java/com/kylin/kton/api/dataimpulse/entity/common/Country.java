/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.dataimpulse.entity.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Generated;

public class Country
implements Serializable {
    @JsonProperty(value="country_code")
    private String countryCode;
    @JsonProperty(value="country_name")
    private String countryName;

    @Generated
    public Country() {
    }

    @Generated
    public String getCountryCode() {
        return this.countryCode;
    }

    @Generated
    public String getCountryName() {
        return this.countryName;
    }

    @JsonProperty(value="country_code")
    @Generated
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty(value="country_name")
    @Generated
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Country)) {
            return false;
        }
        Country other = (Country)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$countryCode = this.getCountryCode();
        String other$countryCode = other.getCountryCode();
        if (this$countryCode == null ? other$countryCode != null : !this$countryCode.equals(other$countryCode)) {
            return false;
        }
        String this$countryName = this.getCountryName();
        String other$countryName = other.getCountryName();
        return !(this$countryName == null ? other$countryName != null : !this$countryName.equals(other$countryName));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof Country;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $countryCode = this.getCountryCode();
        result = result * 59 + ($countryCode == null ? 43 : $countryCode.hashCode());
        String $countryName = this.getCountryName();
        result = result * 59 + ($countryName == null ? 43 : $countryName.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "Country(countryCode=" + this.getCountryCode() + ", countryName=" + this.getCountryName() + ")";
    }
}

