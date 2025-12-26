package com.kylin.kton.framework.config.properties;

import com.kylin.kton.common.annotation.Anonymous;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

@Configuration
public class PermitAllUrlProperties implements InitializingBean, ApplicationContextAware {
    private static final Pattern PATTERN = Pattern.compile("\\{(.*?)\\}");
    private ApplicationContext applicationContext;
    private List<String> urls = new ArrayList<>();
    public String ASTERISK = "*";

    @Override
    public void afterPropertiesSet() {
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        Map map = mapping.getHandlerMethods(); // 反编译丢失了泛型，这里用原生 Map

        map.keySet().forEach(key -> {
            // 【关键修复】显式强转
            RequestMappingInfo info = (RequestMappingInfo) key;
            HandlerMethod handlerMethod = (HandlerMethod) map.get(info);

            // 获取方法上边的注解 替代path variable 为 *
            Anonymous method = AnnotationUtils.findAnnotation(handlerMethod.getMethod(), Anonymous.class);
            Optional.ofNullable(method).ifPresent(anonymous -> {
                if (info.getPatternsCondition() != null) {
                    info.getPatternsCondition().getPatterns().forEach(url -> urls.add(RegEx(url)));
                }
            });

            // 获取类上边的注解, 替代path variable 为 *
            Anonymous controller = AnnotationUtils.findAnnotation(handlerMethod.getBeanType(), Anonymous.class);
            Optional.ofNullable(controller).ifPresent(anonymous -> {
                if (info.getPatternsCondition() != null) {
                    info.getPatternsCondition().getPatterns().forEach(url -> urls.add(RegEx(url)));
                }
            });
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.applicationContext = context;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    private String RegEx(String url) {
        return PATTERN.matcher(url).replaceAll(ASTERISK);
    }
}