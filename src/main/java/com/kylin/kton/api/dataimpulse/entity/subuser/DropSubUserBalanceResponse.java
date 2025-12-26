/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.dataimpulse.entity.subuser;

import com.kylin.kton.api.dataimpulse.entity.subuser.BaseResponse;
import java.io.Serializable;
import lombok.Generated;

public class DropSubUserBalanceResponse
extends BaseResponse
implements Serializable {
    @Generated
    public DropSubUserBalanceResponse() {
    }

    @Override
    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DropSubUserBalanceResponse)) {
            return false;
        }
        DropSubUserBalanceResponse other = (DropSubUserBalanceResponse)o;
        return other.canEqual(this);
    }

    @Override
    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof DropSubUserBalanceResponse;
    }

    @Override
    @Generated
    public int hashCode() {
        boolean result = true;
        return 1;
    }

    @Override
    @Generated
    public String toString() {
        return "DropSubUserBalanceResponse()";
    }
}

