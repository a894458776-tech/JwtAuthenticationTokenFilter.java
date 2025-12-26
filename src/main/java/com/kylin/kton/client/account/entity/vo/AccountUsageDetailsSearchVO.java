/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.validation.constraints.NotNull
 *  lombok.Generated
 */
package com.kylin.kton.client.account.entity.vo;

import javax.validation.constraints.NotNull;
import lombok.Generated;

public class AccountUsageDetailsSearchVO {
    @NotNull(message="merchantId\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="merchantId\u4e0d\u80fd\u4e3a\u7a7a") Long merchantId;
    @NotNull(message="accountId\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="accountId\u4e0d\u80fd\u4e3a\u7a7a") Long accountId;
    private String host;
    private String status;
    private Integer pageNum;
    private Integer pageSize;

    @Generated
    public AccountUsageDetailsSearchVO() {
    }

    @Generated
    public Long getMerchantId() {
        return this.merchantId;
    }

    @Generated
    public Long getAccountId() {
        return this.accountId;
    }

    @Generated
    public String getHost() {
        return this.host;
    }

    @Generated
    public String getStatus() {
        return this.status;
    }

    @Generated
    public Integer getPageNum() {
        return this.pageNum;
    }

    @Generated
    public Integer getPageSize() {
        return this.pageSize;
    }

    @Generated
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Generated
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Generated
    public void setHost(String host) {
        this.host = host;
    }

    @Generated
    public void setStatus(String status) {
        this.status = status;
    }

    @Generated
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @Generated
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AccountUsageDetailsSearchVO)) {
            return false;
        }
        AccountUsageDetailsSearchVO other = (AccountUsageDetailsSearchVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$merchantId = this.getMerchantId();
        Long other$merchantId = other.getMerchantId();
        if (this$merchantId == null ? other$merchantId != null : !((Object)this$merchantId).equals(other$merchantId)) {
            return false;
        }
        Long this$accountId = this.getAccountId();
        Long other$accountId = other.getAccountId();
        if (this$accountId == null ? other$accountId != null : !((Object)this$accountId).equals(other$accountId)) {
            return false;
        }
        Integer this$pageNum = this.getPageNum();
        Integer other$pageNum = other.getPageNum();
        if (this$pageNum == null ? other$pageNum != null : !((Object)this$pageNum).equals(other$pageNum)) {
            return false;
        }
        Integer this$pageSize = this.getPageSize();
        Integer other$pageSize = other.getPageSize();
        if (this$pageSize == null ? other$pageSize != null : !((Object)this$pageSize).equals(other$pageSize)) {
            return false;
        }
        String this$host = this.getHost();
        String other$host = other.getHost();
        if (this$host == null ? other$host != null : !this$host.equals(other$host)) {
            return false;
        }
        String this$status = this.getStatus();
        String other$status = other.getStatus();
        return !(this$status == null ? other$status != null : !this$status.equals(other$status));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AccountUsageDetailsSearchVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $merchantId = this.getMerchantId();
        result = result * 59 + ($merchantId == null ? 43 : ((Object)$merchantId).hashCode());
        Long $accountId = this.getAccountId();
        result = result * 59 + ($accountId == null ? 43 : ((Object)$accountId).hashCode());
        Integer $pageNum = this.getPageNum();
        result = result * 59 + ($pageNum == null ? 43 : ((Object)$pageNum).hashCode());
        Integer $pageSize = this.getPageSize();
        result = result * 59 + ($pageSize == null ? 43 : ((Object)$pageSize).hashCode());
        String $host = this.getHost();
        result = result * 59 + ($host == null ? 43 : $host.hashCode());
        String $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AccountUsageDetailsSearchVO(merchantId=" + this.getMerchantId() + ", accountId=" + this.getAccountId() + ", host=" + this.getHost() + ", status=" + this.getStatus() + ", pageNum=" + this.getPageNum() + ", pageSize=" + this.getPageSize() + ")";
    }
}

