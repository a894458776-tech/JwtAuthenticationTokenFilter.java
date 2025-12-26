/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonVpsHostContainer
 *  lombok.Generated
 */
package com.kylin.kton.admin.vps.entity.vo;

import com.kylin.kton.system.domain.KtonVpsHostContainer;
import java.io.Serializable;
import java.util.Date;
import lombok.Generated;

public class QueryVpsHostContainerVO
extends KtonVpsHostContainer
implements Serializable {
    private Date beginDate;
    private Date endDate;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof QueryVpsHostContainerVO)) {
            return false;
        }
        QueryVpsHostContainerVO other = (QueryVpsHostContainerVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Date this$beginDate = this.getBeginDate();
        Date other$beginDate = other.getBeginDate();
        if (this$beginDate == null ? other$beginDate != null : !((Object)this$beginDate).equals(other$beginDate)) {
            return false;
        }
        Date this$endDate = this.getEndDate();
        Date other$endDate = other.getEndDate();
        return !(this$endDate == null ? other$endDate != null : !((Object)this$endDate).equals(other$endDate));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof QueryVpsHostContainerVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = super.hashCode();
        Date $beginDate = this.getBeginDate();
        result = result * 59 + ($beginDate == null ? 43 : ((Object)$beginDate).hashCode());
        Date $endDate = this.getEndDate();
        result = result * 59 + ($endDate == null ? 43 : ((Object)$endDate).hashCode());
        return result;
    }

    @Generated
    public QueryVpsHostContainerVO() {
    }

    @Generated
    public Date getBeginDate() {
        return this.beginDate;
    }

    @Generated
    public Date getEndDate() {
        return this.endDate;
    }

    @Generated
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    @Generated
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Generated
    public String toString() {
        return "QueryVpsHostContainerVO(beginDate=" + this.getBeginDate() + ", endDate=" + this.getEndDate() + ")";
    }
}

