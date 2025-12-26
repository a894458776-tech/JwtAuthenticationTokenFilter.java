/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.dataimpulse.entity.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kylin.kton.api.dataimpulse.constant.PoolType;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import lombok.Generated;

public class AsnsRequest
implements Serializable {
    @JsonProperty(value="pool_type")
    private PoolType poolType;
    private List<String> countries;
    private List<String> states;
    private List<String> zipcodes;
    private List<String> cities;
    @JsonProperty(value="order_by")
    private String orderBy = "name,asc";

    public String getPoolType() {
        if (Objects.nonNull((Object)this.poolType)) {
            return this.poolType.getCode();
        }
        return null;
    }

    @Generated
    public static AsnsRequestBuilder builder() {
        return new AsnsRequestBuilder();
    }

    @Generated
    public List<String> getCountries() {
        return this.countries;
    }

    @Generated
    public List<String> getStates() {
        return this.states;
    }

    @Generated
    public List<String> getZipcodes() {
        return this.zipcodes;
    }

    @Generated
    public List<String> getCities() {
        return this.cities;
    }

    @Generated
    public String getOrderBy() {
        return this.orderBy;
    }

    @JsonProperty(value="pool_type")
    @Generated
    public void setPoolType(PoolType poolType) {
        this.poolType = poolType;
    }

    @Generated
    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    @Generated
    public void setStates(List<String> states) {
        this.states = states;
    }

    @Generated
    public void setZipcodes(List<String> zipcodes) {
        this.zipcodes = zipcodes;
    }

    @Generated
    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    @JsonProperty(value="order_by")
    @Generated
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AsnsRequest)) {
            return false;
        }
        AsnsRequest other = (AsnsRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$poolType = this.getPoolType();
        String other$poolType = other.getPoolType();
        if (this$poolType == null ? other$poolType != null : !this$poolType.equals(other$poolType)) {
            return false;
        }
        List<String> this$countries = this.getCountries();
        List<String> other$countries = other.getCountries();
        if (this$countries == null ? other$countries != null : !((Object)this$countries).equals(other$countries)) {
            return false;
        }
        List<String> this$states = this.getStates();
        List<String> other$states = other.getStates();
        if (this$states == null ? other$states != null : !((Object)this$states).equals(other$states)) {
            return false;
        }
        List<String> this$zipcodes = this.getZipcodes();
        List<String> other$zipcodes = other.getZipcodes();
        if (this$zipcodes == null ? other$zipcodes != null : !((Object)this$zipcodes).equals(other$zipcodes)) {
            return false;
        }
        List<String> this$cities = this.getCities();
        List<String> other$cities = other.getCities();
        if (this$cities == null ? other$cities != null : !((Object)this$cities).equals(other$cities)) {
            return false;
        }
        String this$orderBy = this.getOrderBy();
        String other$orderBy = other.getOrderBy();
        return !(this$orderBy == null ? other$orderBy != null : !this$orderBy.equals(other$orderBy));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AsnsRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $poolType = this.getPoolType();
        result = result * 59 + ($poolType == null ? 43 : $poolType.hashCode());
        List<String> $countries = this.getCountries();
        result = result * 59 + ($countries == null ? 43 : ((Object)$countries).hashCode());
        List<String> $states = this.getStates();
        result = result * 59 + ($states == null ? 43 : ((Object)$states).hashCode());
        List<String> $zipcodes = this.getZipcodes();
        result = result * 59 + ($zipcodes == null ? 43 : ((Object)$zipcodes).hashCode());
        List<String> $cities = this.getCities();
        result = result * 59 + ($cities == null ? 43 : ((Object)$cities).hashCode());
        String $orderBy = this.getOrderBy();
        result = result * 59 + ($orderBy == null ? 43 : $orderBy.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AsnsRequest(poolType=" + this.getPoolType() + ", countries=" + this.getCountries() + ", states=" + this.getStates() + ", zipcodes=" + this.getZipcodes() + ", cities=" + this.getCities() + ", orderBy=" + this.getOrderBy() + ")";
    }

    @Generated
    public AsnsRequest(PoolType poolType, List<String> countries, List<String> states, List<String> zipcodes, List<String> cities, String orderBy) {
        this.poolType = poolType;
        this.countries = countries;
        this.states = states;
        this.zipcodes = zipcodes;
        this.cities = cities;
        this.orderBy = orderBy;
    }

    @Generated
    public AsnsRequest() {
    }

    @Generated
    public static class AsnsRequestBuilder {
        @Generated
        private PoolType poolType;
        @Generated
        private List<String> countries;
        @Generated
        private List<String> states;
        @Generated
        private List<String> zipcodes;
        @Generated
        private List<String> cities;
        @Generated
        private String orderBy;

        @Generated
        AsnsRequestBuilder() {
        }

        @JsonProperty(value="pool_type")
        @Generated
        public AsnsRequestBuilder poolType(PoolType poolType) {
            this.poolType = poolType;
            return this;
        }

        @Generated
        public AsnsRequestBuilder countries(List<String> countries) {
            this.countries = countries;
            return this;
        }

        @Generated
        public AsnsRequestBuilder states(List<String> states) {
            this.states = states;
            return this;
        }

        @Generated
        public AsnsRequestBuilder zipcodes(List<String> zipcodes) {
            this.zipcodes = zipcodes;
            return this;
        }

        @Generated
        public AsnsRequestBuilder cities(List<String> cities) {
            this.cities = cities;
            return this;
        }

        @JsonProperty(value="order_by")
        @Generated
        public AsnsRequestBuilder orderBy(String orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        @Generated
        public AsnsRequest build() {
            return new AsnsRequest(this.poolType, this.countries, this.states, this.zipcodes, this.cities, this.orderBy);
        }

        @Generated
        public String toString() {
            return "AsnsRequest.AsnsRequestBuilder(poolType=" + (Object)((Object)this.poolType) + ", countries=" + this.countries + ", states=" + this.states + ", zipcodes=" + this.zipcodes + ", cities=" + this.cities + ", orderBy=" + this.orderBy + ")";
        }
    }
}

