/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.validation.constraints.NotNull
 *  lombok.Generated
 */
package com.kylin.kton.admin.order.entity.vo;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Generated;

public class AdminOrderStaticAddVO {
    @NotNull(message="\u5546\u6237ID\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="\u5546\u6237ID\u4e0d\u80fd\u4e3a\u7a7a") Long merchantId;
    @NotNull(message="\u8d2d\u4e70\u6709\u6548\u671f\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="\u8d2d\u4e70\u6709\u6548\u671f\u4e0d\u80fd\u4e3a\u7a7a") Long days;
    @NotNull(message="IP\u5217\u8868\u4e0d\u80fd\u4e3a\u7a7a")
    @NotNull(message="IP\u5217\u8868\u4e0d\u80fd\u4e3a\u7a7a") List<String> ips;
    private Long isFree = 0L;
    private Long isExclusive = 0L;

    @Generated
    public AdminOrderStaticAddVO() {
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public Long getDays() {
        return this.days;
    }

    @Generated
    public List<String> getIps() {
        return this.ips;
    }

    @Generated
    public Long getIsFree() {
        return this.isFree;
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
    public void setDays(Long days) {
        this.days = days;
    }

    @Generated
    public void setIps(List<String> ips) {
        this.ips = ips;
    }

    @Generated
    public void setIsFree(Long isFree) {
        this.isFree = isFree;
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
        if (!(o instanceof AdminOrderStaticAddVO)) {
            return false;
        }
        AdminOrderStaticAddVO other = (AdminOrderStaticAddVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        Long this$days = this.getDays();
        Long other$days = other.getDays();
        if (this$days == null ? other$days != null : !((Object)this$days).equals(other$days)) {
            return false;
        }
        Long this$isFree = this.getIsFree();
        Long other$isFree = other.getIsFree();
        if (this$isFree == null ? other$isFree != null : !((Object)this$isFree).equals(other$isFree)) {
            return false;
        }
        Long this$isExclusive = this.getIsExclusive();
        Long other$isExclusive = other.getIsExclusive();
        if (this$isExclusive == null ? other$isExclusive != null : !((Object)this$isExclusive).equals(other$isExclusive)) {
            return false;
        }
        List<String> this$ips = this.getIps();
        List<String> other$ips = other.getIps();
        return !(this$ips == null ? other$ips != null : !((Object)this$ips).equals(other$ips));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminOrderStaticAddVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        Long $days = this.getDays();
        result = result * 59 + ($days == null ? 43 : ((Object)$days).hashCode());
        Long $isFree = this.getIsFree();
        result = result * 59 + ($isFree == null ? 43 : ((Object)$isFree).hashCode());
        Long $isExclusive = this.getIsExclusive();
        result = result * 59 + ($isExclusive == null ? 43 : ((Object)$isExclusive).hashCode());
        List<String> $ips = this.getIps();
        result = result * 59 + ($ips == null ? 43 : ((Object)$ips).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminOrderStaticAddVO(merchantId=" + this.getMerchantId() + ", days=" + this.getDays() + ", ips=" + this.getIps() + ", isFree=" + this.getIsFree() + ", isExclusive=" + this.getIsExclusive() + ")";
    }
}

