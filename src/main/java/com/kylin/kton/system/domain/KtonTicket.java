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

public class KtonTicket
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="\u5546\u6237ID")
    private Long merchantId;
    @Excel(name="\u5de5\u5355\u6d41\u6c34\u53f7")
    private String ticketNo;
    @Excel(name="\u7236ticket")
    private Long parentTicketId;
    @Excel(name="\u5de5\u5355\u7c7b\u578b:\u5f85\u5b9a")
    private String ticketType;
    @Excel(name="\u5b50\u7c7b\u578b")
    private String ticketSubtype;
    @Excel(name="\u4efb\u52a1title")
    private String ticketTitle;
    @Excel(name="\u4efb\u52a1\u5185\u5bb9")
    private String description;
    @Excel(name="\u72b6\u6001:PENDING: \u5f85\u5904\u7406, FEEDBACK: \u5f85\u53cd\u9988, COMPLETE:\u5df2\u5b8c\u6210")
    private String status;
    @Excel(name="\u5f53\u524d\u5904\u7406\u540e\u53f0\u7ba1\u7406\u5458\u7684 user_id")
    private Long assignUserId;
    @Excel(name="\u4e1a\u52a1\u7c7b\u578b")
    private String businessType;
    @Excel(name="\u4e1a\u52a1ID")
    private String businessId;

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

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getTicketNo() {
        return this.ticketNo;
    }

    public void setParentTicketId(Long parentTicketId) {
        this.parentTicketId = parentTicketId;
    }

    public Long getParentTicketId() {
        return this.parentTicketId;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getTicketType() {
        return this.ticketType;
    }

    public void setTicketSubtype(String ticketSubtype) {
        this.ticketSubtype = ticketSubtype;
    }

    public String getTicketSubtype() {
        return this.ticketSubtype;
    }

    public void setTicketTitle(String ticketTitle) {
        this.ticketTitle = ticketTitle;
    }

    public String getTicketTitle() {
        return this.ticketTitle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setAssignUserId(Long assignUserId) {
        this.assignUserId = assignUserId;
    }

    public Long getAssignUserId() {
        return this.assignUserId;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessType() {
        return this.businessType;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessId() {
        return this.businessId;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("merchantId", (Object)this.getMerchantId()).append("ticketNo", (Object)this.getTicketNo()).append("parentTicketId", (Object)this.getParentTicketId()).append("ticketType", (Object)this.getTicketType()).append("ticketSubtype", (Object)this.getTicketSubtype()).append("ticketTitle", (Object)this.getTicketTitle()).append("description", (Object)this.getDescription()).append("status", (Object)this.getStatus()).append("assignUserId", (Object)this.getAssignUserId()).append("businessType", (Object)this.getBusinessType()).append("businessId", (Object)this.getBusinessId()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

