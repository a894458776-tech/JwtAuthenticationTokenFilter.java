/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.validation.constraints.NotNull
 *  lombok.Generated
 */
package com.kylin.kton.admin.merchant.base.entity.vo;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.Generated;

public class MerchantRecahrgeVO {
    @NotNull(message="\u5546\u6237ID\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="\u5546\u6237ID\u4e0d\u80fd\u4e3a\u7a7a") Long merchantId;
    @NotNull(message="\u5145\u503c\u91d1\u989d")
    private @NotNull(message="\u5145\u503c\u91d1\u989d") BigDecimal amount;

    @Generated
    public MerchantRecahrgeVO() {
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public BigDecimal getAmount() {
        return this.amount;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MerchantRecahrgeVO)) {
            return false;
        }
        MerchantRecahrgeVO other = (MerchantRecahrgeVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        BigDecimal this$amount = this.getAmount();
        BigDecimal other$amount = other.getAmount();
        return !(this$amount == null ? other$amount != null : !((Object)this$amount).equals(other$amount));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof MerchantRecahrgeVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        BigDecimal $amount = this.getAmount();
        result = result * 59 + ($amount == null ? 43 : ((Object)$amount).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "MerchantRecahrgeVO(merchantId=" + this.getMerchantId() + ", amount=" + this.getAmount() + ")";
    }
}

