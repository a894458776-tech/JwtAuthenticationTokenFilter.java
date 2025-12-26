/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.domain.entity.SysUser
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.admin.user.service.impl;

import com.kylin.kton.admin.user.mapper.AdminSysUserDao;
import com.kylin.kton.admin.user.service.AdminSysUserService;
import com.kylin.kton.common.core.domain.entity.SysUser;
import java.util.List;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminSysUserServiceImpl
implements AdminSysUserService {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(AdminSysUserServiceImpl.class);
    @Autowired
    AdminSysUserDao adminSysUserDao;

    @Override
    public List<SysUser> withOutMerchantList(SysUser sysUser) {
        return this.adminSysUserDao.withOutMerchantList(sysUser);
    }

    @Override
    public List<SysUser> withOutSourceList(SysUser sysUser) {
        return this.adminSysUserDao.withOutSourceList(sysUser);
    }
}

