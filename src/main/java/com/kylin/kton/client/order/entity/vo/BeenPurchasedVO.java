/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.order.entity.vo;

import lombok.Generated;

public class BeenPurchasedVO {
    private Long productType;
    private Long merchantId;

    @Generated
    public BeenPurchasedVO() {
    }

    @Generated
    public Long getProductType() {
        return this.productType;
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public void setProductType(Long productType) {
        this.productType = productType;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BeenPurchasedVO)) {
            return false;
        }
        BeenPurchasedVO other = (BeenPurchasedVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$productType = this.getProductType();
        Long other$productType = other.getProductType();
        if (this$productType == null ? other$productType != null : !((Object)this$productType).equals(other$productType)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        return !(this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof BeenPurchasedVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $productType = this.getProductType();
        result = result * 59 + ($productType == null ? 43 : ((Object)$productType).hashCode());
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "BeenPurchasedVO(productType=" + this.getProductType() + ", merchantId=" + this.getMerchantId() + ")";
    }
}

