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

public class KtonCluster
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="\u96c6\u7fa4\u540d")
    private String clusterName;
    @Excel(name="\u96c6\u7fa4\u7c7b\u578b\uff1aVPS")
    private String clusterType;
    @Excel(name="\u6d32(Asia-\u4e9a\u6d32\uff0cNorthAmerica-\u5317\u7f8e\u6d32, Europe-\u6b27\u6d32)")
    private String continent;
    @Excel(name="\u56fd\u5bb6\u7f16\u7801")
    private String countryCode;
    @Excel(name="\u57ce\u5e02")
    private String city;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getClusterName() {
        return this.clusterName;
    }

    public void setClusterType(String clusterType) {
        this.clusterType = clusterType;
    }

    public String getClusterType() {
        return this.clusterType;
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

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("clusterName", (Object)this.getClusterName()).append("clusterType", (Object)this.getClusterType()).append("continent", (Object)this.getContinent()).append("countryCode", (Object)this.getCountryCode()).append("city", (Object)this.getCity()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

