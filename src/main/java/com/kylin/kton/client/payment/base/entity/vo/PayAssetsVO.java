/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.swagger.annotations.ApiModel
 *  io.swagger.annotations.ApiModelProperty
 *  javax.validation.constraints.NotNull
 *  javax.validation.constraints.Pattern
 *  lombok.Generated
 */
package com.kylin.kton.client.payment.base.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Generated;

@ApiModel(value="\u8ba2\u5355\u652f\u6301\u7edf\u4e00\u5165\u53e3")
public class PayAssetsVO {
    @ApiModelProperty(value="\u5145\u503c\u91d1\u989d")
    @NotNull(message="\u5145\u503c\u91d1\u989d\u4e0d\u80fd\u4e3a\u7a7a")
    @NotNull(message="\u5145\u503c\u91d1\u989d\u4e0d\u80fd\u4e3a\u7a7a") BigDecimal amount;
    @ApiModelProperty(value="\u652f\u4ed8\u65b9\u5f0f")
    @Pattern(regexp="WXMINI|JSAPI|DTCPAY|CREDIT|NATIVE|MWEB|BALANCE|COMBINATION|MEMBER_INTEGRAL|MEMBER_INTEGRAL_COMBINATION", message="\u652f\u4ed8\u65b9\u5f0f\u9519\u8bef")
    @Pattern(regexp="WXMINI|JSAPI|DTCPAY|CREDIT|NATIVE|MWEB|BALANCE|COMBINATION|MEMBER_INTEGRAL|MEMBER_INTEGRAL_COMBINATION", message="\u652f\u4ed8\u65b9\u5f0f\u9519\u8bef") String payment;

    @Generated
    public PayAssetsVO() {
    }

    @Generated
    public BigDecimal getAmount() {
        return this.amount;
    }

    @Generated
    public String getPayment() {
        return this.payment;
    }

    @Generated
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Generated
    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PayAssetsVO)) {
            return false;
        }
        PayAssetsVO other = (PayAssetsVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        BigDecimal this$amount = this.getAmount();
        BigDecimal other$amount = other.getAmount();
        if (this$amount == null ? other$amount != null : !((Object)this$amount).equals(other$amount)) {
            return false;
        }
        String this$payment = this.getPayment();
        String other$payment = other.getPayment();
        return !(this$payment == null ? other$payment != null : !this$payment.equals(other$payment));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof PayAssetsVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        BigDecimal $amount = this.getAmount();
        result = result * 59 + ($amount == null ? 43 : ((Object)$amount).hashCode());
        String $payment = this.getPayment();
        result = result * 59 + ($payment == null ? 43 : $payment.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "PayAssetsVO(amount=" + this.getAmount() + ", payment=" + this.getPayment() + ")";
    }
}

