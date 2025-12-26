/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticConfigPlan
 *  com.kylin.kton.system.domain.KtonMerchant
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.dto;

import com.kylin.kton.system.domain.KtonIpStaticConfigPlan;
import com.kylin.kton.system.domain.KtonMerchant;
import lombok.Generated;

public class AdminIpStaticConfigPlanDTO
extends KtonIpStaticConfigPlan {
    private KtonMerchant merchant;

    @Generated
    public AdminIpStaticConfigPlanDTO() {
    }

    @Generated
    public KtonMerchant getMerchant() {
        return this.merchant;
    }

    @Generated
    public void setMerchant(KtonMerchant merchant) {
        this.merchant = merchant;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminIpStaticConfigPlanDTO)) {
            return false;
        }
        AdminIpStaticConfigPlanDTO other = (AdminIpStaticConfigPlanDTO)((Object)o);
        if (!other.canEqual((Object)this)) {
            return false;
        }
        KtonMerchant this$merchant = this.getMerchant();
        KtonMerchant other$merchant = other.getMerchant();
        return !(this$merchant == null ? other$merchant != null : !this$merchant.equals(other$merchant));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminIpStaticConfigPlanDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        KtonMerchant $merchant = this.getMerchant();
        result = result * 59 + ($merchant == null ? 43 : $merchant.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminIpStaticConfigPlanDTO(merchant=" + this.getMerchant() + ")";
    }
}

