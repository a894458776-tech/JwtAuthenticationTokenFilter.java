/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.validation.constraints.NotNull
 *  lombok.Generated
 */
package com.kylin.kton.client.cluster.entity.vo;

import javax.validation.constraints.NotNull;
import lombok.Generated;

public class TemplateListSearchVO {
    @NotNull(message="clusterId\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="clusterId\u4e0d\u80fd\u4e3a\u7a7a") Long clusterId;
    private String templateId;

    @Generated
    public TemplateListSearchVO() {
    }

    @Generated
    public Long getClusterId() {
        return this.clusterId;
    }

    @Generated
    public String getTemplateId() {
        return this.templateId;
    }

    @Generated
    public void setClusterId(Long clusterId) {
        this.clusterId = clusterId;
    }

    @Generated
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TemplateListSearchVO)) {
            return false;
        }
        TemplateListSearchVO other = (TemplateListSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$clusterId = this.getClusterId();
        Long other$clusterId = other.getClusterId();
        if (this$clusterId == null ? other$clusterId != null : !((Object)this$clusterId).equals(other$clusterId)) {
            return false;
        }
        String this$templateId = this.getTemplateId();
        String other$templateId = other.getTemplateId();
        return !(this$templateId == null ? other$templateId != null : !this$templateId.equals(other$templateId));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof TemplateListSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $clusterId = this.getClusterId();
        result = result * 59 + ($clusterId == null ? 43 : ((Object)$clusterId).hashCode());
        String $templateId = this.getTemplateId();
        result = result * 59 + ($templateId == null ? 43 : $templateId.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "TemplateListSearchVO(clusterId=" + this.getClusterId() + ", templateId=" + this.getTemplateId() + ")";
    }
}

