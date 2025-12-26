/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.order.entity.vo;

import lombok.Generated;

public class OrderDetailVO {
    @Generated
    public OrderDetailVO() {
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof OrderDetailVO)) {
            return false;
        }
        OrderDetailVO other = (OrderDetailVO)o;
        return other.canEqual(this);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof OrderDetailVO;
    }

    @Generated
    public int hashCode() {
        boolean result = true;
        return 1;
    }

    @Generated
    public String toString() {
        return "OrderDetailVO()";
    }
}

