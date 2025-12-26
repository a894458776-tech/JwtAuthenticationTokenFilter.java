/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.dataimpulse.constant;

import lombok.Generated;

public enum Protocols {
    HTTP("http"),
    SOCKS5("socks5");

    private String code;

    @Generated
    public String getCode() {
        return this.code;
    }

    @Generated
    private Protocols(String code) {
        this.code = code;
    }
}

