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

public class SetLocationsStatesResponse
extends SubUserInfo
implements Serializable {
    @Override
    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SetLocationsStatesResponse)) {
            return false;
        }
        SetLocationsStatesResponse other = (SetLocationsStatesResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        return super.equals(o);
    }

    @Override
    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof SetLocationsStatesResponse;
    }

    @Override
    @Generated
    public int hashCode() {
        int result = super.hashCode();
        return result;
    }

    @Generated
    public SetLocationsStatesResponse() {
    }

    @Override
    @Generated
    public String toString() {
        return "SetLocationsStatesResponse()";
    }
}

