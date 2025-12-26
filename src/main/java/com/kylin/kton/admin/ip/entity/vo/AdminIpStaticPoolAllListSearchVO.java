/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.vo;

import lombok.Generated;

public class AdminIpStaticPoolAllListSearchVO {
    private Long type;
    private String continent;
    private String countryCode;
    private String location;
    private String port;
    private String ip;
    private String merchantId;
    private Long itemStatus;

    @Generated
    public AdminIpStaticPoolAllListSearchVO() {
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
    public String getPort() {
        return this.port;
    }

    @Generated
    public String getIp() {
        return this.ip;
    }

    @Generated
    public String getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public Long getItemStatus() {
        return this.itemStatus;
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
    public void setPort(String port) {
        this.port = port;
    }

    @Generated
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Generated
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public void setItemStatus(Long itemStatus) {
        this.itemStatus = itemStatus;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminIpStaticPoolAllListSearchVO)) {
            return false;
        }
        AdminIpStaticPoolAllListSearchVO other = (AdminIpStaticPoolAllListSearchVO)o;
        if (!other.canEqual(this)) {
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
        String this$merchantId = this.getMerchantId();
        String other$merchantId = other.getMerchantId();
        return !(this$merchantId == null ? other$merchantId != null : !this$merchantId.equals(other$merchantId));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminIpStaticPoolAllListSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $type = this.getType();
        result = result * 59 + ($type == null ? 43 : ((Object)$type).hashCode());
        Long $itemStatus = this.getItemStatus();
        result = result * 59 + ($itemStatus == null ? 43 : ((Object)$itemStatus).hashCode());
        String $continent = this.getContinent();
        result = result * 59 + ($continent == null ? 43 : $continent.hashCode());
        String $countryCode = this.getCountryCode();
        result = result * 59 + ($countryCode == null ? 43 : $countryCode.hashCode());
        String $location = this.getLocation();
        result = result * 59 + ($location == null ? 43 : $location.hashCode());
        String $port = this.getPort();
        result = result * 59 + ($port == null ? 43 : $port.hashCode());
        String $ip = this.getIp();
        result = result * 59 + ($ip == null ? 43 : $ip.hashCode());
        String $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : $merchantId.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminIpStaticPoolAllListSearchVO(type=" + this.getType() + ", continent=" + this.getContinent() + ", countryCode=" + this.getCountryCode() + ", location=" + this.getLocation() + ", port=" + this.getPort() + ", ip=" + this.getIp() + ", merchantId=" + this.getMerchantId() + ", itemStatus=" + this.getItemStatus() + ")";
    }
}

