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

public class StatesResponse
implements Serializable {
    private List<Item> states;

    @Generated
    public static StatesResponseBuilder builder() {
        return new StatesResponseBuilder();
    }

    @Generated
    public List<Item> getStates() {
        return this.states;
    }

    @Generated
    public void setStates(List<Item> states) {
        this.states = states;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof StatesResponse)) {
            return false;
        }
        StatesResponse other = (StatesResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        List<Item> this$states = this.getStates();
        List<Item> other$states = other.getStates();
        return !(this$states == null ? other$states != null : !((Object)this$states).equals(other$states));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof StatesResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        List<Item> $states = this.getStates();
        result = result * 59 + ($states == null ? 43 : ((Object)$states).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "StatesResponse(states=" + this.getStates() + ")";
    }

    @Generated
    public StatesResponse(List<Item> states) {
        this.states = states;
    }

    @Generated
    public StatesResponse() {
    }

    @Generated
    public static class StatesResponseBuilder {
        @Generated
        private List<Item> states;

        @Generated
        StatesResponseBuilder() {
        }

        @Generated
        public StatesResponseBuilder states(List<Item> states) {
            this.states = states;
            return this;
        }

        @Generated
        public StatesResponse build() {
            return new StatesResponse(this.states);
        }

        @Generated
        public String toString() {
            return "StatesResponse.StatesResponseBuilder(states=" + this.states + ")";
        }
    }
}

