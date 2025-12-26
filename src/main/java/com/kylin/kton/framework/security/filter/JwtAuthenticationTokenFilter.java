/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  org.springframework.security.web.authentication.WebAuthenticationDetailsSource
 *  org.springframework.stereotype.Component
 *  org.springframework.web.filter.OncePerRequestFilter
 */
package com.kylin.kton.framework.security.filter;

import com.kylin.kton.common.constant.Language;
import com.kylin.kton.common.core.domain.model.LoginUser;
import com.kylin.kton.common.utils.SecurityUtils;
import com.kylin.kton.common.utils.StringUtils;
import com.kylin.kton.framework.web.service.TokenService;
import java.io.IOException;
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
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtAuthenticationTokenFilter
extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        LoginUser loginUser = this.tokenService.getLoginUser(request);
        if (StringUtils.isNotNull((Object)loginUser) && StringUtils.isNull((Object)SecurityUtils.getAuthentication())) {
            this.tokenService.verifyToken(loginUser);
            loginUser.setLanguage(this.getLanguage(request));
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken((Object)loginUser, null, loginUser.getAuthorities());
            authenticationToken.setDetails((Object)new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication((Authentication)authenticationToken);
        }
        chain.doFilter((ServletRequest)request, (ServletResponse)response);
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

