/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.oxylabs.entity.subuser;

import java.util.List;
import lombok.Generated;

public class SubUserTargetStatsResponse {
    private List<TargetStats> result;

    @Generated
    public SubUserTargetStatsResponse() {
    }

    @Generated
    public List<TargetStats> getResult() {
        return this.result;
    }

    @Generated
    public void setResult(List<TargetStats> result) {
        this.result = result;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SubUserTargetStatsResponse)) {
            return false;
        }
        SubUserTargetStatsResponse other = (SubUserTargetStatsResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        List<TargetStats> this$result = this.getResult();
        List<TargetStats> other$result = other.getResult();
        return !(this$result == null ? other$result != null : !((Object)this$result).equals(other$result));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof SubUserTargetStatsResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        List<TargetStats> $result = this.getResult();
        result = result * 59 + ($result == null ? 43 : ((Object)$result).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "SubUserTargetStatsResponse(result=" + this.getResult() + ")";
    }

    public static class TargetStats {
        private String date;
        private String target;
        private Double traffic;
        private Integer requests;

        @Generated
        public TargetStats() {
        }

        @Generated
        public String getDate() {
            return this.date;
        }

        @Generated
        public String getTarget() {
            return this.target;
        }

        @Generated
        public Double getTraffic() {
            return this.traffic;
        }

        @Generated
        public Integer getRequests() {
            return this.requests;
        }

        @Generated
        public void setDate(String date) {
            this.date = date;
        }

        @Generated
        public void setTarget(String target) {
            this.target = target;
        }

        @Generated
        public void setTraffic(Double traffic) {
            this.traffic = traffic;
        }

        @Generated
        public void setRequests(Integer requests) {
            this.requests = requests;
        }

        @Generated
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof TargetStats)) {
                return false;
            }
            TargetStats other = (TargetStats)o;
            if (!other.canEqual(this)) {
                return false;
            }
            Double this$traffic = this.getTraffic();
            Double other$traffic = other.getTraffic();
            if (this$traffic == null ? other$traffic != null : !((Object)this$traffic).equals(other$traffic)) {
                return false;
            }
            Integer this$requests = this.getRequests();
            Integer other$requests = other.getRequests();
            if (this$requests == null ? other$requests != null : !((Object)this$requests).equals(other$requests)) {
                return false;
            }
            String this$date = this.getDate();
            String other$date = other.getDate();
            if (this$date == null ? other$date != null : !this$date.equals(other$date)) {
                return false;
            }
            String this$target = this.getTarget();
            String other$target = other.getTarget();
            return !(this$target == null ? other$target != null : !this$target.equals(other$target));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof TargetStats;
        }

        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            Double $traffic = this.getTraffic();
            result = result * 59 + ($traffic == null ? 43 : ((Object)$traffic).hashCode());
            Integer $requests = this.getRequests();
            result = result * 59 + ($requests == null ? 43 : ((Object)$requests).hashCode());
            String $date = this.getDate();
            result = result * 59 + ($date == null ? 43 : $date.hashCode());
            String $target = this.getTarget();
            result = result * 59 + ($target == null ? 43 : $target.hashCode());
            return result;
        }

        @Generated
        public String toString() {
            return "SubUserTargetStatsResponse.TargetStats(date=" + this.getDate() + ", target=" + this.getTarget() + ", traffic=" + this.getTraffic() + ", requests=" + this.getRequests() + ")";
        }
    }
}

