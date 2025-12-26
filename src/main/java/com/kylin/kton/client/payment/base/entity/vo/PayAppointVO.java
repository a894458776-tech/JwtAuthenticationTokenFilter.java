/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.swagger.annotations.ApiModel
 *  io.swagger.annotations.ApiModelProperty
 *  javax.validation.constraints.Pattern
 *  lombok.Generated
 */
package com.kylin.kton.client.payment.base.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Pattern;
import lombok.Generated;

@ApiModel(value="\u8ba2\u5355\u652f\u6301\u7edf\u4e00\u5165\u53e3")
public class PayAppointVO {
    @ApiModelProperty(value="\u652f\u4ed8\u65b9\u5f0f")
    @Pattern(regexp="WXMINI|JSAPI|DTCPAY|CREDIT|NATIVE|MWEB|BALANCE|COMBINATION|MEMBER_INTEGRAL|MEMBER_INTEGRAL_COMBINATION", message="\u652f\u4ed8\u65b9\u5f0f\u9519\u8bef")
    @Pattern(regexp="WXMINI|JSAPI|DTCPAY|CREDIT|NATIVE|MWEB|BALANCE|COMBINATION|MEMBER_INTEGRAL|MEMBER_INTEGRAL_COMBINATION", message="\u652f\u4ed8\u65b9\u5f0f\u9519\u8bef") String payment;

    @Generated
    public PayAppointVO() {
    }

    @Generated
    public String getPayment() {
        return this.payment;
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
        if (!(o instanceof PayAppointVO)) {
            return false;
        }
        PayAppointVO other = (PayAppointVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$payment = this.getPayment();
        String other$payment = other.getPayment();
        return !(this$payment == null ? other$payment != null : !this$payment.equals(other$payment));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof PayAppointVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $payment = this.getPayment();
        result = result * 59 + ($payment == null ? 43 : $payment.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "PayAppointVO(payment=" + this.getPayment() + ")";
    }
}

