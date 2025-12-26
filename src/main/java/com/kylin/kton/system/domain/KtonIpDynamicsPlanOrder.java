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
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class KtonIpDynamicsPlanOrder
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="\u5546\u6237ID")
    private Long merchantId;
    @Excel(name="\u8ba1\u5212\u540d")
    private String planName;
    @Excel(name="\u8ba1\u5212\u7684\u6d41\u91cf")
    private BigDecimal planTrafficGb;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Excel(name="\u8fc7\u671f\u65f6\u95f4", width=30.0, dateFormat="yyyy-MM-dd")
    private Date expirationDate;
    @Excel(name="\u662f\u5426\u8fc7\u671f")
    private Long expired;
    @Excel(name="\u4ef7\u683c")
    private BigDecimal price;
    @Excel(name="\u6bcfGB\u4ef7\u683c")
    private BigDecimal pricePerGb;
    @Excel(name="\u8ba1\u5212\u7c7b\u578bID")
    private Long planTypeId;
    @Excel(name="\u5269\u4f59\u6d41\u91cf")
    private BigDecimal planResidueTrafficGb;

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

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanName() {
        return this.planName;
    }

    public void setPlanTrafficGb(BigDecimal planTrafficGb) {
        this.planTrafficGb = planTrafficGb;
    }

    public BigDecimal getPlanTrafficGb() {
        return this.planTrafficGb;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpired(Long expired) {
        this.expired = expired;
    }

    public Long getExpired() {
        return this.expired;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPricePerGb(BigDecimal pricePerGb) {
        this.pricePerGb = pricePerGb;
    }

    public BigDecimal getPricePerGb() {
        return this.pricePerGb;
    }

    public void setPlanTypeId(Long planTypeId) {
        this.planTypeId = planTypeId;
    }

    public Long getPlanTypeId() {
        return this.planTypeId;
    }

    public void setPlanResidueTrafficGb(BigDecimal planResidueTrafficGb) {
        this.planResidueTrafficGb = planResidueTrafficGb;
    }

    public BigDecimal getPlanResidueTrafficGb() {
        return this.planResidueTrafficGb;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("merchantId", (Object)this.getMerchantId()).append("planName", (Object)this.getPlanName()).append("planTrafficGb", (Object)this.getPlanTrafficGb()).append("expirationDate", (Object)this.getExpirationDate()).append("expired", (Object)this.getExpired()).append("price", (Object)this.getPrice()).append("pricePerGb", (Object)this.getPricePerGb()).append("planTypeId", (Object)this.getPlanTypeId()).append("planResidueTrafficGb", (Object)this.getPlanResidueTrafficGb()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

