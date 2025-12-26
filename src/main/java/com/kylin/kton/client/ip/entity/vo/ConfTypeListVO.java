/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.ip.entity.vo;

import lombok.Generated;

public class ConfTypeListVO {
    private String ipType;
    private Long type;
    private String status;

    @Generated
    public ConfTypeListVO() {
    }

    @Generated
    public String getIpType() {
        return this.ipType;
    }

    @Generated
    public Long getType() {
        return this.type;
    }

    @Generated
    public String getStatus() {
        return this.status;
    }

    @Generated
    public void setIpType(String ipType) {
        this.ipType = ipType;
    }

    @Generated
    public void setType(Long type) {
        this.type = type;
    }

    @Generated
    public void setStatus(String status) {
        this.status = status;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ConfTypeListVO)) {
            return false;
        }
        ConfTypeListVO other = (ConfTypeListVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$type = this.getType();
        Long other$type = other.getType();
        if (this$type == null ? other$type != null : !((Object)this$type).equals(other$type)) {
            return false;
        }
        String this$ipType = this.getIpType();
        String other$ipType = other.getIpType();
        if (this$ipType == null ? other$ipType != null : !this$ipType.equals(other$ipType)) {
            return false;
        }
        String this$status = this.getStatus();
        String other$status = other.getStatus();
        return !(this$status == null ? other$status != null : !this$status.equals(other$status));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ConfTypeListVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $type = this.getType();
        result = result * 59 + ($type == null ? 43 : ((Object)$type).hashCode());
        String $ipType = this.getIpType();
        result = result * 59 + ($ipType == null ? 43 : $ipType.hashCode());
        String $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ConfTypeListVO(ipType=" + this.getIpType() + ", type=" + this.getType() + ", status=" + this.getStatus() + ")";
    }
}

