/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.vo;

import lombok.Generated;

public class AdminIpStaticConfigPlanSearchVO {
    private Long ipType;
    private Long merchantId;
    private Long isExclusive;

    @Generated
    public AdminIpStaticConfigPlanSearchVO() {
    }

    @Generated
    public Long getIpType() {
        return this.ipType;
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public Long getIsExclusive() {
        return this.isExclusive;
    }

    @Generated
    public void setIpType(Long ipType) {
        this.ipType = ipType;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
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
        if (!(o instanceof AdminIpStaticConfigPlanSearchVO)) {
            return false;
        }
        AdminIpStaticConfigPlanSearchVO other = (AdminIpStaticConfigPlanSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$ipType = this.getIpType();
        Long other$ipType = other.getIpType();
        if (this$ipType == null ? other$ipType != null : !((Object)this$ipType).equals(other$ipType)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        Long this$isExclusive = this.getIsExclusive();
        Long other$isExclusive = other.getIsExclusive();
        return !(this$isExclusive == null ? other$isExclusive != null : !((Object)this$isExclusive).equals(other$isExclusive));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminIpStaticConfigPlanSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $ipType = this.getIpType();
        result = result * 59 + ($ipType == null ? 43 : ((Object)$ipType).hashCode());
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        Long $isExclusive = this.getIsExclusive();
        result = result * 59 + ($isExclusive == null ? 43 : ((Object)$isExclusive).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminIpStaticConfigPlanSearchVO(ipType=" + this.getIpType() + ", merchantId=" + this.getMerchantId() + ", isExclusive=" + this.getIsExclusive() + ")";
    }
}

