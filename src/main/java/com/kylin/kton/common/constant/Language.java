/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.common.constant;

import com.kylin.kton.common.utils.StringUtils;
import lombok.Generated;

public enum Language {
    EN_US("en_us"),
    ZH_CN("zh_cn");

    private String language;

    public static Language of(String language) {
        if (StringUtils.equalsIgnoreCase((CharSequence)language, (CharSequence)"zh_CN")) {
            return ZH_CN;
        }
        if (StringUtils.isNotBlank((CharSequence)language) && (language.toLowerCase().indexOf("zh") > 0 || language.toLowerCase().startsWith("zh"))) {
            return ZH_CN;
        }
        return EN_US;
    }

    @Generated
    public String getLanguage() {
        return this.language;
    }

    @Generated
    private Language(String language) {
        this.language = language;
    }
}

