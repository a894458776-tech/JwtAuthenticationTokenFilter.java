/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.validation.constraints.NotNull
 *  lombok.Generated
 */
package com.kylin.kton.client.ip.entity.vo;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.Generated;

public class ConfDaysListVO {
    @NotNull(message="ipType\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="ipType\u4e0d\u80fd\u4e3a\u7a7a") Long ipType;
    private Long days;
    private BigDecimal discount;
    private String status;
    private Long merchantId;

    @Generated
    public ConfDaysListVO() {
    }

    @Generated
    public Long getIpType() {
        return this.ipType;
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
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public void setIpType(Long ipType) {
        this.ipType = ipType;
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
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ConfDaysListVO)) {
            return false;
        }
        ConfDaysListVO other = (ConfDaysListVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$ipType = this.getIpType();
        Long other$ipType = other.getIpType();
        if (this$ipType == null ? other$ipType != null : !((Object)this$ipType).equals(other$ipType)) {
            return false;
        }
        Long this$days = this.getDays();
        Long other$days = other.getDays();
        if (this$days == null ? other$days != null : !((Object)this$days).equals(other$days)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
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
        return other instanceof ConfDaysListVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $ipType = this.getIpType();
        result = result * 59 + ($ipType == null ? 43 : ((Object)$ipType).hashCode());
        Long $days = this.getDays();
        result = result * 59 + ($days == null ? 43 : ((Object)$days).hashCode());
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        BigDecimal $discount = this.getDiscount();
        result = result * 59 + ($discount == null ? 43 : ((Object)$discount).hashCode());
        String $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ConfDaysListVO(ipType=" + this.getIpType() + ", days=" + this.getDays() + ", discount=" + this.getDiscount() + ", status=" + this.getStatus() + ", merchantId=" + this.getMerchantId() + ")";
    }
}

