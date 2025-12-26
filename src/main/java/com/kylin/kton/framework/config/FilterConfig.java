/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.filter.RepeatableFilter
 *  com.kylin.kton.common.filter.XssFilter
 *  com.kylin.kton.common.utils.StringUtils
 *  javax.servlet.DispatcherType
 *  javax.servlet.Filter
 *  org.springframework.beans.factory.annotation.Value
 *  org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
 *  org.springframework.boot.web.servlet.FilterRegistrationBean
 *  org.springframework.context.annotation.Bean
 *  org.springframework.context.annotation.Configuration
 */
package com.kylin.kton.framework.config;

import com.kylin.kton.common.filter.RepeatableFilter;
import com.kylin.kton.common.filter.XssFilter;
import com.kylin.kton.common.utils.StringUtils;
import java.util.HashMap;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Value(value="${xss.excludes}")
    private String excludes;
    @Value(value="${xss.urlPatterns}")
    private String urlPatterns;

    @Bean
    @ConditionalOnProperty(value={"xss.enabled"}, havingValue="true")
    public FilterRegistrationBean xssFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST, new DispatcherType[0]);
        registration.setFilter((Filter)new XssFilter());
        registration.addUrlPatterns(StringUtils.split((String)this.urlPatterns, (String)","));
        registration.setName("xssFilter");
        registration.setOrder(Integer.MIN_VALUE);
        HashMap<String, String> initParameters = new HashMap<String, String>();
        initParameters.put("excludes", this.excludes);
        registration.setInitParameters(initParameters);
        return registration;
    }

    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter((Filter)new RepeatableFilter());
        registration.addUrlPatterns(new String[]{"/*"});
        registration.setName("repeatableFilter");
        registration.setOrder(Integer.MAX_VALUE);
        return registration;
    }
}

