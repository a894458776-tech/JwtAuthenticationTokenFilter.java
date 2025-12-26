/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.account.entity.vo;

import lombok.Generated;

public class AccountBalanceSearchVO {
    private Long merchantId;
    private Long accountId;

    @Generated
    public AccountBalanceSearchVO() {
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
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AccountBalanceSearchVO)) {
            return false;
        }
        AccountBalanceSearchVO other = (AccountBalanceSearchVO)o;
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
        return !(this$accountId == null ? other$accountId != null : !((Object)this$accountId).equals(other$accountId));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AccountBalanceSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        Long $accountId = this.getAccountId();
        result = result * 59 + ($accountId == null ? 43 : ((Object)$accountId).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AccountBalanceSearchVO(merchantId=" + this.getMerchantId() + ", accountId=" + this.getAccountId() + ")";
    }
}

