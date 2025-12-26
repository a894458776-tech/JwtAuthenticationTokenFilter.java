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
import lombok.Generated;

public class SetAllowedIpRequest
implements Serializable {
    @JsonProperty(value="subuser_id")
    private Long subUserId;
    private String ip;

    @Generated
    public static SetAllowedIpRequestBuilder builder() {
        return new SetAllowedIpRequestBuilder();
    }

    @Generated
    public Long getSubUserId() {
        return this.subUserId;
    }

    @Generated
    public String getIp() {
        return this.ip;
    }

    @JsonProperty(value="subuser_id")
    @Generated
    public void setSubUserId(Long subUserId) {
        this.subUserId = subUserId;
    }

    @Generated
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SetAllowedIpRequest)) {
            return false;
        }
        SetAllowedIpRequest other = (SetAllowedIpRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$subUserId = this.getSubUserId();
        Long other$subUserId = other.getSubUserId();
        if (this$subUserId == null ? other$subUserId != null : !((Object)this$subUserId).equals(other$subUserId)) {
            return false;
        }
        String this$ip = this.getIp();
        String other$ip = other.getIp();
        return !(this$ip == null ? other$ip != null : !this$ip.equals(other$ip));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof SetAllowedIpRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $subUserId = this.getSubUserId();
        result = result * 59 + ($subUserId == null ? 43 : ((Object)$subUserId).hashCode());
        String $ip = this.getIp();
        result = result * 59 + ($ip == null ? 43 : $ip.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "SetAllowedIpRequest(subUserId=" + this.getSubUserId() + ", ip=" + this.getIp() + ")";
    }

    @Generated
    public SetAllowedIpRequest(Long subUserId, String ip) {
        this.subUserId = subUserId;
        this.ip = ip;
    }

    @Generated
    public SetAllowedIpRequest() {
    }

    @Generated
    public static class SetAllowedIpRequestBuilder {
        @Generated
        private Long subUserId;
        @Generated
        private String ip;

        @Generated
        SetAllowedIpRequestBuilder() {
        }

        @JsonProperty(value="subuser_id")
        @Generated
        public SetAllowedIpRequestBuilder subUserId(Long subUserId) {
            this.subUserId = subUserId;
            return this;
        }

        @Generated
        public SetAllowedIpRequestBuilder ip(String ip) {
            this.ip = ip;
            return this;
        }

        @Generated
        public SetAllowedIpRequest build() {
            return new SetAllowedIpRequest(this.subUserId, this.ip);
        }

        @Generated
        public String toString() {
            return "SetAllowedIpRequest.SetAllowedIpRequestBuilder(subUserId=" + this.subUserId + ", ip=" + this.ip + ")";
        }
    }
}

