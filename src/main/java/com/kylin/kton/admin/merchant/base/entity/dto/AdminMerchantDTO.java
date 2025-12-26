/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonMerchant
 *  lombok.Generated
 */
package com.kylin.kton.admin.merchant.base.entity.dto;

import com.kylin.kton.system.domain.KtonMerchant;
import lombok.Generated;

public class AdminMerchantDTO
extends KtonMerchant {
    @Generated
    public AdminMerchantDTO() {
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminMerchantDTO)) {
            return false;
        }
        AdminMerchantDTO other = (AdminMerchantDTO)((Object)o);
        return other.canEqual((Object)this);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminMerchantDTO;
    }

    @Generated
    public int hashCode() {
        boolean result = true;
        return 1;
    }

    @Generated
    public String toString() {
        return "AdminMerchantDTO()";
    }
}

