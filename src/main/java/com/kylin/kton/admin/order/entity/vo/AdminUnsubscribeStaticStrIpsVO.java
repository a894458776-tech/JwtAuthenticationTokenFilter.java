/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.validation.constraints.NotNull
 *  lombok.Generated
 */
package com.kylin.kton.admin.order.entity.vo;

import javax.validation.constraints.NotNull;
import lombok.Generated;

public class AdminUnsubscribeStaticStrIpsVO {
    @NotNull(message="ipList\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="ipList\u4e0d\u80fd\u4e3a\u7a7a") String ipList;
    @NotNull(message="merchantId\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="merchantId\u4e0d\u80fd\u4e3a\u7a7a") Long merchantId;
    private Long isRefund;

    @Generated
    public AdminUnsubscribeStaticStrIpsVO() {
    }

    @Generated
    public String getIpList() {
        return this.ipList;
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public Long getIsRefund() {
        return this.isRefund;
    }

    @Generated
    public void setIpList(String ipList) {
        this.ipList = ipList;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public void setIsRefund(Long isRefund) {
        this.isRefund = isRefund;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminUnsubscribeStaticStrIpsVO)) {
            return false;
        }
        AdminUnsubscribeStaticStrIpsVO other = (AdminUnsubscribeStaticStrIpsVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        Long this$isRefund = this.getIsRefund();
        Long other$isRefund = other.getIsRefund();
        if (this$isRefund == null ? other$isRefund != null : !((Object)this$isRefund).equals(other$isRefund)) {
            return false;
        }
        String this$ipList = this.getIpList();
        String other$ipList = other.getIpList();
        return !(this$ipList == null ? other$ipList != null : !this$ipList.equals(other$ipList));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminUnsubscribeStaticStrIpsVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        Long $isRefund = this.getIsRefund();
        result = result * 59 + ($isRefund == null ? 43 : ((Object)$isRefund).hashCode());
        String $ipList = this.getIpList();
        result = result * 59 + ($ipList == null ? 43 : $ipList.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminUnsubscribeStaticStrIpsVO(ipList=" + this.getIpList() + ", merchantId=" + this.getMerchantId() + ", isRefund=" + this.getIsRefund() + ")";
    }
}

