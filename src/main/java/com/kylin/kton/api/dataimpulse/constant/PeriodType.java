/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.api.dataimpulse.constant;

import lombok.Generated;

public enum PeriodType {
    DAY("day"),
    WEEK("week"),
    MONTH("month"),
    MONTHS3("3months"),
    MONTHS6("3months");

    private String code;

    @Generated
    private PeriodType(String code) {
        this.code = code;
    }

    @Generated
    public String getCode() {
        return this.code;
    }
}

