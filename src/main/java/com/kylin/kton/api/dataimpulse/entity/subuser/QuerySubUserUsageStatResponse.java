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
import java.time.LocalDate;
import java.util.List;
import lombok.Generated;
import org.springframework.util.CollectionUtils;

public class QuerySubUserUsageStatResponse
implements Serializable {
    private List<Usage> usage;
    private Total total;

    public Boolean isEmpty() {
        return CollectionUtils.isEmpty(this.usage);
    }

    @Generated
    public static QuerySubUserUsageStatResponseBuilder builder() {
        return new QuerySubUserUsageStatResponseBuilder();
    }

    @Generated
    public List<Usage> getUsage() {
        return this.usage;
    }

    @Generated
    public Total getTotal() {
        return this.total;
    }

    @Generated
    public void setUsage(List<Usage> usage) {
        this.usage = usage;
    }

    @Generated
    public void setTotal(Total total) {
        this.total = total;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof QuerySubUserUsageStatResponse)) {
            return false;
        }
        QuerySubUserUsageStatResponse other = (QuerySubUserUsageStatResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        List<Usage> this$usage = this.getUsage();
        List<Usage> other$usage = other.getUsage();
        if (this$usage == null ? other$usage != null : !((Object)this$usage).equals(other$usage)) {
            return false;
        }
        Total this$total = this.getTotal();
        Total other$total = other.getTotal();
        return !(this$total == null ? other$total != null : !((Object)this$total).equals(other$total));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof QuerySubUserUsageStatResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        List<Usage> $usage = this.getUsage();
        result = result * 59 + ($usage == null ? 43 : ((Object)$usage).hashCode());
        Total $total = this.getTotal();
        result = result * 59 + ($total == null ? 43 : ((Object)$total).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "QuerySubUserUsageStatResponse(usage=" + this.getUsage() + ", total=" + this.getTotal() + ")";
    }

    @Generated
    public QuerySubUserUsageStatResponse(List<Usage> usage, Total total) {
        this.usage = usage;
        this.total = total;
    }

    @Generated
    public QuerySubUserUsageStatResponse() {
    }

    @Generated
    public static class QuerySubUserUsageStatResponseBuilder {
        @Generated
        private List<Usage> usage;
        @Generated
        private Total total;

        @Generated
        QuerySubUserUsageStatResponseBuilder() {
        }

        @Generated
        public QuerySubUserUsageStatResponseBuilder usage(List<Usage> usage) {
            this.usage = usage;
            return this;
        }

        @Generated
        public QuerySubUserUsageStatResponseBuilder total(Total total) {
            this.total = total;
            return this;
        }

        @Generated
        public QuerySubUserUsageStatResponse build() {
            return new QuerySubUserUsageStatResponse(this.usage, this.total);
        }

        @Generated
        public String toString() {
            return "QuerySubUserUsageStatResponse.QuerySubUserUsageStatResponseBuilder(usage=" + this.usage + ", total=" + this.total + ")";
        }
    }

    public static class Total
    implements Serializable {
        private Integer traffic;
        @JsonProperty(value="extra_traffic")
        private Integer extraTraffic;
        private Integer request;

        @Generated
        public Total() {
        }

        @Generated
        public Integer getTraffic() {
            return this.traffic;
        }

        @Generated
        public Integer getExtraTraffic() {
            return this.extraTraffic;
        }

        @Generated
        public Integer getRequest() {
            return this.request;
        }

        @Generated
        public void setTraffic(Integer traffic) {
            this.traffic = traffic;
        }

        @JsonProperty(value="extra_traffic")
        @Generated
        public void setExtraTraffic(Integer extraTraffic) {
            this.extraTraffic = extraTraffic;
        }

        @Generated
        public void setRequest(Integer request) {
            this.request = request;
        }

        @Generated
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Total)) {
                return false;
            }
            Total other = (Total)o;
            if (!other.canEqual(this)) {
                return false;
            }
            Integer this$traffic = this.getTraffic();
            Integer other$traffic = other.getTraffic();
            if (this$traffic == null ? other$traffic != null : !((Object)this$traffic).equals(other$traffic)) {
                return false;
            }
            Integer this$extraTraffic = this.getExtraTraffic();
            Integer other$extraTraffic = other.getExtraTraffic();
            if (this$extraTraffic == null ? other$extraTraffic != null : !((Object)this$extraTraffic).equals(other$extraTraffic)) {
                return false;
            }
            Integer this$request = this.getRequest();
            Integer other$request = other.getRequest();
            return !(this$request == null ? other$request != null : !((Object)this$request).equals(other$request));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof Total;
        }

        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            Integer $traffic = this.getTraffic();
            result = result * 59 + ($traffic == null ? 43 : ((Object)$traffic).hashCode());
            Integer $extraTraffic = this.getExtraTraffic();
            result = result * 59 + ($extraTraffic == null ? 43 : ((Object)$extraTraffic).hashCode());
            Integer $request = this.getRequest();
            result = result * 59 + ($request == null ? 43 : ((Object)$request).hashCode());
            return result;
        }

        @Generated
        public String toString() {
            return "QuerySubUserUsageStatResponse.Total(traffic=" + this.getTraffic() + ", extraTraffic=" + this.getExtraTraffic() + ", request=" + this.getRequest() + ")";
        }
    }

    public static class Usage
    implements Serializable {
        private Double traffic;
        @JsonProperty(value="extra_traffic")
        private Double extraTraffic;
        private Long request;
        @JsonProperty(value="d_usage")
        private LocalDate usageD;

        @Generated
        public Usage() {
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
            return !(this$usageD == null ? other$usageD != null : !((Object)this$usageD).equals(other$usageD));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof Usage;
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
            return result;
        }

        @Generated
        public String toString() {
            return "QuerySubUserUsageStatResponse.Usage(traffic=" + this.getTraffic() + ", extraTraffic=" + this.getExtraTraffic() + ", request=" + this.getRequest() + ", usageD=" + this.getUsageD() + ")";
        }
    }
}

