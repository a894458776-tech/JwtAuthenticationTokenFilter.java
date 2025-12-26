package com.kylin.kton.api.dataimpulse.utils;

import com.kylin.kton.common.utils.spring.SpringUtils;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public class TokenCacheUtils {
    private static final String KEY_PREFIX = "kylin:dataimpulse:token";

    public static String getToken() {
        RedisTemplate redisTemplate = SpringUtils.getBean("redisTemplate");
        // 【修复】显式 toString
        Object tokenObj = redisTemplate.opsForValue().get(KEY_PREFIX);
        return tokenObj != null ? tokenObj.toString() : null;
    }

    public static void registry(String token) {
        setToken(token, 3600L);
    }

    public static void setToken(String token, Long expireTime) {
        RedisTemplate redisTemplate = SpringUtils.getBean("redisTemplate");
        redisTemplate.opsForValue().set(KEY_PREFIX, token, expireTime, TimeUnit.SECONDS);
    }
}