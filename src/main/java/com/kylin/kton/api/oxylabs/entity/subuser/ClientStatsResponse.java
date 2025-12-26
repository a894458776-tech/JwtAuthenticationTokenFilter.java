/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.oxylabs.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

public class ClientStatsResponse {
    private Double traffic;
    @JsonProperty(value="date_from")
    private String dateFrom;
    @JsonProperty(value="date_to")
    private String dateTo;

    @Generated
    public ClientStatsResponse() {
    }

    @Generated
    public Double getTraffic() {
        return this.traffic;
    }

    @Generated
    public String getDateFrom() {
        return this.dateFrom;
    }

    @Generated
    public String getDateTo() {
        return this.dateTo;
    }

    @Generated
    public void setTraffic(Double traffic) {
        this.traffic = traffic;
    }

    @JsonProperty(value="date_from")
    @Generated
    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    @JsonProperty(value="date_to")
    @Generated
    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ClientStatsResponse)) {
            return false;
        }
        ClientStatsResponse other = (ClientStatsResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Double this$traffic = this.getTraffic();
        Double other$traffic = other.getTraffic();
        if (this$traffic == null ? other$traffic != null : !((Object)this$traffic).equals(other$traffic)) {
            return false;
        }
        String this$dateFrom = this.getDateFrom();
        String other$dateFrom = other.getDateFrom();
        if (this$dateFrom == null ? other$dateFrom != null : !this$dateFrom.equals(other$dateFrom)) {
            return false;
        }
        String this$dateTo = this.getDateTo();
        String other$dateTo = other.getDateTo();
        return !(this$dateTo == null ? other$dateTo != null : !this$dateTo.equals(other$dateTo));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ClientStatsResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Double $traffic = this.getTraffic();
        result = result * 59 + ($traffic == null ? 43 : ((Object)$traffic).hashCode());
        String $dateFrom = this.getDateFrom();
        result = result * 59 + ($dateFrom == null ? 43 : $dateFrom.hashCode());
        String $dateTo = this.getDateTo();
        result = result * 59 + ($dateTo == null ? 43 : $dateTo.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ClientStatsResponse(traffic=" + this.getTraffic() + ", dateFrom=" + this.getDateFrom() + ", dateTo=" + this.getDateTo() + ")";
    }
}

