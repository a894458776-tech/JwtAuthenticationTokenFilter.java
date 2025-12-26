/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonSource
 *  lombok.Generated
 */
package com.kylin.kton.admin.merchant.base.entity.dto;

import com.kylin.kton.system.domain.KtonSource;
import lombok.Generated;

public class AdminMrtchantIpSourceDTO
extends KtonSource {
    private Long merchantId;
    private String ipType;
    private Long sourceId;
    private Long weight;
    private String sourceCode;

    @Generated
    public AdminMrtchantIpSourceDTO() {
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public String getIpType() {
        return this.ipType;
    }

    @Generated
    public Long getSourceId() {
        return this.sourceId;
    }

    @Generated
    public Long getWeight() {
        return this.weight;
    }

    @Generated
    public String getSourceCode() {
        return this.sourceCode;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public void setIpType(String ipType) {
        this.ipType = ipType;
    }

    @Generated
    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    @Generated
    public void setWeight(Long weight) {
        this.weight = weight;
    }

    @Generated
    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminMrtchantIpSourceDTO)) {
            return false;
        }
        AdminMrtchantIpSourceDTO other = (AdminMrtchantIpSourceDTO)((Object)o);
        if (!other.canEqual((Object)this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        Long this$sourceId = this.getSourceId();
        Long other$sourceId = other.getSourceId();
        if (this$sourceId == null ? other$sourceId != null : !((Object)this$sourceId).equals(other$sourceId)) {
            return false;
        }
        Long this$weight = this.getWeight();
        Long other$weight = other.getWeight();
        if (this$weight == null ? other$weight != null : !((Object)this$weight).equals(other$weight)) {
            return false;
        }
        String this$ipType = this.getIpType();
        String other$ipType = other.getIpType();
        if (this$ipType == null ? other$ipType != null : !this$ipType.equals(other$ipType)) {
            return false;
        }
        String this$sourceCode = this.getSourceCode();
        String other$sourceCode = other.getSourceCode();
        return !(this$sourceCode == null ? other$sourceCode != null : !this$sourceCode.equals(other$sourceCode));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminMrtchantIpSourceDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        Long $sourceId = this.getSourceId();
        result = result * 59 + ($sourceId == null ? 43 : ((Object)$sourceId).hashCode());
        Long $weight = this.getWeight();
        result = result * 59 + ($weight == null ? 43 : ((Object)$weight).hashCode());
        String $ipType = this.getIpType();
        result = result * 59 + ($ipType == null ? 43 : $ipType.hashCode());
        String $sourceCode = this.getSourceCode();
        result = result * 59 + ($sourceCode == null ? 43 : $sourceCode.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminMrtchantIpSourceDTO(merchantId=" + this.getMerchantId() + ", ipType=" + this.getIpType() + ", sourceId=" + this.getSourceId() + ", weight=" + this.getWeight() + ", sourceCode=" + this.getSourceCode() + ")";
    }
}

