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

public class KtonIpStaticPool
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name=" \u7c7b\u578b:1-\u666e\u901a\uff0c2-\u9ad8\u7ea7")
    private Long type;
    @Excel(name="\u6d32(Asia-\u4e9a\u6d32\uff0cNorthAmerica-\u5317\u7f8e\u6d32, Europe-\u6b27\u6d32)")
    private String continent;
    @Excel(name="\u56fd\u5bb6\u7f16\u7801")
    private String countryCode;
    @Excel(name="ip\u5f52\u5c5e\u5730")
    private String location;
    @Excel(name="\u662f\u5426\u70ed\u70b9\uff1aN-\u5426\uff0cY-\u662f")
    private String hot;
    @Excel(name="\u72b6\u6001\uff1a1-\u6b63\u5e38\uff0c0-\u5173\u95ed\uff0c 2-\u5e93\u5b58\u4e0d\u8db3")
    private Long status;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getType() {
        return this.type;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getContinent() {
        return this.continent;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public String getHot() {
        return this.hot;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return this.status;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("type", (Object)this.getType()).append("continent", (Object)this.getContinent()).append("countryCode", (Object)this.getCountryCode()).append("location", (Object)this.getLocation()).append("hot", (Object)this.getHot()).append("status", (Object)this.getStatus()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

