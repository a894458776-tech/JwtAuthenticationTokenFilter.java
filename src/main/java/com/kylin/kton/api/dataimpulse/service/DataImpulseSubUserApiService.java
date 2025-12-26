/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.alibaba.fastjson2.JSONException
 *  com.alibaba.fastjson2.JSONObject
 *  com.alibaba.fastjson2.JSONWriter$Feature
 *  com.kylin.kton.common.utils.StringUtils
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.http.HttpEntity
 *  org.springframework.http.HttpHeaders
 *  org.springframework.http.HttpMethod
 *  org.springframework.http.ResponseEntity
 *  org.springframework.stereotype.Service
 *  org.springframework.util.MultiValueMap
 *  org.springframework.web.client.HttpClientErrorException
 *  org.springframework.web.client.HttpServerErrorException
 *  org.springframework.web.client.RestClientException
 *  org.springframework.web.client.RestTemplate
 */
package com.kylin.kton.api.dataimpulse.service;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.kylin.kton.api.dataimpulse.constant.PeriodType;
import com.kylin.kton.api.dataimpulse.constant.Protocols;
import com.kylin.kton.api.dataimpulse.entity.subuser.AddSubUserBalanceRequest;
import com.kylin.kton.api.dataimpulse.entity.subuser.AddSubUserBalanceResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.CreateSubUserRequest;
import com.kylin.kton.api.dataimpulse.entity.subuser.CreateSubUserResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.DeleteSubUserRequest;
import com.kylin.kton.api.dataimpulse.entity.subuser.DeleteSubUserResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.DropSubUserBalanceRequest;
import com.kylin.kton.api.dataimpulse.entity.subuser.DropSubUserBalanceResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.GetSupportedProtocolsResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.ListSubUserResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.MasterBalanceResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.QuerySubUserBalanceResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.QuerySubUserResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.QuerySubUserUsageStatDetailsResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.QuerySubUserUsageStatResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.RemoveAllowedIpRequest;
import com.kylin.kton.api.dataimpulse.entity.subuser.RemoveAllowedIpResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.ResetPwdRequest;
import com.kylin.kton.api.dataimpulse.entity.subuser.ResetPwdResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetAllowedIpRequest;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetAllowedIpResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetBlockedHostRequest;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetBlockedHostResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetBlockedRequest;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetBlockedResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetDefaultParametersRequest;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetDefaultParametersResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetSupportedProtocolsRequest;
import com.kylin.kton.api.dataimpulse.entity.subuser.SetSupportedProtocolsResponse;
import com.kylin.kton.api.dataimpulse.entity.subuser.UpdateSubUserRequest;
import com.kylin.kton.api.dataimpulse.entity.subuser.UpdateSubUserResponse;
import com.kylin.kton.api.dataimpulse.properties.DataimpulseProperties;
import com.kylin.kton.api.dataimpulse.service.DataImpulseCommonApiService;
import com.kylin.kton.common.utils.StringUtils;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class DataImpulseSubUserApiService
extends DataImpulseCommonApiService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(DataImpulseSubUserApiService.class);
    private final RestTemplate restTemplate;
    private final DataimpulseProperties dataimpulseProperties;

    public DataImpulseSubUserApiService(RestTemplate restTemplate, DataimpulseProperties dataimpulseProperties) {
        super(restTemplate, dataimpulseProperties);
        this.restTemplate = restTemplate;
        this.dataimpulseProperties = dataimpulseProperties;
    }

    public MasterBalanceResponse queryMainBalance() {
        String url = String.format("%s/reseller/user/balance", this.dataimpulseProperties.getApiHost());
        HttpHeaders headers = this.getDefaultHeaders();
        HttpEntity entity = new HttpEntity((MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (MasterBalanceResponse)JSONObject.parseObject((String)responseStr, MasterBalanceResponse.class);
    }

    public ListSubUserResponse list() {
        String url = String.format("%s/reseller/sub-user/list", this.dataimpulseProperties.getApiHost());
        HttpHeaders headers = this.getDefaultHeaders();
        HttpEntity entity = new HttpEntity((MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (ListSubUserResponse)JSONObject.parseObject((String)responseStr, ListSubUserResponse.class);
    }

    public CreateSubUserResponse create(CreateSubUserRequest request) {
        String url = String.format("%s/reseller/sub-user/create", this.dataimpulseProperties.getApiHost());
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (CreateSubUserResponse)JSONObject.parseObject((String)responseStr, CreateSubUserResponse.class);
    }

    public UpdateSubUserResponse update(UpdateSubUserRequest request) {
        String url = String.format("%s/reseller/sub-user/update", this.dataimpulseProperties.getApiHost());
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (UpdateSubUserResponse)JSONObject.parseObject((String)responseStr, UpdateSubUserResponse.class);
    }

    public DeleteSubUserResponse delete(Long subUserId) {
        DropSubUserBalanceResponse balanceResponse = this.dropBalance(subUserId);
        if (!balanceResponse.getSuccess().booleanValue()) {
            log.info("drop sub user balance error....");
            DeleteSubUserResponse deleteSubUserResponse = new DeleteSubUserResponse();
            deleteSubUserResponse.setSuccess(false);
            deleteSubUserResponse.setMessage("drop sub user balance error");
            return deleteSubUserResponse;
        }
        String url = String.format("%s/reseller/sub-user/delete", this.dataimpulseProperties.getApiHost());
        HttpHeaders headers = this.getJSONHeaders();
        DeleteSubUserRequest request = DeleteSubUserRequest.builder().subuserId(subUserId).build();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (DeleteSubUserResponse)JSONObject.parseObject((String)responseStr, DeleteSubUserResponse.class);
    }

    public QuerySubUserResponse query(Long subUserId) {
        String url = String.format("%s/reseller/sub-user/get?subuser_id=%s", this.dataimpulseProperties.getApiHost(), subUserId);
        HttpHeaders headers = this.getDefaultHeaders();
        HttpEntity entity = new HttpEntity((MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (QuerySubUserResponse)JSONObject.parseObject((String)responseStr, QuerySubUserResponse.class);
    }

    public QuerySubUserUsageStatResponse queryUsageStat(Long subUserId, PeriodType periodType) {
        HttpHeaders headers;
        HttpEntity entity;
        String url = String.format("%s/reseller/sub-user/usage-stat/get?subuser_id=%s&period=%s", this.dataimpulseProperties.getApiHost(), subUserId, periodType.getCode());
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.GET, entity = new HttpEntity((MultiValueMap)(headers = this.getDefaultHeaders())), String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        if (StringUtils.equals((CharSequence)responseStr, (CharSequence)"[]")) {
            return QuerySubUserUsageStatResponse.builder().build();
        }
        return (QuerySubUserUsageStatResponse)JSONObject.parseObject((String)responseStr, QuerySubUserUsageStatResponse.class);
    }

    public QuerySubUserUsageStatDetailsResponse queryUsageStatDetails(Long subUserId, PeriodType periodType, Integer pageNo, Integer pageSize) {
        String url = String.format("%s/reseller/sub-user/usage-stat/detail?subuser_id=%s&period=%s&limit=%s&offset=%s", this.dataimpulseProperties.getApiHost(), subUserId, periodType.getCode(), pageSize, (pageNo - 1) * pageSize);
        HttpHeaders headers = this.getDefaultHeaders();
        HttpEntity entity = new HttpEntity((MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (QuerySubUserUsageStatDetailsResponse)JSONObject.parseObject((String)responseStr, QuerySubUserUsageStatDetailsResponse.class);
    }

    public QuerySubUserBalanceResponse queryBalance(Long subUserId) {
        if (subUserId <= 0L) {
            log.info("subuser_id is invalid ");
        }
        String url = String.format("%s/reseller/sub-user/balance/get?subuser_id=%s", this.dataimpulseProperties.getApiHost(), subUserId);
        HttpHeaders headers = this.getDefaultHeaders();
        HttpEntity entity = new HttpEntity((MultiValueMap)headers);
        try {
            ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new Object[0]);
            String responseStr = (String)responseEntity.getBody();
            log.info("queryBalance responseStr = {}", (Object)responseStr);
            return (QuerySubUserBalanceResponse)JSONObject.parseObject((String)responseStr, QuerySubUserBalanceResponse.class);
        }
        catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("HTTP error while querying balance for subuser_id {}, status code: {}, response: {}", new Object[]{subUserId, e.getStatusCode(), e.getResponseBodyAsString(), e});
        }
        catch (RestClientException e) {
            log.error("RestClientException while querying balance for subuser_id {}", (Object)subUserId, (Object)e);
        }
        catch (JSONException e) {
            log.error("Failed to parse response for subuser_id {}", (Object)subUserId, (Object)e);
        }
        catch (Exception e) {
            log.error("Unexpected error while querying balance for subuser_id {}", (Object)subUserId, (Object)e);
        }
        return null;
    }

    public AddSubUserBalanceResponse addBalance(Long subUserId, Long traffic) {
        String url = String.format("%s/reseller/sub-user/balance/add", this.dataimpulseProperties.getApiHost());
        HttpHeaders headers = this.getJSONHeaders();
        AddSubUserBalanceRequest request = AddSubUserBalanceRequest.builder().subuserId(subUserId).traffic(traffic).build();
        log.info("add balance request: {}, header = {}", (Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (Object)JSONObject.toJSONString((Object)headers, (JSONWriter.Feature[])new JSONWriter.Feature[0]));
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        log.info("add balance response: {}", (Object)responseStr);
        return (AddSubUserBalanceResponse)JSONObject.parseObject((String)responseStr, AddSubUserBalanceResponse.class);
    }

    public DropSubUserBalanceResponse dropBalance(Long subUserId) {
        String url = String.format("%s/reseller/sub-user/balance/drop", this.dataimpulseProperties.getApiHost());
        HttpHeaders headers = this.getJSONHeaders();
        DropSubUserBalanceRequest request = DropSubUserBalanceRequest.builder().subUserId(subUserId).build();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (DropSubUserBalanceResponse)JSONObject.parseObject((String)responseStr, DropSubUserBalanceResponse.class);
    }

    public ResetPwdResponse resetPassword(Long subUserId) {
        String url = String.format("%s/reseller/sub-user/reset-password", this.dataimpulseProperties.getApiHost());
        HttpHeaders headers = this.getJSONHeaders();
        ResetPwdRequest request = ResetPwdRequest.builder().subUserId(subUserId).build();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (ResetPwdResponse)JSONObject.parseObject((String)responseStr, ResetPwdResponse.class);
    }

    public SetBlockedResponse setBlockedSubUser(Long subUserId, Boolean isBlocked) {
        String url = String.format("%s/reseller/sub-user/set-blocked", this.dataimpulseProperties.getApiHost());
        SetBlockedRequest request = SetBlockedRequest.builder().subUserId(subUserId).blocked(isBlocked).build();
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (SetBlockedResponse)JSONObject.parseObject((String)responseStr, SetBlockedResponse.class);
    }

    public SetBlockedHostResponse setBlockedHosts(Long subUserId, List<String> blockedHosts) {
        String url = String.format("%s/reseller/sub-user/set-blocked-hosts", this.dataimpulseProperties.getApiHost());
        SetBlockedHostRequest request = SetBlockedHostRequest.builder().subUserId(subUserId).blockedHosts(blockedHosts).build();
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (SetBlockedHostResponse)JSONObject.parseObject((String)responseStr, SetBlockedHostResponse.class);
    }

    public SetDefaultParametersResponse setDefaultParameter(SetDefaultParametersRequest request) {
        String url = String.format("%s/reseller/sub-user/set-default-pool-parameters", this.dataimpulseProperties.getApiHost());
        HttpHeaders headers = this.getJSONHeaders();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (SetDefaultParametersResponse)JSONObject.parseObject((String)responseStr, SetDefaultParametersResponse.class);
    }

    public SetAllowedIpResponse setAllowedIp(Long subUserId, String ip) {
        String url = String.format("%s/reseller/sub-user/allowed-ips/add", this.dataimpulseProperties.getApiHost());
        HttpHeaders headers = this.getJSONHeaders();
        SetAllowedIpRequest request = SetAllowedIpRequest.builder().subUserId(subUserId).ip(ip).build();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (SetAllowedIpResponse)JSONObject.parseObject((String)responseStr, SetAllowedIpResponse.class);
    }

    public RemoveAllowedIpResponse removeAllowedIp(Long subUserId, String ip) {
        String url = String.format("%s/reseller/sub-user/allowed-ips/remove", this.dataimpulseProperties.getApiHost());
        HttpHeaders headers = this.getJSONHeaders();
        RemoveAllowedIpRequest request = RemoveAllowedIpRequest.builder().subUserId(subUserId).ip(ip).build();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (RemoveAllowedIpResponse)JSONObject.parseObject((String)responseStr, RemoveAllowedIpResponse.class);
    }

    public GetSupportedProtocolsResponse getSupportedProtocols(Long subUserId) {
        String url = String.format("%s/reseller/sub-user/supported-protocols/get?subuser_id=%s", this.dataimpulseProperties.getApiHost(), subUserId);
        HttpHeaders headers = this.getDefaultHeaders();
        HttpEntity entity = new HttpEntity((MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (GetSupportedProtocolsResponse)JSONObject.parseObject((String)responseStr, GetSupportedProtocolsResponse.class);
    }

    public SetSupportedProtocolsResponse setSupportedProtocols(Long subUserId, List<Protocols> protocols) {
        String url = String.format("%s/reseller/sub-user/supported-protocols/set", this.dataimpulseProperties.getApiHost());
        HttpHeaders headers = this.getJSONHeaders();
        SetSupportedProtocolsRequest request = SetSupportedProtocolsRequest.builder().subUserId(subUserId).supportedProtocols(protocols.stream().map(Protocols::getCode).collect(Collectors.toList())).build();
        HttpEntity entity = new HttpEntity((Object)JSONObject.toJSONString((Object)request, (JSONWriter.Feature[])new JSONWriter.Feature[0]), (MultiValueMap)headers);
        ResponseEntity responseEntity = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class, new Object[0]);
        String responseStr = (String)responseEntity.getBody();
        return (SetSupportedProtocolsResponse)JSONObject.parseObject((String)responseStr, SetSupportedProtocolsResponse.class);
    }
}

