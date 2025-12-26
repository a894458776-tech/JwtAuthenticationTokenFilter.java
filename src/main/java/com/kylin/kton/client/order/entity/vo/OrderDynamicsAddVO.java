/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.order.entity.vo;

import java.math.BigDecimal;
import lombok.Generated;

public class OrderDynamicsAddVO {
    private Long merchantId;
    private String domain;
    private Long productType;
    private Long quantity;
    private BigDecimal totalAmount;
    private String currency;
    private String payMethod;
    private String udp;
    private BigDecimal capacity;
    private Long configPeriodId;
    private Long configPlanId;

    @Generated
    public OrderDynamicsAddVO() {
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
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
    public Long getQuantity() {
        return this.quantity;
    }

    @Generated
    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    @Generated
    public String getCurrency() {
        return this.currency;
    }

    @Generated
    public String getPayMethod() {
        return this.payMethod;
    }

    @Generated
    public String getUdp() {
        return this.udp;
    }

    @Generated
    public BigDecimal getCapacity() {
        return this.capacity;
    }

    @Generated
    public Long getConfigPeriodId() {
        return this.configPeriodId;
    }

    @Generated
    public Long getConfigPlanId() {
        return this.configPlanId;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
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
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Generated
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Generated
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Generated
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    @Generated
    public void setUdp(String udp) {
        this.udp = udp;
    }

    @Generated
    public void setCapacity(BigDecimal capacity) {
        this.capacity = capacity;
    }

    @Generated
    public void setConfigPeriodId(Long configPeriodId) {
        this.configPeriodId = configPeriodId;
    }

    @Generated
    public void setConfigPlanId(Long configPlanId) {
        this.configPlanId = configPlanId;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof OrderDynamicsAddVO)) {
            return false;
        }
        OrderDynamicsAddVO other = (OrderDynamicsAddVO)o;
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
        Long this$quantity = this.getQuantity();
        Long other$quantity = other.getQuantity();
        if (this$quantity == null ? other$quantity != null : !((Object)this$quantity).equals(other$quantity)) {
            return false;
        }
        Long this$configPeriodId = this.getConfigPeriodId();
        Long other$configPeriodId = other.getConfigPeriodId();
        if (this$configPeriodId == null ? other$configPeriodId != null : !((Object)this$configPeriodId).equals(other$configPeriodId)) {
            return false;
        }
        Long this$configPlanId = this.getConfigPlanId();
        Long other$configPlanId = other.getConfigPlanId();
        if (this$configPlanId == null ? other$configPlanId != null : !((Object)this$configPlanId).equals(other$configPlanId)) {
            return false;
        }
        String this$domain = this.getDomain();
        String other$domain = other.getDomain();
        if (this$domain == null ? other$domain != null : !this$domain.equals(other$domain)) {
            return false;
        }
        BigDecimal this$totalAmount = this.getTotalAmount();
        BigDecimal other$totalAmount = other.getTotalAmount();
        if (this$totalAmount == null ? other$totalAmount != null : !((Object)this$totalAmount).equals(other$totalAmount)) {
            return false;
        }
        String this$currency = this.getCurrency();
        String other$currency = other.getCurrency();
        if (this$currency == null ? other$currency != null : !this$currency.equals(other$currency)) {
            return false;
        }
        String this$payMethod = this.getPayMethod();
        String other$payMethod = other.getPayMethod();
        if (this$payMethod == null ? other$payMethod != null : !this$payMethod.equals(other$payMethod)) {
            return false;
        }
        String this$udp = this.getUdp();
        String other$udp = other.getUdp();
        if (this$udp == null ? other$udp != null : !this$udp.equals(other$udp)) {
            return false;
        }
        BigDecimal this$capacity = this.getCapacity();
        BigDecimal other$capacity = other.getCapacity();
        return !(this$capacity == null ? other$capacity != null : !((Object)this$capacity).equals(other$capacity));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof OrderDynamicsAddVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        Long $productType = this.getProductType();
        result = result * 59 + ($productType == null ? 43 : ((Object)$productType).hashCode());
        Long $quantity = this.getQuantity();
        result = result * 59 + ($quantity == null ? 43 : ((Object)$quantity).hashCode());
        Long $configPeriodId = this.getConfigPeriodId();
        result = result * 59 + ($configPeriodId == null ? 43 : ((Object)$configPeriodId).hashCode());
        Long $configPlanId = this.getConfigPlanId();
        result = result * 59 + ($configPlanId == null ? 43 : ((Object)$configPlanId).hashCode());
        String $domain = this.getDomain();
        result = result * 59 + ($domain == null ? 43 : $domain.hashCode());
        BigDecimal $totalAmount = this.getTotalAmount();
        result = result * 59 + ($totalAmount == null ? 43 : ((Object)$totalAmount).hashCode());
        String $currency = this.getCurrency();
        result = result * 59 + ($currency == null ? 43 : $currency.hashCode());
        String $payMethod = this.getPayMethod();
        result = result * 59 + ($payMethod == null ? 43 : $payMethod.hashCode());
        String $udp = this.getUdp();
        result = result * 59 + ($udp == null ? 43 : $udp.hashCode());
        BigDecimal $capacity = this.getCapacity();
        result = result * 59 + ($capacity == null ? 43 : ((Object)$capacity).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "OrderDynamicsAddVO(merchantId=" + this.getMerchantId() + ", domain=" + this.getDomain() + ", productType=" + this.getProductType() + ", quantity=" + this.getQuantity() + ", totalAmount=" + this.getTotalAmount() + ", currency=" + this.getCurrency() + ", payMethod=" + this.getPayMethod() + ", udp=" + this.getUdp() + ", capacity=" + this.getCapacity() + ", configPeriodId=" + this.getConfigPeriodId() + ", configPlanId=" + this.getConfigPlanId() + ")";
    }
}

