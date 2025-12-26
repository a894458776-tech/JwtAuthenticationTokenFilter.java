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
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class KtonMerchantConfig
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long merchantConfigId;
    @Excel(name="\u5546\u6237Id")
    private Long merchantId;
    @Excel(name="\u8ba2\u5355\u7b49\u4ed8\u6b3e\u6d88\u606f\u901a\u77e5\u5f00\u5173")
    private Long orderNotifyEnabled;
    @Excel(name="\u6d41\u91cf\u4e0d\u8db3\u63d0\u9192\u5f00\u5173")
    private Long dataUsageNotifyEnabled;
    @Excel(name="\u6d41\u91cf\u4e0d\u8db3\u81ea\u5b9a\u4e49\u503c")
    private Long dataUsageFlowThreshold;
    @Excel(name="\u7cfb\u7edf\u901a\u77e5\u5f00\u5173")
    private Long systemNotifyEnabled;
    @Excel(name="\u662f\u5426\u98ce\u9669\u68c0\u6d4b\u5f00\u5173")
    private Long riskDetectionEnabled;
    @Excel(name="\u98ce\u9669\u68c0\u6d4burl")
    private String riskDetectionBaseUrl;

    public void setMerchantConfigId(Long merchantConfigId) {
        this.merchantConfigId = merchantConfigId;
    }

    public Long getMerchantConfigId() {
        return this.merchantConfigId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getMerchantId() {
        return this.merchantId;
    }

    public void setOrderNotifyEnabled(Long orderNotifyEnabled) {
        this.orderNotifyEnabled = orderNotifyEnabled;
    }

    public Long getOrderNotifyEnabled() {
        return this.orderNotifyEnabled;
    }

    public void setDataUsageNotifyEnabled(Long dataUsageNotifyEnabled) {
        this.dataUsageNotifyEnabled = dataUsageNotifyEnabled;
    }

    public Long getDataUsageNotifyEnabled() {
        return this.dataUsageNotifyEnabled;
    }

    public void setDataUsageFlowThreshold(Long dataUsageFlowThreshold) {
        this.dataUsageFlowThreshold = dataUsageFlowThreshold;
    }

    public Long getDataUsageFlowThreshold() {
        return this.dataUsageFlowThreshold;
    }

    public void setSystemNotifyEnabled(Long systemNotifyEnabled) {
        this.systemNotifyEnabled = systemNotifyEnabled;
    }

    public Long getSystemNotifyEnabled() {
        return this.systemNotifyEnabled;
    }

    public void setRiskDetectionEnabled(Long riskDetectionEnabled) {
        this.riskDetectionEnabled = riskDetectionEnabled;
    }

    public Long getRiskDetectionEnabled() {
        return this.riskDetectionEnabled;
    }

    public void setRiskDetectionBaseUrl(String riskDetectionBaseUrl) {
        this.riskDetectionBaseUrl = riskDetectionBaseUrl;
    }

    public String getRiskDetectionBaseUrl() {
        return this.riskDetectionBaseUrl;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("merchantConfigId", (Object)this.getMerchantConfigId()).append("merchantId", (Object)this.getMerchantId()).append("orderNotifyEnabled", (Object)this.getOrderNotifyEnabled()).append("dataUsageNotifyEnabled", (Object)this.getDataUsageNotifyEnabled()).append("dataUsageFlowThreshold", (Object)this.getDataUsageFlowThreshold()).append("systemNotifyEnabled", (Object)this.getSystemNotifyEnabled()).append("riskDetectionEnabled", (Object)this.getRiskDetectionEnabled()).append("riskDetectionBaseUrl", (Object)this.getRiskDetectionBaseUrl()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

