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

public class KtonVpsImages
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="\u5bf9\u5916ID")
    private String refId;
    @Excel(name="\u955c\u50cf\u7c7b\u578b")
    private String imageType;
    @Excel(name="\u5546\u6237id\uff0c0-\u8868\u793a\u7cfb\u7edf\u955c\u50cf")
    private Long merchantId;
    @Excel(name="\u955c\u50cf\u540d\u79f0")
    private String name;
    @Excel(name="\u955c\u50cf\u63cf\u8ff0")
    private String description;
    @Excel(name="\u955c\u50cf\u5730\u5740")
    private String imageUrl;
    @Excel(name="\u7248\u672c\u53f7")
    private String imageVersion;
    @Excel(name="\u72b6\u6001 0-\u65e0\u6548\uff0c1-\u6709\u6548")
    private Long status;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getRefId() {
        return this.refId;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getImageType() {
        return this.imageType;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getMerchantId() {
        return this.merchantId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageVersion(String imageVersion) {
        this.imageVersion = imageVersion;
    }

    public String getImageVersion() {
        return this.imageVersion;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return this.status;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("refId", (Object)this.getRefId()).append("imageType", (Object)this.getImageType()).append("merchantId", (Object)this.getMerchantId()).append("name", (Object)this.getName()).append("description", (Object)this.getDescription()).append("imageUrl", (Object)this.getImageUrl()).append("imageVersion", (Object)this.getImageVersion()).append("status", (Object)this.getStatus()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

