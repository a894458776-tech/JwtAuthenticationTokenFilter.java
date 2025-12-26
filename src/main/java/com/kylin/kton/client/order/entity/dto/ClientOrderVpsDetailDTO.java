/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  lombok.Generated
 */
package com.kylin.kton.client.order.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kylin.kton.client.order.entity.dto.ClientOrderItemVpsDTO;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import lombok.Generated;

public class ClientOrderVpsDetailDTO {
    private String orderNo;
    private Long quantity;
    private BigDecimal totalAmount;
    private String currency;
    private Long paidStatus;
    private String payMethod;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date effectiveDatetime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date expireDatetime;
    List<ClientOrderItemVpsDTO> orderItems;

    @Generated
    public ClientOrderVpsDetailDTO() {
    }

    @Generated
    public String getOrderNo() {
        return this.orderNo;
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
    public Date getEffectiveDatetime() {
        return this.effectiveDatetime;
    }

    @Generated
    public Date getExpireDatetime() {
        return this.expireDatetime;
    }

    @Generated
    public List<ClientOrderItemVpsDTO> getOrderItems() {
        return this.orderItems;
    }

    @Generated
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    @Generated
    public void setOrderItems(List<ClientOrderItemVpsDTO> orderItems) {
        this.orderItems = orderItems;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ClientOrderVpsDetailDTO)) {
            return false;
        }
        ClientOrderVpsDetailDTO other = (ClientOrderVpsDetailDTO)o;
        if (!other.canEqual(this)) {
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
        String this$orderNo = this.getOrderNo();
        String other$orderNo = other.getOrderNo();
        if (this$orderNo == null ? other$orderNo != null : !this$orderNo.equals(other$orderNo)) {
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
        List<ClientOrderItemVpsDTO> this$orderItems = this.getOrderItems();
        List<ClientOrderItemVpsDTO> other$orderItems = other.getOrderItems();
        return !(this$orderItems == null ? other$orderItems != null : !((Object)this$orderItems).equals(other$orderItems));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ClientOrderVpsDetailDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $quantity = this.getQuantity();
        result = result * 59 + ($quantity == null ? 43 : ((Object)$quantity).hashCode());
        Long $paidStatus = this.getPaidStatus();
        result = result * 59 + ($paidStatus == null ? 43 : ((Object)$paidStatus).hashCode());
        String $orderNo = this.getOrderNo();
        result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
        BigDecimal $totalAmount = this.getTotalAmount();
        result = result * 59 + ($totalAmount == null ? 43 : ((Object)$totalAmount).hashCode());
        String $currency = this.getCurrency();
        result = result * 59 + ($currency == null ? 43 : $currency.hashCode());
        String $payMethod = this.getPayMethod();
        result = result * 59 + ($payMethod == null ? 43 : $payMethod.hashCode());
        Date $effectiveDatetime = this.getEffectiveDatetime();
        result = result * 59 + ($effectiveDatetime == null ? 43 : ((Object)$effectiveDatetime).hashCode());
        Date $expireDatetime = this.getExpireDatetime();
        result = result * 59 + ($expireDatetime == null ? 43 : ((Object)$expireDatetime).hashCode());
        List<ClientOrderItemVpsDTO> $orderItems = this.getOrderItems();
        result = result * 59 + ($orderItems == null ? 43 : ((Object)$orderItems).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ClientOrderVpsDetailDTO(orderNo=" + this.getOrderNo() + ", quantity=" + this.getQuantity() + ", totalAmount=" + this.getTotalAmount() + ", currency=" + this.getCurrency() + ", paidStatus=" + this.getPaidStatus() + ", payMethod=" + this.getPayMethod() + ", effectiveDatetime=" + this.getEffectiveDatetime() + ", expireDatetime=" + this.getExpireDatetime() + ", orderItems=" + this.getOrderItems() + ")";
    }
}

