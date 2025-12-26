/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.dataimpulse.constant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lombok.Generated;

public enum PoolType {
    RESIDENTAL("residental"),
    MOBILE("mobile"),
    DATACENTER("datacenter");

    private String code;
    private static Map<String, PoolType> cache;

    public static PoolType of(String code) {
        return cache.get(code);
    }

    @Generated
    public String getCode() {
        return this.code;
    }

    @Generated
    private PoolType(String code) {
        this.code = code;
    }

    static {
        cache = new HashMap<String, PoolType>();
        Arrays.stream(PoolType.values()).forEach(item -> cache.put(item.getCode(), (PoolType)((Object)item)));
    }
}

