/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.dto;

import java.io.Serializable;
import lombok.Generated;

public class ContinentDto
implements Serializable {
    private String continent;
    private String countryCode;
    private String location;

    @Generated
    public static ContinentDtoBuilder builder() {
        return new ContinentDtoBuilder();
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
    public void setLocation(String location) {
        this.location = location;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ContinentDto)) {
            return false;
        }
        ContinentDto other = (ContinentDto)o;
        if (!other.canEqual(this)) {
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
        return other instanceof ContinentDto;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
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
        return "ContinentDto(continent=" + this.getContinent() + ", countryCode=" + this.getCountryCode() + ", location=" + this.getLocation() + ")";
    }

    @Generated
    public ContinentDto(String continent, String countryCode, String location) {
        this.continent = continent;
        this.countryCode = countryCode;
        this.location = location;
    }

    @Generated
    public ContinentDto() {
    }

    @Generated
    public static class ContinentDtoBuilder {
        @Generated
        private String continent;
        @Generated
        private String countryCode;
        @Generated
        private String location;

        @Generated
        ContinentDtoBuilder() {
        }

        @Generated
        public ContinentDtoBuilder continent(String continent) {
            this.continent = continent;
            return this;
        }

        @Generated
        public ContinentDtoBuilder countryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        @Generated
        public ContinentDtoBuilder location(String location) {
            this.location = location;
            return this;
        }

        @Generated
        public ContinentDto build() {
            return new ContinentDto(this.continent, this.countryCode, this.location);
        }

        @Generated
        public String toString() {
            return "ContinentDto.ContinentDtoBuilder(continent=" + this.continent + ", countryCode=" + this.countryCode + ", location=" + this.location + ")";
        }
    }
}

