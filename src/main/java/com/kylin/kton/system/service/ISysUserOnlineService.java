/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.domain.model.LoginUser
 */
package com.kylin.kton.system.service;

import com.kylin.kton.common.core.domain.model.LoginUser;
import com.kylin.kton.system.domain.SysUserOnline;

public interface ISysUserOnlineService {
    public SysUserOnline selectOnlineByIpaddr(String var1, LoginUser var2);

    public SysUserOnline selectOnlineByUserName(String var1, LoginUser var2);

    public SysUserOnline selectOnlineByInfo(String var1, String var2, LoginUser var3);

    public SysUserOnline loginUserToUserOnline(LoginUser var1);
}

