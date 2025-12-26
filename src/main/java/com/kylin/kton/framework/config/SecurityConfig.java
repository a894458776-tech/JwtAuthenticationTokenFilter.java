package com.kylin.kton.framework.config;

import com.kylin.kton.framework.config.properties.PermitAllUrlProperties;
import com.kylin.kton.framework.security.filter.JwtAuthenticationTokenFilter;
import com.kylin.kton.framework.security.filter.JwtOpenPlatformFilter;
import com.kylin.kton.framework.security.handle.AuthenticationEntryPointImpl;
import com.kylin.kton.framework.security.handle.LogoutSuccessHandlerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.filter.CorsFilter;

@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationEntryPointImpl unauthorizedHandler;
    @Autowired
    private LogoutSuccessHandlerImpl logoutSuccessHandler;
    @Autowired
    private JwtAuthenticationTokenFilter authenticationTokenFilter;
    @Autowired
    private JwtOpenPlatformFilter openPlatformJwtFilter;
    @Autowired
    private CorsFilter corsFilter;
    @Autowired
    private PermitAllUrlProperties permitAllUrl;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 核心修复：WebSecurity 忽略掉的路径完全不走过滤器链
     * 注意：这里的路径是相对于 context-path 之后的
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/captchaImage",
                "/login",
                "/register",
                "/favicon.ico",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js"
        );
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                // 1. 基础接口放行
                .antMatchers("/login", "/captchaImage", "/getInfo", "/logout").permitAll()

                // 2. 业务模块放行（匹配你的 ClientMerchantController）
                .antMatchers("/client/merchant/**").permitAll()

                // 3. Swagger 与开发工具放行
                .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/webjars/**", "/*/api-docs", "/druid/**").permitAll()

                .anyRequest().authenticated()
                .and()
                .headers().frameOptions().disable();

        // 登出地址：Spring 会自动拼接 context-path，所以这里写 /logout 即可
        httpSecurity.logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler);

        httpSecurity.addFilterBefore(openPlatformJwtFilter, UsernamePasswordAuthenticationFilter.class);
        httpSecurity.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        httpSecurity.addFilterBefore(corsFilter, JwtAuthenticationTokenFilter.class);
        httpSecurity.addFilterBefore(corsFilter, LogoutFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}