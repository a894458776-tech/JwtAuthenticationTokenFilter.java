/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.oxylabs.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Generated;

public class MyusageResponse {
    private Integer id;
    @JsonProperty(value="start_date")
    private String startDate;
    @JsonProperty(value="end_date")
    private String endDate;
    @JsonProperty(value="is_active")
    private Boolean isActive;
    @JsonProperty(value="total_requests_used")
    private BigDecimal totalRequestsUsed;
    @JsonProperty(value="total_gb_used")
    private BigDecimal totalGbUsed;
    @JsonProperty(value="usage_percentage")
    private BigDecimal usagePercentage;
    @JsonProperty(value="plan_gb")
    private BigDecimal planGb;
    @JsonProperty(value="threads_used")
    private String threadsUsed;

    @Generated
    public static MyusageResponseBuilder builder() {
        return new MyusageResponseBuilder();
    }

    @Generated
    public Integer getId() {
        return this.id;
    }

    @Generated
    public String getStartDate() {
        return this.startDate;
    }

    @Generated
    public String getEndDate() {
        return this.endDate;
    }

    @Generated
    public Boolean getIsActive() {
        return this.isActive;
    }

    @Generated
    public BigDecimal getTotalRequestsUsed() {
        return this.totalRequestsUsed;
    }

    @Generated
    public BigDecimal getTotalGbUsed() {
        return this.totalGbUsed;
    }

    @Generated
    public BigDecimal getUsagePercentage() {
        return this.usagePercentage;
    }

    @Generated
    public BigDecimal getPlanGb() {
        return this.planGb;
    }

    @Generated
    public String getThreadsUsed() {
        return this.threadsUsed;
    }

    @Generated
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty(value="start_date")
    @Generated
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty(value="end_date")
    @Generated
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @JsonProperty(value="is_active")
    @Generated
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty(value="total_requests_used")
    @Generated
    public void setTotalRequestsUsed(BigDecimal totalRequestsUsed) {
        this.totalRequestsUsed = totalRequestsUsed;
    }

    @JsonProperty(value="total_gb_used")
    @Generated
    public void setTotalGbUsed(BigDecimal totalGbUsed) {
        this.totalGbUsed = totalGbUsed;
    }

    @JsonProperty(value="usage_percentage")
    @Generated
    public void setUsagePercentage(BigDecimal usagePercentage) {
        this.usagePercentage = usagePercentage;
    }

    @JsonProperty(value="plan_gb")
    @Generated
    public void setPlanGb(BigDecimal planGb) {
        this.planGb = planGb;
    }

