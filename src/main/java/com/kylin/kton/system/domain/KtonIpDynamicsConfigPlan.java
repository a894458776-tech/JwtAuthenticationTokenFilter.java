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

public class KtonIpDynamicsConfigPlan
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="\u5546\u6237ID\uff0c0-\u9ed8\u8ba4\u914d\u7f6e")
    private Long merchantId;
    @Excel(name="\u6807\u9898")
    private String title;
    @Excel(name="\u5bb9\u91cfGB")
    private BigDecimal capacity;
    @Excel(name="\u4ef7\u683c")
    private BigDecimal price;
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

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getMerchantId() {
        return this.merchantId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
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
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("merchantId", (Object)this.getMerchantId()).append("title", (Object)this.getTitle()).append("capacity", (Object)this.getCapacity()).append("price", (Object)this.getPrice()).append("discount", (Object)this.getDiscount()).append("status", (Object)this.getStatus()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

