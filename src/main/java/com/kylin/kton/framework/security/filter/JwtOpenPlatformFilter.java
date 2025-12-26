/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.annotation.OpenPlatform
 *  com.kylin.kton.common.constant.Language
 *  com.kylin.kton.common.core.domain.model.LoginUser
 *  com.kylin.kton.common.utils.SecurityUtils
 *  com.kylin.kton.common.utils.StringUtils
 *  javax.servlet.FilterChain
 *  javax.servlet.ServletException
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.security.authentication.UsernamePasswordAuthenticationToken
 *  org.springframework.security.core.Authentication
 *  org.springframework.security.core.context.SecurityContextHolder
 *  org.springframework.stereotype.Component
 *  org.springframework.web.context.WebApplicationContext
 *  org.springframework.web.filter.OncePerRequestFilter
 *  org.springframework.web.method.HandlerMethod
 *  org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
 */
package com.kylin.kton.framework.security.filter;

import com.kylin.kton.common.annotation.OpenPlatform;
import com.kylin.kton.common.constant.Language;
import com.kylin.kton.common.core.domain.model.LoginUser;
import com.kylin.kton.common.utils.SecurityUtils;
import com.kylin.kton.common.utils.StringUtils;
import com.kylin.kton.framework.web.service.OpenPlatformTokenService;
import java.io.IOException;
import java.util.Collections;
import java.util.Objects;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
public class JwtOpenPlatformFilter
extends OncePerRequestFilter {
    @Autowired
    private WebApplicationContext applicationContext;
    @Autowired
    private OpenPlatformTokenService openPlatformTokenService;

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        if (!this.isOpenPlatformApi(request)) {
            chain.doFilter((ServletRequest)request, (ServletResponse)response);
            return;
        }
        LoginUser loginUser = this.openPlatformTokenService.getLoginUser(request);
        if (StringUtils.isNotNull((Object)loginUser) && StringUtils.isNull((Object)SecurityUtils.getAuthentication())) {
            loginUser.setLanguage(this.getLanguage(request));
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken((Object)loginUser, null, Collections.emptyList());
            SecurityContextHolder.getContext().setAuthentication((Authentication)authenticationToken);
        }
        chain.doFilter((ServletRequest)request, (ServletResponse)response);
    }

    private boolean isOpenPlatformApi(HttpServletRequest request) {
        try {
            HandlerMethod handlerMethod = (HandlerMethod)Objects.requireNonNull(((RequestMappingHandlerMapping)this.applicationContext.getBean(RequestMappingHandlerMapping.class)).getHandler(request)).getHandler();
            OpenPlatform methodAnnotation = (OpenPlatform)handlerMethod.getMethodAnnotation(OpenPlatform.class);
            if (methodAnnotation != null) {
                return true;
            }
            OpenPlatform classAnnotation = handlerMethod.getBeanType().getAnnotation(OpenPlatform.class);
            return classAnnotation != null;
        }
        catch (Exception e) {
            return false;
        }
    }

    private Language getLanguage(HttpServletRequest request) {
        String language = request.getHeader("x-accept-language");
        if (StringUtils.isNotBlank((CharSequence)language)) {
            return Language.of((String)language);
        }
        language = request.getHeader("Accept-Language");
        if (StringUtils.isNotBlank((CharSequence)language)) {
            return Language.of((String)language);
        }
        return Language.EN_US;
    }
}

