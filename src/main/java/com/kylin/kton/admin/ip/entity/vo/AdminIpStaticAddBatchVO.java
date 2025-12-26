/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.vo;

import com.kylin.kton.admin.ip.entity.vo.AdminIpStaticAddBatchItemVO;
import java.util.List;
import lombok.Generated;

public class AdminIpStaticAddBatchVO {
    List<AdminIpStaticAddBatchItemVO> staticIps;

    @Generated
    public AdminIpStaticAddBatchVO() {
    }

    @Generated
    public List<AdminIpStaticAddBatchItemVO> getStaticIps() {
        return this.staticIps;
    }

    @Generated
    public void setStaticIps(List<AdminIpStaticAddBatchItemVO> staticIps) {
        this.staticIps = staticIps;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminIpStaticAddBatchVO)) {
            return false;
        }
        AdminIpStaticAddBatchVO other = (AdminIpStaticAddBatchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        List<AdminIpStaticAddBatchItemVO> this$staticIps = this.getStaticIps();
        List<AdminIpStaticAddBatchItemVO> other$staticIps = other.getStaticIps();
        return !(this$staticIps == null ? other$staticIps != null : !((Object)this$staticIps).equals(other$staticIps));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminIpStaticAddBatchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        List<AdminIpStaticAddBatchItemVO> $staticIps = this.getStaticIps();
        result = result * 59 + ($staticIps == null ? 43 : ((Object)$staticIps).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminIpStaticAddBatchVO(staticIps=" + this.getStaticIps() + ")";
    }
}

