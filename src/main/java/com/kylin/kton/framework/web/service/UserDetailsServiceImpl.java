/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.domain.entity.SysUser
 *  com.kylin.kton.common.core.domain.model.LoginUser
 *  com.kylin.kton.common.enums.UserStatus
 *  com.kylin.kton.common.exception.ServiceException
 *  com.kylin.kton.common.utils.MessageUtils
 *  com.kylin.kton.common.utils.StringUtils
 *  com.kylin.kton.system.service.ISysUserService
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.security.core.userdetails.UserDetails
 *  org.springframework.security.core.userdetails.UserDetailsService
 *  org.springframework.security.core.userdetails.UsernameNotFoundException
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.framework.web.service;

import com.kylin.kton.common.core.domain.entity.SysUser;
import com.kylin.kton.common.core.domain.model.LoginUser;
import com.kylin.kton.common.enums.UserStatus;
import com.kylin.kton.common.exception.ServiceException;
import com.kylin.kton.common.utils.MessageUtils;
import com.kylin.kton.common.utils.StringUtils;
import com.kylin.kton.framework.web.service.SysPasswordService;
import com.kylin.kton.framework.web.service.SysPermissionService;
import com.kylin.kton.system.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl
implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    @Autowired
    private ISysUserService userService;
    @Autowired
    private SysPasswordService passwordService;
    @Autowired
    private SysPermissionService permissionService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = this.userService.selectUserByUserName(username);
        if (StringUtils.isNull((Object)user)) {
            log.info("\u767b\u5f55\u7528\u6237\uff1a{} \u4e0d\u5b58\u5728.", (Object)username);
            throw new ServiceException(MessageUtils.message((String)"user.not.exists", (Object[])new Object[0]));
        }
        if (UserStatus.DELETED.getCode().equals(user.getDelFlag())) {
            log.info("\u767b\u5f55\u7528\u6237\uff1a{} \u5df2\u88ab\u5220\u9664.", (Object)username);
            throw new ServiceException(MessageUtils.message((String)"user.password.delete", (Object[])new Object[0]));
        }
        if (UserStatus.DISABLE.getCode().equals(user.getStatus())) {
            log.info("\u767b\u5f55\u7528\u6237\uff1a{} \u5df2\u88ab\u505c\u7528.", (Object)username);
            throw new ServiceException(MessageUtils.message((String)"user.blocked", (Object[])new Object[0]));
        }
        this.passwordService.validate(user);
        return this.createLoginUser(user);
    }

    public UserDetails createLoginUser(SysUser user) {
        return new LoginUser(user.getUserId(), user.getDeptId(), user, this.permissionService.getMenuPermission(user));
    }
}

