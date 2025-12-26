/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package com.kylin.kton.common.utils;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeChatWebhookUtil {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(WeChatWebhookUtil.class);
    private static final String WEBHOOK_KEY = "375e1883-8825-450e-bcfb-309de54ea6eb";
    private static final String WEBHOOK_URL = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=375e1883-8825-450e-bcfb-309de54ea6eb";

    public static void sendWebhookMessage(String content) throws Exception {
        String requestJson = String.format("{\"msgtype\": \"text\", \"text\": {\"content\": \"%s\"}}", content);
        URL url = new URL(WEBHOOK_URL);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);
        try (OutputStream os = connection.getOutputStream();){
            byte[] input = requestJson.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code : " + responseCode);
        if (responseCode == 200) {
            log.info("Webhook message sent successfully!");
        } else {
            log.info("Failed to send webhook message.");
        }
    }

    public static void sendMessage(String message) {
        try {
            WeChatWebhookUtil.sendWebhookMessage(message);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            WeChatWebhookUtil.sendWebhookMessage("\u6d4b\u8bd5\u6ce8\u518c\u6d88\u606f");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