    @JsonProperty(value="threads_used")
    @Generated
    public void setThreadsUsed(String threadsUsed) {
        this.threadsUsed = threadsUsed;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MyusageResponse)) {
            return false;
        }
        MyusageResponse other = (MyusageResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Integer this$id = this.getId();
        Integer other$id = other.getId();
        if (this$id == null ? other$id != null : !((Object)this$id).equals(other$id)) {
            return false;
        }
        Boolean this$isActive = this.getIsActive();
        Boolean other$isActive = other.getIsActive();
        if (this$isActive == null ? other$isActive != null : !((Object)this$isActive).equals(other$isActive)) {
            return false;
        }
        String this$startDate = this.getStartDate();
        String other$startDate = other.getStartDate();
        if (this$startDate == null ? other$startDate != null : !this$startDate.equals(other$startDate)) {
            return false;
        }
        String this$endDate = this.getEndDate();
        String other$endDate = other.getEndDate();
        if (this$endDate == null ? other$endDate != null : !this$endDate.equals(other$endDate)) {
            return false;
        }
        BigDecimal this$totalRequestsUsed = this.getTotalRequestsUsed();
        BigDecimal other$totalRequestsUsed = other.getTotalRequestsUsed();
        if (this$totalRequestsUsed == null ? other$totalRequestsUsed != null : !((Object)this$totalRequestsUsed).equals(other$totalRequestsUsed)) {
            return false;
        }
        BigDecimal this$totalGbUsed = this.getTotalGbUsed();
        BigDecimal other$totalGbUsed = other.getTotalGbUsed();
        if (this$totalGbUsed == null ? other$totalGbUsed != null : !((Object)this$totalGbUsed).equals(other$totalGbUsed)) {
            return false;
        }
        BigDecimal this$usagePercentage = this.getUsagePercentage();
        BigDecimal other$usagePercentage = other.getUsagePercentage();
        if (this$usagePercentage == null ? other$usagePercentage != null : !((Object)this$usagePercentage).equals(other$usagePercentage)) {
            return false;
        }
        BigDecimal this$planGb = this.getPlanGb();
        BigDecimal other$planGb = other.getPlanGb();
        if (this$planGb == null ? other$planGb != null : !((Object)this$planGb).equals(other$planGb)) {
            return false;
        }
        String this$threadsUsed = this.getThreadsUsed();
        String other$threadsUsed = other.getThreadsUsed();
        return !(this$threadsUsed == null ? other$threadsUsed != null : !this$threadsUsed.equals(other$threadsUsed));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof MyusageResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $id = this.getId();
        result = result * 59 + ($id == null ? 43 : ((Object)$id).hashCode());
        Boolean $isActive = this.getIsActive();
        result = result * 59 + ($isActive == null ? 43 : ((Object)$isActive).hashCode());
        String $startDate = this.getStartDate();
        result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
        String $endDate = this.getEndDate();
        result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
        BigDecimal $totalRequestsUsed = this.getTotalRequestsUsed();
        result = result * 59 + ($totalRequestsUsed == null ? 43 : ((Object)$totalRequestsUsed).hashCode());
        BigDecimal $totalGbUsed = this.getTotalGbUsed();
        result = result * 59 + ($totalGbUsed == null ? 43 : ((Object)$totalGbUsed).hashCode());
        BigDecimal $usagePercentage = this.getUsagePercentage();
        result = result * 59 + ($usagePercentage == null ? 43 : ((Object)$usagePercentage).hashCode());
        BigDecimal $planGb = this.getPlanGb();
        result = result * 59 + ($planGb == null ? 43 : ((Object)$planGb).hashCode());
        String $threadsUsed = this.getThreadsUsed();
        result = result * 59 + ($threadsUsed == null ? 43 : $threadsUsed.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "MyusageResponse(id=" + this.getId() + ", startDate=" + this.getStartDate() + ", endDate=" + this.getEndDate() + ", isActive=" + this.getIsActive() + ", totalRequestsUsed=" + this.getTotalRequestsUsed() + ", totalGbUsed=" + this.getTotalGbUsed() + ", usagePercentage=" + this.getUsagePercentage() + ", planGb=" + this.getPlanGb() + ", threadsUsed=" + this.getThreadsUsed() + ")";
    }

    @Generated
    public MyusageResponse(Integer id, String startDate, String endDate, Boolean isActive, BigDecimal totalRequestsUsed, BigDecimal totalGbUsed, BigDecimal usagePercentage, BigDecimal planGb, String threadsUsed) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
        this.totalRequestsUsed = totalRequestsUsed;
        this.totalGbUsed = totalGbUsed;
        this.usagePercentage = usagePercentage;
        this.planGb = planGb;
        this.threadsUsed = threadsUsed;
    }

    @Generated
    public MyusageResponse() {
    }

    @Generated
    public static class MyusageResponseBuilder {
        @Generated
        private Integer id;
        @Generated
        private String startDate;
        @Generated
        private String endDate;
        @Generated
        private Boolean isActive;
        @Generated
        private BigDecimal totalRequestsUsed;
        @Generated
        private BigDecimal totalGbUsed;
        @Generated
        private BigDecimal usagePercentage;
        @Generated
        private BigDecimal planGb;
        @Generated
        private String threadsUsed;

        @Generated
        MyusageResponseBuilder() {
        }

        @Generated
        public MyusageResponseBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        @JsonProperty(value="start_date")
        @Generated
        public MyusageResponseBuilder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        @JsonProperty(value="end_date")
        @Generated
        public MyusageResponseBuilder endDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        @JsonProperty(value="is_active")
        @Generated
        public MyusageResponseBuilder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        @JsonProperty(value="total_requests_used")
        @Generated
        public MyusageResponseBuilder totalRequestsUsed(BigDecimal totalRequestsUsed) {
            this.totalRequestsUsed = totalRequestsUsed;
            return this;
        }

        @JsonProperty(value="total_gb_used")
        @Generated
        public MyusageResponseBuilder totalGbUsed(BigDecimal totalGbUsed) {
            this.totalGbUsed = totalGbUsed;
            return this;
        }

        @JsonProperty(value="usage_percentage")
        @Generated
        public MyusageResponseBuilder usagePercentage(BigDecimal usagePercentage) {
            this.usagePercentage = usagePercentage;
            return this;
        }

        @JsonProperty(value="plan_gb")
        @Generated
        public MyusageResponseBuilder planGb(BigDecimal planGb) {
            this.planGb = planGb;
            return this;
        }

        @JsonProperty(value="threads_used")
        @Generated
        public MyusageResponseBuilder threadsUsed(String threadsUsed) {
            this.threadsUsed = threadsUsed;
            return this;
        }

        @Generated
        public MyusageResponse build() {
            return new MyusageResponse(this.id, this.startDate, this.endDate, this.isActive, this.totalRequestsUsed, this.totalGbUsed, this.usagePercentage, this.planGb, this.threadsUsed);
        }

        @Generated
        public String toString() {
            return "MyusageResponse.MyusageResponseBuilder(id=" + this.id + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ", isActive=" + this.isActive + ", totalRequestsUsed=" + this.totalRequestsUsed + ", totalGbUsed=" + this.totalGbUsed + ", usagePercentage=" + this.usagePercentage + ", planGb=" + this.planGb + ", threadsUsed=" + this.threadsUsed + ")";
        }
    }
}

