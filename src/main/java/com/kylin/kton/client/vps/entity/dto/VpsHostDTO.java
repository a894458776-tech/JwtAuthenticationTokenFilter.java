/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.vps.entity.dto;

import lombok.Generated;

public class VpsHostDTO {
    private Long id;
    private String hostName;
    private String hostIp;
    private String continent;
    private String countryCode;
    private String city;
    private Long sshPort;

    @Generated
    public VpsHostDTO() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public String getHostName() {
        return this.hostName;
    }

    @Generated
    public String getHostIp() {
        return this.hostIp;
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
    public Long getSshPort() {
        return this.sshPort;
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    @Generated
    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
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
    public void setSshPort(Long sshPort) {
        this.sshPort = sshPort;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof VpsHostDTO)) {
            return false;
        }
        VpsHostDTO other = (VpsHostDTO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$id = this.getId();
        Long other$id = other.getId();
        if (this$id == null ? other$id != null : !((Object)this$id).equals(other$id)) {
            return false;
        }
        Long this$sshPort = this.getSshPort();
        Long other$sshPort = other.getSshPort();
        if (this$sshPort == null ? other$sshPort != null : !((Object)this$sshPort).equals(other$sshPort)) {
            return false;
        }
        String this$hostName = this.getHostName();
        String other$hostName = other.getHostName();
        if (this$hostName == null ? other$hostName != null : !this$hostName.equals(other$hostName)) {
            return false;
        }
        String this$hostIp = this.getHostIp();
        String other$hostIp = other.getHostIp();
        if (this$hostIp == null ? other$hostIp != null : !this$hostIp.equals(other$hostIp)) {
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
        return other instanceof VpsHostDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $id = this.getId();
        result = result * 59 + ($id == null ? 43 : ((Object)$id).hashCode());
        Long $sshPort = this.getSshPort();
        result = result * 59 + ($sshPort == null ? 43 : ((Object)$sshPort).hashCode());
        String $hostName = this.getHostName();
        result = result * 59 + ($hostName == null ? 43 : $hostName.hashCode());
        String $hostIp = this.getHostIp();
        result = result * 59 + ($hostIp == null ? 43 : $hostIp.hashCode());
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
        return "VpsHostDTO(id=" + this.getId() + ", hostName=" + this.getHostName() + ", hostIp=" + this.getHostIp() + ", continent=" + this.getContinent() + ", countryCode=" + this.getCountryCode() + ", city=" + this.getCity() + ", sshPort=" + this.getSshPort() + ")";
    }
}

