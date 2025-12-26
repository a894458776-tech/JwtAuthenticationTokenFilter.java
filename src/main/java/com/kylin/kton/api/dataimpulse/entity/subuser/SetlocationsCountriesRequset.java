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
import lombok.Generated;

public class SetlocationsCountriesRequset
implements Serializable {
    @JsonProperty(value="pool_type")
    private String poolType;
    @JsonProperty(value="pool_type")
    private String orderBy;

    @Generated
    public static SetlocationsCountriesRequsetBuilder builder() {
        return new SetlocationsCountriesRequsetBuilder();
    }

    @Generated
    public String getPoolType() {
        return this.poolType;
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

    @JsonProperty(value="pool_type")
    @Generated
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SetlocationsCountriesRequset)) {
            return false;
        }
        SetlocationsCountriesRequset other = (SetlocationsCountriesRequset)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$poolType = this.getPoolType();
        String other$poolType = other.getPoolType();
        if (this$poolType == null ? other$poolType != null : !this$poolType.equals(other$poolType)) {
            return false;
        }
        String this$orderBy = this.getOrderBy();
        String other$orderBy = other.getOrderBy();
        return !(this$orderBy == null ? other$orderBy != null : !this$orderBy.equals(other$orderBy));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof SetlocationsCountriesRequset;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $poolType = this.getPoolType();
        result = result * 59 + ($poolType == null ? 43 : $poolType.hashCode());
        String $orderBy = this.getOrderBy();
        result = result * 59 + ($orderBy == null ? 43 : $orderBy.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "SetlocationsCountriesRequset(poolType=" + this.getPoolType() + ", orderBy=" + this.getOrderBy() + ")";
    }

    @Generated
    public SetlocationsCountriesRequset() {
    }

    @Generated
    public SetlocationsCountriesRequset(String poolType, String orderBy) {
        this.poolType = poolType;
        this.orderBy = orderBy;
    }

    @Generated
    public static class SetlocationsCountriesRequsetBuilder {
        @Generated
        private String poolType;
        @Generated
        private String orderBy;

        @Generated
        SetlocationsCountriesRequsetBuilder() {
        }

        @JsonProperty(value="pool_type")
        @Generated
        public SetlocationsCountriesRequsetBuilder poolType(String poolType) {
            this.poolType = poolType;
            return this;
        }

        @JsonProperty(value="pool_type")
        @Generated
        public SetlocationsCountriesRequsetBuilder orderBy(String orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        @Generated
        public SetlocationsCountriesRequset build() {
            return new SetlocationsCountriesRequset(this.poolType, this.orderBy);
        }

        @Generated
        public String toString() {
            return "SetlocationsCountriesRequset.SetlocationsCountriesRequsetBuilder(poolType=" + this.poolType + ", orderBy=" + this.orderBy + ")";
        }
    }
}

