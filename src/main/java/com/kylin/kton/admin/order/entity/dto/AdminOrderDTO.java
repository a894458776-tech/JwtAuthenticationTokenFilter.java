/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonOrder
 *  io.swagger.annotations.ApiModel
 *  io.swagger.annotations.ApiModelProperty
 *  lombok.Generated
 */
package com.kylin.kton.admin.order.entity.dto;

import com.kylin.kton.system.domain.KtonOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Generated;

@ApiModel(value="\u8ba2\u5355\u5217\u8868")
public class AdminOrderDTO
extends KtonOrder {
    @ApiModelProperty(value="IP\u603b\u6570")
    private Integer ipTotals;
    @ApiModelProperty(value="\u53ef\u7528IP\u6570")
    private Integer effectiveTotals;

    @Generated
    public AdminOrderDTO() {
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
    public void setIpTotals(Integer ipTotals) {
        this.ipTotals = ipTotals;
    }

    @Generated
    public void setEffectiveTotals(Integer effectiveTotals) {
        this.effectiveTotals = effectiveTotals;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminOrderDTO)) {
            return false;
        }
        AdminOrderDTO other = (AdminOrderDTO)((Object)o);
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
        return !(this$effectiveTotals == null ? other$effectiveTotals != null : !((Object)this$effectiveTotals).equals(other$effectiveTotals));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminOrderDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $ipTotals = this.getIpTotals();
        result = result * 59 + ($ipTotals == null ? 43 : ((Object)$ipTotals).hashCode());
        Integer $effectiveTotals = this.getEffectiveTotals();
        result = result * 59 + ($effectiveTotals == null ? 43 : ((Object)$effectiveTotals).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminOrderDTO(ipTotals=" + this.getIpTotals() + ", effectiveTotals=" + this.getEffectiveTotals() + ")";
    }
}

