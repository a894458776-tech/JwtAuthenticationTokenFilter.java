/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

public class SubUserListRequest {
    @JsonProperty(value="is_active")
    private boolean isActive;

    @Generated
    public SubUserListRequest() {
    }

    @Generated
    public boolean isActive() {
        return this.isActive;
    }

    @JsonProperty(value="is_active")
    @Generated
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SubUserListRequest)) {
            return false;
        }
        SubUserListRequest other = (SubUserListRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        return this.isActive() == other.isActive();
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof SubUserListRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isActive() ? 79 : 97);
        return result;
    }

    @Generated
    public String toString() {
        return "SubUserListRequest(isActive=" + this.isActive() + ")";
    }
}

