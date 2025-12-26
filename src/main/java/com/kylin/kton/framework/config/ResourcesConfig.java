/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.config.RuoYiConfig
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.context.annotation.Bean
 *  org.springframework.context.annotation.Configuration
 *  org.springframework.http.CacheControl
 *  org.springframework.web.cors.CorsConfiguration
 *  org.springframework.web.cors.CorsConfigurationSource
 *  org.springframework.web.cors.UrlBasedCorsConfigurationSource
 *  org.springframework.web.filter.CorsFilter
 *  org.springframework.web.servlet.HandlerInterceptor
 *  org.springframework.web.servlet.config.annotation.InterceptorRegistry
 *  org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
 *  org.springframework.web.servlet.config.annotation.WebMvcConfigurer
 */
package com.kylin.kton.framework.config;

import com.kylin.kton.common.config.RuoYiConfig;
import com.kylin.kton.framework.interceptor.RepeatSubmitInterceptor;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourcesConfig
implements WebMvcConfigurer {
    @Autowired
    private RepeatSubmitInterceptor repeatSubmitInterceptor;

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(new String[]{"/profile/**"}).addResourceLocations(new String[]{"file:" + RuoYiConfig.getProfile() + "/"});
        registry.addResourceHandler(new String[]{"/swagger-ui/**"}).addResourceLocations(new String[]{"classpath:/META-INF/resources/webjars/springfox-swagger-ui/"}).setCacheControl(CacheControl.maxAge((long)5L, (TimeUnit)TimeUnit.HOURS).cachePublic());
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor((HandlerInterceptor)this.repeatSubmitInterceptor).addPathPatterns(new String[]{"/**"});
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(Boolean.valueOf(true));
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setMaxAge(Long.valueOf(1800L));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter((CorsConfigurationSource)source);
    }
}

