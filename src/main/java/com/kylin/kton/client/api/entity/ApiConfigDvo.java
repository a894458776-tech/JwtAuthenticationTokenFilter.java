/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.api.entity;

import lombok.Generated;

public class ApiConfigDvo {
    private String merchantCode;
    private String merchantToken;

    @Generated
    public ApiConfigDvo() {
    }

    @Generated
    public String getMerchantCode() {
        return this.merchantCode;
    }

    @Generated
    public String getMerchantToken() {
        return this.merchantToken;
    }

    @Generated
    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    @Generated
    public void setMerchantToken(String merchantToken) {
        this.merchantToken = merchantToken;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ApiConfigDvo)) {
            return false;
        }
        ApiConfigDvo other = (ApiConfigDvo)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$merchantCode = this.getMerchantCode();
        String other$merchantCode = other.getMerchantCode();
        if (this$merchantCode == null ? other$merchantCode != null : !this$merchantCode.equals(other$merchantCode)) {
            return false;
        }
        String this$merchantToken = this.getMerchantToken();
        String other$merchantToken = other.getMerchantToken();
        return !(this$merchantToken == null ? other$merchantToken != null : !this$merchantToken.equals(other$merchantToken));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ApiConfigDvo;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $merchantCode = this.getMerchantCode();
        result = result * 59 + ($merchantCode == null ? 43 : $merchantCode.hashCode());
        String $merchantToken = this.getMerchantToken();
        result = result * 59 + ($merchantToken == null ? 43 : $merchantToken.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ApiConfigDvo(merchantCode=" + this.getMerchantCode() + ", merchantToken=" + this.getMerchantToken() + ")";
    }
}

