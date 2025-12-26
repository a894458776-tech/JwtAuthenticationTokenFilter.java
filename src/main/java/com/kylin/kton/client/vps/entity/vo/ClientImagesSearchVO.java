/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.swagger.annotations.ApiModelProperty
 *  lombok.Generated
 */
package com.kylin.kton.client.vps.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Generated;

public class ClientImagesSearchVO {
    @ApiModelProperty(value="\u5b57\u7b26\u4e32ID")
    private String refId;
    @ApiModelProperty(value="\u955c\u50cf\u540d\u79f0")
    private String name;
    @ApiModelProperty(value="\u5546\u6237ID")
    private Long merchantId;

    @Generated
    public ClientImagesSearchVO() {
    }

    @Generated
    public String getRefId() {
        return this.refId;
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public void setRefId(String refId) {
        this.refId = refId;
    }

    @Generated
    public void setName(String name) {
        this.name = name;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ClientImagesSearchVO)) {
            return false;
        }
        ClientImagesSearchVO other = (ClientImagesSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        String this$refId = this.getRefId();
        String other$refId = other.getRefId();
        if (this$refId == null ? other$refId != null : !this$refId.equals(other$refId)) {
            return false;
        }
        String this$name = this.getName();
        String other$name = other.getName();
        return !(this$name == null ? other$name != null : !this$name.equals(other$name));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ClientImagesSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        String $refId = this.getRefId();
        result = result * 59 + ($refId == null ? 43 : $refId.hashCode());
        String $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "ClientImagesSearchVO(refId=" + this.getRefId() + ", name=" + this.getName() + ", merchantId=" + this.getMerchantId() + ")";
    }
}

