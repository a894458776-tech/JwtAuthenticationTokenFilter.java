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

public class KtonIpStaticConfigPlan
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="IP\u7c7b\u578b  0 \u5e7f\u64ad\uff0c1 \u539f\u751f")
    private Long ipType;
    @Excel(name="ip\u6570\u91cf")
    private Long totalIps;
    @Excel(name="\u5355\u4ef7")
    private BigDecimal price;
    @Excel(name="\u56fd\u5bb6\u7f16\u7801")
    private String countryCode;
    @Excel(name="\u72b6\u6001\uff1aN-\u5426\uff0cY-\u662f")
    private String status;
    @Excel(name="\u5546\u6237ID")
    private Long merchantId;
    @Excel(name="\u662f\u5426\u72ec\u4eab")
    private Long isExclusive;

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

    public void setTotalIps(Long totalIps) {
        this.totalIps = totalIps;
    }

    public Long getTotalIps() {
        return this.totalIps;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getMerchantId() {
        return this.merchantId;
    }

    public void setIsExclusive(Long isExclusive) {
        this.isExclusive = isExclusive;
    }

    public Long getIsExclusive() {
        return this.isExclusive;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("ipType", (Object)this.getIpType()).append("totalIps", (Object)this.getTotalIps()).append("price", (Object)this.getPrice()).append("countryCode", (Object)this.getCountryCode()).append("status", (Object)this.getStatus()).append("merchantId", (Object)this.getMerchantId()).append("isExclusive", (Object)this.getIsExclusive()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

