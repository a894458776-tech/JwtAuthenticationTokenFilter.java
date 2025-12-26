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

public class KtonIpStaticPoolItem
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="")
    private Long merchantId;
    @Excel(name="IP\u6c60ID")
    private Long poolId;
    @Excel(name="IP")
    private String ip;

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

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public Long getPoolId() {
        return this.poolId;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return this.ip;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("merchantId", (Object)this.getMerchantId()).append("poolId", (Object)this.getPoolId()).append("ip", (Object)this.getIp()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

