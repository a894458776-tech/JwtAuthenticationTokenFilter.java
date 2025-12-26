/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.domain.entity.SysUser
 *  com.kylin.kton.common.core.domain.model.RegisterBody
 *  com.kylin.kton.common.core.redis.RedisCache
 *  com.kylin.kton.common.exception.user.CaptchaException
 *  com.kylin.kton.common.exception.user.CaptchaExpireException
 *  com.kylin.kton.common.utils.MessageUtils
 *  com.kylin.kton.common.utils.SecurityUtils
 *  com.kylin.kton.common.utils.StringUtils
 *  com.kylin.kton.common.utils.WeChatWebhookUtil
 *  com.kylin.kton.system.service.ISysConfigService
 *  com.kylin.kton.system.service.ISysUserService
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Component
 */
package com.kylin.kton.framework.web.service;

import com.kylin.kton.common.core.domain.entity.SysUser;
import com.kylin.kton.common.core.domain.model.RegisterBody;
import com.kylin.kton.common.core.redis.RedisCache;
import com.kylin.kton.common.exception.user.CaptchaException;
import com.kylin.kton.common.exception.user.CaptchaExpireException;
import com.kylin.kton.common.utils.MessageUtils;
import com.kylin.kton.common.utils.SecurityUtils;
import com.kylin.kton.common.utils.StringUtils;
import com.kylin.kton.common.utils.WeChatWebhookUtil;
import com.kylin.kton.framework.manager.AsyncManager;
import com.kylin.kton.framework.manager.factory.AsyncFactory;
import com.kylin.kton.system.service.ISysConfigService;
import com.kylin.kton.system.service.ISysUserService;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SysRegisterService {
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysConfigService configService;
    @Autowired
    private RedisCache redisCache;

    public String register(RegisterBody registerBody) {
        String msg = "";
        String username = registerBody.getUsername();
        String password = registerBody.getPassword();
        SysUser sysUser = new SysUser();
        sysUser.setUserName(username);
        boolean captchaEnabled = this.configService.selectCaptchaEnabled();
        if (captchaEnabled) {
            this.validateCaptcha(username, registerBody.getCode(), registerBody.getUuid());
        }
        if (StringUtils.isEmpty((String)username)) {
            msg = "\u7528\u6237\u540d\u4e0d\u80fd\u4e3a\u7a7a";
        } else if (StringUtils.isEmpty((String)password)) {
            msg = "\u7528\u6237\u5bc6\u7801\u4e0d\u80fd\u4e3a\u7a7a";
        } else if (username.length() < 2 || username.length() > 20) {
            msg = "\u8d26\u6237\u957f\u5ea6\u5fc5\u987b\u57282\u523020\u4e2a\u5b57\u7b26\u4e4b\u95f4";
        } else if (password.length() < 5 || password.length() > 20) {
            msg = "\u5bc6\u7801\u957f\u5ea6\u5fc5\u987b\u57285\u523020\u4e2a\u5b57\u7b26\u4e4b\u95f4";
        } else if (!this.userService.checkUserNameUnique(sysUser)) {
            msg = "\u4fdd\u5b58\u7528\u6237'" + username + "'\u5931\u8d25\uff0c\u6ce8\u518c\u8d26\u53f7\u5df2\u5b58\u5728";
        } else {
            sysUser.setNickName(username);
            sysUser.setPassword(SecurityUtils.encryptPassword((String)password));
            boolean regFlag = this.userService.registerUser(sysUser);
            if (!regFlag) {
                msg = "\u6ce8\u518c\u5931\u8d25,\u8bf7\u8054\u7cfb\u7cfb\u7edf\u7ba1\u7406\u4eba\u5458";
            } else {
                this.sendWeComMessage(sysUser);
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, "Register", MessageUtils.message((String)"user.register.success", (Object[])new Object[0]), new Object[0]));
            }
        }
        return msg;
    }

    private void sendWeComMessage(SysUser sysUser) {
        Date subtime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(subtime);
        String msg = "\u4e1a\u52a1\u4e8b\u4ef6\u901a\u77e5\uff1a\n\u65b0\u7528\u6237\u6ce8\u518c\u6210\u529f\uff1a\n\u8d26\u53f7\uff1a" + sysUser.getUserName() + "\n\u6ce8\u518c\u65f6\u95f4\uff1a" + formattedDate;
        WeChatWebhookUtil.sendMessage((String)msg);
    }

    public void validateCaptcha(String username, String code, String uuid) {
        String verifyKey = "captcha_codes:" + (String)StringUtils.nvl((Object)uuid, (Object)"");
        String captcha = (String)this.redisCache.getCacheObject(verifyKey);
        this.redisCache.deleteObject(verifyKey);
        if (captcha == null) {
            throw new CaptchaExpireException();
        }
        if (!code.equalsIgnoreCase(captcha)) {
            throw new CaptchaException();
        }
    }
}

