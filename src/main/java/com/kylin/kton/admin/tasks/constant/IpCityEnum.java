/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.tasks.constant;

import java.util.Arrays;
import lombok.Generated;

public enum IpCityEnum {
    Bangkok("Bangkok", "\u66fc\u8c37"),
    Ho_Chi_Minh("Ho Chi Minh", "\u80e1\u5fd7\u660e\u5e02"),
    Taipei("Taipei", "\u4e2d\u56fd  \u53f0\u5317\u5e02"),
    Djakarta("Djakarta", "\u96c5\u52a0\u8fbe"),
    Manila("Manila", "\u9a6c\u5c3c\u62c9"),
    Kuala_Lumpur("Kuala Lumpur", "\u5409\u9686\u5761"),
    New_York("New York", "\u7ebd\u7ea6"),
    TLL("TLL (Tallinn)", "\u5854\u6797"),
    Stavro_Polkray("Stavro Polkray", "\u65af\u5854\u592b\u7f57\u6ce2\u5c14\u514b\u96f7"),
    St_Paul("St.Paul", "\u5723\u4fdd\u7f57"),
    Germany("Germany", "\u5fb7\u56fd"),
    Funabashi("Funabashi", "\u8239\u6a4b\u5e02"),
    London("London", "\u4f26\u6566"),
    Singapore("Singapore", "\u65b0\u52a0\u5761"),
    Sejong("Sejong", "\u4e16\u5b97"),
    Mexico_City("Mexico City", "\u58a8\u897f\u54e5\u57ce"),
    Paris("Paris", "\u5df4\u9ece"),
    Dubai("Dubai", "\u8fea\u62dc"),
    Rome("Rome", "\u7f57\u9a6c\u5e02");

    private final String code;
    private final String name;

    public static String getCodeByName(String name) {
        return Arrays.stream(IpCityEnum.values()).filter(status -> status.getName().equals(name)).findFirst().map(IpCityEnum::getCode).orElse(name);
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
    private IpCityEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}

