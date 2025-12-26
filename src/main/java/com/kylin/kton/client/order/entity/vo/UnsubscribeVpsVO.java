/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.swagger.annotations.ApiModelProperty
 *  javax.validation.constraints.NotNull
 *  lombok.Generated
 */
package com.kylin.kton.client.order.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Generated;

public class UnsubscribeVpsVO {
    @ApiModelProperty(value="\u5546\u6237ID")
    private Long merchantId;
    @ApiModelProperty(value="\u9000\u8ba2\u5bb9\u5668ID\u5217\u8868", required=true)
    @NotNull(message="\u9000\u8ba2\u5bb9\u5668ID\u5217\u8868\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="\u9000\u8ba2\u5bb9\u5668ID\u5217\u8868\u4e0d\u80fd\u4e3a\u7a7a") String unsubscribeContainerIds;

    @Generated
    public UnsubscribeVpsVO() {
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public String getUnsubscribeContainerIds() {
        return this.unsubscribeContainerIds;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public void setUnsubscribeContainerIds(String unsubscribeContainerIds) {
        this.unsubscribeContainerIds = unsubscribeContainerIds;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof UnsubscribeVpsVO)) {
            return false;
        }
        UnsubscribeVpsVO other = (UnsubscribeVpsVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        String this$unsubscribeContainerIds = this.getUnsubscribeContainerIds();
        String other$unsubscribeContainerIds = other.getUnsubscribeContainerIds();
        return !(this$unsubscribeContainerIds == null ? other$unsubscribeContainerIds != null : !this$unsubscribeContainerIds.equals(other$unsubscribeContainerIds));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof UnsubscribeVpsVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        String $unsubscribeContainerIds = this.getUnsubscribeContainerIds();
        result = result * 59 + ($unsubscribeContainerIds == null ? 43 : $unsubscribeContainerIds.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "UnsubscribeVpsVO(merchantId=" + this.getMerchantId() + ", unsubscribeContainerIds=" + this.getUnsubscribeContainerIds() + ")";
    }
}

