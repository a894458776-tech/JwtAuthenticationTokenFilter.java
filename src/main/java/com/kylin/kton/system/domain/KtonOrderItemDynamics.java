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

public class KtonOrderItemDynamics
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="t_order.id")
    private Long orderId;
    @Excel(name="\u5bb9\u91cfGB")
    private BigDecimal capacity;
    @Excel(name="\u5355\u4ef7")
    private BigDecimal price;
    @Excel(name="\u8d27\u5e01")
    private String currency;
    @Excel(name="\u6709\u6548\u5929\u6570")
    private Long days;
    @Excel(name="\u6298\u6263")
    private BigDecimal discount;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Excel(name="\u751f\u6548\u65f6\u95f4", width=30.0, dateFormat="yyyy-MM-dd")
    private Date effectiveDatetime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Excel(name="\u8fc7\u671f\u65f6\u95f4", width=30.0, dateFormat="yyyy-MM-dd HH:mm:ss")
    private Date expireDatetime;
    @Excel(name="\u72b6\u6001:Y-\u6b63\u5e38\uff0cN-\u8fc7\u671f")
    private String status;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public void setCapacity(BigDecimal capacity) {
        this.capacity = capacity;
    }

    public BigDecimal getCapacity() {
        return this.capacity;
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

    public void setEffectiveDatetime(Date effectiveDatetime) {
        this.effectiveDatetime = effectiveDatetime;
    }

    public Date getEffectiveDatetime() {
        return this.effectiveDatetime;
    }

    public void setExpireDatetime(Date expireDatetime) {
        this.expireDatetime = expireDatetime;
    }

    public Date getExpireDatetime() {
        return this.expireDatetime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("orderId", (Object)this.getOrderId()).append("capacity", (Object)this.getCapacity()).append("price", (Object)this.getPrice()).append("currency", (Object)this.getCurrency()).append("days", (Object)this.getDays()).append("discount", (Object)this.getDiscount()).append("effectiveDatetime", (Object)this.getEffectiveDatetime()).append("expireDatetime", (Object)this.getExpireDatetime()).append("status", (Object)this.getStatus()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

