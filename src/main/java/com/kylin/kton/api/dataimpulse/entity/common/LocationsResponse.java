/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.dataimpulse.entity.common;

import com.kylin.kton.api.dataimpulse.entity.common.Country;
import java.io.Serializable;
import java.util.List;
import lombok.Generated;

public class LocationsResponse
implements Serializable {
    private List<Country> countries;

    @Generated
    public static LocationsResponseBuilder builder() {
        return new LocationsResponseBuilder();
    }

    @Generated
    public List<Country> getCountries() {
        return this.countries;
    }

    @Generated
    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LocationsResponse)) {
            return false;
        }
        LocationsResponse other = (LocationsResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        List<Country> this$countries = this.getCountries();
        List<Country> other$countries = other.getCountries();
        return !(this$countries == null ? other$countries != null : !((Object)this$countries).equals(other$countries));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof LocationsResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        List<Country> $countries = this.getCountries();
        result = result * 59 + ($countries == null ? 43 : ((Object)$countries).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "LocationsResponse(countries=" + this.getCountries() + ")";
    }

    @Generated
    public LocationsResponse() {
    }

    @Generated
    public LocationsResponse(List<Country> countries) {
        this.countries = countries;
    }

    @Generated
    public static class LocationsResponseBuilder {
        @Generated
        private List<Country> countries;

        @Generated
        LocationsResponseBuilder() {
        }

        @Generated
        public LocationsResponseBuilder countries(List<Country> countries) {
            this.countries = countries;
            return this;
        }

        @Generated
        public LocationsResponse build() {
            return new LocationsResponse(this.countries);
        }

        @Generated
        public String toString() {
            return "LocationsResponse.LocationsResponseBuilder(countries=" + this.countries + ")";
        }
    }
}

