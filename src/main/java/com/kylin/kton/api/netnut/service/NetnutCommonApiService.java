/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.utils.StringUtils
 *  javax.annotation.PostConstruct
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.http.HttpHeaders
 *  org.springframework.http.MediaType
 *  org.springframework.http.ResponseEntity
 *  org.springframework.stereotype.Service
 *  org.springframework.web.client.RestTemplate
 */
package com.kylin.kton.api.netnut.service;

import com.kylin.kton.api.netnut.entity.subuser.TokenRequest;
import com.kylin.kton.api.netnut.entity.subuser.TokenResponse;
import com.kylin.kton.api.netnut.properties.NetnutProperties;
import com.kylin.kton.api.netnut.utils.TokenCacheUtils;
import com.kylin.kton.common.utils.StringUtils;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.PostConstruct;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NetnutCommonApiService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(NetnutCommonApiService.class);
    private final RestTemplate restTemplate;
    private final NetnutProperties netnutProperties;
    private Lock lock = new ReentrantLock();

    public NetnutCommonApiService(RestTemplate restTemplate, NetnutProperties dataimpulseProperties) {
        this.restTemplate = restTemplate;
        this.netnutProperties = dataimpulseProperties;
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
        log.info("init netnut token...");
        TokenResponse tokenResponse = this.createToken();
        if (Objects.nonNull(tokenResponse) && StringUtils.isNotBlank((CharSequence)tokenResponse.getToken())) {
            TokenCacheUtils.registry(tokenResponse.getToken());
        }
        return TokenCacheUtils.getToken();
    }

    private TokenResponse createToken() {
        TokenRequest tokenRequest = TokenRequest.builder().email(this.netnutProperties.getAccount()).password(this.netnutProperties.getPassword()).build();
        String url = String.format("%s/auth/login", this.netnutProperties.getApiHost());
        ResponseEntity responseEntity = this.restTemplate.postForEntity(url, (Object)tokenRequest, TokenResponse.class, new Object[0]);
        return (TokenResponse)responseEntity.getBody();
    }

    protected HttpHeaders getDefaultHeaders() {
        HttpHeaders headers = new HttpHeaders();
        log.info("netnut toten = " + this.getToken());
        headers.add("Authorization", String.format("%s", this.getToken()));
        return headers;
    }

    protected HttpHeaders getJSONHeaders() {
        HttpHeaders headers = this.getDefaultHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}

