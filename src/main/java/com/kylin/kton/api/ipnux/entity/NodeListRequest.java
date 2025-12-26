/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.ipnux.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Generated;

public class NodeListRequest
implements Serializable {
    @JsonProperty(value="proxies_type")
    private String proxiesType;
    @JsonProperty(value="proxies_format")
    private Integer proxiesFormat;
    @JsonProperty(value="order_id")
    private String orderId;
    @JsonProperty(value="proxy_ids")
    private List<Integer> proxyIds;
    @JsonProperty(value="proxy_address")
    private String proxyAddress;
    @JsonProperty(value="city_name")
    private String cityName;
    @JsonProperty(value="continents_name")
    private String continentsName;
    @JsonProperty(value="proxy_status")
    private Integer proxyStatus;
    @JsonProperty(value="expiring_days")
    private Integer expiringDays;

    @Generated
    public static NodeListRequestBuilder builder() {
        return new NodeListRequestBuilder();
    }

    @Generated
    public String getProxiesType() {
        return this.proxiesType;
    }

    @Generated
    public Integer getProxiesFormat() {
        return this.proxiesFormat;
    }

    @Generated
    public String getOrderId() {
        return this.orderId;
    }

    @Generated
    public List<Integer> getProxyIds() {
        return this.proxyIds;
    }

    @Generated
    public String getProxyAddress() {
        return this.proxyAddress;
    }

    @Generated
    public String getCityName() {
        return this.cityName;
    }

    @Generated
    public String getContinentsName() {
        return this.continentsName;
    }

    @Generated
    public Integer getProxyStatus() {
        return this.proxyStatus;
    }

    @Generated
    public Integer getExpiringDays() {
        return this.expiringDays;
    }

    @JsonProperty(value="proxies_type")
    @Generated
    public void setProxiesType(String proxiesType) {
        this.proxiesType = proxiesType;
    }

    @JsonProperty(value="proxies_format")
    @Generated
    public void setProxiesFormat(Integer proxiesFormat) {
        this.proxiesFormat = proxiesFormat;
    }

    @JsonProperty(value="order_id")
    @Generated
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @JsonProperty(value="proxy_ids")
    @Generated
    public void setProxyIds(List<Integer> proxyIds) {
        this.proxyIds = proxyIds;
    }

    @JsonProperty(value="proxy_address")
    @Generated
    public void setProxyAddress(String proxyAddress) {
        this.proxyAddress = proxyAddress;
    }

    @JsonProperty(value="city_name")
    @Generated
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @JsonProperty(value="continents_name")
    @Generated
    public void setContinentsName(String continentsName) {
        this.continentsName = continentsName;
    }

    @JsonProperty(value="proxy_status")
    @Generated
    public void setProxyStatus(Integer proxyStatus) {
        this.proxyStatus = proxyStatus;
    }

    @JsonProperty(value="expiring_days")
    @Generated
    public void setExpiringDays(Integer expiringDays) {
        this.expiringDays = expiringDays;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof NodeListRequest)) {
            return false;
        }
        NodeListRequest other = (NodeListRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Integer this$proxiesFormat = this.getProxiesFormat();
        Integer other$proxiesFormat = other.getProxiesFormat();
        if (this$proxiesFormat == null ? other$proxiesFormat != null : !((Object)this$proxiesFormat).equals(other$proxiesFormat)) {
            return false;
        }
        Integer this$proxyStatus = this.getProxyStatus();
        Integer other$proxyStatus = other.getProxyStatus();
        if (this$proxyStatus == null ? other$proxyStatus != null : !((Object)this$proxyStatus).equals(other$proxyStatus)) {
            return false;
        }
        Integer this$expiringDays = this.getExpiringDays();
        Integer other$expiringDays = other.getExpiringDays();
        if (this$expiringDays == null ? other$expiringDays != null : !((Object)this$expiringDays).equals(other$expiringDays)) {
            return false;
        }
        String this$proxiesType = this.getProxiesType();
        String other$proxiesType = other.getProxiesType();
        if (this$proxiesType == null ? other$proxiesType != null : !this$proxiesType.equals(other$proxiesType)) {
            return false;
        }
        String this$orderId = this.getOrderId();
        String other$orderId = other.getOrderId();
        if (this$orderId == null ? other$orderId != null : !this$orderId.equals(other$orderId)) {
            return false;
        }
        List<Integer> this$proxyIds = this.getProxyIds();
        List<Integer> other$proxyIds = other.getProxyIds();
        if (this$proxyIds == null ? other$proxyIds != null : !((Object)this$proxyIds).equals(other$proxyIds)) {
            return false;
        }
        String this$proxyAddress = this.getProxyAddress();
        String other$proxyAddress = other.getProxyAddress();
        if (this$proxyAddress == null ? other$proxyAddress != null : !this$proxyAddress.equals(other$proxyAddress)) {
            return false;
        }
        String this$cityName = this.getCityName();
        String other$cityName = other.getCityName();
        if (this$cityName == null ? other$cityName != null : !this$cityName.equals(other$cityName)) {
            return false;
        }
        String this$continentsName = this.getContinentsName();
        String other$continentsName = other.getContinentsName();
        return !(this$continentsName == null ? other$continentsName != null : !this$continentsName.equals(other$continentsName));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof NodeListRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $proxiesFormat = this.getProxiesFormat();
        result = result * 59 + ($proxiesFormat == null ? 43 : ((Object)$proxiesFormat).hashCode());
        Integer $proxyStatus = this.getProxyStatus();
        result = result * 59 + ($proxyStatus == null ? 43 : ((Object)$proxyStatus).hashCode());
        Integer $expiringDays = this.getExpiringDays();
        result = result * 59 + ($expiringDays == null ? 43 : ((Object)$expiringDays).hashCode());
        String $proxiesType = this.getProxiesType();
        result = result * 59 + ($proxiesType == null ? 43 : $proxiesType.hashCode());
        String $orderId = this.getOrderId();
        result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
        List<Integer> $proxyIds = this.getProxyIds();
        result = result * 59 + ($proxyIds == null ? 43 : ((Object)$proxyIds).hashCode());
        String $proxyAddress = this.getProxyAddress();
        result = result * 59 + ($proxyAddress == null ? 43 : $proxyAddress.hashCode());
        String $cityName = this.getCityName();
        result = result * 59 + ($cityName == null ? 43 : $cityName.hashCode());
        String $continentsName = this.getContinentsName();
        result = result * 59 + ($continentsName == null ? 43 : $continentsName.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "NodeListRequest(proxiesType=" + this.getProxiesType() + ", proxiesFormat=" + this.getProxiesFormat() + ", orderId=" + this.getOrderId() + ", proxyIds=" + this.getProxyIds() + ", proxyAddress=" + this.getProxyAddress() + ", cityName=" + this.getCityName() + ", continentsName=" + this.getContinentsName() + ", proxyStatus=" + this.getProxyStatus() + ", expiringDays=" + this.getExpiringDays() + ")";
    }

    @Generated
    public NodeListRequest(String proxiesType, Integer proxiesFormat, String orderId, List<Integer> proxyIds, String proxyAddress, String cityName, String continentsName, Integer proxyStatus, Integer expiringDays) {
        this.proxiesType = proxiesType;
        this.proxiesFormat = proxiesFormat;
        this.orderId = orderId;
        this.proxyIds = proxyIds;
        this.proxyAddress = proxyAddress;
        this.cityName = cityName;
        this.continentsName = continentsName;
        this.proxyStatus = proxyStatus;
        this.expiringDays = expiringDays;
    }

    @Generated
    public NodeListRequest() {
    }

    @Generated
    public static class NodeListRequestBuilder {
        @Generated
        private String proxiesType;
        @Generated
        private Integer proxiesFormat;
        @Generated
        private String orderId;
        @Generated
        private List<Integer> proxyIds;
        @Generated
        private String proxyAddress;
        @Generated
        private String cityName;
        @Generated
        private String continentsName;
        @Generated
        private Integer proxyStatus;
        @Generated
        private Integer expiringDays;

        @Generated
        NodeListRequestBuilder() {
        }

        @JsonProperty(value="proxies_type")
        @Generated
        public NodeListRequestBuilder proxiesType(String proxiesType) {
            this.proxiesType = proxiesType;
            return this;
        }

        @JsonProperty(value="proxies_format")
        @Generated
        public NodeListRequestBuilder proxiesFormat(Integer proxiesFormat) {
            this.proxiesFormat = proxiesFormat;
            return this;
        }

        @JsonProperty(value="order_id")
        @Generated
        public NodeListRequestBuilder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        @JsonProperty(value="proxy_ids")
        @Generated
        public NodeListRequestBuilder proxyIds(List<Integer> proxyIds) {
            this.proxyIds = proxyIds;
            return this;
        }

        @JsonProperty(value="proxy_address")
        @Generated
        public NodeListRequestBuilder proxyAddress(String proxyAddress) {
            this.proxyAddress = proxyAddress;
            return this;
        }

        @JsonProperty(value="city_name")
        @Generated
        public NodeListRequestBuilder cityName(String cityName) {
            this.cityName = cityName;
            return this;
        }

        @JsonProperty(value="continents_name")
        @Generated
        public NodeListRequestBuilder continentsName(String continentsName) {
            this.continentsName = continentsName;
            return this;
        }

        @JsonProperty(value="proxy_status")
        @Generated
        public NodeListRequestBuilder proxyStatus(Integer proxyStatus) {
            this.proxyStatus = proxyStatus;
            return this;
        }

        @JsonProperty(value="expiring_days")
        @Generated
        public NodeListRequestBuilder expiringDays(Integer expiringDays) {
            this.expiringDays = expiringDays;
            return this;
        }

        @Generated
        public NodeListRequest build() {
            return new NodeListRequest(this.proxiesType, this.proxiesFormat, this.orderId, this.proxyIds, this.proxyAddress, this.cityName, this.continentsName, this.proxyStatus, this.expiringDays);
        }

        @Generated
        public String toString() {
            return "NodeListRequest.NodeListRequestBuilder(proxiesType=" + this.proxiesType + ", proxiesFormat=" + this.proxiesFormat + ", orderId=" + this.orderId + ", proxyIds=" + this.proxyIds + ", proxyAddress=" + this.proxyAddress + ", cityName=" + this.cityName + ", continentsName=" + this.continentsName + ", proxyStatus=" + this.proxyStatus + ", expiringDays=" + this.expiringDays + ")";
        }
    }
}

