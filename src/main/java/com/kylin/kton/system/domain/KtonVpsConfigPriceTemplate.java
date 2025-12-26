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

public class KtonVpsConfigPriceTemplate
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="\u5bbf\u4e3b\u673aID kton_vps_host \u8868\u4e3b\u952e")
    private Long hostId;
    @Excel(name="\u5546\u6237ID", readConverterExp="\u6307=\u5b9a\u5c31\u662f\u5546\u6237ID\uff0c\u6ca1\u6709\u5c31\u662f0")
    private Long merchantId;
    @Excel(name="kton_vps_config_performance.id")
    private Long hostPerformanceId;
    @Excel(name="\u5929\u6570")
    private Long days;
    @Excel(name="\u5929\u6570\u6298\u6263")
    private BigDecimal dayDiscount;
    @Excel(name="\u6bcf\u6708\u4ef7\u683c")
    private BigDecimal priceMonthly;
    @Excel(name="\u6bcf\u5b63\u5ea6\u4ef7\u683c")
    private BigDecimal priceQuarterly;
    @Excel(name="\u6bcf\u534a\u5e74\u4ef7\u683c")
    private BigDecimal priceSemiAnnually;
    @Excel(name="\u6bcf\u5e74\u4ef7\u683c")
    private BigDecimal priceAnnually;
    @Excel(name="\u8d27\u5e01")
    private String currency;
    @Excel(name="\u72b6\u6001", readConverterExp="Y=\uff1a\u542f\u7528\uff1bN:\u672a\u542f\u7528")
    private String status;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public Long getHostId() {
        return this.hostId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getMerchantId() {
        return this.merchantId;
    }

    public void setHostPerformanceId(Long hostPerformanceId) {
        this.hostPerformanceId = hostPerformanceId;
    }

    public Long getHostPerformanceId() {
        return this.hostPerformanceId;
    }

    public void setDays(Long days) {
        this.days = days;
    }

    public Long getDays() {
        return this.days;
    }

    public void setDayDiscount(BigDecimal dayDiscount) {
        this.dayDiscount = dayDiscount;
    }

    public BigDecimal getDayDiscount() {
        return this.dayDiscount;
    }

    public void setPriceMonthly(BigDecimal priceMonthly) {
        this.priceMonthly = priceMonthly;
    }

    public BigDecimal getPriceMonthly() {
        return this.priceMonthly;
    }

    public void setPriceQuarterly(BigDecimal priceQuarterly) {
        this.priceQuarterly = priceQuarterly;
    }

    public BigDecimal getPriceQuarterly() {
        return this.priceQuarterly;
    }

    public void setPriceSemiAnnually(BigDecimal priceSemiAnnually) {
        this.priceSemiAnnually = priceSemiAnnually;
    }

    public BigDecimal getPriceSemiAnnually() {
        return this.priceSemiAnnually;
    }

    public void setPriceAnnually(BigDecimal priceAnnually) {
        this.priceAnnually = priceAnnually;
    }

    public BigDecimal getPriceAnnually() {
        return this.priceAnnually;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("hostId", (Object)this.getHostId()).append("merchantId", (Object)this.getMerchantId()).append("hostPerformanceId", (Object)this.getHostPerformanceId()).append("days", (Object)this.getDays()).append("dayDiscount", (Object)this.getDayDiscount()).append("priceMonthly", (Object)this.getPriceMonthly()).append("priceQuarterly", (Object)this.getPriceQuarterly()).append("priceSemiAnnually", (Object)this.getPriceSemiAnnually()).append("priceAnnually", (Object)this.getPriceAnnually()).append("currency", (Object)this.getCurrency()).append("status", (Object)this.getStatus()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

