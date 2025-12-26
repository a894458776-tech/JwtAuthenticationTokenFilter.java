/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.alibaba.fastjson2.JSONObject
 *  com.alibaba.fastjson2.JSONWriter$Feature
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.http.HttpEntity
 *  org.springframework.http.HttpHeaders
 *  org.springframework.http.HttpMethod
 *  org.springframework.http.MediaType
 *  org.springframework.http.ResponseEntity
 *  org.springframework.stereotype.Component
 *  org.springframework.util.LinkedMultiValueMap
 *  org.springframework.util.MultiValueMap
 *  org.springframework.web.client.RestTemplate
 */
package com.kylin.kton.api.ipidea.service;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.kylin.kton.api.ipidea.entity.IpListRequest;
import com.kylin.kton.api.ipidea.entity.IpListResponse;
import com.kylin.kton.api.ipidea.properties.IpIdeaApiProperties;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class IpIdeaApiService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(IpIdeaApiService.class);
    private final IpIdeaApiProperties ipIdeaApiProperties;
    private final RestTemplate restTemplate;

    public IpListResponse getDataCenterIpList(Integer pageNo, Integer pageSize, Integer accountType) {
        String url = String.format("%s/api/open/datacenter_ip_list", this.ipIdeaApiProperties.getBaseUrl());
        ResponseEntity<String> responseEntity = this.getResponseEntity(pageNo, pageSize, url, accountType);
        return (IpListResponse)JSONObject.parseObject((String)((String)responseEntity.getBody()), IpListResponse.class);
    }

    public IpListResponse getIspIpList(Integer pageNo, Integer pageSize, Integer accountType) {
        String url = String.format("%s/api/open/isp_ip_list", this.ipIdeaApiProperties.getBaseUrl());
        ResponseEntity<String> responseEntity = this.getResponseEntity(pageNo, pageSize, url, accountType);
        return (IpListResponse)JSONObject.parseObject((String)((String)responseEntity.getBody()), IpListResponse.class);
    }

    private ResponseEntity<String> getResponseEntity(Integer pageNo, Integer pageSize, String url, Integer accountType) {
        String appkey = this.getAppKeyByAccountType(accountType);
        IpListRequest request = IpListRequest.builder().page(pageNo).limit(pageSize).appKey(appkey).build();
        log.info("list node request: {}", (Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]));
        HttpHeaders headers = this.buildHeaders();
        LinkedMultiValueMap body = new LinkedMultiValueMap();
        body.add((Object)"page", (Object)request.getPage());
        body.add((Object)"limit", (Object)request.getLimit());
        body.add((Object)"appkey", (Object)request.getAppKey());
        body.add((Object)"status", (Object)request.getStatus());
        HttpEntity httpEntity = new HttpEntity((Object)body, (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class, new Object[0]);
        log.info("responseEntity = {}", (Object)responseEntity);
        return responseEntity;
    }

    private HttpHeaders buildHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        return headers;
    }

    private String getAppKeyByAccountType(Integer accountType) {
        switch (accountType) {
            case 1: {
                return this.ipIdeaApiProperties.getAppkey1();
            }
            case 2: {
                return this.ipIdeaApiProperties.getAppkey2();
            }
        }
        throw new IllegalArgumentException("\u4e0d\u652f\u6301\u7684\u8d26\u53f7\u7c7b\u578b: " + accountType);
    }

    @Generated
    public IpIdeaApiProperties getIpIdeaApiProperties() {
        return this.ipIdeaApiProperties;
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
        if (!(o instanceof IpIdeaApiService)) {
            return false;
        }
        IpIdeaApiService other = (IpIdeaApiService)o;
        if (!other.canEqual(this)) {
            return false;
        }
        IpIdeaApiProperties this$ipIdeaApiProperties = this.getIpIdeaApiProperties();
        IpIdeaApiProperties other$ipIdeaApiProperties = other.getIpIdeaApiProperties();
        if (this$ipIdeaApiProperties == null ? other$ipIdeaApiProperties != null : !((Object)this$ipIdeaApiProperties).equals(other$ipIdeaApiProperties)) {
            return false;
        }
        RestTemplate this$restTemplate = this.getRestTemplate();
        RestTemplate other$restTemplate = other.getRestTemplate();
        return !(this$restTemplate == null ? other$restTemplate != null : !this$restTemplate.equals(other$restTemplate));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof IpIdeaApiService;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        IpIdeaApiProperties $ipIdeaApiProperties = this.getIpIdeaApiProperties();
        result = result * 59 + ($ipIdeaApiProperties == null ? 43 : ((Object)$ipIdeaApiProperties).hashCode());
        RestTemplate $restTemplate = this.getRestTemplate();
        result = result * 59 + ($restTemplate == null ? 43 : $restTemplate.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "IpIdeaApiService(ipIdeaApiProperties=" + this.getIpIdeaApiProperties() + ", restTemplate=" + this.getRestTemplate() + ")";
    }

    @Generated
    public IpIdeaApiService(IpIdeaApiProperties ipIdeaApiProperties, RestTemplate restTemplate) {
        this.ipIdeaApiProperties = ipIdeaApiProperties;
        this.restTemplate = restTemplate;
    }
}

