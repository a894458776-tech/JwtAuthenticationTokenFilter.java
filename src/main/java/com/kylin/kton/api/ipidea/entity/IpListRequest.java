/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.ipidea.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Generated;

public class IpListRequest
implements Serializable {
    @JsonProperty(value="page")
    private Integer page;
    @JsonProperty(value="limit")
    private Integer limit;
    @JsonProperty(value="status")
    private Integer status;
    @JsonProperty(value="order_id")
    private String orderId;
    @JsonProperty(value="appkey")
    private String appKey;
    private Integer accountType;

    @Generated
    private static Integer $default$status() {
        return 1;
    }

    @Generated
    private static String $default$appKey() {
        return "5fdba6ccd86fc10320f6b78dcbbc7fea";
    }

    @Generated
    public static IpListRequestBuilder builder() {
        return new IpListRequestBuilder();
    }

    @Generated
    public Integer getPage() {
        return this.page;
    }

    @Generated
    public Integer getLimit() {
        return this.limit;
    }

    @Generated
    public Integer getStatus() {
        return this.status;
    }

    @Generated
    public String getOrderId() {
        return this.orderId;
    }

    @Generated
    public String getAppKey() {
        return this.appKey;
    }

    @Generated
    public Integer getAccountType() {
        return this.accountType;
    }

    @JsonProperty(value="page")
    @Generated
    public void setPage(Integer page) {
        this.page = page;
    }

    @JsonProperty(value="limit")
    @Generated
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @JsonProperty(value="status")
    @Generated
    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonProperty(value="order_id")
    @Generated
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @JsonProperty(value="appkey")
    @Generated
    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    @Generated
    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof IpListRequest)) {
            return false;
        }
        IpListRequest other = (IpListRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Integer this$page = this.getPage();
        Integer other$page = other.getPage();
        if (this$page == null ? other$page != null : !((Object)this$page).equals(other$page)) {
            return false;
        }
        Integer this$limit = this.getLimit();
        Integer other$limit = other.getLimit();
        if (this$limit == null ? other$limit != null : !((Object)this$limit).equals(other$limit)) {
            return false;
        }
        Integer this$status = this.getStatus();
        Integer other$status = other.getStatus();
        if (this$status == null ? other$status != null : !((Object)this$status).equals(other$status)) {
            return false;
        }
        Integer this$accountType = this.getAccountType();
        Integer other$accountType = other.getAccountType();
        if (this$accountType == null ? other$accountType != null : !((Object)this$accountType).equals(other$accountType)) {
            return false;
        }
        String this$orderId = this.getOrderId();
        String other$orderId = other.getOrderId();
        if (this$orderId == null ? other$orderId != null : !this$orderId.equals(other$orderId)) {
            return false;
        }
        String this$appKey = this.getAppKey();
        String other$appKey = other.getAppKey();
        return !(this$appKey == null ? other$appKey != null : !this$appKey.equals(other$appKey));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof IpListRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $page = this.getPage();
        result = result * 59 + ($page == null ? 43 : ((Object)$page).hashCode());
        Integer $limit = this.getLimit();
        result = result * 59 + ($limit == null ? 43 : ((Object)$limit).hashCode());
        Integer $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : ((Object)$status).hashCode());
        Integer $accountType = this.getAccountType();
        result = result * 59 + ($accountType == null ? 43 : ((Object)$accountType).hashCode());
        String $orderId = this.getOrderId();
        result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
        String $appKey = this.getAppKey();
        result = result * 59 + ($appKey == null ? 43 : $appKey.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "IpListRequest(page=" + this.getPage() + ", limit=" + this.getLimit() + ", status=" + this.getStatus() + ", orderId=" + this.getOrderId() + ", appKey=" + this.getAppKey() + ", accountType=" + this.getAccountType() + ")";
    }

    @Generated
    public IpListRequest(Integer page, Integer limit, Integer status, String orderId, String appKey, Integer accountType) {
        this.page = page;
        this.limit = limit;
        this.status = status;
        this.orderId = orderId;
        this.appKey = appKey;
        this.accountType = accountType;
    }

    @Generated
    public IpListRequest() {
        this.status = IpListRequest.$default$status();
        this.appKey = IpListRequest.$default$appKey();
    }

    @Generated
    public static class IpListRequestBuilder {
        @Generated
        private Integer page;
        @Generated
        private Integer limit;
        @Generated
        private boolean status$set;
        @Generated
        private Integer status$value;
        @Generated
        private String orderId;
        @Generated
        private boolean appKey$set;
        @Generated
        private String appKey$value;
        @Generated
        private Integer accountType;

        @Generated
        IpListRequestBuilder() {
        }

        @JsonProperty(value="page")
        @Generated
        public IpListRequestBuilder page(Integer page) {
            this.page = page;
            return this;
        }

        @JsonProperty(value="limit")
        @Generated
        public IpListRequestBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        @JsonProperty(value="status")
        @Generated
        public IpListRequestBuilder status(Integer status) {
            this.status$value = status;
            this.status$set = true;
            return this;
        }

        @JsonProperty(value="order_id")
        @Generated
        public IpListRequestBuilder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        @JsonProperty(value="appkey")
        @Generated
        public IpListRequestBuilder appKey(String appKey) {
            this.appKey$value = appKey;
            this.appKey$set = true;
            return this;
        }

        @Generated
        public IpListRequestBuilder accountType(Integer accountType) {
            this.accountType = accountType;
            return this;
        }

        @Generated
        public IpListRequest build() {
            Integer status$value = this.status$value;
            if (!this.status$set) {
                status$value = IpListRequest.$default$status();
            }
            String appKey$value = this.appKey$value;
            if (!this.appKey$set) {
                appKey$value = IpListRequest.$default$appKey();
            }
            return new IpListRequest(this.page, this.limit, status$value, this.orderId, appKey$value, this.accountType);
        }

        @Generated
        public String toString() {
            return "IpListRequest.IpListRequestBuilder(page=" + this.page + ", limit=" + this.limit + ", status$value=" + this.status$value + ", orderId=" + this.orderId + ", appKey$value=" + this.appKey$value + ", accountType=" + this.accountType + ")";
        }
    }
}

