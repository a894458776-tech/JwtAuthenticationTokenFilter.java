/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.swagger.annotations.ApiModelProperty
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Generated;

public class PoolItemAddBatchVO {
    @ApiModelProperty(value="IP\u5217\u8868")
    List<String> ips;
    @ApiModelProperty(value="IP\u6c60ID")
    Long poolId;

    @Generated
    public PoolItemAddBatchVO() {
    }

    @Generated
    public List<String> getIps() {
        return this.ips;
    }

    @Generated
    public Long getPoolId() {
        return this.poolId;
    }

    @Generated
    public void setIps(List<String> ips) {
        this.ips = ips;
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
        if (!(o instanceof PoolItemAddBatchVO)) {
            return false;
        }
        PoolItemAddBatchVO other = (PoolItemAddBatchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$poolId = this.getPoolId();
        Long other$poolId = other.getPoolId();
        if (this$poolId == null ? other$poolId != null : !((Object)this$poolId).equals(other$poolId)) {
            return false;
        }
        List<String> this$ips = this.getIps();
        List<String> other$ips = other.getIps();
        return !(this$ips == null ? other$ips != null : !((Object)this$ips).equals(other$ips));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof PoolItemAddBatchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $poolId = this.getPoolId();
        result = result * 59 + ($poolId == null ? 43 : ((Object)$poolId).hashCode());
        List<String> $ips = this.getIps();
        result = result * 59 + ($ips == null ? 43 : ((Object)$ips).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "PoolItemAddBatchVO(ips=" + this.getIps() + ", poolId=" + this.getPoolId() + ")";
    }
}

