
package com.kylin.kton.api.ipnux.service;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.kylin.kton.api.ipnux.constant.ProxiesType;
import com.kylin.kton.api.ipnux.entity.NodeListRequest;
import com.kylin.kton.api.ipnux.entity.NodeListResponse;
import com.kylin.kton.api.ipnux.properties.IpUnxApiProperties;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class IpNuxApiService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(IpNuxApiService.class);
    private final IpUnxApiProperties ipUnxApiProperties;
    private final RestTemplate restTemplate;

    public NodeListResponse listNode(ProxiesType proxiesType) {
        String url = String.format("%s/V1/OpenApi/OpenApiNodeList", this.ipUnxApiProperties.getBaseUrl());
        NodeListRequest request = NodeListRequest.builder().proxiesType(proxiesType.getCode()).proxiesFormat(proxiesType.getFormat()).build();
        log.info("list node request: {}", (Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]));
        HttpHeaders headers = this.buildHeaders();
        HttpEntity httpEntity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class, new Object[0]);
        return (NodeListResponse)JSONObject.parseObject((String)((String)responseEntity.getBody()), NodeListResponse.class);
    }

    private HttpHeaders buildHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("UserId", this.ipUnxApiProperties.getUserId());
        headers.add("Token", this.ipUnxApiProperties.getToken());
        return headers;
    }

    @Generated
    public IpUnxApiProperties getIpUnxApiProperties() {
        return this.ipUnxApiProperties;
    }

    @Generated
    public RestTemplate getRestTemplate() {
        return this.restTemplate;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof IpNuxApiService)) {
            return false;
        }
        IpNuxApiService other = (IpNuxApiService)o;
        if (!other.canEqual(this)) {
            return false;
        }
        IpUnxApiProperties this$ipUnxApiProperties = this.getIpUnxApiProperties();
        IpUnxApiProperties other$ipUnxApiProperties = other.getIpUnxApiProperties();
        if (this$ipUnxApiProperties == null ? other$ipUnxApiProperties != null : !((Object)this$ipUnxApiProperties).equals(other$ipUnxApiProperties)) {
            return false;
        }
        RestTemplate this$restTemplate = this.getRestTemplate();
        RestTemplate other$restTemplate = other.getRestTemplate();
        return !(this$restTemplate == null ? other$restTemplate != null : !this$restTemplate.equals(other$restTemplate));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof IpNuxApiService;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        IpUnxApiProperties $ipUnxApiProperties = this.getIpUnxApiProperties();
        result = result * 59 + ($ipUnxApiProperties == null ? 43 : ((Object)$ipUnxApiProperties).hashCode());
        RestTemplate $restTemplate = this.getRestTemplate();
        result = result * 59 + ($restTemplate == null ? 43 : $restTemplate.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "IpNuxApiService(ipUnxApiProperties=" + this.getIpUnxApiProperties() + ", restTemplate=" + this.getRestTemplate() + ")";
    }

    @Generated
    public IpNuxApiService(IpUnxApiProperties ipUnxApiProperties, RestTemplate restTemplate) {
        this.ipUnxApiProperties = ipUnxApiProperties;
        this.restTemplate = restTemplate;
    }
}

