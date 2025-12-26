/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.vo;

import lombok.Generated;

public class AdminWithOutMerchantlistSearchVO {
    private String sourceCode;
    private String sourceName;
    private String merchantId;
    private String ipType;

    @Generated
    public AdminWithOutMerchantlistSearchVO() {
    }

    @Generated
    public String getSourceCode() {
        return this.sourceCode;
    }

    @Generated
    public String getSourceName() {
        return this.sourceName;
    }

    @Generated
    public String getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public String getIpType() {
        return this.ipType;
    }

    @Generated
    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    @Generated
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    @Generated
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public void setIpType(String ipType) {
        this.ipType = ipType;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminWithOutMerchantlistSearchVO)) {
            return false;
        }
        AdminWithOutMerchantlistSearchVO other = (AdminWithOutMerchantlistSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$sourceCode = this.getSourceCode();
        String other$sourceCode = other.getSourceCode();
        if (this$sourceCode == null ? other$sourceCode != null : !this$sourceCode.equals(other$sourceCode)) {
            return false;
        }
        String this$sourceName = this.getSourceName();
        String other$sourceName = other.getSourceName();
        if (this$sourceName == null ? other$sourceName != null : !this$sourceName.equals(other$sourceName)) {
            return false;
        }
        String this$merchantId = this.getMerchantId();
        String other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !this$merchantId.equals(other$merchantId)) {
            return false;
        }
        String this$ipType = this.getIpType();
        String other$ipType = other.getIpType();
        return !(this$ipType == null ? other$ipType != null : !this$ipType.equals(other$ipType));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminWithOutMerchantlistSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $sourceCode = this.getSourceCode();
        result = result * 59 + ($sourceCode == null ? 43 : $sourceCode.hashCode());
        String $sourceName = this.getSourceName();
        result = result * 59 + ($sourceName == null ? 43 : $sourceName.hashCode());
        String $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : $merchantId.hashCode());
        String $ipType = this.getIpType();
        result = result * 59 + ($ipType == null ? 43 : $ipType.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminWithOutMerchantlistSearchVO(sourceCode=" + this.getSourceCode() + ", sourceName=" + this.getSourceName() + ", merchantId=" + this.getMerchantId() + ", ipType=" + this.getIpType() + ")";
    }
}

