/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticSource
 *  com.kylin.kton.system.domain.KtonSource
 *  io.swagger.annotations.ApiModelProperty
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.dto;

import com.kylin.kton.system.domain.KtonIpStaticSource;
import com.kylin.kton.system.domain.KtonSource;
import io.swagger.annotations.ApiModelProperty;
import lombok.Generated;

public class AdminIpStaticSourceDTO
extends KtonIpStaticSource {
    @ApiModelProperty(value="\u4f9b\u5e94\u5546\u4fe1\u606f")
    KtonSource sourceInfo;

    @Generated
    public AdminIpStaticSourceDTO() {
    }

    @Generated
    public KtonSource getSourceInfo() {
        return this.sourceInfo;
    }

    @Generated
    public void setSourceInfo(KtonSource sourceInfo) {
        this.sourceInfo = sourceInfo;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminIpStaticSourceDTO)) {
            return false;
        }
        AdminIpStaticSourceDTO other = (AdminIpStaticSourceDTO)((Object)o);
        if (!other.canEqual((Object)this)) {
            return false;
        }
        KtonSource this$sourceInfo = this.getSourceInfo();
        KtonSource other$sourceInfo = other.getSourceInfo();
        return !(this$sourceInfo == null ? other$sourceInfo != null : !this$sourceInfo.equals(other$sourceInfo));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminIpStaticSourceDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        KtonSource $sourceInfo = this.getSourceInfo();
        result = result * 59 + ($sourceInfo == null ? 43 : $sourceInfo.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminIpStaticSourceDTO(sourceInfo=" + this.getSourceInfo() + ")";
    }
}

