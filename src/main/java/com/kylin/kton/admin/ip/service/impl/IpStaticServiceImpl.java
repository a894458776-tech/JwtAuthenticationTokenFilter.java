/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticSource
 *  com.kylin.kton.system.service.impl.KtonIpStaticServiceImpl
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.admin.ip.service.impl;

import com.kylin.kton.admin.ip.mapper.IpStaticPoolSourceDao;
import com.kylin.kton.admin.ip.service.IpStaticService;
import com.kylin.kton.system.domain.KtonIpStaticSource;
import com.kylin.kton.system.service.impl.KtonIpStaticServiceImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IpStaticServiceImpl
extends KtonIpStaticServiceImpl
implements IpStaticService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(IpStaticServiceImpl.class);
    @Autowired
    IpStaticPoolSourceDao ipStaticPoolSourceDao;
    private static final List<String> COMMON_TEST_URLS = Arrays.asList("https://seller-th.tiktok.com/api/v1/seller/register/check", "https://shopee.ph/api/v4/account/get_partner_login_init?partner=seller", "https://api.ipify.org?format=json", "https://icanhazip.com/s", "https://httpbin.org/ip", "https://ipinfo.io/json", "https://api.ip.sb/jsonip", "https://ifconfig.me/all.json");
    private static final int DEFAULT_S5_PORT = 1080;

    @Override
    public List<String> getCommonTestUrls() {
        return COMMON_TEST_URLS;
    }

    @Override
    public Map<String, Object> testS5UrlAccess(String s5Ip, String testUrl, Integer timeout) throws Exception {
        if (timeout == null) {
            timeout = 100000;
        }
        KtonIpStaticSource source = this.ipStaticPoolSourceDao.getAuthInfoByIp(s5Ip);
        HashMap<String, Object> result = new HashMap<String, Object>();
        if (source == null) {
            throw new Exception("\u672a\u627e\u5230IP: " + s5Ip + " \u5bf9\u5e94\u4f9b\u5e94\u5546Ip\u4fe1\u606f");
        }
        String s5PortStr = source.getPort();
        int s5Port = 1080;
        if (s5PortStr != null && !s5PortStr.trim().isEmpty()) {
            try {
                s5Port = Integer.parseInt(s5PortStr);
            }
            catch (NumberFormatException e) {
                log.warn("\u7aef\u53e3\u683c\u5f0f\u9519\u8bef\uff0c\u4f7f\u7528\u9ed8\u8ba4\u7aef\u53e3 {}: {}", (Object)s5PortStr, (Object)e.getMessage());
            }
        }
        final String username = source.getAccount();
        String password = source.getPassword();
        if (password == null) {
            password = "";
        }
        try {
            URL url = new URL(testUrl);
            log.info("\u6b63\u5728\u8bbf\u95eeURL: {}", (Object)testUrl);
            log.info("s5Ip: {}", (Object)s5Ip);
            log.info("s5Port: {}", (Object)s5Port);
            log.info("s5PortStr: {}", (Object)s5PortStr);
            log.info("username: {}", (Object)username);
            log.info("password: {}", (Object)password);
            Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(s5Ip, s5Port));
            if (username != null && !username.isEmpty()) {
                final String finalPassword = password;
                Authenticator.setDefault(new Authenticator(){

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, finalPassword.toCharArray());
                    }
                });
            }
            long startTime = System.currentTimeMillis();
            HttpURLConnection connection = (HttpURLConnection)url.openConnection(proxy);
            connection.setConnectTimeout(timeout);
            connection.setReadTimeout(timeout);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3");
            int responseCode = connection.getResponseCode();
            result.put("responseCode", responseCode);
            result.put("isSuccess", responseCode >= 200 && responseCode < 300);
            StringBuilder responseContent = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));){
                String line;
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
            }
            catch (IOException e) {
                try (BufferedReader errorReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));){
                    String line;
                    while ((line = errorReader.readLine()) != null) {
                        responseContent.append(line);
                    }
                }
            }
            String content = responseContent.toString();
            result.put("contentLength", content.length());
            result.put("contentPreview", content.length() > 1000 ? content.substring(0, 1000) + "..." : content);
            long elapsedTime = System.currentTimeMillis() - startTime;
            result.put("responseTime", elapsedTime);
            HashMap<String, Object> hashMap = result;
            return hashMap;
        }
        catch (MalformedURLException e) {
            log.error("URL\u683c\u5f0f\u9519\u8bef: {}", (Object)testUrl, (Object)e);
            throw new Exception("URL\u683c\u5f0f\u9519\u8bef: " + e.getMessage(), e);
        }
        catch (SocketTimeoutException e) {
            log.error("\u8fde\u63a5\u8d85\u65f6\uff0cS5\u4ee3\u7406: {}:{}\uff0cURL: {}", new Object[]{s5Ip, s5Port, testUrl, e});
            throw new Exception("\u8fde\u63a5\u8d85\u65f6\uff0c\u8d85\u65f6\u65f6\u95f4: " + timeout + "\u6beb\u79d2", e);
        }
        catch (ConnectException e) {
            log.error("\u65e0\u6cd5\u8fde\u63a5\u5230S5\u4ee3\u7406: {}:{}\uff0c\u8ba4\u8bc1\u4fe1\u606f: {}", new Object[]{s5Ip, s5Port, source, e});
            throw new Exception("\u65e0\u6cd5\u8fde\u63a5\u5230S5\u4ee3\u7406\uff0c\u8bf7\u68c0\u67e5\u4ee3\u7406\u5730\u5740\u3001\u7aef\u53e3\u548c\u8ba4\u8bc1\u4fe1\u606f", e);
        }
        catch (IOException e) {
            log.error("\u8bbf\u95eeURL\u65f6\u53d1\u751fIO\u5f02\u5e38\uff0cS5\u4ee3\u7406: {}:{}\uff0cURL: {}", new Object[]{s5Ip, s5Port, testUrl, e});
            throw new Exception("\u8bbf\u95eeURL\u65f6\u53d1\u751f\u5f02\u5e38: " + e.getMessage(), e);
        }
        finally {
            Authenticator.setDefault(null);
        }
    }
}

