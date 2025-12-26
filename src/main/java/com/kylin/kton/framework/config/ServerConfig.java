/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.utils.ServletUtils
 *  javax.servlet.http.HttpServletRequest
 *  org.springframework.stereotype.Component
 */
package com.kylin.kton.framework.config;

import com.kylin.kton.common.utils.ServletUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class ServerConfig {
    public String getUrl() {
        HttpServletRequest request = ServletUtils.getRequest();
        return ServerConfig.getDomain(request);
    }

    public static String getDomain(HttpServletRequest request) {
        StringBuffer url = request.getRequestURL();
        String contextPath = request.getServletContext().getContextPath();
        return url.delete(url.length() - request.getRequestURI().length(), url.length()).append(contextPath).toString();
    }
}

