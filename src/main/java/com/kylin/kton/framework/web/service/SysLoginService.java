package com.kylin.kton.framework.web.service;

import com.kylin.kton.common.core.domain.entity.SysUser;
import com.kylin.kton.common.core.domain.model.LoginUser;
import com.kylin.kton.common.core.redis.RedisCache;
import com.kylin.kton.common.exception.ServiceException;
import com.kylin.kton.common.exception.user.BlackListException;
import com.kylin.kton.common.exception.user.CaptchaException;
import com.kylin.kton.common.exception.user.CaptchaExpireException;
import com.kylin.kton.common.exception.user.UserNotExistsException;
import com.kylin.kton.common.exception.user.UserPasswordNotMatchException;
import com.kylin.kton.common.utils.DateUtils;
import com.kylin.kton.common.utils.StringUtils;
import com.kylin.kton.common.utils.ip.IpUtils;
import com.kylin.kton.framework.manager.AsyncManager;
import com.kylin.kton.framework.manager.factory.AsyncFactory;
import com.kylin.kton.framework.security.context.AuthenticationContextHolder;
import com.kylin.kton.system.service.ISysConfigService;
import com.kylin.kton.system.service.ISysUserService;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * 登录校验方法 (硬编码修复版)
 */
@Component
public class SysLoginService {
    @Autowired
    private TokenService tokenService;
    @Resource
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysConfigService configService;

    /**
     * 登录验证
     */
    public String login(String username, String password, String code, String uuid) {
        // 验证码校验
        this.validateCaptcha(username, code, uuid);
        // 登录前置校验
        this.loginPreCheck(username, password);

        Authentication authentication = null;
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            AuthenticationContextHolder.setContext(authenticationToken);
            // 该方法会去调用 UserUserDetailsServiceImpl.loadUserByUsername
            authentication = this.authenticationManager.authenticate(authenticationToken);
        }
        catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                // [修复] 硬编码错误提示
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, "Error", "用户不存在/密码错误", new Object[0]));
                throw new UserPasswordNotMatchException();
            }
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, "Error", e.getMessage(), new Object[0]));
            throw new ServiceException(e.getMessage());
        }
        finally {
            AuthenticationContextHolder.clearContext();
        }

        // [修复] 硬编码成功提示
        AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, "Success", "登录成功", new Object[0]));

        LoginUser loginUser = (LoginUser)authentication.getPrincipal();
        this.recordLoginInfo(loginUser.getUserId());

        // 生成token
        return this.tokenService.createToken(loginUser);
    }

    /**
     * 校验验证码
     */
    public void validateCaptcha(String username, String code, String uuid) {
        boolean captchaEnabled = this.configService.selectCaptchaEnabled();
        if (captchaEnabled) {
            String verifyKey = "captcha_codes:" + StringUtils.nvl(uuid, "");
            String captcha = this.redisCache.getCacheObject(verifyKey);

            // 验证码失效
            if (captcha == null) {
                // [修复] 对应 user.jcaptcha.expire
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, "Error", "验证码已失效", new Object[0]));
                throw new CaptchaExpireException();
            }

            this.redisCache.deleteObject(verifyKey);

            // 验证码错误
            if (!code.equalsIgnoreCase(captcha)) {
                // [修复] 对应 user.jcaptcha.error -> 这就是你刚才报错的地方
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, "Error", "验证码错误", new Object[0]));
                throw new CaptchaException();
            }
        }
    }

    /**
     * 登录前置校验
     */
    public void loginPreCheck(String username, String password) {
        // 判空
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            // [修复] 对应 not.null
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, "Error", "账号或密码不能为空", new Object[0]));
            throw new UserNotExistsException();
        }
        // 密码长度
        if (password.length() < 5 || password.length() > 20) {
            // [修复] 对应 user.password.not.match
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, "Error", "用户不存在/密码错误", new Object[0]));
            throw new UserPasswordNotMatchException();
        }
        // 用户名长度
        if (username.length() < 2 || username.length() > 20) {
            // [修复] 对应 user.password.not.match
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, "Error", "用户不存在/密码错误", new Object[0]));
            throw new UserPasswordNotMatchException();
        }

        // 黑名单
        String blackStr = this.configService.selectConfigByKey("sys.login.blackIPList");
        if (IpUtils.isMatchedIp(blackStr, IpUtils.getIpAddr())) {
            // [修复] 对应 login.blocked
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, "Error", "很遗憾，访问IP已被列入系统黑名单", new Object[0]));
            throw new BlackListException();
        }
    }

    /**
     * 记录登录信息
     */
    public void recordLoginInfo(Long userId) {
        SysUser sysUser = new SysUser();
        sysUser.setUserId(userId);
        sysUser.setLoginIp(IpUtils.getIpAddr());
        sysUser.setLoginDate(DateUtils.getNowDate());
        this.userService.updateUserProfile(sysUser);
    }
}