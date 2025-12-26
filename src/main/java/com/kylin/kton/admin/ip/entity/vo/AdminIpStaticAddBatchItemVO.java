/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.validation.constraints.NotNull
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.vo;

import com.kylin.kton.admin.ip.entity.vo.AdminIpStaticItemDetailsVO;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Generated;

public class AdminIpStaticAddBatchItemVO {
    @NotNull(message="ipType\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="ipType\u4e0d\u80fd\u4e3a\u7a7a") Long ipType;
    @NotNull(message="\u5929\u6570\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="\u5929\u6570\u4e0d\u80fd\u4e3a\u7a7a") Long days;
    @NotNull(message="\u6298\u6263\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="\u6298\u6263\u4e0d\u80fd\u4e3a\u7a7a") BigDecimal discount;
    private String status;
    List<AdminIpStaticItemDetailsVO> details;

    @Generated
    public AdminIpStaticAddBatchItemVO() {
    }

    @Generated
    public Long getIpType() {
        return this.ipType;
    }

    @Generated
    public Long getDays() {
        return this.days;
    }

    @Generated
    public BigDecimal getDiscount() {
        return this.discount;
    }

    @Generated
    public String getStatus() {
        return this.status;
    }

    @Generated
    public List<AdminIpStaticItemDetailsVO> getDetails() {
        return this.details;
    }

    @Generated
    public void setIpType(Long ipType) {
        this.ipType = ipType;
    }

    @Generated
    public void setDays(Long days) {
        this.days = days;
    }

    @Generated
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Generated
    public void setStatus(String status) {
        this.status = status;
    }

    @Generated
    public void setDetails(List<AdminIpStaticItemDetailsVO> details) {
        this.details = details;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminIpStaticAddBatchItemVO)) {
            return false;
        }
        AdminIpStaticAddBatchItemVO other = (AdminIpStaticAddBatchItemVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$ipType = this.getIpType();
        Long other$ipType = other.getIpType();
        if (this$ipType == null ? other$ipType != null : !((Object)this$ipType).equals(other$ipType)) {
            return false;
        }
        Long this$days = this.getDays();
        Long other$days = other.getDays();
        if (this$days == null ? other$days != null : !((Object)this$days).equals(other$days)) {
            return false;
        }
        BigDecimal this$discount = this.getDiscount();
        BigDecimal other$discount = other.getDiscount();
        if (this$discount == null ? other$discount != null : !((Object)this$discount).equals(other$discount)) {
            return false;
        }
        String this$status = this.getStatus();
        String other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
            return false;
        }
        List<AdminIpStaticItemDetailsVO> this$details = this.getDetails();
        List<AdminIpStaticItemDetailsVO> other$details = other.getDetails();
        return !(this$details == null ? other$details != null : !((Object)this$details).equals(other$details));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminIpStaticAddBatchItemVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $ipType = this.getIpType();
        result = result * 59 + ($ipType == null ? 43 : ((Object)$ipType).hashCode());
        Long $days = this.getDays();
        result = result * 59 + ($days == null ? 43 : ((Object)$days).hashCode());
        BigDecimal $discount = this.getDiscount();
        result = result * 59 + ($discount == null ? 43 : ((Object)$discount).hashCode());
        String $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        List<AdminIpStaticItemDetailsVO> $details = this.getDetails();
        result = result * 59 + ($details == null ? 43 : ((Object)$details).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminIpStaticAddBatchItemVO(ipType=" + this.getIpType() + ", days=" + this.getDays() + ", discount=" + this.getDiscount() + ", status=" + this.getStatus() + ", details=" + this.getDetails() + ")";
    }
}

