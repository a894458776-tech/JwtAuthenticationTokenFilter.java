/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.ticket.entity.vo;

import lombok.Generated;

public class AdminTicketSearchVO {
    private Long merchantId;
    private String ticketNo;
    private String ticketType;
    private String ticketTitle;
    private String status;

    @Generated
    public AdminTicketSearchVO() {
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public String getTicketNo() {
        return this.ticketNo;
    }

    @Generated
    public String getTicketType() {
        return this.ticketType;
    }

    @Generated
    public String getTicketTitle() {
        return this.ticketTitle;
    }

    @Generated
    public String getStatus() {
        return this.status;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    @Generated
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    @Generated
    public void setTicketTitle(String ticketTitle) {
        this.ticketTitle = ticketTitle;
    }

    @Generated
    public void setStatus(String status) {
        this.status = status;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminTicketSearchVO)) {
            return false;
        }
        AdminTicketSearchVO other = (AdminTicketSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        String this$ticketNo = this.getTicketNo();
        String other$ticketNo = other.getTicketNo();
        if (this$ticketNo == null ? other$ticketNo != null : !this$ticketNo.equals(other$ticketNo)) {
            return false;
        }
        String this$ticketType = this.getTicketType();
        String other$ticketType = other.getTicketType();
        if (this$ticketType == null ? other$ticketType != null : !this$ticketType.equals(other$ticketType)) {
            return false;
        }
        String this$ticketTitle = this.getTicketTitle();
        String other$ticketTitle = other.getTicketTitle();
        if (this$ticketTitle == null ? other$ticketTitle != null : !this$ticketTitle.equals(other$ticketTitle)) {
            return false;
        }
        String this$status = this.getStatus();
        String other$status = other.getStatus();
        return !(this$status == null ? other$status != null : !this$status.equals(other$status));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminTicketSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        String $ticketNo = this.getTicketNo();
        result = result * 59 + ($ticketNo == null ? 43 : $ticketNo.hashCode());
        String $ticketType = this.getTicketType();
        result = result * 59 + ($ticketType == null ? 43 : $ticketType.hashCode());
        String $ticketTitle = this.getTicketTitle();
        result = result * 59 + ($ticketTitle == null ? 43 : $ticketTitle.hashCode());
        String $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminTicketSearchVO(merchantId=" + this.getMerchantId() + ", ticketNo=" + this.getTicketNo() + ", ticketType=" + this.getTicketType() + ", ticketTitle=" + this.getTicketTitle() + ", status=" + this.getStatus() + ")";
    }
}

