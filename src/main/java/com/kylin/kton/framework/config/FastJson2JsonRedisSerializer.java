/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.alibaba.fastjson2.JSON
 *  com.alibaba.fastjson2.JSONReader
 *  com.alibaba.fastjson2.JSONReader$Feature
 *  com.alibaba.fastjson2.JSONWriter$Feature
 *  com.alibaba.fastjson2.filter.Filter
 *  com.kylin.kton.common.constant.Constants
 *  org.springframework.data.redis.serializer.RedisSerializer
 *  org.springframework.data.redis.serializer.SerializationException
 */
package com.kylin.kton.framework.config;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.filter.Filter;
import com.kylin.kton.common.constant.Constants;
import java.nio.charset.Charset;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class FastJson2JsonRedisSerializer<T>
implements RedisSerializer<T> {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    static final Filter AUTO_TYPE_FILTER = JSONReader.autoTypeFilter((String[])Constants.JSON_WHITELIST_STR);
    private Class<T> clazz;

    public FastJson2JsonRedisSerializer(Class<T> clazz) {
        this.clazz = clazz;
    }

    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }
        return JSON.toJSONString(t, (JSONWriter.Feature[])new JSONWriter.Feature[]{JSONWriter.Feature.WriteClassName}).getBytes(DEFAULT_CHARSET);
    }

    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARSET);
        return (T)JSON.parseObject((String)str, this.clazz, (Filter)AUTO_TYPE_FILTER, (JSONReader.Feature[])new JSONReader.Feature[0]);
    }
}

