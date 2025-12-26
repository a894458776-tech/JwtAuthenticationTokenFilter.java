package com.kylin.kton.framework.security.handle;

import com.alibaba.fastjson2.JSON;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.domain.model.LoginUser;
// import com.kylin.kton.common.utils.MessageUtils; // [修改] 注释掉，不再查字典
import com.kylin.kton.common.utils.ServletUtils;
import com.kylin.kton.common.utils.StringUtils;
import com.kylin.kton.framework.manager.AsyncManager;
import com.kylin.kton.framework.manager.factory.AsyncFactory;
import com.kylin.kton.framework.web.service.TokenService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * 自定义退出处理类 (硬编码修复版)
 */
@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {
    @Autowired
    private TokenService tokenService;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        LoginUser loginUser = this.tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser)) {
            String userName = loginUser.getUsername();
            // 删除用户缓存记录
            this.tokenService.delLoginUser(loginUser.getToken());

            // [修改] 记录退出日志，直接用中文 "退出成功"
            // 原代码：MessageUtils.message("user.logout.success")
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(userName, "Logout", "退出成功", new Object[0]));
        }

        // [修改] 返回前端响应，直接用中文 "退出成功"
        // 原代码：MessageUtils.message("user.logout.success")
        ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.success("退出成功")));
    }
}