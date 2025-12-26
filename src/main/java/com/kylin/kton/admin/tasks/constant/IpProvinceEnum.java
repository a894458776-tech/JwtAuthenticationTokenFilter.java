/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.tasks.constant;

import java.util.Arrays;
import lombok.Generated;

public enum IpProvinceEnum {
    Bangkok("Bangkok", "\u66fc\u8c37"),
    Ho_Chi_Minh("Ho Chi Minh", "\u80e1\u5fd7\u660e\u5e02"),
    Taiwan("Taiwan", "\u53f0\u6e7e"),
    Djakarta("Djakarta", "\u96c5\u52a0\u8fbe"),
    Metro_Manila("Metro Manila", "\u9a6c\u5c3c\u62c9\u5927\u90fd\u4f1a"),
    Kuala_Lumpur("Kuala Lumpur", "\u5409\u9686\u5761"),
    New_York("New York", "\u7ebd\u7ea6\u5dde"),
    Harju_County("Harju County", "\u54c8\u5c14\u5c24\u53bf"),
    Stavro_Polkray("Stavro Polkray", "\u65af\u5854\u592b\u7f57\u6ce2\u5c14\u514b\u96f7"),
    St_Paul("St.Paul", "\u5723\u4fdd\u7f57"),
    Germany("Germany", "\u5fb7\u56fd"),
    Chiba("Chiba", "\u5343\u53f6"),
    England("England", "\u82f1\u683c\u5170"),
    Singapore("Singapore", "\u65b0\u52a0\u5761"),
    Sejong_siok("Sejong-si", "\u4e16\u5b97\u5dde\u5e02"),
    Mexico_City("Mexico City", "\u58a8\u897f\u54e5\u57ce"),
    \u00cele_de_France("\u00cele-de-France", "\u6cd5\u5170\u897f\u5c9b\u5927\u533a"),
    Dubai("Dubai", "\u8fea\u62dc"),
    Lazio("Lazio", "\u62c9\u9f50\u5965\u5927\u533a");

    private final String code;
    private final String name;

    public static String getCodeByName(String name) {
        return Arrays.stream(IpProvinceEnum.values()).filter(status -> status.getName().equals(name)).findFirst().map(IpProvinceEnum::getCode).orElse(name);
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
    private IpProvinceEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}

