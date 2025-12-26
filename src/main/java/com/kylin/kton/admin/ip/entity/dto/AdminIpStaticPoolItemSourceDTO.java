/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.dto;

import lombok.Generated;

public class AdminIpStaticPoolItemSourceDTO {
    @Generated
    public AdminIpStaticPoolItemSourceDTO() {
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminIpStaticPoolItemSourceDTO)) {
            return false;
        }
        AdminIpStaticPoolItemSourceDTO other = (AdminIpStaticPoolItemSourceDTO)o;
        return other.canEqual(this);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminIpStaticPoolItemSourceDTO;
    }

    @Generated
    public int hashCode() {
        boolean result = true;
        return 1;
    }

    @Generated
    public String toString() {
        return "AdminIpStaticPoolItemSourceDTO()";
    }
}

