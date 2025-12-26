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

public class SetSupportedProtocolsRequest
implements Serializable {
    @JsonProperty(value="subuser_id")
    private Long subUserId;
    @JsonProperty(value="supported_protocols")
    private List<String> supportedProtocols;

    @Generated
    public static SetSupportedProtocolsRequestBuilder builder() {
        return new SetSupportedProtocolsRequestBuilder();
    }

    @Generated
    public SetSupportedProtocolsRequest(Long subUserId, List<String> supportedProtocols) {
        this.subUserId = subUserId;
        this.supportedProtocols = supportedProtocols;
    }

    @Generated
    public SetSupportedProtocolsRequest() {
    }

    @Generated
    public Long getSubUserId() {
        return this.subUserId;
    }

    @Generated
    public List<String> getSupportedProtocols() {
        return this.supportedProtocols;
    }

    @JsonProperty(value="subuser_id")
    @Generated
    public void setSubUserId(Long subUserId) {
        this.subUserId = subUserId;
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
        if (!(o instanceof SetSupportedProtocolsRequest)) {
            return false;
        }
        SetSupportedProtocolsRequest other = (SetSupportedProtocolsRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$subUserId = this.getSubUserId();
        Long other$subUserId = other.getSubUserId();
        if (this$subUserId == null ? other$subUserId != null : !((Object)this$subUserId).equals(other$subUserId)) {
            return false;
        }
        List<String> this$supportedProtocols = this.getSupportedProtocols();
        List<String> other$supportedProtocols = other.getSupportedProtocols();
        return !(this$supportedProtocols == null ? other$supportedProtocols != null : !((Object)this$supportedProtocols).equals(other$supportedProtocols));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof SetSupportedProtocolsRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $subUserId = this.getSubUserId();
        result = result * 59 + ($subUserId == null ? 43 : ((Object)$subUserId).hashCode());
        List<String> $supportedProtocols = this.getSupportedProtocols();
        result = result * 59 + ($supportedProtocols == null ? 43 : ((Object)$supportedProtocols).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "SetSupportedProtocolsRequest(subUserId=" + this.getSubUserId() + ", supportedProtocols=" + this.getSupportedProtocols() + ")";
    }

    @Generated
    public static class SetSupportedProtocolsRequestBuilder {
        @Generated
        private Long subUserId;
        @Generated
        private List<String> supportedProtocols;

        @Generated
        SetSupportedProtocolsRequestBuilder() {
        }

        @JsonProperty(value="subuser_id")
        @Generated
        public SetSupportedProtocolsRequestBuilder subUserId(Long subUserId) {
            this.subUserId = subUserId;
            return this;
        }

        @JsonProperty(value="supported_protocols")
        @Generated
        public SetSupportedProtocolsRequestBuilder supportedProtocols(List<String> supportedProtocols) {
            this.supportedProtocols = supportedProtocols;
            return this;
        }

        @Generated
        public SetSupportedProtocolsRequest build() {
            return new SetSupportedProtocolsRequest(this.subUserId, this.supportedProtocols);
        }

        @Generated
        public String toString() {
            return "SetSupportedProtocolsRequest.SetSupportedProtocolsRequestBuilder(subUserId=" + this.subUserId + ", supportedProtocols=" + this.supportedProtocols + ")";
        }
    }
}

