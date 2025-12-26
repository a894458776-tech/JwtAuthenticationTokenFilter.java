/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonVpsHostContainer
 *  io.swagger.annotations.ApiModelProperty
 *  lombok.Generated
 */
package com.kylin.kton.admin.vps.entity.vo;

import com.kylin.kton.system.domain.KtonVpsHostContainer;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Generated;

public class AddVpsHostContainerVO
extends KtonVpsHostContainer
implements Serializable {
    private Integer quantity = 1;
    private String hostTemplateId;
    @ApiModelProperty(value="\u955c\u50cfID")
    private String imagesId;
    private Long clusterId;
    private Long merchantId;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AddVpsHostContainerVO)) {
            return false;
        }
        AddVpsHostContainerVO other = (AddVpsHostContainerVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Integer this$quantity = this.getQuantity();
        Integer other$quantity = other.getQuantity();
        if (this$quantity == null ? other$quantity != null : !((Object)this$quantity).equals(other$quantity)) {
            return false;
        }
        Long this$clusterId = this.getClusterId();
        Long other$clusterId = other.getClusterId();
        if (this$clusterId == null ? other$clusterId != null : !((Object)this$clusterId).equals(other$clusterId)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        String this$hostTemplateId = this.getHostTemplateId();
        String other$hostTemplateId = other.getHostTemplateId();
        if (this$hostTemplateId == null ? other$hostTemplateId != null : !this$hostTemplateId.equals(other$hostTemplateId)) {
            return false;
        }
        String this$imagesId = this.getImagesId();
        String other$imagesId = other.getImagesId();
        return !(this$imagesId == null ? other$imagesId != null : !this$imagesId.equals(other$imagesId));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AddVpsHostContainerVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = super.hashCode();
        Integer $quantity = this.getQuantity();
        result = result * 59 + ($quantity == null ? 43 : ((Object)$quantity).hashCode());
        Long $clusterId = this.getClusterId();
        result = result * 59 + ($clusterId == null ? 43 : ((Object)$clusterId).hashCode());
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        String $hostTemplateId = this.getHostTemplateId();
        result = result * 59 + ($hostTemplateId == null ? 43 : $hostTemplateId.hashCode());
        String $imagesId = this.getImagesId();
        result = result * 59 + ($imagesId == null ? 43 : $imagesId.hashCode());
        return result;
    }

    @Generated
    public AddVpsHostContainerVO() {
    }

    @Generated
    public Integer getQuantity() {
        return this.quantity;
    }

    @Generated
    public String getHostTemplateId() {
        return this.hostTemplateId;
    }

    @Generated
    public String getImagesId() {
        return this.imagesId;
    }

    @Generated
    public Long getClusterId() {
        return this.clusterId;
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Generated
    public void setHostTemplateId(String hostTemplateId) {
        this.hostTemplateId = hostTemplateId;
    }

    @Generated
    public void setImagesId(String imagesId) {
        this.imagesId = imagesId;
    }

    @Generated
    public void setClusterId(Long clusterId) {
        this.clusterId = clusterId;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public String toString() {
        return "AddVpsHostContainerVO(quantity=" + this.getQuantity() + ", hostTemplateId=" + this.getHostTemplateId() + ", imagesId=" + this.getImagesId() + ", clusterId=" + this.getClusterId() + ", merchantId=" + this.getMerchantId() + ")";
    }
}

