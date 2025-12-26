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

public class CountryResponse
implements Serializable {
    private List<Item> countries;

    @Generated
    public static CountryResponseBuilder builder() {
        return new CountryResponseBuilder();
    }

    @Generated
    public List<Item> getCountries() {
        return this.countries;
    }

    @Generated
    public void setCountries(List<Item> countries) {
        this.countries = countries;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CountryResponse)) {
            return false;
        }
        CountryResponse other = (CountryResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        List<Item> this$countries = this.getCountries();
        List<Item> other$countries = other.getCountries();
        return !(this$countries == null ? other$countries != null : !((Object)this$countries).equals(other$countries));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof CountryResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        List<Item> $countries = this.getCountries();
        result = result * 59 + ($countries == null ? 43 : ((Object)$countries).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "CountryResponse(countries=" + this.getCountries() + ")";
    }

    @Generated
    public CountryResponse(List<Item> countries) {
        this.countries = countries;
    }

    @Generated
    public CountryResponse() {
    }

    @Generated
    public static class CountryResponseBuilder {
        @Generated
        private List<Item> countries;

        @Generated
        CountryResponseBuilder() {
        }

        @Generated
        public CountryResponseBuilder countries(List<Item> countries) {
            this.countries = countries;
            return this;
        }

        @Generated
        public CountryResponse build() {
            return new CountryResponse(this.countries);
        }

        @Generated
        public String toString() {
            return "CountryResponse.CountryResponseBuilder(countries=" + this.countries + ")";
        }
    }
}

