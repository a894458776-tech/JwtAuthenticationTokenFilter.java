/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.kylin.kton.common.annotation.Excel
 *  com.kylin.kton.system.domain.KtonVpsHostContainer
 *  lombok.Generated
 */
package com.kylin.kton.client.vps.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kylin.kton.common.annotation.Excel;
import com.kylin.kton.system.domain.KtonVpsHostContainer;
import java.io.Serializable;
import java.util.Date;
import lombok.Generated;

public class VpsHostContainerVO
extends KtonVpsHostContainer
implements Serializable {
    @Excel(name="\u6d32(Asia-\u4e9a\u6d32\uff0cNorthAmerica-\u5317\u7f8e\u6d32, Europe-\u6b27\u6d32)")
    private String continent;
    @Excel(name="\u56fd\u5bb6\u7f16\u7801")
    private String countryCode;
    @Excel(name="\u57ce\u5e02")
    private String city;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date expireDate;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof VpsHostContainerVO)) {
            return false;
        }
        VpsHostContainerVO other = (VpsHostContainerVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (!super.equals(o)) {
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
        if (this$city == null ? other$city != null : !this$city.equals(other$city)) {
            return false;
        }
        Date this$expireDate = this.getExpireDate();
        Date other$expireDate = other.getExpireDate();
        return !(this$expireDate == null ? other$expireDate != null : !((Object)this$expireDate).equals(other$expireDate));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof VpsHostContainerVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = super.hashCode();
        String $continent = this.getContinent();
        result = result * 59 + ($continent == null ? 43 : $continent.hashCode());
        String $countryCode = this.getCountryCode();
        result = result * 59 + ($countryCode == null ? 43 : $countryCode.hashCode());
        String $city = this.getCity();
        result = result * 59 + ($city == null ? 43 : $city.hashCode());
        Date $expireDate = this.getExpireDate();
        result = result * 59 + ($expireDate == null ? 43 : ((Object)$expireDate).hashCode());
        return result;
    }

    @Generated
    public VpsHostContainerVO() {
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
    public Date getExpireDate() {
        return this.expireDate;
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

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Generated
    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @Generated
    public String toString() {
        return "VpsHostContainerVO(continent=" + this.getContinent() + ", countryCode=" + this.getCountryCode() + ", city=" + this.getCity() + ", expireDate=" + this.getExpireDate() + ")";
    }
}

