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

public class KtonIpStaticConfigPeriod
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="IP\u7c7b\u578b1\uff0c\u666e\u901a\uff0c2 \u539f\u751f")
    private Long ipType;
    @Excel(name="kton_merchant.id\uff0c \u4e3a0\u65f6\u8868\u793a\u9ed8\u8ba4\u914d\u7f6e")
    private Long merchantId;
    @Excel(name="\u5929\u6570")
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

    public void setIpType(Long ipType) {
        this.ipType = ipType;
    }

    public Long getIpType() {
        return this.ipType;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getMerchantId() {
        return this.merchantId;
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
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("ipType", (Object)this.getIpType()).append("merchantId", (Object)this.getMerchantId()).append("days", (Object)this.getDays()).append("discount", (Object)this.getDiscount()).append("status", (Object)this.getStatus()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

