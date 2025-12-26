/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.swagger.annotations.ApiModelProperty
 *  javax.validation.Valid
 *  javax.validation.constraints.NotNull
 *  lombok.Generated
 */
package com.kylin.kton.client.order.entity.vo;

import com.kylin.kton.client.order.entity.vo.CountryNumsItemVO;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Generated;

public class OrderStaticAddVO {
    private Long merchantId;
    @ApiModelProperty(value="\u652f\u4ed8\u65b9\u5f0f")
    private String payMode;
    private String currency = "USD";
    private String payMethod = "BALANCE";
    @NotNull(message="\u8d2d\u4e70\u6709\u6548\u671f\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="\u8d2d\u4e70\u6709\u6548\u671f\u4e0d\u80fd\u4e3a\u7a7a") Long monthCount;
    @Valid
    List<CountryNumsItemVO> countryNums = new ArrayList<CountryNumsItemVO>();
    private Long isExclusive = 0L;

    @Generated
    public OrderStaticAddVO() {
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public String getPayMode() {
        return this.payMode;
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
    public Long getMonthCount() {
        return this.monthCount;
    }

    @Generated
    public List<CountryNumsItemVO> getCountryNums() {
        return this.countryNums;
    }

    @Generated
    public Long getIsExclusive() {
        return this.isExclusive;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public void setPayMode(String payMode) {
        this.payMode = payMode;
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
    public void setMonthCount(Long monthCount) {
        this.monthCount = monthCount;
    }

    @Generated
    public void setCountryNums(List<CountryNumsItemVO> countryNums) {
        this.countryNums = countryNums;
    }

    @Generated
    public void setIsExclusive(Long isExclusive) {
        this.isExclusive = isExclusive;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof OrderStaticAddVO)) {
            return false;
        }
        OrderStaticAddVO other = (OrderStaticAddVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        Long this$monthCount = this.getMonthCount();
        Long other$monthCount = other.getMonthCount();
        if (this$monthCount == null ? other$monthCount != null : !((Object)this$monthCount).equals(other$monthCount)) {
            return false;
        }
        Long this$isExclusive = this.getIsExclusive();
        Long other$isExclusive = other.getIsExclusive();
        if (this$isExclusive == null ? other$isExclusive != null : !((Object)this$isExclusive).equals(other$isExclusive)) {
            return false;
        }
        String this$payMode = this.getPayMode();
        String other$payMode = other.getPayMode();
        if (this$payMode == null ? other$payMode != null : !this$payMode.equals(other$payMode)) {
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
        List<CountryNumsItemVO> this$countryNums = this.getCountryNums();
        List<CountryNumsItemVO> other$countryNums = other.getCountryNums();
        return !(this$countryNums == null ? other$countryNums != null : !((Object)this$countryNums).equals(other$countryNums));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof OrderStaticAddVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        Long $monthCount = this.getMonthCount();
        result = result * 59 + ($monthCount == null ? 43 : ((Object)$monthCount).hashCode());
        Long $isExclusive = this.getIsExclusive();
        result = result * 59 + ($isExclusive == null ? 43 : ((Object)$isExclusive).hashCode());
        String $payMode = this.getPayMode();
        result = result * 59 + ($payMode == null ? 43 : $payMode.hashCode());
        String $currency = this.getCurrency();
        result = result * 59 + ($currency == null ? 43 : $currency.hashCode());
        String $payMethod = this.getPayMethod();
        result = result * 59 + ($payMethod == null ? 43 : $payMethod.hashCode());
        List<CountryNumsItemVO> $countryNums = this.getCountryNums();
        result = result * 59 + ($countryNums == null ? 43 : ((Object)$countryNums).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "OrderStaticAddVO(merchantId=" + this.getMerchantId() + ", payMode=" + this.getPayMode() + ", currency=" + this.getCurrency() + ", payMethod=" + this.getPayMethod() + ", monthCount=" + this.getMonthCount() + ", countryNums=" + this.getCountryNums() + ", isExclusive=" + this.getIsExclusive() + ")";
    }
}

