/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.ipnux.constant;

import lombok.Generated;

public enum ProxyStatus {
    NORMAL(1, "Normal"),
    DISABLED(2, "Disabled"),
    MAINTENANCE(3, "Maintenance");

    private Integer code;
    private String desc;

    @Generated
    public Integer getCode() {
        return this.code;
    }

    @Generated
    public String getDesc() {
        return this.desc;
    }

    @Generated
    private ProxyStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}

