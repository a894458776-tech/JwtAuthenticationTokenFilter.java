/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.order.entity.vo;

import lombok.Generated;

public class AdminOrderSearchVO {
    private String orderNo;
    private String domain;
    private String productName;

    @Generated
    public AdminOrderSearchVO() {
    }

    @Generated
    public String getOrderNo() {
        return this.orderNo;
    }

    @Generated
    public String getDomain() {
        return this.domain;
    }

    @Generated
    public String getProductName() {
        return this.productName;
    }

    @Generated
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Generated
    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Generated
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminOrderSearchVO)) {
            return false;
        }
        AdminOrderSearchVO other = (AdminOrderSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$orderNo = this.getOrderNo();
        String other$orderNo = other.getOrderNo();
        if (this$orderNo == null ? other$orderNo != null : !this$orderNo.equals(other$orderNo)) {
            return false;
        }
        String this$domain = this.getDomain();
        String other$domain = other.getDomain();
        if (this$domain == null ? other$domain != null : !this$domain.equals(other$domain)) {
            return false;
        }
        String this$productName = this.getProductName();
        String other$productName = other.getProductName();
        return !(this$productName == null ? other$productName != null : !this$productName.equals(other$productName));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminOrderSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $orderNo = this.getOrderNo();
        result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
        String $domain = this.getDomain();
        result = result * 59 + ($domain == null ? 43 : $domain.hashCode());
        String $productName = this.getProductName();
        result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminOrderSearchVO(orderNo=" + this.getOrderNo() + ", domain=" + this.getDomain() + ", productName=" + this.getProductName() + ")";
    }
}

