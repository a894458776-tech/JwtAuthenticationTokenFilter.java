/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.validation.constraints.NotNull
 *  lombok.Generated
 */
package com.kylin.kton.client.order.entity.vo;

import javax.validation.constraints.NotNull;
import lombok.Generated;

public class ClientMerchantIpsByOrderNoGetVO {
    @NotNull(message="\u8ba2\u5355\u53f7\u4e0d\u80fd\u4e3a\u7a7a")
    @NotNull(message="\u8ba2\u5355\u53f7\u4e0d\u80fd\u4e3a\u7a7a") String orderNo;
    private Long merchantId;

    @Generated
    public ClientMerchantIpsByOrderNoGetVO() {
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
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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
        if (!(o instanceof ClientMerchantIpsByOrderNoGetVO)) {
            return false;
        }
        ClientMerchantIpsByOrderNoGetVO other = (ClientMerchantIpsByOrderNoGetVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        String this$orderNo = this.getOrderNo();
        String other$orderNo = other.getOrderNo();
        return !(this$orderNo == null ? other$orderNo != null : !this$orderNo.equals(other$orderNo));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ClientMerchantIpsByOrderNoGetVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        String $orderNo = this.getOrderNo();
        result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ClientMerchantIpsByOrderNoGetVO(orderNo=" + this.getOrderNo() + ", merchantId=" + this.getMerchantId() + ")";
    }
}

