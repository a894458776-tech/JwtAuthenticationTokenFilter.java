/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.order.entity.dto;

import lombok.Generated;

public class ClientDataStatisticsDTO {
    private Integer nextPayDays;
    private Integer regularipTotal;
    private Integer regularExpiringSoon;
    private Integer premiumIpTotal;
    private Integer premiumExpiringSoon;

    @Generated
    public ClientDataStatisticsDTO() {
    }

    @Generated
    public Integer getNextPayDays() {
        return this.nextPayDays;
    }

    @Generated
    public Integer getRegularipTotal() {
        return this.regularipTotal;
    }

    @Generated
    public Integer getRegularExpiringSoon() {
        return this.regularExpiringSoon;
    }

    @Generated
    public Integer getPremiumIpTotal() {
        return this.premiumIpTotal;
    }

    @Generated
    public Integer getPremiumExpiringSoon() {
        return this.premiumExpiringSoon;
    }

    @Generated
    public void setNextPayDays(Integer nextPayDays) {
        this.nextPayDays = nextPayDays;
    }

    @Generated
    public void setRegularipTotal(Integer regularipTotal) {
        this.regularipTotal = regularipTotal;
    }

    @Generated
    public void setRegularExpiringSoon(Integer regularExpiringSoon) {
        this.regularExpiringSoon = regularExpiringSoon;
    }

    @Generated
    public void setPremiumIpTotal(Integer premiumIpTotal) {
        this.premiumIpTotal = premiumIpTotal;
    }

    @Generated
    public void setPremiumExpiringSoon(Integer premiumExpiringSoon) {
        this.premiumExpiringSoon = premiumExpiringSoon;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ClientDataStatisticsDTO)) {
            return false;
        }
        ClientDataStatisticsDTO other = (ClientDataStatisticsDTO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Integer this$nextPayDays = this.getNextPayDays();
        Integer other$nextPayDays = other.getNextPayDays();
        if (this$nextPayDays == null ? other$nextPayDays != null : !((Object)this$nextPayDays).equals(other$nextPayDays)) {
            return false;
        }
        Integer this$regularipTotal = this.getRegularipTotal();
        Integer other$regularipTotal = other.getRegularipTotal();
        if (this$regularipTotal == null ? other$regularipTotal != null : !((Object)this$regularipTotal).equals(other$regularipTotal)) {
            return false;
        }
        Integer this$regularExpiringSoon = this.getRegularExpiringSoon();
        Integer other$regularExpiringSoon = other.getRegularExpiringSoon();
        if (this$regularExpiringSoon == null ? other$regularExpiringSoon != null : !((Object)this$regularExpiringSoon).equals(other$regularExpiringSoon)) {
            return false;
        }
        Integer this$premiumIpTotal = this.getPremiumIpTotal();
        Integer other$premiumIpTotal = other.getPremiumIpTotal();
        if (this$premiumIpTotal == null ? other$premiumIpTotal != null : !((Object)this$premiumIpTotal).equals(other$premiumIpTotal)) {
            return false;
        }
        Integer this$premiumExpiringSoon = this.getPremiumExpiringSoon();
        Integer other$premiumExpiringSoon = other.getPremiumExpiringSoon();
        return !(this$premiumExpiringSoon == null ? other$premiumExpiringSoon != null : !((Object)this$premiumExpiringSoon).equals(other$premiumExpiringSoon));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ClientDataStatisticsDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $nextPayDays = this.getNextPayDays();
        result = result * 59 + ($nextPayDays == null ? 43 : ((Object)$nextPayDays).hashCode());
        Integer $regularipTotal = this.getRegularipTotal();
        result = result * 59 + ($regularipTotal == null ? 43 : ((Object)$regularipTotal).hashCode());
        Integer $regularExpiringSoon = this.getRegularExpiringSoon();
        result = result * 59 + ($regularExpiringSoon == null ? 43 : ((Object)$regularExpiringSoon).hashCode());
        Integer $premiumIpTotal = this.getPremiumIpTotal();
        result = result * 59 + ($premiumIpTotal == null ? 43 : ((Object)$premiumIpTotal).hashCode());
        Integer $premiumExpiringSoon = this.getPremiumExpiringSoon();
        result = result * 59 + ($premiumExpiringSoon == null ? 43 : ((Object)$premiumExpiringSoon).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ClientDataStatisticsDTO(nextPayDays=" + this.getNextPayDays() + ", regularipTotal=" + this.getRegularipTotal() + ", regularExpiringSoon=" + this.getRegularExpiringSoon() + ", premiumIpTotal=" + this.getPremiumIpTotal() + ", premiumExpiringSoon=" + this.getPremiumExpiringSoon() + ")";
    }
}

