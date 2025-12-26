/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.Generated;

public class TrafficUsageData {
    private Double traffic;
    @JsonProperty(value="extra_traffic")
    private Double extraTraffic;
    private Long request;
    @JsonProperty(value="d_usage")
    private LocalDate usageD;
    @JsonProperty(value="start_date")
    private LocalDate startDate;

    @Generated
    public TrafficUsageData() {
    }

    @Generated
    public Double getTraffic() {
        return this.traffic;
    }

    @Generated
    public Double getExtraTraffic() {
        return this.extraTraffic;
    }

    @Generated
    public Long getRequest() {
        return this.request;
    }

    @Generated
    public LocalDate getUsageD() {
        return this.usageD;
    }

    @Generated
    public LocalDate getStartDate() {
        return this.startDate;
    }

    @Generated
    public void setTraffic(Double traffic) {
        this.traffic = traffic;
    }

    @JsonProperty(value="extra_traffic")
    @Generated
    public void setExtraTraffic(Double extraTraffic) {
        this.extraTraffic = extraTraffic;
    }

    @Generated
    public void setRequest(Long request) {
        this.request = request;
    }

    @JsonProperty(value="d_usage")
    @Generated
    public void setUsageD(LocalDate usageD) {
        this.usageD = usageD;
    }

    @JsonProperty(value="start_date")
    @Generated
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TrafficUsageData)) {
            return false;
        }
        TrafficUsageData other = (TrafficUsageData)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Double this$traffic = this.getTraffic();
        Double other$traffic = other.getTraffic();
        if (this$traffic == null ? other$traffic != null : !((Object)this$traffic).equals(other$traffic)) {
            return false;
        }
        Double this$extraTraffic = this.getExtraTraffic();
        Double other$extraTraffic = other.getExtraTraffic();
        if (this$extraTraffic == null ? other$extraTraffic != null : !((Object)this$extraTraffic).equals(other$extraTraffic)) {
            return false;
        }
        Long this$request = this.getRequest();
        Long other$request = other.getRequest();
        if (this$request == null ? other$request != null : !((Object)this$request).equals(other$request)) {
            return false;
        }
        LocalDate this$usageD = this.getUsageD();
        LocalDate other$usageD = other.getUsageD();
        if (this$usageD == null ? other$usageD != null : !((Object)this$usageD).equals(other$usageD)) {
            return false;
        }
        LocalDate this$startDate = this.getStartDate();
        LocalDate other$startDate = other.getStartDate();
        return !(this$startDate == null ? other$startDate != null : !((Object)this$startDate).equals(other$startDate));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof TrafficUsageData;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Double $traffic = this.getTraffic();
        result = result * 59 + ($traffic == null ? 43 : ((Object)$traffic).hashCode());
        Double $extraTraffic = this.getExtraTraffic();
        result = result * 59 + ($extraTraffic == null ? 43 : ((Object)$extraTraffic).hashCode());
        Long $request = this.getRequest();
        result = result * 59 + ($request == null ? 43 : ((Object)$request).hashCode());
        LocalDate $usageD = this.getUsageD();
        result = result * 59 + ($usageD == null ? 43 : ((Object)$usageD).hashCode());
        LocalDate $startDate = this.getStartDate();
        result = result * 59 + ($startDate == null ? 43 : ((Object)$startDate).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "TrafficUsageData(traffic=" + this.getTraffic() + ", extraTraffic=" + this.getExtraTraffic() + ", request=" + this.getRequest() + ", usageD=" + this.getUsageD() + ", startDate=" + this.getStartDate() + ")";
    }
}

