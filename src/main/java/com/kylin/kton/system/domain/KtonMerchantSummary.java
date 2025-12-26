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

public class KtonMerchantSummary
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="\u9759\u6001IP\u6570\u91cf")
    private Long staticIpCount;
    @Excel(name="\u52a8\u6001IP\u8ba1\u5212")
    private Long dynamicsPlan;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Excel(name="\u52a8\u6001IP\u8ba1\u5212\uff1a\u7ed3\u675f\u65f6\u95f4", width=30.0, dateFormat="yyyy-MM-dd")
    private Date dynamicsPlanEndDate;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setStaticIpCount(Long staticIpCount) {
        this.staticIpCount = staticIpCount;
    }

    public Long getStaticIpCount() {
        return this.staticIpCount;
    }

    public void setDynamicsPlan(Long dynamicsPlan) {
        this.dynamicsPlan = dynamicsPlan;
    }

    public Long getDynamicsPlan() {
        return this.dynamicsPlan;
    }

    public void setDynamicsPlanEndDate(Date dynamicsPlanEndDate) {
        this.dynamicsPlanEndDate = dynamicsPlanEndDate;
    }

    public Date getDynamicsPlanEndDate() {
        return this.dynamicsPlanEndDate;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("staticIpCount", (Object)this.getStaticIpCount()).append("dynamicsPlan", (Object)this.getDynamicsPlan()).append("dynamicsPlanEndDate", (Object)this.getDynamicsPlanEndDate()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

