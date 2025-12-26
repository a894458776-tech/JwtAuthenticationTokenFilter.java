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

public class SetLocationsAsnsRequset
implements Serializable {
    @JsonProperty(value="pool_type")
    private String poolType;
    private List<String> countries;
    private List<String> asns;
    @JsonProperty(value="order_by")
    private String orderBy;

    @Generated
    public static SetLocationsAsnsRequsetBuilder builder() {
        return new SetLocationsAsnsRequsetBuilder();
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
    public List<String> getAsns() {
        return this.asns;
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
    public void setAsns(List<String> asns) {
        this.asns = asns;
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
        if (!(o instanceof SetLocationsAsnsRequset)) {
            return false;
        }
        SetLocationsAsnsRequset other = (SetLocationsAsnsRequset)o;
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
        List<String> this$asns = this.getAsns();
        List<String> other$asns = other.getAsns();
        if (this$asns == null ? other$asns != null : !((Object)this$asns).equals(other$asns)) {
            return false;
        }
        String this$orderBy = this.getOrderBy();
        String other$orderBy = other.getOrderBy();
        return !(this$orderBy == null ? other$orderBy != null : !this$orderBy.equals(other$orderBy));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof SetLocationsAsnsRequset;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $poolType = this.getPoolType();
        result = result * 59 + ($poolType == null ? 43 : $poolType.hashCode());
        List<String> $countries = this.getCountries();
        result = result * 59 + ($countries == null ? 43 : ((Object)$countries).hashCode());
        List<String> $asns = this.getAsns();
        result = result * 59 + ($asns == null ? 43 : ((Object)$asns).hashCode());
        String $orderBy = this.getOrderBy();
        result = result * 59 + ($orderBy == null ? 43 : $orderBy.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "SetLocationsAsnsRequset(poolType=" + this.getPoolType() + ", countries=" + this.getCountries() + ", asns=" + this.getAsns() + ", orderBy=" + this.getOrderBy() + ")";
    }

    @Generated
    public SetLocationsAsnsRequset() {
    }

    @Generated
    public SetLocationsAsnsRequset(String poolType, List<String> countries, List<String> asns, String orderBy) {
        this.poolType = poolType;
        this.countries = countries;
        this.asns = asns;
        this.orderBy = orderBy;
    }

    @Generated
    public static class SetLocationsAsnsRequsetBuilder {
        @Generated
        private String poolType;
        @Generated
        private List<String> countries;
        @Generated
        private List<String> asns;
        @Generated
        private String orderBy;

        @Generated
        SetLocationsAsnsRequsetBuilder() {
        }

        @JsonProperty(value="pool_type")
        @Generated
        public SetLocationsAsnsRequsetBuilder poolType(String poolType) {
            this.poolType = poolType;
            return this;
        }

        @Generated
        public SetLocationsAsnsRequsetBuilder countries(List<String> countries) {
            this.countries = countries;
            return this;
        }

        @Generated
        public SetLocationsAsnsRequsetBuilder asns(List<String> asns) {
            this.asns = asns;
            return this;
        }

        @JsonProperty(value="order_by")
        @Generated
        public SetLocationsAsnsRequsetBuilder orderBy(String orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        @Generated
        public SetLocationsAsnsRequset build() {
            return new SetLocationsAsnsRequset(this.poolType, this.countries, this.asns, this.orderBy);
        }

        @Generated
        public String toString() {
            return "SetLocationsAsnsRequset.SetLocationsAsnsRequsetBuilder(poolType=" + this.poolType + ", countries=" + this.countries + ", asns=" + this.asns + ", orderBy=" + this.orderBy + ")";
        }
    }
}

