/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.swagger.annotations.ApiModelProperty
 *  lombok.Generated
 */
package com.kylin.kton.client.payment.base.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.Generated;

public class PayBalanceVO {
    @ApiModelProperty(value="\u7528\u6237key")
    String userKey;
    @ApiModelProperty(value="\u91d1\u989d")
    BigDecimal amount;

    @Generated
    public PayBalanceVO() {
    }

    @Generated
    public String getUserKey() {
        return this.userKey;
    }

    @Generated
    public BigDecimal getAmount() {
        return this.amount;
    }

    @Generated
    public void setUserKey(String userKey) {
        this.userKey = userKey;
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
        if (!(o instanceof PayBalanceVO)) {
            return false;
        }
        PayBalanceVO other = (PayBalanceVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$userKey = this.getUserKey();
        String other$userKey = other.getUserKey();
        if (this$userKey == null ? other$userKey != null : !this$userKey.equals(other$userKey)) {
            return false;
        }
        BigDecimal this$amount = this.getAmount();
        BigDecimal other$amount = other.getAmount();
        return !(this$amount == null ? other$amount != null : !((Object)this$amount).equals(other$amount));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof PayBalanceVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $userKey = this.getUserKey();
        result = result * 59 + ($userKey == null ? 43 : $userKey.hashCode());
        BigDecimal $amount = this.getAmount();
        result = result * 59 + ($amount == null ? 43 : ((Object)$amount).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "PayBalanceVO(userKey=" + this.getUserKey() + ", amount=" + this.getAmount() + ")";
    }
}

