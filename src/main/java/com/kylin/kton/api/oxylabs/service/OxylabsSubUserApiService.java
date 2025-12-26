/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.alibaba.fastjson2.JSON
 *  com.alibaba.fastjson2.JSONObject
 *  com.alibaba.fastjson2.JSONWriter$Feature
 *  lombok.Generated
 *  org.apache.http.HttpEntity
 *  org.apache.http.client.methods.CloseableHttpResponse
 *  org.apache.http.client.methods.HttpPatch
 *  org.apache.http.client.methods.HttpUriRequest
 *  org.apache.http.entity.StringEntity
 *  org.apache.http.impl.client.CloseableHttpClient
 *  org.apache.http.impl.client.HttpClients
 *  org.apache.http.util.EntityUtils
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.http.HttpEntity
 *  org.springframework.http.HttpHeaders
 *  org.springframework.http.HttpMethod
 *  org.springframework.http.ResponseEntity
 *  org.springframework.stereotype.Service
 *  org.springframework.util.MultiValueMap
 *  org.springframework.web.client.RestTemplate
 */
package com.kylin.kton.api.oxylabs.service;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.kylin.kton.api.oxylabs.entity.ClientStatsResponse;
import com.kylin.kton.api.oxylabs.entity.subuser.SubUserRequest;
import com.kylin.kton.api.oxylabs.entity.subuser.SubUserResponse;
import com.kylin.kton.api.oxylabs.entity.subuser.SubUserResponseItem;
import com.kylin.kton.api.oxylabs.entity.subuser.SubUserTargetStatsResponse;
import com.kylin.kton.api.oxylabs.entity.subuser.SubUserTrafficStatsResponse;
import com.kylin.kton.api.oxylabs.entity.subuser.UpdateSubUserRequest;
import com.kylin.kton.api.oxylabs.entity.subuser.createSubUserResponse;
import com.kylin.kton.api.oxylabs.properties.OxylabsProperties;
import com.kylin.kton.api.oxylabs.service.OxylabsCommonApiService;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import lombok.Generated;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class OxylabsSubUserApiService
extends OxylabsCommonApiService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(OxylabsSubUserApiService.class);
    private final RestTemplate restTemplate;
    private final OxylabsProperties oxylabsProperties;

    public OxylabsSubUserApiService(RestTemplate restTemplate, OxylabsProperties oxylabsProperties) {
        super(restTemplate, oxylabsProperties);
        this.restTemplate = restTemplate;
        this.oxylabsProperties = oxylabsProperties;
    }

    public List<SubUserResponseItem> getSubUsers() {
        String userId = this.getUserId();
        String url = String.format("%s/users/%s/sub-users", this.oxylabsProperties.getApiHost(), userId);
        HttpHeaders headers = this.getJSONHeaders();
        org.springframework.http.HttpEntity entity = new org.springframework.http.HttpEntity((MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return JSON.parseArray((String)responseStr, SubUserResponseItem.class);
    }

    public createSubUserResponse createSubUser(SubUserRequest subUserRequest) {
        String userId = this.getUserId();
        String url = String.format("%s/users/%s/sub-users", this.oxylabsProperties.getApiHost(), userId);
        log.info("url = " + url);
        log.info("userId = " + userId);
        HttpHeaders headers = this.getJSONHeaders();
        log.info("createSubUser headers = {}", (Object)headers);
        org.springframework.http.HttpEntity entity = new org.springframework.http.HttpEntity((Object)JSONObject.toJSONString((Object)subUserRequest, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (createSubUserResponse)JSONObject.parseObject((String)responseStr, createSubUserResponse.class);
    }

    public SubUserTrafficStatsResponse getSubUserTrafficStats(Integer subUserId, String type) {
        String userId = this.getUserId();
        String url = String.format("%s/users/%s/sub-users/%s/traffic-stats?type=%s", this.oxylabsProperties.getApiHost(), userId, subUserId, type);
        HttpHeaders headers = this.getJSONHeaders();
        org.springframework.http.HttpEntity entity = new org.springframework.http.HttpEntity((MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (SubUserTrafficStatsResponse)JSONObject.parseObject((String)responseStr, SubUserTrafficStatsResponse.class);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public SubUserResponse updateSubUser(Integer subUserId, UpdateSubUserRequest updateSubUserRequest) {
        String userId = this.getUserId();
        String apiUrl = this.oxylabsProperties.getApiHost();
        String url = String.format("%s/users/%s/sub-users/%s", apiUrl, userId, subUserId);
        try (CloseableHttpClient httpClient = HttpClients.createDefault();){
            HttpPatch httpPatch = new HttpPatch(url);
            httpPatch.setHeader("Content-Type", "application/json");
            httpPatch.setHeader("Authorization", String.format("Bearer %s", this.getToken()));
            httpPatch.setEntity((HttpEntity)new StringEntity(JSONObject.toJSONString((Object)updateSubUserRequest, (JSONWriter.Feature[])new JSONWriter.Feature[0]), StandardCharsets.UTF_8));
            CloseableHttpResponse response = httpClient.execute((HttpUriRequest)httpPatch);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode < 200) throw new RuntimeException("Request failed with status code: " + statusCode);
            if (statusCode >= 300) throw new RuntimeException("Request failed with status code: " + statusCode);
            if (statusCode == 200) {
                String responseStr = EntityUtils.toString((HttpEntity)response.getEntity(), (Charset)StandardCharsets.UTF_8);
                SubUserResponse subUserResponse = (SubUserResponse)JSONObject.parseObject((String)responseStr, SubUserResponse.class);
                return subUserResponse;
            }
            if (statusCode == 201) {
                String responseStr = EntityUtils.toString((HttpEntity)response.getEntity(), (Charset)StandardCharsets.UTF_8);
                SubUserResponse subUserResponse = (SubUserResponse)JSONObject.parseObject((String)responseStr, SubUserResponse.class);
                return subUserResponse;
            }
            String errorResponse = EntityUtils.toString((HttpEntity)response.getEntity(), (Charset)StandardCharsets.UTF_8);
            log.error("Request failed with status code: {} - Response: {}", (Object)statusCode, (Object)errorResponse);
            throw new RuntimeException("Request failed with status code: " + statusCode + " - " + errorResponse);
        }
        catch (Exception e) {
            log.error("Request failed: {}", (Object)e.getMessage(), (Object)e);
            throw new RuntimeException("Request failed: " + e.getMessage(), e);
        }
    }

    public void deleteSubUser(Integer subUserId) {
        String userId = this.getUserId();
        String url = String.format("%s/users/%s/sub-users/%s", this.oxylabsProperties.getApiHost(), userId, subUserId);
        HttpHeaders headers = this.getJSONHeaders();
        org.springframework.http.HttpEntity entity = new org.springframework.http.HttpEntity((MultiValueMap)headers);
        this.restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class, new Object[0]);
    }

    public SubUserTargetStatsResponse getSubUserTargetStats(Integer subUserId, String date) {
        String userId = this.getUserId();
        String url = String.format("%s/users/%s/sub-users/%s/target-stats?date=%s", this.oxylabsProperties.getApiHost(), userId, subUserId, date);
        HttpHeaders headers = this.getJSONHeaders();
        org.springframework.http.HttpEntity entity = new org.springframework.http.HttpEntity((MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (SubUserTargetStatsResponse)JSONObject.parseObject((String)responseStr, SubUserTargetStatsResponse.class);
    }

    public ClientStatsResponse getClientStats() {
        String userId = this.getUserId();
        String url = String.format("%s/users/%s/client-stats", this.oxylabsProperties.getApiHost(), userId);
        HttpHeaders headers = this.getJSONHeaders();
        org.springframework.http.HttpEntity entity = new org.springframework.http.HttpEntity((MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (ClientStatsResponse)JSONObject.parseObject((String)responseStr, ClientStatsResponse.class);
    }

    public static void main(String[] args) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            OxylabsProperties oxylabsProperties = new OxylabsProperties();
            oxylabsProperties.setApiHost("https://residential-api.oxylabs.io/v1");
            oxylabsProperties.setAccount("testuser_EAxSw");
            oxylabsProperties.setPassword("sKwY2dQ5=WMuU");
            OxylabsSubUserApiService oxylabsSubUserApiService = new OxylabsSubUserApiService(restTemplate, oxylabsProperties);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

