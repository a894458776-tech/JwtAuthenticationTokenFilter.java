/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import com.kylin.kton.api.netnut.entity.subuser.TrafficAvailableCountriesData;
import java.util.List;
import lombok.Generated;

public class TrafficAvailableCountriesResponse {
    private boolean success;
    private List<TrafficAvailableCountriesData> data;

    @Generated
    public TrafficAvailableCountriesResponse() {
    }

    @Generated
    public boolean isSuccess() {
        return this.success;
    }

    @Generated
    public List<TrafficAvailableCountriesData> getData() {
        return this.data;
    }

    @Generated
    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Generated
    public void setData(List<TrafficAvailableCountriesData> data) {
        this.data = data;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TrafficAvailableCountriesResponse)) {
            return false;
        }
        TrafficAvailableCountriesResponse other = (TrafficAvailableCountriesResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.isSuccess() != other.isSuccess()) {
            return false;
        }
        List<TrafficAvailableCountriesData> this$data = this.getData();
        List<TrafficAvailableCountriesData> other$data = other.getData();
        return !(this$data == null ? other$data != null : !((Object)this$data).equals(other$data));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof TrafficAvailableCountriesResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isSuccess() ? 79 : 97);
        List<TrafficAvailableCountriesData> $data = this.getData();
        result = result * 59 + ($data == null ? 43 : ((Object)$data).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "TrafficAvailableCountriesResponse(success=" + this.isSuccess() + ", data=" + this.getData() + ")";
    }
}

