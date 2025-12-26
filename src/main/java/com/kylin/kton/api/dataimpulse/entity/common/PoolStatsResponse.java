/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.dataimpulse.entity.common;

import com.kylin.kton.api.dataimpulse.entity.common.Country;
import java.io.Serializable;
import java.util.List;
import lombok.Generated;

public class PoolStatsResponse
implements Serializable {
    private List<PoolStats> poolStats;

    @Generated
    public static PoolStatsResponseBuilder builder() {
        return new PoolStatsResponseBuilder();
    }

    @Generated
    public PoolStatsResponse(List<PoolStats> poolStats) {
        this.poolStats = poolStats;
    }

    @Generated
    public PoolStatsResponse() {
    }

    @Generated
    public List<PoolStats> getPoolStats() {
        return this.poolStats;
    }

    @Generated
    public void setPoolStats(List<PoolStats> poolStats) {
        this.poolStats = poolStats;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PoolStatsResponse)) {
            return false;
        }
        PoolStatsResponse other = (PoolStatsResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        List<PoolStats> this$poolStats = this.getPoolStats();
        List<PoolStats> other$poolStats = other.getPoolStats();
        return !(this$poolStats == null ? other$poolStats != null : !((Object)this$poolStats).equals(other$poolStats));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof PoolStatsResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        List<PoolStats> $poolStats = this.getPoolStats();
        result = result * 59 + ($poolStats == null ? 43 : ((Object)$poolStats).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "PoolStatsResponse(poolStats=" + this.getPoolStats() + ")";
    }

    @Generated
    public static class PoolStatsResponseBuilder {
        @Generated
        private List<PoolStats> poolStats;

        @Generated
        PoolStatsResponseBuilder() {
        }

        @Generated
        public PoolStatsResponseBuilder poolStats(List<PoolStats> poolStats) {
            this.poolStats = poolStats;
            return this;
        }

        @Generated
        public PoolStatsResponse build() {
            return new PoolStatsResponse(this.poolStats);
        }

        @Generated
        public String toString() {
            return "PoolStatsResponse.PoolStatsResponseBuilder(poolStats=" + this.poolStats + ")";
        }
    }

    public static class PoolStats
    extends Country
    implements Serializable {
        private Integer count;

        @Override
        @Generated
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof PoolStats)) {
                return false;
            }
            PoolStats other = (PoolStats)o;
            if (!other.canEqual(this)) {
                return false;
            }
            if (!super.equals(o)) {
                return false;
            }
            Integer this$count = this.getCount();
            Integer other$count = other.getCount();
            return !(this$count == null ? other$count != null : !((Object)this$count).equals(other$count));
        }

        @Override
        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof PoolStats;
        }

        @Override
        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = super.hashCode();
            Integer $count = this.getCount();
            result = result * 59 + ($count == null ? 43 : ((Object)$count).hashCode());
            return result;
        }

        @Generated
        public PoolStats() {
        }

        @Generated
        public Integer getCount() {
            return this.count;
        }

        @Generated
        public void setCount(Integer count) {
            this.count = count;
        }

        @Override
        @Generated
        public String toString() {
            return "PoolStatsResponse.PoolStats(count=" + this.getCount() + ")";
        }
    }
}

