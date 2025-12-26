/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticConfigPlan
 *  lombok.Generated
 */
package com.kylin.kton.client.ip.entity.dto;

import com.kylin.kton.system.domain.KtonIpStaticConfigPlan;
import lombok.Generated;

public class ClientIpStaticPoolTypeDTO
extends KtonIpStaticConfigPlan {
    private Integer type;

    @Generated
    public ClientIpStaticPoolTypeDTO() {
    }

    @Generated
    public Integer getType() {
        return this.type;
    }

    @Generated
    public void setType(Integer type) {
        this.type = type;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ClientIpStaticPoolTypeDTO)) {
            return false;
        }
        ClientIpStaticPoolTypeDTO other = (ClientIpStaticPoolTypeDTO)((Object)o);
        if (!other.canEqual((Object)this)) {
            return false;
        }
        Integer this$type = this.getType();
        Integer other$type = other.getType();
        return !(this$type == null ? other$type != null : !((Object)this$type).equals(other$type));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ClientIpStaticPoolTypeDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $type = this.getType();
        result = result * 59 + ($type == null ? 43 : ((Object)$type).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ClientIpStaticPoolTypeDTO(type=" + this.getType() + ")";
    }
}

