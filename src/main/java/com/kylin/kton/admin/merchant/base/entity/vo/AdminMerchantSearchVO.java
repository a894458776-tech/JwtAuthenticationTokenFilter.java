/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.merchant.base.entity.vo;

import lombok.Generated;

public class AdminMerchantSearchVO {
    private String companyName;
    private String name;

    @Generated
    public AdminMerchantSearchVO() {
    }

    @Generated
    public String getCompanyName() {
        return this.companyName;
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Generated
    public void setName(String name) {
        this.name = name;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminMerchantSearchVO)) {
            return false;
        }
        AdminMerchantSearchVO other = (AdminMerchantSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$companyName = this.getCompanyName();
        String other$companyName = other.getCompanyName();
        if (this$companyName == null ? other$companyName != null : !this$companyName.equals(other$companyName)) {
            return false;
        }
        String this$name = this.getName();
        String other$name = other.getName();
        return !(this$name == null ? other$name != null : !this$name.equals(other$name));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminMerchantSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $companyName = this.getCompanyName();
        result = result * 59 + ($companyName == null ? 43 : $companyName.hashCode());
        String $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminMerchantSearchVO(companyName=" + this.getCompanyName() + ", name=" + this.getName() + ")";
    }
}

