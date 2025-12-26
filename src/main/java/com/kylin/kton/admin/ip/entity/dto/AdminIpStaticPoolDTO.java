/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticPool
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.dto;

import com.kylin.kton.system.domain.KtonIpStaticPool;
import lombok.Generated;

public class AdminIpStaticPoolDTO
extends KtonIpStaticPool {
    private Integer ipTotals;
    private Integer effectiveTotals;

    @Generated
    public AdminIpStaticPoolDTO() {
    }

    @Generated
    public Integer getIpTotals() {
        return this.ipTotals;
    }

    @Generated
    public Integer getEffectiveTotals() {
        return this.effectiveTotals;
    }

    @Generated
    public void setIpTotals(Integer ipTotals) {
        this.ipTotals = ipTotals;
    }

    @Generated
    public void setEffectiveTotals(Integer effectiveTotals) {
        this.effectiveTotals = effectiveTotals;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminIpStaticPoolDTO)) {
            return false;
        }
        AdminIpStaticPoolDTO other = (AdminIpStaticPoolDTO)((Object)o);
        if (!other.canEqual((Object)this)) {
            return false;
        }
        Integer this$ipTotals = this.getIpTotals();
        Integer other$ipTotals = other.getIpTotals();
        if (this$ipTotals == null ? other$ipTotals != null : !((Object)this$ipTotals).equals(other$ipTotals)) {
            return false;
        }
        Integer this$effectiveTotals = this.getEffectiveTotals();
        Integer other$effectiveTotals = other.getEffectiveTotals();
        return !(this$effectiveTotals == null ? other$effectiveTotals != null : !((Object)this$effectiveTotals).equals(other$effectiveTotals));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminIpStaticPoolDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $ipTotals = this.getIpTotals();
        result = result * 59 + ($ipTotals == null ? 43 : ((Object)$ipTotals).hashCode());
        Integer $effectiveTotals = this.getEffectiveTotals();
        result = result * 59 + ($effectiveTotals == null ? 43 : ((Object)$effectiveTotals).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminIpStaticPoolDTO(ipTotals=" + this.getIpTotals() + ", effectiveTotals=" + this.getEffectiveTotals() + ")";
    }
}

