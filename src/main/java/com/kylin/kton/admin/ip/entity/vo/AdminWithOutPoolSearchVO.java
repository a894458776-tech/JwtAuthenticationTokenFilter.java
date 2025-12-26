/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.vo;

import lombok.Generated;

public class AdminWithOutPoolSearchVO {
    private Long sourceId;
    private String ip;
    private Long status;
    private Long poolId;

    @Generated
    public AdminWithOutPoolSearchVO() {
    }

    @Generated
    public Long getSourceId() {
        return this.sourceId;
    }

    @Generated
    public String getIp() {
        return this.ip;
    }

    @Generated
    public Long getStatus() {
        return this.status;
    }

    @Generated
    public Long getPoolId() {
        return this.poolId;
    }

    @Generated
    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    @Generated
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Generated
    public void setStatus(Long status) {
        this.status = status;
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
        if (!(o instanceof AdminWithOutPoolSearchVO)) {
            return false;
        }
        AdminWithOutPoolSearchVO other = (AdminWithOutPoolSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$sourceId = this.getSourceId();
        Long other$sourceId = other.getSourceId();
        if (this$sourceId == null ? other$sourceId != null : !((Object)this$sourceId).equals(other$sourceId)) {
            return false;
        }
        Long this$status = this.getStatus();
        Long other$status = other.getStatus();
        if (this$status == null ? other$status != null : !((Object)this$status).equals(other$status)) {
            return false;
        }
        Long this$poolId = this.getPoolId();
        Long other$poolId = other.getPoolId();
        if (this$poolId == null ? other$poolId != null : !((Object)this$poolId).equals(other$poolId)) {
            return false;
        }
        String this$ip = this.getIp();
        String other$ip = other.getIp();
        return !(this$ip == null ? other$ip != null : !this$ip.equals(other$ip));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminWithOutPoolSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $sourceId = this.getSourceId();
        result = result * 59 + ($sourceId == null ? 43 : ((Object)$sourceId).hashCode());
        Long $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : ((Object)$status).hashCode());
        Long $poolId = this.getPoolId();
        result = result * 59 + ($poolId == null ? 43 : ((Object)$poolId).hashCode());
        String $ip = this.getIp();
        result = result * 59 + ($ip == null ? 43 : $ip.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminWithOutPoolSearchVO(sourceId=" + this.getSourceId() + ", ip=" + this.getIp() + ", status=" + this.getStatus() + ", poolId=" + this.getPoolId() + ")";
    }
}

