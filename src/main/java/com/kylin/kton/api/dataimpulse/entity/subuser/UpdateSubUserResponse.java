/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.dataimpulse.entity.subuser;

import com.kylin.kton.api.dataimpulse.entity.subuser.SubUserInfo;
import java.io.Serializable;
import lombok.Generated;

public class UpdateSubUserResponse
extends SubUserInfo
implements Serializable {
    @Override
    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof UpdateSubUserResponse)) {
            return false;
        }
        UpdateSubUserResponse other = (UpdateSubUserResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        return super.equals(o);
    }

    @Override
    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof UpdateSubUserResponse;
    }

    @Override
    @Generated
    public int hashCode() {
        int result = super.hashCode();
        return result;
    }

    @Generated
    public UpdateSubUserResponse() {
    }

    @Override
    @Generated
    public String toString() {
        return "UpdateSubUserResponse()";
    }
}

