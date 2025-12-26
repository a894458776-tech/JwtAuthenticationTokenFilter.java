/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.validation.constraints.NotNull
 *  lombok.Generated
 */
package com.kylin.kton.client.order.entity.vo;

import javax.validation.constraints.NotNull;
import lombok.Generated;

public class CountryNumsItemVO {
    private String continent;
    @NotNull(message="countryCode cannot be empty.")
    private @NotNull(message="countryCode cannot be empty.") String countryCode;
    @NotNull(message="location cannot be empty.")
    private @NotNull(message="location cannot be empty.") String location;
    @NotNull(message="Num cannot be empty.")
    private @NotNull(message="Num cannot be empty.") Integer num;
    @NotNull(message="ipType cannot be empty.")
    private @NotNull(message="ipType cannot be empty.") Integer ipType;

    @Generated
    public CountryNumsItemVO() {
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
    public Integer getNum() {
        return this.num;
    }

    @Generated
    public Integer getIpType() {
        return this.ipType;
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
    public void setNum(Integer num) {
        this.num = num;
    }

    @Generated
    public void setIpType(Integer ipType) {
        this.ipType = ipType;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CountryNumsItemVO)) {
            return false;
        }
        CountryNumsItemVO other = (CountryNumsItemVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Integer this$num = this.getNum();
        Integer other$num = other.getNum();
        if (this$num == null ? other$num != null : !((Object)this$num).equals(other$num)) {
            return false;
        }
        Integer this$ipType = this.getIpType();
        Integer other$ipType = other.getIpType();
        if (this$ipType == null ? other$ipType != null : !((Object)this$ipType).equals(other$ipType)) {
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
        return other instanceof CountryNumsItemVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $num = this.getNum();
        result = result * 59 + ($num == null ? 43 : ((Object)$num).hashCode());
        Integer $ipType = this.getIpType();
        result = result * 59 + ($ipType == null ? 43 : ((Object)$ipType).hashCode());
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
        return "CountryNumsItemVO(continent=" + this.getContinent() + ", countryCode=" + this.getCountryCode() + ", location=" + this.getLocation() + ", num=" + this.getNum() + ", ipType=" + this.getIpType() + ")";
    }
}

