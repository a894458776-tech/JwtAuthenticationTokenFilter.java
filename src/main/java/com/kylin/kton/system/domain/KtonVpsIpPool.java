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

public class KtonVpsIpPool
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="\u96c6\u7fa4ID")
    private Long clusterId;
    @Excel(name="kton_vps_host.id")
    private Long hostId;
    @Excel(name="\u5546\u6237ID")
    private Long merchantId;
    @Excel(name="ip")
    private String ip;
    @Excel(name="\u5bb9\u5668ip")
    private String containerIp;
    @Excel(name="IP\u7c7b\u578b\uff1adedicated: \u72ec\u5360\uff0c shared:\u5171\u4eab")
    private String ipType;
    @Excel(name="\u5206\u914d\u6b21\u6570\uff1a\u4e3b\u8981\u662f\u5171\u4eab\u7684IP\uff0c\u9700\u8981\u5747\u8861\u5206\u914d\uff0c\u6240\u4ee5\u8fd9\u91cc\u8fdb\u884c\u5df2\u5206\u914d\u7684\u8ba1\u6570")
    private Long countAssign;
    @Excel(name="0-\u672a\u4f7f\u7528\uff0c1-\u5df2\u4f7f\u7528")
    private Long status;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setClusterId(Long clusterId) {
        this.clusterId = clusterId;
    }

    public Long getClusterId() {
        return this.clusterId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public Long getHostId() {
        return this.hostId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getMerchantId() {
        return this.merchantId;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return this.ip;
    }

    public void setContainerIp(String containerIp) {
        this.containerIp = containerIp;
    }

    public String getContainerIp() {
        return this.containerIp;
    }

    public void setIpType(String ipType) {
        this.ipType = ipType;
    }

    public String getIpType() {
        return this.ipType;
    }

    public void setCountAssign(Long countAssign) {
        this.countAssign = countAssign;
    }

    public Long getCountAssign() {
        return this.countAssign;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return this.status;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("clusterId", (Object)this.getClusterId()).append("hostId", (Object)this.getHostId()).append("merchantId", (Object)this.getMerchantId()).append("ip", (Object)this.getIp()).append("containerIp", (Object)this.getContainerIp()).append("ipType", (Object)this.getIpType()).append("countAssign", (Object)this.getCountAssign()).append("status", (Object)this.getStatus()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

