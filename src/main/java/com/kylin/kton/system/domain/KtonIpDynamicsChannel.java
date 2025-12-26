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

public class KtonIpDynamicsChannel
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="\u5546\u6237ID")
    private Long merchantId;
    @Excel(name="\u901a\u9053\u72b6\u6001")
    private Long channelStatus;
    @Excel(name="")
    private String channelName;
    @Excel(name="")
    private String channelPassword;
    @Excel(name="\u5df2\u7528\u6d41\u91cf")
    private BigDecimal useTrafficGb;
    @Excel(name="\u9650\u5236\u6d41\u91cf")
    private BigDecimal limitTrafficGb;
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

    public void setChannelStatus(Long channelStatus) {
        this.channelStatus = channelStatus;
    }

    public Long getChannelStatus() {
        return this.channelStatus;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public void setChannelPassword(String channelPassword) {
        this.channelPassword = channelPassword;
    }

    public String getChannelPassword() {
        return this.channelPassword;
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

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("merchantId", (Object)this.getMerchantId()).append("channelStatus", (Object)this.getChannelStatus()).append("channelName", (Object)this.getChannelName()).append("channelPassword", (Object)this.getChannelPassword()).append("useTrafficGb", (Object)this.getUseTrafficGb()).append("limitTrafficGb", (Object)this.getLimitTrafficGb()).append("remarks", (Object)this.getRemarks()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

