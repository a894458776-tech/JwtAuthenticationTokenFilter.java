/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.validation.constraints.NotNull
 *  lombok.Generated
 */
package com.kylin.kton.client.vps.entity.vo;

import javax.validation.constraints.NotNull;
import lombok.Generated;

public class PerformanceListSearchVO {
    @NotNull(message="hostId\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="hostId\u4e0d\u80fd\u4e3a\u7a7a") Long hostId;
    private String continent;
    private String countryCode;
    private String city;

    @Generated
    public PerformanceListSearchVO() {
    }

    @Generated
    public Long getHostId() {
        return this.hostId;
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
    public void setHostId(Long hostId) {
        this.hostId = hostId;
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
        if (!(o instanceof PerformanceListSearchVO)) {
            return false;
        }
        PerformanceListSearchVO other = (PerformanceListSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$hostId = this.getHostId();
        Long other$hostId = other.getHostId();
        if (this$hostId == null ? other$hostId != null : !((Object)this$hostId).equals(other$hostId)) {
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
        return other instanceof PerformanceListSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $hostId = this.getHostId();
        result = result * 59 + ($hostId == null ? 43 : ((Object)$hostId).hashCode());
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
        return "PerformanceListSearchVO(hostId=" + this.getHostId() + ", continent=" + this.getContinent() + ", countryCode=" + this.getCountryCode() + ", city=" + this.getCity() + ")";
    }
}

