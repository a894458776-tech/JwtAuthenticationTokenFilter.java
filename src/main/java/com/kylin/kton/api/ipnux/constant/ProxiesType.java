/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.ipnux.constant;

import lombok.Generated;

public enum ProxiesType {
    SHARED_PROXIES("Shared (ISP) proxies", 2, 1),
    PREMIUM_PROXIES("Premium (ISP) proxies", 2, 2);

    private String code;
    private Integer format;
    private Integer poolType;

    @Generated
    public String getCode() {
        return this.code;
    }

    @Generated
    public Integer getFormat() {
        return this.format;
    }

    @Generated
    public Integer getPoolType() {
        return this.poolType;
    }

    @Generated
    private ProxiesType(String code, Integer format, Integer poolType) {
        this.code = code;
        this.format = format;
        this.poolType = poolType;
    }
}

