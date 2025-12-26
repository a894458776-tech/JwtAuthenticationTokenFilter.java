/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.annotation.Excel
 *  com.kylin.kton.common.core.domain.BaseEntity
 *  org.apache.commons.lang3.builder.ToStringBuilder
 *  org.apache.commons.lang3.builder.ToStringStyle
 */
package com.kylin.kton.system.domain;

import com.kylin.kton.common.annotation.Excel;
import com.kylin.kton.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class KtonApiConfig
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long userId;
    @Excel(name="\u4f7f\u7528\u77ed\u540d\u7b97\u6cd5\u751f\u6210\u4e00\u4e2a")
    private String merchantCode;
    @Excel(name="\u53ef\u4ee5\u7528uuid\u7684md5")
    private String merchantToken;

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getMerchantCode() {
        return this.merchantCode;
    }

    public void setMerchantToken(String merchantToken) {
        this.merchantToken = merchantToken;
    }

    public String getMerchantToken() {
        return this.merchantToken;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("userId", (Object)this.getUserId()).append("merchantCode", (Object)this.getMerchantCode()).append("merchantToken", (Object)this.getMerchantToken()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

