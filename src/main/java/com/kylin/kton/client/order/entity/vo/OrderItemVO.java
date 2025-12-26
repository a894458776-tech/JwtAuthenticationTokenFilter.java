/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.validation.constraints.NotNull
 *  lombok.Generated
 */
package com.kylin.kton.client.order.entity.vo;

import javax.validation.constraints.NotNull;
import lombok.Generated;

public class OrderItemVO {
    @NotNull(message="\u914d\u7f6e\u6a21\u7248ID\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="\u914d\u7f6e\u6a21\u7248ID\u4e0d\u80fd\u4e3a\u7a7a") Long hostTemplateId;
    @NotNull(message="vps\u7c7b\u578b\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="vps\u7c7b\u578b\u4e0d\u80fd\u4e3a\u7a7a") Long vpsType;

    @Generated
    public OrderItemVO() {
    }

    @Generated
    public Long getHostTemplateId() {
        return this.hostTemplateId;
    }

    @Generated
    public Long getVpsType() {
        return this.vpsType;
    }

    @Generated
    public void setHostTemplateId(Long hostTemplateId) {
        this.hostTemplateId = hostTemplateId;
    }

    @Generated
    public void setVpsType(Long vpsType) {
        this.vpsType = vpsType;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof OrderItemVO)) {
            return false;
        }
        OrderItemVO other = (OrderItemVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$hostTemplateId = this.getHostTemplateId();
        Long other$hostTemplateId = other.getHostTemplateId();
        if (this$hostTemplateId == null ? other$hostTemplateId != null : !((Object)this$hostTemplateId).equals(other$hostTemplateId)) {
            return false;
        }
        Long this$vpsType = this.getVpsType();
        Long other$vpsType = other.getVpsType();
        return !(this$vpsType == null ? other$vpsType != null : !((Object)this$vpsType).equals(other$vpsType));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof OrderItemVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $hostTemplateId = this.getHostTemplateId();
        result = result * 59 + ($hostTemplateId == null ? 43 : ((Object)$hostTemplateId).hashCode());
        Long $vpsType = this.getVpsType();
        result = result * 59 + ($vpsType == null ? 43 : ((Object)$vpsType).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "OrderItemVO(hostTemplateId=" + this.getHostTemplateId() + ", vpsType=" + this.getVpsType() + ")";
    }
}

