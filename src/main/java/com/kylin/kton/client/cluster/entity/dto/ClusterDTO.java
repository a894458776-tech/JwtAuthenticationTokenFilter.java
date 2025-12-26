/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.cluster.entity.dto;

import lombok.Generated;

public class ClusterDTO {
    private Long id;
    private String clusterName;
    private String clusterType;
    private String continent;
    private String countryCode;
    private String city;

    @Generated
    public ClusterDTO() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public String getClusterName() {
        return this.clusterName;
    }

    @Generated
    public String getClusterType() {
        return this.clusterType;
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
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    @Generated
    public void setClusterType(String clusterType) {
        this.clusterType = clusterType;
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
        if (!(o instanceof ClusterDTO)) {
            return false;
        }
        ClusterDTO other = (ClusterDTO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$id = this.getId();
        Long other$id = other.getId();
        if (this$id == null ? other$id != null : !((Object)this$id).equals(other$id)) {
            return false;
        }
        String this$clusterName = this.getClusterName();
        String other$clusterName = other.getClusterName();
        if (this$clusterName == null ? other$clusterName != null : !this$clusterName.equals(other$clusterName)) {
            return false;
        }
        String this$clusterType = this.getClusterType();
        String other$clusterType = other.getClusterType();
        if (this$clusterType == null ? other$clusterType != null : !this$clusterType.equals(other$clusterType)) {
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
        return other instanceof ClusterDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $id = this.getId();
        result = result * 59 + ($id == null ? 43 : ((Object)$id).hashCode());
        String $clusterName = this.getClusterName();
        result = result * 59 + ($clusterName == null ? 43 : $clusterName.hashCode());
        String $clusterType = this.getClusterType();
        result = result * 59 + ($clusterType == null ? 43 : $clusterType.hashCode());
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
        return "ClusterDTO(id=" + this.getId() + ", clusterName=" + this.getClusterName() + ", clusterType=" + this.getClusterType() + ", continent=" + this.getContinent() + ", countryCode=" + this.getCountryCode() + ", city=" + this.getCity() + ")";
    }
}

