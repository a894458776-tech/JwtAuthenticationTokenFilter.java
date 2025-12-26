/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.core.JsonProcessingException
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.kylin.kton.common.exception.CustomServiceException
 *  com.kylin.kton.system.domain.KtonMerchantConfig
 *  javax.annotation.Resource
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.http.ResponseEntity
 *  org.springframework.stereotype.Service
 *  org.springframework.web.client.RestTemplate
 *  org.springframework.web.util.UriComponentsBuilder
 */
package com.kylin.kton.client.risk.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kylin.kton.client.merchant.base.mapper.MerchantConfigDao;
import com.kylin.kton.client.risk.entity.dto.RiskApiResponse;
import com.kylin.kton.client.risk.service.RiskService;
import com.kylin.kton.common.exception.CustomServiceException;
import com.kylin.kton.system.domain.KtonMerchantConfig;
import javax.annotation.Resource;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class RiskServiceImpl
implements RiskService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(RiskServiceImpl.class);
    @Resource
    private RestTemplate restTemplate;
    @Resource
    MerchantConfigDao merchantConfigDao;

    @Override
    public Boolean checkRisk(KtonMerchantConfig config, String ip) {
        if (config == null || ip == null || ip.isEmpty()) {
            log.info("\u53c2\u6570\u6821\u9a8c\u5931\u8d25\uff0cconfig={}, ip={}", (Object)config, (Object)ip);
            throw new CustomServiceException("Invalid config or IP address");
        }
        String url = UriComponentsBuilder.fromHttpUrl((String)config.getRiskDetectionBaseUrl()).queryParam("ip", new Object[]{ip}).build().encode().toUriString();
        log.info("====================");
        log.info("\u98ce\u63a7\u63a5\u53e3\u8bf7\u6c42URL: {}", (Object)url);
        log.info("====================");
        try {
            RiskApiResponse body;
            ResponseEntity rawResponse = this.restTemplate.getForEntity(url, String.class, new Object[0]);
            log.info("\u98ce\u63a7\u63a5\u53e3\u539f\u59cb\u54cd\u5e94\u6570\u636e: {}", rawResponse.getBody());
            if (!rawResponse.getStatusCode().is2xxSuccessful()) {
                log.error("\u98ce\u63a7\u63a5\u53e3\u8bf7\u6c42\u5931\u8d25\uff0c\u72b6\u6001\u7801\uff1a{}", (Object)rawResponse.getStatusCodeValue());
                return false;
            }
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                body = (RiskApiResponse)objectMapper.readValue((String)rawResponse.getBody(), RiskApiResponse.class);
                log.info("====================");
                log.info("\u98ce\u63a7\u4e1a\u52a1\u54cd\u5e94\u6570\u636e: {}", (Object)body);
                log.info("====================");
            }
            catch (JsonProcessingException e) {
                log.error("\u89e3\u6790\u98ce\u63a7\u54cd\u5e94JSON\u5931\u8d25: {}", (Object)e.getMessage());
                return false;
            }
            if (!"20000".equals(body.getCode())) {
                log.error("\u98ce\u63a7\u4e1a\u52a1\u5f02\u5e38\uff0ccode={}, message={}", (Object)body.getCode(), (Object)body.getMessage());
                return false;
            }
            return body.getData() != null && body.getData().getFraudScore() != null && body.getData().getFraudScore() == 0;
        }
        catch (Exception e) {
            log.error("\u8c03\u7528\u98ce\u63a7\u63a5\u53e3\u5f02\u5e38\uff1a{}", (Object)e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean checkIpRisk(String ip) {
        Long merchantId = 1L;
        KtonMerchantConfig config = this.merchantConfigDao.merchantConfigInfo(merchantId);
        return this.checkRisk(config, ip);
    }
}

