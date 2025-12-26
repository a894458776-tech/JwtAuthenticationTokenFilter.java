/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.dataimpulse.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Generated;

public class RemoveAllowedIpResponse
implements Serializable {
    @JsonProperty(value="allowed_ips")
    private List<String> allowedIps;

    @Generated
    public RemoveAllowedIpResponse() {
    }

    @Generated
    public List<String> getAllowedIps() {
        return this.allowedIps;
    }

    @JsonProperty(value="allowed_ips")
    @Generated
    public void setAllowedIps(List<String> allowedIps) {
        this.allowedIps = allowedIps;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RemoveAllowedIpResponse)) {
            return false;
        }
        RemoveAllowedIpResponse other = (RemoveAllowedIpResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        List<String> this$allowedIps = this.getAllowedIps();
        List<String> other$allowedIps = other.getAllowedIps();
        return !(this$allowedIps == null ? other$allowedIps != null : !((Object)this$allowedIps).equals(other$allowedIps));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof RemoveAllowedIpResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        List<String> $allowedIps = this.getAllowedIps();
        result = result * 59 + ($allowedIps == null ? 43 : ((Object)$allowedIps).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "RemoveAllowedIpResponse(allowedIps=" + this.getAllowedIps() + ")";
    }
}

