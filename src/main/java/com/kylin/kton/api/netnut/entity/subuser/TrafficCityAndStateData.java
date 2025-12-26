/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

public class TrafficCityAndStateData {
    @JsonProperty(value="region")
    private String region;
    @JsonProperty(value="city")
    private String city;

    @Generated
    public TrafficCityAndStateData() {
    }

    @Generated
    public String getRegion() {
        return this.region;
    }

    @Generated
    public String getCity() {
        return this.city;
    }

    @JsonProperty(value="region")
    @Generated
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty(value="city")
    @Generated
    public void setCity(String city) {
        this.city = city;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TrafficCityAndStateData)) {
            return false;
        }
        TrafficCityAndStateData other = (TrafficCityAndStateData)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$region = this.getRegion();
        String other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
            return false;
        }
        String this$city = this.getCity();
        String other$city = other.getCity();
        return !(this$city == null ? other$city != null : !this$city.equals(other$city));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof TrafficCityAndStateData;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $region = this.getRegion();
        result = result * 59 + ($region == null ? 43 : $region.hashCode());
        String $city = this.getCity();
        result = result * 59 + ($city == null ? 43 : $city.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "TrafficCityAndStateData(region=" + this.getRegion() + ", city=" + this.getCity() + ")";
    }
}

