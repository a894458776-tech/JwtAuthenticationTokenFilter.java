/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.order.entity.vo;

import lombok.Generated;

public class ClientOrderSearchVO {
    private Long merchantId;
    private String productName;
    private String orderNo;
    private String domain;
    private Long productType;

    @Generated
    public ClientOrderSearchVO() {
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public String getProductName() {
        return this.productName;
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
    public Long getProductType() {
        return this.productType;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public void setProductName(String productName) {
        this.productName = productName;
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
    public void setProductType(Long productType) {
        this.productType = productType;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ClientOrderSearchVO)) {
            return false;
        }
        ClientOrderSearchVO other = (ClientOrderSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        Long this$productType = this.getProductType();
        Long other$productType = other.getProductType();
        if (this$productType == null ? other$productType != null : !((Object)this$productType).equals(other$productType)) {
            return false;
        }
        String this$productName = this.getProductName();
        String other$productName = other.getProductName();
        if (this$productName == null ? other$productName != null : !this$productName.equals(other$productName)) {
            return false;
        }
        String this$orderNo = this.getOrderNo();
        String other$orderNo = other.getOrderNo();
        if (this$orderNo == null ? other$orderNo != null : !this$orderNo.equals(other$orderNo)) {
            return false;
        }
        String this$domain = this.getDomain();
        String other$domain = other.getDomain();
        return !(this$domain == null ? other$domain != null : !this$domain.equals(other$domain));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ClientOrderSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        Long $productType = this.getProductType();
        result = result * 59 + ($productType == null ? 43 : ((Object)$productType).hashCode());
        String $productName = this.getProductName();
        result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
        String $orderNo = this.getOrderNo();
        result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
        String $domain = this.getDomain();
        result = result * 59 + ($domain == null ? 43 : $domain.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ClientOrderSearchVO(merchantId=" + this.getMerchantId() + ", productName=" + this.getProductName() + ", orderNo=" + this.getOrderNo() + ", domain=" + this.getDomain() + ", productType=" + this.getProductType() + ")";
    }
}

