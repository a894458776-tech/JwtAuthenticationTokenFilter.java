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

public class TrafficAvailableCountriesData {
    @JsonProperty(value="region")
    private String region;
    @JsonProperty(value="isp_percent")
    private int ispPercent;
    @JsonProperty(value="top_percent")
    private int topPercent;

    @Generated
    public TrafficAvailableCountriesData() {
    }

    @Generated
    public String getRegion() {
        return this.region;
    }

    @Generated
    public int getIspPercent() {
        return this.ispPercent;
    }

    @Generated
    public int getTopPercent() {
        return this.topPercent;
    }

    @JsonProperty(value="region")
    @Generated
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty(value="isp_percent")
    @Generated
    public void setIspPercent(int ispPercent) {
        this.ispPercent = ispPercent;
    }

    @JsonProperty(value="top_percent")
    @Generated
    public void setTopPercent(int topPercent) {
        this.topPercent = topPercent;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TrafficAvailableCountriesData)) {
            return false;
        }
        TrafficAvailableCountriesData other = (TrafficAvailableCountriesData)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getIspPercent() != other.getIspPercent()) {
            return false;
        }
        if (this.getTopPercent() != other.getTopPercent()) {
            return false;
        }
        String this$region = this.getRegion();
        String other$region = other.getRegion();
        return !(this$region == null ? other$region != null : !this$region.equals(other$region));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof TrafficAvailableCountriesData;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getIspPercent();
        result = result * 59 + this.getTopPercent();
        String $region = this.getRegion();
        result = result * 59 + ($region == null ? 43 : $region.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "TrafficAvailableCountriesData(region=" + this.getRegion() + ", ispPercent=" + this.getIspPercent() + ", topPercent=" + this.getTopPercent() + ")";
    }
}

