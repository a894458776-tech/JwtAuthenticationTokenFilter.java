/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.dataimpulse.entity.common;

import com.kylin.kton.api.dataimpulse.entity.common.Item;
import java.io.Serializable;
import java.util.List;
import lombok.Generated;

public class CitiesResponse
implements Serializable {
    private List<Item> cities;

    @Generated
    public static CitiesResponseBuilder builder() {
        return new CitiesResponseBuilder();
    }

    @Generated
    public List<Item> getCities() {
        return this.cities;
    }

    @Generated
    public void setCities(List<Item> cities) {
        this.cities = cities;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CitiesResponse)) {
            return false;
        }
        CitiesResponse other = (CitiesResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        List<Item> this$cities = this.getCities();
        List<Item> other$cities = other.getCities();
        return !(this$cities == null ? other$cities != null : !((Object)this$cities).equals(other$cities));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof CitiesResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        List<Item> $cities = this.getCities();
        result = result * 59 + ($cities == null ? 43 : ((Object)$cities).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "CitiesResponse(cities=" + this.getCities() + ")";
    }

    @Generated
    public CitiesResponse(List<Item> cities) {
        this.cities = cities;
    }

    @Generated
    public CitiesResponse() {
    }

    @Generated
    public static class CitiesResponseBuilder {
        @Generated
        private List<Item> cities;

        @Generated
        CitiesResponseBuilder() {
        }

        @Generated
        public CitiesResponseBuilder cities(List<Item> cities) {
            this.cities = cities;
            return this;
        }

        @Generated
        public CitiesResponse build() {
            return new CitiesResponse(this.cities);
        }

        @Generated
        public String toString() {
            return "CitiesResponse.CitiesResponseBuilder(cities=" + this.cities + ")";
        }
    }
}

