/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.alibaba.fastjson2.JSONArray
 *  com.alibaba.fastjson2.JSONObject
 *  com.alibaba.fastjson2.JSONWriter$Feature
 *  com.kylin.kton.common.utils.StringUtils
 *  javax.annotation.PostConstruct
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.http.HttpEntity
 *  org.springframework.http.HttpHeaders
 *  org.springframework.http.HttpMethod
 *  org.springframework.http.MediaType
 *  org.springframework.http.ResponseEntity
 *  org.springframework.stereotype.Service
 *  org.springframework.util.MultiValueMap
 *  org.springframework.web.client.RestTemplate
 */
package com.kylin.kton.api.dataimpulse.service;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.kylin.kton.api.dataimpulse.constant.PoolType;
import com.kylin.kton.api.dataimpulse.entity.common.AsnsRequest;
import com.kylin.kton.api.dataimpulse.entity.common.AsnsResponse;
import com.kylin.kton.api.dataimpulse.entity.common.CitiesRequest;
import com.kylin.kton.api.dataimpulse.entity.common.CitiesResponse;
import com.kylin.kton.api.dataimpulse.entity.common.Country;
import com.kylin.kton.api.dataimpulse.entity.common.CountryResponse;
import com.kylin.kton.api.dataimpulse.entity.common.Item;
import com.kylin.kton.api.dataimpulse.entity.common.LocationsResponse;
import com.kylin.kton.api.dataimpulse.entity.common.PoolStatsResponse;
import com.kylin.kton.api.dataimpulse.entity.common.StatesRequest;
import com.kylin.kton.api.dataimpulse.entity.common.StatesResponse;
import com.kylin.kton.api.dataimpulse.entity.common.ZipCodesRequest;
import com.kylin.kton.api.dataimpulse.entity.common.ZipCodesResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetLocationsAsnsRequset;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetLocationsAsnsResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetLocationsCitiesRequset;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetLocationsCitiesResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetLocationsCountriesResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetLocationsStatesRequset;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetLocationsStatesResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetLocationsZipcodesRequset;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetLocationsZipcodesResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetlocationsCountriesRequset;
import com.kylin.kton.api.dataimpulse.entity.subuser.TokenRequest;
import com.kylin.kton.api.dataimpulse.entity.subuser.TokenResponse;
import com.kylin.kton.api.dataimpulse.properties.DataimpulseProperties;
import com.kylin.kton.api.dataimpulse.utils.TokenCacheUtils;
import com.kylin.kton.common.utils.StringUtils;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.PostConstruct;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class DataImpulseCommonApiService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(DataImpulseCommonApiService.class);
    private final RestTemplate restTemplate;
    private final DataimpulseProperties dataimpulseProperties;
    private Lock lock = new ReentrantLock();

    public DataImpulseCommonApiService(RestTemplate restTemplate, DataimpulseProperties dataimpulseProperties) {
        this.restTemplate = restTemplate;
        this.dataimpulseProperties = dataimpulseProperties;
    }

    @PostConstruct
    public void initToken() {
        try {
            this.lock.tryLock(3L, TimeUnit.SECONDS);
            this.getToken();
        }
        catch (Exception e) {
            log.error(e.getMessage(), (Throwable)e);
        }
        finally {
            this.lock.unlock();
        }
    }

    public String getToken() {
        String token = TokenCacheUtils.getToken();
        if (StringUtils.isNotBlank((CharSequence)token)) {
            return token;
        }
        log.info("init dataimpulse token...");
        TokenResponse tokenResponse = this.createToken();
        if (Objects.nonNull(tokenResponse) && StringUtils.isNotBlank((CharSequence)tokenResponse.getToken())) {
            TokenCacheUtils.registry(tokenResponse.getToken());
        }
        return TokenCacheUtils.getToken();
    }

    private TokenResponse createToken() {
        TokenRequest tokenRequest = TokenRequest.builder().login(this.dataimpulseProperties.getAccount()).password(this.dataimpulseProperties.getPassword()).build();
        String url = String.format("%s/reseller/user/token/get", this.dataimpulseProperties.getApiHost());
        ResponseEntity responseEntity = this.restTemplate.postForEntity(url, (Object)tokenRequest, TokenResponse.class, new Object[0]);
        return (TokenResponse)responseEntity.getBody();
    }

    public LocationsResponse getLocations(PoolType poolType) {
        String url = String.format("%s/reseller/common/locations?pool_type=%s", this.dataimpulseProperties.getApiHost(), poolType.getCode());
        HttpHeaders headers = this.getDefaultHeaders();
        HttpEntity entity = new HttpEntity((MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        List countries = JSONArray.parseArray((String)responseStr, Country.class);
        return LocationsResponse.builder().countries(countries).build();
    }

    public PoolStatsResponse getPoolStats(PoolType poolType) {
        String url = String.format("%s/reseller/common/pool_stats?pool_type=%s", this.dataimpulseProperties.getApiHost(), poolType.getCode());
        HttpHeaders headers = this.getDefaultHeaders();
        HttpEntity entity = new HttpEntity((MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        List poolStats = JSONArray.parseArray((String)responseStr, PoolStatsResponse.PoolStats.class);
        return PoolStatsResponse.builder().poolStats(poolStats).build();
    }

    public CountryResponse getCountries(PoolType poolType) {
        String url = String.format("%s/reseller/common/locations/countries", this.dataimpulseProperties.getApiHost());
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        List countries = JSONArray.parseArray((String)responseStr, Item.class);
        return CountryResponse.builder().countries(countries).build();
    }

    public StatesResponse getStates(StatesRequest request) {
        String url = String.format("%s/reseller/common/locations/states", this.dataimpulseProperties.getApiHost());
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        List states = JSONArray.parseArray((String)responseStr, Item.class);
        return StatesResponse.builder().states(states).build();
    }

    public CitiesResponse getCities(CitiesRequest request) {
        String url = String.format("%s/reseller/common/locations/cities", this.dataimpulseProperties.getApiHost());
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        List cities = JSONArray.parseArray((String)responseStr, Item.class);
        return CitiesResponse.builder().cities(cities).build();
    }

    public ZipCodesResponse getZipCodes(ZipCodesRequest request) {
        String url = String.format("%s/reseller/common/locations/zipcodes", this.dataimpulseProperties.getApiHost());
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        List zipCodes = JSONArray.parseArray((String)responseStr, Item.class);
        return ZipCodesResponse.builder().zipCodes(zipCodes).build();
    }

    public AsnsResponse getAsns(AsnsRequest request) {
        String url = String.format("%s/reseller/common/locations/asns", this.dataimpulseProperties.getApiHost());
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        List zipCodes = JSONArray.parseArray((String)responseStr, Item.class);
        return AsnsResponse.builder().asns(zipCodes).build();
    }

    public SetLocationsCountriesResponse setlocationsCountries(String poolType, String orderBy) {
        String url = String.format("%s/reseller/common/locations/countries", this.dataimpulseProperties.getApiHost());
        SetlocationsCountriesRequset request = SetlocationsCountriesRequset.builder().poolType(poolType).orderBy(orderBy).build();
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (SetLocationsCountriesResponse)JSONObject.parseObject((String)responseStr, SetLocationsCountriesResponse.class);
    }

    public SetLocationsStatesResponse setlocationsStates(String poolType, List<String> countries, List<String> states) {
        String url = String.format("%s/reseller/common/locations/states", this.dataimpulseProperties.getApiHost());
        SetLocationsStatesRequset request = SetLocationsStatesRequset.builder().poolType(poolType).countries(countries).states(states).build();
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (SetLocationsStatesResponse)JSONObject.parseObject((String)responseStr, SetLocationsStatesResponse.class);
    }

    public SetLocationsCitiesResponse setlocationCities(String poolType, List<String> countries, List<String> cities) {
        String url = String.format("%s/reseller/common/locations/cities", this.dataimpulseProperties.getApiHost());
        SetLocationsCitiesRequset request = SetLocationsCitiesRequset.builder().poolType(poolType).countries(countries).cities(cities).build();
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (SetLocationsCitiesResponse)JSONObject.parseObject((String)responseStr, SetLocationsCitiesResponse.class);
    }

    public SetLocationsZipcodesResponse setlocationZipcodes(String poolType, List<String> countries, List<String> zipcodes) {
        String url = String.format("%s/reseller/common/locations/zipcodes", this.dataimpulseProperties.getApiHost());
        SetLocationsZipcodesRequset request = SetLocationsZipcodesRequset.builder().poolType(poolType).countries(countries).zipcodes(zipcodes).build();
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (SetLocationsZipcodesResponse)JSONObject.parseObject((String)responseStr, SetLocationsZipcodesResponse.class);
    }

    public SetLocationsAsnsResponse setlocationZipAsns(String poolType, List<String> countries, List<String> asns) {
        String url = String.format("%s/reseller/common/locations/asns", this.dataimpulseProperties.getApiHost());
        SetLocationsAsnsRequset request = SetLocationsAsnsRequset.builder().poolType(poolType).countries(countries).asns(asns).build();
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (SetLocationsAsnsResponse)JSONObject.parseObject((String)responseStr, SetLocationsAsnsResponse.class);
    }

    protected HttpHeaders getDefaultHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("authorization", String.format("Bearer %s", this.getToken()));
        log.info("getDefaultHeaders headers = {}", (Object)headers);
        return headers;
    }

    protected HttpHeaders getJSONHeaders() {
        HttpHeaders headers = this.getDefaultHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}

