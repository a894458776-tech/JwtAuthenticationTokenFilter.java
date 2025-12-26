/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.swagger.annotations.ApiModelProperty
 *  javax.validation.constraints.NotNull
 *  javax.validation.constraints.Pattern
 *  lombok.Generated
 */
package com.kylin.kton.client.order.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Generated;

public class VpsOrderAddVO {
    private Long merchantId;
    @ApiModelProperty(value="\u652f\u4ed8\u65b9\u5f0f")
    @Pattern(regexp="PAY_FIRST|PAY_LATER", message="\u652f\u4ed8\u65b9\u5f0f\u9519\u8bef")
    @NotNull(message="payMode can not be null")
    private @Pattern(regexp="PAY_FIRST|PAY_LATER", message="\u652f\u4ed8\u65b9\u5f0f\u9519\u8bef") @NotNull(message="payMode can not be null") String payMode;
    @NotNull(message="activationDurationType can not be null")
    private @NotNull(message="activationDurationType can not be null") String activationDurationType;
    private List<OrderItem> orderItems;

    @Generated
    public VpsOrderAddVO() {
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
    public String getActivationDurationType() {
        return this.activationDurationType;
    }

    @Generated
    public List<OrderItem> getOrderItems() {
        return this.orderItems;
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
    public void setActivationDurationType(String activationDurationType) {
        this.activationDurationType = activationDurationType;
    }

    @Generated
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof VpsOrderAddVO)) {
            return false;
        }
        VpsOrderAddVO other = (VpsOrderAddVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        String this$payMode = this.getPayMode();
        String other$payMode = other.getPayMode();
        if (this$payMode == null ? other$payMode != null : !this$payMode.equals(other$payMode)) {
            return false;
        }
        String this$activationDurationType = this.getActivationDurationType();
        String other$activationDurationType = other.getActivationDurationType();
        if (this$activationDurationType == null ? other$activationDurationType != null : !this$activationDurationType.equals(other$activationDurationType)) {
            return false;
        }
        List<OrderItem> this$orderItems = this.getOrderItems();
        List<OrderItem> other$orderItems = other.getOrderItems();
        return !(this$orderItems == null ? other$orderItems != null : !((Object)this$orderItems).equals(other$orderItems));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof VpsOrderAddVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        String $payMode = this.getPayMode();
        result = result * 59 + ($payMode == null ? 43 : $payMode.hashCode());
        String $activationDurationType = this.getActivationDurationType();
        result = result * 59 + ($activationDurationType == null ? 43 : $activationDurationType.hashCode());
        List<OrderItem> $orderItems = this.getOrderItems();
        result = result * 59 + ($orderItems == null ? 43 : ((Object)$orderItems).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "VpsOrderAddVO(merchantId=" + this.getMerchantId() + ", payMode=" + this.getPayMode() + ", activationDurationType=" + this.getActivationDurationType() + ", orderItems=" + this.getOrderItems() + ")";
    }

    public static class OrderItem {
        @ApiModelProperty(value="\u914d\u7f6e\u6a21\u7248ID")
        private String hostTemplateId;
        @ApiModelProperty(value="\u5bb9\u5668ID")
        private String containerId;
        @ApiModelProperty(value="\u955c\u50cfID")
        private String imagesId;

        @Generated
        public OrderItem() {
        }

        @Generated
        public String getHostTemplateId() {
            return this.hostTemplateId;
        }

        @Generated
        public String getContainerId() {
            return this.containerId;
        }

        @Generated
        public String getImagesId() {
            return this.imagesId;
        }

        @Generated
        public void setHostTemplateId(String hostTemplateId) {
            this.hostTemplateId = hostTemplateId;
        }

        @Generated
        public void setContainerId(String containerId) {
            this.containerId = containerId;
        }

        @Generated
        public void setImagesId(String imagesId) {
            this.imagesId = imagesId;
        }

        @Generated
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof OrderItem)) {
                return false;
            }
            OrderItem other = (OrderItem)o;
            if (!other.canEqual(this)) {
                return false;
            }
            String this$hostTemplateId = this.getHostTemplateId();
            String other$hostTemplateId = other.getHostTemplateId();
            if (this$hostTemplateId == null ? other$hostTemplateId != null : !this$hostTemplateId.equals(other$hostTemplateId)) {
                return false;
            }
            String this$containerId = this.getContainerId();
            String other$containerId = other.getContainerId();
            if (this$containerId == null ? other$containerId != null : !this$containerId.equals(other$containerId)) {
                return false;
            }
            String this$imagesId = this.getImagesId();
            String other$imagesId = other.getImagesId();
            return !(this$imagesId == null ? other$imagesId != null : !this$imagesId.equals(other$imagesId));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof OrderItem;
        }

        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            String $hostTemplateId = this.getHostTemplateId();
            result = result * 59 + ($hostTemplateId == null ? 43 : $hostTemplateId.hashCode());
            String $containerId = this.getContainerId();
            result = result * 59 + ($containerId == null ? 43 : $containerId.hashCode());
            String $imagesId = this.getImagesId();
            result = result * 59 + ($imagesId == null ? 43 : $imagesId.hashCode());
            return result;
        }

        @Generated
        public String toString() {
            return "VpsOrderAddVO.OrderItem(hostTemplateId=" + this.getHostTemplateId() + ", containerId=" + this.getContainerId() + ", imagesId=" + this.getImagesId() + ")";
        }
    }
}

