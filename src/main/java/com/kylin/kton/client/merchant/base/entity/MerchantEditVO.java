/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.merchant.base.entity;

import lombok.Generated;

public class MerchantEditVO {
    private Long id;
    private String companyName;
    private String name;
    private String address;
    private String city;
    private String country;
    private String zipCode;

    @Generated
    public MerchantEditVO() {
    }

    @Generated
    public Long getId() {
        return this.id;
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
    public void setId(Long id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MerchantEditVO)) {
            return false;
        }
        MerchantEditVO other = (MerchantEditVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$id = this.getId();
        Long other$id = other.getId();
        if (this$id == null ? other$id != null : !((Object)this$id).equals(other$id)) {
            return false;
        }
        String this$companyName = this.getCompanyName();
        String other$companyName = other.getCompanyName();
        if (this$companyName == null ? other$companyName != null : !this$companyName.equals(other$companyName)) {
            return false;
        }
        String this$name = this.getName();
        String other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
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
        return other instanceof MerchantEditVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $id = this.getId();
        result = result * 59 + ($id == null ? 43 : ((Object)$id).hashCode());
        String $companyName = this.getCompanyName();
        result = result * 59 + ($companyName == null ? 43 : $companyName.hashCode());
        String $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
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
        return "MerchantEditVO(id=" + this.getId() + ", companyName=" + this.getCompanyName() + ", name=" + this.getName() + ", address=" + this.getAddress() + ", city=" + this.getCity() + ", country=" + this.getCountry() + ", zipCode=" + this.getZipCode() + ")";
    }
}

