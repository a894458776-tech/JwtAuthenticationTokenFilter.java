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

public class GetSupportedProtocolsResponse
implements Serializable {
    @JsonProperty(value="supported_protocols")
    private List<String> supportedProtocols;

    @Generated
    public GetSupportedProtocolsResponse() {
    }

    @Generated
    public List<String> getSupportedProtocols() {
        return this.supportedProtocols;
    }

    @JsonProperty(value="supported_protocols")
    @Generated
    public void setSupportedProtocols(List<String> supportedProtocols) {
        this.supportedProtocols = supportedProtocols;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof GetSupportedProtocolsResponse)) {
            return false;
        }
        GetSupportedProtocolsResponse other = (GetSupportedProtocolsResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        List<String> this$supportedProtocols = this.getSupportedProtocols();
        List<String> other$supportedProtocols = other.getSupportedProtocols();
        return !(this$supportedProtocols == null ? other$supportedProtocols != null : !((Object)this$supportedProtocols).equals(other$supportedProtocols));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof GetSupportedProtocolsResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        List<String> $supportedProtocols = this.getSupportedProtocols();
        result = result * 59 + ($supportedProtocols == null ? 43 : ((Object)$supportedProtocols).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "GetSupportedProtocolsResponse(supportedProtocols=" + this.getSupportedProtocols() + ")";
    }
}

