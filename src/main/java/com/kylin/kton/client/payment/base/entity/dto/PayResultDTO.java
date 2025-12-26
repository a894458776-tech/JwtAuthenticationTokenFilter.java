/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.swagger.annotations.ApiModel
 *  io.swagger.annotations.ApiModelProperty
 *  lombok.Generated
 */
package com.kylin.kton.client.payment.base.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Generated;

@ApiModel(value="\u652f\u4ed8\u7ed3\u679c")
public class PayResultDTO {
    @ApiModelProperty(value="\u652f\u4ed8\u65b9\u5f0f")
    String paymentType;
    @ApiModelProperty(value="\u652f\u4ed8\u540d\u79f0")
    String paymentName;
    @ApiModelProperty(value="\u8ba2\u5355ID")
    Long orderId;
    @ApiModelProperty(value="\u652f\u4ed8\u72b6\u6001(1:\u6210\u529f,0:\u5931\u8d25)")
    Integer status = 1;
    @ApiModelProperty(value="\u652f\u4ed8\u7ed3\u679c")
    String payMessage;

    @Generated
    public PayResultDTO() {
    }

    @Generated
    public String getPaymentType() {
        return this.paymentType;
    }

    @Generated
    public String getPaymentName() {
        return this.paymentName;
    }

    @Generated
    public Long getOrderId() {
        return this.orderId;
    }

    @Generated
    public Integer getStatus() {
        return this.status;
    }

    @Generated
    public String getPayMessage() {
        return this.payMessage;
    }

    @Generated
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Generated
    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    @Generated
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Generated
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Generated
    public void setPayMessage(String payMessage) {
        this.payMessage = payMessage;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PayResultDTO)) {
            return false;
        }
        PayResultDTO other = (PayResultDTO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$orderId = this.getOrderId();
        Long other$orderId = other.getOrderId();
        if (this$orderId == null ? other$orderId != null : !((Object)this$orderId).equals(other$orderId)) {
            return false;
        }
        Integer this$status = this.getStatus();
        Integer other$status = other.getStatus();
        if (this$status == null ? other$status != null : !((Object)this$status).equals(other$status)) {
            return false;
        }
        String this$paymentType = this.getPaymentType();
        String other$paymentType = other.getPaymentType();
        if (this$paymentType == null ? other$paymentType != null : !this$paymentType.equals(other$paymentType)) {
            return false;
        }
        String this$paymentName = this.getPaymentName();
        String other$paymentName = other.getPaymentName();
        if (this$paymentName == null ? other$paymentName != null : !this$paymentName.equals(other$paymentName)) {
            return false;
        }
        String this$payMessage = this.getPayMessage();
        String other$payMessage = other.getPayMessage();
        return !(this$payMessage == null ? other$payMessage != null : !this$payMessage.equals(other$payMessage));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof PayResultDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $orderId = this.getOrderId();
        result = result * 59 + ($orderId == null ? 43 : ((Object)$orderId).hashCode());
        Integer $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : ((Object)$status).hashCode());
        String $paymentType = this.getPaymentType();
        result = result * 59 + ($paymentType == null ? 43 : $paymentType.hashCode());
        String $paymentName = this.getPaymentName();
        result = result * 59 + ($paymentName == null ? 43 : $paymentName.hashCode());
        String $payMessage = this.getPayMessage();
        result = result * 59 + ($payMessage == null ? 43 : $payMessage.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "PayResultDTO(paymentType=" + this.getPaymentType() + ", paymentName=" + this.getPaymentName() + ", orderId=" + this.getOrderId() + ", status=" + this.getStatus() + ", payMessage=" + this.getPayMessage() + ")";
    }
}

