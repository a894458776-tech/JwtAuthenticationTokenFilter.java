/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.ip.entity.vo;

import java.math.BigDecimal;
import lombok.Generated;

public class DynamicsDaysConfigVO {
    private Long merchantId;
    private Long days;
    private BigDecimal discount;
    private String status;

    @Generated
    public DynamicsDaysConfigVO() {
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public Long getDays() {
        return this.days;
    }

    @Generated
    public BigDecimal getDiscount() {
        return this.discount;
    }

    @Generated
    public String getStatus() {
        return this.status;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public void setDays(Long days) {
        this.days = days;
    }

    @Generated
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Generated
    public void setStatus(String status) {
        this.status = status;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DynamicsDaysConfigVO)) {
            return false;
        }
        DynamicsDaysConfigVO other = (DynamicsDaysConfigVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        Long this$days = this.getDays();
        Long other$days = other.getDays();
        if (this$days == null ? other$days != null : !((Object)this$days).equals(other$days)) {
            return false;
        }
        BigDecimal this$discount = this.getDiscount();
        BigDecimal other$discount = other.getDiscount();
        if (this$discount == null ? other$discount != null : !((Object)this$discount).equals(other$discount)) {
            return false;
        }
        String this$status = this.getStatus();
        String other$status = other.getStatus();
        return !(this$status == null ? other$status != null : !this$status.equals(other$status));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof DynamicsDaysConfigVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        Long $days = this.getDays();
        result = result * 59 + ($days == null ? 43 : ((Object)$days).hashCode());
        BigDecimal $discount = this.getDiscount();
        result = result * 59 + ($discount == null ? 43 : ((Object)$discount).hashCode());
        String $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "DynamicsDaysConfigVO(merchantId=" + this.getMerchantId() + ", days=" + this.getDays() + ", discount=" + this.getDiscount() + ", status=" + this.getStatus() + ")";
    }
}

