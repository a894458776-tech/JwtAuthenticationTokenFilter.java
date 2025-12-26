/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.kylin.kton.system.domain.KtonIpStaticPoolItem
 *  com.kylin.kton.system.domain.KtonMerchant
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kylin.kton.system.domain.KtonIpStaticPoolItem;
import com.kylin.kton.system.domain.KtonMerchant;
import java.util.Date;
import java.util.List;
import lombok.Generated;

public class AdminIpStaticPoolItemDTO
extends KtonIpStaticPoolItem {
    private Long type;
    private String continent;
    private String merchantIds;
    private String countryCode;
    private String location;
    private String hot;
    private String ip;
    private String port;
    private String account;
    private String password;
    private String protocolse;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date effectiveDatetime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date expireDatetime;
    private Long itemStatus;
    private Long itemId;
    private String sourceId;
    private String sourceCode;
    private String sourceName;
    private List<KtonMerchant> merchant;

    @Generated
    public AdminIpStaticPoolItemDTO() {
    }

    @Generated
    public Long getType() {
        return this.type;
    }

    @Generated
    public String getContinent() {
        return this.continent;
    }

    @Generated
    public String getMerchantIds() {
        return this.merchantIds;
    }

    @Generated
    public String getCountryCode() {
        return this.countryCode;
    }

    @Generated
    public String getLocation() {
        return this.location;
    }

    @Generated
    public String getHot() {
        return this.hot;
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
    public List<KtonMerchant> getMerchant() {
        return this.merchant;
    }

    @Generated
    public void setType(Long type) {
        this.type = type;
    }

    @Generated
    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Generated
    public void setMerchantIds(String merchantIds) {
        this.merchantIds = merchantIds;
    }

    @Generated
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Generated
    public void setLocation(String location) {
        this.location = location;
    }

    @Generated
    public void setHot(String hot) {
        this.hot = hot;
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
    public void setMerchant(List<KtonMerchant> merchant) {
        this.merchant = merchant;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminIpStaticPoolItemDTO)) {
            return false;
        }
        AdminIpStaticPoolItemDTO other = (AdminIpStaticPoolItemDTO)((Object)o);
        if (!other.canEqual((Object)this)) {
            return false;
        }
        Long this$type = this.getType();
        Long other$type = other.getType();
        if (this$type == null ? other$type != null : !((Object)this$type).equals(other$type)) {
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
        String this$continent = this.getContinent();
        String other$continent = other.getContinent();
        if (this$continent == null ? other$continent != null : !this$continent.equals(other$continent)) {
            return false;
        }
        String this$merchantIds = this.getMerchantIds();
        String other$merchantIds = other.getMerchantIds();
        if (this$merchantIds == null ? other$merchantIds != null : !this$merchantIds.equals(other$merchantIds)) {
            return false;
        }
        String this$countryCode = this.getCountryCode();
        String other$countryCode = other.getCountryCode();
        if (this$countryCode == null ? other$countryCode != null : !this$countryCode.equals(other$countryCode)) {
            return false;
        }
        String this$location = this.getLocation();
        String other$location = other.getLocation();
        if (this$location == null ? other$location != null : !this$location.equals(other$location)) {
            return false;
        }
        String this$hot = this.getHot();
        String other$hot = other.getHot();
        if (this$hot == null ? other$hot != null : !this$hot.equals(other$hot)) {
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
        if (this$expireDatetime == null ? other$expireDatetime != null : !((Object)this$expireDatetime).equals(other$expireDatetime)) {
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
        List<KtonMerchant> this$merchant = this.getMerchant();
        List<KtonMerchant> other$merchant = other.getMerchant();
        return !(this$merchant == null ? other$merchant != null : !((Object)this$merchant).equals(other$merchant));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminIpStaticPoolItemDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $type = this.getType();
        result = result * 59 + ($type == null ? 43 : ((Object)$type).hashCode());
        Long $itemStatus = this.getItemStatus();
        result = result * 59 + ($itemStatus == null ? 43 : ((Object)$itemStatus).hashCode());
        Long $itemId = this.getItemId();
        result = result * 59 + ($itemId == null ? 43 : ((Object)$itemId).hashCode());
        String $continent = this.getContinent();
        result = result * 59 + ($continent == null ? 43 : $continent.hashCode());
        String $merchantIds = this.getMerchantIds();
        result = result * 59 + ($merchantIds == null ? 43 : $merchantIds.hashCode());
        String $countryCode = this.getCountryCode();
        result = result * 59 + ($countryCode == null ? 43 : $countryCode.hashCode());
        String $location = this.getLocation();
        result = result * 59 + ($location == null ? 43 : $location.hashCode());
        String $hot = this.getHot();
        result = result * 59 + ($hot == null ? 43 : $hot.hashCode());
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
        String $sourceId = this.getSourceId();
        result = result * 59 + ($sourceId == null ? 43 : $sourceId.hashCode());
        String $sourceCode = this.getSourceCode();
        result = result * 59 + ($sourceCode == null ? 43 : $sourceCode.hashCode());
        String $sourceName = this.getSourceName();
        result = result * 59 + ($sourceName == null ? 43 : $sourceName.hashCode());
        List<KtonMerchant> $merchant = this.getMerchant();
        result = result * 59 + ($merchant == null ? 43 : ((Object)$merchant).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminIpStaticPoolItemDTO(type=" + this.getType() + ", continent=" + this.getContinent() + ", merchantIds=" + this.getMerchantIds() + ", countryCode=" + this.getCountryCode() + ", location=" + this.getLocation() + ", hot=" + this.getHot() + ", ip=" + this.getIp() + ", port=" + this.getPort() + ", account=" + this.getAccount() + ", password=" + this.getPassword() + ", protocolse=" + this.getProtocolse() + ", effectiveDatetime=" + this.getEffectiveDatetime() + ", expireDatetime=" + this.getExpireDatetime() + ", itemStatus=" + this.getItemStatus() + ", itemId=" + this.getItemId() + ", sourceId=" + this.getSourceId() + ", sourceCode=" + this.getSourceCode() + ", sourceName=" + this.getSourceName() + ", merchant=" + this.getMerchant() + ")";
    }
}

