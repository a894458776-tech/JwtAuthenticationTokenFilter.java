/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.account.constant;

import lombok.Generated;

public enum ChannelCode {
    DATAIMPULSE("dataimpulse", "dataimpulse"),
    NNETNUT("netnut", "netnut"),
    OXYLABS("oxylabs", "oxylabs"),
    IPNUX("ipnux", "ipnux");

    private String code;
    private String desc;

    @Generated
    public String getCode() {
        return this.code;
    }

    @Generated
    public String getDesc() {
        return this.desc;
    }

    @Generated
    private ChannelCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}

