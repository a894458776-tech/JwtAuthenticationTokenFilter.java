/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.client.risk.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

public class RiskData {
    @JsonProperty(value="fraud_score")
    private Integer fraudScore;

    @Generated
    public RiskData() {
    }

    @Generated
    public Integer getFraudScore() {
        return this.fraudScore;
    }

    @JsonProperty(value="fraud_score")
    @Generated
    public void setFraudScore(Integer fraudScore) {
        this.fraudScore = fraudScore;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RiskData)) {
            return false;
        }
        RiskData other = (RiskData)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Integer this$fraudScore = this.getFraudScore();
        Integer other$fraudScore = other.getFraudScore();
        return !(this$fraudScore == null ? other$fraudScore != null : !((Object)this$fraudScore).equals(other$fraudScore));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof RiskData;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $fraudScore = this.getFraudScore();
        result = result * 59 + ($fraudScore == null ? 43 : ((Object)$fraudScore).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "RiskData(fraudScore=" + this.getFraudScore() + ")";
    }
}

