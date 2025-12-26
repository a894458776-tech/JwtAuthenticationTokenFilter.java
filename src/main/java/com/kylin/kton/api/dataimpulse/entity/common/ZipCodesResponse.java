/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.dataimpulse.entity.common;

import com.kylin.kton.api.dataimpulse.entity.common.Item;
import java.io.Serializable;
import java.util.List;
import lombok.Generated;

public class ZipCodesResponse
implements Serializable {
    private List<Item> zipCodes;

    @Generated
    public static ZipCodesResponseBuilder builder() {
        return new ZipCodesResponseBuilder();
    }

    @Generated
    public List<Item> getZipCodes() {
        return this.zipCodes;
    }

    @Generated
    public void setZipCodes(List<Item> zipCodes) {
        this.zipCodes = zipCodes;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ZipCodesResponse)) {
            return false;
        }
        ZipCodesResponse other = (ZipCodesResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        List<Item> this$zipCodes = this.getZipCodes();
        List<Item> other$zipCodes = other.getZipCodes();
        return !(this$zipCodes == null ? other$zipCodes != null : !((Object)this$zipCodes).equals(other$zipCodes));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ZipCodesResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        List<Item> $zipCodes = this.getZipCodes();
        result = result * 59 + ($zipCodes == null ? 43 : ((Object)$zipCodes).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ZipCodesResponse(zipCodes=" + this.getZipCodes() + ")";
    }

    @Generated
    public ZipCodesResponse(List<Item> zipCodes) {
        this.zipCodes = zipCodes;
    }

    @Generated
    public ZipCodesResponse() {
    }

    @Generated
    public static class ZipCodesResponseBuilder {
        @Generated
        private List<Item> zipCodes;

        @Generated
        ZipCodesResponseBuilder() {
        }

        @Generated
        public ZipCodesResponseBuilder zipCodes(List<Item> zipCodes) {
            this.zipCodes = zipCodes;
            return this;
        }

        @Generated
        public ZipCodesResponse build() {
            return new ZipCodesResponse(this.zipCodes);
        }

        @Generated
        public String toString() {
            return "ZipCodesResponse.ZipCodesResponseBuilder(zipCodes=" + this.zipCodes + ")";
        }
    }
}

