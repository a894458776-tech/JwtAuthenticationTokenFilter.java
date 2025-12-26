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

public class KtonIpDynamicsAccount
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="kton_merchant.id")
    private Long merchantId;
    @Excel(name="\u6e20\u9053\u65b9\u8bb0\u5f55id")
    private Long accountId;
    @Excel(name="\u6765\u6e90\u7f16\u7801\uff1adataimpulse")
    private Long sourceId;
    @Excel(name="\u6807\u7b7e\u540d\u79f0")
    private String label;
    @Excel(name="\u6e20\u9053\u65b9\u6807\u7b7e\u540d\u79f0")
    private String channelLabel;
    @Excel(name="\u72b6\u6001\uff1apending: \u5f85\u4e0b\u53d1\uff0cactive\uff1a\u5df2\u4e0b\u53d1")
    private String status;
    @Excel(name="\u7c7b\u578b:datacenter\uff0cresidential,mobile")
    private String poolType;
    @Excel(name="\u90ae\u7bb1")
    private String email;
    @Excel(name="\u8d26\u53f7")
    private String account;
    @Excel(name="\u5bc6\u7801")
    private String password;
    @Excel(name="\u7ebf\u7a0b\uff0c\t", readConverterExp="\u5b50=\u7528\u6237\u7684\u7ebf\u7a0b\u6570\uff08\u6700\u5927\u503c2000")
    private Long threads;
    @Excel(name="\u7c98\u6027\u8303\u56f4\uff0c\u6307\u5b9a\u7c98\u6027\u8303\u56f4\u7684\u5bf9\u8c61\uff0c\u8d77\u59cb\uff1a\u6700\u5c0f\u503c\uff1a10000\uff0c\u6700\u5927\u503c\uff1a30000")
    private Long stickyRangeStart;
    @Excel(name="\u7c98\u6027\u8303\u56f4\uff0c\u6307\u5b9a\u7c98\u6027\u8303\u56f4\u7684\u5bf9\u8c61\uff0c\u7ed3\u675f\uff1a\u6700\u5c0f\u503c\uff1a10000\uff0c\u6700\u5927\u503c\uff1a30000")
    private Long stickyRangeEnd;
    @Excel(name="\u5c4f\u853d\u72b6\u6001 ", readConverterExp="t=rue|false")
    private String blocked;
    @Excel(name="\u5df2\u5c4f\u853d\u7684\u57df\u540d")
    private String blockedHosts;
    @Excel(name="\u9ed8\u8ba4\u6c60\u53c2\u6570,\u56fd\u5bb6")
    private String defaultPoolParametersCountries;
    @Excel(name="\u9ed8\u8ba4\u6c60\u53c2\u6570,\u57ce\u5e02")
    private String defaultPoolParametersCities;
    @Excel(name="\u9ed8\u8ba4\u6c60\u53c2\u6570,\u5dde")
    private String defaultPoolParametersStates;
    @Excel(name="\u9ed8\u8ba4\u6c60\u53c2\u6570,\u90ae\u7f16")
    private String defaultPoolParametersZipcodes;
    @Excel(name="\u9ed8\u8ba4\u6c60\u53c2\u6570,\u652f\u6301\u4ee3\u7801")
    private String defaultPoolParametersAsns;
    @Excel(name="\u9ed8\u8ba4\u6c60\u53c2\u6570,\u6392\u9664\u7684\u56fd\u5bb6")
    private String defaultPoolParametersExcludeCountries;
    @Excel(name="\u9ed8\u8ba4\u6c60\u53c2\u6570,\u6392\u9664\u7684\u652f\u6301\u4ee3\u7801")
    private String defaultPoolParametersExcludeAsn;
    @Excel(name="\u9ed8\u8ba4\u6c60\u53c2\u6570,\u533f\u540d\u8fc7\u6ee4\u5668(\u5e03\u5c14\u503c\uff0c\u6307\u793a\u662f\u5426\u5e94\u7528\u533f\u540d\u8fc7\u6ee4)")
    private String defaultPoolParametersAnonymousFilter;
    @Excel(name="\u9ed8\u8ba4\u6c60\u53c2\u6570,\u6307\u5b9a\u7c98\u6027\u8fde\u63a5\u7684\u8f6e\u6362\u95f4\u9694\uff0c\u4ee5\u5206\u949f\u4e3a\u5355\u4f4d\uff0c\u6700\u5c0f\u503c\u4e3a 1\uff0c\u6700\u5927\u503c\u4e3a 120\u3002")
    private String defaultPoolParametersRotationInterval;
    @Excel(name="\u6d41\u91cf\u9650\u5236")
    private BigDecimal trafficLimit;
    @Excel(name="\u9ed8\u8ba4\u63a5\u5165\u70b9HOST")
    private String defaultEndpointHost;
    @Excel(name="\u9ed8\u8ba4\u63a5\u5165\u70b9PORT")
    private String defaultEndpointPort;
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

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getSourceId() {
        return this.sourceId;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public void setChannelLabel(String channelLabel) {
        this.channelLabel = channelLabel;
    }

    public String getChannelLabel() {
        return this.channelLabel;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setPoolType(String poolType) {
        this.poolType = poolType;
    }

    public String getPoolType() {
        return this.poolType;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return this.account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setThreads(Long threads) {
        this.threads = threads;
    }

    public Long getThreads() {
        return this.threads;
    }

    public void setStickyRangeStart(Long stickyRangeStart) {
        this.stickyRangeStart = stickyRangeStart;
    }

    public Long getStickyRangeStart() {
        return this.stickyRangeStart;
    }

    public void setStickyRangeEnd(Long stickyRangeEnd) {
        this.stickyRangeEnd = stickyRangeEnd;
    }

    public Long getStickyRangeEnd() {
        return this.stickyRangeEnd;
    }

    public void setBlocked(String blocked) {
        this.blocked = blocked;
    }

    public String getBlocked() {
        return this.blocked;
    }

    public void setBlockedHosts(String blockedHosts) {
        this.blockedHosts = blockedHosts;
    }

    public String getBlockedHosts() {
        return this.blockedHosts;
    }

    public void setDefaultPoolParametersCountries(String defaultPoolParametersCountries) {
        this.defaultPoolParametersCountries = defaultPoolParametersCountries;
    }

    public String getDefaultPoolParametersCountries() {
        return this.defaultPoolParametersCountries;
    }

    public void setDefaultPoolParametersCities(String defaultPoolParametersCities) {
        this.defaultPoolParametersCities = defaultPoolParametersCities;
    }

    public String getDefaultPoolParametersCities() {
        return this.defaultPoolParametersCities;
    }

    public void setDefaultPoolParametersStates(String defaultPoolParametersStates) {
        this.defaultPoolParametersStates = defaultPoolParametersStates;
    }

    public String getDefaultPoolParametersStates() {
        return this.defaultPoolParametersStates;
    }

    public void setDefaultPoolParametersZipcodes(String defaultPoolParametersZipcodes) {
        this.defaultPoolParametersZipcodes = defaultPoolParametersZipcodes;
    }

    public String getDefaultPoolParametersZipcodes() {
        return this.defaultPoolParametersZipcodes;
    }

    public void setDefaultPoolParametersAsns(String defaultPoolParametersAsns) {
        this.defaultPoolParametersAsns = defaultPoolParametersAsns;
    }

    public String getDefaultPoolParametersAsns() {
        return this.defaultPoolParametersAsns;
    }

    public void setDefaultPoolParametersExcludeCountries(String defaultPoolParametersExcludeCountries) {
        this.defaultPoolParametersExcludeCountries = defaultPoolParametersExcludeCountries;
    }

    public String getDefaultPoolParametersExcludeCountries() {
        return this.defaultPoolParametersExcludeCountries;
    }

    public void setDefaultPoolParametersExcludeAsn(String defaultPoolParametersExcludeAsn) {
        this.defaultPoolParametersExcludeAsn = defaultPoolParametersExcludeAsn;
    }

    public String getDefaultPoolParametersExcludeAsn() {
        return this.defaultPoolParametersExcludeAsn;
    }

    public void setDefaultPoolParametersAnonymousFilter(String defaultPoolParametersAnonymousFilter) {
        this.defaultPoolParametersAnonymousFilter = defaultPoolParametersAnonymousFilter;
    }

    public String getDefaultPoolParametersAnonymousFilter() {
        return this.defaultPoolParametersAnonymousFilter;
    }

    public void setDefaultPoolParametersRotationInterval(String defaultPoolParametersRotationInterval) {
        this.defaultPoolParametersRotationInterval = defaultPoolParametersRotationInterval;
    }

    public String getDefaultPoolParametersRotationInterval() {
        return this.defaultPoolParametersRotationInterval;
    }

    public void setTrafficLimit(BigDecimal trafficLimit) {
        this.trafficLimit = trafficLimit;
    }

    public BigDecimal getTrafficLimit() {
        return this.trafficLimit;
    }

    public void setDefaultEndpointHost(String defaultEndpointHost) {
        this.defaultEndpointHost = defaultEndpointHost;
    }

    public String getDefaultEndpointHost() {
        return this.defaultEndpointHost;
    }

    public void setDefaultEndpointPort(String defaultEndpointPort) {
        this.defaultEndpointPort = defaultEndpointPort;
    }

    public String getDefaultEndpointPort() {
        return this.defaultEndpointPort;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("merchantId", (Object)this.getMerchantId()).append("accountId", (Object)this.getAccountId()).append("sourceId", (Object)this.getSourceId()).append("label", (Object)this.getLabel()).append("channelLabel", (Object)this.getChannelLabel()).append("status", (Object)this.getStatus()).append("poolType", (Object)this.getPoolType()).append("email", (Object)this.getEmail()).append("account", (Object)this.getAccount()).append("password", (Object)this.getPassword()).append("threads", (Object)this.getThreads()).append("stickyRangeStart", (Object)this.getStickyRangeStart()).append("stickyRangeEnd", (Object)this.getStickyRangeEnd()).append("blocked", (Object)this.getBlocked()).append("blockedHosts", (Object)this.getBlockedHosts()).append("defaultPoolParametersCountries", (Object)this.getDefaultPoolParametersCountries()).append("defaultPoolParametersCities", (Object)this.getDefaultPoolParametersCities()).append("defaultPoolParametersStates", (Object)this.getDefaultPoolParametersStates()).append("defaultPoolParametersZipcodes", (Object)this.getDefaultPoolParametersZipcodes()).append("defaultPoolParametersAsns", (Object)this.getDefaultPoolParametersAsns()).append("defaultPoolParametersExcludeCountries", (Object)this.getDefaultPoolParametersExcludeCountries()).append("defaultPoolParametersExcludeAsn", (Object)this.getDefaultPoolParametersExcludeAsn()).append("defaultPoolParametersAnonymousFilter", (Object)this.getDefaultPoolParametersAnonymousFilter()).append("defaultPoolParametersRotationInterval", (Object)this.getDefaultPoolParametersRotationInterval()).append("trafficLimit", (Object)this.getTrafficLimit()).append("defaultEndpointHost", (Object)this.getDefaultEndpointHost()).append("defaultEndpointPort", (Object)this.getDefaultEndpointPort()).append("remarks", (Object)this.getRemarks()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

