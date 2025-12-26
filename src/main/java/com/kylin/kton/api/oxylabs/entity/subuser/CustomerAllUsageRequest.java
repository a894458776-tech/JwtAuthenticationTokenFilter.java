/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.oxylabs.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

public class CustomerAllUsageRequest {
    @JsonProperty(value="customer_id")
    private Long customerId;

    @Generated
    public static CustomerAllUsageRequestBuilder builder() {
        return new CustomerAllUsageRequestBuilder();
    }

    @Generated
    public Long getCustomerId() {
        return this.customerId;
    }

    @JsonProperty(value="customer_id")
    @Generated
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CustomerAllUsageRequest)) {
            return false;
        }
        CustomerAllUsageRequest other = (CustomerAllUsageRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$customerId = this.getCustomerId();
        Long other$customerId = other.getCustomerId();
        return !(this$customerId == null ? other$customerId != null : !((Object)this$customerId).equals(other$customerId));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof CustomerAllUsageRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $customerId = this.getCustomerId();
        result = result * 59 + ($customerId == null ? 43 : ((Object)$customerId).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "CustomerAllUsageRequest(customerId=" + this.getCustomerId() + ")";
    }

    @Generated
    public CustomerAllUsageRequest(Long customerId) {
        this.customerId = customerId;
    }

    @Generated
    public CustomerAllUsageRequest() {
    }

    @Generated
    public static class CustomerAllUsageRequestBuilder {
        @Generated
        private Long customerId;

        @Generated
        CustomerAllUsageRequestBuilder() {
        }

        @JsonProperty(value="customer_id")
        @Generated
        public CustomerAllUsageRequestBuilder customerId(Long customerId) {
            this.customerId = customerId;
            return this;
        }

        @Generated
        public CustomerAllUsageRequest build() {
            return new CustomerAllUsageRequest(this.customerId);
        }

        @Generated
        public String toString() {
            return "CustomerAllUsageRequest.CustomerAllUsageRequestBuilder(customerId=" + this.customerId + ")";
        }
    }
}

