/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticPoolItem
 *  lombok.Generated
 */
package com.kylin.kton.client.order.entity.dto;

import com.kylin.kton.system.domain.KtonIpStaticPoolItem;
import lombok.Generated;

public class ClientStaticPoolItemDTO
extends KtonIpStaticPoolItem {
    private String continent;
    private String countryCode;
    private String location;
    private String icon;
    private Long totalIps;
    private Long availableIps;
    private String hot;
    private Long status;

    @Generated
    public ClientStaticPoolItemDTO() {
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
    public String getIcon() {
        return this.icon;
    }

    @Generated
    public Long getTotalIps() {
        return this.totalIps;
    }

    @Generated
    public Long getAvailableIps() {
        return this.availableIps;
    }

    @Generated
    public String getHot() {
        return this.hot;
    }

    @Generated
    public Long getStatus() {
        return this.status;
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
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Generated
    public void setTotalIps(Long totalIps) {
        this.totalIps = totalIps;
    }

    @Generated
    public void setAvailableIps(Long availableIps) {
        this.availableIps = availableIps;
    }

    @Generated
    public void setHot(String hot) {
        this.hot = hot;
    }

    @Generated
    public void setStatus(Long status) {
        this.status = status;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ClientStaticPoolItemDTO)) {
            return false;
        }
        ClientStaticPoolItemDTO other = (ClientStaticPoolItemDTO)((Object)o);
        if (!other.canEqual((Object)this)) {
            return false;
        }
        Long this$totalIps = this.getTotalIps();
        Long other$totalIps = other.getTotalIps();
        if (this$totalIps == null ? other$totalIps != null : !((Object)this$totalIps).equals(other$totalIps)) {
            return false;
        }
        Long this$availableIps = this.getAvailableIps();
        Long other$availableIps = other.getAvailableIps();
        if (this$availableIps == null ? other$availableIps != null : !((Object)this$availableIps).equals(other$availableIps)) {
            return false;
        }
        Long this$status = this.getStatus();
        Long other$status = other.getStatus();
        if (this$status == null ? other$status != null : !((Object)this$status).equals(other$status)) {
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
        String this$icon = this.getIcon();
        String other$icon = other.getIcon();
        if (this$icon == null ? other$icon != null : !this$icon.equals(other$icon)) {
            return false;
        }
        String this$hot = this.getHot();
        String other$hot = other.getHot();
        return !(this$hot == null ? other$hot != null : !this$hot.equals(other$hot));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ClientStaticPoolItemDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $totalIps = this.getTotalIps();
        result = result * 59 + ($totalIps == null ? 43 : ((Object)$totalIps).hashCode());
        Long $availableIps = this.getAvailableIps();
        result = result * 59 + ($availableIps == null ? 43 : ((Object)$availableIps).hashCode());
        Long $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : ((Object)$status).hashCode());
        String $continent = this.getContinent();
        result = result * 59 + ($continent == null ? 43 : $continent.hashCode());
        String $countryCode = this.getCountryCode();
        result = result * 59 + ($countryCode == null ? 43 : $countryCode.hashCode());
        String $location = this.getLocation();
        result = result * 59 + ($location == null ? 43 : $location.hashCode());
        String $icon = this.getIcon();
        result = result * 59 + ($icon == null ? 43 : $icon.hashCode());
        String $hot = this.getHot();
        result = result * 59 + ($hot == null ? 43 : $hot.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ClientStaticPoolItemDTO(continent=" + this.getContinent() + ", countryCode=" + this.getCountryCode() + ", location=" + this.getLocation() + ", icon=" + this.getIcon() + ", totalIps=" + this.getTotalIps() + ", availableIps=" + this.getAvailableIps() + ", hot=" + this.getHot() + ", status=" + this.getStatus() + ")";
    }
}

