/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.validation.constraints.NotNull
 *  lombok.Generated
 */
package com.kylin.kton.admin.ticket.entity.vo;

import javax.validation.constraints.NotNull;
import lombok.Generated;

public class AdminTicketEditVO {
    @NotNull(message="ID\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="ID\u4e0d\u80fd\u4e3a\u7a7a") Long id;
    private Long merchantId;
    @NotNull(message="\u5de5\u5355\u7c7b\u578b\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="\u5de5\u5355\u7c7b\u578b\u4e0d\u80fd\u4e3a\u7a7a") String ticketType;
    @NotNull(message="\u4efb\u52a1title\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="\u4efb\u52a1title\u4e0d\u80fd\u4e3a\u7a7a") String ticketTitle;
    @NotNull(message="\u4efb\u52a1\u5185\u5bb9\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="\u4efb\u52a1\u5185\u5bb9\u4e0d\u80fd\u4e3a\u7a7a") String description;
    private String businessType;
    private String status;
    private String businessId;

    @Generated
    public AdminTicketEditVO() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
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
    public String getDescription() {
        return this.description;
    }

    @Generated
    public String getBusinessType() {
        return this.businessType;
    }

    @Generated
    public String getStatus() {
        return this.status;
    }

    @Generated
    public String getBusinessId() {
        return this.businessId;
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
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
    public void setDescription(String description) {
        this.description = description;
    }

    @Generated
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    @Generated
    public void setStatus(String status) {
        this.status = status;
    }

    @Generated
    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminTicketEditVO)) {
            return false;
        }
        AdminTicketEditVO other = (AdminTicketEditVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$id = this.getId();
        Long other$id = other.getId();
        if (this$id == null ? other$id != null : !((Object)this$id).equals(other$id)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
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
        String this$description = this.getDescription();
        String other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        String this$businessType = this.getBusinessType();
        String other$businessType = other.getBusinessType();
        if (this$businessType == null ? other$businessType != null : !this$businessType.equals(other$businessType)) {
            return false;
        }
        String this$status = this.getStatus();
        String other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
            return false;
        }
        String this$businessId = this.getBusinessId();
        String other$businessId = other.getBusinessId();
        return !(this$businessId == null ? other$businessId != null : !this$businessId.equals(other$businessId));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminTicketEditVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $id = this.getId();
        result = result * 59 + ($id == null ? 43 : ((Object)$id).hashCode());
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        String $ticketType = this.getTicketType();
        result = result * 59 + ($ticketType == null ? 43 : $ticketType.hashCode());
        String $ticketTitle = this.getTicketTitle();
        result = result * 59 + ($ticketTitle == null ? 43 : $ticketTitle.hashCode());
        String $description = this.getDescription();
        result = result * 59 + ($description == null ? 43 : $description.hashCode());
        String $businessType = this.getBusinessType();
        result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
        String $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        String $businessId = this.getBusinessId();
        result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminTicketEditVO(id=" + this.getId() + ", merchantId=" + this.getMerchantId() + ", ticketType=" + this.getTicketType() + ", ticketTitle=" + this.getTicketTitle() + ", description=" + this.getDescription() + ", businessType=" + this.getBusinessType() + ", status=" + this.getStatus() + ", businessId=" + this.getBusinessId() + ")";
    }
}

