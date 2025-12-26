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

public class SetLocationsZipcodesRequset
implements Serializable {
    @JsonProperty(value="pool_type")
    private String poolType;
    private List<String> countries;
    private List<String> zipcodes;
    @JsonProperty(value="order_by")
    private String orderBy;

    @Generated
    public static SetLocationsZipcodesRequsetBuilder builder() {
        return new SetLocationsZipcodesRequsetBuilder();
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
    public List<String> getZipcodes() {
        return this.zipcodes;
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
    public void setZipcodes(List<String> zipcodes) {
        this.zipcodes = zipcodes;
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
        if (!(o instanceof SetLocationsZipcodesRequset)) {
            return false;
        }
        SetLocationsZipcodesRequset other = (SetLocationsZipcodesRequset)o;
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
        List<String> this$zipcodes = this.getZipcodes();
        List<String> other$zipcodes = other.getZipcodes();
        if (this$zipcodes == null ? other$zipcodes != null : !((Object)this$zipcodes).equals(other$zipcodes)) {
            return false;
        }
        String this$orderBy = this.getOrderBy();
        String other$orderBy = other.getOrderBy();
        return !(this$orderBy == null ? other$orderBy != null : !this$orderBy.equals(other$orderBy));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof SetLocationsZipcodesRequset;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $poolType = this.getPoolType();
        result = result * 59 + ($poolType == null ? 43 : $poolType.hashCode());
        List<String> $countries = this.getCountries();
        result = result * 59 + ($countries == null ? 43 : ((Object)$countries).hashCode());
        List<String> $zipcodes = this.getZipcodes();
        result = result * 59 + ($zipcodes == null ? 43 : ((Object)$zipcodes).hashCode());
        String $orderBy = this.getOrderBy();
        result = result * 59 + ($orderBy == null ? 43 : $orderBy.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "SetLocationsZipcodesRequset(poolType=" + this.getPoolType() + ", countries=" + this.getCountries() + ", zipcodes=" + this.getZipcodes() + ", orderBy=" + this.getOrderBy() + ")";
    }

    @Generated
    public SetLocationsZipcodesRequset() {
    }

    @Generated
    public SetLocationsZipcodesRequset(String poolType, List<String> countries, List<String> zipcodes, String orderBy) {
        this.poolType = poolType;
        this.countries = countries;
        this.zipcodes = zipcodes;
        this.orderBy = orderBy;
    }

    @Generated
    public static class SetLocationsZipcodesRequsetBuilder {
        @Generated
        private String poolType;
        @Generated
        private List<String> countries;
        @Generated
        private List<String> zipcodes;
        @Generated
        private String orderBy;

        @Generated
        SetLocationsZipcodesRequsetBuilder() {
        }

        @JsonProperty(value="pool_type")
        @Generated
        public SetLocationsZipcodesRequsetBuilder poolType(String poolType) {
            this.poolType = poolType;
            return this;
        }

        @Generated
        public SetLocationsZipcodesRequsetBuilder countries(List<String> countries) {
            this.countries = countries;
            return this;
        }

        @Generated
        public SetLocationsZipcodesRequsetBuilder zipcodes(List<String> zipcodes) {
            this.zipcodes = zipcodes;
            return this;
        }

        @JsonProperty(value="order_by")
        @Generated
        public SetLocationsZipcodesRequsetBuilder orderBy(String orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        @Generated
        public SetLocationsZipcodesRequset build() {
            return new SetLocationsZipcodesRequset(this.poolType, this.countries, this.zipcodes, this.orderBy);
        }

        @Generated
        public String toString() {
            return "SetLocationsZipcodesRequset.SetLocationsZipcodesRequsetBuilder(poolType=" + this.poolType + ", countries=" + this.countries + ", zipcodes=" + this.zipcodes + ", orderBy=" + this.orderBy + ")";
        }
    }
}

