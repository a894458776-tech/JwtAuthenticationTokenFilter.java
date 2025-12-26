/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.vo;

import lombok.Generated;

public class AdminStaticPoolSearchVO {
    private String continent;
    private String countryCode;
    private Long type;
    private String location;

    @Generated
    public AdminStaticPoolSearchVO() {
    }

    @Generated
    public String getContinent() {
        return this.continent;
    }

    @Generated
    public String getCountryCode() {
        return this.countryCode;
    }

    @Generated
    public Long getType() {
        return this.type;
    }

    @Generated
    public String getLocation() {
        return this.location;
    }

    @Generated
    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Generated
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Generated
    public void setType(Long type) {
        this.type = type;
    }

    @Generated
    public void setLocation(String location) {
        this.location = location;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminStaticPoolSearchVO)) {
            return false;
        }
        AdminStaticPoolSearchVO other = (AdminStaticPoolSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$type = this.getType();
        Long other$type = other.getType();
        if (this$type == null ? other$type != null : !((Object)this$type).equals(other$type)) {
            return false;
        }
        String this$continent = this.getContinent();
        String other$continent = other.getContinent();
        if (this$continent == null ? other$continent != null : !this$continent.equals(other$continent)) {
            return false;
        }
        String this$countryCode = this.getCountryCode();
        String other$countryCode = other.getCountryCode();
        if (this$countryCode == null ? other$countryCode != null : !this$countryCode.equals(other$countryCode)) {
            return false;
        }
        String this$location = this.getLocation();
        String other$location = other.getLocation();
        return !(this$location == null ? other$location != null : !this$location.equals(other$location));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminStaticPoolSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $type = this.getType();
        result = result * 59 + ($type == null ? 43 : ((Object)$type).hashCode());
        String $continent = this.getContinent();
        result = result * 59 + ($continent == null ? 43 : $continent.hashCode());
        String $countryCode = this.getCountryCode();
        result = result * 59 + ($countryCode == null ? 43 : $countryCode.hashCode());
        String $location = this.getLocation();
        result = result * 59 + ($location == null ? 43 : $location.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminStaticPoolSearchVO(continent=" + this.getContinent() + ", countryCode=" + this.getCountryCode() + ", type=" + this.getType() + ", location=" + this.getLocation() + ")";
    }
}

