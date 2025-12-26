/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

public class AllocateGBRequest {
    @JsonProperty(value="allocate")
    private Integer allocate;
    @JsonProperty(value="product_type")
    private String productType;

    @Generated
    public AllocateGBRequest() {
    }

    @Generated
    public Integer getAllocate() {
        return this.allocate;
    }

    @Generated
    public String getProductType() {
        return this.productType;
    }

    @JsonProperty(value="allocate")
    @Generated
    public void setAllocate(Integer allocate) {
        this.allocate = allocate;
    }

    @JsonProperty(value="product_type")
    @Generated
    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AllocateGBRequest)) {
            return false;
        }
        AllocateGBRequest other = (AllocateGBRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Integer this$allocate = this.getAllocate();
        Integer other$allocate = other.getAllocate();
        if (this$allocate == null ? other$allocate != null : !((Object)this$allocate).equals(other$allocate)) {
            return false;
        }
        String this$productType = this.getProductType();
        String other$productType = other.getProductType();
        return !(this$productType == null ? other$productType != null : !this$productType.equals(other$productType));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AllocateGBRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $allocate = this.getAllocate();
        result = result * 59 + ($allocate == null ? 43 : ((Object)$allocate).hashCode());
        String $productType = this.getProductType();
        result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AllocateGBRequest(allocate=" + this.getAllocate() + ", productType=" + this.getProductType() + ")";
    }
}

