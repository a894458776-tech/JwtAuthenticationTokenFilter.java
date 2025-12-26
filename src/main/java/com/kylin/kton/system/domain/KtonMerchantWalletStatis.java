/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.kylin.kton.common.annotation.Excel
 *  com.kylin.kton.common.core.domain.BaseEntity
 *  org.apache.commons.lang3.builder.ToStringBuilder
 *  org.apache.commons.lang3.builder.ToStringStyle
 */
package com.kylin.kton.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kylin.kton.common.annotation.Excel;
import com.kylin.kton.common.core.domain.BaseEntity;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class KtonMerchantWalletStatis
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="\u5546\u6237ID")
    private Long merchantId;
    @Excel(name="\u7edf\u8ba1\u7c7b\u578b\uff0c\u5907\u7528")
    private String statisType;
    @Excel(name="\u5e74")
    private Long year;
    @Excel(name="\u6708")
    private Long month;
    @Excel(name="\u65e5")
    private Long date;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Excel(name="\u7edf\u8ba1\u65e5\u671f", width=30.0, dateFormat="yyyy-MM-dd")
    private Date statisDate;
    @Excel(name="\u91d1\u989d")
    private Long amount;

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

    public void setStatisType(String statisType) {
        this.statisType = statisType;
    }

    public String getStatisType() {
        return this.statisType;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getYear() {
        return this.year;
    }

    public void setMonth(Long month) {
        this.month = month;
    }

    public Long getMonth() {
        return this.month;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getDate() {
        return this.date;
    }

    public void setStatisDate(Date statisDate) {
        this.statisDate = statisDate;
    }

    public Date getStatisDate() {
        return this.statisDate;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return this.amount;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("merchantId", (Object)this.getMerchantId()).append("statisType", (Object)this.getStatisType()).append("year", (Object)this.getYear()).append("month", (Object)this.getMonth()).append("date", (Object)this.getDate()).append("statisDate", (Object)this.getStatisDate()).append("amount", (Object)this.getAmount()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

