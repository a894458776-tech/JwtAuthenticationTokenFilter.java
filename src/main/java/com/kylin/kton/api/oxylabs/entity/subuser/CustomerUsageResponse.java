/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.oxylabs.entity.subuser;

import com.kylin.kton.api.oxylabs.entity.subuser.BaseResponse;
import java.io.Serializable;
import lombok.Generated;

public class CustomerUsageResponse
extends BaseResponse
implements Serializable {
    @Override
    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CustomerUsageResponse)) {
            return false;
        }
        CustomerUsageResponse other = (CustomerUsageResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        return super.equals(o);
    }

    @Override
    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof CustomerUsageResponse;
    }

    @Override
    @Generated
    public int hashCode() {
        int result = super.hashCode();
        return result;
    }

    @Generated
    public CustomerUsageResponse() {
    }

    @Override
    @Generated
    public String toString() {
        return "CustomerUsageResponse()";
    }
}

