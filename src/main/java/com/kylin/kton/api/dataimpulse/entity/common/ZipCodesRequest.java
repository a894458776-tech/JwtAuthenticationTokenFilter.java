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

public class ZipCodesRequest
implements Serializable {
    @JsonProperty(value="pool_type")
    private PoolType poolType;
    private List<String> countries;
    private List<String> states;
    private List<String> asns;
    @JsonProperty(value="order_by")
    private String orderBy = "name,asc";

    public String getPoolType() {
        if (Objects.nonNull((Object)this.poolType)) {
            return this.poolType.getCode();
        }
        return null;
    }

    @Generated
    public static ZipCodesRequestBuilder builder() {
        return new ZipCodesRequestBuilder();
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
    public List<String> getAsns() {
        return this.asns;
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
        if (!(o instanceof ZipCodesRequest)) {
            return false;
        }
        ZipCodesRequest other = (ZipCodesRequest)o;
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
        return other instanceof ZipCodesRequest;
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
        List<String> $asns = this.getAsns();
        result = result * 59 + ($asns == null ? 43 : ((Object)$asns).hashCode());
        String $orderBy = this.getOrderBy();
        result = result * 59 + ($orderBy == null ? 43 : $orderBy.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ZipCodesRequest(poolType=" + this.getPoolType() + ", countries=" + this.getCountries() + ", states=" + this.getStates() + ", asns=" + this.getAsns() + ", orderBy=" + this.getOrderBy() + ")";
    }

    @Generated
    public ZipCodesRequest(PoolType poolType, List<String> countries, List<String> states, List<String> asns, String orderBy) {
        this.poolType = poolType;
        this.countries = countries;
        this.states = states;
        this.asns = asns;
        this.orderBy = orderBy;
    }

    @Generated
    public ZipCodesRequest() {
    }

    @Generated
    public static class ZipCodesRequestBuilder {
        @Generated
        private PoolType poolType;
        @Generated
        private List<String> countries;
        @Generated
        private List<String> states;
        @Generated
        private List<String> asns;
        @Generated
        private String orderBy;

        @Generated
        ZipCodesRequestBuilder() {
        }

        @JsonProperty(value="pool_type")
        @Generated
        public ZipCodesRequestBuilder poolType(PoolType poolType) {
            this.poolType = poolType;
            return this;
        }

        @Generated
        public ZipCodesRequestBuilder countries(List<String> countries) {
            this.countries = countries;
            return this;
        }

        @Generated
        public ZipCodesRequestBuilder states(List<String> states) {
            this.states = states;
            return this;
        }

        @Generated
        public ZipCodesRequestBuilder asns(List<String> asns) {
            this.asns = asns;
            return this;
        }

        @JsonProperty(value="order_by")
        @Generated
        public ZipCodesRequestBuilder orderBy(String orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        @Generated
        public ZipCodesRequest build() {
            return new ZipCodesRequest(this.poolType, this.countries, this.states, this.asns, this.orderBy);
        }

        @Generated
        public String toString() {
            return "ZipCodesRequest.ZipCodesRequestBuilder(poolType=" + (Object)((Object)this.poolType) + ", countries=" + this.countries + ", states=" + this.states + ", asns=" + this.asns + ", orderBy=" + this.orderBy + ")";
        }
    }
}

