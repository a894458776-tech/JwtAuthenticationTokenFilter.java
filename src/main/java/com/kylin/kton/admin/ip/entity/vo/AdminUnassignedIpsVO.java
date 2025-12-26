/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.validation.constraints.NotNull
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.vo;

import javax.validation.constraints.NotNull;
import lombok.Generated;

public class AdminUnassignedIpsVO {
    private Long merchantId;
    @NotNull(message="\u56fd\u5bb6\u4ee3\u7801\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="\u56fd\u5bb6\u4ee3\u7801\u4e0d\u80fd\u4e3a\u7a7a") String countryCode;
    @NotNull(message="\u662f\u5426\u539f\u751f\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="\u662f\u5426\u539f\u751f\u4e0d\u80fd\u4e3a\u7a7a") Long isNative;

    @Generated
    public AdminUnassignedIpsVO() {
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
    public Long getIsNative() {
        return this.isNative;
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
    public void setIsNative(Long isNative) {
        this.isNative = isNative;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminUnassignedIpsVO)) {
            return false;
        }
        AdminUnassignedIpsVO other = (AdminUnassignedIpsVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        Long this$isNative = this.getIsNative();
        Long other$isNative = other.getIsNative();
        if (this$isNative == null ? other$isNative != null : !((Object)this$isNative).equals(other$isNative)) {
            return false;
        }
        String this$countryCode = this.getCountryCode();
        String other$countryCode = other.getCountryCode();
        return !(this$countryCode == null ? other$countryCode != null : !this$countryCode.equals(other$countryCode));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminUnassignedIpsVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        Long $isNative = this.getIsNative();
        result = result * 59 + ($isNative == null ? 43 : ((Object)$isNative).hashCode());
        String $countryCode = this.getCountryCode();
        result = result * 59 + ($countryCode == null ? 43 : $countryCode.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminUnassignedIpsVO(merchantId=" + this.getMerchantId() + ", countryCode=" + this.getCountryCode() + ", isNative=" + this.getIsNative() + ")";
    }
}

