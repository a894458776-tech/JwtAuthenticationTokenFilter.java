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

public class RemoveAllowedIpRequest
implements Serializable {
    @JsonProperty(value="subuser_id")
    private Long subUserId;
    private String ip;

    @Generated
    public static RemoveAllowedIpRequestBuilder builder() {
        return new RemoveAllowedIpRequestBuilder();
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
        if (!(o instanceof RemoveAllowedIpRequest)) {
            return false;
        }
        RemoveAllowedIpRequest other = (RemoveAllowedIpRequest)o;
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
        return other instanceof RemoveAllowedIpRequest;
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
        return "RemoveAllowedIpRequest(subUserId=" + this.getSubUserId() + ", ip=" + this.getIp() + ")";
    }

    @Generated
    public RemoveAllowedIpRequest(Long subUserId, String ip) {
        this.subUserId = subUserId;
        this.ip = ip;
    }

    @Generated
    public RemoveAllowedIpRequest() {
    }

    @Generated
    public static class RemoveAllowedIpRequestBuilder {
        @Generated
        private Long subUserId;
        @Generated
        private String ip;

        @Generated
        RemoveAllowedIpRequestBuilder() {
        }

        @JsonProperty(value="subuser_id")
        @Generated
        public RemoveAllowedIpRequestBuilder subUserId(Long subUserId) {
            this.subUserId = subUserId;
            return this;
        }

        @Generated
        public RemoveAllowedIpRequestBuilder ip(String ip) {
            this.ip = ip;
            return this;
        }

        @Generated
        public RemoveAllowedIpRequest build() {
            return new RemoveAllowedIpRequest(this.subUserId, this.ip);
        }

        @Generated
        public String toString() {
            return "RemoveAllowedIpRequest.RemoveAllowedIpRequestBuilder(subUserId=" + this.subUserId + ", ip=" + this.ip + ")";
        }
    }
}

