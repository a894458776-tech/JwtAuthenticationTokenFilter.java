/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.ip.entity.vo;

import java.util.List;
import lombok.Generated;

public class ClientRegionalAvailableIpsVO {
    private Long merchantId;
    private Long type;
    private List<String> continents;
    private List<String> countryCodes;
    private List<String> locations;
    private Long isExclusive = 0L;

    @Generated
    public ClientRegionalAvailableIpsVO() {
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public Long getType() {
        return this.type;
    }

    @Generated
    public List<String> getContinents() {
        return this.continents;
    }

    @Generated
    public List<String> getCountryCodes() {
        return this.countryCodes;
    }

    @Generated
    public List<String> getLocations() {
        return this.locations;
    }

    @Generated
    public Long getIsExclusive() {
        return this.isExclusive;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public void setType(Long type) {
        this.type = type;
    }

    @Generated
    public void setContinents(List<String> continents) {
        this.continents = continents;
    }

    @Generated
    public void setCountryCodes(List<String> countryCodes) {
        this.countryCodes = countryCodes;
    }

    @Generated
    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    @Generated
    public void setIsExclusive(Long isExclusive) {
        this.isExclusive = isExclusive;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ClientRegionalAvailableIpsVO)) {
            return false;
        }
        ClientRegionalAvailableIpsVO other = (ClientRegionalAvailableIpsVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        Long this$type = this.getType();
        Long other$type = other.getType();
        if (this$type == null ? other$type != null : !((Object)this$type).equals(other$type)) {
            return false;
        }
        Long this$isExclusive = this.getIsExclusive();
        Long other$isExclusive = other.getIsExclusive();
        if (this$isExclusive == null ? other$isExclusive != null : !((Object)this$isExclusive).equals(other$isExclusive)) {
            return false;
        }
        List<String> this$continents = this.getContinents();
        List<String> other$continents = other.getContinents();
        if (this$continents == null ? other$continents != null : !((Object)this$continents).equals(other$continents)) {
            return false;
        }
        List<String> this$countryCodes = this.getCountryCodes();
        List<String> other$countryCodes = other.getCountryCodes();
        if (this$countryCodes == null ? other$countryCodes != null : !((Object)this$countryCodes).equals(other$countryCodes)) {
            return false;
        }
        List<String> this$locations = this.getLocations();
        List<String> other$locations = other.getLocations();
        return !(this$locations == null ? other$locations != null : !((Object)this$locations).equals(other$locations));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ClientRegionalAvailableIpsVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        Long $type = this.getType();
        result = result * 59 + ($type == null ? 43 : ((Object)$type).hashCode());
        Long $isExclusive = this.getIsExclusive();
        result = result * 59 + ($isExclusive == null ? 43 : ((Object)$isExclusive).hashCode());
        List<String> $continents = this.getContinents();
        result = result * 59 + ($continents == null ? 43 : ((Object)$continents).hashCode());
        List<String> $countryCodes = this.getCountryCodes();
        result = result * 59 + ($countryCodes == null ? 43 : ((Object)$countryCodes).hashCode());
        List<String> $locations = this.getLocations();
        result = result * 59 + ($locations == null ? 43 : ((Object)$locations).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ClientRegionalAvailableIpsVO(merchantId=" + this.getMerchantId() + ", type=" + this.getType() + ", continents=" + this.getContinents() + ", countryCodes=" + this.getCountryCodes() + ", locations=" + this.getLocations() + ", isExclusive=" + this.getIsExclusive() + ")";
    }
}

