/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonOrder
 *  com.kylin.kton.system.domain.KtonOrderItemStatic
 *  lombok.Generated
 */
package com.kylin.kton.admin.order.entity.dto;

import com.kylin.kton.system.domain.KtonOrder;
import com.kylin.kton.system.domain.KtonOrderItemStatic;
import java.util.List;
import lombok.Generated;

public class AdminOrderItemStaticDTO
extends KtonOrder {
    List<KtonOrderItemStatic> itemStaticList;

    @Generated
    public AdminOrderItemStaticDTO() {
    }

    @Generated
    public List<KtonOrderItemStatic> getItemStaticList() {
        return this.itemStaticList;
    }

    @Generated
    public void setItemStaticList(List<KtonOrderItemStatic> itemStaticList) {
        this.itemStaticList = itemStaticList;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminOrderItemStaticDTO)) {
            return false;
        }
        AdminOrderItemStaticDTO other = (AdminOrderItemStaticDTO)((Object)o);
        if (!other.canEqual((Object)this)) {
            return false;
        }
        List<KtonOrderItemStatic> this$itemStaticList = this.getItemStaticList();
        List<KtonOrderItemStatic> other$itemStaticList = other.getItemStaticList();
        return !(this$itemStaticList == null ? other$itemStaticList != null : !((Object)this$itemStaticList).equals(other$itemStaticList));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminOrderItemStaticDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        List<KtonOrderItemStatic> $itemStaticList = this.getItemStaticList();
        result = result * 59 + ($itemStaticList == null ? 43 : ((Object)$itemStaticList).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminOrderItemStaticDTO(itemStaticList=" + this.getItemStaticList() + ")";
    }
}

