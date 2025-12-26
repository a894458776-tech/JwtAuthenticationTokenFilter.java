/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.order.entity.vo;

import lombok.Generated;

public class UnsubscribeStaticStrIpsVO {
    private String ipList;
    private Long merchantId;

    @Generated
    public UnsubscribeStaticStrIpsVO() {
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
    public void setIpList(String ipList) {
        this.ipList = ipList;
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
        if (!(o instanceof UnsubscribeStaticStrIpsVO)) {
            return false;
        }
        UnsubscribeStaticStrIpsVO other = (UnsubscribeStaticStrIpsVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        String this$ipList = this.getIpList();
        String other$ipList = other.getIpList();
        return !(this$ipList == null ? other$ipList != null : !this$ipList.equals(other$ipList));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof UnsubscribeStaticStrIpsVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        String $ipList = this.getIpList();
        result = result * 59 + ($ipList == null ? 43 : $ipList.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "UnsubscribeStaticStrIpsVO(ipList=" + this.getIpList() + ", merchantId=" + this.getMerchantId() + ")";
    }
}

