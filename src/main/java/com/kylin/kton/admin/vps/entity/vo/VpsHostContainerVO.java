/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.annotation.Excel
 *  com.kylin.kton.system.domain.KtonVpsHostContainer
 *  lombok.Generated
 */
package com.kylin.kton.admin.vps.entity.vo;

import com.kylin.kton.admin.vps.entity.vo.SourceInfoVO;
import com.kylin.kton.common.annotation.Excel;
import com.kylin.kton.system.domain.KtonVpsHostContainer;
import java.io.Serializable;
import lombok.Generated;

public class VpsHostContainerVO
extends KtonVpsHostContainer
implements Serializable {
    @Excel(name="\u4e3b\u673aIP")
    private String hostIp;
    @Excel(name="\u6d32(Asia-\u4e9a\u6d32\uff0cNorthAmerica-\u5317\u7f8e\u6d32, Europe-\u6b27\u6d32)")
    private String continent;
    @Excel(name="\u56fd\u5bb6\u7f16\u7801")
    private String countryCode;
    @Excel(name="\u57ce\u5e02")
    private String city;
    @Excel(name="\u6240\u5c5e\u96c6\u7fa4")
    private String clusterName;
    @Excel(name="\u4f9b\u5e94\u5546\u4fe1\u606f")
    private SourceInfoVO sourceInfo;

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
        String this$clusterName = this.getClusterName();
        String other$clusterName = other.getClusterName();
        if (this$clusterName == null ? other$clusterName != null : !this$clusterName.equals(other$clusterName)) {
            return false;
        }
        SourceInfoVO this$sourceInfo = this.getSourceInfo();
        SourceInfoVO other$sourceInfo = other.getSourceInfo();
        return !(this$sourceInfo == null ? other$sourceInfo != null : !((Object)this$sourceInfo).equals(other$sourceInfo));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof VpsHostContainerVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = super.hashCode();
        String $hostIp = this.getHostIp();
        result = result * 59 + ($hostIp == null ? 43 : $hostIp.hashCode());
        String $continent = this.getContinent();
        result = result * 59 + ($continent == null ? 43 : $continent.hashCode());
        String $countryCode = this.getCountryCode();
        result = result * 59 + ($countryCode == null ? 43 : $countryCode.hashCode());
        String $city = this.getCity();
        result = result * 59 + ($city == null ? 43 : $city.hashCode());
        String $clusterName = this.getClusterName();
        result = result * 59 + ($clusterName == null ? 43 : $clusterName.hashCode());
        SourceInfoVO $sourceInfo = this.getSourceInfo();
        result = result * 59 + ($sourceInfo == null ? 43 : ((Object)$sourceInfo).hashCode());
        return result;
    }

    @Generated
    public VpsHostContainerVO() {
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
    public String getClusterName() {
        return this.clusterName;
    }

    @Generated
    public SourceInfoVO getSourceInfo() {
        return this.sourceInfo;
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
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    @Generated
    public void setSourceInfo(SourceInfoVO sourceInfo) {
        this.sourceInfo = sourceInfo;
    }

    @Generated
    public String toString() {
        return "VpsHostContainerVO(hostIp=" + this.getHostIp() + ", continent=" + this.getContinent() + ", countryCode=" + this.getCountryCode() + ", city=" + this.getCity() + ", clusterName=" + this.getClusterName() + ", sourceInfo=" + this.getSourceInfo() + ")";
    }
}

