/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.springframework.util.CollectionUtils
 */
package com.kylin.kton.api.dataimpulse.entity.subuser;

import com.kylin.kton.api.dataimpulse.entity.subuser.SubUserInfo;
import java.io.Serializable;
import java.util.List;
import lombok.Generated;
import org.springframework.util.CollectionUtils;

public class ListSubUserResponse
implements Serializable {
    private List<SubUserInfo> subusers;

    public Boolean isEmpty() {
        return CollectionUtils.isEmpty(this.subusers);
    }

    @Generated
    public ListSubUserResponse() {
    }

    @Generated
    public List<SubUserInfo> getSubusers() {
        return this.subusers;
    }

    @Generated
    public void setSubusers(List<SubUserInfo> subusers) {
        this.subusers = subusers;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ListSubUserResponse)) {
            return false;
        }
        ListSubUserResponse other = (ListSubUserResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        List<SubUserInfo> this$subusers = this.getSubusers();
        List<SubUserInfo> other$subusers = other.getSubusers();
        return !(this$subusers == null ? other$subusers != null : !((Object)this$subusers).equals(other$subusers));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ListSubUserResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        List<SubUserInfo> $subusers = this.getSubusers();
        result = result * 59 + ($subusers == null ? 43 : ((Object)$subusers).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ListSubUserResponse(subusers=" + this.getSubusers() + ")";
    }
}

