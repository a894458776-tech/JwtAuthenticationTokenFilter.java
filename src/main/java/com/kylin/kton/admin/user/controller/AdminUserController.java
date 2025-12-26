/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.entity.SysUser
 *  com.kylin.kton.common.core.page.TableDataInfo
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.admin.user.controller;

import com.kylin.kton.admin.user.service.AdminSysUserService;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.entity.SysUser;
import com.kylin.kton.common.core.page.TableDataInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/admin/user"})
public class AdminUserController
extends BaseController {
    @Autowired
    private AdminSysUserService userService;

    @GetMapping(value={"/withOutMerchantList"})
    public TableDataInfo withOutMerchantList(SysUser user) {
        this.startPage();
        List<SysUser> list = this.userService.withOutMerchantList(user);
        return this.getDataTable(list);
    }

    @GetMapping(value={"/withOutSourceList"})
    public TableDataInfo withOutSourceList(SysUser user) {
        this.startPage();
        List<SysUser> list = this.userService.withOutSourceList(user);
        return this.getDataTable(list);
    }
}

