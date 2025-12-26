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

public class SetLocationsStatesRequset
implements Serializable {
    @JsonProperty(value="pool_type")
    private String poolType;
    private List<String> countries;
    private List<String> states;
    @JsonProperty(value="order_by")
    private String orderBy;

    @Generated
    public static SetLocationsStatesRequsetBuilder builder() {
        return new SetLocationsStatesRequsetBuilder();
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
    public List<String> getStates() {
        return this.states;
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
    public void setStates(List<String> states) {
        this.states = states;
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
        if (!(o instanceof SetLocationsStatesRequset)) {
            return false;
        }
        SetLocationsStatesRequset other = (SetLocationsStatesRequset)o;
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
        String this$orderBy = this.getOrderBy();
        String other$orderBy = other.getOrderBy();
        return !(this$orderBy == null ? other$orderBy != null : !this$orderBy.equals(other$orderBy));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof SetLocationsStatesRequset;
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
        String $orderBy = this.getOrderBy();
        result = result * 59 + ($orderBy == null ? 43 : $orderBy.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "SetLocationsStatesRequset(poolType=" + this.getPoolType() + ", countries=" + this.getCountries() + ", states=" + this.getStates() + ", orderBy=" + this.getOrderBy() + ")";
    }

    @Generated
    public SetLocationsStatesRequset() {
    }

    @Generated
    public SetLocationsStatesRequset(String poolType, List<String> countries, List<String> states, String orderBy) {
        this.poolType = poolType;
        this.countries = countries;
        this.states = states;
        this.orderBy = orderBy;
    }

    @Generated
    public static class SetLocationsStatesRequsetBuilder {
        @Generated
        private String poolType;
        @Generated
        private List<String> countries;
        @Generated
        private List<String> states;
        @Generated
        private String orderBy;

        @Generated
        SetLocationsStatesRequsetBuilder() {
        }

        @JsonProperty(value="pool_type")
        @Generated
        public SetLocationsStatesRequsetBuilder poolType(String poolType) {
            this.poolType = poolType;
            return this;
        }

        @Generated
        public SetLocationsStatesRequsetBuilder countries(List<String> countries) {
            this.countries = countries;
            return this;
        }

        @Generated
        public SetLocationsStatesRequsetBuilder states(List<String> states) {
            this.states = states;
            return this;
        }

        @JsonProperty(value="order_by")
        @Generated
        public SetLocationsStatesRequsetBuilder orderBy(String orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        @Generated
        public SetLocationsStatesRequset build() {
            return new SetLocationsStatesRequset(this.poolType, this.countries, this.states, this.orderBy);
        }

        @Generated
        public String toString() {
            return "SetLocationsStatesRequset.SetLocationsStatesRequsetBuilder(poolType=" + this.poolType + ", countries=" + this.countries + ", states=" + this.states + ", orderBy=" + this.orderBy + ")";
        }
    }
}

