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

public class KtonIpDynamicsAccountEndpoint
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="\u5546\u6237ID")
    private Long merchantId;
    @Excel(name="")
    private Long accountId;
    @Excel(name="\u63a5\u5165\u70b9\u670d\u52a1\u5668")
    private String endpointHost;
    @Excel(name="\u63a5\u5165\u70b9\u7aef\u53e3")
    private Long endpointPort;
    @Excel(name="\u901a\u9053\u72b6\u6001 0:\u672a\u542f\u7528\uff0c1\uff1a\u5df2\u542f\u7528")
    private Long endpointStatus;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Excel(name="\u8fc7\u671f\u65f6\u95f4", width=30.0, dateFormat="yyyy-MM-dd HH:mm:ss")
    private Date expireTime;
    @Excel(name="\u5df2\u7528\u6d41\u91cf")
    private BigDecimal useTrafficGb;
    @Excel(name="\u9650\u5236\u6d41\u91cf")
    private BigDecimal limitTrafficGb;
    @Excel(name="\u534f\u8bae\u65b9\u5f0f")
    private String supportedProtocol;
    @Excel(name="\u5907\u6ce8")
    private String remarks;

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

    public void setEndpointHost(String endpointHost) {
        this.endpointHost = endpointHost;
    }

    public String getEndpointHost() {
        return this.endpointHost;
    }

    public void setEndpointPort(Long endpointPort) {
        this.endpointPort = endpointPort;
    }

    public Long getEndpointPort() {
        return this.endpointPort;
    }

    public void setEndpointStatus(Long endpointStatus) {
        this.endpointStatus = endpointStatus;
    }

    public Long getEndpointStatus() {
        return this.endpointStatus;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getExpireTime() {
        return this.expireTime;
    }

    public void setUseTrafficGb(BigDecimal useTrafficGb) {
        this.useTrafficGb = useTrafficGb;
    }

    public BigDecimal getUseTrafficGb() {
        return this.useTrafficGb;
    }

    public void setLimitTrafficGb(BigDecimal limitTrafficGb) {
        this.limitTrafficGb = limitTrafficGb;
    }

    public BigDecimal getLimitTrafficGb() {
        return this.limitTrafficGb;
    }

    public void setSupportedProtocol(String supportedProtocol) {
        this.supportedProtocol = supportedProtocol;
    }

    public String getSupportedProtocol() {
        return this.supportedProtocol;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("merchantId", (Object)this.getMerchantId()).append("accountId", (Object)this.getAccountId()).append("endpointHost", (Object)this.getEndpointHost()).append("endpointPort", (Object)this.getEndpointPort()).append("endpointStatus", (Object)this.getEndpointStatus()).append("expireTime", (Object)this.getExpireTime()).append("useTrafficGb", (Object)this.getUseTrafficGb()).append("limitTrafficGb", (Object)this.getLimitTrafficGb()).append("supportedProtocol", (Object)this.getSupportedProtocol()).append("remarks", (Object)this.getRemarks()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

