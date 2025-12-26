/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import java.util.List;
import lombok.Generated;

public class TrafficAvailableCountriesMobResponse {
    private boolean success;
    private List<String> data;

    @Generated
    public TrafficAvailableCountriesMobResponse() {
    }

    @Generated
    public boolean isSuccess() {
        return this.success;
    }

    @Generated
    public List<String> getData() {
        return this.data;
    }

    @Generated
    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Generated
    public void setData(List<String> data) {
        this.data = data;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TrafficAvailableCountriesMobResponse)) {
            return false;
        }
        TrafficAvailableCountriesMobResponse other = (TrafficAvailableCountriesMobResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.isSuccess() != other.isSuccess()) {
            return false;
        }
        List<String> this$data = this.getData();
        List<String> other$data = other.getData();
        return !(this$data == null ? other$data != null : !((Object)this$data).equals(other$data));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof TrafficAvailableCountriesMobResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isSuccess() ? 79 : 97);
        List<String> $data = this.getData();
        result = result * 59 + ($data == null ? 43 : ((Object)$data).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "TrafficAvailableCountriesMobResponse(success=" + this.isSuccess() + ", data=" + this.getData() + ")";
    }
}

