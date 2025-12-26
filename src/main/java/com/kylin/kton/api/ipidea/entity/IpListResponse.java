/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.ipidea.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kylin.kton.api.ipidea.entity.BaseResponse;
import java.io.Serializable;
import java.util.List;
import lombok.Generated;

public class IpListResponse
extends BaseResponse
implements Serializable {
    @JsonProperty(value="ret_data")
    private NodeData retData;

    @Override
    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof IpListResponse)) {
            return false;
        }
        IpListResponse other = (IpListResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        NodeData this$retData = this.getRetData();
        NodeData other$retData = other.getRetData();
        return !(this$retData == null ? other$retData != null : !((Object)this$retData).equals(other$retData));
    }

    @Override
    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof IpListResponse;
    }

    @Override
    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = super.hashCode();
        NodeData $retData = this.getRetData();
        result = result * 59 + ($retData == null ? 43 : ((Object)$retData).hashCode());
        return result;
    }

    @Generated
    public IpListResponse() {
    }

    @Generated
    public NodeData getRetData() {
        return this.retData;
    }

    @JsonProperty(value="ret_data")
    @Generated
    public void setRetData(NodeData retData) {
        this.retData = retData;
    }

    @Override
    @Generated
    public String toString() {
        return "IpListResponse(retData=" + this.getRetData() + ")";
    }

    public static class NodeData
    implements Serializable {
        private Integer total;
        @JsonProperty(value="per_page")
        private String perPage;
        @JsonProperty(value="current_page")
        private Integer currentPage;
        @JsonProperty(value="last_page")
        private Integer lastPage;
        private List<Result> data;

        @Generated
        public NodeData() {
        }

        @Generated
        public Integer getTotal() {
            return this.total;
        }

        @Generated
        public String getPerPage() {
            return this.perPage;
        }

        @Generated
        public Integer getCurrentPage() {
            return this.currentPage;
        }

        @Generated
        public Integer getLastPage() {
            return this.lastPage;
        }

        @Generated
        public List<Result> getData() {
            return this.data;
        }

        @Generated
        public void setTotal(Integer total) {
            this.total = total;
        }

        @JsonProperty(value="per_page")
        @Generated
        public void setPerPage(String perPage) {
            this.perPage = perPage;
        }

        @JsonProperty(value="current_page")
        @Generated
        public void setCurrentPage(Integer currentPage) {
            this.currentPage = currentPage;
        }

        @JsonProperty(value="last_page")
        @Generated
        public void setLastPage(Integer lastPage) {
            this.lastPage = lastPage;
        }

        @Generated
        public void setData(List<Result> data) {
            this.data = data;
        }

        @Generated
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof NodeData)) {
                return false;
            }
            NodeData other = (NodeData)o;
            if (!other.canEqual(this)) {
                return false;
            }
            Integer this$total = this.getTotal();
            Integer other$total = other.getTotal();
            if (this$total == null ? other$total != null : !((Object)this$total).equals(other$total)) {
                return false;
            }
            Integer this$currentPage = this.getCurrentPage();
            Integer other$currentPage = other.getCurrentPage();
            if (this$currentPage == null ? other$currentPage != null : !((Object)this$currentPage).equals(other$currentPage)) {
                return false;
            }
            Integer this$lastPage = this.getLastPage();
            Integer other$lastPage = other.getLastPage();
            if (this$lastPage == null ? other$lastPage != null : !((Object)this$lastPage).equals(other$lastPage)) {
                return false;
            }
            String this$perPage = this.getPerPage();
            String other$perPage = other.getPerPage();
            if (this$perPage == null ? other$perPage != null : !this$perPage.equals(other$perPage)) {
                return false;
            }
            List<Result> this$data = this.getData();
            List<Result> other$data = other.getData();
            return !(this$data == null ? other$data != null : !((Object)this$data).equals(other$data));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof NodeData;
        }

        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            Integer $total = this.getTotal();
            result = result * 59 + ($total == null ? 43 : ((Object)$total).hashCode());
            Integer $currentPage = this.getCurrentPage();
            result = result * 59 + ($currentPage == null ? 43 : ((Object)$currentPage).hashCode());
            Integer $lastPage = this.getLastPage();
            result = result * 59 + ($lastPage == null ? 43 : ((Object)$lastPage).hashCode());
            String $perPage = this.getPerPage();
            result = result * 59 + ($perPage == null ? 43 : $perPage.hashCode());
            List<Result> $data = this.getData();
            result = result * 59 + ($data == null ? 43 : ((Object)$data).hashCode());
            return result;
        }

        @Generated
        public String toString() {
            return "IpListResponse.NodeData(total=" + this.getTotal() + ", perPage=" + this.getPerPage() + ", currentPage=" + this.getCurrentPage() + ", lastPage=" + this.getLastPage() + ", data=" + this.getData() + ")";
        }
    }

    public static class Result
    implements Serializable {
        @JsonProperty(value="eip")
        private String ip;
        @JsonProperty(value="add_time")
        private Long addTime;
        @JsonProperty(value="expire_time")
        private Long expireTime;

        @Generated
        public Result() {
        }

        @Generated
        public String getIp() {
            return this.ip;
        }

        @Generated
        public Long getAddTime() {
            return this.addTime;
        }

        @Generated
        public Long getExpireTime() {
            return this.expireTime;
        }

        @JsonProperty(value="eip")
        @Generated
        public void setIp(String ip) {
            this.ip = ip;
        }

        @JsonProperty(value="add_time")
        @Generated
        public void setAddTime(Long addTime) {
            this.addTime = addTime;
        }

        @JsonProperty(value="expire_time")
        @Generated
        public void setExpireTime(Long expireTime) {
            this.expireTime = expireTime;
        }

        @Generated
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Result)) {
                return false;
            }
            Result other = (Result)o;
            if (!other.canEqual(this)) {
                return false;
            }
            Long this$addTime = this.getAddTime();
            Long other$addTime = other.getAddTime();
            if (this$addTime == null ? other$addTime != null : !((Object)this$addTime).equals(other$addTime)) {
                return false;
            }
            Long this$expireTime = this.getExpireTime();
            Long other$expireTime = other.getExpireTime();
            if (this$expireTime == null ? other$expireTime != null : !((Object)this$expireTime).equals(other$expireTime)) {
                return false;
            }
            String this$ip = this.getIp();
            String other$ip = other.getIp();
            return !(this$ip == null ? other$ip != null : !this$ip.equals(other$ip));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof Result;
        }

        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            Long $addTime = this.getAddTime();
            result = result * 59 + ($addTime == null ? 43 : ((Object)$addTime).hashCode());
            Long $expireTime = this.getExpireTime();
            result = result * 59 + ($expireTime == null ? 43 : ((Object)$expireTime).hashCode());
            String $ip = this.getIp();
            result = result * 59 + ($ip == null ? 43 : $ip.hashCode());
            return result;
        }

        @Generated
        public String toString() {
            return "IpListResponse.Result(ip=" + this.getIp() + ", addTime=" + this.getAddTime() + ", expireTime=" + this.getExpireTime() + ")";
        }
    }
}

