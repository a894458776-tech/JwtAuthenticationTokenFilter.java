/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.vps.entity.vo;

import lombok.Generated;

public class VpsHostSearchVO {
    private Long clusterId;
    private String continent;
    private String countryCode;
    private String city;

    @Generated
    public VpsHostSearchVO() {
    }

    @Generated
    public Long getClusterId() {
        return this.clusterId;
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
    public String getCity() {
        return this.city;
    }

    @Generated
    public void setClusterId(Long clusterId) {
        this.clusterId = clusterId;
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
    public void setCity(String city) {
        this.city = city;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof VpsHostSearchVO)) {
            return false;
        }
        VpsHostSearchVO other = (VpsHostSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$clusterId = this.getClusterId();
        Long other$clusterId = other.getClusterId();
        if (this$clusterId == null ? other$clusterId != null : !((Object)this$clusterId).equals(other$clusterId)) {
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
        String this$city = this.getCity();
        String other$city = other.getCity();
        return !(this$city == null ? other$city != null : !this$city.equals(other$city));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof VpsHostSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $clusterId = this.getClusterId();
        result = result * 59 + ($clusterId == null ? 43 : ((Object)$clusterId).hashCode());
        String $continent = this.getContinent();
        result = result * 59 + ($continent == null ? 43 : $continent.hashCode());
        String $countryCode = this.getCountryCode();
        result = result * 59 + ($countryCode == null ? 43 : $countryCode.hashCode());
        String $city = this.getCity();
        result = result * 59 + ($city == null ? 43 : $city.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "VpsHostSearchVO(clusterId=" + this.getClusterId() + ", continent=" + this.getContinent() + ", countryCode=" + this.getCountryCode() + ", city=" + this.getCity() + ")";
    }
}

