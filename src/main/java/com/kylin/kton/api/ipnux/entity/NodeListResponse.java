/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.ipnux.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kylin.kton.api.ipnux.entity.BaseResponse;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Generated;

public class NodeListResponse
extends BaseResponse
implements Serializable {
    @JsonProperty(value="Data")
    private NodeData data;

    @Override
    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof NodeListResponse)) {
            return false;
        }
        NodeListResponse other = (NodeListResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        NodeData this$data = this.getData();
        NodeData other$data = other.getData();
        return !(this$data == null ? other$data != null : !((Object)this$data).equals(other$data));
    }

    @Override
    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof NodeListResponse;
    }

    @Override
    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = super.hashCode();
        NodeData $data = this.getData();
        result = result * 59 + ($data == null ? 43 : ((Object)$data).hashCode());
        return result;
    }

    @Generated
    public NodeListResponse() {
    }

    @Generated
    public NodeData getData() {
        return this.data;
    }

    @JsonProperty(value="Data")
    @Generated
    public void setData(NodeData data) {
        this.data = data;
    }

    @Override
    @Generated
    public String toString() {
        return "NodeListResponse(data=" + this.getData() + ")";
    }

    public static class NodeData
    implements Serializable {
        private Integer count;
        @JsonProperty(value="proxies_type")
        private String proxiesType;
        @JsonProperty(value="proxies_format")
        private Integer proxiesFormat;
        private List<Result> results;

        @Generated
        public NodeData() {
        }

        @Generated
        public Integer getCount() {
            return this.count;
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
        public List<Result> getResults() {
            return this.results;
        }

        @Generated
        public void setCount(Integer count) {
            this.count = count;
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

        @Generated
        public void setResults(List<Result> results) {
            this.results = results;
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
            Integer this$count = this.getCount();
            Integer other$count = other.getCount();
            if (this$count == null ? other$count != null : !((Object)this$count).equals(other$count)) {
                return false;
            }
            Integer this$proxiesFormat = this.getProxiesFormat();
            Integer other$proxiesFormat = other.getProxiesFormat();
            if (this$proxiesFormat == null ? other$proxiesFormat != null : !((Object)this$proxiesFormat).equals(other$proxiesFormat)) {
                return false;
            }
            String this$proxiesType = this.getProxiesType();
            String other$proxiesType = other.getProxiesType();
            if (this$proxiesType == null ? other$proxiesType != null : !this$proxiesType.equals(other$proxiesType)) {
                return false;
            }
            List<Result> this$results = this.getResults();
            List<Result> other$results = other.getResults();
            return !(this$results == null ? other$results != null : !((Object)this$results).equals(other$results));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof NodeData;
        }

        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            Integer $count = this.getCount();
            result = result * 59 + ($count == null ? 43 : ((Object)$count).hashCode());
            Integer $proxiesFormat = this.getProxiesFormat();
            result = result * 59 + ($proxiesFormat == null ? 43 : ((Object)$proxiesFormat).hashCode());
            String $proxiesType = this.getProxiesType();
            result = result * 59 + ($proxiesType == null ? 43 : $proxiesType.hashCode());
            List<Result> $results = this.getResults();
            result = result * 59 + ($results == null ? 43 : ((Object)$results).hashCode());
            return result;
        }

        @Generated
        public String toString() {
            return "NodeListResponse.NodeData(count=" + this.getCount() + ", proxiesType=" + this.getProxiesType() + ", proxiesFormat=" + this.getProxiesFormat() + ", results=" + this.getResults() + ")";
        }
    }

    public static class Result
    implements Serializable {
        @JsonProperty(value="proxy_id")
        private Long proxyId;
        @JsonProperty(value="username")
        private String userName;
        private String password;
        @JsonProperty(value="proxy_address")
        private String proxyAddress;
        private Integer port;
        private Integer protocols;
        @JsonProperty(value="proxy_status")
        private Integer proxyStatus;
        @JsonProperty(value="continents_id")
        private Long continentsId;
        @JsonProperty(value="continents_name")
        private String continentsName;
        @JsonProperty(value="country_code")
        private String countryCode;
        @JsonProperty(value="city_id")
        private Integer cityId;
        @JsonProperty(value="city_name")
        private String cityName;
        @JsonProperty(value="created_at")
        private LocalDateTime createdAt;
        @JsonProperty(value="expired_at")
        private LocalDateTime expiredAt;
        @JsonProperty(value="udp_status")
        private Boolean udpStatus;

        @Generated
        public Result() {
        }

        @Generated
        public Long getProxyId() {
            return this.proxyId;
        }

        @Generated
        public String getUserName() {
            return this.userName;
        }

        @Generated
        public String getPassword() {
            return this.password;
        }

        @Generated
        public String getProxyAddress() {
            return this.proxyAddress;
        }

        @Generated
        public Integer getPort() {
            return this.port;
        }

        @Generated
        public Integer getProtocols() {
            return this.protocols;
        }

        @Generated
        public Integer getProxyStatus() {
            return this.proxyStatus;
        }

        @Generated
        public Long getContinentsId() {
            return this.continentsId;
        }

        @Generated
        public String getContinentsName() {
            return this.continentsName;
        }

        @Generated
        public String getCountryCode() {
            return this.countryCode;
        }

        @Generated
        public Integer getCityId() {
            return this.cityId;
        }

        @Generated
        public String getCityName() {
            return this.cityName;
        }

        @Generated
        public LocalDateTime getCreatedAt() {
            return this.createdAt;
        }

        @Generated
        public LocalDateTime getExpiredAt() {
            return this.expiredAt;
        }

        @Generated
        public Boolean getUdpStatus() {
            return this.udpStatus;
        }

        @JsonProperty(value="proxy_id")
        @Generated
        public void setProxyId(Long proxyId) {
            this.proxyId = proxyId;
        }

        @JsonProperty(value="username")
        @Generated
        public void setUserName(String userName) {
            this.userName = userName;
        }

        @Generated
        public void setPassword(String password) {
            this.password = password;
        }

        @JsonProperty(value="proxy_address")
        @Generated
        public void setProxyAddress(String proxyAddress) {
            this.proxyAddress = proxyAddress;
        }

        @Generated
        public void setPort(Integer port) {
            this.port = port;
        }

        @Generated
        public void setProtocols(Integer protocols) {
            this.protocols = protocols;
        }

        @JsonProperty(value="proxy_status")
        @Generated
        public void setProxyStatus(Integer proxyStatus) {
            this.proxyStatus = proxyStatus;
        }

        @JsonProperty(value="continents_id")
        @Generated
        public void setContinentsId(Long continentsId) {
            this.continentsId = continentsId;
        }

        @JsonProperty(value="continents_name")
        @Generated
        public void setContinentsName(String continentsName) {
            this.continentsName = continentsName;
        }

        @JsonProperty(value="country_code")
        @Generated
        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        @JsonProperty(value="city_id")
        @Generated
        public void setCityId(Integer cityId) {
            this.cityId = cityId;
        }

        @JsonProperty(value="city_name")
        @Generated
        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        @JsonProperty(value="created_at")
        @Generated
        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }

        @JsonProperty(value="expired_at")
        @Generated
        public void setExpiredAt(LocalDateTime expiredAt) {
            this.expiredAt = expiredAt;
        }

        @JsonProperty(value="udp_status")
        @Generated
        public void setUdpStatus(Boolean udpStatus) {
            this.udpStatus = udpStatus;
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
            Long this$proxyId = this.getProxyId();
            Long other$proxyId = other.getProxyId();
            if (this$proxyId == null ? other$proxyId != null : !((Object)this$proxyId).equals(other$proxyId)) {
                return false;
            }
            Integer this$port = this.getPort();
            Integer other$port = other.getPort();
            if (this$port == null ? other$port != null : !((Object)this$port).equals(other$port)) {
                return false;
            }
            Integer this$protocols = this.getProtocols();
            Integer other$protocols = other.getProtocols();
            if (this$protocols == null ? other$protocols != null : !((Object)this$protocols).equals(other$protocols)) {
                return false;
            }
            Integer this$proxyStatus = this.getProxyStatus();
            Integer other$proxyStatus = other.getProxyStatus();
            if (this$proxyStatus == null ? other$proxyStatus != null : !((Object)this$proxyStatus).equals(other$proxyStatus)) {
                return false;
            }
            Long this$continentsId = this.getContinentsId();
            Long other$continentsId = other.getContinentsId();
            if (this$continentsId == null ? other$continentsId != null : !((Object)this$continentsId).equals(other$continentsId)) {
                return false;
            }
            Integer this$cityId = this.getCityId();
            Integer other$cityId = other.getCityId();
            if (this$cityId == null ? other$cityId != null : !((Object)this$cityId).equals(other$cityId)) {
                return false;
            }
            Boolean this$udpStatus = this.getUdpStatus();
            Boolean other$udpStatus = other.getUdpStatus();
            if (this$udpStatus == null ? other$udpStatus != null : !((Object)this$udpStatus).equals(other$udpStatus)) {
                return false;
            }
            String this$userName = this.getUserName();
            String other$userName = other.getUserName();
            if (this$userName == null ? other$userName != null : !this$userName.equals(other$userName)) {
                return false;
            }
            String this$password = this.getPassword();
            String other$password = other.getPassword();
            if (this$password == null ? other$password != null : !this$password.equals(other$password)) {
                return false;
            }
            String this$proxyAddress = this.getProxyAddress();
            String other$proxyAddress = other.getProxyAddress();
            if (this$proxyAddress == null ? other$proxyAddress != null : !this$proxyAddress.equals(other$proxyAddress)) {
                return false;
            }
            String this$continentsName = this.getContinentsName();
            String other$continentsName = other.getContinentsName();
            if (this$continentsName == null ? other$continentsName != null : !this$continentsName.equals(other$continentsName)) {
                return false;
            }
            String this$countryCode = this.getCountryCode();
            String other$countryCode = other.getCountryCode();
            if (this$countryCode == null ? other$countryCode != null : !this$countryCode.equals(other$countryCode)) {
                return false;
            }
            String this$cityName = this.getCityName();
            String other$cityName = other.getCityName();
            if (this$cityName == null ? other$cityName != null : !this$cityName.equals(other$cityName)) {
                return false;
            }
            LocalDateTime this$createdAt = this.getCreatedAt();
            LocalDateTime other$createdAt = other.getCreatedAt();
            if (this$createdAt == null ? other$createdAt != null : !((Object)this$createdAt).equals(other$createdAt)) {
                return false;
            }
            LocalDateTime this$expiredAt = this.getExpiredAt();
            LocalDateTime other$expiredAt = other.getExpiredAt();
            return !(this$expiredAt == null ? other$expiredAt != null : !((Object)this$expiredAt).equals(other$expiredAt));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof Result;
        }

        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            Long $proxyId = this.getProxyId();
            result = result * 59 + ($proxyId == null ? 43 : ((Object)$proxyId).hashCode());
            Integer $port = this.getPort();
            result = result * 59 + ($port == null ? 43 : ((Object)$port).hashCode());
            Integer $protocols = this.getProtocols();
            result = result * 59 + ($protocols == null ? 43 : ((Object)$protocols).hashCode());
            Integer $proxyStatus = this.getProxyStatus();
            result = result * 59 + ($proxyStatus == null ? 43 : ((Object)$proxyStatus).hashCode());
            Long $continentsId = this.getContinentsId();
            result = result * 59 + ($continentsId == null ? 43 : ((Object)$continentsId).hashCode());
            Integer $cityId = this.getCityId();
            result = result * 59 + ($cityId == null ? 43 : ((Object)$cityId).hashCode());
            Boolean $udpStatus = this.getUdpStatus();
            result = result * 59 + ($udpStatus == null ? 43 : ((Object)$udpStatus).hashCode());
            String $userName = this.getUserName();
            result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
            String $password = this.getPassword();
            result = result * 59 + ($password == null ? 43 : $password.hashCode());
            String $proxyAddress = this.getProxyAddress();
            result = result * 59 + ($proxyAddress == null ? 43 : $proxyAddress.hashCode());
            String $continentsName = this.getContinentsName();
            result = result * 59 + ($continentsName == null ? 43 : $continentsName.hashCode());
            String $countryCode = this.getCountryCode();
            result = result * 59 + ($countryCode == null ? 43 : $countryCode.hashCode());
            String $cityName = this.getCityName();
            result = result * 59 + ($cityName == null ? 43 : $cityName.hashCode());
            LocalDateTime $createdAt = this.getCreatedAt();
            result = result * 59 + ($createdAt == null ? 43 : ((Object)$createdAt).hashCode());
            LocalDateTime $expiredAt = this.getExpiredAt();
            result = result * 59 + ($expiredAt == null ? 43 : ((Object)$expiredAt).hashCode());
            return result;
        }

        @Generated
        public String toString() {
            return "NodeListResponse.Result(proxyId=" + this.getProxyId() + ", userName=" + this.getUserName() + ", password=" + this.getPassword() + ", proxyAddress=" + this.getProxyAddress() + ", port=" + this.getPort() + ", protocols=" + this.getProtocols() + ", proxyStatus=" + this.getProxyStatus() + ", continentsId=" + this.getContinentsId() + ", continentsName=" + this.getContinentsName() + ", countryCode=" + this.getCountryCode() + ", cityId=" + this.getCityId() + ", cityName=" + this.getCityName() + ", createdAt=" + this.getCreatedAt() + ", expiredAt=" + this.getExpiredAt() + ", udpStatus=" + this.getUdpStatus() + ")";
        }
    }
}

