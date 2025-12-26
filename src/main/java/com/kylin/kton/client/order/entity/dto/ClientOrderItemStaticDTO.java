/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.kylin.kton.system.domain.KtonOrderItemStatic
 *  lombok.Generated
 */
package com.kylin.kton.client.order.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kylin.kton.system.domain.KtonOrderItemStatic;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Generated;

public class ClientOrderItemStaticDTO
extends KtonOrderItemStatic {
    private Long merchantId;
    private String orderNo;
    private String domain;
    private String productName;
    private Long productType;
    private Long quantity;
    private BigDecimal totalAmount;
    private String currency;
    private Long paidStatus;
    private String payMethod;
    private Long totalIps;
    private String udp;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date effectiveDatetime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date expireDatetime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date unsubscribeTime;

    @Generated
    public ClientOrderItemStaticDTO() {
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
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
    public Long getPaidStatus() {
        return this.paidStatus;
    }

    @Generated
    public String getPayMethod() {
        return this.payMethod;
    }

    @Generated
    public Long getTotalIps() {
        return this.totalIps;
    }

    @Generated
    public String getUdp() {
        return this.udp;
    }

    @Generated
    public Date getEffectiveDatetime() {
        return this.effectiveDatetime;
    }

    @Generated
    public Date getExpireDatetime() {
        return this.expireDatetime;
    }

    @Generated
    public Date getUnsubscribeTime() {
        return this.unsubscribeTime;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
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
    public void setPaidStatus(Long paidStatus) {
        this.paidStatus = paidStatus;
    }

    @Generated
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    @Generated
    public void setTotalIps(Long totalIps) {
        this.totalIps = totalIps;
    }

    @Generated
    public void setUdp(String udp) {
        this.udp = udp;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Generated
    public void setEffectiveDatetime(Date effectiveDatetime) {
        this.effectiveDatetime = effectiveDatetime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Generated
    public void setExpireDatetime(Date expireDatetime) {
        this.expireDatetime = expireDatetime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Generated
    public void setUnsubscribeTime(Date unsubscribeTime) {
        this.unsubscribeTime = unsubscribeTime;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ClientOrderItemStaticDTO)) {
            return false;
        }
        ClientOrderItemStaticDTO other = (ClientOrderItemStaticDTO)((Object)o);
        if (!other.canEqual((Object)this)) {
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
        Long this$paidStatus = this.getPaidStatus();
        Long other$paidStatus = other.getPaidStatus();
        if (this$paidStatus == null ? other$paidStatus != null : !((Object)this$paidStatus).equals(other$paidStatus)) {
            return false;
        }
        Long this$totalIps = this.getTotalIps();
        Long other$totalIps = other.getTotalIps();
        if (this$totalIps == null ? other$totalIps != null : !((Object)this$totalIps).equals(other$totalIps)) {
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
        if (this$productName == null ? other$productName != null : !this$productName.equals(other$productName)) {
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
        Date this$effectiveDatetime = this.getEffectiveDatetime();
        Date other$effectiveDatetime = other.getEffectiveDatetime();
        if (this$effectiveDatetime == null ? other$effectiveDatetime != null : !((Object)this$effectiveDatetime).equals(other$effectiveDatetime)) {
            return false;
        }
        Date this$expireDatetime = this.getExpireDatetime();
        Date other$expireDatetime = other.getExpireDatetime();
        if (this$expireDatetime == null ? other$expireDatetime != null : !((Object)this$expireDatetime).equals(other$expireDatetime)) {
            return false;
        }
        Date this$unsubscribeTime = this.getUnsubscribeTime();
        Date other$unsubscribeTime = other.getUnsubscribeTime();
        return !(this$unsubscribeTime == null ? other$unsubscribeTime != null : !((Object)this$unsubscribeTime).equals(other$unsubscribeTime));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ClientOrderItemStaticDTO;
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
        Long $paidStatus = this.getPaidStatus();
        result = result * 59 + ($paidStatus == null ? 43 : ((Object)$paidStatus).hashCode());
        Long $totalIps = this.getTotalIps();
        result = result * 59 + ($totalIps == null ? 43 : ((Object)$totalIps).hashCode());
        String $orderNo = this.getOrderNo();
        result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
        String $domain = this.getDomain();
        result = result * 59 + ($domain == null ? 43 : $domain.hashCode());
        String $productName = this.getProductName();
        result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
        BigDecimal $totalAmount = this.getTotalAmount();
        result = result * 59 + ($totalAmount == null ? 43 : ((Object)$totalAmount).hashCode());
        String $currency = this.getCurrency();
        result = result * 59 + ($currency == null ? 43 : $currency.hashCode());
        String $payMethod = this.getPayMethod();
        result = result * 59 + ($payMethod == null ? 43 : $payMethod.hashCode());
        String $udp = this.getUdp();
        result = result * 59 + ($udp == null ? 43 : $udp.hashCode());
        Date $effectiveDatetime = this.getEffectiveDatetime();
        result = result * 59 + ($effectiveDatetime == null ? 43 : ((Object)$effectiveDatetime).hashCode());
        Date $expireDatetime = this.getExpireDatetime();
        result = result * 59 + ($expireDatetime == null ? 43 : ((Object)$expireDatetime).hashCode());
        Date $unsubscribeTime = this.getUnsubscribeTime();
        result = result * 59 + ($unsubscribeTime == null ? 43 : ((Object)$unsubscribeTime).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ClientOrderItemStaticDTO(merchantId=" + this.getMerchantId() + ", orderNo=" + this.getOrderNo() + ", domain=" + this.getDomain() + ", productName=" + this.getProductName() + ", productType=" + this.getProductType() + ", quantity=" + this.getQuantity() + ", totalAmount=" + this.getTotalAmount() + ", currency=" + this.getCurrency() + ", paidStatus=" + this.getPaidStatus() + ", payMethod=" + this.getPayMethod() + ", totalIps=" + this.getTotalIps() + ", udp=" + this.getUdp() + ", effectiveDatetime=" + this.getEffectiveDatetime() + ", expireDatetime=" + this.getExpireDatetime() + ", unsubscribeTime=" + this.getUnsubscribeTime() + ")";
    }
}

