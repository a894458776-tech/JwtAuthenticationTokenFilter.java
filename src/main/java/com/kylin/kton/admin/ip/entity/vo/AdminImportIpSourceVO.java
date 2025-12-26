/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.vo;

import com.kylin.kton.admin.ip.entity.vo.AdminImportIpItemVO;
import java.util.List;
import lombok.Generated;

public class AdminImportIpSourceVO {
    List<AdminImportIpItemVO> ips;

    @Generated
    public AdminImportIpSourceVO() {
    }

    @Generated
    public List<AdminImportIpItemVO> getIps() {
        return this.ips;
    }

    @Generated
    public void setIps(List<AdminImportIpItemVO> ips) {
        this.ips = ips;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminImportIpSourceVO)) {
            return false;
        }
        AdminImportIpSourceVO other = (AdminImportIpSourceVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        List<AdminImportIpItemVO> this$ips = this.getIps();
        List<AdminImportIpItemVO> other$ips = other.getIps();
        return !(this$ips == null ? other$ips != null : !((Object)this$ips).equals(other$ips));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminImportIpSourceVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        List<AdminImportIpItemVO> $ips = this.getIps();
        result = result * 59 + ($ips == null ? 43 : ((Object)$ips).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminImportIpSourceVO(ips=" + this.getIps() + ")";
    }
}

