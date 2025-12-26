/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.account.entity.dto;

import java.math.BigDecimal;
import lombok.Generated;

public class BanlanceResponseInfoDTO {
    private BigDecimal balance;
    private String balanceFormat;
    private BigDecimal balanceTotal;
    private String balanceTotalFormat;
    private BigDecimal balanceUsed;
    private String balanceUsedFormat;
    private String threadsUsed;

    @Generated
    public BanlanceResponseInfoDTO() {
    }

    @Generated
    public BigDecimal getBalance() {
        return this.balance;
    }

    @Generated
    public String getBalanceFormat() {
        return this.balanceFormat;
    }

    @Generated
    public BigDecimal getBalanceTotal() {
        return this.balanceTotal;
    }

    @Generated
    public String getBalanceTotalFormat() {
        return this.balanceTotalFormat;
    }

    @Generated
    public BigDecimal getBalanceUsed() {
        return this.balanceUsed;
    }

    @Generated
    public String getBalanceUsedFormat() {
        return this.balanceUsedFormat;
    }

    @Generated
    public String getThreadsUsed() {
        return this.threadsUsed;
    }

    @Generated
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Generated
    public void setBalanceFormat(String balanceFormat) {
        this.balanceFormat = balanceFormat;
    }

    @Generated
    public void setBalanceTotal(BigDecimal balanceTotal) {
        this.balanceTotal = balanceTotal;
    }

    @Generated
    public void setBalanceTotalFormat(String balanceTotalFormat) {
        this.balanceTotalFormat = balanceTotalFormat;
    }

    @Generated
    public void setBalanceUsed(BigDecimal balanceUsed) {
        this.balanceUsed = balanceUsed;
    }

    @Generated
    public void setBalanceUsedFormat(String balanceUsedFormat) {
        this.balanceUsedFormat = balanceUsedFormat;
    }

    @Generated
    public void setThreadsUsed(String threadsUsed) {
        this.threadsUsed = threadsUsed;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BanlanceResponseInfoDTO)) {
            return false;
        }
        BanlanceResponseInfoDTO other = (BanlanceResponseInfoDTO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        BigDecimal this$balance = this.getBalance();
        BigDecimal other$balance = other.getBalance();
        if (this$balance == null ? other$balance != null : !((Object)this$balance).equals(other$balance)) {
            return false;
        }
        String this$balanceFormat = this.getBalanceFormat();
        String other$balanceFormat = other.getBalanceFormat();
        if (this$balanceFormat == null ? other$balanceFormat != null : !this$balanceFormat.equals(other$balanceFormat)) {
            return false;
        }
        BigDecimal this$balanceTotal = this.getBalanceTotal();
        BigDecimal other$balanceTotal = other.getBalanceTotal();
        if (this$balanceTotal == null ? other$balanceTotal != null : !((Object)this$balanceTotal).equals(other$balanceTotal)) {
            return false;
        }
        String this$balanceTotalFormat = this.getBalanceTotalFormat();
        String other$balanceTotalFormat = other.getBalanceTotalFormat();
        if (this$balanceTotalFormat == null ? other$balanceTotalFormat != null : !this$balanceTotalFormat.equals(other$balanceTotalFormat)) {
            return false;
        }
        BigDecimal this$balanceUsed = this.getBalanceUsed();
        BigDecimal other$balanceUsed = other.getBalanceUsed();
        if (this$balanceUsed == null ? other$balanceUsed != null : !((Object)this$balanceUsed).equals(other$balanceUsed)) {
            return false;
        }
        String this$balanceUsedFormat = this.getBalanceUsedFormat();
        String other$balanceUsedFormat = other.getBalanceUsedFormat();
        if (this$balanceUsedFormat == null ? other$balanceUsedFormat != null : !this$balanceUsedFormat.equals(other$balanceUsedFormat)) {
            return false;
        }
        String this$threadsUsed = this.getThreadsUsed();
        String other$threadsUsed = other.getThreadsUsed();
        return !(this$threadsUsed == null ? other$threadsUsed != null : !this$threadsUsed.equals(other$threadsUsed));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof BanlanceResponseInfoDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        BigDecimal $balance = this.getBalance();
        result = result * 59 + ($balance == null ? 43 : ((Object)$balance).hashCode());
        String $balanceFormat = this.getBalanceFormat();
        result = result * 59 + ($balanceFormat == null ? 43 : $balanceFormat.hashCode());
        BigDecimal $balanceTotal = this.getBalanceTotal();
        result = result * 59 + ($balanceTotal == null ? 43 : ((Object)$balanceTotal).hashCode());
        String $balanceTotalFormat = this.getBalanceTotalFormat();
        result = result * 59 + ($balanceTotalFormat == null ? 43 : $balanceTotalFormat.hashCode());
        BigDecimal $balanceUsed = this.getBalanceUsed();
        result = result * 59 + ($balanceUsed == null ? 43 : ((Object)$balanceUsed).hashCode());
        String $balanceUsedFormat = this.getBalanceUsedFormat();
        result = result * 59 + ($balanceUsedFormat == null ? 43 : $balanceUsedFormat.hashCode());
        String $threadsUsed = this.getThreadsUsed();
        result = result * 59 + ($threadsUsed == null ? 43 : $threadsUsed.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "BanlanceResponseInfoDTO(balance=" + this.getBalance() + ", balanceFormat=" + this.getBalanceFormat() + ", balanceTotal=" + this.getBalanceTotal() + ", balanceTotalFormat=" + this.getBalanceTotalFormat() + ", balanceUsed=" + this.getBalanceUsed() + ", balanceUsedFormat=" + this.getBalanceUsedFormat() + ", threadsUsed=" + this.getThreadsUsed() + ")";
    }
}

