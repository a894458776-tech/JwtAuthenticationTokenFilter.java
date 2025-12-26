/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.kylin.kton.common.annotation.Excel
 *  com.kylin.kton.system.domain.KtonIpStaticPoolItem
 *  lombok.Generated
 */
package com.kylin.kton.client.ip.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kylin.kton.common.annotation.Excel;
import com.kylin.kton.system.domain.KtonIpStaticPoolItem;
import java.util.Date;
import lombok.Generated;

public class ClientIpStaticPoolItemDTO
extends KtonIpStaticPoolItem {
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Excel(name="\u751f\u6548\u65f6\u95f4", width=30.0, dateFormat="yyyy-MM-dd HH:mm:ss")
    private Date effectiveDatetime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Excel(name="\u8fc7\u671f\u65f6\u95f4", width=30.0, dateFormat="yyyy-MM-dd HH:mm:ss")
    private Date expireDatetime;
    private Integer assignTimes;

    @Generated
    public ClientIpStaticPoolItemDTO() {
    }

    @Generated
    public Long getSourceId() {
        return this.sourceId;
    }

    @Generated
    public String getIp() {
        return this.ip;
    }

    @Generated
    public String getPort() {
        return this.port;
    }

    @Generated
    public String getAccount() {
        return this.account;
    }

    @Generated
    public String getPassword() {
        return this.password;
    }

    @Generated
    public String getProtocolse() {
        return this.protocolse;
    }

    @Generated
    public Date getEffectiveDatetime() {
        return this.effectiveDatetime;
    }

    @Generated
    public Date getExpireDatetime() {
        return this.expireDatetime;
    }

    @Generated
    public Integer getAssignTimes() {
        return this.assignTimes;
    }

    @Generated
    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    @Generated
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Generated
    public void setPort(String port) {
        this.port = port;
    }

    @Generated
    public void setAccount(String account) {
        this.account = account;
    }

    @Generated
    public void setPassword(String password) {
        this.password = password;
    }

    @Generated
    public void setProtocolse(String protocolse) {
        this.protocolse = protocolse;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Generated
    public void setEffectiveDatetime(Date effectiveDatetime) {
        this.effectiveDatetime = effectiveDatetime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Generated
    public void setExpireDatetime(Date expireDatetime) {
        this.expireDatetime = expireDatetime;
    }

    @Generated
    public void setAssignTimes(Integer assignTimes) {
        this.assignTimes = assignTimes;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ClientIpStaticPoolItemDTO)) {
            return false;
        }
        ClientIpStaticPoolItemDTO other = (ClientIpStaticPoolItemDTO)((Object)o);
        if (!other.canEqual((Object)this)) {
            return false;
        }
        Long this$sourceId = this.getSourceId();
        Long other$sourceId = other.getSourceId();
        if (this$sourceId == null ? other$sourceId != null : !((Object)this$sourceId).equals(other$sourceId)) {
            return false;
        }
        Integer this$assignTimes = this.getAssignTimes();
        Integer other$assignTimes = other.getAssignTimes();
        if (this$assignTimes == null ? other$assignTimes != null : !((Object)this$assignTimes).equals(other$assignTimes)) {
            return false;
        }
        String this$ip = this.getIp();
        String other$ip = other.getIp();
        if (this$ip == null ? other$ip != null : !this$ip.equals(other$ip)) {
            return false;
        }
        String this$port = this.getPort();
        String other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
            return false;
        }
        String this$account = this.getAccount();
        String other$account = other.getAccount();
        if (this$account == null ? other$account != null : !this$account.equals(other$account)) {
            return false;
        }
        String this$password = this.getPassword();
        String other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) {
            return false;
        }
        String this$protocolse = this.getProtocolse();
        String other$protocolse = other.getProtocolse();
        if (this$protocolse == null ? other$protocolse != null : !this$protocolse.equals(other$protocolse)) {
            return false;
        }
        Date this$effectiveDatetime = this.getEffectiveDatetime();
        Date other$effectiveDatetime = other.getEffectiveDatetime();
        if (this$effectiveDatetime == null ? other$effectiveDatetime != null : !((Object)this$effectiveDatetime).equals(other$effectiveDatetime)) {
            return false;
        }
        Date this$expireDatetime = this.getExpireDatetime();
        Date other$expireDatetime = other.getExpireDatetime();
        return !(this$expireDatetime == null ? other$expireDatetime != null : !((Object)this$expireDatetime).equals(other$expireDatetime));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ClientIpStaticPoolItemDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $sourceId = this.getSourceId();
        result = result * 59 + ($sourceId == null ? 43 : ((Object)$sourceId).hashCode());
        Integer $assignTimes = this.getAssignTimes();
        result = result * 59 + ($assignTimes == null ? 43 : ((Object)$assignTimes).hashCode());
        String $ip = this.getIp();
        result = result * 59 + ($ip == null ? 43 : $ip.hashCode());
        String $port = this.getPort();
        result = result * 59 + ($port == null ? 43 : $port.hashCode());
        String $account = this.getAccount();
        result = result * 59 + ($account == null ? 43 : $account.hashCode());
        String $password = this.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        String $protocolse = this.getProtocolse();
        result = result * 59 + ($protocolse == null ? 43 : $protocolse.hashCode());
        Date $effectiveDatetime = this.getEffectiveDatetime();
        result = result * 59 + ($effectiveDatetime == null ? 43 : ((Object)$effectiveDatetime).hashCode());
        Date $expireDatetime = this.getExpireDatetime();
        result = result * 59 + ($expireDatetime == null ? 43 : ((Object)$expireDatetime).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ClientIpStaticPoolItemDTO(sourceId=" + this.getSourceId() + ", ip=" + this.getIp() + ", port=" + this.getPort() + ", account=" + this.getAccount() + ", password=" + this.getPassword() + ", protocolse=" + this.getProtocolse() + ", effectiveDatetime=" + this.getEffectiveDatetime() + ", expireDatetime=" + this.getExpireDatetime() + ", assignTimes=" + this.getAssignTimes() + ")";
    }
}

