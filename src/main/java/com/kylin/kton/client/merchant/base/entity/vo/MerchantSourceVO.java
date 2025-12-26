/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.merchant.base.entity.vo;

import lombok.Generated;

public class MerchantSourceVO {
    private String ipType;
    private Long merchantId;

    @Generated
    public MerchantSourceVO() {
    }

    @Generated
    public String getIpType() {
        return this.ipType;
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public void setIpType(String ipType) {
        this.ipType = ipType;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MerchantSourceVO)) {
            return false;
        }
        MerchantSourceVO other = (MerchantSourceVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        String this$ipType = this.getIpType();
        String other$ipType = other.getIpType();
        return !(this$ipType == null ? other$ipType != null : !this$ipType.equals(other$ipType));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof MerchantSourceVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        String $ipType = this.getIpType();
        result = result * 59 + ($ipType == null ? 43 : $ipType.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "MerchantSourceVO(ipType=" + this.getIpType() + ", merchantId=" + this.getMerchantId() + ")";
    }
}

