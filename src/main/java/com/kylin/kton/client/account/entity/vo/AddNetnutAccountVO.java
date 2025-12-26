/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.account.entity.vo;

import java.math.BigDecimal;
import lombok.Generated;

public class AddNetnutAccountVO {
    private BigDecimal trafficLimit;
    private String label;
    private String email;
    private String remarks;
    private Long merchantId;

    @Generated
    public AddNetnutAccountVO() {
    }

    @Generated
    public BigDecimal getTrafficLimit() {
        return this.trafficLimit;
    }

    @Generated
    public String getLabel() {
        return this.label;
    }

    @Generated
    public String getEmail() {
        return this.email;
    }

    @Generated
    public String getRemarks() {
        return this.remarks;
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public void setTrafficLimit(BigDecimal trafficLimit) {
        this.trafficLimit = trafficLimit;
    }

    @Generated
    public void setLabel(String label) {
        this.label = label;
    }

    @Generated
    public void setEmail(String email) {
        this.email = email;
    }

    @Generated
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AddNetnutAccountVO)) {
            return false;
        }
        AddNetnutAccountVO other = (AddNetnutAccountVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        BigDecimal this$trafficLimit = this.getTrafficLimit();
        BigDecimal other$trafficLimit = other.getTrafficLimit();
        if (this$trafficLimit == null ? other$trafficLimit != null : !((Object)this$trafficLimit).equals(other$trafficLimit)) {
            return false;
        }
        String this$label = this.getLabel();
        String other$label = other.getLabel();
        if (this$label == null ? other$label != null : !this$label.equals(other$label)) {
            return false;
        }
        String this$email = this.getEmail();
        String other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) {
            return false;
        }
        String this$remarks = this.getRemarks();
        String other$remarks = other.getRemarks();
        return !(this$remarks == null ? other$remarks != null : !this$remarks.equals(other$remarks));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AddNetnutAccountVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        BigDecimal $trafficLimit = this.getTrafficLimit();
        result = result * 59 + ($trafficLimit == null ? 43 : ((Object)$trafficLimit).hashCode());
        String $label = this.getLabel();
        result = result * 59 + ($label == null ? 43 : $label.hashCode());
        String $email = this.getEmail();
        result = result * 59 + ($email == null ? 43 : $email.hashCode());
        String $remarks = this.getRemarks();
        result = result * 59 + ($remarks == null ? 43 : $remarks.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AddNetnutAccountVO(trafficLimit=" + this.getTrafficLimit() + ", label=" + this.getLabel() + ", email=" + this.getEmail() + ", remarks=" + this.getRemarks() + ", merchantId=" + this.getMerchantId() + ")";
    }
}

