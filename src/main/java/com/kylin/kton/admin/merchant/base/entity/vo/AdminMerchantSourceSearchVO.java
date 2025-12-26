/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.merchant.base.entity.vo;

import lombok.Generated;

public class AdminMerchantSourceSearchVO {
    private String sourceCode;
    private String merchantId;

    @Generated
    public AdminMerchantSourceSearchVO() {
    }

    @Generated
    public String getSourceCode() {
        return this.sourceCode;
    }

    @Generated
    public String getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    @Generated
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminMerchantSourceSearchVO)) {
            return false;
        }
        AdminMerchantSourceSearchVO other = (AdminMerchantSourceSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$sourceCode = this.getSourceCode();
        String other$sourceCode = other.getSourceCode();
        if (this$sourceCode == null ? other$sourceCode != null : !this$sourceCode.equals(other$sourceCode)) {
            return false;
        }
        String this$merchantId = this.getMerchantId();
        String other$merchantId = other.getMerchantId();
        return !(this$merchantId == null ? other$merchantId != null : !this$merchantId.equals(other$merchantId));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminMerchantSourceSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $sourceCode = this.getSourceCode();
        result = result * 59 + ($sourceCode == null ? 43 : $sourceCode.hashCode());
        String $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : $merchantId.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminMerchantSourceSearchVO(sourceCode=" + this.getSourceCode() + ", merchantId=" + this.getMerchantId() + ")";
    }
}

