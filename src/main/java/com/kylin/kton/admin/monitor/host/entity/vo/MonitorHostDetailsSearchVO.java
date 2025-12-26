/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.monitor.host.entity.vo;

import lombok.Generated;

public class MonitorHostDetailsSearchVO {
    private String hostIp;

    @Generated
    public MonitorHostDetailsSearchVO() {
    }

    @Generated
    public String getHostIp() {
        return this.hostIp;
    }

    @Generated
    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MonitorHostDetailsSearchVO)) {
            return false;
        }
        MonitorHostDetailsSearchVO other = (MonitorHostDetailsSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$hostIp = this.getHostIp();
        String other$hostIp = other.getHostIp();
        return !(this$hostIp == null ? other$hostIp != null : !this$hostIp.equals(other$hostIp));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof MonitorHostDetailsSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $hostIp = this.getHostIp();
        result = result * 59 + ($hostIp == null ? 43 : $hostIp.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "MonitorHostDetailsSearchVO(hostIp=" + this.getHostIp() + ")";
    }
}

