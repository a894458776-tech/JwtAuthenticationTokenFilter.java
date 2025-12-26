/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import lombok.Generated;

public class TrafficCityAndStateRequest {
    @Generated
    public TrafficCityAndStateRequest() {
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TrafficCityAndStateRequest)) {
            return false;
        }
        TrafficCityAndStateRequest other = (TrafficCityAndStateRequest)o;
        return other.canEqual(this);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof TrafficCityAndStateRequest;
    }

    @Generated
    public int hashCode() {
        boolean result = true;
        return 1;
    }

    @Generated
    public String toString() {
        return "TrafficCityAndStateRequest()";
    }
}

