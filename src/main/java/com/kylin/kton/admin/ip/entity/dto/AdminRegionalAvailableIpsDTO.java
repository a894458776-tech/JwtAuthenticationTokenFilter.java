/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.annotation.Excel
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.dto;

import com.kylin.kton.common.annotation.Excel;
import java.math.BigDecimal;
import lombok.Generated;

public class AdminRegionalAvailableIpsDTO {
    private Long id;
    @Excel(name=" \u7c7b\u578b:1-\u666e\u901a\uff0c2-\u9ad8\u7ea7")
    private Long type;
    @Excel(name="\u6d32(Asia-\u4e9a\u6d32\uff0cNorthAmerica-\u5317\u7f8e\u6d32, Europe-\u6b27\u6d32)")
    private String continent;
    @Excel(name="\u56fd\u5bb6\u7f16\u7801")
    private String countryCode;
    @Excel(name="ip\u5f52\u5c5e\u5730")
    private String location;
    @Excel(name="\u4ef7\u683c")
    private BigDecimal price;
    @Excel(name="\u53ef\u7528\u6570\u91cf")
    private Integer ipTotals;

    @Generated
    public AdminRegionalAvailableIpsDTO() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public Long getType() {
        return this.type;
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
    public BigDecimal getPrice() {
        return this.price;
    }

    @Generated
    public Integer getIpTotals() {
        return this.ipTotals;
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setType(Long type) {
        this.type = type;
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
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Generated
    public void setIpTotals(Integer ipTotals) {
        this.ipTotals = ipTotals;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminRegionalAvailableIpsDTO)) {
            return false;
        }
        AdminRegionalAvailableIpsDTO other = (AdminRegionalAvailableIpsDTO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$id = this.getId();
        Long other$id = other.getId();
        if (this$id == null ? other$id != null : !((Object)this$id).equals(other$id)) {
            return false;
        }
        Long this$type = this.getType();
        Long other$type = other.getType();
        if (this$type == null ? other$type != null : !((Object)this$type).equals(other$type)) {
            return false;
        }
        Integer this$ipTotals = this.getIpTotals();
        Integer other$ipTotals = other.getIpTotals();
        if (this$ipTotals == null ? other$ipTotals != null : !((Object)this$ipTotals).equals(other$ipTotals)) {
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
        if (this$location == null ? other$location != null : !this$location.equals(other$location)) {
            return false;
        }
        BigDecimal this$price = this.getPrice();
        BigDecimal other$price = other.getPrice();
        return !(this$price == null ? other$price != null : !((Object)this$price).equals(other$price));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminRegionalAvailableIpsDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $id = this.getId();
        result = result * 59 + ($id == null ? 43 : ((Object)$id).hashCode());
        Long $type = this.getType();
        result = result * 59 + ($type == null ? 43 : ((Object)$type).hashCode());
        Integer $ipTotals = this.getIpTotals();
        result = result * 59 + ($ipTotals == null ? 43 : ((Object)$ipTotals).hashCode());
        String $continent = this.getContinent();
        result = result * 59 + ($continent == null ? 43 : $continent.hashCode());
        String $countryCode = this.getCountryCode();
        result = result * 59 + ($countryCode == null ? 43 : $countryCode.hashCode());
        String $location = this.getLocation();
        result = result * 59 + ($location == null ? 43 : $location.hashCode());
        BigDecimal $price = this.getPrice();
        result = result * 59 + ($price == null ? 43 : ((Object)$price).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminRegionalAvailableIpsDTO(id=" + this.getId() + ", type=" + this.getType() + ", continent=" + this.getContinent() + ", countryCode=" + this.getCountryCode() + ", location=" + this.getLocation() + ", price=" + this.getPrice() + ", ipTotals=" + this.getIpTotals() + ")";
    }
}

