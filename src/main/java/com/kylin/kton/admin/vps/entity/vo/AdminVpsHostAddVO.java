/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.validation.constraints.NotNull
 *  lombok.Generated
 */
package com.kylin.kton.admin.vps.entity.vo;

import javax.validation.constraints.NotNull;
import lombok.Generated;

public class AdminVpsHostAddVO {
    private String hostName;
    @NotNull(message="\u4e3b\u673aIP\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="\u4e3b\u673aIP\u4e0d\u80fd\u4e3a\u7a7a") String hostIp;
    @NotNull(message="\u6240\u5c5e\u96c6\u7fa4\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="\u6240\u5c5e\u96c6\u7fa4\u4e0d\u80fd\u4e3a\u7a7a") Long clusterId;
    private Long sourceId;
    private String continent;
    private String countryCode;
    private String city;
    private String sshUsername;
    private String sshPassword;
    private Long sshPort;

    @Generated
    public AdminVpsHostAddVO() {
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
    public Long getClusterId() {
        return this.clusterId;
    }

    @Generated
    public Long getSourceId() {
        return this.sourceId;
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
    public String getSshUsername() {
        return this.sshUsername;
    }

    @Generated
    public String getSshPassword() {
        return this.sshPassword;
    }

    @Generated
    public Long getSshPort() {
        return this.sshPort;
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
    public void setClusterId(Long clusterId) {
        this.clusterId = clusterId;
    }

    @Generated
    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
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
    public void setSshUsername(String sshUsername) {
        this.sshUsername = sshUsername;
    }

    @Generated
    public void setSshPassword(String sshPassword) {
        this.sshPassword = sshPassword;
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
        if (!(o instanceof AdminVpsHostAddVO)) {
            return false;
        }
        AdminVpsHostAddVO other = (AdminVpsHostAddVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$clusterId = this.getClusterId();
        Long other$clusterId = other.getClusterId();
        if (this$clusterId == null ? other$clusterId != null : !((Object)this$clusterId).equals(other$clusterId)) {
            return false;
        }
        Long this$sourceId = this.getSourceId();
        Long other$sourceId = other.getSourceId();
        if (this$sourceId == null ? other$sourceId != null : !((Object)this$sourceId).equals(other$sourceId)) {
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
        if (this$city == null ? other$city != null : !this$city.equals(other$city)) {
            return false;
        }
        String this$sshUsername = this.getSshUsername();
        String other$sshUsername = other.getSshUsername();
        if (this$sshUsername == null ? other$sshUsername != null : !this$sshUsername.equals(other$sshUsername)) {
            return false;
        }
        String this$sshPassword = this.getSshPassword();
        String other$sshPassword = other.getSshPassword();
        return !(this$sshPassword == null ? other$sshPassword != null : !this$sshPassword.equals(other$sshPassword));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminVpsHostAddVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $clusterId = this.getClusterId();
        result = result * 59 + ($clusterId == null ? 43 : ((Object)$clusterId).hashCode());
        Long $sourceId = this.getSourceId();
        result = result * 59 + ($sourceId == null ? 43 : ((Object)$sourceId).hashCode());
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
        String $sshUsername = this.getSshUsername();
        result = result * 59 + ($sshUsername == null ? 43 : $sshUsername.hashCode());
        String $sshPassword = this.getSshPassword();
        result = result * 59 + ($sshPassword == null ? 43 : $sshPassword.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminVpsHostAddVO(hostName=" + this.getHostName() + ", hostIp=" + this.getHostIp() + ", clusterId=" + this.getClusterId() + ", sourceId=" + this.getSourceId() + ", continent=" + this.getContinent() + ", countryCode=" + this.getCountryCode() + ", city=" + this.getCity() + ", sshUsername=" + this.getSshUsername() + ", sshPassword=" + this.getSshPassword() + ", sshPort=" + this.getSshPort() + ")";
    }
}

