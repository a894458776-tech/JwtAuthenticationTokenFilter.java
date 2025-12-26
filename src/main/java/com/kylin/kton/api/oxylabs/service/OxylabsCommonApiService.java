/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.utils.StringUtils
 *  javax.annotation.PostConstruct
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.http.HttpEntity
 *  org.springframework.http.HttpHeaders
 *  org.springframework.http.MediaType
 *  org.springframework.http.ResponseEntity
 *  org.springframework.stereotype.Service
 *  org.springframework.util.MultiValueMap
 *  org.springframework.web.client.RestTemplate
 */
package com.kylin.kton.api.oxylabs.service;

import com.kylin.kton.api.oxylabs.entity.subuser.TokenResponse;
import com.kylin.kton.api.oxylabs.properties.OxylabsProperties;
import com.kylin.kton.api.oxylabs.utils.TokenCacheUtils;
import com.kylin.kton.common.utils.StringUtils;
import java.util.Arrays;
import java.util.Base64;
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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class OxylabsCommonApiService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(OxylabsCommonApiService.class);
    private final RestTemplate restTemplate;
    private final OxylabsProperties oxylabsProperties;
    private Lock lock = new ReentrantLock();

    public OxylabsCommonApiService(RestTemplate restTemplate, OxylabsProperties oxylabsProperties) {
        this.restTemplate = restTemplate;
        this.oxylabsProperties = oxylabsProperties;
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
        log.info("init oxylabs token...");
        TokenResponse tokenResponse = this.createToken();
        if (Objects.nonNull(tokenResponse) && StringUtils.isNotBlank((CharSequence)tokenResponse.getToken())) {
            log.info("tokenResponse  token = " + tokenResponse.getToken());
            log.info("tokenResponse  userId = " + tokenResponse.getUserId());
            TokenCacheUtils.registry(tokenResponse.getToken());
            log.info("tokenResponse TokenCacheUtils token = " + TokenCacheUtils.getToken());
        }
        return tokenResponse.getToken();
    }

    public String getUserId() {
        String userId = this.oxylabsProperties.getUserId();
        return userId;
    }

    private TokenResponse createToken() {
        try {
            String username = this.oxylabsProperties.getAccount();
            String password = this.oxylabsProperties.getPassword();
            String authHeader = "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.set("Authorization", authHeader);
            HttpEntity entity = new HttpEntity((MultiValueMap)headers);
            String url = String.format("%s/login", this.oxylabsProperties.getApiHost());
            ResponseEntity responseEntity = this.restTemplate.postForEntity(url, (Object)entity, TokenResponse.class, new Object[0]);
            return (TokenResponse)responseEntity.getBody();
        }
        catch (Exception e) {
            log.info("oxylabs createToken error  ");
            log.info(e.getMessage());
            return null;
        }
    }

    protected HttpHeaders getDefaultHeaders() {
        HttpHeaders headers = new HttpHeaders();
        log.info("header token = " + this.getToken());
        headers.add("Authorization", String.format("Bearer %s", this.getToken()));
        return headers;
    }

    protected HttpHeaders getJSONHeaders() {
        HttpHeaders headers = this.getDefaultHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}

