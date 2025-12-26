/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import com.kylin.kton.api.netnut.entity.subuser.MyPackageUsageData;
import java.util.List;
import lombok.Generated;

public class MyPackageUsageResponse {
    private boolean success;
    private List<MyPackageUsageData> data;

    @Generated
    public MyPackageUsageResponse() {
    }

    @Generated
    public boolean isSuccess() {
        return this.success;
    }

    @Generated
    public List<MyPackageUsageData> getData() {
        return this.data;
    }

    @Generated
    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Generated
    public void setData(List<MyPackageUsageData> data) {
        this.data = data;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MyPackageUsageResponse)) {
            return false;
        }
        MyPackageUsageResponse other = (MyPackageUsageResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.isSuccess() != other.isSuccess()) {
            return false;
        }
        List<MyPackageUsageData> this$data = this.getData();
        List<MyPackageUsageData> other$data = other.getData();
        return !(this$data == null ? other$data != null : !((Object)this$data).equals(other$data));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof MyPackageUsageResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isSuccess() ? 79 : 97);
        List<MyPackageUsageData> $data = this.getData();
        result = result * 59 + ($data == null ? 43 : ((Object)$data).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "MyPackageUsageResponse(success=" + this.isSuccess() + ", data=" + this.getData() + ")";
    }
}

