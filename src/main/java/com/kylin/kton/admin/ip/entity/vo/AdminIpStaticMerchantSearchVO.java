/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.vo;

import lombok.Generated;

public class AdminIpStaticMerchantSearchVO {
    private Long type;
    private String ip;
    private String status;
    private String orderNo;
    private Long merchantId;
    private String countryCode;

    @Generated
    public AdminIpStaticMerchantSearchVO() {
    }

    @Generated
    public Long getType() {
        return this.type;
    }

    @Generated
    public String getIp() {
        return this.ip;
    }

    @Generated
    public String getStatus() {
        return this.status;
    }

    @Generated
    public String getOrderNo() {
        return this.orderNo;
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public String getCountryCode() {
        return this.countryCode;
    }

    @Generated
    public void setType(Long type) {
        this.type = type;
    }

    @Generated
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Generated
    public void setStatus(String status) {
        this.status = status;
    }

    @Generated
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminIpStaticMerchantSearchVO)) {
            return false;
        }
        AdminIpStaticMerchantSearchVO other = (AdminIpStaticMerchantSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$type = this.getType();
        Long other$type = other.getType();
        if (this$type == null ? other$type != null : !((Object)this$type).equals(other$type)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        String this$ip = this.getIp();
        String other$ip = other.getIp();
        if (this$ip == null ? other$ip != null : !this$ip.equals(other$ip)) {
            return false;
        }
        String this$status = this.getStatus();
        String other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
            return false;
        }
        String this$orderNo = this.getOrderNo();
        String other$orderNo = other.getOrderNo();
        if (this$orderNo == null ? other$orderNo != null : !this$orderNo.equals(other$orderNo)) {
            return false;
        }
        String this$countryCode = this.getCountryCode();
        String other$countryCode = other.getCountryCode();
        return !(this$countryCode == null ? other$countryCode != null : !this$countryCode.equals(other$countryCode));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminIpStaticMerchantSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $type = this.getType();
        result = result * 59 + ($type == null ? 43 : ((Object)$type).hashCode());
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        String $ip = this.getIp();
        result = result * 59 + ($ip == null ? 43 : $ip.hashCode());
        String $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        String $orderNo = this.getOrderNo();
        result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
        String $countryCode = this.getCountryCode();
        result = result * 59 + ($countryCode == null ? 43 : $countryCode.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminIpStaticMerchantSearchVO(type=" + this.getType() + ", ip=" + this.getIp() + ", status=" + this.getStatus() + ", orderNo=" + this.getOrderNo() + ", merchantId=" + this.getMerchantId() + ", countryCode=" + this.getCountryCode() + ")";
    }
}

