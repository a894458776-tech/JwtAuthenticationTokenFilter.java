package com.kylin.kton.api.oxylabs.utils;

import com.kylin.kton.common.utils.spring.SpringUtils;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public class TokenCacheUtils {
    private static final String KEY_PREFIX = "kylin:oxylabs:token";

    public static String getToken() {
        RedisTemplate redisTemplate = SpringUtils.getBean("redisTemplate");
        Object tokenObj = redisTemplate.opsForValue().get(KEY_PREFIX);
        return tokenObj != null ? tokenObj.toString() : null;
    }

    // 【关键修复】增加这个缺失的方法
    public static void registry(String token) {
        setToken(token, 3600L); // 默认 1 小时
    }

    public static void setToken(String token, Long expireTime) {
        RedisTemplate redisTemplate = SpringUtils.getBean("redisTemplate");
        redisTemplate.opsForValue().set(KEY_PREFIX, token, expireTime, TimeUnit.SECONDS);
    }
}