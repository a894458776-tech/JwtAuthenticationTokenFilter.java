/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.dataimpulse.entity.subuser;

import java.io.Serializable;
import lombok.Generated;

public class MasterBalanceResponse
implements Serializable {
    private Long balance;

    @Generated
    public MasterBalanceResponse() {
    }

    @Generated
    public Long getBalance() {
        return this.balance;
    }

    @Generated
    public void setBalance(Long balance) {
        this.balance = balance;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MasterBalanceResponse)) {
            return false;
        }
        MasterBalanceResponse other = (MasterBalanceResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$balance = this.getBalance();
        Long other$balance = other.getBalance();
        return !(this$balance == null ? other$balance != null : !((Object)this$balance).equals(other$balance));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof MasterBalanceResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $balance = this.getBalance();
        result = result * 59 + ($balance == null ? 43 : ((Object)$balance).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "MasterBalanceResponse(balance=" + this.getBalance() + ")";
    }
}

