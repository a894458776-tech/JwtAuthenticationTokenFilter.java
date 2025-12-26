/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.dataimpulse.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Generated;

public class SetLocationsCitiesRequset
implements Serializable {
    @JsonProperty(value="pool_type")
    private String poolType;
    private List<String> countries;
    private List<String> cities;
    @JsonProperty(value="order_by")
    private String orderBy;

    @Generated
    public static SetLocationsCitiesRequsetBuilder builder() {
        return new SetLocationsCitiesRequsetBuilder();
    }

    @Generated
    public String getPoolType() {
        return this.poolType;
    }

    @Generated
    public List<String> getCountries() {
        return this.countries;
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
    public void setPoolType(String poolType) {
        this.poolType = poolType;
    }

    @Generated
    public void setCountries(List<String> countries) {
        this.countries = countries;
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
        if (!(o instanceof SetLocationsCitiesRequset)) {
            return false;
        }
        SetLocationsCitiesRequset other = (SetLocationsCitiesRequset)o;
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
        return other instanceof SetLocationsCitiesRequset;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $poolType = this.getPoolType();
        result = result * 59 + ($poolType == null ? 43 : $poolType.hashCode());
        List<String> $countries = this.getCountries();
        result = result * 59 + ($countries == null ? 43 : ((Object)$countries).hashCode());
        List<String> $cities = this.getCities();
        result = result * 59 + ($cities == null ? 43 : ((Object)$cities).hashCode());
        String $orderBy = this.getOrderBy();
        result = result * 59 + ($orderBy == null ? 43 : $orderBy.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "SetLocationsCitiesRequset(poolType=" + this.getPoolType() + ", countries=" + this.getCountries() + ", cities=" + this.getCities() + ", orderBy=" + this.getOrderBy() + ")";
    }

    @Generated
    public SetLocationsCitiesRequset() {
    }

    @Generated
    public SetLocationsCitiesRequset(String poolType, List<String> countries, List<String> cities, String orderBy) {
        this.poolType = poolType;
        this.countries = countries;
        this.cities = cities;
        this.orderBy = orderBy;
    }

    @Generated
    public static class SetLocationsCitiesRequsetBuilder {
        @Generated
        private String poolType;
        @Generated
        private List<String> countries;
        @Generated
        private List<String> cities;
        @Generated
        private String orderBy;

        @Generated
        SetLocationsCitiesRequsetBuilder() {
        }

        @JsonProperty(value="pool_type")
        @Generated
        public SetLocationsCitiesRequsetBuilder poolType(String poolType) {
            this.poolType = poolType;
            return this;
        }

        @Generated
        public SetLocationsCitiesRequsetBuilder countries(List<String> countries) {
            this.countries = countries;
            return this;
        }

        @Generated
        public SetLocationsCitiesRequsetBuilder cities(List<String> cities) {
            this.cities = cities;
            return this;
        }

        @JsonProperty(value="order_by")
        @Generated
        public SetLocationsCitiesRequsetBuilder orderBy(String orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        @Generated
        public SetLocationsCitiesRequset build() {
            return new SetLocationsCitiesRequset(this.poolType, this.countries, this.cities, this.orderBy);
        }

        @Generated
        public String toString() {
            return "SetLocationsCitiesRequset.SetLocationsCitiesRequsetBuilder(poolType=" + this.poolType + ", countries=" + this.countries + ", cities=" + this.cities + ", orderBy=" + this.orderBy + ")";
        }
    }
}

