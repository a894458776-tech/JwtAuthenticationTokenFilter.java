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

public class KtonIpStaticAuthorization
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="\u7528\u6237ID")
    private Long merchantId;
    @Excel(name="\u8d26\u5bc6\u8ba4\u8bc1")
    private Long userAuthorization;
    @Excel(name="\u767d\u540d\u5355\u8ba4\u8bc1")
    private Long ipAuthorization;
    @Excel(name="\u4ee3\u7406\u7528\u6237\u540d")
    private String authUsername;
    @Excel(name="\u4ee3\u7406\u5bc6\u7801")
    private String authPassword;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getMerchantId() {
        return this.merchantId;
    }

    public void setUserAuthorization(Long userAuthorization) {
        this.userAuthorization = userAuthorization;
    }

    public Long getUserAuthorization() {
        return this.userAuthorization;
    }

    public void setIpAuthorization(Long ipAuthorization) {
        this.ipAuthorization = ipAuthorization;
    }

    public Long getIpAuthorization() {
        return this.ipAuthorization;
    }

    public void setAuthUsername(String authUsername) {
        this.authUsername = authUsername;
    }

    public String getAuthUsername() {
        return this.authUsername;
    }

    public void setAuthPassword(String authPassword) {
        this.authPassword = authPassword;
    }

    public String getAuthPassword() {
        return this.authPassword;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("merchantId", (Object)this.getMerchantId()).append("userAuthorization", (Object)this.getUserAuthorization()).append("ipAuthorization", (Object)this.getIpAuthorization()).append("authUsername", (Object)this.getAuthUsername()).append("authPassword", (Object)this.getAuthPassword()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

