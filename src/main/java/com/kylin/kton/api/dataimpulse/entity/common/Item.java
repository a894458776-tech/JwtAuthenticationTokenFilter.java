/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.dataimpulse.entity.common;

import java.io.Serializable;
import lombok.Generated;

public class Item
implements Serializable {
    private String code;
    private String name;
    private Integer count;

    @Generated
    public Item() {
    }

    @Generated
    public String getCode() {
        return this.code;
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public Integer getCount() {
        return this.count;
    }

    @Generated
    public void setCode(String code) {
        this.code = code;
    }

    @Generated
    public void setName(String name) {
        this.name = name;
    }

    @Generated
    public void setCount(Integer count) {
        this.count = count;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Item)) {
            return false;
        }
        Item other = (Item)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Integer this$count = this.getCount();
        Integer other$count = other.getCount();
        if (this$count == null ? other$count != null : !((Object)this$count).equals(other$count)) {
            return false;
        }
        String this$code = this.getCode();
        String other$code = other.getCode();
        if (this$code == null ? other$code != null : !this$code.equals(other$code)) {
            return false;
        }
        String this$name = this.getName();
        String other$name = other.getName();
        return !(this$name == null ? other$name != null : !this$name.equals(other$name));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof Item;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $count = this.getCount();
        result = result * 59 + ($count == null ? 43 : ((Object)$count).hashCode());
        String $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        String $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "Item(code=" + this.getCode() + ", name=" + this.getName() + ", count=" + this.getCount() + ")";
    }
}

