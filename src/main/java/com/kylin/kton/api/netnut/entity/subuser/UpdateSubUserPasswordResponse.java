/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import com.kylin.kton.api.netnut.entity.subuser.UpdateSubUserPasswordValue;
import java.util.List;
import lombok.Generated;

public class UpdateSubUserPasswordResponse {
    private boolean success;
    private List<UpdateSubUserPasswordValue> value;

    @Generated
    public UpdateSubUserPasswordResponse() {
    }

    @Generated
    public boolean isSuccess() {
        return this.success;
    }

    @Generated
    public List<UpdateSubUserPasswordValue> getValue() {
        return this.value;
    }

    @Generated
    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Generated
    public void setValue(List<UpdateSubUserPasswordValue> value) {
        this.value = value;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof UpdateSubUserPasswordResponse)) {
            return false;
        }
        UpdateSubUserPasswordResponse other = (UpdateSubUserPasswordResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.isSuccess() != other.isSuccess()) {
            return false;
        }
        List<UpdateSubUserPasswordValue> this$value = this.getValue();
        List<UpdateSubUserPasswordValue> other$value = other.getValue();
        return !(this$value == null ? other$value != null : !((Object)this$value).equals(other$value));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof UpdateSubUserPasswordResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isSuccess() ? 79 : 97);
        List<UpdateSubUserPasswordValue> $value = this.getValue();
        result = result * 59 + ($value == null ? 43 : ((Object)$value).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "UpdateSubUserPasswordResponse(success=" + this.isSuccess() + ", value=" + this.getValue() + ")";
    }
}

