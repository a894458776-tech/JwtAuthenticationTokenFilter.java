/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import com.kylin.kton.api.netnut.entity.subuser.AddSubUserData;
import lombok.Generated;

public class AddSubUserResponse {
    private boolean success;
    private AddSubUserData data;

    @Generated
    public AddSubUserResponse() {
    }

    @Generated
    public boolean isSuccess() {
        return this.success;
    }

    @Generated
    public AddSubUserData getData() {
        return this.data;
    }

    @Generated
    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Generated
    public void setData(AddSubUserData data) {
        this.data = data;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AddSubUserResponse)) {
            return false;
        }
        AddSubUserResponse other = (AddSubUserResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.isSuccess() != other.isSuccess()) {
            return false;
        }
        AddSubUserData this$data = this.getData();
        AddSubUserData other$data = other.getData();
        return !(this$data == null ? other$data != null : !((Object)this$data).equals(other$data));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AddSubUserResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isSuccess() ? 79 : 97);
        AddSubUserData $data = this.getData();
        result = result * 59 + ($data == null ? 43 : ((Object)$data).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AddSubUserResponse(success=" + this.isSuccess() + ", data=" + this.getData() + ")";
    }
}

