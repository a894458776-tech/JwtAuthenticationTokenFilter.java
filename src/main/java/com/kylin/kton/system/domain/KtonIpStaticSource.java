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

public class KtonIpStaticSource
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="\u4f9b\u5e94\u5546\u6765\u6e90")
    private Long sourceId;
    @Excel(name="ip\u5730\u5740")
    private String ip;
    @Excel(name="\u7aef\u53e3")
    private String port;
    @Excel(name="\u8d26\u53f7")
    private String account;
    @Excel(name="\u5bc6\u7801")
    private String password;
    @Excel(name="\u534f\u8bae")
    private String protocolse;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Excel(name="\u751f\u6548\u65f6\u95f4", width=30.0, dateFormat="yyyy-MM-dd")
    private Date effectiveDatetime;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Excel(name="\u8fc7\u671f\u65f6\u95f4", width=30.0, dateFormat="yyyy-MM-dd")
    private Date expireDatetime;
    @Excel(name="\u5206\u914d\u6b21\u6570")
    private Long assignTimes;
    @Excel(name="\u72b6\u6001\uff1a0-\u6b63\u5e38, 2-\u5df2\u8fc7\u671f")
    private Long status;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getSourceId() {
        return this.sourceId;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return this.ip;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPort() {
        return this.port;
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

    public void setAssignTimes(Long assignTimes) {
        this.assignTimes = assignTimes;
    }

    public Long getAssignTimes() {
        return this.assignTimes;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return this.status;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("sourceId", (Object)this.getSourceId()).append("ip", (Object)this.getIp()).append("port", (Object)this.getPort()).append("account", (Object)this.getAccount()).append("password", (Object)this.getPassword()).append("protocolse", (Object)this.getProtocolse()).append("effectiveDatetime", (Object)this.getEffectiveDatetime()).append("expireDatetime", (Object)this.getExpireDatetime()).append("assignTimes", (Object)this.getAssignTimes()).append("status", (Object)this.getStatus()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

