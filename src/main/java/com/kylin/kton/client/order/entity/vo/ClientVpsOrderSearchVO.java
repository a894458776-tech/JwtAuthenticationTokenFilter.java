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

public class ClientVpsOrderSearchVO {
    @NotNull(message="\u8ba2\u5355\u53f7\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="\u8ba2\u5355\u53f7\u4e0d\u80fd\u4e3a\u7a7a") String orderNo;

    @Generated
    public ClientVpsOrderSearchVO() {
    }

    @Generated
    public String getOrderNo() {
        return this.orderNo;
    }

    @Generated
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ClientVpsOrderSearchVO)) {
            return false;
        }
        ClientVpsOrderSearchVO other = (ClientVpsOrderSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$orderNo = this.getOrderNo();
        String other$orderNo = other.getOrderNo();
        return !(this$orderNo == null ? other$orderNo != null : !this$orderNo.equals(other$orderNo));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ClientVpsOrderSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $orderNo = this.getOrderNo();
        result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ClientVpsOrderSearchVO(orderNo=" + this.getOrderNo() + ")";
    }
}

