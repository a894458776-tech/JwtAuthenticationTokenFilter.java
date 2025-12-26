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

public class AddSubUserRequest {
    @JsonProperty(value="customer_dashboard_email")
    private String customerDashboardEmail;
    @JsonProperty(value="customer_name")
    private String customerName;
    @JsonProperty(value="customer_dashboard_pwd")
    private String customerDashboardPwd;
    @JsonProperty(value="customer_login_name")
    private String customerLoginName;
    @JsonProperty(value="customer_login_pwd")
    private String customerLoginPwd;
    @JsonProperty(value="snkrs_private_pool")
    private String snkrsPrivatePool;

    @Generated
    public AddSubUserRequest() {
    }

    @Generated
    public String getCustomerDashboardEmail() {
        return this.customerDashboardEmail;
    }

    @Generated
    public String getCustomerName() {
        return this.customerName;
    }

    @Generated
    public String getCustomerDashboardPwd() {
        return this.customerDashboardPwd;
    }

    @Generated
    public String getCustomerLoginName() {
        return this.customerLoginName;
    }

    @Generated
    public String getCustomerLoginPwd() {
        return this.customerLoginPwd;
    }

    @Generated
    public String getSnkrsPrivatePool() {
        return this.snkrsPrivatePool;
    }

    @JsonProperty(value="customer_dashboard_email")
    @Generated
    public void setCustomerDashboardEmail(String customerDashboardEmail) {
        this.customerDashboardEmail = customerDashboardEmail;
    }

    @JsonProperty(value="customer_name")
    @Generated
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @JsonProperty(value="customer_dashboard_pwd")
    @Generated
    public void setCustomerDashboardPwd(String customerDashboardPwd) {
        this.customerDashboardPwd = customerDashboardPwd;
    }

    @JsonProperty(value="customer_login_name")
    @Generated
    public void setCustomerLoginName(String customerLoginName) {
        this.customerLoginName = customerLoginName;
    }

    @JsonProperty(value="customer_login_pwd")
    @Generated
    public void setCustomerLoginPwd(String customerLoginPwd) {
        this.customerLoginPwd = customerLoginPwd;
    }

    @JsonProperty(value="snkrs_private_pool")
    @Generated
    public void setSnkrsPrivatePool(String snkrsPrivatePool) {
        this.snkrsPrivatePool = snkrsPrivatePool;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AddSubUserRequest)) {
            return false;
        }
        AddSubUserRequest other = (AddSubUserRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$customerDashboardEmail = this.getCustomerDashboardEmail();
        String other$customerDashboardEmail = other.getCustomerDashboardEmail();
        if (this$customerDashboardEmail == null ? other$customerDashboardEmail != null : !this$customerDashboardEmail.equals(other$customerDashboardEmail)) {
            return false;
        }
        String this$customerName = this.getCustomerName();
        String other$customerName = other.getCustomerName();
        if (this$customerName == null ? other$customerName != null : !this$customerName.equals(other$customerName)) {
            return false;
        }
        String this$customerDashboardPwd = this.getCustomerDashboardPwd();
        String other$customerDashboardPwd = other.getCustomerDashboardPwd();
        if (this$customerDashboardPwd == null ? other$customerDashboardPwd != null : !this$customerDashboardPwd.equals(other$customerDashboardPwd)) {
            return false;
        }
        String this$customerLoginName = this.getCustomerLoginName();
        String other$customerLoginName = other.getCustomerLoginName();
        if (this$customerLoginName == null ? other$customerLoginName != null : !this$customerLoginName.equals(other$customerLoginName)) {
            return false;
        }
        String this$customerLoginPwd = this.getCustomerLoginPwd();
        String other$customerLoginPwd = other.getCustomerLoginPwd();
        if (this$customerLoginPwd == null ? other$customerLoginPwd != null : !this$customerLoginPwd.equals(other$customerLoginPwd)) {
            return false;
        }
        String this$snkrsPrivatePool = this.getSnkrsPrivatePool();
        String other$snkrsPrivatePool = other.getSnkrsPrivatePool();
        return !(this$snkrsPrivatePool == null ? other$snkrsPrivatePool != null : !this$snkrsPrivatePool.equals(other$snkrsPrivatePool));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AddSubUserRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $customerDashboardEmail = this.getCustomerDashboardEmail();
        result = result * 59 + ($customerDashboardEmail == null ? 43 : $customerDashboardEmail.hashCode());
        String $customerName = this.getCustomerName();
        result = result * 59 + ($customerName == null ? 43 : $customerName.hashCode());
        String $customerDashboardPwd = this.getCustomerDashboardPwd();
        result = result * 59 + ($customerDashboardPwd == null ? 43 : $customerDashboardPwd.hashCode());
        String $customerLoginName = this.getCustomerLoginName();
        result = result * 59 + ($customerLoginName == null ? 43 : $customerLoginName.hashCode());
        String $customerLoginPwd = this.getCustomerLoginPwd();
        result = result * 59 + ($customerLoginPwd == null ? 43 : $customerLoginPwd.hashCode());
        String $snkrsPrivatePool = this.getSnkrsPrivatePool();
        result = result * 59 + ($snkrsPrivatePool == null ? 43 : $snkrsPrivatePool.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AddSubUserRequest(customerDashboardEmail=" + this.getCustomerDashboardEmail() + ", customerName=" + this.getCustomerName() + ", customerDashboardPwd=" + this.getCustomerDashboardPwd() + ", customerLoginName=" + this.getCustomerLoginName() + ", customerLoginPwd=" + this.getCustomerLoginPwd() + ", snkrsPrivatePool=" + this.getSnkrsPrivatePool() + ")";
    }
}

