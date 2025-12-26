/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticSource
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.dto;

import com.kylin.kton.system.domain.KtonIpStaticSource;
import lombok.Generated;

public class AdminUnassignedIpsDTO
extends KtonIpStaticSource {
    private String continent;
    private String subContinent;
    private String countryCode;
    private String province;
    private String city;

    @Generated
    public AdminUnassignedIpsDTO() {
    }

    @Generated
    public String getContinent() {
        return this.continent;
    }

    @Generated
    public String getSubContinent() {
        return this.subContinent;
    }

    @Generated
    public String getCountryCode() {
        return this.countryCode;
    }

    @Generated
    public String getProvince() {
        return this.province;
    }

    @Generated
    public String getCity() {
        return this.city;
    }

    @Generated
    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Generated
    public void setSubContinent(String subContinent) {
        this.subContinent = subContinent;
    }

    @Generated
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Generated
    public void setProvince(String province) {
        this.province = province;
    }

    @Generated
    public void setCity(String city) {
        this.city = city;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminUnassignedIpsDTO)) {
            return false;
        }
        AdminUnassignedIpsDTO other = (AdminUnassignedIpsDTO)((Object)o);
        if (!other.canEqual((Object)this)) {
            return false;
        }
        String this$continent = this.getContinent();
        String other$continent = other.getContinent();
        if (this$continent == null ? other$continent != null : !this$continent.equals(other$continent)) {
            return false;
        }
        String this$subContinent = this.getSubContinent();
        String other$subContinent = other.getSubContinent();
        if (this$subContinent == null ? other$subContinent != null : !this$subContinent.equals(other$subContinent)) {
            return false;
        }
        String this$countryCode = this.getCountryCode();
        String other$countryCode = other.getCountryCode();
        if (this$countryCode == null ? other$countryCode != null : !this$countryCode.equals(other$countryCode)) {
            return false;
        }
        String this$province = this.getProvince();
        String other$province = other.getProvince();
        if (this$province == null ? other$province != null : !this$province.equals(other$province)) {
            return false;
        }
        String this$city = this.getCity();
        String other$city = other.getCity();
        return !(this$city == null ? other$city != null : !this$city.equals(other$city));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminUnassignedIpsDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $continent = this.getContinent();
        result = result * 59 + ($continent == null ? 43 : $continent.hashCode());
        String $subContinent = this.getSubContinent();
        result = result * 59 + ($subContinent == null ? 43 : $subContinent.hashCode());
        String $countryCode = this.getCountryCode();
        result = result * 59 + ($countryCode == null ? 43 : $countryCode.hashCode());
        String $province = this.getProvince();
        result = result * 59 + ($province == null ? 43 : $province.hashCode());
        String $city = this.getCity();
        result = result * 59 + ($city == null ? 43 : $city.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminUnassignedIpsDTO(continent=" + this.getContinent() + ", subContinent=" + this.getSubContinent() + ", countryCode=" + this.getCountryCode() + ", province=" + this.getProvince() + ", city=" + this.getCity() + ")";
    }
}

