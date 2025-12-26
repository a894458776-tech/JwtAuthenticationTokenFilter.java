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

public class AsnsResponse
implements Serializable {
    private List<Item> asns;

    @Generated
    public static AsnsResponseBuilder builder() {
        return new AsnsResponseBuilder();
    }

    @Generated
    public List<Item> getAsns() {
        return this.asns;
    }

    @Generated
    public void setAsns(List<Item> asns) {
        this.asns = asns;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AsnsResponse)) {
            return false;
        }
        AsnsResponse other = (AsnsResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        List<Item> this$asns = this.getAsns();
        List<Item> other$asns = other.getAsns();
        return !(this$asns == null ? other$asns != null : !((Object)this$asns).equals(other$asns));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AsnsResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        List<Item> $asns = this.getAsns();
        result = result * 59 + ($asns == null ? 43 : ((Object)$asns).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AsnsResponse(asns=" + this.getAsns() + ")";
    }

    @Generated
    public AsnsResponse(List<Item> asns) {
        this.asns = asns;
    }

    @Generated
    public AsnsResponse() {
    }

    @Generated
    public static class AsnsResponseBuilder {
        @Generated
        private List<Item> asns;

        @Generated
        AsnsResponseBuilder() {
        }

        @Generated
        public AsnsResponseBuilder asns(List<Item> asns) {
            this.asns = asns;
            return this;
        }

        @Generated
        public AsnsResponse build() {
            return new AsnsResponse(this.asns);
        }

        @Generated
        public String toString() {
            return "AsnsResponse.AsnsResponseBuilder(asns=" + this.asns + ")";
        }
    }
}

