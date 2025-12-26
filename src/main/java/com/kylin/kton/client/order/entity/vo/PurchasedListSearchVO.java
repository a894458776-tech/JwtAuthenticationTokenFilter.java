/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.order.entity.vo;

import lombok.Generated;

public class PurchasedListSearchVO {
    private Long merchantId;
    private String continent;
    private String countryCode;
    private String location;
    private String ip;
    private String port;
    private Integer orderType;

    @Generated
    public PurchasedListSearchVO() {
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
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
    public String getIp() {
        return this.ip;
    }

    @Generated
    public String getPort() {
        return this.port;
    }

    @Generated
    public Integer getOrderType() {
        return this.orderType;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
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
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Generated
    public void setPort(String port) {
        this.port = port;
    }

    @Generated
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PurchasedListSearchVO)) {
            return false;
        }
        PurchasedListSearchVO other = (PurchasedListSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        Integer this$orderType = this.getOrderType();
        Integer other$orderType = other.getOrderType();
        if (this$orderType == null ? other$orderType != null : !((Object)this$orderType).equals(other$orderType)) {
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
        String this$ip = this.getIp();
        String other$ip = other.getIp();
        if (this$ip == null ? other$ip != null : !this$ip.equals(other$ip)) {
            return false;
        }
        String this$port = this.getPort();
        String other$port = other.getPort();
        return !(this$port == null ? other$port != null : !this$port.equals(other$port));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof PurchasedListSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        Integer $orderType = this.getOrderType();
        result = result * 59 + ($orderType == null ? 43 : ((Object)$orderType).hashCode());
        String $continent = this.getContinent();
        result = result * 59 + ($continent == null ? 43 : $continent.hashCode());
        String $countryCode = this.getCountryCode();
        result = result * 59 + ($countryCode == null ? 43 : $countryCode.hashCode());
        String $location = this.getLocation();
        result = result * 59 + ($location == null ? 43 : $location.hashCode());
        String $ip = this.getIp();
        result = result * 59 + ($ip == null ? 43 : $ip.hashCode());
        String $port = this.getPort();
        result = result * 59 + ($port == null ? 43 : $port.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "PurchasedListSearchVO(merchantId=" + this.getMerchantId() + ", continent=" + this.getContinent() + ", countryCode=" + this.getCountryCode() + ", location=" + this.getLocation() + ", ip=" + this.getIp() + ", port=" + this.getPort() + ", orderType=" + this.getOrderType() + ")";
    }
}

