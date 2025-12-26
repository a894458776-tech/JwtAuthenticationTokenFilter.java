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

public class KtonClusterStatisVps
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="\u7edf\u8ba1\uff1a\u4e3b\u673a\u6570\u91cf")
    private Long countHost;
    @Excel(name="\u603b\u8ba1IP")
    private Long countIpTotal;
    @Excel(name="\u5df2\u4f7f\u7528IP")
    private Long countIpUsed;
    @Excel(name="\u7edf\u8ba1\uff1a\u5bb9\u5668\u6570\u91cf")
    private Long countContainer;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setCountHost(Long countHost) {
        this.countHost = countHost;
    }

    public Long getCountHost() {
        return this.countHost;
    }

    public void setCountIpTotal(Long countIpTotal) {
        this.countIpTotal = countIpTotal;
    }

    public Long getCountIpTotal() {
        return this.countIpTotal;
    }

    public void setCountIpUsed(Long countIpUsed) {
        this.countIpUsed = countIpUsed;
    }

    public Long getCountIpUsed() {
        return this.countIpUsed;
    }

    public void setCountContainer(Long countContainer) {
        this.countContainer = countContainer;
    }

    public Long getCountContainer() {
        return this.countContainer;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("countHost", (Object)this.getCountHost()).append("countIpTotal", (Object)this.getCountIpTotal()).append("countIpUsed", (Object)this.getCountIpUsed()).append("countContainer", (Object)this.getCountContainer()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

