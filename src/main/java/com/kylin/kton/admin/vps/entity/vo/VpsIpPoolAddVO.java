/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.validation.constraints.NotNull
 *  lombok.Generated
 */
package com.kylin.kton.admin.vps.entity.vo;

import javax.validation.constraints.NotNull;
import lombok.Generated;

public class VpsIpPoolAddVO {
    @NotNull(message="\u6570\u91cf\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="\u6570\u91cf\u4e0d\u80fd\u4e3a\u7a7a") Integer quantity = 1;
    @NotNull(message="hostId\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="hostId\u4e0d\u80fd\u4e3a\u7a7a") Long hostId;
    @NotNull(message="ip\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="ip\u4e0d\u80fd\u4e3a\u7a7a") String ip;
    @NotNull(message="\u5bb9\u5668\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="\u5bb9\u5668\u4e0d\u80fd\u4e3a\u7a7a") String containerIp;
    private Long status;

    @Generated
    public VpsIpPoolAddVO() {
    }

    @Generated
    public Integer getQuantity() {
        return this.quantity;
    }

    @Generated
    public Long getHostId() {
        return this.hostId;
    }

    @Generated
    public String getIp() {
        return this.ip;
    }

    @Generated
    public String getContainerIp() {
        return this.containerIp;
    }

    @Generated
    public Long getStatus() {
        return this.status;
    }

    @Generated
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Generated
    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    @Generated
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Generated
    public void setContainerIp(String containerIp) {
        this.containerIp = containerIp;
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
        if (!(o instanceof VpsIpPoolAddVO)) {
            return false;
        }
        VpsIpPoolAddVO other = (VpsIpPoolAddVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Integer this$quantity = this.getQuantity();
        Integer other$quantity = other.getQuantity();
        if (this$quantity == null ? other$quantity != null : !((Object)this$quantity).equals(other$quantity)) {
            return false;
        }
        Long this$hostId = this.getHostId();
        Long other$hostId = other.getHostId();
        if (this$hostId == null ? other$hostId != null : !((Object)this$hostId).equals(other$hostId)) {
            return false;
        }
        Long this$status = this.getStatus();
        Long other$status = other.getStatus();
        if (this$status == null ? other$status != null : !((Object)this$status).equals(other$status)) {
            return false;
        }
        String this$ip = this.getIp();
        String other$ip = other.getIp();
        if (this$ip == null ? other$ip != null : !this$ip.equals(other$ip)) {
            return false;
        }
        String this$containerIp = this.getContainerIp();
        String other$containerIp = other.getContainerIp();
        return !(this$containerIp == null ? other$containerIp != null : !this$containerIp.equals(other$containerIp));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof VpsIpPoolAddVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $quantity = this.getQuantity();
        result = result * 59 + ($quantity == null ? 43 : ((Object)$quantity).hashCode());
        Long $hostId = this.getHostId();
        result = result * 59 + ($hostId == null ? 43 : ((Object)$hostId).hashCode());
        Long $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : ((Object)$status).hashCode());
        String $ip = this.getIp();
        result = result * 59 + ($ip == null ? 43 : $ip.hashCode());
        String $containerIp = this.getContainerIp();
        result = result * 59 + ($containerIp == null ? 43 : $containerIp.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "VpsIpPoolAddVO(quantity=" + this.getQuantity() + ", hostId=" + this.getHostId() + ", ip=" + this.getIp() + ", containerIp=" + this.getContainerIp() + ", status=" + this.getStatus() + ")";
    }
}

