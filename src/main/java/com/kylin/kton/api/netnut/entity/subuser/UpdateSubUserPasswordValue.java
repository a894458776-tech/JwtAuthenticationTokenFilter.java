/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import lombok.Generated;

public class UpdateSubUserPasswordValue {
    private boolean updated;

    @Generated
    public UpdateSubUserPasswordValue() {
    }

    @Generated
    public boolean isUpdated() {
        return this.updated;
    }

    @Generated
    public void setUpdated(boolean updated) {
        this.updated = updated;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof UpdateSubUserPasswordValue)) {
            return false;
        }
        UpdateSubUserPasswordValue other = (UpdateSubUserPasswordValue)o;
        if (!other.canEqual(this)) {
            return false;
        }
        return this.isUpdated() == other.isUpdated();
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof UpdateSubUserPasswordValue;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isUpdated() ? 79 : 97);
        return result;
    }

    @Generated
    public String toString() {
        return "UpdateSubUserPasswordValue(updated=" + this.isUpdated() + ")";
    }
}

