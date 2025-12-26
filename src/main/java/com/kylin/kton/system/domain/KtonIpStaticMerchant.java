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

public class KtonIpStaticMerchant
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="kton_merchant.id")
    private Long merchantId;
    @Excel(name="\u6700\u540e\u4e0b\u5355\u7684ID")
    private Long lastOrderId;
    @Excel(name="\u6700\u540eIP\u6c60ID")
    private Long lastPoolId;
    @Excel(name="\u7aef\u53e3")
    private String port;
    @Excel(name="ip\u5730\u5740")
    private String ip;
    @Excel(name="\u534f\u8bae")
    private String protocolse;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Excel(name="\u751f\u6548\u65f6\u95f4", width=30.0, dateFormat="yyyy-MM-dd")
    private Date effectiveDatetime;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Excel(name="\u8fc7\u671f\u65f6\u95f4", width=30.0, dateFormat="yyyy-MM-dd")
    private Date expireDatetime;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Excel(name="\u9000\u8ba2\u65f6\u95f4", width=30.0, dateFormat="yyyy-MM-dd")
    private Date unsubscribeTime;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Excel(name="\u8ba2\u8d2d\u65f6\u95f4", width=30.0, dateFormat="yyyy-MM-dd")
    private Date subscribeDatetime;
    @Excel(name="\u72b6\u6001\uff1a0-\u672a\u751f\u6548\uff0c1-\u5df2\u751f\u6548, 2-\u5df2\u8fc7\u671f,3-\u5df2\u9000\u8ba2")
    private Long status;

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

    public void setLastOrderId(Long lastOrderId) {
        this.lastOrderId = lastOrderId;
    }

    public Long getLastOrderId() {
        return this.lastOrderId;
    }

    public void setLastPoolId(Long lastPoolId) {
        this.lastPoolId = lastPoolId;
    }

    public Long getLastPoolId() {
        return this.lastPoolId;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPort() {
        return this.port;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return this.ip;
    }

    public void setProtocolse(String protocolse) {
        this.protocolse = protocolse;
    }

    public String getProtocolse() {
        return this.protocolse;
    }

    public void setEffectiveDatetime(Date effectiveDatetime) {
        this.effectiveDatetime = effectiveDatetime;
    }

    public Date getEffectiveDatetime() {
        return this.effectiveDatetime;
    }

    public void setExpireDatetime(Date expireDatetime) {
        this.expireDatetime = expireDatetime;
    }

    public Date getExpireDatetime() {
        return this.expireDatetime;
    }

    public void setUnsubscribeTime(Date unsubscribeTime) {
        this.unsubscribeTime = unsubscribeTime;
    }

    public Date getUnsubscribeTime() {
        return this.unsubscribeTime;
    }

    public void setSubscribeDatetime(Date subscribeDatetime) {
        this.subscribeDatetime = subscribeDatetime;
    }

    public Date getSubscribeDatetime() {
        return this.subscribeDatetime;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return this.status;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("merchantId", (Object)this.getMerchantId()).append("lastOrderId", (Object)this.getLastOrderId()).append("lastPoolId", (Object)this.getLastPoolId()).append("port", (Object)this.getPort()).append("ip", (Object)this.getIp()).append("protocolse", (Object)this.getProtocolse()).append("effectiveDatetime", (Object)this.getEffectiveDatetime()).append("expireDatetime", (Object)this.getExpireDatetime()).append("unsubscribeTime", (Object)this.getUnsubscribeTime()).append("subscribeDatetime", (Object)this.getSubscribeDatetime()).append("status", (Object)this.getStatus()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

