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

public class KtonVpsHost
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="\u4e3b\u673a\u540d")
    private String hostName;
    @Excel(name="\u4e3b\u673aIP")
    private String hostIp;
    @Excel(name="\u6240\u5c5e\u96c6\u7fa4")
    private Long clusterId;
    @Excel(name="\u4f9b\u5e94\u5546ID\uff0ckton_supplier.id")
    private Long sourceId;
    @Excel(name="\u6d32(Asia-\u4e9a\u6d32\uff0cNorthAmerica-\u5317\u7f8e\u6d32, Europe-\u6b27\u6d32)")
    private String continent;
    @Excel(name="\u56fd\u5bb6\u7f16\u7801")
    private String countryCode;
    @Excel(name="\u57ce\u5e02")
    private String city;
    @Excel(name="\u7528\u6237\u540d")
    private String sshUsername;
    @Excel(name="\u5bc6\u7801")
    private String sshPassword;
    @Excel(name="\u7aef\u53e3")
    private Long sshPort;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostName() {
        return this.hostName;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public String getHostIp() {
        return this.hostIp;
    }

    public void setClusterId(Long clusterId) {
        this.clusterId = clusterId;
    }

    public Long getClusterId() {
        return this.clusterId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getSourceId() {
        return this.sourceId;
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

    public void setSshUsername(String sshUsername) {
        this.sshUsername = sshUsername;
    }

    public String getSshUsername() {
        return this.sshUsername;
    }

    public void setSshPassword(String sshPassword) {
        this.sshPassword = sshPassword;
    }

    public String getSshPassword() {
        return this.sshPassword;
    }

    public void setSshPort(Long sshPort) {
        this.sshPort = sshPort;
    }

    public Long getSshPort() {
        return this.sshPort;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("hostName", (Object)this.getHostName()).append("hostIp", (Object)this.getHostIp()).append("clusterId", (Object)this.getClusterId()).append("sourceId", (Object)this.getSourceId()).append("continent", (Object)this.getContinent()).append("countryCode", (Object)this.getCountryCode()).append("city", (Object)this.getCity()).append("sshUsername", (Object)this.getSshUsername()).append("sshPassword", (Object)this.getSshPassword()).append("sshPort", (Object)this.getSshPort()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

