/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.kylin.kton.common.annotation.Excel
 *  com.kylin.kton.system.domain.KtonIpStaticMerchant
 *  lombok.Generated
 */
package com.kylin.kton.client.ip.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kylin.kton.common.annotation.Excel;
import com.kylin.kton.system.domain.KtonIpStaticMerchant;
import java.util.Date;
import lombok.Generated;

public class ClientIpStaticPoolMerchantDTO
extends KtonIpStaticMerchant {
    private Long id;
    private Long poolId;
    private Long merchantId;
    private String account;
    private String password;
    private String port;
    private String ip;
    private String protocolse;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date effectiveDatetime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date expireDatetime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date unsubscribeTime;
    private Long status;
    @Excel(name=" \u7c7b\u578b:1-\u666e\u901a\uff0c2-\u9ad8\u7ea7")
    private Long type;
    private String continent;
    private String countryCode;
    private String location;
    private String hot;

    @Generated
    public ClientIpStaticPoolMerchantDTO() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public Long getPoolId() {
        return this.poolId;
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
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
    public String getPort() {
        return this.port;
    }

    @Generated
    public String getIp() {
        return this.ip;
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
    public Date getUnsubscribeTime() {
        return this.unsubscribeTime;
    }

    @Generated
    public Long getStatus() {
        return this.status;
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
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
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
    public void setPort(String port) {
        this.port = port;
    }

    @Generated
    public void setIp(String ip) {
        this.ip = ip;
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

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Generated
    public void setUnsubscribeTime(Date unsubscribeTime) {
        this.unsubscribeTime = unsubscribeTime;
    }

    @Generated
    public void setStatus(Long status) {
        this.status = status;
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
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ClientIpStaticPoolMerchantDTO)) {
            return false;
        }
        ClientIpStaticPoolMerchantDTO other = (ClientIpStaticPoolMerchantDTO)((Object)o);
        if (!other.canEqual((Object)this)) {
            return false;
        }
        Long this$id = this.getId();
        Long other$id = other.getId();
        if (this$id == null ? other$id != null : !((Object)this$id).equals(other$id)) {
            return false;
        }
        Long this$poolId = this.getPoolId();
        Long other$poolId = other.getPoolId();
        if (this$poolId == null ? other$poolId != null : !((Object)this$poolId).equals(other$poolId)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        Long this$status = this.getStatus();
        Long other$status = other.getStatus();
        if (this$status == null ? other$status != null : !((Object)this$status).equals(other$status)) {
            return false;
        }
        Long this$type = this.getType();
        Long other$type = other.getType();
        if (this$type == null ? other$type != null : !((Object)this$type).equals(other$type)) {
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
        String this$port = this.getPort();
        String other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
            return false;
        }
        String this$ip = this.getIp();
        String other$ip = other.getIp();
        if (this$ip == null ? other$ip != null : !this$ip.equals(other$ip)) {
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
        Date this$unsubscribeTime = this.getUnsubscribeTime();
        Date other$unsubscribeTime = other.getUnsubscribeTime();
        if (this$unsubscribeTime == null ? other$unsubscribeTime != null : !((Object)this$unsubscribeTime).equals(other$unsubscribeTime)) {
            return false;
        }
        String this$continent = this.getContinent();
        String other$continent = other.getContinent();
        if (this$continent == null ? other$continent != null : !this$continent.equals(other$continent)) {
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
        return !(this$hot == null ? other$hot != null : !this$hot.equals(other$hot));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ClientIpStaticPoolMerchantDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $id = this.getId();
        result = result * 59 + ($id == null ? 43 : ((Object)$id).hashCode());
        Long $poolId = this.getPoolId();
        result = result * 59 + ($poolId == null ? 43 : ((Object)$poolId).hashCode());
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        Long $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : ((Object)$status).hashCode());
        Long $type = this.getType();
        result = result * 59 + ($type == null ? 43 : ((Object)$type).hashCode());
        String $account = this.getAccount();
        result = result * 59 + ($account == null ? 43 : $account.hashCode());
        String $password = this.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        String $port = this.getPort();
        result = result * 59 + ($port == null ? 43 : $port.hashCode());
        String $ip = this.getIp();
        result = result * 59 + ($ip == null ? 43 : $ip.hashCode());
        String $protocolse = this.getProtocolse();
        result = result * 59 + ($protocolse == null ? 43 : $protocolse.hashCode());
        Date $effectiveDatetime = this.getEffectiveDatetime();
        result = result * 59 + ($effectiveDatetime == null ? 43 : ((Object)$effectiveDatetime).hashCode());
        Date $expireDatetime = this.getExpireDatetime();
        result = result * 59 + ($expireDatetime == null ? 43 : ((Object)$expireDatetime).hashCode());
        Date $unsubscribeTime = this.getUnsubscribeTime();
        result = result * 59 + ($unsubscribeTime == null ? 43 : ((Object)$unsubscribeTime).hashCode());
        String $continent = this.getContinent();
        result = result * 59 + ($continent == null ? 43 : $continent.hashCode());
        String $countryCode = this.getCountryCode();
        result = result * 59 + ($countryCode == null ? 43 : $countryCode.hashCode());
        String $location = this.getLocation();
        result = result * 59 + ($location == null ? 43 : $location.hashCode());
        String $hot = this.getHot();
        result = result * 59 + ($hot == null ? 43 : $hot.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ClientIpStaticPoolMerchantDTO(id=" + this.getId() + ", poolId=" + this.getPoolId() + ", merchantId=" + this.getMerchantId() + ", account=" + this.getAccount() + ", password=" + this.getPassword() + ", port=" + this.getPort() + ", ip=" + this.getIp() + ", protocolse=" + this.getProtocolse() + ", effectiveDatetime=" + this.getEffectiveDatetime() + ", expireDatetime=" + this.getExpireDatetime() + ", unsubscribeTime=" + this.getUnsubscribeTime() + ", status=" + this.getStatus() + ", type=" + this.getType() + ", continent=" + this.getContinent() + ", countryCode=" + this.getCountryCode() + ", location=" + this.getLocation() + ", hot=" + this.getHot() + ")";
    }
}

