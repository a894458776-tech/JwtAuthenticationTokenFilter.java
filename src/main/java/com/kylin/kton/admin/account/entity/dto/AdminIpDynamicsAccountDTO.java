/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccount
 *  com.kylin.kton.system.domain.KtonMerchant
 *  lombok.Generated
 */
package com.kylin.kton.admin.account.entity.dto;

import com.kylin.kton.system.domain.KtonIpDynamicsAccount;
import com.kylin.kton.system.domain.KtonMerchant;
import lombok.Generated;

public class AdminIpDynamicsAccountDTO
extends KtonIpDynamicsAccount {
    KtonMerchant merchant;

    @Generated
    public AdminIpDynamicsAccountDTO() {
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
        if (!(o instanceof AdminIpDynamicsAccountDTO)) {
            return false;
        }
        AdminIpDynamicsAccountDTO other = (AdminIpDynamicsAccountDTO)((Object)o);
        if (!other.canEqual((Object)this)) {
            return false;
        }
        KtonMerchant this$merchant = this.getMerchant();
        KtonMerchant other$merchant = other.getMerchant();
        return !(this$merchant == null ? other$merchant != null : !this$merchant.equals(other$merchant));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminIpDynamicsAccountDTO;
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
        return "AdminIpDynamicsAccountDTO(merchant=" + this.getMerchant() + ")";
    }
}

