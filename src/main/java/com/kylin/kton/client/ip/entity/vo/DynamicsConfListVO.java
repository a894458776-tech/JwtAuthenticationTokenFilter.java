/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.ip.entity.vo;

import lombok.Generated;

public class DynamicsConfListVO {
    private String status;
    private String capacity;
    private String title;
    private Long merchantId;

    @Generated
    public DynamicsConfListVO() {
    }

    @Generated
    public String getStatus() {
        return this.status;
    }

    @Generated
    public String getCapacity() {
        return this.capacity;
    }

    @Generated
    public String getTitle() {
        return this.title;
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public void setStatus(String status) {
        this.status = status;
    }

    @Generated
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Generated
    public void setTitle(String title) {
        this.title = title;
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
        if (!(o instanceof DynamicsConfListVO)) {
            return false;
        }
        DynamicsConfListVO other = (DynamicsConfListVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        String this$status = this.getStatus();
        String other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
            return false;
        }
        String this$capacity = this.getCapacity();
        String other$capacity = other.getCapacity();
        if (this$capacity == null ? other$capacity != null : !this$capacity.equals(other$capacity)) {
            return false;
        }
        String this$title = this.getTitle();
        String other$title = other.getTitle();
        return !(this$title == null ? other$title != null : !this$title.equals(other$title));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof DynamicsConfListVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        String $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        String $capacity = this.getCapacity();
        result = result * 59 + ($capacity == null ? 43 : $capacity.hashCode());
        String $title = this.getTitle();
        result = result * 59 + ($title == null ? 43 : $title.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "DynamicsConfListVO(status=" + this.getStatus() + ", capacity=" + this.getCapacity() + ", title=" + this.getTitle() + ", merchantId=" + this.getMerchantId() + ")";
    }
}

