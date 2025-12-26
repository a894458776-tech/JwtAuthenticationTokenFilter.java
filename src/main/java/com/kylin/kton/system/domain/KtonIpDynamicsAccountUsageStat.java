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

public class KtonIpDynamicsAccountUsageStat
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="kton_merchant.id")
    private Long merchantId;
    @Excel(name="\u6e20\u9053\u65b9\u8bb0\u5f55id")
    private Long accountId;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Excel(name="\u4f7f\u7528\u65e5\u671f", width=30.0, dateFormat="yyyy-MM-dd")
    private Date dUsage;
    @Excel(name="\u8bf7\u6c42")
    private Long requests;
    @Excel(name="\u6d41\u91cf,\u5355\u4f4dMB")
    private Double traffic;
    @Excel(name="extra\u6d41\u91cf")
    private Double extraTraffic;

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

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return this.accountId;
    }

    public void setdUsage(Date dUsage) {
        this.dUsage = dUsage;
    }

    public Date getdUsage() {
        return this.dUsage;
    }

    public void setRequests(Long requests) {
        this.requests = requests;
    }

    public Long getRequests() {
        return this.requests;
    }

    public void setTraffic(Double traffic) {
        this.traffic = traffic;
    }

    public Double getTraffic() {
        return this.traffic;
    }

    public void setExtraTraffic(Double extraTraffic) {
        this.extraTraffic = extraTraffic;
    }

    public Double getExtraTraffic() {
        return this.extraTraffic;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("merchantId", (Object)this.getMerchantId()).append("accountId", (Object)this.getAccountId()).append("dUsage", (Object)this.getdUsage()).append("requests", (Object)this.getRequests()).append("traffic", (Object)this.getTraffic()).append("extraTraffic", (Object)this.getExtraTraffic()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

