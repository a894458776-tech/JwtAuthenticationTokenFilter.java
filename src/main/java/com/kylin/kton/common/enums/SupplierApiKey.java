/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.common.enums;

import lombok.Generated;

public enum SupplierApiKey {
    DATA_IMPULSE("data_impulse", "data impulse"),
    NET_NUT("net_nut", "net nut"),
    OXY_LABS("oxy_labs", "oxy labs");

    private String key;
    private String desc;

    @Generated
    private SupplierApiKey(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    @Generated
    public String getKey() {
        return this.key;
    }

    @Generated
    public String getDesc() {
        return this.desc;
    }
}

