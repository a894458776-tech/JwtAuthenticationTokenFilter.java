/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.kylin.kton.system.domain.KtonIpStaticPoolItem
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kylin.kton.system.domain.KtonIpStaticPoolItem;
import java.util.Date;
import lombok.Generated;

public class AdminIpStaticPoolItemInfoDTO
extends KtonIpStaticPoolItem {
    private Long id;
    private Long itemStatus;
    private Long itemId;
    private String sourceId;
    private String sourceCode;
    private String sourceName;
    private String ip;
    private String port;
    private String account;
    private String password;
    private String protocolse;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date effectiveDatetime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date expireDatetime;
    private Long status;

    @Generated
    public AdminIpStaticPoolItemInfoDTO() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public Long getItemStatus() {
        return this.itemStatus;
    }

    @Generated
    public Long getItemId() {
        return this.itemId;
    }

    @Generated
    public String getSourceId() {
        return this.sourceId;
    }

    @Generated
    public String getSourceCode() {
        return this.sourceCode;
    }

    @Generated
    public String getSourceName() {
        return this.sourceName;
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
    public Long getStatus() {
        return this.status;
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setItemStatus(Long itemStatus) {
        this.itemStatus = itemStatus;
    }

    @Generated
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @Generated
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    @Generated
    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    @Generated
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
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
    public void setStatus(Long status) {
        this.status = status;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminIpStaticPoolItemInfoDTO)) {
            return false;
        }
        AdminIpStaticPoolItemInfoDTO other = (AdminIpStaticPoolItemInfoDTO)((Object)o);
        if (!other.canEqual((Object)this)) {
            return false;
        }
        Long this$id = this.getId();
        Long other$id = other.getId();
        if (this$id == null ? other$id != null : !((Object)this$id).equals(other$id)) {
            return false;
        }
        Long this$itemStatus = this.getItemStatus();
        Long other$itemStatus = other.getItemStatus();
        if (this$itemStatus == null ? other$itemStatus != null : !((Object)this$itemStatus).equals(other$itemStatus)) {
            return false;
        }
        Long this$itemId = this.getItemId();
        Long other$itemId = other.getItemId();
        if (this$itemId == null ? other$itemId != null : !((Object)this$itemId).equals(other$itemId)) {
            return false;
        }
        Long this$status = this.getStatus();
        Long other$status = other.getStatus();
        if (this$status == null ? other$status != null : !((Object)this$status).equals(other$status)) {
            return false;
        }
        String this$sourceId = this.getSourceId();
        String other$sourceId = other.getSourceId();
        if (this$sourceId == null ? other$sourceId != null : !this$sourceId.equals(other$sourceId)) {
            return false;
        }
        String this$sourceCode = this.getSourceCode();
        String other$sourceCode = other.getSourceCode();
        if (this$sourceCode == null ? other$sourceCode != null : !this$sourceCode.equals(other$sourceCode)) {
            return false;
        }
        String this$sourceName = this.getSourceName();
        String other$sourceName = other.getSourceName();
        if (this$sourceName == null ? other$sourceName != null : !this$sourceName.equals(other$sourceName)) {
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
        return other instanceof AdminIpStaticPoolItemInfoDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $id = this.getId();
        result = result * 59 + ($id == null ? 43 : ((Object)$id).hashCode());
        Long $itemStatus = this.getItemStatus();
        result = result * 59 + ($itemStatus == null ? 43 : ((Object)$itemStatus).hashCode());
        Long $itemId = this.getItemId();
        result = result * 59 + ($itemId == null ? 43 : ((Object)$itemId).hashCode());
        Long $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : ((Object)$status).hashCode());
        String $sourceId = this.getSourceId();
        result = result * 59 + ($sourceId == null ? 43 : $sourceId.hashCode());
        String $sourceCode = this.getSourceCode();
        result = result * 59 + ($sourceCode == null ? 43 : $sourceCode.hashCode());
        String $sourceName = this.getSourceName();
        result = result * 59 + ($sourceName == null ? 43 : $sourceName.hashCode());
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
        return "AdminIpStaticPoolItemInfoDTO(id=" + this.getId() + ", itemStatus=" + this.getItemStatus() + ", itemId=" + this.getItemId() + ", sourceId=" + this.getSourceId() + ", sourceCode=" + this.getSourceCode() + ", sourceName=" + this.getSourceName() + ", ip=" + this.getIp() + ", port=" + this.getPort() + ", account=" + this.getAccount() + ", password=" + this.getPassword() + ", protocolse=" + this.getProtocolse() + ", effectiveDatetime=" + this.getEffectiveDatetime() + ", expireDatetime=" + this.getExpireDatetime() + ", status=" + this.getStatus() + ")";
    }
}

