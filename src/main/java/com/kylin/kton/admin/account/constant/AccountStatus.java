/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.account.constant;

import lombok.Generated;

public enum AccountStatus {
    PENDING("pedding", "\u5f85\u4e0b\u53d1"),
    ACTIVE("active", "\u5df2\u4e0b\u53d1");

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
    private AccountStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}

