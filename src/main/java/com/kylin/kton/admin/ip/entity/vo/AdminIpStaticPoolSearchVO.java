/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.vo;

import lombok.Generated;

public class AdminIpStaticPoolSearchVO {
    private String companyName;
    private String name;

    @Generated
    public AdminIpStaticPoolSearchVO() {
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
        if (!(o instanceof AdminIpStaticPoolSearchVO)) {
            return false;
        }
        AdminIpStaticPoolSearchVO other = (AdminIpStaticPoolSearchVO)o;
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
        return other instanceof AdminIpStaticPoolSearchVO;
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
        return "AdminIpStaticPoolSearchVO(companyName=" + this.getCompanyName() + ", name=" + this.getName() + ")";
    }
}

