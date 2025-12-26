/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.vo;

import lombok.Generated;

public class MerchantAvailableIpListVO {
    private Long merchantId;
    private Long poolId;
    private String ipFuzzyField;
    private Long isExclusive = 0L;

    @Generated
    public MerchantAvailableIpListVO() {
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public Long getPoolId() {
        return this.poolId;
    }

    @Generated
    public String getIpFuzzyField() {
        return this.ipFuzzyField;
    }

    @Generated
    public Long getIsExclusive() {
        return this.isExclusive;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    @Generated
    public void setIpFuzzyField(String ipFuzzyField) {
        this.ipFuzzyField = ipFuzzyField;
    }

    @Generated
    public void setIsExclusive(Long isExclusive) {
        this.isExclusive = isExclusive;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MerchantAvailableIpListVO)) {
            return false;
        }
        MerchantAvailableIpListVO other = (MerchantAvailableIpListVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        Long this$poolId = this.getPoolId();
        Long other$poolId = other.getPoolId();
        if (this$poolId == null ? other$poolId != null : !((Object)this$poolId).equals(other$poolId)) {
            return false;
        }
        Long this$isExclusive = this.getIsExclusive();
        Long other$isExclusive = other.getIsExclusive();
        if (this$isExclusive == null ? other$isExclusive != null : !((Object)this$isExclusive).equals(other$isExclusive)) {
            return false;
        }
        String this$ipFuzzyField = this.getIpFuzzyField();
        String other$ipFuzzyField = other.getIpFuzzyField();
        return !(this$ipFuzzyField == null ? other$ipFuzzyField != null : !this$ipFuzzyField.equals(other$ipFuzzyField));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof MerchantAvailableIpListVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        Long $poolId = this.getPoolId();
        result = result * 59 + ($poolId == null ? 43 : ((Object)$poolId).hashCode());
        Long $isExclusive = this.getIsExclusive();
        result = result * 59 + ($isExclusive == null ? 43 : ((Object)$isExclusive).hashCode());
        String $ipFuzzyField = this.getIpFuzzyField();
        result = result * 59 + ($ipFuzzyField == null ? 43 : $ipFuzzyField.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "MerchantAvailableIpListVO(merchantId=" + this.getMerchantId() + ", poolId=" + this.getPoolId() + ", ipFuzzyField=" + this.getIpFuzzyField() + ", isExclusive=" + this.getIsExclusive() + ")";
    }
}

