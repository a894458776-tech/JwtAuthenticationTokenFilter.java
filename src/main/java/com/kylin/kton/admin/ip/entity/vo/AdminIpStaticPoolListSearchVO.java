/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.vo;

import lombok.Generated;

public class AdminIpStaticPoolListSearchVO {
    private String port;
    private String ip;
    private Long itemStatus;
    private Long poolId;

    @Generated
    public AdminIpStaticPoolListSearchVO() {
    }

    @Generated
    public String getPort() {
        return this.port;
    }

    @Generated
    public String getIp() {
        return this.ip;
    }

    @Generated
    public Long getItemStatus() {
        return this.itemStatus;
    }

    @Generated
    public Long getPoolId() {
        return this.poolId;
    }

    @Generated
    public void setPort(String port) {
        this.port = port;
    }

    @Generated
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Generated
    public void setItemStatus(Long itemStatus) {
        this.itemStatus = itemStatus;
    }

    @Generated
    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminIpStaticPoolListSearchVO)) {
            return false;
        }
        AdminIpStaticPoolListSearchVO other = (AdminIpStaticPoolListSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$itemStatus = this.getItemStatus();
        Long other$itemStatus = other.getItemStatus();
        if (this$itemStatus == null ? other$itemStatus != null : !((Object)this$itemStatus).equals(other$itemStatus)) {
            return false;
        }
        Long this$poolId = this.getPoolId();
        Long other$poolId = other.getPoolId();
        if (this$poolId == null ? other$poolId != null : !((Object)this$poolId).equals(other$poolId)) {
            return false;
        }
        String this$port = this.getPort();
        String other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
            return false;
        }
        String this$ip = this.getIp();
        String other$ip = other.getIp();
        return !(this$ip == null ? other$ip != null : !this$ip.equals(other$ip));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminIpStaticPoolListSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $itemStatus = this.getItemStatus();
        result = result * 59 + ($itemStatus == null ? 43 : ((Object)$itemStatus).hashCode());
        Long $poolId = this.getPoolId();
        result = result * 59 + ($poolId == null ? 43 : ((Object)$poolId).hashCode());
        String $port = this.getPort();
        result = result * 59 + ($port == null ? 43 : $port.hashCode());
        String $ip = this.getIp();
        result = result * 59 + ($ip == null ? 43 : $ip.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminIpStaticPoolListSearchVO(port=" + this.getPort() + ", ip=" + this.getIp() + ", itemStatus=" + this.getItemStatus() + ", poolId=" + this.getPoolId() + ")";
    }
}

