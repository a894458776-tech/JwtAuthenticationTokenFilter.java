/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import lombok.Generated;

public class DisableSubUserRequest {
    @Generated
    public DisableSubUserRequest() {
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DisableSubUserRequest)) {
            return false;
        }
        DisableSubUserRequest other = (DisableSubUserRequest)o;
        return other.canEqual(this);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof DisableSubUserRequest;
    }

    @Generated
    public int hashCode() {
        boolean result = true;
        return 1;
    }

    @Generated
    public String toString() {
        return "DisableSubUserRequest()";
    }
}

