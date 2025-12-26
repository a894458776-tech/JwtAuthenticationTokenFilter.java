/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.validation.constraints.NotEmpty
 *  javax.validation.constraints.NotNull
 *  lombok.Generated
 */
package com.kylin.kton.admin.order.entity.vo;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Generated;

public class AdminProcessIpReplacementVO {
    @NotEmpty(message="\u5f85\u66f4\u6362IP\u5217\u8868\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotEmpty(message="\u5f85\u66f4\u6362IP\u5217\u8868\u4e0d\u80fd\u4e3a\u7a7a") List<String> oldIpList;
    @NotEmpty(message="\u65b0IP\u5217\u8868\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotEmpty(message="\u65b0IP\u5217\u8868\u4e0d\u80fd\u4e3a\u7a7a") List<String> newIpList;
    @NotNull(message="merchantId\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="merchantId\u4e0d\u80fd\u4e3a\u7a7a") Long merchantId;
    private Long isExclusive = 0L;

    @Generated
    public AdminProcessIpReplacementVO() {
    }

    @Generated
    public List<String> getOldIpList() {
        return this.oldIpList;
    }

    @Generated
    public List<String> getNewIpList() {
        return this.newIpList;
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
    public void setOldIpList(List<String> oldIpList) {
        this.oldIpList = oldIpList;
    }

    @Generated
    public void setNewIpList(List<String> newIpList) {
        this.newIpList = newIpList;
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
        if (!(o instanceof AdminProcessIpReplacementVO)) {
            return false;
        }
        AdminProcessIpReplacementVO other = (AdminProcessIpReplacementVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        Long this$isExclusive = this.getIsExclusive();
        Long other$isExclusive = other.getIsExclusive();
        if (this$isExclusive == null ? other$isExclusive != null : !((Object)this$isExclusive).equals(other$isExclusive)) {
            return false;
        }
        List<String> this$oldIpList = this.getOldIpList();
        List<String> other$oldIpList = other.getOldIpList();
        if (this$oldIpList == null ? other$oldIpList != null : !((Object)this$oldIpList).equals(other$oldIpList)) {
            return false;
        }
        List<String> this$newIpList = this.getNewIpList();
        List<String> other$newIpList = other.getNewIpList();
        return !(this$newIpList == null ? other$newIpList != null : !((Object)this$newIpList).equals(other$newIpList));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminProcessIpReplacementVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        Long $isExclusive = this.getIsExclusive();
        result = result * 59 + ($isExclusive == null ? 43 : ((Object)$isExclusive).hashCode());
        List<String> $oldIpList = this.getOldIpList();
        result = result * 59 + ($oldIpList == null ? 43 : ((Object)$oldIpList).hashCode());
        List<String> $newIpList = this.getNewIpList();
        result = result * 59 + ($newIpList == null ? 43 : ((Object)$newIpList).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminProcessIpReplacementVO(oldIpList=" + this.getOldIpList() + ", newIpList=" + this.getNewIpList() + ", merchantId=" + this.getMerchantId() + ", isExclusive=" + this.getIsExclusive() + ")";
    }
}

