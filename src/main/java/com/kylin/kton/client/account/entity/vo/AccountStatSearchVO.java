/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  lombok.Generated
 */
package com.kylin.kton.client.account.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Generated;

public class AccountStatSearchVO {
    @JsonFormat(pattern="yyyy-MM-dd")
    private String startTime;
    @JsonFormat(pattern="yyyy-MM-dd")
    private String endTime;
    private Long merchantId;

    @Generated
    public AccountStatSearchVO() {
    }

    @Generated
    public String getStartTime() {
        return this.startTime;
    }

    @Generated
    public String getEndTime() {
        return this.endTime;
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    @Generated
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    @Generated
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AccountStatSearchVO)) {
            return false;
        }
        AccountStatSearchVO other = (AccountStatSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        String this$startTime = this.getStartTime();
        String other$startTime = other.getStartTime();
        if (this$startTime == null ? other$startTime != null : !this$startTime.equals(other$startTime)) {
            return false;
        }
        String this$endTime = this.getEndTime();
        String other$endTime = other.getEndTime();
        return !(this$endTime == null ? other$endTime != null : !this$endTime.equals(other$endTime));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AccountStatSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        String $startTime = this.getStartTime();
        result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
        String $endTime = this.getEndTime();
        result = result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AccountStatSearchVO(startTime=" + this.getStartTime() + ", endTime=" + this.getEndTime() + ", merchantId=" + this.getMerchantId() + ")";
    }
}

