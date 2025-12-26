/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.springframework.util.CollectionUtils
 */
package com.kylin.kton.api.netnut.entity.subuser;

import com.kylin.kton.api.netnut.entity.subuser.CustomerPlansData;
import java.io.Serializable;
import java.util.List;
import lombok.Generated;
import org.springframework.util.CollectionUtils;

public class CustomerPlansResponse
implements Serializable {
    private boolean success;
    private List<CustomerPlansData> data;

    public Boolean isEmpty() {
        return CollectionUtils.isEmpty(this.data);
    }

    @Generated
    public static CustomerPlansResponseBuilder builder() {
        return new CustomerPlansResponseBuilder();
    }

    @Generated
    public boolean isSuccess() {
        return this.success;
    }

    @Generated
    public List<CustomerPlansData> getData() {
        return this.data;
    }

    @Generated
    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Generated
    public void setData(List<CustomerPlansData> data) {
        this.data = data;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CustomerPlansResponse)) {
            return false;
        }
        CustomerPlansResponse other = (CustomerPlansResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.isSuccess() != other.isSuccess()) {
            return false;
        }
        List<CustomerPlansData> this$data = this.getData();
        List<CustomerPlansData> other$data = other.getData();
        return !(this$data == null ? other$data != null : !((Object)this$data).equals(other$data));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof CustomerPlansResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isSuccess() ? 79 : 97);
        List<CustomerPlansData> $data = this.getData();
        result = result * 59 + ($data == null ? 43 : ((Object)$data).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "CustomerPlansResponse(success=" + this.isSuccess() + ", data=" + this.getData() + ")";
    }

    @Generated
    public CustomerPlansResponse(boolean success, List<CustomerPlansData> data) {
        this.success = success;
        this.data = data;
    }

    @Generated
    public CustomerPlansResponse() {
    }

    @Generated
    public static class CustomerPlansResponseBuilder {
        @Generated
        private boolean success;
        @Generated
        private List<CustomerPlansData> data;

        @Generated
        CustomerPlansResponseBuilder() {
        }

        @Generated
        public CustomerPlansResponseBuilder success(boolean success) {
            this.success = success;
            return this;
        }

        @Generated
        public CustomerPlansResponseBuilder data(List<CustomerPlansData> data) {
            this.data = data;
            return this;
        }

        @Generated
        public CustomerPlansResponse build() {
            return new CustomerPlansResponse(this.success, this.data);
        }

        @Generated
        public String toString() {
            return "CustomerPlansResponse.CustomerPlansResponseBuilder(success=" + this.success + ", data=" + this.data + ")";
        }
    }
}

