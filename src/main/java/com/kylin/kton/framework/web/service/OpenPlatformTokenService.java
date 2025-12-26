/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.domain.entity.SysUser
 *  com.kylin.kton.common.core.domain.model.LoginUser
 *  com.kylin.kton.common.core.redis.RedisCache
 *  com.kylin.kton.common.utils.StringUtils
 *  com.kylin.kton.system.domain.KtonApiConfig
 *  com.kylin.kton.system.service.IKtonApiConfigService
 *  com.kylin.kton.system.service.ISysUserService
 *  javax.servlet.http.HttpServletRequest
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Component
 */
package com.kylin.kton.framework.web.service;

import com.kylin.kton.common.core.domain.entity.SysUser;
import com.kylin.kton.common.core.domain.model.LoginUser;
import com.kylin.kton.common.core.redis.RedisCache;
import com.kylin.kton.common.utils.StringUtils;
import com.kylin.kton.framework.web.service.UserDetailsServiceImpl;
import com.kylin.kton.system.domain.KtonApiConfig;
import com.kylin.kton.system.service.IKtonApiConfigService;
import com.kylin.kton.system.service.ISysUserService;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OpenPlatformTokenService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(OpenPlatformTokenService.class);
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private IKtonApiConfigService apiConfigService;

    public LoginUser getLoginUser(HttpServletRequest request) {
        LoginUser loginUser;
        String token = request.getHeader("x-merchant-token");
        String code = request.getHeader("x-merchant-code");
        if (StringUtils.isEmpty((String)token) || StringUtils.isEmpty((String)code)) {
            return null;
        }
        String userKey = this.getTokenKey(code);
        try {
            loginUser = (LoginUser)this.redisCache.getCacheObject(userKey);
            if (StringUtils.isNotNull((Object)loginUser)) {
                return loginUser;
            }
        }
        catch (Exception e) {
            log.error("\u83b7\u53d6\u7528\u6237\u4fe1\u606f\u5f02\u5e38'{}'", (Object)e.getMessage());
        }
        loginUser = this.getUserByApiConfig(token, code);
        if (loginUser != null) {
            this.redisCache.setCacheObject(userKey, (Object)loginUser, Integer.valueOf(60), TimeUnit.MINUTES);
        }
        return loginUser;
    }

    private LoginUser getUserByApiConfig(String token, String code) {
        KtonApiConfig ktonApiConfig = new KtonApiConfig();
        ktonApiConfig.setMerchantCode(code);
        ktonApiConfig.setMerchantToken(token);
        List apiConfigList = this.apiConfigService.selectKtonApiConfigList(ktonApiConfig);
        if (apiConfigList != null && !apiConfigList.isEmpty()) {
            Long userId = ((KtonApiConfig)apiConfigList.get(0)).getUserId();
            SysUser user = this.userService.selectUserById(userId);
            return (LoginUser)this.userDetailsService.createLoginUser(user);
        }
        return null;
    }

    private String getTokenKey(String code) {
        return "open_platform_login_tokens:" + code;
    }
}

