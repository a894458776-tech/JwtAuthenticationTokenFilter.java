/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonVpsHostContainer
 *  lombok.Generated
 */
package com.kylin.kton.client.cluster.entity.vo;

import com.kylin.kton.system.domain.KtonVpsHostContainer;
import java.io.Serializable;
import java.util.Date;
import lombok.Generated;

public class QueryVpsContainer
extends KtonVpsHostContainer
implements Serializable {
    private Date beginDate;
    private Date endDate;
    private String continent;
    private String countryCode;
    private String city;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof QueryVpsContainer)) {
            return false;
        }
        QueryVpsContainer other = (QueryVpsContainer)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Date this$beginDate = this.getBeginDate();
        Date other$beginDate = other.getBeginDate();
        if (this$beginDate == null ? other$beginDate != null : !((Object)this$beginDate).equals(other$beginDate)) {
            return false;
        }
        Date this$endDate = this.getEndDate();
        Date other$endDate = other.getEndDate();
        if (this$endDate == null ? other$endDate != null : !((Object)this$endDate).equals(other$endDate)) {
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
        return other instanceof QueryVpsContainer;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = super.hashCode();
        Date $beginDate = this.getBeginDate();
        result = result * 59 + ($beginDate == null ? 43 : ((Object)$beginDate).hashCode());
        Date $endDate = this.getEndDate();
        result = result * 59 + ($endDate == null ? 43 : ((Object)$endDate).hashCode());
        String $continent = this.getContinent();
        result = result * 59 + ($continent == null ? 43 : $continent.hashCode());
        String $countryCode = this.getCountryCode();
        result = result * 59 + ($countryCode == null ? 43 : $countryCode.hashCode());
        String $city = this.getCity();
        result = result * 59 + ($city == null ? 43 : $city.hashCode());
        return result;
    }

    @Generated
    public QueryVpsContainer() {
    }

    @Generated
    public Date getBeginDate() {
        return this.beginDate;
    }

    @Generated
    public Date getEndDate() {
        return this.endDate;
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
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    @Generated
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
    public String toString() {
        return "QueryVpsContainer(beginDate=" + this.getBeginDate() + ", endDate=" + this.getEndDate() + ", continent=" + this.getContinent() + ", countryCode=" + this.getCountryCode() + ", city=" + this.getCity() + ")";
    }
}

