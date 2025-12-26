/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.tasks.constant;

import java.util.Arrays;
import lombok.Generated;

public enum IpCountryEnum {
    TH("TH", "\u6cf0\u56fd"),
    VN("VN", "\u8d8a\u5357"),
    CN("CN", "\u4e2d\u56fd"),
    ID("ID", "\u5370\u5ea6\u5c3c\u897f\u4e9a"),
    PH("PH", "\u83f2\u5f8b\u5bbe"),
    MY("MY", "\u9a6c\u6765\u897f\u4e9a"),
    US("US", "\u7f8e\u56fd"),
    EE("EE", "\u7231\u6c99\u5c3c\u4e9a"),
    RU("RU", "\u4fc4\u7f57\u65af"),
    BR("BR", "\u5df4\u897f"),
    DE("DE", "\u5fb7\u56fd"),
    JP("JP", "\u65e5\u672c"),
    GB("GB", "\u82f1\u56fd"),
    SG("SG", "\u65b0\u52a0\u5761"),
    KR("KR", "\u97e9\u56fd"),
    MX("MX", "\u58a8\u897f\u54e5"),
    FR("FR", "\u6cd5\u56fd"),
    AE("AE", "\u963f\u8054\u914b"),
    IT("IT", "\u610f\u5927\u5229");

    private final String code;
    private final String name;

    public static String getCodeByName(String name) {
        return Arrays.stream(IpCountryEnum.values()).filter(status -> status.getName().equals(name)).findFirst().map(IpCountryEnum::getCode).orElse(name);
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
    private IpCountryEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}

