/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.vps.entity.vo;

import lombok.Generated;

public class SourceInfoVO {
    private Long id;
    private String sourceCode;
    private String sourceName;
    private String companyName;
    private String address;
    private String city;
    private String country;
    private String zipCode;
    private Long isStatic;
    private Long isDynamics;
    private Long isIdc;

    @Generated
    public SourceInfoVO() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public String getSourceCode() {
        return this.sourceCode;
    }

    @Generated
    public String getSourceName() {
        return this.sourceName;
    }

    @Generated
    public String getCompanyName() {
        return this.companyName;
    }

    @Generated
    public String getAddress() {
        return this.address;
    }

    @Generated
    public String getCity() {
        return this.city;
    }

    @Generated
    public String getCountry() {
        return this.country;
    }

    @Generated
    public String getZipCode() {
        return this.zipCode;
    }

    @Generated
    public Long getIsStatic() {
        return this.isStatic;
    }

    @Generated
    public Long getIsDynamics() {
        return this.isDynamics;
    }

    @Generated
    public Long getIsIdc() {
        return this.isIdc;
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    @Generated
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    @Generated
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Generated
    public void setAddress(String address) {
        this.address = address;
    }

    @Generated
    public void setCity(String city) {
        this.city = city;
    }

    @Generated
    public void setCountry(String country) {
        this.country = country;
    }

    @Generated
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Generated
    public void setIsStatic(Long isStatic) {
        this.isStatic = isStatic;
    }

    @Generated
    public void setIsDynamics(Long isDynamics) {
        this.isDynamics = isDynamics;
    }

    @Generated
    public void setIsIdc(Long isIdc) {
        this.isIdc = isIdc;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SourceInfoVO)) {
            return false;
        }
        SourceInfoVO other = (SourceInfoVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$id = this.getId();
        Long other$id = other.getId();
        if (this$id == null ? other$id != null : !((Object)this$id).equals(other$id)) {
            return false;
        }
        Long this$isStatic = this.getIsStatic();
        Long other$isStatic = other.getIsStatic();
        if (this$isStatic == null ? other$isStatic != null : !((Object)this$isStatic).equals(other$isStatic)) {
            return false;
        }
        Long this$isDynamics = this.getIsDynamics();
        Long other$isDynamics = other.getIsDynamics();
        if (this$isDynamics == null ? other$isDynamics != null : !((Object)this$isDynamics).equals(other$isDynamics)) {
            return false;
        }
        Long this$isIdc = this.getIsIdc();
        Long other$isIdc = other.getIsIdc();
        if (this$isIdc == null ? other$isIdc != null : !((Object)this$isIdc).equals(other$isIdc)) {
            return false;
        }
        String this$sourceCode = this.getSourceCode();
        String other$sourceCode = other.getSourceCode();
        if (this$sourceCode == null ? other$sourceCode != null : !this$sourceCode.equals(other$sourceCode)) {
            return false;
        }
        String this$sourceName = this.getSourceName();
        String other$sourceName = other.getSourceName();
        if (this$sourceName == null ? other$sourceName != null : !this$sourceName.equals(other$sourceName)) {
            return false;
        }
        String this$companyName = this.getCompanyName();
        String other$companyName = other.getCompanyName();
        if (this$companyName == null ? other$companyName != null : !this$companyName.equals(other$companyName)) {
            return false;
        }
        String this$address = this.getAddress();
        String other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) {
            return false;
        }
        String this$city = this.getCity();
        String other$city = other.getCity();
        if (this$city == null ? other$city != null : !this$city.equals(other$city)) {
            return false;
        }
        String this$country = this.getCountry();
        String other$country = other.getCountry();
        if (this$country == null ? other$country != null : !this$country.equals(other$country)) {
            return false;
        }
        String this$zipCode = this.getZipCode();
        String other$zipCode = other.getZipCode();
        return !(this$zipCode == null ? other$zipCode != null : !this$zipCode.equals(other$zipCode));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof SourceInfoVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $id = this.getId();
        result = result * 59 + ($id == null ? 43 : ((Object)$id).hashCode());
        Long $isStatic = this.getIsStatic();
        result = result * 59 + ($isStatic == null ? 43 : ((Object)$isStatic).hashCode());
        Long $isDynamics = this.getIsDynamics();
        result = result * 59 + ($isDynamics == null ? 43 : ((Object)$isDynamics).hashCode());
        Long $isIdc = this.getIsIdc();
        result = result * 59 + ($isIdc == null ? 43 : ((Object)$isIdc).hashCode());
        String $sourceCode = this.getSourceCode();
        result = result * 59 + ($sourceCode == null ? 43 : $sourceCode.hashCode());
        String $sourceName = this.getSourceName();
        result = result * 59 + ($sourceName == null ? 43 : $sourceName.hashCode());
        String $companyName = this.getCompanyName();
        result = result * 59 + ($companyName == null ? 43 : $companyName.hashCode());
        String $address = this.getAddress();
        result = result * 59 + ($address == null ? 43 : $address.hashCode());
        String $city = this.getCity();
        result = result * 59 + ($city == null ? 43 : $city.hashCode());
        String $country = this.getCountry();
        result = result * 59 + ($country == null ? 43 : $country.hashCode());
        String $zipCode = this.getZipCode();
        result = result * 59 + ($zipCode == null ? 43 : $zipCode.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "SourceInfoVO(id=" + this.getId() + ", sourceCode=" + this.getSourceCode() + ", sourceName=" + this.getSourceName() + ", companyName=" + this.getCompanyName() + ", address=" + this.getAddress() + ", city=" + this.getCity() + ", country=" + this.getCountry() + ", zipCode=" + this.getZipCode() + ", isStatic=" + this.getIsStatic() + ", isDynamics=" + this.getIsDynamics() + ", isIdc=" + this.getIsIdc() + ")";
    }
}

