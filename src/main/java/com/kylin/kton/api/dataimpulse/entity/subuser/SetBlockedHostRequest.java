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

public class SetBlockedHostRequest
implements Serializable {
    @JsonProperty(value="subuser_id")
    private Long subUserId;
    @JsonProperty(value="blocked_hosts")
    private List<String> blockedHosts;

    @Generated
    public static SetBlockedHostRequestBuilder builder() {
        return new SetBlockedHostRequestBuilder();
    }

    @Generated
    public Long getSubUserId() {
        return this.subUserId;
    }

    @Generated
    public List<String> getBlockedHosts() {
        return this.blockedHosts;
    }

    @JsonProperty(value="subuser_id")
    @Generated
    public void setSubUserId(Long subUserId) {
        this.subUserId = subUserId;
    }

    @JsonProperty(value="blocked_hosts")
    @Generated
    public void setBlockedHosts(List<String> blockedHosts) {
        this.blockedHosts = blockedHosts;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SetBlockedHostRequest)) {
            return false;
        }
        SetBlockedHostRequest other = (SetBlockedHostRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$subUserId = this.getSubUserId();
        Long other$subUserId = other.getSubUserId();
        if (this$subUserId == null ? other$subUserId != null : !((Object)this$subUserId).equals(other$subUserId)) {
            return false;
        }
        List<String> this$blockedHosts = this.getBlockedHosts();
        List<String> other$blockedHosts = other.getBlockedHosts();
        return !(this$blockedHosts == null ? other$blockedHosts != null : !((Object)this$blockedHosts).equals(other$blockedHosts));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof SetBlockedHostRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $subUserId = this.getSubUserId();
        result = result * 59 + ($subUserId == null ? 43 : ((Object)$subUserId).hashCode());
        List<String> $blockedHosts = this.getBlockedHosts();
        result = result * 59 + ($blockedHosts == null ? 43 : ((Object)$blockedHosts).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "SetBlockedHostRequest(subUserId=" + this.getSubUserId() + ", blockedHosts=" + this.getBlockedHosts() + ")";
    }

    @Generated
    public SetBlockedHostRequest() {
    }

    @Generated
    public SetBlockedHostRequest(Long subUserId, List<String> blockedHosts) {
        this.subUserId = subUserId;
        this.blockedHosts = blockedHosts;
    }

    @Generated
    public static class SetBlockedHostRequestBuilder {
        @Generated
        private Long subUserId;
        @Generated
        private List<String> blockedHosts;

        @Generated
        SetBlockedHostRequestBuilder() {
        }

        @JsonProperty(value="subuser_id")
        @Generated
        public SetBlockedHostRequestBuilder subUserId(Long subUserId) {
            this.subUserId = subUserId;
            return this;
        }

        @JsonProperty(value="blocked_hosts")
        @Generated
        public SetBlockedHostRequestBuilder blockedHosts(List<String> blockedHosts) {
            this.blockedHosts = blockedHosts;
            return this;
        }

        @Generated
        public SetBlockedHostRequest build() {
            return new SetBlockedHostRequest(this.subUserId, this.blockedHosts);
        }

        @Generated
        public String toString() {
            return "SetBlockedHostRequest.SetBlockedHostRequestBuilder(subUserId=" + this.subUserId + ", blockedHosts=" + this.blockedHosts + ")";
        }
    }
}

