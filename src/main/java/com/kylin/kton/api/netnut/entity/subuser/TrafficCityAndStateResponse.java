/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kylin.kton.api.netnut.entity.subuser.TrafficCityAndStateData;
import java.util.List;
import lombok.Generated;

public class TrafficCityAndStateResponse {
    @JsonProperty(value="success")
    private boolean success;
    @JsonProperty(value="data")
    private List<TrafficCityAndStateData> data;

    @Generated
    public TrafficCityAndStateResponse() {
    }

    @Generated
    public boolean isSuccess() {
        return this.success;
    }

    @Generated
    public List<TrafficCityAndStateData> getData() {
        return this.data;
    }

    @JsonProperty(value="success")
    @Generated
    public void setSuccess(boolean success) {
        this.success = success;
    }

    @JsonProperty(value="data")
    @Generated
    public void setData(List<TrafficCityAndStateData> data) {
        this.data = data;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TrafficCityAndStateResponse)) {
            return false;
        }
        TrafficCityAndStateResponse other = (TrafficCityAndStateResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.isSuccess() != other.isSuccess()) {
            return false;
        }
        List<TrafficCityAndStateData> this$data = this.getData();
        List<TrafficCityAndStateData> other$data = other.getData();
        return !(this$data == null ? other$data != null : !((Object)this$data).equals(other$data));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof TrafficCityAndStateResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isSuccess() ? 79 : 97);
        List<TrafficCityAndStateData> $data = this.getData();
        result = result * 59 + ($data == null ? 43 : ((Object)$data).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "TrafficCityAndStateResponse(success=" + this.isSuccess() + ", data=" + this.getData() + ")";
    }
}

