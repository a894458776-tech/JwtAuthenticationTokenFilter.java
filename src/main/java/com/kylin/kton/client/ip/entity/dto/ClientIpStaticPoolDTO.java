/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticConfigPlan
 *  com.kylin.kton.system.domain.KtonIpStaticPool
 *  lombok.Generated
 */
package com.kylin.kton.client.ip.entity.dto;

import com.kylin.kton.system.domain.KtonIpStaticConfigPlan;
import com.kylin.kton.system.domain.KtonIpStaticPool;
import java.util.List;
import lombok.Generated;

public class ClientIpStaticPoolDTO
extends KtonIpStaticPool {
    private Integer ipTotals;
    private Integer effectiveTotals;
    private List<KtonIpStaticConfigPlan> configPlans;

    @Generated
    public ClientIpStaticPoolDTO() {
    }

    @Generated
    public Integer getIpTotals() {
        return this.ipTotals;
    }

    @Generated
    public Integer getEffectiveTotals() {
        return this.effectiveTotals;
    }

    @Generated
    public List<KtonIpStaticConfigPlan> getConfigPlans() {
        return this.configPlans;
    }

    @Generated
    public void setIpTotals(Integer ipTotals) {
        this.ipTotals = ipTotals;
    }

    @Generated
    public void setEffectiveTotals(Integer effectiveTotals) {
        this.effectiveTotals = effectiveTotals;
    }

    @Generated
    public void setConfigPlans(List<KtonIpStaticConfigPlan> configPlans) {
        this.configPlans = configPlans;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ClientIpStaticPoolDTO)) {
            return false;
        }
        ClientIpStaticPoolDTO other = (ClientIpStaticPoolDTO)((Object)o);
        if (!other.canEqual((Object)this)) {
            return false;
        }
        Integer this$ipTotals = this.getIpTotals();
        Integer other$ipTotals = other.getIpTotals();
        if (this$ipTotals == null ? other$ipTotals != null : !((Object)this$ipTotals).equals(other$ipTotals)) {
            return false;
        }
        Integer this$effectiveTotals = this.getEffectiveTotals();
        Integer other$effectiveTotals = other.getEffectiveTotals();
        if (this$effectiveTotals == null ? other$effectiveTotals != null : !((Object)this$effectiveTotals).equals(other$effectiveTotals)) {
            return false;
        }
        List<KtonIpStaticConfigPlan> this$configPlans = this.getConfigPlans();
        List<KtonIpStaticConfigPlan> other$configPlans = other.getConfigPlans();
        return !(this$configPlans == null ? other$configPlans != null : !((Object)this$configPlans).equals(other$configPlans));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ClientIpStaticPoolDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $ipTotals = this.getIpTotals();
        result = result * 59 + ($ipTotals == null ? 43 : ((Object)$ipTotals).hashCode());
        Integer $effectiveTotals = this.getEffectiveTotals();
        result = result * 59 + ($effectiveTotals == null ? 43 : ((Object)$effectiveTotals).hashCode());
        List<KtonIpStaticConfigPlan> $configPlans = this.getConfigPlans();
        result = result * 59 + ($configPlans == null ? 43 : ((Object)$configPlans).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ClientIpStaticPoolDTO(ipTotals=" + this.getIpTotals() + ", effectiveTotals=" + this.getEffectiveTotals() + ", configPlans=" + this.getConfigPlans() + ")";
    }
}

