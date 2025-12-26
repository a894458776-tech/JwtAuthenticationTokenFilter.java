/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.order.entity.dto;

import lombok.Generated;

public class DaysUntilExpireDTO {
    private Integer daysUntilExpire;

    @Generated
    public DaysUntilExpireDTO() {
    }

    @Generated
    public Integer getDaysUntilExpire() {
        return this.daysUntilExpire;
    }

    @Generated
    public void setDaysUntilExpire(Integer daysUntilExpire) {
        this.daysUntilExpire = daysUntilExpire;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DaysUntilExpireDTO)) {
            return false;
        }
        DaysUntilExpireDTO other = (DaysUntilExpireDTO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Integer this$daysUntilExpire = this.getDaysUntilExpire();
        Integer other$daysUntilExpire = other.getDaysUntilExpire();
        return !(this$daysUntilExpire == null ? other$daysUntilExpire != null : !((Object)this$daysUntilExpire).equals(other$daysUntilExpire));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof DaysUntilExpireDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $daysUntilExpire = this.getDaysUntilExpire();
        result = result * 59 + ($daysUntilExpire == null ? 43 : ((Object)$daysUntilExpire).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "DaysUntilExpireDTO(daysUntilExpire=" + this.getDaysUntilExpire() + ")";
    }
}

