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

public class AddSubUserBalanceRequest
implements Serializable {
    @JsonProperty(value="subuser_id")
    private Long subuserId;
    private Long traffic;

    @Generated
    public static AddSubUserBalanceRequestBuilder builder() {
        return new AddSubUserBalanceRequestBuilder();
    }

    @Generated
    public Long getSubuserId() {
        return this.subuserId;
    }

    @Generated
    public Long getTraffic() {
        return this.traffic;
    }

    @JsonProperty(value="subuser_id")
    @Generated
    public void setSubuserId(Long subuserId) {
        this.subuserId = subuserId;
    }

    @Generated
    public void setTraffic(Long traffic) {
        this.traffic = traffic;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AddSubUserBalanceRequest)) {
            return false;
        }
        AddSubUserBalanceRequest other = (AddSubUserBalanceRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$subuserId = this.getSubuserId();
        Long other$subuserId = other.getSubuserId();
        if (this$subuserId == null ? other$subuserId != null : !((Object)this$subuserId).equals(other$subuserId)) {
            return false;
        }
        Long this$traffic = this.getTraffic();
        Long other$traffic = other.getTraffic();
        return !(this$traffic == null ? other$traffic != null : !((Object)this$traffic).equals(other$traffic));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AddSubUserBalanceRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $subuserId = this.getSubuserId();
        result = result * 59 + ($subuserId == null ? 43 : ((Object)$subuserId).hashCode());
        Long $traffic = this.getTraffic();
        result = result * 59 + ($traffic == null ? 43 : ((Object)$traffic).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AddSubUserBalanceRequest(subuserId=" + this.getSubuserId() + ", traffic=" + this.getTraffic() + ")";
    }

    @Generated
    public AddSubUserBalanceRequest(Long subuserId, Long traffic) {
        this.subuserId = subuserId;
        this.traffic = traffic;
    }

    @Generated
    public AddSubUserBalanceRequest() {
    }

    @Generated
    public static class AddSubUserBalanceRequestBuilder {
        @Generated
        private Long subuserId;
        @Generated
        private Long traffic;

        @Generated
        AddSubUserBalanceRequestBuilder() {
        }

        @JsonProperty(value="subuser_id")
        @Generated
        public AddSubUserBalanceRequestBuilder subuserId(Long subuserId) {
            this.subuserId = subuserId;
            return this;
        }

        @Generated
        public AddSubUserBalanceRequestBuilder traffic(Long traffic) {
            this.traffic = traffic;
            return this;
        }

        @Generated
        public AddSubUserBalanceRequest build() {
            return new AddSubUserBalanceRequest(this.subuserId, this.traffic);
        }

        @Generated
        public String toString() {
            return "AddSubUserBalanceRequest.AddSubUserBalanceRequestBuilder(subuserId=" + this.subuserId + ", traffic=" + this.traffic + ")";
        }
    }
}

