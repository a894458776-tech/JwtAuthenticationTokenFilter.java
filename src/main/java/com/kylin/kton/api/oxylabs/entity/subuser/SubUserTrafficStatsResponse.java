/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 *  org.springframework.util.CollectionUtils
 */
package com.kylin.kton.api.oxylabs.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import lombok.Generated;
import org.springframework.util.CollectionUtils;

public class SubUserTrafficStatsResponse {
    private Double traffic;
    @JsonProperty(value="traffic_by_period")
    private Map<String, Double> trafficByPeriod;

    public Boolean isEmpty() {
        return CollectionUtils.isEmpty(this.trafficByPeriod);
    }

    @Generated
    public SubUserTrafficStatsResponse() {
    }

    @Generated
    public Double getTraffic() {
        return this.traffic;
    }

    @Generated
    public Map<String, Double> getTrafficByPeriod() {
        return this.trafficByPeriod;
    }

    @Generated
    public void setTraffic(Double traffic) {
        this.traffic = traffic;
    }

    @JsonProperty(value="traffic_by_period")
    @Generated
    public void setTrafficByPeriod(Map<String, Double> trafficByPeriod) {
        this.trafficByPeriod = trafficByPeriod;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SubUserTrafficStatsResponse)) {
            return false;
        }
        SubUserTrafficStatsResponse other = (SubUserTrafficStatsResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Double this$traffic = this.getTraffic();
        Double other$traffic = other.getTraffic();
        if (this$traffic == null ? other$traffic != null : !((Object)this$traffic).equals(other$traffic)) {
            return false;
        }
        Map<String, Double> this$trafficByPeriod = this.getTrafficByPeriod();
        Map<String, Double> other$trafficByPeriod = other.getTrafficByPeriod();
        return !(this$trafficByPeriod == null ? other$trafficByPeriod != null : !((Object)this$trafficByPeriod).equals(other$trafficByPeriod));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof SubUserTrafficStatsResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Double $traffic = this.getTraffic();
        result = result * 59 + ($traffic == null ? 43 : ((Object)$traffic).hashCode());
        Map<String, Double> $trafficByPeriod = this.getTrafficByPeriod();
        result = result * 59 + ($trafficByPeriod == null ? 43 : ((Object)$trafficByPeriod).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "SubUserTrafficStatsResponse(traffic=" + this.getTraffic() + ", trafficByPeriod=" + this.getTrafficByPeriod() + ")";
    }
}

