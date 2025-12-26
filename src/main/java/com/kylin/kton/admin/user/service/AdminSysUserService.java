/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.domain.entity.SysUser
 */
package com.kylin.kton.admin.user.service;

import com.kylin.kton.common.core.domain.entity.SysUser;
import java.util.List;

public interface AdminSysUserService {
    public List<SysUser> withOutMerchantList(SysUser var1);

    public List<SysUser> withOutSourceList(SysUser var1);
}

