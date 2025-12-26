/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.validation.constraints.NotNull
 *  lombok.Generated
 */
package com.kylin.kton.admin.account.entity.vo;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Generated;

public class AccountEditVO {
    @NotNull(message="ID\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="ID\u4e0d\u80fd\u4e3a\u7a7a") Long id;
    private BigDecimal trafficLimit;
    private String label;
    private String account;
    private String password;
    private Long merchantId;
    private String remarks;
    List<String> protocols;

    @Generated
    public AccountEditVO() {
    }

    @Generated
    public Long getId() {
        return this.id;
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
    public String getAccount() {
        return this.account;
    }

    @Generated
    public String getPassword() {
        return this.password;
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public String getRemarks() {
        return this.remarks;
    }

    @Generated
    public List<String> getProtocols() {
        return this.protocols;
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
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
    public void setAccount(String account) {
        this.account = account;
    }

    @Generated
    public void setPassword(String password) {
        this.password = password;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Generated
    public void setProtocols(List<String> protocols) {
        this.protocols = protocols;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AccountEditVO)) {
            return false;
        }
        AccountEditVO other = (AccountEditVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$id = this.getId();
        Long other$id = other.getId();
        if (this$id == null ? other$id != null : !((Object)this$id).equals(other$id)) {
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
        String this$account = this.getAccount();
        String other$account = other.getAccount();
        if (this$account == null ? other$account != null : !this$account.equals(other$account)) {
            return false;
        }
        String this$password = this.getPassword();
        String other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) {
            return false;
        }
        String this$remarks = this.getRemarks();
        String other$remarks = other.getRemarks();
        if (this$remarks == null ? other$remarks != null : !this$remarks.equals(other$remarks)) {
            return false;
        }
        List<String> this$protocols = this.getProtocols();
        List<String> other$protocols = other.getProtocols();
        return !(this$protocols == null ? other$protocols != null : !((Object)this$protocols).equals(other$protocols));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AccountEditVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $id = this.getId();
        result = result * 59 + ($id == null ? 43 : ((Object)$id).hashCode());
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        BigDecimal $trafficLimit = this.getTrafficLimit();
        result = result * 59 + ($trafficLimit == null ? 43 : ((Object)$trafficLimit).hashCode());
        String $label = this.getLabel();
        result = result * 59 + ($label == null ? 43 : $label.hashCode());
        String $account = this.getAccount();
        result = result * 59 + ($account == null ? 43 : $account.hashCode());
        String $password = this.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        String $remarks = this.getRemarks();
        result = result * 59 + ($remarks == null ? 43 : $remarks.hashCode());
        List<String> $protocols = this.getProtocols();
        result = result * 59 + ($protocols == null ? 43 : ((Object)$protocols).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AccountEditVO(id=" + this.getId() + ", trafficLimit=" + this.getTrafficLimit() + ", label=" + this.getLabel() + ", account=" + this.getAccount() + ", password=" + this.getPassword() + ", merchantId=" + this.getMerchantId() + ", remarks=" + this.getRemarks() + ", protocols=" + this.getProtocols() + ")";
    }
}

