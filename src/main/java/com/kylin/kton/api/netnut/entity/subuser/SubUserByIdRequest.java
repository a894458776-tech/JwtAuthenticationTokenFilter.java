/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import lombok.Generated;

public class SubUserByIdRequest {
    @Generated
    public SubUserByIdRequest() {
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SubUserByIdRequest)) {
            return false;
        }
        SubUserByIdRequest other = (SubUserByIdRequest)o;
        return other.canEqual(this);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof SubUserByIdRequest;
    }

    @Generated
    public int hashCode() {
        boolean result = true;
        return 1;
    }

    @Generated
    public String toString() {
        return "SubUserByIdRequest()";
    }
}

