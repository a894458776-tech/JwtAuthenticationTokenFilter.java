/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.tasks.entity.dto;

import lombok.Generated;

public class MerchantInsufficientDataDTO {
    private Long merchantId;
    private String merchantName;
    private String companyName;
    private String accountId;
    private String accountLabel;
    private String channelLabel;
    private String balanceFormat;
    private Double threshold;

    @Generated
    public MerchantInsufficientDataDTO() {
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public String getMerchantName() {
        return this.merchantName;
    }

    @Generated
    public String getCompanyName() {
        return this.companyName;
    }

    @Generated
    public String getAccountId() {
        return this.accountId;
    }

    @Generated
    public String getAccountLabel() {
        return this.accountLabel;
    }

    @Generated
    public String getChannelLabel() {
        return this.channelLabel;
    }

    @Generated
    public String getBalanceFormat() {
        return this.balanceFormat;
    }

    @Generated
    public Double getThreshold() {
        return this.threshold;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    @Generated
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Generated
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Generated
    public void setAccountLabel(String accountLabel) {
        this.accountLabel = accountLabel;
    }

    @Generated
    public void setChannelLabel(String channelLabel) {
        this.channelLabel = channelLabel;
    }

    @Generated
    public void setBalanceFormat(String balanceFormat) {
        this.balanceFormat = balanceFormat;
    }

    @Generated
    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MerchantInsufficientDataDTO)) {
            return false;
        }
        MerchantInsufficientDataDTO other = (MerchantInsufficientDataDTO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        Double this$threshold = this.getThreshold();
        Double other$threshold = other.getThreshold();
        if (this$threshold == null ? other$threshold != null : !((Object)this$threshold).equals(other$threshold)) {
            return false;
        }
        String this$merchantName = this.getMerchantName();
        String other$merchantName = other.getMerchantName();
        if (this$merchantName == null ? other$merchantName != null : !this$merchantName.equals(other$merchantName)) {
            return false;
        }
        String this$companyName = this.getCompanyName();
        String other$companyName = other.getCompanyName();
        if (this$companyName == null ? other$companyName != null : !this$companyName.equals(other$companyName)) {
            return false;
        }
        String this$accountId = this.getAccountId();
        String other$accountId = other.getAccountId();
        if (this$accountId == null ? other$accountId != null : !this$accountId.equals(other$accountId)) {
            return false;
        }
        String this$accountLabel = this.getAccountLabel();
        String other$accountLabel = other.getAccountLabel();
        if (this$accountLabel == null ? other$accountLabel != null : !this$accountLabel.equals(other$accountLabel)) {
            return false;
        }
        String this$channelLabel = this.getChannelLabel();
        String other$channelLabel = other.getChannelLabel();
        if (this$channelLabel == null ? other$channelLabel != null : !this$channelLabel.equals(other$channelLabel)) {
            return false;
        }
        String this$balanceFormat = this.getBalanceFormat();
        String other$balanceFormat = other.getBalanceFormat();
        return !(this$balanceFormat == null ? other$balanceFormat != null : !this$balanceFormat.equals(other$balanceFormat));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof MerchantInsufficientDataDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        Double $threshold = this.getThreshold();
        result = result * 59 + ($threshold == null ? 43 : ((Object)$threshold).hashCode());
        String $merchantName = this.getMerchantName();
        result = result * 59 + ($merchantName == null ? 43 : $merchantName.hashCode());
        String $companyName = this.getCompanyName();
        result = result * 59 + ($companyName == null ? 43 : $companyName.hashCode());
        String $accountId = this.getAccountId();
        result = result * 59 + ($accountId == null ? 43 : $accountId.hashCode());
        String $accountLabel = this.getAccountLabel();
        result = result * 59 + ($accountLabel == null ? 43 : $accountLabel.hashCode());
        String $channelLabel = this.getChannelLabel();
        result = result * 59 + ($channelLabel == null ? 43 : $channelLabel.hashCode());
        String $balanceFormat = this.getBalanceFormat();
        result = result * 59 + ($balanceFormat == null ? 43 : $balanceFormat.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "MerchantInsufficientDataDTO(merchantId=" + this.getMerchantId() + ", merchantName=" + this.getMerchantName() + ", companyName=" + this.getCompanyName() + ", accountId=" + this.getAccountId() + ", accountLabel=" + this.getAccountLabel() + ", channelLabel=" + this.getChannelLabel() + ", balanceFormat=" + this.getBalanceFormat() + ", threshold=" + this.getThreshold() + ")";
    }
}

