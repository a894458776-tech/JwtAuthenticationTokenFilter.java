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

public class KtonSource
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="\u4f9b\u5e94\u5546code")
    private String sourceCode;
    @Excel(name="\u4f9b\u5e94\u5546\u540d")
    private String sourceName;
    @Excel(name="\u7528\u6237\u540d")
    private String sourceUsername;
    @Excel(name="\u5bc6\u7801")
    private String sourcePassword;
    @Excel(name="\u516c\u53f8\u540d\u79f0")
    private String companyName;
    @Excel(name="\u5730\u5740")
    private String address;
    @Excel(name="\u57ce\u5e02")
    private String city;
    @Excel(name="\u56fd\u5bb6")
    private String country;
    @Excel(name="\u90ae\u7f16")
    private String zipCode;
    @Excel(name="\u90ae\u7bb1")
    private String email;
    @Excel(name="\u662f\u5426\u652f\u6301\u9759\u6001\uff1a0\uff1a\u4e0d\u652f\u6301\uff0c1\uff1a\u652f\u6301")
    private Long isStatic;
    @Excel(name="\u662f\u5426\u652f\u6301\u52a8\u6001\uff1a0\uff1a\u4e0d\u652f\u6301\uff0c1\uff1a\u652f\u6301")
    private Long isDynamics;
    @Excel(name="\u662f\u5426\u652f\u6301IDC\uff1a0\uff1a\u4e0d\u652f\u6301\uff0c1\uff1a\u652f\u6301")
    private Long isIdc;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getSourceCode() {
        return this.sourceCode;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setSourceUsername(String sourceUsername) {
        this.sourceUsername = sourceUsername;
    }

    public String getSourceUsername() {
        return this.sourceUsername;
    }

    public void setSourcePassword(String sourcePassword) {
        this.sourcePassword = sourcePassword;
    }

    public String getSourcePassword() {
        return this.sourcePassword;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setIsStatic(Long isStatic) {
        this.isStatic = isStatic;
    }

    public Long getIsStatic() {
        return this.isStatic;
    }

    public void setIsDynamics(Long isDynamics) {
        this.isDynamics = isDynamics;
    }

    public Long getIsDynamics() {
        return this.isDynamics;
    }

    public void setIsIdc(Long isIdc) {
        this.isIdc = isIdc;
    }

    public Long getIsIdc() {
        return this.isIdc;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("sourceCode", (Object)this.getSourceCode()).append("sourceName", (Object)this.getSourceName()).append("sourceUsername", (Object)this.getSourceUsername()).append("sourcePassword", (Object)this.getSourcePassword()).append("companyName", (Object)this.getCompanyName()).append("address", (Object)this.getAddress()).append("city", (Object)this.getCity()).append("country", (Object)this.getCountry()).append("zipCode", (Object)this.getZipCode()).append("email", (Object)this.getEmail()).append("isStatic", (Object)this.getIsStatic()).append("isDynamics", (Object)this.getIsDynamics()).append("isIdc", (Object)this.getIsIdc()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

