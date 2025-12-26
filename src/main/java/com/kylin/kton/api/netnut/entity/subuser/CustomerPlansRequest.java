/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import lombok.Generated;

public class CustomerPlansRequest {
    @Generated
    public CustomerPlansRequest() {
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CustomerPlansRequest)) {
            return false;
        }
        CustomerPlansRequest other = (CustomerPlansRequest)o;
        return other.canEqual(this);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof CustomerPlansRequest;
    }

    @Generated
    public int hashCode() {
        boolean result = true;
        return 1;
    }

    @Generated
    public String toString() {
        return "CustomerPlansRequest()";
    }
}

