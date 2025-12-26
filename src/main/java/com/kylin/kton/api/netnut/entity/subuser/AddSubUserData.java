/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

public class AddSubUserData {
    @JsonProperty(value="customer_id")
    private Integer customerId;
    @JsonProperty(value="customer_name")
    private String customerName;
    @JsonProperty(value="customer_login_name")
    private String customerLoginName;
    @JsonProperty(value="customer_dashboard_email")
    private String customerDashboardEmail;
    @JsonProperty(value="customer_active")
    private boolean customerActive;

    @Generated
    public AddSubUserData() {
    }

    @Generated
    public Integer getCustomerId() {
        return this.customerId;
    }

    @Generated
    public String getCustomerName() {
        return this.customerName;
    }

    @Generated
    public String getCustomerLoginName() {
        return this.customerLoginName;
    }

    @Generated
    public String getCustomerDashboardEmail() {
        return this.customerDashboardEmail;
    }

    @Generated
    public boolean isCustomerActive() {
        return this.customerActive;
    }

    @JsonProperty(value="customer_id")
    @Generated
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @JsonProperty(value="customer_name")
    @Generated
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @JsonProperty(value="customer_login_name")
    @Generated
    public void setCustomerLoginName(String customerLoginName) {
        this.customerLoginName = customerLoginName;
    }

    @JsonProperty(value="customer_dashboard_email")
    @Generated
    public void setCustomerDashboardEmail(String customerDashboardEmail) {
        this.customerDashboardEmail = customerDashboardEmail;
    }

    @JsonProperty(value="customer_active")
    @Generated
    public void setCustomerActive(boolean customerActive) {
        this.customerActive = customerActive;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AddSubUserData)) {
            return false;
        }
        AddSubUserData other = (AddSubUserData)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.isCustomerActive() != other.isCustomerActive()) {
            return false;
        }
        Integer this$customerId = this.getCustomerId();
        Integer other$customerId = other.getCustomerId();
        if (this$customerId == null ? other$customerId != null : !((Object)this$customerId).equals(other$customerId)) {
            return false;
        }
        String this$customerName = this.getCustomerName();
        String other$customerName = other.getCustomerName();
        if (this$customerName == null ? other$customerName != null : !this$customerName.equals(other$customerName)) {
            return false;
        }
        String this$customerLoginName = this.getCustomerLoginName();
        String other$customerLoginName = other.getCustomerLoginName();
        if (this$customerLoginName == null ? other$customerLoginName != null : !this$customerLoginName.equals(other$customerLoginName)) {
            return false;
        }
        String this$customerDashboardEmail = this.getCustomerDashboardEmail();
        String other$customerDashboardEmail = other.getCustomerDashboardEmail();
        return !(this$customerDashboardEmail == null ? other$customerDashboardEmail != null : !this$customerDashboardEmail.equals(other$customerDashboardEmail));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AddSubUserData;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isCustomerActive() ? 79 : 97);
        Integer $customerId = this.getCustomerId();
        result = result * 59 + ($customerId == null ? 43 : ((Object)$customerId).hashCode());
        String $customerName = this.getCustomerName();
        result = result * 59 + ($customerName == null ? 43 : $customerName.hashCode());
        String $customerLoginName = this.getCustomerLoginName();
        result = result * 59 + ($customerLoginName == null ? 43 : $customerLoginName.hashCode());
        String $customerDashboardEmail = this.getCustomerDashboardEmail();
        result = result * 59 + ($customerDashboardEmail == null ? 43 : $customerDashboardEmail.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AddSubUserData(customerId=" + this.getCustomerId() + ", customerName=" + this.getCustomerName() + ", customerLoginName=" + this.getCustomerLoginName() + ", customerDashboardEmail=" + this.getCustomerDashboardEmail() + ", customerActive=" + this.isCustomerActive() + ")";
    }
}

