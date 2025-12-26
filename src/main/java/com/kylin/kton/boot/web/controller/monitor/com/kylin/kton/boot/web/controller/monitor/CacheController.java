package com.kylin.kton.boot.web.controller.monitor.com.kylin.kton.boot.web.controller.monitor;

import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.utils.StringUtils;
import com.kylin.kton.system.domain.SysCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/monitor/cache")
public class CacheController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final List<SysCache> caches = new ArrayList<>();

    static {
        caches.add(new SysCache("login_tokens:", "用户信息"));
        caches.add(new SysCache("sys_config:", "配置信息"));
        caches.add(new SysCache("sys_dict:", "数据字典"));
        caches.add(new SysCache("captcha_codes:", "验证码"));
        caches.add(new SysCache("repeat_submit:", "防重提交"));
        caches.add(new SysCache("rate_limit:", "限流处理"));
        caches.add(new SysCache("pwd_err_cnt:", "密码错误次数"));
    }

    @PreAuthorize("@ss.hasPermi('monitor:cache:list')")
    @GetMapping
    public AjaxResult getInfo() throws Exception {
        // 关键修复：显式转换 Lambda 为 RedisCallback 接口
        Properties info = redisTemplate.execute((RedisCallback<Properties>) RedisConnection::info);
        Properties commandStats = redisTemplate.execute((RedisCallback<Properties>) connection -> connection.info("commandstats"));
        Object dbSize = redisTemplate.execute((RedisCallback<Object>) RedisConnection::dbSize);

        Map<String, Object> result = new HashMap<>(3);
        result.put("info", info);
        result.put("dbSize", dbSize);

        List<Map<String, String>> pieList = new ArrayList<>();
        if (commandStats != null) {
            commandStats.stringPropertyNames().forEach(key -> {
                Map<String, String> data = new HashMap<>(2);
                String property = commandStats.getProperty(key);
                data.put("name", StringUtils.removeStart(key, "cmdstat_"));
                data.put("value", StringUtils.substringBetween(property, "calls=", ",usec"));
                pieList.add(data);
            });
        }
        result.put("commandStats", pieList);
        return AjaxResult.success(result);
    }

    @PreAuthorize("@ss.hasPermi('monitor:cache:list')")
    @GetMapping("/getNames")
    public AjaxResult cache() {
        return AjaxResult.success(caches);
    }

    @PreAuthorize("@ss.hasPermi('monitor:cache:list')")
    @GetMapping("/getKeys/{cacheName}")
    public AjaxResult getCacheKeys(@PathVariable String cacheName) {
        Set<String> cacheKeys = redisTemplate.keys(cacheName + "*");
        return AjaxResult.success(cacheKeys);
    }

    @PreAuthorize("@ss.hasPermi('monitor:cache:list')")
    @GetMapping("/getValue/{cacheName}/{cacheKey}")
    public AjaxResult getCacheValue(@PathVariable String cacheName, @PathVariable String cacheKey) {
        String cacheValue = redisTemplate.opsForValue().get(cacheKey);
        SysCache sysCache = new SysCache(cacheName, cacheKey, cacheValue);
        return AjaxResult.success(sysCache);
    }

    @PreAuthorize("@ss.hasPermi('monitor:cache:list')")
    @DeleteMapping("/clearCacheName/{cacheName}")
    public AjaxResult clearCacheName(@PathVariable String cacheName) {
        Set<String> cacheKeys = redisTemplate.keys(cacheName + "*");
        if (cacheKeys != null && !cacheKeys.isEmpty()) {
            redisTemplate.delete(cacheKeys);
        }
        return AjaxResult.success();
    }

    @PreAuthorize("@ss.hasPermi('monitor:cache:list')")
    @DeleteMapping("/clearCacheKey/{cacheKey}")
    public AjaxResult clearCacheKey(@PathVariable String cacheKey) {
        redisTemplate.delete(cacheKey);
        return AjaxResult.success();
    }

    @PreAuthorize("@ss.hasPermi('monitor:cache:list')")
    @DeleteMapping("/clearCacheAll")
    public AjaxResult clearCacheAll() {
        Set<String> cacheKeys = redisTemplate.keys("*");
        if (cacheKeys != null && !cacheKeys.isEmpty()) {
            redisTemplate.delete(cacheKeys);
        }
        return AjaxResult.success();
    }
}