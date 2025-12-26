/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.dto;

import com.kylin.kton.admin.ip.entity.dto.ContinentItemDTO;
import java.util.List;
import lombok.Generated;

public class AdminIpBelongDTO {
    List<ContinentItemDTO> continent;

    @Generated
    public AdminIpBelongDTO() {
    }

    @Generated
    public List<ContinentItemDTO> getContinent() {
        return this.continent;
    }

    @Generated
    public void setContinent(List<ContinentItemDTO> continent) {
        this.continent = continent;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminIpBelongDTO)) {
            return false;
        }
        AdminIpBelongDTO other = (AdminIpBelongDTO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        List<ContinentItemDTO> this$continent = this.getContinent();
        List<ContinentItemDTO> other$continent = other.getContinent();
        return !(this$continent == null ? other$continent != null : !((Object)this$continent).equals(other$continent));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminIpBelongDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        List<ContinentItemDTO> $continent = this.getContinent();
        result = result * 59 + ($continent == null ? 43 : ((Object)$continent).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminIpBelongDTO(continent=" + this.getContinent() + ")";
    }
}

