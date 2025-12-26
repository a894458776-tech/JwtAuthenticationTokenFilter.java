/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.order.entity.vo;

import com.kylin.kton.client.order.entity.vo.CountryNumsItemVO;
import java.math.BigDecimal;
import java.util.List;
import lombok.Generated;

public class OrderAddVO {
    private Long merchantId;
    private String domain;
    private String productName;
    private Long productType;
    private Long quantity;
    private BigDecimal totalAmount;
    private String currency;
    private String payMethod;
    private Long totalIps;
    private String udp;
    private Long orderId;
    private BigDecimal capacity;
    private BigDecimal price;
    private Long days;
    private BigDecimal discount;
    private String continent;
    List<CountryNumsItemVO> countryNums;

    @Generated
    public OrderAddVO() {
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
    public Long getOrderId() {
        return this.orderId;
    }

    @Generated
    public BigDecimal getCapacity() {
        return this.capacity;
    }

    @Generated
    public BigDecimal getPrice() {
        return this.price;
    }

    @Generated
    public Long getDays() {
        return this.days;
    }

    @Generated
    public BigDecimal getDiscount() {
        return this.discount;
    }

    @Generated
    public String getContinent() {
        return this.continent;
    }

    @Generated
    public List<CountryNumsItemVO> getCountryNums() {
        return this.countryNums;
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

    @Generated
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Generated
    public void setCapacity(BigDecimal capacity) {
        this.capacity = capacity;
    }

    @Generated
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Generated
    public void setDays(Long days) {
        this.days = days;
    }

    @Generated
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Generated
    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Generated
    public void setCountryNums(List<CountryNumsItemVO> countryNums) {
        this.countryNums = countryNums;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof OrderAddVO)) {
            return false;
        }
        OrderAddVO other = (OrderAddVO)o;
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
        Long this$totalIps = this.getTotalIps();
        Long other$totalIps = other.getTotalIps();
        if (this$totalIps == null ? other$totalIps != null : !((Object)this$totalIps).equals(other$totalIps)) {
            return false;
        }
        Long this$orderId = this.getOrderId();
        Long other$orderId = other.getOrderId();
        if (this$orderId == null ? other$orderId != null : !((Object)this$orderId).equals(other$orderId)) {
            return false;
        }
        Long this$days = this.getDays();
        Long other$days = other.getDays();
        if (this$days == null ? other$days != null : !((Object)this$days).equals(other$days)) {
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
        BigDecimal this$capacity = this.getCapacity();
        BigDecimal other$capacity = other.getCapacity();
        if (this$capacity == null ? other$capacity != null : !((Object)this$capacity).equals(other$capacity)) {
            return false;
        }
        BigDecimal this$price = this.getPrice();
        BigDecimal other$price = other.getPrice();
        if (this$price == null ? other$price != null : !((Object)this$price).equals(other$price)) {
            return false;
        }
        BigDecimal this$discount = this.getDiscount();
        BigDecimal other$discount = other.getDiscount();
        if (this$discount == null ? other$discount != null : !((Object)this$discount).equals(other$discount)) {
            return false;
        }
        String this$continent = this.getContinent();
        String other$continent = other.getContinent();
        if (this$continent == null ? other$continent != null : !this$continent.equals(other$continent)) {
            return false;
        }
        List<CountryNumsItemVO> this$countryNums = this.getCountryNums();
        List<CountryNumsItemVO> other$countryNums = other.getCountryNums();
        return !(this$countryNums == null ? other$countryNums != null : !((Object)this$countryNums).equals(other$countryNums));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof OrderAddVO;
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
        Long $totalIps = this.getTotalIps();
        result = result * 59 + ($totalIps == null ? 43 : ((Object)$totalIps).hashCode());
        Long $orderId = this.getOrderId();
        result = result * 59 + ($orderId == null ? 43 : ((Object)$orderId).hashCode());
        Long $days = this.getDays();
        result = result * 59 + ($days == null ? 43 : ((Object)$days).hashCode());
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
        BigDecimal $capacity = this.getCapacity();
        result = result * 59 + ($capacity == null ? 43 : ((Object)$capacity).hashCode());
        BigDecimal $price = this.getPrice();
        result = result * 59 + ($price == null ? 43 : ((Object)$price).hashCode());
        BigDecimal $discount = this.getDiscount();
        result = result * 59 + ($discount == null ? 43 : ((Object)$discount).hashCode());
        String $continent = this.getContinent();
        result = result * 59 + ($continent == null ? 43 : $continent.hashCode());
        List<CountryNumsItemVO> $countryNums = this.getCountryNums();
        result = result * 59 + ($countryNums == null ? 43 : ((Object)$countryNums).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "OrderAddVO(merchantId=" + this.getMerchantId() + ", domain=" + this.getDomain() + ", productName=" + this.getProductName() + ", productType=" + this.getProductType() + ", quantity=" + this.getQuantity() + ", totalAmount=" + this.getTotalAmount() + ", currency=" + this.getCurrency() + ", payMethod=" + this.getPayMethod() + ", totalIps=" + this.getTotalIps() + ", udp=" + this.getUdp() + ", orderId=" + this.getOrderId() + ", capacity=" + this.getCapacity() + ", price=" + this.getPrice() + ", days=" + this.getDays() + ", discount=" + this.getDiscount() + ", continent=" + this.getContinent() + ", countryNums=" + this.getCountryNums() + ")";
    }
}

