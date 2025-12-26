/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Generated;

public class AdminAddByIpPatternVO {
    private Long sourceId;
    private String ipPattern;
    private String port;
    private String account;
    private String password;
    private String protocolse;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date effectiveDatetime;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date expireDatetime;

    @Generated
    public AdminAddByIpPatternVO() {
    }

    @Generated
    public Long getSourceId() {
        return this.sourceId;
    }

    @Generated
    public String getIpPattern() {
        return this.ipPattern;
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
    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    @Generated
    public void setIpPattern(String ipPattern) {
        this.ipPattern = ipPattern;
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

    @JsonFormat(pattern="yyyy-MM-dd")
    @Generated
    public void setEffectiveDatetime(Date effectiveDatetime) {
        this.effectiveDatetime = effectiveDatetime;
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    @Generated
    public void setExpireDatetime(Date expireDatetime) {
        this.expireDatetime = expireDatetime;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminAddByIpPatternVO)) {
            return false;
        }
        AdminAddByIpPatternVO other = (AdminAddByIpPatternVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$sourceId = this.getSourceId();
        Long other$sourceId = other.getSourceId();
        if (this$sourceId == null ? other$sourceId != null : !((Object)this$sourceId).equals(other$sourceId)) {
            return false;
        }
        String this$ipPattern = this.getIpPattern();
        String other$ipPattern = other.getIpPattern();
        if (this$ipPattern == null ? other$ipPattern != null : !this$ipPattern.equals(other$ipPattern)) {
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
        return other instanceof AdminAddByIpPatternVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $sourceId = this.getSourceId();
        result = result * 59 + ($sourceId == null ? 43 : ((Object)$sourceId).hashCode());
        String $ipPattern = this.getIpPattern();
        result = result * 59 + ($ipPattern == null ? 43 : $ipPattern.hashCode());
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
        return "AdminAddByIpPatternVO(sourceId=" + this.getSourceId() + ", ipPattern=" + this.getIpPattern() + ", port=" + this.getPort() + ", account=" + this.getAccount() + ", password=" + this.getPassword() + ", protocolse=" + this.getProtocolse() + ", effectiveDatetime=" + this.getEffectiveDatetime() + ", expireDatetime=" + this.getExpireDatetime() + ")";
    }
}

