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
 *  org.springframework.http.ResponseEntity
 *  org.springframework.stereotype.Service
 *  org.springframework.util.MultiValueMap
 *  org.springframework.web.client.RestTemplate
 */
package com.kylin.kton.api.netnut.service;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.kylin.kton.api.netnut.entity.subuser.AddSubUserRequest;
import com.kylin.kton.api.netnut.entity.subuser.AddSubUserResponse;
import com.kylin.kton.api.netnut.entity.subuser.AllocateGBRequest;
import com.kylin.kton.api.netnut.entity.subuser.AllocateGBResponse;
import com.kylin.kton.api.netnut.entity.subuser.AllocateIPsRequest;
import com.kylin.kton.api.netnut.entity.subuser.AllocateIPsResponse;
import com.kylin.kton.api.netnut.entity.subuser.CustomerPlansRequest;
import com.kylin.kton.api.netnut.entity.subuser.CustomerPlansResponse;
import com.kylin.kton.api.netnut.entity.subuser.DataUsageRequest;
import com.kylin.kton.api.netnut.entity.subuser.DataUsageResponse;
import com.kylin.kton.api.netnut.entity.subuser.DisableSubUserRequest;
import com.kylin.kton.api.netnut.entity.subuser.DisableSubUserResponse;
import com.kylin.kton.api.netnut.entity.subuser.MyPackageUsageRequest;
import com.kylin.kton.api.netnut.entity.subuser.MyPackageUsageResponse;
import com.kylin.kton.api.netnut.entity.subuser.SubUserInfoResponse;
import com.kylin.kton.api.netnut.entity.subuser.SubUserListRequest;
import com.kylin.kton.api.netnut.entity.subuser.SubUserListResponse;
import com.kylin.kton.api.netnut.entity.subuser.SubUserRequest;
import com.kylin.kton.api.netnut.entity.subuser.TrafficAvailableCountriesMobRequest;
import com.kylin.kton.api.netnut.entity.subuser.TrafficAvailableCountriesMobResponse;
import com.kylin.kton.api.netnut.entity.subuser.TrafficAvailableCountriesRequest;
import com.kylin.kton.api.netnut.entity.subuser.TrafficAvailableCountriesResponse;
import com.kylin.kton.api.netnut.entity.subuser.TrafficCityAndStateRequest;
import com.kylin.kton.api.netnut.entity.subuser.TrafficCityAndStateResponse;
import com.kylin.kton.api.netnut.entity.subuser.TrafficUsageRequest;
import com.kylin.kton.api.netnut.entity.subuser.TrafficUsageResponse;
import com.kylin.kton.api.netnut.entity.subuser.UpdateSubUserPasswordRequest;
import com.kylin.kton.api.netnut.entity.subuser.UpdateSubUserPasswordResponse;
import com.kylin.kton.api.netnut.properties.NetnutProperties;
import com.kylin.kton.api.netnut.service.NetnutCommonApiService;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class NetnutSubUserApiService
extends NetnutCommonApiService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(NetnutSubUserApiService.class);
    private final RestTemplate restTemplate;
    private final NetnutProperties netnutProperties;

    public NetnutSubUserApiService(RestTemplate restTemplate, NetnutProperties dataimpulseProperties) {
        super(restTemplate, dataimpulseProperties);
        this.restTemplate = restTemplate;
        this.netnutProperties = dataimpulseProperties;
    }

    public TrafficCityAndStateResponse getTrafficCityAndState(TrafficCityAndStateRequest request) {
        String url = String.format("%s/customer/traffic/city-and-state", this.netnutProperties.getApiHost());
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        log.info("Response: " + responseStr);
        return (TrafficCityAndStateResponse)JSONObject.parseObject((String)responseStr, TrafficCityAndStateResponse.class);
    }

    public TrafficAvailableCountriesMobResponse getTrafficAvailableCountriesMob(TrafficAvailableCountriesMobRequest request) {
        String url = String.format("%s/customer/traffic/available-countries-mob", this.netnutProperties.getApiHost());
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        log.info("Response: " + responseStr);
        return (TrafficAvailableCountriesMobResponse)JSONObject.parseObject((String)responseStr, TrafficAvailableCountriesMobResponse.class);
    }

    public TrafficAvailableCountriesResponse getTrafficAvailableCountries(TrafficAvailableCountriesRequest request) {
        String url = String.format("%s/customer/traffic/available-countries", this.netnutProperties.getApiHost());
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        log.info("Response: " + responseStr);
        return (TrafficAvailableCountriesResponse)JSONObject.parseObject((String)responseStr, TrafficAvailableCountriesResponse.class);
    }

    public TrafficUsageResponse getTrafficUsage(TrafficUsageRequest request) {
        String url = String.format("%s/customer/traffic/", this.netnutProperties.getApiHost());
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        log.info("Response: " + responseStr);
        return (TrafficUsageResponse)JSONObject.parseObject((String)responseStr, TrafficUsageResponse.class);
    }

    public DataUsageResponse getDataUsage(DataUsageRequest request) {
        String url = String.format("%s/customer/usage/", this.netnutProperties.getApiHost());
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        log.info("Response: " + responseStr);
        return (DataUsageResponse)JSONObject.parseObject((String)responseStr, DataUsageResponse.class);
    }

    public MyPackageUsageResponse getMyPackageUsage(MyPackageUsageRequest request) {
        String url = String.format("%s/customer/usage/myusage", this.netnutProperties.getApiHost());
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        log.info("Response: " + responseStr);
        return (MyPackageUsageResponse)JSONObject.parseObject((String)responseStr, MyPackageUsageResponse.class);
    }

    public CustomerPlansResponse getCustomerPlans(String id, CustomerPlansRequest request) {
        String url = String.format("%s/customer/usage/%s", this.netnutProperties.getApiHost(), id);
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        log.info("Response: " + responseStr);
        return (CustomerPlansResponse)JSONObject.parseObject((String)responseStr, CustomerPlansResponse.class);
    }

    public SubUserInfoResponse getSubUserById(String id, SubUserRequest request) {
        String url = String.format("%s/customer/sub-user/%s", this.netnutProperties.getApiHost(), id);
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        log.info("Response: " + responseStr);
        return (SubUserInfoResponse)JSONObject.parseObject((String)responseStr, SubUserInfoResponse.class);
    }

    public UpdateSubUserPasswordResponse updateSubUserPassword(String id, UpdateSubUserPasswordRequest request) {
        String url = String.format("%s/customer/sub-user/%s/password", this.netnutProperties.getApiHost(), id);
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.PATCH, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        log.info("Response: " + responseStr);
        return (UpdateSubUserPasswordResponse)JSONObject.parseObject((String)responseStr, UpdateSubUserPasswordResponse.class);
    }

    public SubUserListResponse getSubUserList(SubUserListRequest request) {
        String url = String.format("%s/customer/sub-user/", this.netnutProperties.getApiHost());
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        log.info("Response: " + responseStr);
        return (SubUserListResponse)JSONObject.parseObject((String)responseStr, SubUserListResponse.class);
    }

    public AddSubUserResponse addSubUser(AddSubUserRequest request) {
        String url = String.format("%s/customer/sub-user/", this.netnutProperties.getApiHost());
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        log.info("Response: " + responseStr);
        return (AddSubUserResponse)JSONObject.parseObject((String)responseStr, AddSubUserResponse.class);
    }

    public AllocateGBResponse allocateGBToSubUser(String id, AllocateGBRequest request) {
        String url = String.format("%s/customer/sub-user/%s/allocate", this.netnutProperties.getApiHost(), id);
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        log.info("Response: " + responseStr);
        return (AllocateGBResponse)JSONObject.parseObject((String)responseStr, AllocateGBResponse.class);
    }

    public AllocateIPsResponse allocateIPsToSubUser(String id, AllocateIPsRequest request) {
        String url = String.format("%s/customer/sub-user/%s/allocateips", this.netnutProperties.getApiHost(), id);
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        log.info("Response: " + responseStr);
        return (AllocateIPsResponse)JSONObject.parseObject((String)responseStr, AllocateIPsResponse.class);
    }

    public DisableSubUserResponse disableSubUser(String id, DisableSubUserRequest request) {
        String url = String.format("%s/customer/sub-user/%s/disabled", this.netnutProperties.getApiHost(), id);
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.PUT, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        log.info("Response: " + responseStr);
        return (DisableSubUserResponse)JSONObject.parseObject((String)responseStr, DisableSubUserResponse.class);
    }
}

