/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonMerchant
 *  com.kylin.kton.system.domain.KtonTicket
 *  io.swagger.annotations.ApiModelProperty
 *  lombok.Generated
 */
package com.kylin.kton.client.ticket.entity.dto;

import com.kylin.kton.system.domain.KtonMerchant;
import com.kylin.kton.system.domain.KtonTicket;
import io.swagger.annotations.ApiModelProperty;
import lombok.Generated;

public class ClientTicketDTO
extends KtonTicket {
    @ApiModelProperty(value="\u5546\u6237\u4fe1\u606f")
    KtonMerchant merchant;

    @Generated
    public ClientTicketDTO() {
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
        if (!(o instanceof ClientTicketDTO)) {
            return false;
        }
        ClientTicketDTO other = (ClientTicketDTO)((Object)o);
        if (!other.canEqual((Object)this)) {
            return false;
        }
        KtonMerchant this$merchant = this.getMerchant();
        KtonMerchant other$merchant = other.getMerchant();
        return !(this$merchant == null ? other$merchant != null : !this$merchant.equals(other$merchant));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ClientTicketDTO;
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
        return "ClientTicketDTO(merchant=" + this.getMerchant() + ")";
    }
}

