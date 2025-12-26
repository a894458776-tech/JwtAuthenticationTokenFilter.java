/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.vo;

import lombok.Generated;

public class AdminIpStaticSourceSearchVO {
    private Long sourceId;
    private String ip;
    private Long status;

    @Generated
    public AdminIpStaticSourceSearchVO() {
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
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminIpStaticSourceSearchVO)) {
            return false;
        }
        AdminIpStaticSourceSearchVO other = (AdminIpStaticSourceSearchVO)o;
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
        String this$ip = this.getIp();
        String other$ip = other.getIp();
        return !(this$ip == null ? other$ip != null : !this$ip.equals(other$ip));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminIpStaticSourceSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $sourceId = this.getSourceId();
        result = result * 59 + ($sourceId == null ? 43 : ((Object)$sourceId).hashCode());
        Long $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : ((Object)$status).hashCode());
        String $ip = this.getIp();
        result = result * 59 + ($ip == null ? 43 : $ip.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminIpStaticSourceSearchVO(sourceId=" + this.getSourceId() + ", ip=" + this.getIp() + ", status=" + this.getStatus() + ")";
    }
}

