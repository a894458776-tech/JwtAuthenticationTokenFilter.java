/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpDynamicsConfigPlan
 *  lombok.Generated
 */
package com.kylin.kton.client.ip.entity.dto;

import com.kylin.kton.system.domain.KtonIpDynamicsConfigPlan;
import lombok.Generated;

public class DynamicPlanConfigDTO
extends KtonIpDynamicsConfigPlan {
    @Generated
    public DynamicPlanConfigDTO() {
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DynamicPlanConfigDTO)) {
            return false;
        }
        DynamicPlanConfigDTO other = (DynamicPlanConfigDTO)((Object)o);
        return other.canEqual((Object)this);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof DynamicPlanConfigDTO;
    }

    @Generated
    public int hashCode() {
        boolean result = true;
        return 1;
    }

    @Generated
    public String toString() {
        return "DynamicPlanConfigDTO()";
    }
}

