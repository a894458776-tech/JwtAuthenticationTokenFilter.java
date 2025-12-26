/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.ticket.entity.vo;

import lombok.Generated;

public class AdminAuditVO {
    private String ticketNo;
    private String status;

    @Generated
    public AdminAuditVO() {
    }

    @Generated
    public String getTicketNo() {
        return this.ticketNo;
    }

    @Generated
    public String getStatus() {
        return this.status;
    }

    @Generated
    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
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
        if (!(o instanceof AdminAuditVO)) {
            return false;
        }
        AdminAuditVO other = (AdminAuditVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$ticketNo = this.getTicketNo();
        String other$ticketNo = other.getTicketNo();
        if (this$ticketNo == null ? other$ticketNo != null : !this$ticketNo.equals(other$ticketNo)) {
            return false;
        }
        String this$status = this.getStatus();
        String other$status = other.getStatus();
        return !(this$status == null ? other$status != null : !this$status.equals(other$status));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminAuditVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $ticketNo = this.getTicketNo();
        result = result * 59 + ($ticketNo == null ? 43 : $ticketNo.hashCode());
        String $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminAuditVO(ticketNo=" + this.getTicketNo() + ", status=" + this.getStatus() + ")";
    }
}

