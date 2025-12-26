/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonOrder
 *  com.kylin.kton.system.domain.KtonOrderItemStatic
 *  io.swagger.annotations.ApiModel
 *  io.swagger.annotations.ApiModelProperty
 *  lombok.Generated
 */
package com.kylin.kton.admin.order.entity.dto;

import com.kylin.kton.system.domain.KtonOrder;
import com.kylin.kton.system.domain.KtonOrderItemStatic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Generated;

@ApiModel(value="\u8ba2\u5355\u8be6\u60c5")
public class AdminOrderDetailDTO
extends KtonOrder {
    @ApiModelProperty(value="\u8ba2\u5355\u660e\u7ec6")
    private List<KtonOrderItemStatic> orderItems;

    @Generated
    public AdminOrderDetailDTO() {
    }

    @Generated
    public List<KtonOrderItemStatic> getOrderItems() {
        return this.orderItems;
    }

    @Generated
    public void setOrderItems(List<KtonOrderItemStatic> orderItems) {
        this.orderItems = orderItems;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminOrderDetailDTO)) {
            return false;
        }
        AdminOrderDetailDTO other = (AdminOrderDetailDTO)((Object)o);
        if (!other.canEqual((Object)this)) {
            return false;
        }
        List<KtonOrderItemStatic> this$orderItems = this.getOrderItems();
        List<KtonOrderItemStatic> other$orderItems = other.getOrderItems();
        return !(this$orderItems == null ? other$orderItems != null : !((Object)this$orderItems).equals(other$orderItems));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminOrderDetailDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        List<KtonOrderItemStatic> $orderItems = this.getOrderItems();
        result = result * 59 + ($orderItems == null ? 43 : ((Object)$orderItems).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminOrderDetailDTO(orderItems=" + this.getOrderItems() + ")";
    }
}

