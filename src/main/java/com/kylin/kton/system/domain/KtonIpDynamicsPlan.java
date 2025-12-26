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

public class KtonIpDynamicsPlan
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="\u5546\u6237ID")
    private Long merchantId;
    @Excel(name="\u8ba1\u5212\u7684\u6d41\u91cf")
    private BigDecimal planTrafficGb;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Excel(name="\u8fc7\u671f\u65f6\u95f4", width=30.0, dateFormat="yyyy-MM-dd HH:mm:ss")
    private Date expirationDate;
    @Excel(name="\u662f\u5426\u8fc7\u671f")
    private Long expired;
    @Excel(name="\u5269\u4f59\u6d41\u91cf")
    private BigDecimal planResidueTrafficGb;
    @Excel(name="\u5f53\u524d\u6267\u884c\u7684\u6d41\u91cf\u8ba1\u5212")
    private Long currentPlanItemId;

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

    public void setPlanResidueTrafficGb(BigDecimal planResidueTrafficGb) {
        this.planResidueTrafficGb = planResidueTrafficGb;
    }

    public BigDecimal getPlanResidueTrafficGb() {
        return this.planResidueTrafficGb;
    }

    public void setCurrentPlanItemId(Long currentPlanItemId) {
        this.currentPlanItemId = currentPlanItemId;
    }

    public Long getCurrentPlanItemId() {
        return this.currentPlanItemId;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("merchantId", (Object)this.getMerchantId()).append("planTrafficGb", (Object)this.getPlanTrafficGb()).append("expirationDate", (Object)this.getExpirationDate()).append("expired", (Object)this.getExpired()).append("planResidueTrafficGb", (Object)this.getPlanResidueTrafficGb()).append("currentPlanItemId", (Object)this.getCurrentPlanItemId()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

