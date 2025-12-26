/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.kylin.kton.common.annotation.Excel
 *  com.kylin.kton.common.core.domain.BaseEntity
 *  org.apache.commons.lang3.builder.ToStringBuilder
 *  org.apache.commons.lang3.builder.ToStringStyle
 */
package com.kylin.kton.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kylin.kton.common.annotation.Excel;
import com.kylin.kton.common.core.domain.BaseEntity;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class KtonVpsHostContainer
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="\u5bbf\u4e3b\u673akton_ip_cluster_host.id")
    private Long hostId;
    @Excel(name="")
    private Long clusterId;
    @Excel(name="\u5bbf\u4e3b\u673a\u9009\u914d\u53c2\u6570ID kton_cluster_host_template.ref_id")
    private String hostTemplateId;
    @Excel(name="\u5546\u6237id\uff0ckton_merchant.id")
    private Long merchantId;
    @Excel(name="\u5bb9\u5668id")
    private String containerId;
    @Excel(name="ssh\u8d26\u53f7")
    private String sshAccount;
    @Excel(name="ssh\u5bc6\u7801")
    private String sshPwd;
    @Excel(name="\u5ba2\u6237\u4f7f\u7528\u7684ssh\u7aef\u53e3")
    private Long sshPort;
    @Excel(name="\u5bb9\u5668ssh\u7aef\u53e3\u6620\u5c04\u672c\u5730 \u7aef\u53e3")
    private Long nodePort;
    @Excel(name="\u72b6\u6001\uff1a0-\u521d\u59cb\u5316\uff0c10-\u521b\u5efa\u4e2d\uff0c20-\u6b63\u5e38\uff0c25-\u5f85\u5f00\u542f\uff0c30-\u5f85\u505c\u670d\uff0c40-\u5df2\u505c\u670d\uff0c50-\u5f85\u5220\u9664\uff0c51-\u5f85\u9000\u8ba2\uff0c 60-\u5df2\u5220\u9664,  70-\u5df2\u5230\u671f")
    private Long status;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Excel(name="\u8fc7\u671f\u65e5\u671f", width=30.0, dateFormat="yyyy-MM-dd HH:mm:ss")
    private Date expireDate;
    @Excel(name="\u7c7b\u578b\uff0c0-\u9759\u6001\uff0c1-\u52a8\u6001")
    private Long type;
    @Excel(name="VPS IP")
    private String vpsIp;
    @Excel(name="\u5bb9\u5668\u540d\u79f0")
    private String containerName;
    @Excel(name="\u5bb9\u5668IP")
    private String containerIp;
    @Excel(name="\u5f02\u5e38\u6d88\u606f")
    private String errorMessage;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public Long getHostId() {
        return this.hostId;
    }

    public void setClusterId(Long clusterId) {
        this.clusterId = clusterId;
    }

    public Long getClusterId() {
        return this.clusterId;
    }

    public void setHostTemplateId(String hostTemplateId) {
        this.hostTemplateId = hostTemplateId;
    }

    public String getHostTemplateId() {
        return this.hostTemplateId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getMerchantId() {
        return this.merchantId;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    public String getContainerId() {
        return this.containerId;
    }

    public void setSshAccount(String sshAccount) {
        this.sshAccount = sshAccount;
    }

    public String getSshAccount() {
        return this.sshAccount;
    }

    public void setSshPwd(String sshPwd) {
        this.sshPwd = sshPwd;
    }

    public String getSshPwd() {
        return this.sshPwd;
    }

    public void setSshPort(Long sshPort) {
        this.sshPort = sshPort;
    }

    public Long getSshPort() {
        return this.sshPort;
    }

    public void setNodePort(Long nodePort) {
        this.nodePort = nodePort;
    }

    public Long getNodePort() {
        return this.nodePort;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return this.status;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Date getExpireDate() {
        return this.expireDate;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getType() {
        return this.type;
    }

    public void setVpsIp(String vpsIp) {
        this.vpsIp = vpsIp;
    }

    public String getVpsIp() {
        return this.vpsIp;
    }

    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    public String getContainerName() {
        return this.containerName;
    }

    public void setContainerIp(String containerIp) {
        this.containerIp = containerIp;
    }

    public String getContainerIp() {
        return this.containerIp;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("hostId", (Object)this.getHostId()).append("clusterId", (Object)this.getClusterId()).append("hostTemplateId", (Object)this.getHostTemplateId()).append("merchantId", (Object)this.getMerchantId()).append("containerId", (Object)this.getContainerId()).append("sshAccount", (Object)this.getSshAccount()).append("sshPwd", (Object)this.getSshPwd()).append("sshPort", (Object)this.getSshPort()).append("nodePort", (Object)this.getNodePort()).append("status", (Object)this.getStatus()).append("expireDate", (Object)this.getExpireDate()).append("type", (Object)this.getType()).append("vpsIp", (Object)this.getVpsIp()).append("containerName", (Object)this.getContainerName()).append("containerIp", (Object)this.getContainerIp()).append("remark", (Object)this.getRemark()).append("errorMessage", (Object)this.getErrorMessage()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

