/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.order.entity.vo;

import lombok.Generated;

public class ClientDataStatisticsVO {
    private Long merchantId;

    @Generated
    public ClientDataStatisticsVO() {
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
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
        if (!(o instanceof ClientDataStatisticsVO)) {
            return false;
        }
        ClientDataStatisticsVO other = (ClientDataStatisticsVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        return !(this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ClientDataStatisticsVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ClientDataStatisticsVO(merchantId=" + this.getMerchantId() + ")";
    }
}

