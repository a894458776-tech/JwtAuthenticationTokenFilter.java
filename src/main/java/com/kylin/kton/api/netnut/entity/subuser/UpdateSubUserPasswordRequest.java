/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

public class UpdateSubUserPasswordRequest {
    @JsonProperty(value="new_login_pwd")
    private String newLoginPwd;

    @Generated
    public UpdateSubUserPasswordRequest() {
    }

    @Generated
    public String getNewLoginPwd() {
        return this.newLoginPwd;
    }

    @JsonProperty(value="new_login_pwd")
    @Generated
    public void setNewLoginPwd(String newLoginPwd) {
        this.newLoginPwd = newLoginPwd;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof UpdateSubUserPasswordRequest)) {
            return false;
        }
        UpdateSubUserPasswordRequest other = (UpdateSubUserPasswordRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$newLoginPwd = this.getNewLoginPwd();
        String other$newLoginPwd = other.getNewLoginPwd();
        return !(this$newLoginPwd == null ? other$newLoginPwd != null : !this$newLoginPwd.equals(other$newLoginPwd));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof UpdateSubUserPasswordRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $newLoginPwd = this.getNewLoginPwd();
        result = result * 59 + ($newLoginPwd == null ? 43 : $newLoginPwd.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "UpdateSubUserPasswordRequest(newLoginPwd=" + this.getNewLoginPwd() + ")";
    }
}

