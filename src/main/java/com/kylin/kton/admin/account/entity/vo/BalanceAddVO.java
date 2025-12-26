/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.account.entity.vo;

import java.math.BigDecimal;
import lombok.Generated;

public class BalanceAddVO {
    private Long merchantId;
    private Long accountId;
    private BigDecimal trafficLimit;

    @Generated
    public BalanceAddVO() {
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public Long getAccountId() {
        return this.accountId;
    }

    @Generated
    public BigDecimal getTrafficLimit() {
        return this.trafficLimit;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Generated
    public void setTrafficLimit(BigDecimal trafficLimit) {
        this.trafficLimit = trafficLimit;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BalanceAddVO)) {
            return false;
        }
        BalanceAddVO other = (BalanceAddVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        Long this$accountId = this.getAccountId();
        Long other$accountId = other.getAccountId();
        if (this$accountId == null ? other$accountId != null : !((Object)this$accountId).equals(other$accountId)) {
            return false;
        }
        BigDecimal this$trafficLimit = this.getTrafficLimit();
        BigDecimal other$trafficLimit = other.getTrafficLimit();
        return !(this$trafficLimit == null ? other$trafficLimit != null : !((Object)this$trafficLimit).equals(other$trafficLimit));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof BalanceAddVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        Long $accountId = this.getAccountId();
        result = result * 59 + ($accountId == null ? 43 : ((Object)$accountId).hashCode());
        BigDecimal $trafficLimit = this.getTrafficLimit();
        result = result * 59 + ($trafficLimit == null ? 43 : ((Object)$trafficLimit).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "BalanceAddVO(merchantId=" + this.getMerchantId() + ", accountId=" + this.getAccountId() + ", trafficLimit=" + this.getTrafficLimit() + ")";
    }
}

