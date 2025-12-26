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

public class KtonIpDynamicsItem
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="t_ip_dynamics.id")
    private Long refId;
    @Excel(name="\u5355\u4ef7")
    private BigDecimal price;
    @Excel(name="\u8d27\u5e01")
    private String currency;
    @Excel(name="\u6709\u6548\u5929\u6570")
    private Long days;
    @Excel(name="\u6298\u6263")
    private BigDecimal discount;
    @Excel(name="\u72b6\u6001\uff1aN-\u5426\uff0cY-\u662f")
    private String status;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setRefId(Long refId) {
        this.refId = refId;
    }

    public Long getRefId() {
        return this.refId;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setDays(Long days) {
        this.days = days;
    }

    public Long getDays() {
        return this.days;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getDiscount() {
        return this.discount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("refId", (Object)this.getRefId()).append("price", (Object)this.getPrice()).append("currency", (Object)this.getCurrency()).append("days", (Object)this.getDays()).append("discount", (Object)this.getDiscount()).append("status", (Object)this.getStatus()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

