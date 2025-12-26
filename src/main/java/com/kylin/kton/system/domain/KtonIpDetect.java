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
import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class KtonIpDetect
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private String id;
    @Excel(name="ip")
    private String ip;
    @Excel(name="\u6570\u636e\u6e90  IPKS  ping0  ipinfo ")
    private String datasource;
    @Excel(name="\u5dde")
    private String continent;
    @Excel(name="\u5b50\u533a\u57df")
    private String subContinent;
    @Excel(name="\u56fd\u5bb6\u7f16\u7801")
    private String countryCode;
    @Excel(name="\u7701/\u5dde \u7f16\u7801")
    private String province;
    @Excel(name="\u57ce\u5e02 \u7f16\u7801")
    private String city;
    @Excel(name="ASN\u7f16\u53f7")
    private String asn;
    @Excel(name="ASN\u6240\u6709\u8005")
    private String asnBelong;
    @Excel(name="ASN\u6240\u6709\u8005\u5b98\u7f51")
    private String asnBelongUrl;
    @Excel(name="ASN\u662f\u5426\u662fISP")
    private Integer asnIsIsp;
    @Excel(name="\u6240\u5c5e\u516c\u53f8")
    private String company;
    @Excel(name="\u6240\u5c5e\u516c\u53f8\u5b98\u7f51")
    private String companyUrl;
    @Excel(name="\u6240\u5c5e\u516c\u53f8\u662f\u5426\u662fISP")
    private Integer companyIsIsp;
    @Excel(name="\u7ef4\u5ea6")
    private BigDecimal latitude;
    @Excel(name="\u7ecf\u5ea6")
    private BigDecimal longitude;
    @Excel(name="IP\u7c7b\u578b  HOST:\u5bb6\u5ead\u5bbd\u5e26  IDC\uff1aIDC\u673a\u623f")
    private String ipType;
    @Excel(name="\u98ce\u63a7\u503c \u5355\u4f4d%")
    private Long riskValue;
    @Excel(name="\u662f\u5426\u539f\u751f")
    private Integer isNative;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return this.ip;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }

    public String getDatasource() {
        return this.datasource;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getContinent() {
        return this.continent;
    }

    public void setSubContinent(String subContinent) {
        this.subContinent = subContinent;
    }

    public String getSubContinent() {
        return this.subContinent;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() {
        return this.province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setAsn(String asn) {
        this.asn = asn;
    }

    public String getAsn() {
        return this.asn;
    }

    public void setAsnBelong(String asnBelong) {
        this.asnBelong = asnBelong;
    }

    public String getAsnBelong() {
        return this.asnBelong;
    }

    public void setAsnBelongUrl(String asnBelongUrl) {
        this.asnBelongUrl = asnBelongUrl;
    }

    public String getAsnBelongUrl() {
        return this.asnBelongUrl;
    }

    public void setAsnIsIsp(Integer asnIsIsp) {
        this.asnIsIsp = asnIsIsp;
    }

    public Integer getAsnIsIsp() {
        return this.asnIsIsp;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }

    public String getCompanyUrl() {
        return this.companyUrl;
    }

    public void setCompanyIsIsp(Integer companyIsIsp) {
        this.companyIsIsp = companyIsIsp;
    }

    public Integer getCompanyIsIsp() {
        return this.companyIsIsp;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLatitude() {
        return this.latitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLongitude() {
        return this.longitude;
    }

    public void setIpType(String ipType) {
        this.ipType = ipType;
    }

    public String getIpType() {
        return this.ipType;
    }

    public void setRiskValue(Long riskValue) {
        this.riskValue = riskValue;
    }

    public Long getRiskValue() {
        return this.riskValue;
    }

    public void setIsNative(Integer isNative) {
        this.isNative = isNative;
    }

    public Integer getIsNative() {
        return this.isNative;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("ip", (Object)this.getIp()).append("datasource", (Object)this.getDatasource()).append("continent", (Object)this.getContinent()).append("subContinent", (Object)this.getSubContinent()).append("countryCode", (Object)this.getCountryCode()).append("province", (Object)this.getProvince()).append("city", (Object)this.getCity()).append("asn", (Object)this.getAsn()).append("asnBelong", (Object)this.getAsnBelong()).append("asnBelongUrl", (Object)this.getAsnBelongUrl()).append("asnIsIsp", (Object)this.getAsnIsIsp()).append("company", (Object)this.getCompany()).append("companyUrl", (Object)this.getCompanyUrl()).append("companyIsIsp", (Object)this.getCompanyIsIsp()).append("latitude", (Object)this.getLatitude()).append("longitude", (Object)this.getLongitude()).append("ipType", (Object)this.getIpType()).append("riskValue", (Object)this.getRiskValue()).append("isNative", (Object)this.getIsNative()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

