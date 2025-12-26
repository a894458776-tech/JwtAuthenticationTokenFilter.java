/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.annotation.Excel
 *  com.kylin.kton.common.core.domain.BaseEntity
 *  org.apache.commons.lang3.builder.ToStringBuilder
 *  org.apache.commons.lang3.builder.ToStringStyle
 */
package com.kylin.kton.system.domain;

import com.kylin.kton.common.annotation.Excel;
import com.kylin.kton.common.core.domain.BaseEntity;
import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class KtonIpDynamicsAccountBalance
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="kton_merchant.id")
    private Long merchantId;
    @Excel(name="\u6e20\u9053\u65b9\u8bb0\u5f55id")
    private Long accountId;
    @Excel(name="\u5f53\u524d\u4f59\u989d")
    private BigDecimal balance;
    @Excel(name="\u4f59\u989d\u683c\u5f0f\u5316\u663e\u793a\uff0cGB")
    private String balanceFormat;
    @Excel(name="\u603b\u989d")
    private BigDecimal balanceTotal;
    @Excel(name="\u603b\u989d\u683c\u5f0f\u5316\u663e\u793a\uff0cGB")
    private String balanceTotalFormat;
    @Excel(name="\u5df2\u4f7f\u7528")
    private BigDecimal balanceUsed;
    @Excel(name="\u5df2\u4f7f\u7528\u683c\u5f0f\u5316\u663e\u793a\uff0cGB")
    private String balanceUsedFormat;
    @Excel(name="\u5df2\u4f7f\u7528\u7ebf\u7a0b\u6570")
    private String threadsUsed;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getMerchantId() {
        return this.merchantId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return this.accountId;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalanceFormat(String balanceFormat) {
        this.balanceFormat = balanceFormat;
    }

    public String getBalanceFormat() {
        return this.balanceFormat;
    }

    public void setBalanceTotal(BigDecimal balanceTotal) {
        this.balanceTotal = balanceTotal;
    }

    public BigDecimal getBalanceTotal() {
        return this.balanceTotal;
    }

    public void setBalanceTotalFormat(String balanceTotalFormat) {
        this.balanceTotalFormat = balanceTotalFormat;
    }

    public String getBalanceTotalFormat() {
        return this.balanceTotalFormat;
    }

    public void setBalanceUsed(BigDecimal balanceUsed) {
        this.balanceUsed = balanceUsed;
    }

    public BigDecimal getBalanceUsed() {
        return this.balanceUsed;
    }

    public void setBalanceUsedFormat(String balanceUsedFormat) {
        this.balanceUsedFormat = balanceUsedFormat;
    }

    public String getBalanceUsedFormat() {
        return this.balanceUsedFormat;
    }

    public void setThreadsUsed(String threadsUsed) {
        this.threadsUsed = threadsUsed;
    }

    public String getThreadsUsed() {
        return this.threadsUsed;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("merchantId", (Object)this.getMerchantId()).append("accountId", (Object)this.getAccountId()).append("balance", (Object)this.getBalance()).append("balanceFormat", (Object)this.getBalanceFormat()).append("balanceTotal", (Object)this.getBalanceTotal()).append("balanceTotalFormat", (Object)this.getBalanceTotalFormat()).append("balanceUsed", (Object)this.getBalanceUsed()).append("balanceUsedFormat", (Object)this.getBalanceUsedFormat()).append("threadsUsed", (Object)this.getThreadsUsed()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

