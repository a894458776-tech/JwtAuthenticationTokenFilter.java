/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import lombok.Generated;

public class TrafficAvailableCountriesRequest {
    @Generated
    public TrafficAvailableCountriesRequest() {
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TrafficAvailableCountriesRequest)) {
            return false;
        }
        TrafficAvailableCountriesRequest other = (TrafficAvailableCountriesRequest)o;
        return other.canEqual(this);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof TrafficAvailableCountriesRequest;
    }

    @Generated
    public int hashCode() {
        boolean result = true;
        return 1;
    }

    @Generated
    public String toString() {
        return "TrafficAvailableCountriesRequest()";
    }
}

