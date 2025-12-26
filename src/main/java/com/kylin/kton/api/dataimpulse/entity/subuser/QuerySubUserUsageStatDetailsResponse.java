/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 *  org.springframework.util.CollectionUtils
 */
package com.kylin.kton.api.dataimpulse.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Generated;
import org.springframework.util.CollectionUtils;

public class QuerySubUserUsageStatDetailsResponse
implements Serializable {
    private List<Usage> usage;
    @JsonProperty(value="total_count")
    private Integer totalCount;

    public Boolean isEmpty() {
        return CollectionUtils.isEmpty(this.usage);
    }

    @Generated
    public QuerySubUserUsageStatDetailsResponse() {
    }

    @Generated
    public List<Usage> getUsage() {
        return this.usage;
    }

    @Generated
    public Integer getTotalCount() {
        return this.totalCount;
    }

    @Generated
    public void setUsage(List<Usage> usage) {
        this.usage = usage;
    }

    @JsonProperty(value="total_count")
    @Generated
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof QuerySubUserUsageStatDetailsResponse)) {
            return false;
        }
        QuerySubUserUsageStatDetailsResponse other = (QuerySubUserUsageStatDetailsResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Integer this$totalCount = this.getTotalCount();
        Integer other$totalCount = other.getTotalCount();
        if (this$totalCount == null ? other$totalCount != null : !((Object)this$totalCount).equals(other$totalCount)) {
            return false;
        }
        List<Usage> this$usage = this.getUsage();
        List<Usage> other$usage = other.getUsage();
        return !(this$usage == null ? other$usage != null : !((Object)this$usage).equals(other$usage));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof QuerySubUserUsageStatDetailsResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $totalCount = this.getTotalCount();
        result = result * 59 + ($totalCount == null ? 43 : ((Object)$totalCount).hashCode());
        List<Usage> $usage = this.getUsage();
        result = result * 59 + ($usage == null ? 43 : ((Object)$usage).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "QuerySubUserUsageStatDetailsResponse(usage=" + this.getUsage() + ", totalCount=" + this.getTotalCount() + ")";
    }

    public static class Usage
    implements Serializable {
        private String host;
        private LocalDateTime datetime;
        private Integer requests;
        private String traffic;
        @JsonProperty(value="extra_traffic")
        private String extraTraffic;
        private String status;
        private String message;

        @Generated
        public Usage() {
        }

        @Generated
        public String getHost() {
            return this.host;
        }

        @Generated
        public LocalDateTime getDatetime() {
            return this.datetime;
        }

        @Generated
        public Integer getRequests() {
            return this.requests;
        }

        @Generated
        public String getTraffic() {
            return this.traffic;
        }

        @Generated
        public String getExtraTraffic() {
            return this.extraTraffic;
        }

        @Generated
        public String getStatus() {
            return this.status;
        }

        @Generated
        public String getMessage() {
            return this.message;
        }

        @Generated
        public void setHost(String host) {
            this.host = host;
        }

        @Generated
        public void setDatetime(LocalDateTime datetime) {
            this.datetime = datetime;
        }

        @Generated
        public void setRequests(Integer requests) {
            this.requests = requests;
        }

        @Generated
        public void setTraffic(String traffic) {
            this.traffic = traffic;
        }

        @JsonProperty(value="extra_traffic")
        @Generated
        public void setExtraTraffic(String extraTraffic) {
            this.extraTraffic = extraTraffic;
        }

        @Generated
        public void setStatus(String status) {
            this.status = status;
        }

        @Generated
        public void setMessage(String message) {
            this.message = message;
        }

        @Generated
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Usage)) {
                return false;
            }
            Usage other = (Usage)o;
            if (!other.canEqual(this)) {
                return false;
            }
            Integer this$requests = this.getRequests();
            Integer other$requests = other.getRequests();
            if (this$requests == null ? other$requests != null : !((Object)this$requests).equals(other$requests)) {
                return false;
            }
            String this$host = this.getHost();
            String other$host = other.getHost();
            if (this$host == null ? other$host != null : !this$host.equals(other$host)) {
                return false;
            }
            LocalDateTime this$datetime = this.getDatetime();
            LocalDateTime other$datetime = other.getDatetime();
            if (this$datetime == null ? other$datetime != null : !((Object)this$datetime).equals(other$datetime)) {
                return false;
            }
            String this$traffic = this.getTraffic();
            String other$traffic = other.getTraffic();
            if (this$traffic == null ? other$traffic != null : !this$traffic.equals(other$traffic)) {
                return false;
            }
            String this$extraTraffic = this.getExtraTraffic();
            String other$extraTraffic = other.getExtraTraffic();
            if (this$extraTraffic == null ? other$extraTraffic != null : !this$extraTraffic.equals(other$extraTraffic)) {
                return false;
            }
            String this$status = this.getStatus();
            String other$status = other.getStatus();
            if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
                return false;
            }
            String this$message = this.getMessage();
            String other$message = other.getMessage();
            return !(this$message == null ? other$message != null : !this$message.equals(other$message));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof Usage;
        }

        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            Integer $requests = this.getRequests();
            result = result * 59 + ($requests == null ? 43 : ((Object)$requests).hashCode());
            String $host = this.getHost();
            result = result * 59 + ($host == null ? 43 : $host.hashCode());
            LocalDateTime $datetime = this.getDatetime();
            result = result * 59 + ($datetime == null ? 43 : ((Object)$datetime).hashCode());
            String $traffic = this.getTraffic();
            result = result * 59 + ($traffic == null ? 43 : $traffic.hashCode());
            String $extraTraffic = this.getExtraTraffic();
            result = result * 59 + ($extraTraffic == null ? 43 : $extraTraffic.hashCode());
            String $status = this.getStatus();
            result = result * 59 + ($status == null ? 43 : $status.hashCode());
            String $message = this.getMessage();
            result = result * 59 + ($message == null ? 43 : $message.hashCode());
            return result;
        }

        @Generated
        public String toString() {
            return "QuerySubUserUsageStatDetailsResponse.Usage(host=" + this.getHost() + ", datetime=" + this.getDatetime() + ", requests=" + this.getRequests() + ", traffic=" + this.getTraffic() + ", extraTraffic=" + this.getExtraTraffic() + ", status=" + this.getStatus() + ", message=" + this.getMessage() + ")";
        }
    }
}

