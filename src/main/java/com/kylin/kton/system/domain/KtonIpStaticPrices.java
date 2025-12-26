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

public class KtonIpStaticPrices
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="t_ip_static.id")
    private Long refId;
    @Excel(name="ip\u6570\u91cf")
    private Long totalIps;
    @Excel(name="\u5355\u4ef7")
    private BigDecimal price;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("refId", (Object)this.getRefId()).append("totalIps", (Object)this.getTotalIps()).append("price", (Object)this.getPrice()).append("status", (Object)this.getStatus()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

