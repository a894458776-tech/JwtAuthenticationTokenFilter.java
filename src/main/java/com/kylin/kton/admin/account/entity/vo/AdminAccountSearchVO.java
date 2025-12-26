/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.account.entity.vo;

import lombok.Generated;

public class AdminAccountSearchVO {
    private Long merchantId;
    private Long accountId;
    private String channelCode;
    private String label;

    @Generated
    public AdminAccountSearchVO() {
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public Long getAccountId() {
        return this.accountId;
    }

    @Generated
    public String getChannelCode() {
        return this.channelCode;
    }

    @Generated
    public String getLabel() {
        return this.label;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Generated
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    @Generated
    public void setLabel(String label) {
        this.label = label;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminAccountSearchVO)) {
            return false;
        }
        AdminAccountSearchVO other = (AdminAccountSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        Long this$accountId = this.getAccountId();
        Long other$accountId = other.getAccountId();
        if (this$accountId == null ? other$accountId != null : !((Object)this$accountId).equals(other$accountId)) {
            return false;
        }
        String this$channelCode = this.getChannelCode();
        String other$channelCode = other.getChannelCode();
        if (this$channelCode == null ? other$channelCode != null : !this$channelCode.equals(other$channelCode)) {
            return false;
        }
        String this$label = this.getLabel();
        String other$label = other.getLabel();
        return !(this$label == null ? other$label != null : !this$label.equals(other$label));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminAccountSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        Long $accountId = this.getAccountId();
        result = result * 59 + ($accountId == null ? 43 : ((Object)$accountId).hashCode());
        String $channelCode = this.getChannelCode();
        result = result * 59 + ($channelCode == null ? 43 : $channelCode.hashCode());
        String $label = this.getLabel();
        result = result * 59 + ($label == null ? 43 : $label.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminAccountSearchVO(merchantId=" + this.getMerchantId() + ", accountId=" + this.getAccountId() + ", channelCode=" + this.getChannelCode() + ", label=" + this.getLabel() + ")";
    }
}

