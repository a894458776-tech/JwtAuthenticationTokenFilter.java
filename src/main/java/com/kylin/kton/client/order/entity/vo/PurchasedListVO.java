/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.order.entity.vo;

import lombok.Generated;

public class PurchasedListVO {
    private Long merchantId;

    @Generated
    public PurchasedListVO() {
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
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
        if (!(o instanceof PurchasedListVO)) {
            return false;
        }
        PurchasedListVO other = (PurchasedListVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        return !(this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof PurchasedListVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "PurchasedListVO(merchantId=" + this.getMerchantId() + ")";
    }
}

