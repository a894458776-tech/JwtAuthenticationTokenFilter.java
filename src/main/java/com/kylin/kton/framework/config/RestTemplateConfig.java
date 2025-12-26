/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.http.client.HttpClient
 *  org.apache.http.conn.socket.LayeredConnectionSocketFactory
 *  org.apache.http.conn.ssl.SSLConnectionSocketFactory
 *  org.apache.http.conn.ssl.TrustStrategy
 *  org.apache.http.impl.client.CloseableHttpClient
 *  org.apache.http.impl.client.HttpClients
 *  org.apache.http.ssl.SSLContexts
 *  org.apache.http.ssl.TrustStrategy
 *  org.springframework.context.annotation.Bean
 *  org.springframework.context.annotation.Configuration
 *  org.springframework.http.client.ClientHttpRequestFactory
 *  org.springframework.http.client.HttpComponentsClientHttpRequestFactory
 *  org.springframework.web.client.RestTemplate
 */
package com.kylin.kton.framework.config;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        org.apache.http.conn.ssl.TrustStrategy acceptingTrustStrategy = (chain, authType) -> true;
        HostnameVerifier allowAllHosts = (hostname, session) -> true;
        SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, (TrustStrategy)acceptingTrustStrategy).build();
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext, allowAllHosts);
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory((LayeredConnectionSocketFactory)csf).build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient((HttpClient)httpClient);
        requestFactory.setReadTimeout(30000);
        requestFactory.setConnectTimeout(30000);
        requestFactory.setBufferRequestBody(true);
        return new RestTemplate((ClientHttpRequestFactory)requestFactory);
    }
}

