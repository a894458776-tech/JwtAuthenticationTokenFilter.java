/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.alibaba.fastjson2.JSON
 *  com.kylin.kton.common.annotation.RepeatSubmit
 *  com.kylin.kton.common.core.redis.RedisCache
 *  com.kylin.kton.common.filter.RepeatedlyRequestWrapper
 *  com.kylin.kton.common.utils.StringUtils
 *  com.kylin.kton.common.utils.http.HttpHelper
 *  javax.servlet.ServletRequest
 *  javax.servlet.http.HttpServletRequest
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.beans.factory.annotation.Value
 *  org.springframework.stereotype.Component
 */
package com.kylin.kton.framework.interceptor.impl;

import com.alibaba.fastjson2.JSON;
import com.kylin.kton.common.annotation.RepeatSubmit;
import com.kylin.kton.common.core.redis.RedisCache;
import com.kylin.kton.common.filter.RepeatedlyRequestWrapper;
import com.kylin.kton.common.utils.StringUtils;
import com.kylin.kton.common.utils.http.HttpHelper;
import com.kylin.kton.framework.interceptor.RepeatSubmitInterceptor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SameUrlDataInterceptor
extends RepeatSubmitInterceptor {
    public final String REPEAT_PARAMS = "repeatParams";
    public final String REPEAT_TIME = "repeatTime";
    @Value(value="${token.header}")
    private String header;
    @Autowired
    private RedisCache redisCache;

    @Override
    public boolean isRepeatSubmit(HttpServletRequest request, RepeatSubmit annotation) {
        Map preDataMap;
        Map sessionMap;
        String nowParams = "";
        if (request instanceof RepeatedlyRequestWrapper) {
            RepeatedlyRequestWrapper repeatedlyRequest = (RepeatedlyRequestWrapper)request;
            nowParams = HttpHelper.getBodyString((ServletRequest)repeatedlyRequest);
        }
        if (StringUtils.isEmpty((String)nowParams)) {
            nowParams = JSON.toJSONString((Object)request.getParameterMap());
        }
        HashMap<String, Object> nowDataMap = new HashMap<String, Object>();
        nowDataMap.put("repeatParams", nowParams);
        nowDataMap.put("repeatTime", System.currentTimeMillis());
        String url = request.getRequestURI();
        String submitKey = StringUtils.trimToEmpty((String)request.getHeader(this.header));
        String cacheRepeatKey = "repeat_submit:" + url + submitKey;
        Object sessionObj = this.redisCache.getCacheObject(cacheRepeatKey);
        if (sessionObj != null && (sessionMap = (Map)sessionObj).containsKey(url) && this.compareParams(nowDataMap, preDataMap = (Map)sessionMap.get(url)) && this.compareTime(nowDataMap, preDataMap, annotation.interval())) {
            return true;
        }
        HashMap<String, HashMap<String, Object>> cacheMap = new HashMap<String, HashMap<String, Object>>();
        cacheMap.put(url, nowDataMap);
        this.redisCache.setCacheObject(cacheRepeatKey, cacheMap, Integer.valueOf(annotation.interval()), TimeUnit.MILLISECONDS);
        return false;
    }

    private boolean compareParams(Map<String, Object> nowMap, Map<String, Object> preMap) {
        String nowParams = (String)nowMap.get("repeatParams");
        String preParams = (String)preMap.get("repeatParams");
        return nowParams.equals(preParams);
    }

    private boolean compareTime(Map<String, Object> nowMap, Map<String, Object> preMap, int interval) {
        long time2;
        long time1 = (Long)nowMap.get("repeatTime");
        return time1 - (time2 = ((Long)preMap.get("repeatTime")).longValue()) < (long)interval;
    }
}

