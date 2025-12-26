/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.validation.constraints.NotNull
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.vo;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Generated;

public class AdminPutOffIpSourceVO {
    @NotNull(message="\u5546\u6237Id\u4e0d\u80fd\u4e3a\u7a7a")
    @NotNull(message="\u5546\u6237Id\u4e0d\u80fd\u4e3a\u7a7a") List<Long> merchantIds;
    @NotNull(message="IP\u6c60ID\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="IP\u6c60ID\u4e0d\u80fd\u4e3a\u7a7a") Long poolId;
    private Integer quantity;
    private Integer specifyIpSwitch;
    private String ipListStr;

    @Generated
    public AdminPutOffIpSourceVO() {
    }

    @Generated
    public List<Long> getMerchantIds() {
        return this.merchantIds;
    }

    @Generated
    public Long getPoolId() {
        return this.poolId;
    }

    @Generated
    public Integer getQuantity() {
        return this.quantity;
    }

    @Generated
    public Integer getSpecifyIpSwitch() {
        return this.specifyIpSwitch;
    }

    @Generated
    public String getIpListStr() {
        return this.ipListStr;
    }

    @Generated
    public void setMerchantIds(List<Long> merchantIds) {
        this.merchantIds = merchantIds;
    }

    @Generated
    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    @Generated
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Generated
    public void setSpecifyIpSwitch(Integer specifyIpSwitch) {
        this.specifyIpSwitch = specifyIpSwitch;
    }

    @Generated
    public void setIpListStr(String ipListStr) {
        this.ipListStr = ipListStr;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminPutOffIpSourceVO)) {
            return false;
        }
        AdminPutOffIpSourceVO other = (AdminPutOffIpSourceVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$poolId = this.getPoolId();
        Long other$poolId = other.getPoolId();
        if (this$poolId == null ? other$poolId != null : !((Object)this$poolId).equals(other$poolId)) {
            return false;
        }
        Integer this$quantity = this.getQuantity();
        Integer other$quantity = other.getQuantity();
        if (this$quantity == null ? other$quantity != null : !((Object)this$quantity).equals(other$quantity)) {
            return false;
        }
        Integer this$specifyIpSwitch = this.getSpecifyIpSwitch();
        Integer other$specifyIpSwitch = other.getSpecifyIpSwitch();
        if (this$specifyIpSwitch == null ? other$specifyIpSwitch != null : !((Object)this$specifyIpSwitch).equals(other$specifyIpSwitch)) {
            return false;
        }
        List<Long> this$merchantIds = this.getMerchantIds();
        List<Long> other$merchantIds = other.getMerchantIds();
        if (this$merchantIds == null ? other$merchantIds != null : !((Object)this$merchantIds).equals(other$merchantIds)) {
            return false;
        }
        String this$ipListStr = this.getIpListStr();
        String other$ipListStr = other.getIpListStr();
        return !(this$ipListStr == null ? other$ipListStr != null : !this$ipListStr.equals(other$ipListStr));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminPutOffIpSourceVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $poolId = this.getPoolId();
        result = result * 59 + ($poolId == null ? 43 : ((Object)$poolId).hashCode());
        Integer $quantity = this.getQuantity();
        result = result * 59 + ($quantity == null ? 43 : ((Object)$quantity).hashCode());
        Integer $specifyIpSwitch = this.getSpecifyIpSwitch();
        result = result * 59 + ($specifyIpSwitch == null ? 43 : ((Object)$specifyIpSwitch).hashCode());
        List<Long> $merchantIds = this.getMerchantIds();
        result = result * 59 + ($merchantIds == null ? 43 : ((Object)$merchantIds).hashCode());
        String $ipListStr = this.getIpListStr();
        result = result * 59 + ($ipListStr == null ? 43 : $ipListStr.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminPutOffIpSourceVO(merchantIds=" + this.getMerchantIds() + ", poolId=" + this.getPoolId() + ", quantity=" + this.getQuantity() + ", specifyIpSwitch=" + this.getSpecifyIpSwitch() + ", ipListStr=" + this.getIpListStr() + ")";
    }
}

