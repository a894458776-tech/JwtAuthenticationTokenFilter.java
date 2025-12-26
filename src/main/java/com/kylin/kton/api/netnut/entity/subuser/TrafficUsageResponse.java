/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.springframework.util.CollectionUtils
 */
package com.kylin.kton.api.netnut.entity.subuser;

import com.kylin.kton.api.netnut.entity.subuser.TrafficUsageData;
import java.util.List;
import lombok.Generated;
import org.springframework.util.CollectionUtils;

public class TrafficUsageResponse {
    private boolean success;
    private List<TrafficUsageData> data;

    public Boolean isEmpty() {
        return CollectionUtils.isEmpty(this.data);
    }

    @Generated
    public TrafficUsageResponse() {
    }

    @Generated
    public boolean isSuccess() {
        return this.success;
    }

    @Generated
    public List<TrafficUsageData> getData() {
        return this.data;
    }

    @Generated
    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Generated
    public void setData(List<TrafficUsageData> data) {
        this.data = data;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TrafficUsageResponse)) {
            return false;
        }
        TrafficUsageResponse other = (TrafficUsageResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.isSuccess() != other.isSuccess()) {
            return false;
        }
        List<TrafficUsageData> this$data = this.getData();
        List<TrafficUsageData> other$data = other.getData();
        return !(this$data == null ? other$data != null : !((Object)this$data).equals(other$data));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof TrafficUsageResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isSuccess() ? 79 : 97);
        List<TrafficUsageData> $data = this.getData();
        result = result * 59 + ($data == null ? 43 : ((Object)$data).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "TrafficUsageResponse(success=" + this.isSuccess() + ", data=" + this.getData() + ")";
    }
}

