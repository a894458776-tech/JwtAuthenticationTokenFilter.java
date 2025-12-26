/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.validation.constraints.NotNull
 *  javax.validation.constraints.Pattern
 *  lombok.Generated
 */
package com.kylin.kton.client.vps.entity.vo;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Generated;

public class UpdateStatusVO
implements Serializable {
    @NotNull(message="id\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="id\u4e0d\u80fd\u4e3a\u7a7a") Long id;
    @NotNull(message="status\u4e0d\u80fd\u4e3a\u7a7a")
    @Pattern(regexp="25|30|50", message="\u72b6\u6001\u53c2\u6570\u4e0d\u5bf9")
    private @NotNull(message="status\u4e0d\u80fd\u4e3a\u7a7a") @Pattern(regexp="25|30|50", message="\u72b6\u6001\u53c2\u6570\u4e0d\u5bf9") String status;

    @Generated
    public UpdateStatusVO() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public String getStatus() {
        return this.status;
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
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
        if (!(o instanceof UpdateStatusVO)) {
            return false;
        }
        UpdateStatusVO other = (UpdateStatusVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$id = this.getId();
        Long other$id = other.getId();
        if (this$id == null ? other$id != null : !((Object)this$id).equals(other$id)) {
            return false;
        }
        String this$status = this.getStatus();
        String other$status = other.getStatus();
        return !(this$status == null ? other$status != null : !this$status.equals(other$status));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof UpdateStatusVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $id = this.getId();
        result = result * 59 + ($id == null ? 43 : ((Object)$id).hashCode());
        String $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "UpdateStatusVO(id=" + this.getId() + ", status=" + this.getStatus() + ")";
    }
}

