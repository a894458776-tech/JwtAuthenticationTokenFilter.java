/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  lombok.Generated
 */
package com.kylin.kton.client.statis.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Generated;

public class WalletStatisSearchVO {
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startTime;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endTime;
    private Long merchantId;

    @Generated
    public WalletStatisSearchVO() {
    }

    @Generated
    public Date getStartTime() {
        return this.startTime;
    }

    @Generated
    public Date getEndTime() {
        return this.endTime;
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    @Generated
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    @Generated
    public void setEndTime(Date endTime) {
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
        if (!(o instanceof WalletStatisSearchVO)) {
            return false;
        }
        WalletStatisSearchVO other = (WalletStatisSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        Date this$startTime = this.getStartTime();
        Date other$startTime = other.getStartTime();
        if (this$startTime == null ? other$startTime != null : !((Object)this$startTime).equals(other$startTime)) {
            return false;
        }
        Date this$endTime = this.getEndTime();
        Date other$endTime = other.getEndTime();
        return !(this$endTime == null ? other$endTime != null : !((Object)this$endTime).equals(other$endTime));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof WalletStatisSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        Date $startTime = this.getStartTime();
        result = result * 59 + ($startTime == null ? 43 : ((Object)$startTime).hashCode());
        Date $endTime = this.getEndTime();
        result = result * 59 + ($endTime == null ? 43 : ((Object)$endTime).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "WalletStatisSearchVO(startTime=" + this.getStartTime() + ", endTime=" + this.getEndTime() + ", merchantId=" + this.getMerchantId() + ")";
    }
}

