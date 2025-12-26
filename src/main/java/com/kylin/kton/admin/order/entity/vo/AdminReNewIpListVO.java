/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.validation.constraints.NotEmpty
 *  javax.validation.constraints.NotNull
 *  lombok.Generated
 */
package com.kylin.kton.admin.order.entity.vo;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Generated;

public class AdminReNewIpListVO {
    @NotEmpty(message="IP\u5217\u8868\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotEmpty(message="IP\u5217\u8868\u4e0d\u80fd\u4e3a\u7a7a") List<String> ipList = new ArrayList<String>();
    @NotNull(message="\u7eed\u8d39\u6708\u6570\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="\u7eed\u8d39\u6708\u6570\u4e0d\u80fd\u4e3a\u7a7a") Long monthCount;
    @NotNull(message="\u5546\u6237Id\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="\u5546\u6237Id\u4e0d\u80fd\u4e3a\u7a7a") Long merchantId;

    @Generated
    public AdminReNewIpListVO() {
    }

    @Generated
    public List<String> getIpList() {
        return this.ipList;
    }

    @Generated
    public Long getMonthCount() {
        return this.monthCount;
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public void setIpList(List<String> ipList) {
        this.ipList = ipList;
    }

    @Generated
    public void setMonthCount(Long monthCount) {
        this.monthCount = monthCount;
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
        if (!(o instanceof AdminReNewIpListVO)) {
            return false;
        }
        AdminReNewIpListVO other = (AdminReNewIpListVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$monthCount = this.getMonthCount();
        Long other$monthCount = other.getMonthCount();
        if (this$monthCount == null ? other$monthCount != null : !((Object)this$monthCount).equals(other$monthCount)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        List<String> this$ipList = this.getIpList();
        List<String> other$ipList = other.getIpList();
        return !(this$ipList == null ? other$ipList != null : !((Object)this$ipList).equals(other$ipList));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminReNewIpListVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $monthCount = this.getMonthCount();
        result = result * 59 + ($monthCount == null ? 43 : ((Object)$monthCount).hashCode());
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        List<String> $ipList = this.getIpList();
        result = result * 59 + ($ipList == null ? 43 : ((Object)$ipList).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminReNewIpListVO(ipList=" + this.getIpList() + ", monthCount=" + this.getMonthCount() + ", merchantId=" + this.getMerchantId() + ")";
    }
}

