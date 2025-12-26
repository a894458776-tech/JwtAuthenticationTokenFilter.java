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

public class KtonIpDynamicsAccountUsageDetails
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="kton_merchant.id")
    private Long merchantId;
    @Excel(name="\u6e20\u9053\u65b9\u8bb0\u5f55id")
    private Long accountId;
    @Excel(name="\u4f7f\u7528\u7684\u4e3b\u673a")
    private String host;
    @Excel(name="\u7aef\u53e3")
    private String port;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Excel(name="\u6570\u636e\u65e5\u671f", width=30.0, dateFormat="yyyy-MM-dd")
    private Date dataDatetime;
    @Excel(name="")
    private Long requests;
    @Excel(name="")
    private String traffic;
    @Excel(name="")
    private String extraTraffic;
    @Excel(name="")
    private String status;
    @Excel(name="")
    private String message;

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

    public void setHost(String host) {
        this.host = host;
    }

    public String getHost() {
        return this.host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPort() {
        return this.port;
    }

    public void setDataDatetime(Date dataDatetime) {
        this.dataDatetime = dataDatetime;
    }

    public Date getDataDatetime() {
        return this.dataDatetime;
    }

    public void setRequests(Long requests) {
        this.requests = requests;
    }

    public Long getRequests() {
        return this.requests;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public String getTraffic() {
        return this.traffic;
    }

    public void setExtraTraffic(String extraTraffic) {
        this.extraTraffic = extraTraffic;
    }

    public String getExtraTraffic() {
        return this.extraTraffic;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("merchantId", (Object)this.getMerchantId()).append("accountId", (Object)this.getAccountId()).append("host", (Object)this.getHost()).append("port", (Object)this.getPort()).append("dataDatetime", (Object)this.getDataDatetime()).append("requests", (Object)this.getRequests()).append("traffic", (Object)this.getTraffic()).append("extraTraffic", (Object)this.getExtraTraffic()).append("status", (Object)this.getStatus()).append("message", (Object)this.getMessage()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

