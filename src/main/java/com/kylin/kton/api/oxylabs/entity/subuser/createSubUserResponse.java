/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.oxylabs.entity.subuser;

import lombok.Generated;

public class createSubUserResponse {
    private Integer id;

    @Generated
    public createSubUserResponse() {
    }

    @Generated
    public Integer getId() {
        return this.id;
    }

    @Generated
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof createSubUserResponse)) {
            return false;
        }
        createSubUserResponse other = (createSubUserResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Integer this$id = this.getId();
        Integer other$id = other.getId();
        return !(this$id == null ? other$id != null : !((Object)this$id).equals(other$id));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof createSubUserResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $id = this.getId();
        result = result * 59 + ($id == null ? 43 : ((Object)$id).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "createSubUserResponse(id=" + this.getId() + ")";
    }
}

